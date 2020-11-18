package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RaiseAtom;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandRaiseBox extends Command1A {

	TeXLength raise;
	TeXLength height;
	TeXLength depth;

	@Override
	public boolean init(TeXParser tp) {
		raise = tp.getArgAsLength();
		height = tp.getOptionAsLength(null);
		depth = tp.getOptionAsLength(null);
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RaiseAtom(a, raise, height, depth);
	}
}
