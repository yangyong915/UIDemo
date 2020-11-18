package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.NewCommandMacro;
import com.example.a55014.mytest.geogebra.share.TeXParser;

public class CommandDeclareMathOperator extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String name = tp.getArgAsCommand();
		final String base = tp.getGroupAsArgument();
		final String code = "\\mathop{\\mathrm{" + base + "}}\\nolimits";
		NewCommandMacro.addNewCommand(tp, name, code, 0, false);
		return false;
	}

}
