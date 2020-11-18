package com.example.a55014.mytest.geogebra.android.font;

import android.content.res.AssetManager;

import com.example.a55014.mytest.geogebra.share.platform.font.Font;
import com.example.a55014.mytest.geogebra.share.platform.font.FontFactory;
import com.example.a55014.mytest.geogebra.share.platform.font.FontLoader;
import com.example.a55014.mytest.geogebra.share.platform.font.FontRenderContext;
import com.example.a55014.mytest.geogebra.share.platform.font.TextAttributeProvider;
import com.example.a55014.mytest.geogebra.share.platform.font.TextLayout;

public class FontFactoryAndroid extends FontFactory {
	
	private AssetManager mAssetManager;
	
	public FontFactoryAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	@Override
	public Font createFont(String name, int style, int size) {
		return new FontA(name, style, size);
	}

	@Override
	public TextLayout createTextLayout(String string, Font font,
			FontRenderContext fontRenderContext) {
		return new TextLayoutA(string, (FontA) font, (FontRenderContextA) fontRenderContext);
	}

	@Override
	public TextAttributeProvider createTextAttributeProvider() {
		return new TextAttributeProviderA();
	}

	@Override
	public FontLoader createFontLoader() {
		return new FontLoaderA(mAssetManager);
	}

}
