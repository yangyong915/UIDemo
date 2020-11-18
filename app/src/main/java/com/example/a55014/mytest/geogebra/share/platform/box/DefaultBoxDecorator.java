package com.example.a55014.mytest.geogebra.share.platform.box;

import com.example.a55014.mytest.geogebra.share.Box;

/**
 * Doesn't decorate the box, but simply returns the original one.
 */
public class DefaultBoxDecorator implements BoxDecorator {

	@Override
	public Box decorate(Box box) {
		return box;
	}
}
