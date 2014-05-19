package org.animesh.xml.reader.dom;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;



public class XMLSchemaValidator {
	
	public static void main(String[] args) {
		
		String name = "emps.xml";
		Schema schema = null;
	try {
	  String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
	  SchemaFactory factory = SchemaFactory.newInstance(language);
	  schema = factory.newSchema(new File(name));
	  Validator validator = schema.newValidator();

	Document document;
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	document = dbFactory.newDocumentBuilder().parse(new File(name));
	validator.validate(new DOMSource(document));
	} 
	catch (Exception e) {
	    e.printStackTrace();
	}

	}
}
