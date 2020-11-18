package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.CancelAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBCancel extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new CancelAtom(a, CancelAtom.Type.BACKSLASH);
	}

}
