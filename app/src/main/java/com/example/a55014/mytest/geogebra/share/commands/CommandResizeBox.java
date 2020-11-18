package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.ResizeAtom;
import com.example.a55014.mytest.geogebra.share.TeXLength;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandResizeBox extends Command1A {

	private TeXLength width;
	private TeXLength height;

	public CommandResizeBox() {
		//
	}

	@Override
	public boolean init(TeXParser tp) {
		width = tp.getArgAsLengthOrExcl();
		height = tp.getArgAsLengthOrExcl();
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new ResizeAtom(a, width, height);
	}
}
