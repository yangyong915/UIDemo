package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.UnderOverAtom;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandB extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new UnderOverAtom(a, Symbols.BAR,
				new TeXLength(Unit.MU, 0.1), false, false);
	}

}
