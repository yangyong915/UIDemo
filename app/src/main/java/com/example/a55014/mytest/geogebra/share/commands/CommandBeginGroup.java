package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBeginGroup extends Command {

	@Override
	public boolean init(TeXParser tp) {
		tp.processLBrace();
		return false;
	}

}
