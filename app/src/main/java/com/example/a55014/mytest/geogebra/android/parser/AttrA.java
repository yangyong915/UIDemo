package com.example.a55014.mytest.geogebra.android.parser;

import com.example.a55014.mytest.geogebra.share.platform.parser.Attr;

import org.w3c.dom.Node;

public class AttrA extends NodeA implements Attr {
	
	public org.w3c.dom.Attr impl;
	
	public AttrA(org.w3c.dom.Attr impl) {
		super((Node) impl);
		this.impl = impl;
	}

	public String getName() {
		return impl.getName();
	}

	public boolean isSpecified() {
		return impl.getSpecified();
	}

	public String getValue() {
		return impl.getValue();
	}

}
