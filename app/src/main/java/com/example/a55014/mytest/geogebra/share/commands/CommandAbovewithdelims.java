package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FractionAtom;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandAbovewithdelims extends CommandOverwithdelims {

	TeXLength l;

	@Override
	public void add(TeXParser tp, Atom a) {
		if (left == null) {
			left = a;
		} else if (right == null) {
			right = a;
			l = tp.getArgAsLength();
		} else {
			den.add(a);
		}
	}

	@Override
	public Atom newI(TeXParser tp, Atom num, Atom den) {
		return new FractionAtom(num, den, l);
	}
}
