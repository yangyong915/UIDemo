package com.example.a55014.mytest.geogebra.android.geom;

import com.example.a55014.mytest.geogebra.share.platform.geom.Area;
import com.example.a55014.mytest.geogebra.share.platform.geom.GeomFactory;
import com.example.a55014.mytest.geogebra.share.platform.geom.Line2D;
import com.example.a55014.mytest.geogebra.share.platform.geom.Point2D;
import com.example.a55014.mytest.geogebra.share.platform.geom.Rectangle2D;
import com.example.a55014.mytest.geogebra.share.platform.geom.RoundRectangle2D;
import com.example.a55014.mytest.geogebra.share.platform.geom.Shape;

public class GeomFactoryAndroid extends GeomFactory {

	@Override
	public Line2D createLine2D(double x1, double y1, double x2, double y2) {
		return new Line2DA(x1, y1, x2, y2);
	}

	@Override
	public Rectangle2D createRectangle2D(double x, double y, double w, double h) {
		return new Rectangle2DA(x, y, w, h);
	}

	@Override
	public RoundRectangle2D createRoundRectangle2D(double x, double y,
			double w, double h, double arcw, double arch) {
		return new RoundRectangle2DA(x, y, w, h, arcw, arch);
	}

	@Override
	public Point2D createPoint2D(double x, double y) {
		return new Point2DA(x, y);
	}

	@Override
	public Area createArea(Shape rect) {
		return null;
	}

	@Override
	public Area newArea() {
		return null;
	}

}
