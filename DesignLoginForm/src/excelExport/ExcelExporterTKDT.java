package excelExport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

public class ExcelExporterTKDT {
	public static void exportTable(JTable table, Date fromDate, Date toDate, String fileName, String soHD,
			String tongDT) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet();

		CellStyle titleStyle = workbook.createCellStyle();
		Font titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleFont.setFontHeightInPoints((short) 14);
		titleFont.setColor(IndexedColors.BLUE.getIndex());
		titleStyle.setFont(titleFont);

		Row titleRow = sheet.createRow(0);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("Doanh thu tu:" + new SimpleDateFormat("dd/MM/yyyy").format(fromDate) + "den "
				+ new SimpleDateFormat("dd/MM/yyyy").format(toDate));
		titleCell.setCellStyle(titleStyle);
		// Add a blank row after the title
		sheet.createRow(1);

		// add header row
		Row headerRow = sheet.createRow(2);
		for (int i = 0; i < table.getColumnCount(); i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(table.getColumnName(i));
		}

		for (int i = 0; i < table.getRowCount(); i++) {
			Row row = sheet.createRow(i + 3); // Start from row 3 to leave space for title and blank row
			for (int j = 0; j < table.getColumnCount(); j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(String.valueOf(table.getValueAt(i, j)));
			}
		}
		
		FileOutputStream outputStream = new FileOutputStream(fileName);
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}
}
