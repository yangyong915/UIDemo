package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.SymbolAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandGrkAccent extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		// TODO: instanceof
		return new AccentedAtom(b, (SymbolAtom) a);
	}

}
