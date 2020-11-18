package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.PodAtom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandPMod extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		final RowAtom ra = new RowAtom(3);
		ra.add(new RomanAtom(TeXParser.getAtomForLatinStr("mod", true)));
		ra.add(new SpaceAtom(Unit.MU, 6.));
		ra.add(a);
		return new PodAtom(ra, 8., true);
	}
}
