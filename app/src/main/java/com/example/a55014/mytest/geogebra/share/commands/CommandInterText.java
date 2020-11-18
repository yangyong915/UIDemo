package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.Atom;
import com.example.a55014.mytest.geogebra.share.RomanAtom;
import com.example.a55014.mytest.geogebra.share.StyleAtom;
import com.example.a55014.mytest.geogebra.share.TeXConstants;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.TextStyle;
import com.example.a55014.mytest.geogebra.share.TextStyleAtom;
import com.example.a55014.mytest.geogebra.share.exception.ParseException;

public class CommandInterText extends Command {

	boolean mode;

	@Override
	public boolean init(TeXParser tp) {
		if (!tp.isArrayMode()) {
			throw new ParseException(tp,
					"The macro \\intertext is only available in array mode !");
		}
		mode = tp.setTextMode();
		return true;
	}

	@Override
	public void add(TeXParser tp, Atom a) {
		tp.setMathMode(mode);
		a = new TextStyleAtom(a, TextStyle.MATHNORMAL);
		a = new StyleAtom(TeXConstants.STYLE_TEXT, new RomanAtom(a));
		tp.closeConsumer(a.changeType(TeXConstants.TYPE_INTERTEXT));
	}

}
