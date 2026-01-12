package helper;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

    // --- 1. HÀM CHÍNH: Người dùng chỉ cần gọi hàm này ---
    public static void export(JTable table, String defaultName, String title) {
        try {
            File file = chooseFile(defaultName); // Gọi hàm chọn file
            if (file == null) return; // Nếu người dùng hủy chọn thì thôi

            try (Workbook workbook = new XSSFWorkbook(); 
                 FileOutputStream out = new FileOutputStream(file)) {
                
                Sheet sheet = workbook.createSheet("Data");
                
                // Ghi tiêu đề lớn
                writeTitle(sheet, title, table.getColumnCount(), workbook);
                
                // Ghi tên cột (Header)
                writeHeader(sheet, table, workbook);

                // Ghi dữ liệu
                writeData(sheet, table);

                // Tự động chỉnh độ rộng cột
                for (int i = 0; i < table.getColumnCount(); i++) {
                    sheet.autoSizeColumn(i);
                }

                workbook.write(out);
                JOptionPane.showMessageDialog(null, "Xuất file thành công!\nĐường dẫn: " + file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage());
        }
    }

    // --- 2. HÀM PHỤ: Chọn nơi lưu file (Tách ra cho gọn) ---
    private static File chooseFile(String defaultName) {
        JFileChooser chooser = new JFileChooser();
        chooser.setSelectedFile(new File(defaultName + ".xlsx"));
        chooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                file = new File(file.getParentFile(), file.getName() + ".xlsx");
            }
            return file;
        }
        return null;
    }

    // --- 3. HÀM PHỤ: Viết tiêu đề lớn (In đậm, to, giữa) ---
    private static void writeTitle(Sheet sheet, String title, int colCount, Workbook wb) {
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue(title.toUpperCase());

        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        font.setColor(IndexedColors.BLUE.getIndex());
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        
        cell.setCellStyle(style);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, colCount - 1));
    }

    // --- 4. HÀM PHỤ: Viết dòng tiêu đề cột ---
    private static void writeHeader(Sheet sheet, JTable table, Workbook wb) {
        Row row = sheet.createRow(2); // Dòng thứ 3 (index 2)
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBold(true);
        style.setFont(font);

        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(table.getColumnName(i));
            cell.setCellStyle(style);
        }
    }

    // --- 5. HÀM PHỤ: Viết dữ liệu từ bảng ---
    private static void writeData(Sheet sheet, JTable table) {
        TableModel model = table.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            Row row = sheet.createRow(i + 3); // Bắt đầu từ dòng 4
            for (int j = 0; j < model.getColumnCount(); j++) {
                Object value = model.getValueAt(i, j);
                row.createCell(j).setCellValue(value != null ? value.toString() : "");
            }
        }
    }
}