package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.BigOperatorAtom;
import com.example.a55014.mytest.geogebra.share.PhantomAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.ScriptsAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TypedAtom;

public class CommandSideSet extends Command3A {

	@Override
	public Atom newI(TeXParser tp, Atom a, Atom b, Atom c) {
		final RowAtom ra = new RowAtom();
		c = c.changeLimits(TeXConstants.SCRIPT_NOLIMITS);
		if (a instanceof ScriptsAtom) {
			((ScriptsAtom) a).setBase(new PhantomAtom(c, false, true, true));
		} else if (a instanceof BigOperatorAtom) {
			((BigOperatorAtom) a)
					.setBase(new PhantomAtom(c, false, true, true));
		}
		ra.add(new TypedAtom(TeXConstants.TYPE_ORDINARY, a));

		if (b instanceof ScriptsAtom) {
			((ScriptsAtom) b).setBase(c);
		} else if (b instanceof BigOperatorAtom) {
			((BigOperatorAtom) b).setBase(c);
		} else {
			ra.add(c);
		}
		ra.add(new TypedAtom(TeXConstants.TYPE_ORDINARY, b));

		return ra;
	}
}
