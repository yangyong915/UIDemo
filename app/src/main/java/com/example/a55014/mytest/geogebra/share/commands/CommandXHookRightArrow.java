package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.XHookAtom;

public class CommandXHookRightArrow extends Command1O1A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		return new XHookAtom(b, a, false);
	}

}
