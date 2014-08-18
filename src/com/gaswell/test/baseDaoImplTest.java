package com.gaswell.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.gaswell.dao.baseDao;
import com.gaswell.dao.impl.baseDaoImpl;
import com.gaswell.entity.gw_show;

public class baseDaoImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	 @Test
	 public void testAdd() {
	 baseDao dao = new baseDaoImpl();
	 gw_show gh = new gw_show();
	 gh.setLand_voltage("");
	 gh.setName("");
	 gh.setNstantaneous_flow("");
	 gh.setOil_voltage("");
	 gh.setPower_voltage("");
	 gh.setSwitch_status("");
	 gh.setTao_voltage("");
	 gh.setTemperature("");
	 gh.setTime("");
	 gh.setTotal_flow("");
	 gh.setYd_flow("");
	 dao.add(gh);
	 }

	// @Test
	// public void testCheckUserExistsWithName() {
	// baseDao dao = new baseDaoImpl();
	// new gw_show();
	// boolean exists = dao.checkUserExistsWithName("sunan343#");
	// Assert.assertEquals(true, exists);
	// }
//
//	@Test
//	public void testList() {
//		baseDao dao = new baseDaoImpl();
//		new gw_show();
//		dao.getgaswell();
//	}

}
