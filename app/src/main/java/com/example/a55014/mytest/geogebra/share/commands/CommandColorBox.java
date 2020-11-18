package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FBoxAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class CommandColorBox extends Command1A {

	Color bg;

	public CommandColorBox() {
		//
	}

	public CommandColorBox(Color bg2) {
		this.bg = bg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		bg = CommandDefinecolor.getColor(tp);
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new FBoxAtom(a, bg, bg);
	}

}
