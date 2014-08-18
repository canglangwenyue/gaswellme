package com.gaswell.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class parserUtil {

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
			Logger log = LogManager.getLogger(baseLoger.class);
			System.out.println("\n");
			log.info("返回没有tag的message");
			for (int i = 0; i < out.length; i++) {
				System.out.print(out[i]+" ");
			}
			log.info("换行");
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
		byte[] out = null;
		out = new byte[28];// 消息头有分包信息
		System.arraycopy(in, 0, out, 0, 28);
		Logger log = LogManager.getLogger(baseLoger.class);
		log.info("message header:");
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i]+" ");
		}
		log.info("\n");
		return out;
	}

	/**
	 * 获取消息体
	 * 
	 * @param in
	 * @return
	 */
	public static byte[] getMsgBody(byte[] in) {
		byte[] out = null;
		out = new byte[in.length - 29];// 消息头有分包信息
		System.arraycopy(in, 28, out, 0, in.length - 29);
		Logger log = LogManager.getLogger(baseLoger.class);
		log.info("message body:");
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i]+" ");
		}
		log.info("\n");
		return out;
	}

	/**
	 * byte[] to float
	 * 
	 * @param b
	 * @return
	 */
	public static float getFloat(byte[] b) {
		int accum = 0;
		accum = accum | (b[0] & 0xff) << 0;
		accum = accum | (b[1] & 0xff) << 8;
		accum = accum | (b[2] & 0xff) << 16;
		accum = accum | (b[3] & 0xff) << 24;
		return Float.intBitsToFloat(accum);
	}

	
	/**
	 * to double
	 * @param b
	 * @return
	 */
	public static double getDouble(byte[] b){  
	     long l;  
	     l=b[0];  
	     l&=0xff;  
	     l|=((long)b[1]<<8);  
	     l&=0xffff;  
	     l|=((long)b[2]<<16);  
	     l&=0xffffff;  
	     l|=((long)b[3]<<24);  
	     l&=0xffffffffl;  
	     l|=((long)b[4]<<32);  
	     l&=0xffffffffffl;  
	    
	     l|=((long)b[5]<<40);  
	     l&=0xffffffffffffl;  
	     l|=((long)b[6]<<48);  
	   
	   
	     l|=((long)b[7]<<56);  
	     return Double.longBitsToDouble(l);  
	   }  


}
