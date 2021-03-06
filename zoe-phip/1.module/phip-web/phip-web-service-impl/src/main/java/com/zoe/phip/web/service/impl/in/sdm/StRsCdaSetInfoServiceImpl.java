/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.web.service.impl.in.sdm;

import com.zoe.phip.infrastructure.annotation.ErrorMessage;
import com.zoe.phip.infrastructure.exception.BusinessException;
import com.zoe.phip.infrastructure.util.MapUtil;
import com.zoe.phip.module.service.impl.in.BaseInServiceImpl;

import com.zoe.phip.web.dao.sdm.IStRsCdaSetInfoMapper;
import com.zoe.phip.web.model.sdm.StRsCdaSetInfo;
import com.zoe.phip.web.service.sdm.IStRsCdaSetInfoService;
import org.springframework.stereotype.Repository;
import com.alibaba.dubbo.config.annotation.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2016-05-05
 */
@Repository("stRsCdaSetInfoService")
@Service(interfaceClass = IStRsCdaSetInfoService.class,protocol = {"dubbo"}, proxy = "sdpf", dynamic = true)
@ErrorMessage(code = "001", message = "关系已经存在!")
public class StRsCdaSetInfoServiceImpl extends BaseInServiceImpl<StRsCdaSetInfo, IStRsCdaSetInfoMapper> implements IStRsCdaSetInfoMapper {

    public boolean updateByCdaId(String fkCdaId, List<StRsCdaSetInfo> infoList) throws Exception {
        deleteByCdaId(fkCdaId);
        if(null!=infoList){
            super.addList(infoList);
        }
        return true;
    }

    public int deleteByCdaId(String fkCdaId) {
        Example example = new Example(StRsCdaSetInfo.class);
        example.createCriteria().andEqualTo("fkCdaId", fkCdaId);
        return super.deleteByExample(example);
    }

    public int deleteByFkSetId(String fkSetId) {
        Example example = new Example(StRsCdaSetInfo.class);
        example.createCriteria().andEqualTo("fkSetId", fkSetId);
        return super.deleteByExample(example);
    }

    public int deleteByFkSetIds(String fkSetIds) {

        return deleteByFkSetIds(fkSetIds.split(","));
    }


    @Override
    public int add(StRsCdaSetInfo entity) throws Exception {
        Map<String, Object> map = MapUtil.createMap(map1 -> {
            map1.put("fkSetId", entity.getFkSetId());
            map1.put("fkCdaId", entity.getFkCdaId());
        });
        if (getSingle(map) > 0) {
            dispose(map);
            throw new BusinessException("001");
        }
        dispose(map);
        return super.add(entity);
    }

    @Override
    public int update(StRsCdaSetInfo entity) throws Exception {
        Map<String, Object> map = MapUtil.createMap(map1 -> {
            map1.put("fkSetId", entity.getFkSetId());
            map1.put("fkCdaId", entity.getFkCdaId());
            map1.put("id", entity.getId());
        });
        if (getSingle(map) > 0) {
            dispose(map);
            throw new BusinessException("001");
        }
        dispose(map);
        return super.update(entity);
    }

    @Override
    public int getSingle(Map<String, Object> map) {
        return getMapper().getSingle(map);
    }

    @Override
    public int deleteByFkSetIds(String[] fkSetIds) {
        return getMapper().deleteByFkSetIds(fkSetIds);
    }
}