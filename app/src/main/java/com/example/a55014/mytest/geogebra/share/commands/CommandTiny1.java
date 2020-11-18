package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.MonoScaleAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandTiny1 extends CommandStyle {

	public CommandTiny1(RowAtom size) {
		this.size = size;
	}

	public CommandTiny1() {
		//
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new MonoScaleAtom(a, 0.5);
	}

}
