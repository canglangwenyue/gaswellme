package com.gaswell.server;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class helperUtil {

	public static byte[] stringToByte() {
		String temp = "7e 02 00 00 00 00 52 A3 D0 1C 99 42 27 1C EA 82 2E 6B 79 8F E9 43 D3 00 04 00 00 dc 46 36 41 7d 02 7d 02 7d 02 7d 02 01 02 01 10 58 f2 41 01 10 58 fa 41 02 02 01 08 2c 21 42 08 2c 21 42 7b d4 7f 44 8f ea fd 44 9a 99 99 19 15 d6 32 41 01 08 2c 25 42 08 2c 25 42 3e 0a 80 44 8f 0a fe 44 9a 99 99 19 16 d6 32 41 03 02 01 01 01 01 04 00 1e 7e";

		byte b[] = temp.getBytes();// String转换为byte[]

		String t = new String(b);// byte[]转换为String
		return null;

	}

	public static void main(String args[])

	{

	}

}
