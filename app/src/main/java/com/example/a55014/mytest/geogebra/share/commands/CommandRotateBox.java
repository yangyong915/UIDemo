package com.example.a55014.mytest.geogebra.share.commands;

import java.util.Map;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RotateAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandRotateBox extends Command1A {

	double angle;
	Map<String, String> options;

	@Override
	public boolean init(TeXParser tp) {
		options = tp.getOptionAsMap();
		angle = tp.getArgAsDecimal();
		return true;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RotateAtom(a, angle, options);
	}
}
