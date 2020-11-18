package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.PhantomAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.ScriptsAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandPreScript extends Command3A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b, Atom c) {
		final RowAtom ra = new RowAtom(
				new ScriptsAtom(new PhantomAtom(c, false, true, true), b, a,
						false),
				new SpaceAtom(Unit.MU, -0.3, 0., 0.),
				c.changeType(TeXConstants.TYPE_ORDINARY));
		ra.lookAtLast(true);
		return ra;
	}
}
