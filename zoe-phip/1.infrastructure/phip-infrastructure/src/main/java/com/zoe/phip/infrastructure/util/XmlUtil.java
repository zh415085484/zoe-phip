package com.zoe.phip.infrastructure.util;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.SAXValidator;
import org.dom4j.io.XMLWriter;
import org.dom4j.util.XMLErrorHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by zhangwenbin on 2016/4/12.
 */
public final class XmlUtil {
    /**
     * 验证XML是否正确格式
     *
     * @param xmlString xml格式的文本
     * @return
     */
    public static boolean isValid(String xmlString) {
        try {
            if (!StringUtil.isNullOrWhiteSpace(xmlString)) {
                //XML转换时，如果转换前编码方法是UTF-8 或者 UniCode，则XML可能首位会出现异常字符
                //所以需要判断第一位字符是否为 “<”,如果不是 则需要去除
                if (!xmlString.startsWith("<")) {
                    xmlString = xmlString.substring(0, 1);
                }
                DocumentHelper.parseText(xmlString);
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 通过XSD验证xml的准确性
     * @param xsdFileName
     * @param xmlString
     * @return
     */
    public static boolean validateXsd(String xsdFileName, String xmlString) {
        try {
            XMLErrorHandler handler = new XMLErrorHandler();
            //获取基于 SAX 的解析器的实例
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //解析器在解析时验证 XML 内容。
            factory.setValidating(true);
            //指定由此代码生成的解析器将提供对 XML 名称空间的支持。
            factory.setNamespaceAware(true);
            //使用当前配置的工厂参数创建 SAXParser 的一个新实例。
            SAXParser parser = factory.newSAXParser();
            //创建一个读取工具
            //获取要校验xml文档实例
            Document document = DocumentHelper.parseText(xmlString);
            parser.setProperty(
                    "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                    "http://www.w3.org/2001/XMLSchema");
            parser.setProperty(
                    "http://java.sun.com/xml/jaxp/properties/schemaSource",
                    "file:" + xsdFileName);
            //创建一个SAXValidator校验工具，并设置校验工具的属性
            SAXValidator validator = new SAXValidator(parser.getXMLReader());
            //设置校验工具的错误处理器，当发生错误时，可以从处理器对象中得到错误信息。
            validator.setErrorHandler(handler);
            //校验
            validator.validate(document);

            XMLWriter writer = new XMLWriter(OutputFormat.createPrettyPrint());
            if (handler.getErrors().hasContent()) {
                System.out.println("XML文件通过XSD文件校验失败!");
                writer.write(handler.getErrors());
                return false;
            } else {
                System.out.println("XML文件通过XSD文件校验成功!");
            }
            return true;
        } catch (Exception ex) {
            System.out.println("XML文件通过XSD文件:" + xsdFileName + "检验失败。\n原因： " + ex.getMessage());
            //ex.printStackTrace();
            return false;
        }
    }

    /**
     * 去掉XML文件中的命名空间xmlns,防止查找元素出错
     * @param xmlString
     * @return
     */
    public static String removeNameSpace(String xmlString)
    {
        String awsNamespace = "urn:hl7-org:v3";
        String xmlnsStr = " xmlns=\"" + awsNamespace + "\"";
        return xmlString.replace(xmlnsStr, "");
    }

}
