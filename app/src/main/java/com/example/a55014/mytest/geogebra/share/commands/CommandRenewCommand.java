package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.NewCommandMacro;
import com.example.a55014.mytest.geogebra.share.SetLengthAtom;
import com.example.a55014.mytest.geogebra.share.TeXLengthSettings;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandRenewCommand extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String name = tp.getArgAsCommand();
		final int nbargs = tp.getOptionAsPositiveInteger(0);

		if (TeXLengthSettings.isLengthName(name) && nbargs == 0) {
			tp.addToConsumer(new SetLengthAtom(name, tp.getArgAsLength()));
			return false;
		}

		if (TeXLengthSettings.isFactorName(name) && nbargs == 0) {
			tp.addToConsumer(new SetLengthAtom(name, tp.getArgAsDecimal()));
			return false;
		}

		final String code = tp.getGroupAsArgument();

		NewCommandMacro.addNewCommand(tp, name, code, nbargs, true);
		return false;
	}
}
