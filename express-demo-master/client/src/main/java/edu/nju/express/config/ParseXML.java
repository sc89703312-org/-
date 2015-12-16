package edu.nju.express.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * 对XML文件进行解析（读取修改）
 * @author 
 * @version 
 */
public class ParseXML {

	private Element theData;
	private Element root;
	private Document xmldoc;
	private String xmlPath = "RMI.xml";

	public ParseXML(String name) {
		init(xmlPath, name);
	}

	public ParseXML(String xmlPath, String name) {
		this.xmlPath = xmlPath;
		init(xmlPath, name);
	}

	private void init(String xmlPath, String name) {
		try {
			// step 1: 获得dom解析器工厂（工作的作用是用于创建具体的解析器）  
			DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
			// step 2:获得具体的dom解析器  
			DocumentBuilder docBuilder = dbfactory.newDocumentBuilder();
			// step3: 解析一个xml文档，获得Document对象（根结点）  
			xmldoc = docBuilder.parse(new File(xmlPath));
			root = xmldoc.getDocumentElement();
			theData = (Element)selectSingleNode("/Config/Data[name='" + name + "']", root);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据Key获得value
	 * @param tag
	 * @return value
	 * @author 
	 * @version 
	 */
	public String getValue(String tag) {
		String value = theData.getElementsByTagName(tag).item(0).getFirstChild().getNodeValue();
		return value;
	}

	public void setValue(String tag, String value) {
		theData.getElementsByTagName(tag).item(0).setTextContent(value);
		saveXml(xmlPath, xmldoc);
	}

	/**
	 * 查找节点，并返回第一个符合条件节点
	 * @author 
	 * @version 
	 */
	private Node selectSingleNode(String express, Object source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node)xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 将Document输出到文件
	 * @param fileName
	 * @param doc
	 * @author 
	 * @version 
	 */
	private void saveXml(String fileName, Document doc) {
		TransformerFactory transFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transFactory.newTransformer();
			transformer.setOutputProperty("indent", "yes");

			DOMSource source = new DOMSource();
			source.setNode(doc);
			StreamResult result = new StreamResult();
			result.setOutputStream(new FileOutputStream(fileName));

			transformer.transform(source, result);
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
