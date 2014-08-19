package com.gaswell.entity;

import java.math.BigInteger;

import com.gaswell.dao.BodyBase;

public class Header extends BodyBase {

	private short msgID;
	private byte[] msgProperty;
	private short msgLength;
	private byte[] deviceID;
	private short msgNumber;
	private short totalPackagNumber = -1;
	private short packageIndex = -1;

	@Override
	public short getMsgID() {
		return msgID;
	}

	@Override
	public void setMsgID(short msgID) {
		this.msgID = msgID;
	}

	public byte[] getMsgProperty() {
		return msgProperty;
	}

	public void setMsgProperty(byte[] msgProperty) {
		this.msgProperty = msgProperty;
	}

	public short getMsgLength() {
		return msgLength;
	}

	public void setMsgLength(short msgLength) {
		this.msgLength = msgLength;
	}

	public byte[] getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(byte[] deviceID) {
		this.deviceID = deviceID;
	}

	public short getMsgNumber() {
		return msgNumber;
	}

	public void setMsgNumber(short msgNumber) {
		this.msgNumber = msgNumber;
	}

	public short getTotalPackagNumber() {
		return totalPackagNumber;
	}

	public void setTotalPackagNumber(short totalPackagNumber) {
		this.totalPackagNumber = totalPackagNumber;
	}

	public short getPackageIndex() {
		return packageIndex;
	}

	public void setPackageIndex(short packageIndex) {
		this.packageIndex = packageIndex;
	}

	/**
	 * 解析数据头
	 * 
	 * @param in
	 *            数据头byte数组
	 * @return
	 */
	public static Header paserHeader(byte[] in) {
		byte[] temp = null;
		Header header = new Header();
		temp = new byte[2];
		System.arraycopy(in, 0, temp, 0, 2);
		header.setMsgID(new BigInteger(temp).shortValue());
		header.setMsgProperty(new byte[2]);
		System.arraycopy(in, 2, header.msgProperty, 0, 2);
		System.arraycopy(in, 4, temp, 0, 2);
		header.setMsgLength(new BigInteger(temp).shortValue());
		byte[] tempDevice = new byte[16];
		System.arraycopy(in, 6, tempDevice, 0, 16);
		header.setDeviceID(tempDevice);
		System.arraycopy(in, 22, temp, 0, 2);
		header.setMsgNumber(new BigInteger(temp).shortValue());
		System.arraycopy(in, 24, temp, 0, 2);
		header.totalPackagNumber = new BigInteger(temp).shortValue();
		System.arraycopy(in, 26, temp, 0, 2);
		header.packageIndex = new BigInteger(temp).shortValue();
		return header;
	}

}
