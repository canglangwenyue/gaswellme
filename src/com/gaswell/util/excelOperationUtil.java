package com.gaswell.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.ss.usermodel.CellStyle;

import com.gaswell.entity.gw_show;

@SuppressWarnings("deprecation")
public class excelOperationUtil {

	public static boolean readDataToExcelFile(List<gw_show> list) {
		try {
			HSSFWorkbook workbook = new HSSFWorkbook();// 创建Excel工作簿对象
			HSSFSheet sheet = workbook.createSheet();// 在工作簿中创建工作表对象
			// sheet.setColumnWidth(2, 256 * 14);
			// sheet.setColumnWidth(4, 256 * 14);
			for (int i = 0; i < 11; i++) {
				sheet.setColumnWidth(i, 256 * 18);
			}
			workbook.setSheetName(0, "长南项目部");// 设置工作表的名称
			HSSFRow row1 = sheet.createRow(0);// 在工作表中创建行对象
			sheet.addMergedRegion(new Region(0, (short) 0, 0, (short) 10));// 合并第1行的第1个到第5个之间的单元格
			HSSFFont font = workbook.createFont();// 创建字体对象
			font.setColor(HSSFColor.SKY_BLUE.index);// 设置字体颜色
			font.setFontHeightInPoints((short) 14);// 设置字号
			font.setFontName("楷体");// 设置字体样式
			HSSFCellStyle titleStyle = workbook.createCellStyle();
			titleStyle.setFont(font);
			titleStyle.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平居中
			titleStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 设置垂直居中
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setAlignment(CellStyle.ALIGN_CENTER);// 设置水平居中
			cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);// 设置垂直居中
			HSSFCell titleCell = row1.createCell(0);
			titleCell.setCellValue("气井实时数据表");
			titleCell.setCellStyle(titleStyle);
			HSSFRow row2 = sheet.createRow(1);
			HSSFCell nameCell = row2.createCell(0);// 在第1行中创建单元格对象
			nameCell.setCellValue("名称");
			nameCell.setCellStyle(cellStyle);
			HSSFCell sexCell = row2.createCell(1);// 在行中创建单元格对象
			sexCell.setCellValue("时间");
			sexCell.setCellStyle(cellStyle);
			HSSFCell deptCell = row2.createCell(2);// 在行中创建单元格对象
			deptCell.setCellValue("电源电压(V)");
			deptCell.setCellStyle(cellStyle);
			HSSFCell dutyCell = row2.createCell(3);// 在行中创建单元格对象
			dutyCell.setCellValue("油压(MPa)");
			dutyCell.setCellStyle(cellStyle);
			HSSFCell oilCell = row2.createCell(4);// 在行中创建单元格对象
			oilCell.setCellValue("套压(MPa)");
			oilCell.setCellStyle(cellStyle);
			HSSFCell taoCell = row2.createCell(5);// 在行中创建单元格对象
			taoCell.setCellValue("套压(MPa)");
			taoCell.setCellStyle(cellStyle);
			HSSFCell landCell = row2.createCell(6);// 在行中创建单元格对象
			landCell.setCellValue("地面管线压力(MPa)");
			landCell.setCellStyle(cellStyle);
			HSSFCell temperatureCell = row2.createCell(7);// 在行中创建单元格对象
			temperatureCell.setCellValue("温度值('C)");
			temperatureCell.setCellStyle(cellStyle);
			HSSFCell yesterdayFlowCell = row2.createCell(8);// 在行中创建单元格对象
			yesterdayFlowCell.setCellValue("昨日累计流量");
			yesterdayFlowCell.setCellStyle(cellStyle);
			HSSFCell FlowCell = row2.createCell(9);// 在行中创建单元格对象
			FlowCell.setCellValue("累计流量");
			FlowCell.setCellStyle(cellStyle);
			HSSFCell instranceFlowCell = row2.createCell(9);// 在行中创建单元格对象
			instranceFlowCell.setCellValue("瞬时流量");
			instranceFlowCell.setCellStyle(cellStyle);
			HSSFCell blockCell = row2.createCell(10);// 在行中创建单元格对象
			blockCell.setCellValue("截断阀状态");
			blockCell.setCellStyle(cellStyle);
			for (int i = 0; i < list.size(); i++) {
				gw_show gw = list.get(i);
				HSSFRow dataRow = sheet.createRow(i + 2);// 创建行
				HSSFCell name = dataRow.createCell(0);// 创建单元格
				name.setCellValue(gw.getName());// 将数据添加到单元格中
				name.setCellStyle(cellStyle);
				HSSFCell time = dataRow.createCell(1);
				time.setCellValue(gw.getTime());
				time.setCellStyle(cellStyle);
				HSSFCell power = dataRow.createCell(2);
				power.setCellValue(gw.getPower_voltage());
				power.setCellStyle(cellStyle);
				HSSFCell oilPower = dataRow.createCell(3);
				oilPower.setCellValue(gw.getOil_voltage());
				oilPower.setCellStyle(cellStyle);
				HSSFCell taoPower = dataRow.createCell(4);
				taoPower.setCellValue(gw.getTao_voltage());
				taoPower.setCellStyle(cellStyle);
				HSSFCell landPower = dataRow.createCell(5);
				landPower.setCellValue(gw.getLand_voltage());
				landPower.setCellStyle(cellStyle);
				HSSFCell temperature = dataRow.createCell(6);
				temperature.setCellValue(gw.getTemperature());
				temperature.setCellStyle(cellStyle);
				HSSFCell yesterdayFlow = dataRow.createCell(7);
				yesterdayFlow.setCellValue(gw.getYd_flow());
				yesterdayFlow.setCellStyle(cellStyle);
				HSSFCell Flow = dataRow.createCell(8);
				Flow.setCellValue(gw.getTotal_flow());
				Flow.setCellStyle(cellStyle);
				HSSFCell shunshiFlow = dataRow.createCell(9);
				shunshiFlow.setCellValue(gw.getNstantaneous_flow());
				shunshiFlow.setCellStyle(cellStyle);
				HSSFCell status = dataRow.createCell(10);
				status.setCellValue(gw.getSwitch_status());
				status.setCellStyle(cellStyle);
			}
			File xlsFile = new File(
					"C:/Users/canglangwenyue/Desktop/wenyue.xls");
			FileOutputStream fos = new FileOutputStream(xlsFile);
			workbook.write(fos);// 将文档对象写入文件输出流
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		readDataToExcelFile(null);
	}
}
