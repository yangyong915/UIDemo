package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandOperatorName extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		a = new RomanAtom(a).changeType(TeXConstants.TYPE_BIG_OPERATOR);
		a.type_limits = TeXConstants.SCRIPT_NOLIMITS;
		return a;
	}
}
