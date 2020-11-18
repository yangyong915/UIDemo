package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.Symbols;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandTilde2 extends Command1A {
	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new AccentedAtom(a, Symbols.TILDE);
	}

	@Override
	public boolean close(TeXParser tp) {
		tp.closeConsumer(Symbols.TILDE);
		return true;
	}

	@Override
	public boolean isClosable() {
		return true;
	}

}
