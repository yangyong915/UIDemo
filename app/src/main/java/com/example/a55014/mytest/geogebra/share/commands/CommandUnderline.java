package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.UnderlinedAtom;

public class CommandUnderline extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new UnderlinedAtom(a);
	}

}
