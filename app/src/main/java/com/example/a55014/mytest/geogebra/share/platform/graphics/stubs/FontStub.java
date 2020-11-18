package com.example.a55014.mytest.geogebra.share.platform.graphics.stubs;

import java.util.Map;

import com.example.a55014.mytest.geogebra.share.CharFont;
import com.example.a55014.mytest.geogebra.share.platform.font.Font;
import com.example.a55014.mytest.geogebra.share.platform.font.FontRenderContext;
import com.example.a55014.mytest.geogebra.share.platform.font.TextAttribute;
import com.example.a55014.mytest.geogebra.share.platform.geom.Shape;

public class FontStub implements Font {

	@Override
	public Font deriveFont(Map<TextAttribute, Object> map) {
		return this;
	}

	@Override
	public Font deriveFont(int type) {
		return this;
	}

	@Override
	public boolean isEqual(Font f) {
		return false;
	}

	@Override
	public int getScale() {
		return 1;
	}

	@Override
	public Shape getGlyphOutline(FontRenderContext frc, CharFont cf) {
		return null;
	}

	@Override
	public boolean canDisplay(char ch) {
		return true;
	}

	@Override
	public boolean canDisplay(int c) {
		return true;
	}

}
