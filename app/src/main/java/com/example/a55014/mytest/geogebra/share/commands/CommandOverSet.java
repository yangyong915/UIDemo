package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.UnderOverAtom;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandOverSet extends Command2A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b) {
		final Atom at = new UnderOverAtom(b, a,
				new TeXLength(Unit.MU, 2.5), true, true);
		return at.changeType(TeXConstants.TYPE_RELATION);
	}
}
