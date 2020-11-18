package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandTextRm extends CommandText {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RomanAtom(a);
	}

}
