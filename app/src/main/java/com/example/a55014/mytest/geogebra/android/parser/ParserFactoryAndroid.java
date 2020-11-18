package com.example.a55014.mytest.geogebra.android.parser;

import com.example.a55014.mytest.geogebra.share.platform.parser.Parser;
import com.example.a55014.mytest.geogebra.share.platform.parser.ParserFactory;

public class ParserFactoryAndroid extends ParserFactory {

	@Override
	public Parser createParser() {
		return new ParserA();
	}

}
