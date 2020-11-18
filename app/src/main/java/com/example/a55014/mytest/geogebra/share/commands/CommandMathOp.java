package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TypedAtom;

public class CommandMathOp extends Command1A {
	@Override
	public Atom newI(TeXParser tp, Atom a) {
		a = new TypedAtom(TeXConstants.TYPE_BIG_OPERATOR, a);
		a.type_limits = TeXConstants.SCRIPT_NORMAL;
		return a;
	}

}
