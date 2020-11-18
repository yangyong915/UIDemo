package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.OoalignAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.Unit;

public class CommandPMB extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new OoalignAtom(a,
				new RowAtom(new SpaceAtom(Unit.MU, 0.4), a));
	}
}
