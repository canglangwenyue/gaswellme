package com.gaswell.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gaswell.entity.gw_show;
import com.gaswell.service.gwShow;
import com.gaswell.service.impl.gwShowImpl;

public class gwShowImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	// @Test
	// public void testLists() {
	// gwShow gw = new gwShowImpl();
	// gw.lists();
	// }

	@Test
	public void testAdd() throws Exception {
		gwShow gw = new gwShowImpl();
		gw_show gh = new gw_show();
		gh.setName("金秀贤");
		gw.add(gh);

	}

	// @Test
	// public void testExists() throws Exception {
	// gwShow gw = new gwShowImpl();
	// gw_show gh = new gw_show();
	// gh.setName("sunan343#");
	// System.out.println(gh.getLand_voltage());
	// boolean exists = gw.exists(gh);
	// Assert.assertEquals(true, exists);
	// }
	//
	// @Test
	// public void testUpdate() {
	// fail("Not yet implemented");
	// }

}
