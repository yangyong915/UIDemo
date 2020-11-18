package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.SmallCapAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandSc extends CommandStyle {

	public CommandSc() {
		//
	}

	public CommandSc(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new SmallCapAtom(a);
	}
}
