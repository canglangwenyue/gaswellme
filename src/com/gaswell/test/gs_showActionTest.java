package com.gaswell.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaswell.action.gs_showAction;

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
		userAction.list();
	}

}
