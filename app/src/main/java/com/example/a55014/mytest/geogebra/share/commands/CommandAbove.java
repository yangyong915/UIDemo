package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FractionAtom;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandAbove extends CommandOver {

	TeXLength len;

	@Override
	public boolean init(TeXParser tp) {
		super.init(tp);
		len = tp.getArgAsLength();
		return false;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		return new FractionAtom(a, b, len);
	}
}
