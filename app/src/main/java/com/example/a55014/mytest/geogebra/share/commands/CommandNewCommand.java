package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.NewCommandMacro;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandNewCommand extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String name = tp.getArgAsCommand();
		final int nbargs = tp.getOptionAsPositiveInteger(0);
		final String code = tp.getGroupAsArgument();
		NewCommandMacro.addNewCommand(tp, name, code, nbargs, false);
		return false;
	}
}
