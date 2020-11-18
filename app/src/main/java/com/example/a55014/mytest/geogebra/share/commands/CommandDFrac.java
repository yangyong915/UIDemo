package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandDFrac extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		return CommandGenfrac.get(null, a, b, null, null, 0);
	}

}
