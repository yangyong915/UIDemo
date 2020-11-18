package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TypedAtom;

public class CommandMathOpen extends Command1A {
	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new TypedAtom(TeXConstants.TYPE_OPENING, a);
	}
}
