package com.example.a55014.mytest.geogebra.android.parser;

import com.example.a55014.mytest.geogebra.share.platform.parser.Document;
import com.example.a55014.mytest.geogebra.share.platform.parser.Element;

public class DocumentA implements Document {
	
	private org.w3c.dom.Document impl;
	
	public DocumentA(org.w3c.dom.Document impl) {
		this.impl = impl;
	}

	public Element getDocumentElement() {
		return new ElementA(impl.getDocumentElement());
	}

}
