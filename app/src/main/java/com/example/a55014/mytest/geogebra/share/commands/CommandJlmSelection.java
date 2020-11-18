package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.Colors;
import com.example.a55014.mytest.geogebra.share.SelectionAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandJlmSelection extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new SelectionAtom(a, Colors.SELECTION, null);
	}
}
