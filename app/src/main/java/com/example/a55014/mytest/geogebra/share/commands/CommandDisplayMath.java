package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.MathAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandDisplayMath extends Command1A {
	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new MathAtom(a, TeXConstants.STYLE_DISPLAY);
	}

}
