package com.example.a55014.mytest.geogebra.android.geom;

import android.graphics.PointF;

import com.example.a55014.mytest.geogebra.share.platform.geom.Point2D;

public class Point2DA implements Point2D {
	
	private PointF point;
	
	public Point2DA(double x, double y) {
		point = new PointF((float) x, (float) y);
	}

	public double getX() {
		return point.x;
	}

	public double getY() {
		return point.y;
	}

	public void setX(double x) {
		point.x = (float) x;
	}

	public void setY(double y) {
		point.y = (float) y;
	}

}
