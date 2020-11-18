package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FencedAtom;
import com.example.a55014.mytest.geogebra.share.FractionAtom;
import com.example.a55014.mytest.geogebra.share.SymbolAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBinom extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		final SymbolAtom left = Symbols.LBRACK;
		final SymbolAtom right = Symbols.RBRACK;
		return new FencedAtom(new FractionAtom(a, b, false), left, right);
	}

}
