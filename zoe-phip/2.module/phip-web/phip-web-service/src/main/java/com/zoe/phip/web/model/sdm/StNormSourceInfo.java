/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.web.model.sdm;

import javax.persistence.*;

import com.zoe.phip.module.service.entity.MasterEntity;

import java.sql.Date;

/**
 * @author
 * @version 1.0
 * @date 2016-05-03
 */
@Table(name = "PHIP_ST_NORM_SOURCE_INFO")
public class StNormSourceInfo extends MasterEntity {
    /**
     * 标准来源标识
     */
    @Column(name = "CODE")
    private String code;
    /**
     * 数据来源名称
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 数据库连接串
     */
    @Column(name = "DB_LINK")
    private String dbLink;
    /**
     * 标准类型
     */
    @Column(name = "STANDARD_TYPE")
    private java.math.BigDecimal standardType;
    /**
     * 起用时间
     */
    @Column(name = "START_TIME")
    private java.util.Date startTime;
    /**
     * 停用时间
     */
    @Column(name = "END_TIME")
    private java.util.Date endTime;

    /**
     *
     */
    @Column(name = "DESCR")
    private String descr;

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

    public String getDbLink() {
        return this.dbLink;
    }


    public void setDbLink(String dbLink) {
        this.dbLink = dbLink;
    }

    public java.math.BigDecimal getStandardType() {
        return this.standardType;
    }


    public void setStandardType(java.math.BigDecimal standardType) {
        this.standardType = standardType;
    }

    public java.util.Date getStartTime() {
        return this.startTime;
    }


    public void setStartTime(java.util.Date startTime) {
        this.startTime = startTime;
    }

    public java.util.Date getEndTime() {
        return this.endTime;
    }


    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    public String getDescr() {
        return this.descr;
    }


    public void setDescr(String descr) {
        this.descr = descr;
    }
}
