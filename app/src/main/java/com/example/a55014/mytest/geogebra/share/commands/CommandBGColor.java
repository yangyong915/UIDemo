package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.ColorAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class CommandBGColor extends Command1A {

	Color bg;

	public CommandBGColor() {
		//
	}

	public CommandBGColor(Color bg2) {
		this.bg = bg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		bg = CommandDefinecolor.getColor(tp);
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new ColorAtom(a, bg, null);
	}

}
