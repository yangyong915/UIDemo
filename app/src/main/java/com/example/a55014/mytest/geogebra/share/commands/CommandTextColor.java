package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.ColorAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class CommandTextColor extends Command1A {

	Color fg;

	public CommandTextColor() {
		//
	}

	public CommandTextColor(Color fg) {
		this.fg = fg;
	}

	@Override
	public boolean init(TeXParser tp) {
		fg = CommandDefinecolor.getColor(tp);
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new ColorAtom(a, null, fg);
	}

}
