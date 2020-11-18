package com.example.a55014.mytest.geogebra.android.resources;

import android.content.res.AssetManager;

import com.example.a55014.mytest.geogebra.share.platform.resources.ResourceLoader;
import com.example.a55014.mytest.geogebra.share.platform.resources.ResourceLoaderFactory;

public class ResourceLoaderFactoryAndroid implements ResourceLoaderFactory {
	
	private AssetManager mAssetManager;
	
	public ResourceLoaderFactoryAndroid(AssetManager assetManager) {
		mAssetManager = assetManager;
	}

	public ResourceLoader createResourceLoader() {
		return new ResourceLoaderA(mAssetManager);
	}

}
