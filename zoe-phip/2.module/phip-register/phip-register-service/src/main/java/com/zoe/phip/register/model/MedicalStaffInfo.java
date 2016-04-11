/*
 * Powered By zoe
 * Since 2008 - 2016
 */

package com.zoe.phip.register.model;

import com.zoe.phip.module.service.entity.BaseEntity;

import javax.persistence.*;


/**
 * @author
 * @version 1.0
 * @date 2016-04-11
 */
@Table(name = "PHIP_MEDICAL_STAFF_INFO")
public class MedicalStaffInfo extends BaseEntity {
    /**
     * 医务人员id
     */
    @Column(name = "STAFF_ID")
    private String staffId;
    /**
     * 姓名
     */
    @Column(name = "NAME")
    private String name;
    /**
     * 性别代码
     */
    @Column(name = "GENDER_CODE")
    private String genderCode;
    /**
     * 性别名称
     */
    @Column(name = "GENDER_NAME")
    private String genderName;
    /**
     * 出生日期
     */
    @Column(name = "BIRTH_TIME")
    private java.sql.Timestamp birthTime;
    /**
     * 出生地
     */
    @Column(name = "BIRTHPLACE_ADDR")
    private String birthplaceAddr;
    /**
     * 身份证号
     */
    @Column(name = "ID_NO")
    private String idNo;
    /**
     * 专业技术职务代码
     */
    @Column(name = "TECHNICAL_CODE")
    private String technicalCode;
    /**
     * 专业技术职务名称
     */
    @Column(name = "TECHNICAL_NAME")
    private String technicalName;
    /**
     * 工作地址
     */
    @Column(name = "EMPLOYER_ADDR")
    private String employerAddr;
    /**
     * 工作联系电话
     */
    @Column(name = "EMPLOYER_TEL_NO")
    private String employerTelNo;
    /**
     * 角色有效期间(起始日期)
     */
    @Column(name = "EFFECTIVE_TIME_LOW")
    private java.sql.Timestamp effectiveTimeLow;
    /**
     * 角色有效期间(截止日期)
     */
    @Column(name = "EFFECTIVE_TIME_HIGH")
    private java.sql.Timestamp effectiveTimeHigh;
    /**
     * 科室号
     */
    @Column(name = "AFFILIATED_ORG_CODE")
    private String affiliatedOrgCode;
    /**
     * 科室名称
     */
    @Column(name = "AFFILIATED_ORG_NAME")
    private String affiliatedOrgName;
    /**
     * 创建时间
     */
    @Column(name = "CREATION_TIME")
    private java.sql.Timestamp creationTime;
    /**
     * 消息id
     */
    @Column(name = "MSG_ID")
    private String msgId;
    /**
     * 申请者代码
     */
    @Column(name = "ASSIGNED_CODE")
    private String assignedCode;
    /**
     * 申请者名称
     */
    @Column(name = "ASSIGNED_NAME")
    private String assignedName;
    /**
     * 申请者科室代码
     */
    @Column(name = "ASSIGNED_DEPT_CODE")
    private String assignedDeptCode;
    /**
     * 申请者科室名称
     */
    @Column(name = "ASSIGNED_DEPT_NAME")
    private String assignedDeptName;
    /**
     * 申请联系人
     */
    @Column(name = "ASSIGNED_ONTACT_PERSON")
    private String assignedOntactPerson;

    public String getStaffId() {
        return this.staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderCode() {
        return this.genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getGenderName() {
        return this.genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }

    public java.sql.Timestamp getBirthTime() {
        return this.birthTime;
    }

    public void setBirthTime(java.sql.Timestamp birthTime) {
        this.birthTime = birthTime;
    }

    public String getBirthplaceAddr() {
        return this.birthplaceAddr;
    }

    public void setBirthplaceAddr(String birthplaceAddr) {
        this.birthplaceAddr = birthplaceAddr;
    }

    public String getIdNo() {
        return this.idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getTechnicalCode() {
        return this.technicalCode;
    }

    public void setTechnicalCode(String technicalCode) {
        this.technicalCode = technicalCode;
    }

    public String getTechnicalName() {
        return this.technicalName;
    }

    public void setTechnicalName(String technicalName) {
        this.technicalName = technicalName;
    }

    public String getEmployerAddr() {
        return this.employerAddr;
    }

    public void setEmployerAddr(String employerAddr) {
        this.employerAddr = employerAddr;
    }

    public String getEmployerTelNo() {
        return this.employerTelNo;
    }

    public void setEmployerTelNo(String employerTelNo) {
        this.employerTelNo = employerTelNo;
    }

    public java.sql.Timestamp getEffectiveTimeLow() {
        return this.effectiveTimeLow;
    }

    public void setEffectiveTimeLow(java.sql.Timestamp effectiveTimeLow) {
        this.effectiveTimeLow = effectiveTimeLow;
    }

    public java.sql.Timestamp getEffectiveTimeHigh() {
        return this.effectiveTimeHigh;
    }

    public void setEffectiveTimeHigh(java.sql.Timestamp effectiveTimeHigh) {
        this.effectiveTimeHigh = effectiveTimeHigh;
    }

    public String getAffiliatedOrgCode() {
        return this.affiliatedOrgCode;
    }

    public void setAffiliatedOrgCode(String affiliatedOrgCode) {
        this.affiliatedOrgCode = affiliatedOrgCode;
    }

    public String getAffiliatedOrgName() {
        return this.affiliatedOrgName;
    }

    public void setAffiliatedOrgName(String affiliatedOrgName) {
        this.affiliatedOrgName = affiliatedOrgName;
    }

    public java.sql.Timestamp getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(java.sql.Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public String getMsgId() {
        return this.msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getAssignedCode() {
        return this.assignedCode;
    }

    public void setAssignedCode(String assignedCode) {
        this.assignedCode = assignedCode;
    }

    public String getAssignedName() {
        return this.assignedName;
    }

    public void setAssignedName(String assignedName) {
        this.assignedName = assignedName;
    }

    public String getAssignedDeptCode() {
        return this.assignedDeptCode;
    }

    public void setAssignedDeptCode(String assignedDeptCode) {
        this.assignedDeptCode = assignedDeptCode;
    }

    public String getAssignedDeptName() {
        return this.assignedDeptName;
    }

    public void setAssignedDeptName(String assignedDeptName) {
        this.assignedDeptName = assignedDeptName;
    }

    public String getAssignedOntactPerson() {
        return this.assignedOntactPerson;
    }

    public void setAssignedOntactPerson(String assignedOntactPerson) {
        this.assignedOntactPerson = assignedOntactPerson;
    }
}
