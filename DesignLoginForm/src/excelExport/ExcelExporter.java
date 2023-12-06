package excelExport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;

public class ExcelExporter {
    public static void exportTable(JTable table, Date fromDate, Date toDate, String employeeName, String fileName, String maxDT, String minDT, String soHD, String tongDT) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet();

        CellStyle titleStyle = workbook.createCellStyle();
        Font titleFont = workbook.createFont();
        titleFont.setBold(true);
        titleFont.setFontHeightInPoints((short) 14); // Cỡ chữ
        titleFont.setColor(IndexedColors.BLUE.getIndex()); // Màu sắc
        titleStyle.setFont(titleFont);
        
        // Add a title row indicating the revenue of the specified employee from fromDate to toDate
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Doanh thu của nhân viên " + employeeName + " từ " +
                new SimpleDateFormat("dd/MM/yyyy").format(fromDate) + " đến " +
                new SimpleDateFormat("dd/MM/yyyy").format(toDate));
        titleCell.setCellStyle(titleStyle);
        // Add a blank row after the title
        sheet.createRow(1);

        // Add header row
        Row headerRow = sheet.createRow(2);
        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(table.getColumnName(i));
        }

        // Add data rows
        for (int i = 0; i < table.getRowCount(); i++) {
            Row row = sheet.createRow(i + 3); // Start from row 3 to leave space for title and blank row
            for (int j = 0; j < table.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(String.valueOf(table.getValueAt(i, j)));
            }
        }
        
        CellStyle bottomStyle = workbook.createCellStyle();
        Font bottomFont = workbook.createFont();
        bottomFont.setBold(true);
        bottomFont.setFontHeightInPoints((short) 10); // Cỡ chữ
        bottomFont.setColor(IndexedColors.RED.getIndex()); // Màu sắc
        bottomStyle.setFont(bottomFont);
        
        Row bottomRow = sheet.createRow(table.getRowCount() + 4);
        Cell max = bottomRow.createCell(0);
        max.setCellValue("Cao nhất:" + maxDT);
        max.setCellStyle(bottomStyle);
        
        Cell min = bottomRow.createCell(2);
        min.setCellValue("Thấp nhất:" + minDT);
        min.setCellStyle(bottomStyle);
        
        Cell soHoaDon = bottomRow.createCell(4);
        soHoaDon.setCellValue("Tổng số hóa đơn:" + soHD);
        soHoaDon.setCellStyle(bottomStyle);
        
        Cell tongDoanhThu = bottomRow.createCell(6);
        tongDoanhThu.setCellValue("Tổng doanh thu:" + tongDT);
        tongDoanhThu.setCellStyle(bottomStyle);

        FileOutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
