package org.animesh.xml.reader.sax;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

public class SAXSchemaValidation {
	Schema schema = null;
	String name =null;
	SAXParser parser = null;
	
	public SAXSchemaValidation(String name) {
		super();
		this.name = name;
	}


	
	public SAXParser validateSchema() throws ParserConfigurationException, SAXException{
		try {
			  String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
			  SchemaFactory factory = SchemaFactory.newInstance(language);
			  schema = factory.newSchema(new File(name));
			} catch (Exception e) {
			    e.printStackTrace();
			}
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		spf.setSchema(schema);

		SAXParser parser = spf.newSAXParser();
		return parser;
	}

}
