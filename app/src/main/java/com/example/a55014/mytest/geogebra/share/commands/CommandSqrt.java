package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.NthRoot;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandSqrt extends Command1O1A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		return new NthRoot(b, a);
	}

}
