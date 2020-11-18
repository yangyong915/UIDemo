package com.example.a55014.mytest.geogebra.android;

import android.content.res.AssetManager;

import com.example.a55014.mytest.geogebra.android.font.FontFactoryAndroid;
import com.example.a55014.mytest.geogebra.android.geom.GeomFactoryAndroid;
import com.example.a55014.mytest.geogebra.android.graphics.GraphicsFactoryAndroid;
import com.example.a55014.mytest.geogebra.android.parser.ParserFactoryAndroid;
import com.example.a55014.mytest.geogebra.android.resources.ResourceLoaderFactoryAndroid;
import com.example.a55014.mytest.geogebra.share.platform.FactoryProvider;
import com.example.a55014.mytest.geogebra.share.platform.font.FontFactory;
import com.example.a55014.mytest.geogebra.share.platform.geom.GeomFactory;
import com.example.a55014.mytest.geogebra.share.platform.graphics.GraphicsFactory;
import com.example.a55014.mytest.geogebra.share.platform.parser.ParserFactory;
import com.example.a55014.mytest.geogebra.share.platform.resources.ResourceLoaderFactory;

public class FactoryProviderAndroid extends FactoryProvider {
	
	private AssetManager mAssetManager;
	
	public FactoryProviderAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	@Override
	protected GeomFactory createGeomFactory() {
		return new GeomFactoryAndroid();
	}

	@Override
	protected FontFactory createFontFactory() {
		return new FontFactoryAndroid(mAssetManager);
	}

	@Override
	protected GraphicsFactory createGraphicsFactory() {
		return new GraphicsFactoryAndroid();
	}

	//@Override
	protected ParserFactory createParserFactory() {
		return new ParserFactoryAndroid();
	}

	//@Override
	protected ResourceLoaderFactory createResourceLoaderFactory() {
		return new ResourceLoaderFactoryAndroid(mAssetManager);
	}
}
