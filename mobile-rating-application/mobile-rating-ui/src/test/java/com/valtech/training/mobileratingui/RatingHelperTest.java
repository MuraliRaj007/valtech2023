package com.valtech.training.mobileratingui;


import org.junit.Test;

import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {

	@Test
	public void testGetRating() {
		RatingHelper helper=new RatingHelper();
		assertEquals(0, helper.getRanking("9876543210"));
	}

}
