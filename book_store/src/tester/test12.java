package tester;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import DAO.nhanvienDAO;
import DTO.nhanvien;

public class test12 {

    public static void main(String[] args) {
        String[] list_ten = { "STT", "Ma nhan vien", "Ten nhan vien", "Gioi tinh", "Dia chi", "Email", "So dien thoai",
                "Chuc vu" };
        nhanvienDAO chucnang = new nhanvienDAO();
        ArrayList<nhanvien> list = chucnang.selecAll();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách nhan vien");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, 7);
        sheet.addMergedRegion(mergedRegion);
        Cell cell_title = row.createCell(0);
        // cjen chu danh sach nhan vien
        cell_title.setCellValue("Danh sach nhan vien");
        CellStyle style = workbook.createCellStyle();
        // can giua cho chu cai
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
        Font font = workbook.createFont(); // create a new font object
        font.setFontHeightInPoints((short) 14); // set the font size to 14
        font.setBold(true); // set the font to bold
        style.setFont(font); // apply the font to the style
        // add style vao cho cell
        // CellStyle borderStyle = workbook.createCellStyle();
        // style.setBorderBottom(CellStyle.BORDER_THIN);
        // style.setBorderTop(CellStyle.BORDER_THICK);
        // style.setBorderBottom(CellStyle.BORDER_THICK);
        // style.setBorderLeft(CellStyle.BORDER_THICK);
        // style.setBorderRight(CellStyle.BORDER_THICK);
        // style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        // style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        // style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        // style.setRightBorderColor(IndexedColors.BLACK.getIndex());

        cell_title.setCellStyle(style);

        // ------------------------
        row = sheet.createRow(1);
        for (int i = 0; i < list_ten.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(list_ten[i]);
        }

        for (int i = 1; i < list.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < 11; j++) {
                Cell cell = row.createCell(j);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(i + 1);
                } else if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(list.get(i).getMa());
                } else if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(list.get(i).getTen());
                } else if (cell.getColumnIndex() == 3) {
                    if (list.get(i).getGioitinh() == 1)
                        cell.setCellValue("Nam");
                    else
                        cell.setCellValue("Nu");
                } else if (cell.getColumnIndex() == 4) {
                    cell.setCellValue(list.get(i).getDiachi());
                } else if (cell.getColumnIndex() == 5) {
                    cell.setCellValue(list.get(i).getEmail());
                } else if (cell.getColumnIndex() == 6) {
                    cell.setCellValue(list.get(i).getSodienthoai());
                } else if (cell.getColumnIndex() == 7) {
                    cell.setCellValue(list.get(i).getChucvu());
                }

            }
        }

        for (int i = 0; i < 9; i++)
            sheet.autoSizeColumn(i);

        // JFileChooser openFileChooser = new JFileChooser();
        // openFileChooser.setDialogTitle("Open File");
        // openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
        // FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file
        // (.xlsx)", "xlsx");
        // openFileChooser.setFileFilter(filter);

        // if (openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        // File inputFile = openFileChooser.getSelectedFile();
        // try (FileOutputStream outputStream = new FileOutputStream(inputFile)) {
        // workbook.write(outputStream);
        // outputStream.close();

        // System.out.println("Tao file thanh cong");
        // } catch (IOException e) {

        // System.out.println("That bai");
        // }
        // }
        // for (int rowIdx = 0; rowIdx < 7; rowIdx++) {
        //     // Row row = sheet.createRow(rowIdx);
        //     for (int colIdx = 0; colIdx < 8; colIdx++) {
        //         // set style to cell
        //         cell.setCellStyle(style);
        //     }
        // }
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save As");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files", "xlsx", "xls");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String fileName = fileToSave.getName();

            if (!fileName.endsWith(".xlsx") && !fileName.endsWith(".xls")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
            }

            // Workbook workbook = new XSSFWorkbook();
            // Sheet sheet = workbook.createSheet("Data Sheet");
            // Row row = sheet.createRow(0);
            // Cell cell = row.createCell(0);
            // cell.setCellValue("Hello world!");

            try {
                FileOutputStream outputStream = new FileOutputStream(fileToSave);
                workbook.write(outputStream);
                workbook.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
        }

    }
}
