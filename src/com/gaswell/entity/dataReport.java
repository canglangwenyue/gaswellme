package com.gaswell.entity;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.gaswell.dao.BodyBase;
import com.gaswell.util.baseLoger;
import com.gaswell.util.parserUtil;

public class dataReport extends BodyBase {

	// 基本信息帧
	private byte baseBpsType;
	private byte redAlarmTag;
	private float systemPower;
	private byte[] remainBytes;

	// 压力数据帧
	private byte pressureFpsType;
	private byte presureNumber;
	private byte pressureJudageEffective;
	private float pressureData;

	// 气象流量数据帧
	private byte gasFpsType;
	private byte gasNumber;
	private byte gasJudageEffective;
	private float gasPressure;
	private float gasTemperature;
	private float gasInstantFlow;
	private float gasWorkflow;
	private double gasTotalFlow;

	// 截断阀流量数据帧
	private byte blockFpsType;
	private byte blockNumber;
	private byte blockJudageEffective;
	private byte blockStatus;

	// 气液两相流量数据帧
	private byte liquidFpsType;
	private byte liquidNumber;
	private byte liquidJudageEffective;
	private float liquidPressure;
	private float liquidTemperature;
	private float liquidInstantGasFlow;
	private double liquidTotalGasFlow;
	private float liquidInstantLiquidFlow;
	private double liquidTotalLiquidFlow;

	public dataReport() {
	}

	public dataReport(byte pressureJudageEffective, float pressureData) {

		this.pressureJudageEffective = pressureJudageEffective;
		this.pressureData = pressureData;

	}

	public dataReport(byte gasJudageEffective, float gasPressure,
			float gasTemperature, float gasInstantFlow, float gasWorkflow,
			double gasTotalFlow) {

		this.gasJudageEffective = gasJudageEffective;
		this.gasPressure = gasPressure;
		this.gasTemperature = gasTemperature;
		this.gasInstantFlow = gasInstantFlow;
		this.gasWorkflow = gasWorkflow;
		this.gasTotalFlow = gasTotalFlow;

	}

	public dataReport(byte blockJudageEffective, byte blockStatus) {
		this.blockJudageEffective = blockJudageEffective;
		this.blockStatus = blockStatus;
	}

	public dataReport(byte liquidJudageEffective, float liquidPressure,
			float liquidTemperature, float liquidInstantGasFlow,
			double liquidTotalGasFlow, float liquidInstantLiquidFlow,
			double liquidTotalLiquidFlow) {

		this.liquidJudageEffective = liquidJudageEffective;
		this.liquidPressure = liquidPressure;
		this.liquidTemperature = liquidTemperature;
		this.liquidInstantGasFlow = liquidInstantGasFlow;
		this.liquidTotalGasFlow = liquidTotalGasFlow;
		this.liquidInstantLiquidFlow = liquidInstantLiquidFlow;
		this.liquidTotalLiquidFlow = liquidTotalLiquidFlow;

	}

	public byte getBaseBpsType() {
		return baseBpsType;
	}

	public void setBaseBpsType(byte baseBpsType) {
		this.baseBpsType = baseBpsType;
	}

	public byte getRedAlarmTag() {
		return redAlarmTag;
	}

	public void setRedAlarmTag(byte redAlarmTag) {
		this.redAlarmTag = redAlarmTag;
	}

	public float getSystemPower() {
		return systemPower;
	}

	public void setSystemPower(float systemPower) {
		this.systemPower = systemPower;
	}

	public byte[] getRemainBytes() {
		return remainBytes;
	}

	public void setRemainBytes(byte[] remainBytes) {
		this.remainBytes = remainBytes;
	}

	public byte getPressureFpsType() {
		return pressureFpsType;
	}

	public void setPressureFpsType(byte pressureFpsType) {
		this.pressureFpsType = pressureFpsType;
	}

	public byte getPresureNumber() {
		return presureNumber;
	}

	public void setPresureNumber(byte presureNumber) {
		this.presureNumber = presureNumber;
	}

	public byte getPressureJudageEffective() {
		return pressureJudageEffective;
	}

	public void setPressureJudageEffective(byte pressureJudageEffective) {
		this.pressureJudageEffective = pressureJudageEffective;
	}

	public float getPressureData() {
		return pressureData;
	}

	public void setPressureData(float pressureData) {
		this.pressureData = pressureData;
	}

	public byte getGasFpsType() {
		return gasFpsType;
	}

	public void setGasFpsType(byte gasFpsType) {
		this.gasFpsType = gasFpsType;
	}

	public byte getGasNumber() {
		return gasNumber;
	}

	public void setGasNumber(byte gasNumber) {
		this.gasNumber = gasNumber;
	}

	public byte getGasJudageEffective() {
		return gasJudageEffective;
	}

	public void setGasJudageEffective(byte gasJudageEffective) {
		this.gasJudageEffective = gasJudageEffective;
	}

	public float getGasPressure() {
		return gasPressure;
	}

	public void setGasPressure(float gasPressure) {
		this.gasPressure = gasPressure;
	}

	public float getGasTemperature() {
		return gasTemperature;
	}

	public void setGasTemperature(float gasTemperature) {
		this.gasTemperature = gasTemperature;
	}

	public float getGasInstantFlow() {
		return gasInstantFlow;
	}

	public void setGasInstantFlow(float gasInstantFlow) {
		this.gasInstantFlow = gasInstantFlow;
	}

	public float getGasWorkflow() {
		return gasWorkflow;
	}

	public void setGasWorkflow(float gasWorkflow) {
		this.gasWorkflow = gasWorkflow;
	}

	public double getGasTotalFlow() {
		return gasTotalFlow;
	}

	public void setGasTotalFlow(double gasTotalFlow) {
		this.gasTotalFlow = gasTotalFlow;
	}

	public byte getBlockFpsType() {
		return blockFpsType;
	}

	public void setBlockFpsType(byte blockFpsType) {
		this.blockFpsType = blockFpsType;
	}

	public byte getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(byte blockNumber) {
		this.blockNumber = blockNumber;
	}

	public byte getBlockJudageEffective() {
		return blockJudageEffective;
	}

	public void setBlockJudageEffective(byte blockJudageEffective) {
		this.blockJudageEffective = blockJudageEffective;
	}

	public byte getBlockStatus() {
		return blockStatus;
	}

	public void setBlockStatus(byte blockStatus) {
		this.blockStatus = blockStatus;
	}

	public byte getLiquidFpsType() {
		return liquidFpsType;
	}

	public void setLiquidFpsType(byte liquidFpsType) {
		this.liquidFpsType = liquidFpsType;
	}

	public byte getLiquidNumber() {
		return liquidNumber;
	}

	public void setLiquidNumber(byte liquidNumber) {
		this.liquidNumber = liquidNumber;
	}

	public byte getLiquidJudageEffective() {
		return liquidJudageEffective;
	}

	public void setLiquidJudageEffective(byte liquidJudageEffective) {
		this.liquidJudageEffective = liquidJudageEffective;
	}

	public float getLiquidPressure() {
		return liquidPressure;
	}

	public void setLiquidPressure(float liquidPressure) {
		this.liquidPressure = liquidPressure;
	}

	public float getLiquidTemperature() {
		return liquidTemperature;
	}

	public void setLiquidTemperature(float liquidTemperature) {
		this.liquidTemperature = liquidTemperature;
	}

	public float getLiquidInstantGasFlow() {
		return liquidInstantGasFlow;
	}

	public void setLiquidInstantGasFlow(float liquidInstantGasFlow) {
		this.liquidInstantGasFlow = liquidInstantGasFlow;
	}

	public double getLiquidTotalGasFlow() {
		return liquidTotalGasFlow;
	}

	public void setLiquidTotalGasFlow(double liquidTotalGasFlow) {
		this.liquidTotalGasFlow = liquidTotalGasFlow;
	}

	public float getLiquidInstantLiquidFlow() {
		return liquidInstantLiquidFlow;
	}

	public void setLiquidInstantLiquidFlow(float liquidInstantLiquidFlow) {
		this.liquidInstantLiquidFlow = liquidInstantLiquidFlow;
	}

	public double getLiquidTotalLiquidFlow() {
		return liquidTotalLiquidFlow;
	}

	public void setLiquidTotalLiquidFlow(double liquidTotalLiquidFlow) {
		this.liquidTotalLiquidFlow = liquidTotalLiquidFlow;
	}

	public static dataReport paserDataReport(byte[] in) {

		System.out.println("\n");
		byte[] temp = null;
		byte[] floatbytes = null;
		byte[] doublebytes = null;
		dataReport data = new dataReport();

		// 基本信息帧
		data.setBaseBpsType(in[0]);
		data.setRedAlarmTag(in[1]);
		temp = new byte[4];
		System.arraycopy(in, 2, temp, 0, 4);
		data.setSystemPower(parserUtil.getFloat(temp));
		System.arraycopy(in, 6, temp, 0, 4);
		data.setRemainBytes(temp);

		// 压力数据帧
		data.setPressureFpsType(in[10]);
		data.setPresureNumber(in[11]);
		dataReport[] pressureDataReports = new dataReport[data
				.getPresureNumber()];
		temp = new byte[data.getPresureNumber() * 5 + 2];
		System.arraycopy(in, 10, temp, 0, (data.getPresureNumber() * 5 + 2));
		Logger log = LogManager.getLogger(baseLoger.class);
		log.info("pressure message:");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		for (int i = 0; i < data.getPresureNumber(); i++) {
			if (temp[5 * i + 2] == 1) {
				for (int j = 0; j < pressureDataReports.length; j++)
					pressureDataReports[j] = new dataReport();
				pressureDataReports[i]
						.setPressureJudageEffective(temp[5 * i + 2]);
				floatbytes = new byte[4];
				System.arraycopy(temp, 5 * i + 3, floatbytes, 0, 4);
				pressureDataReports[i].setPressureData(parserUtil
						.getFloat(floatbytes));
			} else if (temp[5 * i + 2] == 0) {
				System.out.println("无效的压力表数据");
			}
		}

		//气相流量数据帧
		data.setGasFpsType(in[10+data.getPresureNumber()*5+2]);
		data.setGasNumber(in[10+data.getPresureNumber()*5+2]);
		dataReport[] gasDataReport = new dataReport[data.getGasNumber()];
		temp = new byte[data.getGasNumber()*25+2];
		System.arraycopy(in, (10+data.getPresureNumber()*5+2), temp, 0, data.getGasNumber()*25+2);
		log.info("\n");
		log.info("Gas message:");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		for (int i = 0; i < data.getGasNumber(); i++) {
			if (temp[25*i+2]==1) {
				for (int j = 0; j < gasDataReport.length; j++) 
					gasDataReport[j] = new dataReport();
				gasDataReport[i].setPressureJudageEffective(temp[25*i+2]);
				floatbytes = new byte[4];
				doublebytes = new byte[8];
				System.arraycopy(temp, 25*i+3, floatbytes, 0, 4);
				gasDataReport[i].setGasPressure(parserUtil.getFloat(floatbytes)/1000);
				System.arraycopy(temp, 25*i+7, floatbytes, 0, 4);
				gasDataReport[i].setGasTemperature(parserUtil.getFloat(floatbytes));
				System.arraycopy(temp, 25*i+11, floatbytes, 0, 4);
				gasDataReport[i].setGasInstantFlow(parserUtil.getFloat(floatbytes));
				System.arraycopy(temp, 25*i+15, floatbytes, 0, 4);
				gasDataReport[i].setGasWorkflow(parserUtil.getFloat(floatbytes));
				System.arraycopy(temp, 25*i+19, doublebytes, 0, 8);
				gasDataReport[i].setGasTotalFlow(parserUtil.getDouble(doublebytes));
			}else if (temp[25*i+2]==1) {
				System.out.println("无效的气相流量数据帧数据");
			}
		}
		
		//截断阀数据帧
		data.setBlockFpsType(in[10+data.getPresureNumber()*5+2+data.getGasNumber()*25+2]);
		data.setBlockNumber(in[10+data.getPresureNumber()*5+2+data.getGasNumber()*25+3]);
		dataReport[]blockDataReport = new dataReport[data.getBlockNumber()];
		for (int i = 0; i < blockDataReport.length; i++) 
			blockDataReport[i] = new dataReport();
			
		temp = new byte[data.getBlockNumber()*2+2];
		System.arraycopy(in,  (10+data.getPresureNumber()*5+2+data.getGasNumber()*25+2), temp, 0, data.getBlockNumber()*2+2);
		log.info("\n");
		log.info("block message:");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " ");
		}
		for (int i = 0; i < data.getBlockNumber(); i++) {
			blockDataReport[i].setBlockJudageEffective(temp[2*i+2]);
			if (temp[2*i+2]==1) {
				 blockDataReport[i].setBlockStatus(temp[2*i+3]);
			}else if (temp[2*i+2]==0) {
				 blockDataReport[i].setBlockStatus(temp[2*i+3]);
			}
		}
		
		
		//气液两相流量数据帧
		return null;

	}
}
