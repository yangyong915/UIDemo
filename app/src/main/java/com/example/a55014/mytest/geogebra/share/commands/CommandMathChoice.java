package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.MathchoiceAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandMathChoice extends Command4A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b, Atom c, Atom d) {
		return new MathchoiceAtom(a, b, c, d);
	}
}
