package com.example.a55014.mytest.geogebra.android.font;

import android.graphics.Paint;

import com.example.a55014.mytest.geogebra.share.platform.font.Font;
import com.example.a55014.mytest.geogebra.share.platform.font.FontRenderContext;

public class FontRenderContextA implements FontRenderContext {
	
	private Paint mPaint;
	
	public FontRenderContextA(Paint paint) {
		mPaint = paint;
	}

	public Paint getPaint() {
		return mPaint;
	}

	@Override
	public Font getFont() {
		// not used, web only
		return null;
	}
}
