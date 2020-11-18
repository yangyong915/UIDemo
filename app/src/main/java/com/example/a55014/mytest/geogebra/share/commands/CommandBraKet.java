package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBraKet extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RowAtom(Symbols.LANGLE, a, Symbols.RANGLE);
	}

}
