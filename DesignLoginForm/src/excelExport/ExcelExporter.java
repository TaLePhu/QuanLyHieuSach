package excelExport;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTable;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelExporter {
    public static void exportTable(JTable table, Date fromDate, Date toDate, String employeeName, String fileName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet();

        // Add a title row indicating the revenue of the specified employee from fromDate to toDate
        Row titleRow = sheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("Doanh thu của nhân viên " + employeeName + " từ " +
                new SimpleDateFormat("dd/MM/yyyy").format(fromDate) + " đến " +
                new SimpleDateFormat("dd/MM/yyyy").format(toDate));

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

        FileOutputStream outputStream = new FileOutputStream(fileName);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
