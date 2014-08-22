package com.gaswell.server;

import java.net.InetAddress;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gaswell.entity.Header;
import com.gaswell.entity.clientHeartBeat;
import com.gaswell.entity.dataReport;
import com.gaswell.entity.picture;
import com.gaswell.entity.registerEntity;
import com.gaswell.util.baseLoger;
import com.gaswell.util.parserUtil;

public class chooseParserMethod {

	static boolean registerResult = false;
	static boolean registerJudage = false;
	static parserUtil pUtil = new parserUtil();
	static Logger log = LogManager.getLogger(baseLoger.class);
	static byte[] registerSuccess = { (byte) 0x7e, (byte) 0x00, (byte) 0x00,
			(byte) 0x00, (byte) 0x00, (byte) 0x7e };
	static byte[] registerFail = { (byte) 0x7e, (byte) 0x00, (byte) 0x00,
			(byte) 0x01, (byte) 0x00, (byte) 0x7e };
	static boolean choice = false;

	/**
	 * 对外接口，数据解析
	 * 
	 * @param in
	 * @param header
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public static boolean Paser(byte[] in, InetAddress adress, int port)
			throws Exception {
		byte[] msg = parserUtil.getMessage(in);
		if (msg == null)
			return false;
		msg = parserUtil.transForms(msg);
		if (parserUtil.checkMessage(msg) == false)
			return false;
		log.info("校验通过");
		byte[] headerByte = parserUtil.getMsgHeader(msg);
		byte[] bodyByte = parserUtil.getMsgBody(msg);
		Header header = Header.paserHeader(headerByte);
		switch (header.getMsgID()) {
		// case 0x0001:
		// body = paserGeneralResponseMessage(bodyByte);
		// break;
		case (short) 0x0801:
			picture.getMedia(bodyByte, header.getTotalPackagNumber(),
					header.getPackageIndex());
			break;
		case 0x0200:
			dataReport.paserDataReport(bodyByte);
			break;
		case 0x0100:
			registerResult = registerEntity.parserRegister(bodyByte, adress,
					port);
			registerJudage = true;
			break;
		case 0x0002:
			choice = clientHeartBeat.dealClientHeartBeat(adress, port);
			break;
		// 添加其他数据解析方法
		default:
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		String serverHost = "219.245.64.3";
		int serverPort = 30001;
		UdpServerSocket udpServerSocket = new UdpServerSocket(serverHost,
				serverPort);

		while (true) {
			String info = udpServerSocket.receive();
			InetAddress adress = udpServerSocket.getResponseAddress();
			byte[] ipAddress = adress.getAddress();
			int port = udpServerSocket.getResponsePort();
			log.info("received info's length: " + info.length());
			log.info(adress + "" + port);
			new chooseParserMethod();

			byte[] in = info.getBytes("ISO-8859-1");
			log.info("==" + in.length);
			for (int i = 0; i < in.length; i++) {
				System.out.print(in[i] + " ");
			}
			chooseParserMethod.Paser(in, adress, port);

			// if (registerResult == true) {
			// udpServerSocket.response(registerSuccess);
			// } else {
			// udpServerSocket.response(registerFail);
			// }
			if (registerJudage) {
				if (registerResult == true) {
					udpServerSocket.response(registerSuccess);
				} else {
					udpServerSocket.response(registerFail);
				}
				registerJudage = false;
				
			}
			
			if (choice) {
				byte[] heartBytes= {(byte)0x7e,(byte)0x00,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x7e};
				udpServerSocket.response(heartBytes);
				choice = false;
			}

		}
	}
}
