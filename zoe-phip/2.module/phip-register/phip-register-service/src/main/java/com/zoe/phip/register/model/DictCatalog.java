/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.register.model;

import com.zoe.phip.module.service.entity.MasterEntity;

import javax.persistence.*;


/**
 * @author
 * @version 1.0
 * @date 2016-04-11
 */
@Table(name = "PHIP_DICT_CATALOG")
public class DictCatalog extends MasterEntity {
    /**
     * 字典分类编码
     */
    @Column(name = "CODE")
    private String code;
    /**
     * 字典分类名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 字典父分类编码
     */
    @Column(name = "PARENT_CODE")
    private String parentCode;
    /**
     * 字典分类类别
     */
    @Column(name = "TYPE")
    private int type;

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentCode() {
        return this.parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
