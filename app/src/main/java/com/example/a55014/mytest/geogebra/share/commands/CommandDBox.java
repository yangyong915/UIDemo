package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.DBoxAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandDBox extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new DBoxAtom(a);
	}
}
