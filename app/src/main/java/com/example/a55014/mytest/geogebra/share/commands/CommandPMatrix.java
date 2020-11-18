package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FencedAtom;
import com.example.a55014.mytest.geogebra.share.SMatrixAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandPMatrix extends CommandMatrix {

	@Override
	public Atom newI(TeXParser tp) {
		return new FencedAtom(new SMatrixAtom(aoa, false), Symbols.LBRACK,
				Symbols.RBRACK);
	}
}
