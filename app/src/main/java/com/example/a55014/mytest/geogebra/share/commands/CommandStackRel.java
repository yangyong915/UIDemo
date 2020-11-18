package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.UnderOverAtom;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandStackRel extends Command1O2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b, Atom c) {
		final Atom at = new UnderOverAtom(c, a,
				new TeXLength(Unit.MU, 3.5), true, b,
				new TeXLength(Unit.MU, 3.), true);
		return at.changeType(TeXConstants.TYPE_RELATION);
	}

}
