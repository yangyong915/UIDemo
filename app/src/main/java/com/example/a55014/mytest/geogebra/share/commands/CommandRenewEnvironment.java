package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.NewEnvironmentMacro;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandRenewEnvironment extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String name = tp.getArgAsString();
		final int nbargs = tp.getOptionAsPositiveInteger(0);
		final String before = tp.getArgAsString();
		final String after = tp.getArgAsString();
		NewEnvironmentMacro.addNewEnvironment(tp, name, before, after, nbargs,
				true);
		return false;
	}
}
