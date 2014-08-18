package com.gaswell.server;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gaswell.entity.Header;
import com.gaswell.entity.dataReport;
import com.gaswell.util.baseLoger;
import com.gaswell.util.parserUtil;

public class chooseParserMethod {

	static parserUtil pUtil = new parserUtil();
	static Logger log = LogManager.getLogger(baseLoger.class);

	/**
	 * 对外接口，数据解析
	 * 
	 * @param in
	 * @param header
	 * @param body
	 * @return
	 */
	public static boolean Paser(byte[] in) {
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
		// case (short) 0x8801:
		// getMedia(bodyByte, header.totalPackagNumber, header.packageIndex);
		// break;
		case 0x0200:
			dataReport.paserDataReport(bodyByte);
			break;
		// 添加其他数据解析方法
		default:
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
        String serverHost = "115.155.11.61";
        int serverPort = 11011;
        UdpServerSocket udpServerSocket = new UdpServerSocket(serverHost, serverPort);
        
        while (true) {
            String info = udpServerSocket.receive();
            log.info("received info's length: "+info.length());
            new chooseParserMethod();
            
            byte[] in = info.getBytes("ISO-8859-1");
            for (int i = 0; i < in.length; i++) {
				System.out.print(in[i]+" ");
			}
    		chooseParserMethod.Paser(in);
            
        }
    }
}