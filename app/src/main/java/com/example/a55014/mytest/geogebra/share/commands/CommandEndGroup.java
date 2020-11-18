package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandEndGroup extends Command {

	@Override
	public boolean init(TeXParser tp) {
		tp.processRBrace();
		return false;
	}

}
