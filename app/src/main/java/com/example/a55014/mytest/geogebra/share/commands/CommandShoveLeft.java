package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AlignedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandShoveLeft extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new AlignedAtom(a, TeXConstants.Align.LEFT);
	}
}
