package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AccentSetAtom;
import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.SymbolAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandAccentSet extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		if (a instanceof SymbolAtom) {
			return new AccentedAtom(b, (SymbolAtom) a);
		} else {
			return new AccentSetAtom(b, a);
		}
	}


}
