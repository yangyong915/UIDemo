package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.OverUnderDelimiter;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandOverBrack extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new OverUnderDelimiter(a, null, Symbols.LSQBRACK,
				Unit.EX, 0, true);
	}
}
