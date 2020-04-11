package com.dms.oa.base;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Excelopertion {

	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		deleteFile("d:\\test.xls");
		//excelWrite("d:\\test.xls", list);

	}

	public static void excelWrite(String filepath,
			List<Map<String, Object>> list,String[] title) {
		try {
			deleteFile(filepath);
			// 打开文件
			WritableWorkbook book = Workbook.createWorkbook(new File(filepath));
			// 生成名为“第一页”的工作表，参数0表示这是第一页
			WritableSheet sheet = book.createSheet(" 第一页 ", 0);
			//String[] title = { "项目名称", "员工姓名", "消耗工时" };
			Label labelh;
			for (int i = 0; i < title.length; i++) {
				// Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
				// 在Label对象的子对象中指明单元格的位置和内容
				labelh = new Label(i, 0, title[i]);
				labelh = new Label(i, 0, title[i], getHeader());
				// 将定义好的单元格添加到工作表中
				sheet.addCell(labelh);
			}

			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = new HashMap();
				map = list.get(i);
				int j = 0;
				for (String key : map.keySet()) {
					if (map.get(key).getClass() == String.class) {
						// System.out.println("key= "+ key + " and value= " +
						// map.get(key));
						Label label = new Label(j, i + 1,
								(String) map.get(key), getBody());// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
																	// 以及单元格内容为test
						sheet.addCell(label);// 将定义好的单元格添加到工作表中
					} else {
						jxl.write.Number number = new jxl.write.Number(j,
								i + 1, (Double) map.get(key), getBody());
						sheet.addCell(number);
					}
					//
					j++;
				}

			}

			/*
			 * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
			 */

			// 写入数据并关闭文件
			book.write();
			book.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public static void excelWritebyList(String filepath,
			List<List<String>> list,String[] title) {
		try {
			deleteFile(filepath);
			
			WritableWorkbook book = Workbook.createWorkbook(new FileOutputStream(filepath));
			WritableSheet sheet = book.createSheet(" 第一页 ", 0);
			Label labelh;
			for (int i = 0; i < title.length; i++) {
				labelh = new Label(i, 0, title[i]);
				labelh = new Label(i, 0, title[i], getHeader());
				sheet.addCell(labelh);
			}
			for (int i = 0; i < list.size(); i++) {
				List<String> strlist = new ArrayList();
				strlist = list.get(i);
				
				for(int j=0;j<strlist.size();j++){
					Label label = new Label(j, i + 1,strlist.get(j), getBody());
					sheet.addCell(label);// 将定义好的单元格添加到工作表中
				}
			}
			book.write();
			book.close();
			

            

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static WritableCellFormat getHeader() {
		WritableFont font = new WritableFont(WritableFont.TIMES, 10,
				WritableFont.BOLD);// 定义字体
		try {
			font.setColour(Colour.BLACK);// 蓝色字体
		} catch (WriteException e1) {
			// TODO 自动生成 catch 块
			e1.printStackTrace();
		}
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);// 黑色边框
			format.setBackground(Colour.GREY_25_PERCENT);//黄色背景
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}

	
	public static WritableCellFormat getBody() {
		WritableFont font = new WritableFont(WritableFont.TIMES, 10,
				WritableFont.NO_BOLD);// 定义字体
		try {
			font.setColour(Colour.BLACK);// 蓝色字体
		} catch (WriteException e1) {
			// TODO 自动生成 catch 块
			e1.printStackTrace();
		}
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
			format.setBorder(Border.ALL, BorderLineStyle.THIN, Colour.BLACK);// 黑色边框
			// format.setBackground(Colour.YELLOW);//黄色背景
		} catch (WriteException e) {
			// TODO 自动生成 catch 块
			e.printStackTrace();
		}
		return format;
	}
	
	public static boolean deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

}
