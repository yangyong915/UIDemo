package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.mhchem.MhchemBondParser;

public class CommandBond extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String code = tp.getGroupAsArgument();
		final MhchemBondParser mbp = new MhchemBondParser(code);
		tp.addToConsumer(mbp.get());
		return false;
	}
}
