/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.register.dao;

import com.zoe.phip.module.service.mapper.IServiceMapper;
import com.zoe.phip.register.model.NationalStandards;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date 2016-04-25
 */
public interface INationalStandardsMapper extends IServiceMapper<NationalStandards> {
    List<NationalStandards> getDataPageList(Map<String, Object> map);

    int getNationalStandard(Map<String, Object> map);

    NationalStandards getNationalStandardDescr(Map<String, Object> map);
}