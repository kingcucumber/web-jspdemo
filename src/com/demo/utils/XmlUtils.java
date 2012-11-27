package com.demo.utils;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class XmlUtils {
	
	private static String filepath;
	
	static{
		filepath = XmlUtils.class.getClassLoader().getResource("user.xml").getPath();
	}
	public static Document getDocument() throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(filepath));
		return document;
	}
	
	public static void write2Xml(Document document){
		
	}
}
;