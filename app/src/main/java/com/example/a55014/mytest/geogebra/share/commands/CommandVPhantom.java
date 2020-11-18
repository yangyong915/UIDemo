package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.PhantomAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandVPhantom extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new PhantomAtom(a, false, true, true);
	}

}
