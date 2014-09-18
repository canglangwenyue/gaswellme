package com.gaswell.test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaswell.action.gs_showAction;
import com.gaswell.entity.gw_show;
import com.gaswell.util.excelOperationUtil;

public class gs_showActionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testList() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		gs_showAction userAction = (gs_showAction) ctx.getBean("gs_showAction");
		List<gw_show> list = userAction.list();
		excelOperationUtil.readDataToExcelFile(list);
	}

}
