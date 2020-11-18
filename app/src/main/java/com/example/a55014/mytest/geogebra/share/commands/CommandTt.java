package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TtAtom;

public class CommandTt extends CommandStyle {

	public CommandTt() {
		//
	}

	public CommandTt(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new TtAtom(a);
	}

}
