package com.example.a55014.mytest.geogebra.share.commands;

import com.example.a55014.mytest.geogebra.share.CursorAtom;
import com.example.a55014.mytest.geogebra.share.TeXParser;
import com.example.a55014.mytest.geogebra.share.platform.FactoryProvider;
import com.example.a55014.mytest.geogebra.share.platform.graphics.GraphicsFactory;

public class CommandJlmCursor extends Command {

	@Override
	public boolean init(TeXParser tp) {
		double size = tp.getArgAsDecimal();

		CursorAtom atom = new CursorAtom(FactoryProvider.getInstance()
				.getGraphicsFactory().createColor(GraphicsFactory.CURSOR_RED,
						GraphicsFactory.CURSOR_GREEN,
						GraphicsFactory.CURSOR_BLUE),
				size);

		tp.addToConsumer(atom);
		return false;

	}

}
