package BUS;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.nhacungcapDAO;
import DTO.nhacungcap;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class quanlinhacungcap {
    nhacungcapDAO nccdao = new nhacungcapDAO();
    ArrayList<nhacungcap> listncc = new ArrayList<nhacungcap>();

    public void initList() {
        this.listncc = nccdao.list();
    }

    public ArrayList<nhacungcap> getList() {
        return this.listncc;
    }

    public void hienthidanhsach_ncc(JTable table) {

        listncc = nccdao.list();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < listncc.size(); i++) {
            model.addRow(new Object[] { i + 1, listncc.get(i).getMa(), listncc.get(i).getTen(),
                    listncc.get(i).getDiaChi(), listncc.get(i).getEmail(), listncc.get(i).getSDT() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void hienthidanhsach_ncc_timkiem(JTable table, ArrayList<nhacungcap> listtk) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < listtk.size(); i++) {
            model.addRow(new Object[] { i + 1, listtk.get(i).getMa(), listtk.get(i).getTen(),
                    listtk.get(i).getDiaChi(), listtk.get(i).getEmail(), listtk.get(i).getSDT() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void themnhacungcap(nhacungcap ncc) {
        listncc.add(ncc);
        nccdao.insert(ncc);
    }

    public void suanhacungcap(nhacungcap ncc) {
        nccdao.update(ncc);
    }

    public ArrayList<nhacungcap> searchNCC(String query) {
        ArrayList<nhacungcap> resultList = new ArrayList<nhacungcap>();
        listncc.forEach((ncc) -> {
            if (String.valueOf(ncc.getMa()).contains(query) ||
                    ncc.getTen().toLowerCase().contains(query.toLowerCase()) ||
                    ncc.getEmail().toLowerCase().contains(query.toLowerCase()) ||
                    ncc.getSDT().contains(query)) {
                resultList.add(ncc);
            }
        });
        return resultList;
    }

    public nhacungcap getNCC(int ma) {
        for (nhacungcap ncc : listncc) {
            if (ncc.getMa() == ma) {
                return ncc;
            }
        }
        return null;
    }

    public boolean timkiem_vitri(int vitri, String str, JTable table) {
        boolean kiemtra = false;
        ArrayList<nhacungcap> resultList = new ArrayList<nhacungcap>();
        resultList = searchNCC(str);
        if (vitri == 0) {
            hienthidanhsach_ncc(table);
            kiemtra = true;
        } else
            hienthidanhsach_ncc_timkiem(table, resultList);
        return kiemtra;
    }

    public void xuatds_excel() {
        String[] list_ten = { "STT",
                "Ma nha cung cap",
                "Ten",
                "Dia chi",
                "Email",
                "SDT",
        };
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách nha cung cap");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, list_ten.length);
        sheet.addMergedRegion(mergedRegion);
        Cell cell_title = row.createCell(0);
        // cjen chu danh sach nhan vien
        cell_title.setCellValue("Danh sach nha cung cap");
        CellStyle style = workbook.createCellStyle();
        // can giua cho chu cai
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_BOTTOM);
        Font font = workbook.createFont(); // create a new font object
        font.setFontHeightInPoints((short) 14); // set the font size to 14
        font.setBold(true); // set the font to bold
        style.setFont(font); // apply the font to the style

        cell_title.setCellStyle(style);

        // ------------------------
        row = sheet.createRow(1);
        for (int i = 0; i < list_ten.length; i++) {
            Cell cell = row.createCell(i);
            cell.setCellValue(list_ten[i]);
        }

        for (int i = 1; i < listncc.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < 11; j++) {
                Cell cell = row.createCell(j);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(i + 1);
                } else if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(listncc.get(i).getMa());
                } else if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(listncc.get(i).getTen());
                } else if (cell.getColumnIndex() == 3) {
                    cell.setCellValue(listncc.get(i).getDiaChi());
                } else if (cell.getColumnIndex() == 4) {
                    cell.setCellValue(listncc.get(i).getEmail());
                } else if (cell.getColumnIndex() == 5) {
                    cell.setCellValue(listncc.get(i).getSDT());
                }
            }
        }

        for (int i = 0; i < 9; i++)
            sheet.autoSizeColumn(i);

        // chon file luu thong tin
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
