/*
 * Powered By zoe
 * Since 2008 - 2016
 */


package com.zoe.phip.service.in.sm;

import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.QueryPage;
import com.zoe.phip.infrastructure.entity.ServiceResultT;
import com.zoe.phip.infrastructure.entity.SystemData;
import com.zoe.phip.model.sm.SystemDictCategory;
import com.zoe.phip.service.in.IBaseInService;

/**
 * 对外发布的服务接口
 *
 * @author
 * @version 1.0
 * @date 2016-03-22
 */
public interface ISystemDictCategoryService extends IBaseInService<SystemDictCategory> {

    ServiceResultT<PageList<SystemDictCategory>> getDictCategories(SystemData systemData, String key, QueryPage queryPage);

    ServiceResultT<SystemDictCategory> getDictCategory(SystemData systemData, String code);
}