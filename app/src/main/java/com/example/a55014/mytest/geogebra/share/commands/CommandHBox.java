package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandHBox extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		if (a instanceof RowAtom) {
			return a;
		}
		return new RowAtom(a);
	}

}
