package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.MonoScaleAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandLarge extends CommandStyle {

	public CommandLarge() {
		//
	}

	public CommandLarge(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new MonoScaleAtom(a, 1.2);
	}
}
