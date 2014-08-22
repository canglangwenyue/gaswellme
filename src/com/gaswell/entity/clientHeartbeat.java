package com.gaswell.entity;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import com.gaswell.dao.BodyBase;

public class clientHeartBeat extends BodyBase{
	
	
	private final static byte[] buffer = new byte[1024];

//	private final DatagramPacket packet = null;
	
	public static int  staticPort = 10000;
	
	private String hostName;
	private int port;
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public static boolean dealClientHeartBeat(InetAddress adress, int port) throws Exception {
		
//		byte[] heartBytes= {(byte)0x7e,(byte)0x00,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x7e};
//		
//		clientHeartBeat cBeat = new clientHeartBeat();
//		cBeat.setHostName(adress.getHostAddress());
//		cBeat.setPort(port);
//		System.out.println("adress"+adress.getHostAddress()+"port"+port);
//			DatagramSocket dsSocket = new DatagramSocket(staticPort);
//			DatagramPacket dp = new DatagramPacket(buffer, buffer.length,
//					adress, port);
//			dp.setData(heartBytes);
//			staticPort++;
//			dsSocket.send(dp);
//		
//		if(staticPort==30000)
//			staticPort=10000;
		return true;
}
	
//	public static void main(String[] args) {
//		new clientHeartBeat();
//	}
}
