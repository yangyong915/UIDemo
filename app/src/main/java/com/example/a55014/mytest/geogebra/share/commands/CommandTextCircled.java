package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TextCircledAtom;

public class CommandTextCircled extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new TextCircledAtom(new RomanAtom(a));
	}

}
