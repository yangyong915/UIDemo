package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RowAtom;
import com.example.a55014.mytest.geogebra.share.StyleAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandScriptStyle extends CommandStyle {

	public CommandScriptStyle() {
		//
	}

	public CommandScriptStyle(RowAtom size) {
		this.size = size;
	}

	@Override
	public Atom newI(TeXParser tp, Atom a) {
		return new StyleAtom(TeXConstants.STYLE_SCRIPT, a);
	}
}
