/*
 * Powered By zoe
 * Since 2008 - 2016
 */


package com.zoe.phip.service.impl.in.sm;

import com.alibaba.dubbo.config.annotation.Service;
import com.zoe.phip.infrastructure.exception.BusinessException;
import com.zoe.phip.infrastructure.util.StringUtil;
import com.zoe.phip.infrastructure.entity.ServiceResult;
import com.zoe.phip.infrastructure.entity.ServiceResultT;
import com.zoe.phip.model.sm.LoginCredentials;
import com.zoe.phip.model.sm.SystemUser;
import com.zoe.phip.service.impl.in.BaseInServiceImpl;
import com.zoe.phip.infrastructure.util.SafeExecuteUtil;
import com.zoe.phip.service.in.sm.SystemUserService;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author
 * @version 1.0
 * @date 2016-03-18
 */
@Repository("SystemUserService")
@Service
public class SystemUserServiceImpl extends BaseInServiceImpl<SystemUser> implements SystemUserService {


    @Override
    public ServiceResultT<LoginCredentials> login(String loginName, String passWord, int expiresTime) {
        SafeExecuteUtil<LoginCredentials> safeExecute = new SafeExecuteUtil<LoginCredentials>();
        return safeExecute.executeT(() -> {
            List<SystemUser> list = getUserByLoginName(loginName);
            if (list == null || list.size() == 0) {
                throw new BusinessException("用户名错�");
            }
            SystemUser user = list.get(0);
            if (user.getState() == 0) {
                throw new BusinessException("用户不可�");
            }
            String psd = createPassword(user.getLoginName(), passWord);
            if (!psd.equals(user.getPassword())) {
                throw new BusinessException("密码错误!");
            }
            LoginCredentials credentials = createLoginCredentials(user.getId(), user.getName());
            return credentials;
        });
    }

    @Override
    public ServiceResult updatePassword(String id, String oldPwd, String newPwd) {
        return SafeExecuteUtil.execute(() -> {
            SystemUser user = getMapper().selectByPrimaryKey(id);
            if (user == null) {
                throw new BusinessException("未找到该用户!");
            }
            String oldPassword = createPassword(user.getLoginName(), oldPwd);
            if (!user.getPassword().equals(oldPassword)) {
                throw new BusinessException("旧密码错�");
            }
            user.setPassword(createPassword(user.getLoginName(), newPwd));
            user.setModifyAt(new Date());
            return getMapper().updateByPrimaryKeySelective(user);
        });
    }

    @Override
    public ServiceResult resetPassword(String id, String newPwd) {
        return SafeExecuteUtil.execute(() -> {
            SystemUser user = getMapper().selectByPrimaryKey(id);
            if (user == null) {
                throw new BusinessException("未找到该用户!");
            }
            user.setPassword(createPassword(user.getLoginName(), newPwd));
            user.setModifyAt(new Date());
            return getMapper().updateByPrimaryKeySelective(user);
        });
    }

    @Override
    public ServiceResult updateState(String id, int state) {
        return SafeExecuteUtil.execute(() -> {
            SystemUser user = getMapper().selectByPrimaryKey(id);
            if (user == null) {
                throw new BusinessException("未找到该用户!");
            }
            user.setState(state);
            user.setModifyAt(new Date());
            return getMapper().updateByPrimaryKeySelective(user);
        });
    }

    @Override
    public ServiceResult add(SystemUser entity) {
        return SafeExecuteUtil.execute(() -> {
            //判断是否存在用户�
            List<SystemUser> list = getUserByLoginName(entity.getLoginName());
            if (list != null && list.size() > 0) {
                throw new BusinessException("已存在登录名�{0})的用�", entity.getLoginName());
            }
            String password = createPassword(entity.getLoginName(), entity.getPassword());
            entity.setPassword(password);
            return getMapper().insertSelective(entity);
        });

    }

    @Override
    public ServiceResult addList(List<SystemUser> entities) {
        return SafeExecuteUtil.execute(() ->
        {
            List<String> loginNames = new ArrayList<String>();
            entities.forEach(e -> {
                loginNames.add(e.getLoginName());
            });
            //判断是否重名
            Example example = new Example(SystemUser.class);
            example.createCriteria().andIn("loginName", loginNames);
            List<SystemUser> list = getMapper().selectByExample(example);
            if (list.size() > 0) {
                loginNames.clear();
                list.forEach(l -> {
                    loginNames.add(l.getLoginName());
                });
                throw new BusinessException("已存在登录名�{0})的用�, loginNames.toString());
            }
            entities.forEach(e -> {
                String password = createPassword(e.getLoginName(), e.getPassword());
                e.setPassword(password);
                e.setId(StringUtil.getUUID());
            });

            return getMapper().addList(entities);
        });

    }

    private String createPassword(String loginName, String password) {
        return StringUtil.toMD5(String.join("zoe", loginName, StringUtil.toMD5(password), loginName));
    }

    private LoginCredentials createLoginCredentials(String userId, String userName) {
        LoginCredentials credentials = new LoginCredentials();
        credentials.setUserId(userId);
        credentials.setUserName(userName);
        //todo 设置LoginCredentials
        credentials.setCredential("");
        return credentials;
    }

    private List<SystemUser> getUserByLoginName(String loginName) {
        Example example = new Example(SystemUser.class);
        example.createCriteria().andEqualTo("loginName", loginName);
        List<SystemUser> list = getMapper().selectByExample(example);
        return list;
    }

}