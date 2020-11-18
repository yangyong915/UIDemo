package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.mhchem.MhchemParser;

public class CommandCE extends Command {

	@Override
	public boolean init(TeXParser tp) {
		final String code = tp.getGroupAsArgument();
		final MhchemParser mp = new MhchemParser(code);
		mp.parse();
		tp.addToConsumer(new RomanAtom(mp.get()));
		return false;
	}

}
