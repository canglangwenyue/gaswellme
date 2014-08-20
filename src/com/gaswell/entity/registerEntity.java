package com.gaswell.entity;

import java.net.InetAddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gaswell.dao.parseDao;
import com.gaswell.dao.impl.parseDaoImpl;
import com.gaswell.server.UdpServerSocket;
import com.gaswell.util.baseLoger;

@Entity
@Table(name = "registerentity")
public class registerEntity {

	private int id;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String makerID;
	private String equipmentId;

	public String getMakerID() {
		return makerID;
	}

	public void setMakerID(String makerID) {
		this.makerID = makerID;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	@SuppressWarnings("null")
	public static boolean parserRegister(byte[] in, InetAddress adress, int port)
			throws Exception {

		byte[] temp = new byte[20];
		parseDao dao = new parseDaoImpl();

		Logger log = LogManager.getLogger(baseLoger.class);
		log.info("register");
		registerEntity reEntity = new registerEntity();
		System.arraycopy(in, 0, temp, 0, 20);

		reEntity.setMakerID(new String(temp, "ISO-8859-1"));

		System.arraycopy(in, 20, temp, 0, 20);
		reEntity.setEquipmentId(new String(temp, "ISO-8859-1"));
		log.info(adress + "=======" + port);
		new UdpServerSocket();
		if (dao.checkUserExistsEquipmentId(reEntity.getEquipmentId()))
			dao.saveEntity(reEntity);
		else {
			return false;
		}

		return true;
	}
}
