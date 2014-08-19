package com.gaswell.server;

import java.math.BigInteger;
import java.util.ArrayList;

public class Parser {

	public class Header {
		public short msgID;
		public byte[] msgProperty;
		public short msgLength;
		public byte[] deviceID;
		public short msgNumber;
		public short totalPackagNumber = -1;
		public short packageIndex = -1;
	}

	public class BodyBase {
		short msgID;
	}

	public class GeneralResponse extends BodyBase {
		short responseNumber;
		short responseID;
		byte result;
	}

	class MediaStruct {
		int index;
		byte[] data;
	}

	public static ArrayList<MediaStruct> pic = new ArrayList<MediaStruct>();
	public static short currentMediaID = -1;

	public static void psrserTest(byte[] in) {
		// byte[] in =
		// {(byte)0x7e,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x52,(byte)0xA3,(byte)0xD0,(byte)0x1C,(byte)0x99,(byte)0x42,(byte)0x27,(byte)0x1C,(byte)0xEA,(byte)0x82,(byte)0x2E,(byte)0x6B,(byte)0x79,(byte)0x8F,(byte)0xE9,(byte)0x43,(byte)0xD3,(byte)0x00,(byte)0x04,(byte)0x00,(byte)0x00,(byte)0xdc,(byte)0x46,(byte)0x36,(byte)0x41,(byte)0x7d,(byte)0x02,(byte)0x7d,(byte)0x02,(byte)0x7d,(byte)0x02,(byte)0x7d,(byte)0x02,(byte)0x01,(byte)0x02,(byte)0x01,(byte)0x10,(byte)0x58,(byte)0xf2,(byte)0x41,(byte)0x01,(byte)0x10,(byte)0x58,(byte)0xfa,(byte)0x41,(byte)0x02,(byte)0x02,(byte)0x01,(byte)0x08,(byte)0x2c,(byte)0x21,(byte)0x42,(byte)0x08,(byte)0x2c,(byte)0x21,(byte)0x42,(byte)0x7b,(byte)0xd4,(byte)0x7f,(byte)0x44,(byte)0x8f,(byte)0xea,(byte)0xfd,(byte)0x44,(byte)0x9a,(byte)0x99,(byte)0x99,(byte)0x19,(byte)0x15,(byte)0xd6,(byte)0x32,(byte)0x41,(byte)0x01,(byte)0x08,(byte)0x2c,(byte)0x25,(byte)0x42,(byte)0x08,(byte)0x2c,(byte)0x25,(byte)0x42,(byte)0x3e,(byte)0x0a,(byte)0x80,(byte)0x44,(byte)0x8f,(byte)0x0a,(byte)0xfe,(byte)0x44,(byte)0x9a,(byte)0x99,(byte)0x99,(byte)0x19,(byte)0x16,(byte)0xd6,(byte)0x32,(byte)0x41,(byte)0x03,(byte)0x02,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x01,(byte)0x04,(byte)0x00,(byte)0x1e,(byte)0x7e};
		byte[] out = getMessage(in);
		out = transForms(out);
		System.out.println(checkMessage(out));
		byte[] header = getMsgHeader(out);
		paserHeader(header);
		for (int i = 0; i < out.length; i++)
			System.out.println(out[i]);
	}

	/**
	 * 检查消息头
	 * 
	 * @param in
	 *            输入byte数组
	 * @return 返回不包含标示符的数据包
	 */
	public static byte[] getMessage(byte[] in) {
		int msgLength = in.length;
		if (in[0] != 126 || in[msgLength - 1] != 126) // 0x7e
			return null;
		else {
			byte[] out = new byte[msgLength - 2];
			System.arraycopy(in, 1, out, 0, msgLength - 2);
			return out;
		}
	}

	/**
	 * 校验数据包
	 * 
	 * @param in
	 *            输入byte数组
	 * @return 返回校验结果
	 */
	public static boolean checkMessage(byte[] in) {
		int msgLength = in.length;
		byte checksum = in[0];
		for (int i = 1; i < msgLength - 1; i++)
			checksum = (byte) (checksum ^ in[i]);
		if (checksum != in[msgLength - 1])
			return false;
		else
			return true;
	}

	/**
	 * 转义还原
	 * 
	 * @param in
	 *            输入byte数组
	 * @return
	 */
	public static byte[] transForms(byte[] in) {
		int count = 0;
		for (int i = 0; i < in.length; i++)
			if (in[i] == 125) // 0x7d
				count++;
		byte[] out = new byte[in.length - count];
		for (int i = 0, j = 0; i < in.length; i++, j++) {
			if (in[i] == 125 && in[i + 1] == 2) {
				out[j] = 126; // 0x7e
				i++;
			} else if (in[i] == 125 && in[i + 1] == 1) {
				out[j] = 125; // 0x7d
				i++;
			} else
				out[j] = in[i];
		}
		return out;
	}

	/**
	 * 获取消息头
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] getMsgHeader(byte[] in) {
		byte msgProperty = in[15];
		byte[] out = null;
		if (msgProperty == 1) {
			out = new byte[28];// 消息头有分包信息
			System.arraycopy(in, 0, out, 0, 28);
		} else {
			out = new byte[24]; // 消息头没有分包信息
			System.arraycopy(in, 0, out, 0, 24);
		}
		return out;
	}

	/**
	 * 获取消息体
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] getMsgBody(byte[] in) {
		byte msgProperty = in[15];
		byte[] out = null;
		if (msgProperty == 1) {
			out = new byte[in.length - 28];// 消息头有分包信息
			System.arraycopy(in, 24, out, 0, in.length - 28);
		} else {
			out = new byte[in.length - 24];// 消息头没有分包信息
			System.arraycopy(in, 24, out, 0, in.length - 24); // 需要去掉最后一个字节的校验
		}
		return out;
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
		Header header = new Parser().new Header();
		temp = new byte[2];
		System.arraycopy(in, 0, temp, 0, 2);
		header.msgID = new BigInteger(temp).shortValue();
		header.msgProperty = new byte[2];
		System.arraycopy(in, 2, header.msgProperty, 0, 2);
		System.arraycopy(in, 4, temp, 0, 2);
		header.msgLength = new BigInteger(temp).shortValue();
		header.deviceID = new byte[16];
		System.arraycopy(in, 6, header.deviceID, 0, 16);
		System.arraycopy(in, 22, temp, 0, 2);
		header.msgNumber = new BigInteger(temp).shortValue();
		if (header.msgProperty[13] == 1) {
			System.arraycopy(in, 24, temp, 0, 2);
			header.totalPackagNumber = new BigInteger(temp).shortValue();
			System.arraycopy(in, 26, temp, 0, 2);
			header.packageIndex = new BigInteger(temp).shortValue();
		}
		return header;
	}

	/**
	 * 解析通用应答消息体数据
	 * 
	 * @param in
	 * @return
	 */
	public static BodyBase paserGeneralResponseMessage(byte[] in) {
		byte[] temp = null;
		GeneralResponse gernelResponse = new Parser().new GeneralResponse();
		gernelResponse.msgID = 0x0001;
		temp = new byte[2];
		System.arraycopy(in, 0, temp, 0, 2);
		gernelResponse.responseID = new BigInteger(temp).shortValue();
		System.arraycopy(in, 2, temp, 0, 2);
		gernelResponse.responseNumber = new BigInteger(temp).shortValue();
		gernelResponse.result = in[4];
		return gernelResponse;
	}

	// 解析其他数据函数

	/**
	 * 对外接口，数据解析
	 * 
	 * @param in
	 * @param header
	 * @param body
	 * @return
	 */
	public static boolean Paser(byte[] in, Header header, BodyBase body) {
		byte[] msg = getMessage(in);
		if (msg == null)
			return false;
		msg = transForms(msg);
		if (checkMessage(msg) == false)
			return false;
		byte[] headerByte = getMsgHeader(msg);
		byte[] bodyByte = getMsgBody(msg);
		header = paserHeader(headerByte);
		switch (header.msgID) {
		case 0x0001:
			body = paserGeneralResponseMessage(bodyByte);
			break;
		case (short) 0x8801:
			getMedia(bodyByte, header.totalPackagNumber, header.packageIndex);
			break;
		// 添加其他数据解析方法
		default:
			return false;
		}
		return true;
	}

	/**
	 * 获取多媒体信息
	 * 
	 * @param in
	 * @param totalNum
	 * @param currentNum
	 */
	public static void getMedia(byte[] in, int totalNum, int currentNum) {
		byte[] temp = new byte[2];
		System.arraycopy(in, 0, temp, 0, 2);
		short mediaID = new BigInteger(temp).shortValue();
		System.arraycopy(in, 8, temp, 0, 2);
		short mediaLength = new BigInteger(temp).shortValue();
		if (mediaID != currentMediaID) {
			pic.clear();
			currentMediaID = mediaID;
		} else {
			MediaStruct mediaPackage = new Parser().new MediaStruct();
			mediaPackage.index = currentNum;
			mediaPackage.data = new byte[mediaLength];
			System.arraycopy(in, 10, mediaPackage.data, 0, mediaLength);
			pic.add(mediaPackage);
		}
		if (pic.size() == totalNum) {
			int totalSize = 0;
			for (int i = 0; i < pic.size(); i++)
				totalSize += pic.get(i).data.length;
			byte[] media = new byte[totalSize];
			int currentIndex = 0, currentPackage = 0;
			for (int i = 0; i < pic.size(); i++) {
				if (i == currentPackage) {
					currentPackage++;
					System.arraycopy(pic.get(i).data, 0, media, currentIndex,
							pic.get(i).data.length);
					currentIndex += pic.get(i).data.length;
				}
			}
			// 调用多媒体存储函数
		}
	}

}
