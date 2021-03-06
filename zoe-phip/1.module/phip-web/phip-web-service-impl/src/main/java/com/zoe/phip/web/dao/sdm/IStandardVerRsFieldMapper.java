/*
 * Powered By zoe
 * Since 2008 - 2016
 */


package com.zoe.phip.web.dao.sdm;

import com.zoe.phip.module.service.mapper.IMyMapper;
import com.zoe.phip.web.model.sdm.StRsSetElementInfo;
import com.zoe.phip.web.model.sdm.StandardVerRsDict;
import com.zoe.phip.web.model.sdm.StandardVerRsField;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2016-05-04
 */
public interface IStandardVerRsFieldMapper extends IMyMapper<StandardVerRsField> {
    int getSingle(Map<String, Object> map);

    List<StRsSetElementInfo> getFieldByFkVersionId(Map<String, Object> map);

    
}