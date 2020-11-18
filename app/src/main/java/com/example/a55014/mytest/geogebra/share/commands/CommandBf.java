package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.BoldAtom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBf extends CommandStyle {

	public CommandBf() {
		//
	}

	public CommandBf(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new BoldAtom(new RomanAtom(a));
	}

}
