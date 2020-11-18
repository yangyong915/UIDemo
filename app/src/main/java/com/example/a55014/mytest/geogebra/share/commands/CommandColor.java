package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.ColorAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class CommandColor extends CommandStyle {

	Color fg;

	public CommandColor() {
		//
	}

	public CommandColor(RowAtom size, Color fg2) {
		this.size = size;
		this.fg = fg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		fg = CommandDefinecolor.getColor(tp);
		return super.init(tp);
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new ColorAtom(a, null, fg);
	}

}
