package com.example.a55014.mytest.geogebra.share.commands;

import java.util.HashMap;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RotateAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandT extends Command1A {

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new RotateAtom(a, 180., new HashMap<String, String>() {
			{
				put("origin", "cc");
			}
		});
	}

}
