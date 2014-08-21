package com.gaswell.entity;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class clientHeartbeat extends TimerTask {

	private final byte[] buffer = new byte[1024];

	private final DatagramPacket packet = null;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		cal.get(Calendar.HOUR_OF_DAY);
		if (hour == 7 | hour == 8 | hour == 9 | hour == 10 | hour == 11
				| hour == 12 | hour == 13 | hour == 14 | hour == 15
				| hour == 16 | hour == 17 | hour == 18 | hour == 19) {
			System.out.println("hello everyone!");
			try {
				DatagramSocket dsSocket = new DatagramSocket(10000);
				DatagramPacket dp = new DatagramPacket(buffer, buffer.length,
						InetAddress.getByName("192.16.16.1"), 8080);
				byte[] test = { (byte) 0x00, (byte) 0x00 };
				dp.setData(test);
				try {
					dsSocket.send(dp);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new clientHeartbeat(), 10000, 1000);
	}
}
