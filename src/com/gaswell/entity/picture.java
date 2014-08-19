package com.gaswell.entity;

import java.math.BigInteger;
import java.util.ArrayList;

import com.gaswell.dao.BodyBase;

public class picture extends BodyBase {

	private int mediaID;
	private byte mediaType;
	private byte mediaCodeFormat;
	private short dafaultMediaDataLength;
	private short receivedMediaDataLength;
	private byte[] mediaData;
	private int index;

	private String absolutelyPicPath;

	public picture() {
	}

	public picture(byte[] mediaData, int index) {
		this.mediaData = mediaData;
		this.index = index;
	}

	public static ArrayList<picture> pic = new ArrayList<picture>();
	public static short currentMediaID = -1;

	public int getMediaID() {
		return mediaID;
	}

	public void setMediaID(int mediaID) {
		this.mediaID = mediaID;
	}

	public byte getMediaType() {
		return mediaType;
	}

	public void setMediaType(byte mediaType) {
		this.mediaType = mediaType;
	}

	public byte getMediaCodeFormat() {
		return mediaCodeFormat;
	}

	public void setMediaCodeFormat(byte mediaCodeFormat) {
		this.mediaCodeFormat = mediaCodeFormat;
	}

	public short getDafaultMediaDataLength() {
		return dafaultMediaDataLength;
	}

	public void setDafaultMediaDataLength(short dafaultMediaDataLength) {
		this.dafaultMediaDataLength = dafaultMediaDataLength;
	}

	public short getReceivedMediaDataLength() {
		return receivedMediaDataLength;
	}

	public void setReceivedMediaDataLength(short receivedMediaDataLength) {
		this.receivedMediaDataLength = receivedMediaDataLength;
	}

	public byte[] getMediaData() {
		return mediaData;
	}

	public void setMediaData(byte[] mediaData) {
		this.mediaData = mediaData;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getAbsolutelyPicPath() {
		return absolutelyPicPath;
	}

	public void setAbsolutelyPicPath(String absolutelyPicPath) {
		this.absolutelyPicPath = absolutelyPicPath;
	}

	/**
	 * 获取多媒体信息
	 * 
	 * @param in
	 * @param totalNum
	 * @param currentNum
	 */
	public static void getMedia(byte[] in, int totalNum, int currentNum) {
		picture picPackage = new picture();
		byte[] temp = new byte[2];
		System.arraycopy(in, 0, temp, 0, 2);
		picPackage.setMediaID(new BigInteger(temp).shortValue());
		System.arraycopy(in, 8, temp, 0, 2);
		picPackage
				.setReceivedMediaDataLength(new BigInteger(temp).shortValue());
		if (picPackage.getMediaID() != currentMediaID) {
			pic.clear();
			currentMediaID = (short) picPackage.getMediaID();
		} else {

			picPackage.setIndex(currentNum);
			picPackage.setMediaData(new byte[picPackage
					.getReceivedMediaDataLength()]);
			System.arraycopy(in, 10, picPackage.getMediaData(), 0,
					picPackage.getReceivedMediaDataLength());
			pic.add(picPackage);
		}
		if (pic.size() == totalNum) {
			int totalSize = 0;
			for (int i = 0; i < pic.size(); i++)
				totalSize += pic.get(i).getMediaData().length;
			byte[] media = new byte[totalSize];
			int currentIndex = 0, currentPackage = 0;
			for (int i = 0; i < pic.size(); i++) {
				if (i == currentPackage) {
					currentPackage++;
					System.arraycopy(pic.get(i).getMediaData(), 0, media,
							currentIndex, pic.get(i).getMediaData().length);
					currentIndex += pic.get(i).getMediaData().length;
				}
			}
			// 调用多媒体存储函数

		}
	}
}
