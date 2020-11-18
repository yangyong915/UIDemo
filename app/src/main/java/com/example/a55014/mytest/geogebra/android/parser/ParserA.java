package com.example.a55014.mytest.geogebra.android.parser;

import com.example.a55014.mytest.geogebra.share.exception.ResourceParseException;
import com.example.a55014.mytest.geogebra.share.platform.parser.Document;
import com.example.a55014.mytest.geogebra.share.platform.parser.Parser;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

public class ParserA implements Parser {

	private DocumentBuilderFactory factory;

	public ParserA() {
		factory = DocumentBuilderFactory.newInstance();
	}

	public Document parse(Object input) throws ResourceParseException {
		// On the desktop platform, the input is an InputSource object
		// Please refer to the ResourceLoaderD class
		InputStream is = (InputStream) input;
		org.w3c.dom.Document document = tryParse(is);
		return new DocumentA(document);
	}

	private org.w3c.dom.Document tryParse(InputStream is) throws ResourceParseException {
		try {
			return factory.newDocumentBuilder().parse(is);
		} catch (Exception ex) {
			ResourceParseException rpe = new ResourceParseException("Could not parse resource", ex);
			throw rpe;
		}
	}

	public void setIgnoringElementContentWhitespace(boolean whitespace) {
		factory.setIgnoringElementContentWhitespace(whitespace);
	}

	public void setIgnoringComments(boolean ignoreComments) {
		factory.setIgnoringComments(ignoreComments);
	}
}
