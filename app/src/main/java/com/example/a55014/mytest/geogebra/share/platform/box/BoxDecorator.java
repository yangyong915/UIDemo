package com.example.a55014.mytest.geogebra.share.platform.box;

import com.example.a55014.mytest.geogebra.share.Box;

/**
 * Decorates a box.
 */
public interface BoxDecorator {

	/**
	 * @param box The returned decorated box is based on this one.
	 * @return A decorated box.
	 */
	Box decorate(Box box);
}
