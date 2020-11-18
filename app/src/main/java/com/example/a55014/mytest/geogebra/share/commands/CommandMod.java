package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.PodAtom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandMod extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		final RowAtom ra = new RowAtom(4);
		final Atom sp = new SpaceAtom(TeXConstants.Muskip.THIN);
		ra.add(new RomanAtom(TeXParser.getAtomForLatinStr("mod", true)));
		ra.add(sp);
		ra.add(sp);
		ra.add(a);
		return new PodAtom(ra, 12., false);
	}

}
