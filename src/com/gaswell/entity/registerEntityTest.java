package com.gaswell.entity;

import org.junit.Test;

import com.gaswell.dao.impl.parseDaoImpl;

public class registerEntityTest {

	@Test
	public void testParserRegister() {
		parseDaoImpl dao = new parseDaoImpl();
		registerEntity entity = new registerEntity();
		entity.setEquipmentId(null);
		dao.saveEntity(entity);

	}

}
