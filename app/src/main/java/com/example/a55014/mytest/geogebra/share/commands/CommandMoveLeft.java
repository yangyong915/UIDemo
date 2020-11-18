package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.SpaceAtom;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandMoveLeft extends Command1A {

	TeXLength left;

	@Override
	public boolean init(TeXParser tp) {
		left = tp.getArgAsLength();
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RowAtom(new SpaceAtom(left.scale(-1.)), a);
	}
}
