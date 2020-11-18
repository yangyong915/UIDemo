package com.example.a55014.mytest.geogebra.android.font;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import com.example.a55014.mytest.geogebra.share.exception.ResourceParseException;
import com.example.a55014.mytest.geogebra.share.platform.font.Font;
import com.example.a55014.mytest.geogebra.share.platform.font.FontLoader;

public class FontLoaderA implements FontLoader {

	private AssetManager mAssetManager;

	public FontLoaderA(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	public Font loadFont(String name) throws ResourceParseException {
		// TODO fontType should be a class object instead of inputstream
		Typeface typeface = Typeface.createFromAsset(mAssetManager, name);
		return new FontA(name, typeface, (int)Math.round(PIXELS_PER_POINT));
	}

}
