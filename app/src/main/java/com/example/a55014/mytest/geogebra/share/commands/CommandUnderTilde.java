package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.PhantomAtom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.UnderOverAtom;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandUnderTilde extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new UnderOverAtom(a,
				new AccentedAtom(new PhantomAtom(a, true, false, false),
						Symbols.WIDETILDE),
				new TeXLength(Unit.MU, 0.3), true, false);
	}

}
