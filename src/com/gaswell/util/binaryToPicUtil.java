package com.gaswell.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

public class binaryToPicUtil {

	public static String saveImage(String data, String fileName, String type) {

		String path = "C:/Users/wenyue/Desktop/";
		BufferedImage image = new BufferedImage(540, 960,
				BufferedImage.TYPE_BYTE_BINARY);
		ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
		String picName = path + fileName + getCurrentDateStr()  + "." + type;
		try {
			ImageIO.write(image, type, byteOutputStream);
			byte[] bytes = hex2byte(data);
			RandomAccessFile file = new RandomAccessFile(picName,
					"rw");
			file.write(bytes);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return picName;
	}

	public static byte[] hex2byte(String s) {
		byte[] src = s.toLowerCase().getBytes();
		byte[] ret = new byte[src.length / 2];
		for (int i = 0; i < src.length; i += 2) {
			byte hi = src[i];
			byte low = src[i + 1];
			hi = (byte) ((hi >= 'a' && hi <= 'f') ? 0x0a + (hi - 'a')
					: hi - '0');
			low = (byte) ((low >= 'a' && low <= 'f') ? 0x0a + (low - 'a')
					: low - '0');
			ret[i / 2] = (byte) (hi << 4 | low);
		}
		return ret;
	}

	public static String getCurrentDateStr() {
		Date date = new Date();
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		str = df.format(date);
		return str;
	}
}
