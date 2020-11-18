package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.SymbolAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandTBinom extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		final SymbolAtom left = Symbols.LBRACK;
		final SymbolAtom right = Symbols.RBRACK;
		return CommandGenfrac.get(left, a, b, right, TeXLength.getZero(), 1);
	}

}
