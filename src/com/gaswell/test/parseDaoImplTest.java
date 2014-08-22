package com.gaswell.test;

import org.junit.Test;

import com.gaswell.dao.parseDao;
import com.gaswell.dao.impl.parseDaoImpl;
import com.gaswell.entity.gw_show;

public class parseDaoImplTest {

	@Test
	public void testSaveEntity() {
		parseDao dao = new parseDaoImpl();
		gw_show gh = new gw_show();
		gh.setLand_voltage("");
		gh.setName("dhjkahdjkal");
		gh.setNstantaneous_flow("");
		gh.setOil_voltage("");
		gh.setPower_voltage("");
		gh.setSwitch_status("");
		gh.setTao_voltage("");
		gh.setTemperature("");
		gh.setTime("");
		gh.setTotal_flow("");
		gh.setYd_flow("");
		dao.saveEntity(gh);
	}

}
