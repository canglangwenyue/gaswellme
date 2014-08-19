package com.gaswell.entity;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gaswell.dao.impl.parseDaoImpl;
import com.gaswell.util.baseLoger;

@Entity
@Table(name = "registerentity")
public class registerEntity {

	public parseDaoImpl getDao() {
		return dao;
	}

	@Resource(name = "parsedao")
	public void setDao(parseDaoImpl dao) {
		this.dao = dao;
	}

	private int id;
	private static parseDaoImpl dao;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private byte[] makerID;
	private byte[] equipmentId;

	public byte[] getMakerID() {
		return makerID;
	}

	public void setMakerID(byte[] makerID) {
		this.makerID = makerID;
	}

	public byte[] getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(byte[] equipmentId) {
		this.equipmentId = equipmentId;
	}

	public static registerEntity parserRegister(byte[] in) {

		byte[] temp = new byte[20];

		Logger log = LogManager.getLogger(baseLoger.class);
		log.info("register");
		registerEntity reEntity = new registerEntity();
		System.arraycopy(in, 0, temp, 0, 20);

		reEntity.setMakerID(temp);

		System.arraycopy(in, 20, temp, 0, 20);

		reEntity.setEquipmentId(temp);
		dao.saveEntity(reEntity);
		return null;
	}
}
