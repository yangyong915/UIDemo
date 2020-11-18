package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.FBoxAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class CommandFColorBox extends Command1A {

	Color frame;
	Color bg;

	public CommandFColorBox() {
		//
	}

	public CommandFColorBox(Color frame2, Color bg2) {
		this.frame = frame2;
		this.bg = bg2;
	}

	@Override
	public boolean init(TeXParser tp) {
		frame = tp.getArgAsColor();
		bg = tp.getArgAsColor();
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new FBoxAtom(a, bg, frame);
	}

}
