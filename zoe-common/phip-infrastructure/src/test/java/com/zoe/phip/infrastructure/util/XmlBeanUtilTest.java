package com.zoe.phip.infrastructure.util;

import com.zoe.phip.infrastructure.annotation.XPath;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.junit.Test;

import java.util.Date;

/**
 * Created by zhangwenbin on 2016/4/12.
 */
public class XmlBeanUtilTest {

    @Test
    public void toBean() throws Exception {
        String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<PRPA_IN201311UV02 xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\"\n" +
                "xsi:schemaLocation=\"urn:hl7-org:v3 ../multicacheschemas/PRPA_IN201311UV02.xsd\" xmlns=\"urn:hl7-org:v3\">\n" +
                "  <id root=\"2.16.156.10011.0\" extension=\"22a0f9e0-4454-11dc-a6be-3603d6866807\"/>\n" +
                "  <creationTime value=\"20070803130624\"/>\n" +
                "  <interactionId root=\"2.16.840.1.113883.1.6\" extension=\"PRPA_IN201311UV02\"/>\n" +
                "  <processingCode code=\"P\"/>\n" +
                "  <processingModeCode code=\"R\"/>\n" +
                "  <acceptAckCode code=\"AL\"/>\n" +
                "  <receiver typeCode=\"RCV\">\n" +
                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
                "      <id root=\"2.16.156.10011.0.1.1\" extension=\"2.16.156.10011.0.1.1\"/>\n" +
                "    </device>\n" +
                "  </receiver>\n" +
                "  <sender typeCode=\"SND\">\n" +
                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
                "      <id root=\"2.16.156.10011.0.1.2\" extension=\"2.16.156.10011.0.1.2\"/>\n" +
                "    </device>\n" +
                "  </sender>\n" +
                "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\">\n" +
                "    <subject typeCode=\"SUBJ\">\n" +
                "      <registrationRequest classCode=\"REG\" moodCode=\"RQO\">\n" +
                "        <statusCode code=\"active\"/>\n" +
                "        <subject1 typeCode=\"SBJ\">\n" +
                "          <patient classCode=\"PAT\">\n" +
                "            <!--本地系统的患者ID -->\n" +
                "            <id root=\"2.16.156.10011.0.2.2\" extension=\"患者ID\"/>\n" +
                "            <statusCode code=\"active\"/>\n" +
                "            <effectiveTime value=\"20111212141414\"/>\n" +
                "            <patientPerson>\n" +
                "              <!--身份证号-->\n" +
                "              <id root=\"2.16.156.10011.1.3\" extension=\"120109197706015516\"/>\n" +
                "              <!--姓名-->\n" +
                "              <name use=\"L\">刘永好</name>\n" +
                "              <!--联系电话-->\n" +
                "              <telecom value=\"028-2222444\" use=\"H\"/>\n" +
                "              <!--性别-->\n" +
                "              <administrativeGenderCode code=\"1\"\n" +
                "              codeSystem=\"2.16.156.10011.2.3.3.4\" displayName=\"男性\"/>\n" +
                "              <!--出生时间-->\n" +
                "              <birthTime value=\"19570323\"/>\n" +
                "              <!--联系地址-->\n" +
                "              <addr use=\"PUB\">\n" +
                "                <!--非结构化地址（完整地址描述） -->\n" +
                "                <streetAddressLine partType=\"SAL\">\n" +
                "                  四川省成都市双流县红沙\n" +
                "                  村3 号\n" +
                "                </streetAddressLine>\n" +
                "                <!--地址-省（自治区、直辖市） -->\n" +
                "                <state language=\"CH\">广东省</state>\n" +
                "                <!--地址-市（地区） -->\n" +
                "                <city>广州市</city>\n" +
                "                <!--地址-县（区） -->\n" +
                "                <county>越秀区</county>\n" +
                "                <!-- 地址-乡（镇、街道办事处） -->\n" +
                "                <streetNameBase>童心街</streetNameBase>\n" +
                "                <!-- 地址-村（街、路、弄等） -->\n" +
                "                <streetName>下塘西路</streetName>\n" +
                "                <!-- 地址-门牌号码 -->\n" +
                "                <houseNumber>39号</houseNumber>\n" +
                "                <!-- 邮政编码-->\n" +
                "                <postalCode>510000</postalCode>\n" +
                "              </addr>\n" +
                "              <!--婚姻状况-->\n" +
                "              <maritalStatusCode code=\"10\" codeSystem=\"2.16.156.10011.2.3.3.5\"\n" +
                "              displayName=\"未婚\"/>\n" +
                "              <!--民族-->\n" +
                "              <ethnicGroupCode code=\"01\" codeSystem=\"2.16.156.10011.2.3.3.3\"\n" +
                "              displayName=\"汉族\"/>\n" +
                "              <!--职业类别代码-->\n" +
                "              <asEmployee classCode=\"EMP\">\n" +
                "                <occupationCode code=\"13\"\n" +
                "                codeSystem=\"2.16.156.10011.2.3.3.7\" displayName=\"专业技术人员\"/>\n" +
                "                <employerOrganization classCode=\"ORG\"\n" +
                "                determinerCode=\"INSTANCE\">\n" +
                "                  <!--工作单位名称-->\n" +
                "                  <name>XXX学校</name>\n" +
                "                  <contactParty classCode=\"CON\">\n" +
                "                    <!--工作联系电话-->\n" +
                "                    <telecom value=\"028-9999999\" use=\"WP\"/>\n" +
                "                  </contactParty>\n" +
                "                </employerOrganization>\n" +
                "              </asEmployee>\n" +
                "              <asOtherIDs classCode=\"PAT\">\n" +
                "                <!--健康卡号-->\n" +
                "                <id root=\"2.16.156.10011.1.19\" extension=\"38273N237\"/>\n" +
                "                <scopingOrganization classCode=\"ORG\"\n" +
                "                determinerCode=\"INSTANCE\">\n" +
                "                  <!--健康卡发放机构代码-->\n" +
                "                  <id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
                "                </scopingOrganization>\n" +
                "              </asOtherIDs>\n" +
                "              <asOtherIDs classCode=\"PAT\">\n" +
                "                <!--城乡居民健康档案编号-->\n" +
                "                <id root=\"2.16.156.10011.1.2\" extension=\"38273N237\"/>\n" +
                "                <scopingOrganization classCode=\"ORG\"\n" +
                "                determinerCode=\"INSTANCE\">\n" +
                "                  <!--建档医疗机构组织机构代码-->\n" +
                "                  <id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
                "                </scopingOrganization>\n" +
                "              </asOtherIDs>\n" +
                "              <!--联系人-->\n" +
                "              <personalRelationship>\n" +
                "                <code/>\n" +
                "                <!--联系人电话-->\n" +
                "                <telecom use=\"H\" value=\"028-8888888\"/>\n" +
                "                <relationshipHolder1 classCode=\"PSN\"\n" +
                "                determinerCode=\"INSTANCE\">\n" +
                "                  <!--联系人姓名-->\n" +
                "                  <name>刘好</name>\n" +
                "                </relationshipHolder1>\n" +
                "              </personalRelationship>\n" +
                "            </patientPerson>\n" +
                "            <providerOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\">\n" +
                "              <id root=\"2.16.156.10011.1.5\" extension=\"XXXXX\"/>\n" +
                "              <name use=\"L\">无锡中医院</name>\n" +
                "              <contactParty classCode=\"CON\"/>\n" +
                "            </providerOrganization>\n" +
                "            <!--医疗保险信息-->\n" +
                "            <coveredPartyOf typeCode=\"COV\">\n" +
                "              <coverageRecord classCode=\"COV\" moodCode=\"EVN\">\n" +
                "                <beneficiary typeCode=\"BEN\">\n" +
                "                  <beneficiary classCode=\"MBR\">\n" +
                "                    <code code=\"1\"\n" +
                "                    codeSystem=\"2.16.156.10011.2.3.1.248\" codeSystemName=\"医疗保险类别代码\" displayName=\"城镇职工基本医疗保险\"/>\n" +
                "                  </beneficiary>\n" +
                "                </beneficiary>\n" +
                "              </coverageRecord>\n" +
                "            </coveredPartyOf>\n" +
                "          </patient>\n" +
                "        </subject1>\n" +
                "        <author typeCode=\"AUT\">\n" +
                "          <assignedEntity classCode=\"ASSIGNED\">\n" +
                "            <id root=\"2.16.156.10011.0.3.2\" extension=\"修改人ID\"/>\n" +
                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\">\n" +
                "              <name use=\"L\">赵武x</name>\n" +
                "            </assignedPerson>\n" +
                "          </assignedEntity>\n" +
                "        </author>\n" +
                "      </registrationRequest>\n" +
                "    </subject>\n" +
                "  </controlActProcess>\n" +
                "</PRPA_IN201311UV02>";
        xmlString = XmlUtil.removeNameSpace(xmlString);
        try {
            Document document = DocumentHelper.parseText(xmlString);

          //  BaseInfo baseInfo = XmlBeanUtil.toBean(document, BaseInfo.class, null);
            System.out.println();


        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

class BaseInfo {
    //final String ROOT = "/PRPA_IN201311UV02";

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @XPath(value = "//controlActProcess/subject/registrationRequest/subject1/patient/providerOrganization/name", descr = "机构名称")
    //@Column(name = "ORG_NAME")
    public String orgName;

    public Integer getSexCode() {
        return sexCode;
    }

    public void setSexCode(Integer sexCode) {
        this.sexCode = sexCode;
    }

    @XPath(value = "//controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/administrativeGenderCode/@code", descr = "性别代码")
    private Integer sexCode;

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @XPath(value = "//controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/birthTime/@value", descr = "出生日期")
    private Date birthDate;


    public String getHealthRecordNo() {
        return healthRecordNo;
    }

    public void setHealthRecordNo(String healthRecordNo) {
        this.healthRecordNo = healthRecordNo;
    }

    @XPath(value = "//controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asOtherIDs/id[@root='2.16.156.10011.1.2']/@extension", descr = "出生日期")
    private String healthRecordNo;

}