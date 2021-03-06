/*
 * Powered By zoe
 * Since 2008 - 2016
 */


package com.zoe.phip.register.dao;

import com.zoe.phip.infrastructure.entity.PageList;
import com.zoe.phip.infrastructure.entity.QueryPage;
import com.zoe.phip.module.service.mapper.IServiceMapper;
import com.zoe.phip.register.model.DictCatalog;
import com.zoe.phip.register.model.DictItem;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2016-04-12
 */
public interface IDictCatalogMapper extends IServiceMapper<DictCatalog> {

    //字典分类（字典）
    DictCatalog addDictCatalogRequest(DictCatalog dictCatalog) throws Exception;

    DictCatalog updateDictCatalogRequest(DictCatalog dictCatalog) throws Exception;

    int dictCatalogExist(Map<String, Object> args);

    DictCatalog dictCatalogDetailQuery(String dictCatalogCode) throws Exception;

    DictCatalog dictCatalogDetailQueryById(String dictCatalogId) throws Exception;

    DictCatalog getDictCatalogById(Map<String, Object> args);

    boolean dictCatalogDetailDelete(String catalogId) throws Exception;

    int selectChildCountById(Map<String, Object> args);

    PageList<DictCatalog> dictCatalogTreeQuery(String codes, String key);

    List<DictCatalog> getDictCatalogTree(Map<String, Object> args);

    PageList<DictCatalog> dictCatalogListQueryPage(QueryPage queryPage, String key);

    PageList<DictCatalog> dictListQueryPage(QueryPage queryPage, String key);

    List<DictCatalog> getDictCatalogListPage(Map<String, Object> args);

    PageList<DictCatalog> dictCatalogListQueryByPIdPage(String pId, QueryPage queryPage);

    List<DictCatalog> getDictCatalogListByPIdPage(Map<String, Object> args);

    PageList<DictCatalog> getDictCatalogAndItemListByCode(String catalogCode);

    List<DictCatalog> getDictCatalogAndItemListByCode(Map<String, Object> args);

    PageList<DictCatalog> dictListWithoutFkCatalog(QueryPage queryPage, String key);

    List<DictCatalog> dictListWithoutFkCatalog(Map<String, Object> args);

    int updateDictWithFkCatalog(String pId, String catalogIds);

    int updateDictWithFkCatalog(Map<String, Object> args);

    //字典项
    DictItem addDictItemRequest(DictItem dictItem) throws Exception;

    DictItem updateDictItemRequest(DictItem dictItem) throws Exception;

    DictItem dictItemDetailQuery(String dictItemCode) throws Exception;

    DictItem dictItemDetailQueryById(String dictItemId) throws Exception;

    boolean dictItemDetailDelete(String dictItemId) throws Exception;

    boolean dictItemListDelete(String dictItemIds) throws Exception;

    PageList<DictItem> dictItemListQueryByCatalogCode(String catalogCode, QueryPage queryPage, String key);

    PageList<DictItem> dictItemListQueryByCatalogId(String catalogId, QueryPage queryPage, String key);

    DictCatalog getDictCategoryOrg(Map<String, Object> args);
}