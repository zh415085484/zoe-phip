package com.zoe.phip.web.bootstrapper;

import com.zoe.phip.infrastructure.bean.BeanFactory;
import com.zoe.phip.infrastructure.security.MenuCode;
import com.zoe.phip.web.model.sm.MenuData;
import com.zoe.phip.web.service.impl.in.sm.MenuDataServiceImpl;

/**
 * Created by zengjiyang on 2016/3/29.
 */
public class MenuInit {

    public static final int State = 1;

    // 无用，为了菜单数据的收集
    public static final MenuData ROOT = new MenuData("Root", "#", "#", State, 0, null);

    // 第一级， 系统菜单
    public static final MenuData SYSTEM_MANAGER = new MenuData("系统管理", "#", MenuCode.SystemManager.getCode(), State, 1, ROOT);

    // 第二级， 系统菜单子级
    public static final MenuData SYSTEM_USER = new MenuData("用户管理", "/user/view/list", MenuCode.SystemUser.getCode(), State, 2, SYSTEM_MANAGER);
    public static final MenuData SYSTEM_MENU = new MenuData("菜单管理", "/menu/view/list", MenuCode.SystemMenu.getCode(), State, 3, SYSTEM_MANAGER);
    public static final MenuData SYSTEM_PARAMETER = new MenuData("参数管理", "/param/view/index", MenuCode.SystemParameter.getCode(), State, 4, SYSTEM_MANAGER);
    public static final MenuData SYSTEM_DICT = new MenuData("字典管理", "/dict/view/list", MenuCode.SystemDict.getCode(), State, 5, SYSTEM_MANAGER);


    public static void toDatabase() {
        //如果数据库中该表数据不为0，则返回
        if (getMenuDataService().selectCountByExample(null) > 0) {
            return;
        }
        getMenuDataService().insertMenuData(ROOT.getChildren());
    }

    public static MenuDataServiceImpl getMenuDataService() {
        return BeanFactory.getBean("MenuDataService");
    }
}
