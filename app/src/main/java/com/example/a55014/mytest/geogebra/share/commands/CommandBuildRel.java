package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.BuildrelAtom;
import com.example.a55014.mytest.geogebra.share.OverAtom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandBuildRel extends CommandStyle {

	public CommandBuildRel() {
		//
	}

	public CommandBuildRel(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		if (a instanceof OverAtom) {
			final Atom over = ((OverAtom) a).getNum();
			final Atom base = ((OverAtom) a).getDen();
			return new BuildrelAtom(base, over);
		}
		return a;
	}

}
