package org.animesh.xml.reader.sax;

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

/*
 * SAX is an abbreviation and means "Simple API for XML". 
 * A Java SAX XML parser is a stream oriented XML parser. 
 * It works by iterating over the XML and call certain methods on a "listener" object when it meets certain structural elements of the XML.
 *  For instance, it will call the listener object for the following "events":
 *  
 *  startDocument
	startElement
	characters
	comments
	processing instructions
	endElement
	endDocument
 *  
 *  
 *  
 * 
 * 
 * 
 * 
 * 
 */
public class SAXReader {
	
	public static void main(String[] args) {
		
		try {
			SAXParserFactory  saxparserFactory = SAXParserFactory.newInstance();
			SAXParser saxParser = saxparserFactory.newSAXParser();
			InputStream    xmlInput  = new FileInputStream("emps.xml");
			DefaultHandler deafultHandler = new SaxHandler();
			saxParser.parse(xmlInput, deafultHandler);
			
			SAXSchemaValidation schemavalidator = new SAXSchemaValidation("emps.xml");
			schemavalidator.validateSchema();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
