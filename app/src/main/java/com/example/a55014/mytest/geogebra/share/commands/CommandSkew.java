package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.AccentedAtom;
import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.exception.ParseException;

public class CommandSkew extends Command {

	private double skew;

	@Override
	public boolean init(TeXParser tp) {
		skew = tp.getArgAsDecimal();
		return true;
	}

	@Override
	public void add(TeXParser tp, Atom a) {
		if (a instanceof AccentedAtom) {
			((AccentedAtom) a).setSkew(skew);
			tp.closeConsumer(a);
			return;
		}
		throw new ParseException(tp,
				"skew command is only working with an accent as second argument");
	}
}
