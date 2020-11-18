package com.example.a55014.mytest.geogebra.android.graphics;

import com.example.a55014.mytest.geogebra.share.platform.graphics.Color;

public class ColorA implements Color {
	
	private int mColor;

	public ColorA(int color) {
		mColor = color;
	}
	
	public ColorA(int red, int green, int blue) {
		mColor = android.graphics.Color.rgb(red, green, blue);
	}

	public Object getNativeObject() {
		return Integer.valueOf(mColor);
	}

	public int getColor() {
		return mColor;
	}

	@Override
	public int hashCode() {
		return mColor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColorA other = (ColorA) obj;
		if (mColor != other.mColor)
			return false;
		return true;
	}

	
}
