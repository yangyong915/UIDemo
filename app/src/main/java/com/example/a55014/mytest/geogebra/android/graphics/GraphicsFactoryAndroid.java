package com.example.a55014.mytest.geogebra.android.graphics;

import com.example.a55014.mytest.geogebra.share.platform.graphics.BasicStroke;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;
import com.example.a55014.mytest.geogebra.share.platform.graphics.GraphicsFactory;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Image;
import com.example.a55014.mytest.geogebra.share.platform.graphics.Transform;

public class GraphicsFactoryAndroid extends GraphicsFactory {

	@Override
	public BasicStroke createBasicStroke(double width, int cap, int join,
			double miterLimit) {
		return new BasicStrokeA(width, miterLimit, cap, join);
	}

	@Override
	public Color createColor(int red, int green, int blue) {
		return new ColorA(red, green, blue);
	}

	@Override
	public Image createImage(int width, int height, int type) {
		return new ImageA(width, height, type);
	}

	@Override
	public Transform createTransform() {
		return new TransformA();
	}

}
