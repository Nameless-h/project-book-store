package BUS;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.table.*;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.khachhangDAO;
import DTO.khachhang;

public class quanlikhachhang {
    // hien thi danh sach khach hang
    khachhangDAO chucang_khachhang = new khachhangDAO();
    ArrayList<khachhang> list = chucang_khachhang.selecAll();

    public void hienthidanhsach_khachhang(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 1; i < list.size(); i++) {
            String gt;
            if (list.get(i).getGioitinh() == 1)
                gt = "Nam";
            else
                gt = "Nu";
            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                    list.get(i).getDiem(), list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void themkhachhang(khachhang kh) {
        list.add(kh);
        chucang_khachhang.insert(kh);
    }

    public void suathongtinkhachhang(khachhang kh) {
        chucang_khachhang.update(kh);
    }

    public ArrayList<khachhang> getListKH() {
        return this.list;
    }

    public ArrayList<khachhang> searchKH(String query) {
        ArrayList<khachhang> resultList = new ArrayList<khachhang>();
        list.forEach((kh) -> {
            if (String.valueOf(kh.getMa()).contains(query) ||
                    kh.getTen().toLowerCase().contains(query.toLowerCase()) ||
                    kh.getEmail().toLowerCase().contains(query.toLowerCase()) ||
                    kh.getSodienthoai().contains(query)) {
                resultList.add(kh);
            }
        });
        return resultList;
    }

    public khachhang getKhachHang(int makh) {
        for (khachhang kh : list) {
            if (kh.getMa() == makh)
                return kh;
        }
        return null;
    }

    public boolean timkiem_vitri(int tk, String str, JTable table) {
        boolean kiemtra = false;
        if (tk == 0) {
            hienthidanhsach_khachhang(table);
            kiemtra = true;
        }
        if (tk == 1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int temp = Integer.parseInt(str);
            for (int i = 0; i < list.size(); i++) {
                if (temp == list.get(i).getMa()) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 2) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).getTen())) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 3) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int gt1;
            if (str.equalsIgnoreCase("Nam"))
                gt1 = 1;
            else
                gt1 = 0;
            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (gt1 == list.get(i).getGioitinh()) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 4) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).getDiachi())) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 5) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).getEmail())) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 6) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).getSodienthoai())) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getDiem(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }

        return kiemtra;
    }

    public void updateDiem(int makh, int diem) {
        for (khachhang kh : this.list) {
            if (kh.getMa() == makh) {
                kh.setDiem(diem);
                chucang_khachhang.update(kh);
                break;
            }
        }
    }

    public void xuatds_excel() {
        String[] list_ten = { "STT",
                "Ma khach hang",
                "Ten", "Gioi tinh",
                "Dia chi",
                "Email",
                "SDT",
                "Diem tich luy",
                "Tinh trang" };
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách khach hang");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, list_ten.length);
        sheet.addMergedRegion(mergedRegion);
        Cell cell_title = row.createCell(0);
        // cjen chu danh sach nhan vien
        cell_title.setCellValue("Danh sach khach hang");
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

        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i + 2);
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
                    cell.setCellValue(list.get(i).getDiem());
                } else if (cell.getColumnIndex() == 8) {
                    cell.setCellValue(list.get(i).getTinhtrang());
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

    public ArrayList<khachhang> get_by_excel() {
        ArrayList<khachhang> list = new ArrayList<khachhang>();
        String title;
        String gt_str;
        ArrayList<String> header = new ArrayList<>();
        ArrayList<Integer> stt = new ArrayList<>();
        JFileChooser openFileChooser = new JFileChooser();
        openFileChooser.setDialogTitle("Open File");
        openFileChooser.removeChoosableFileFilter(openFileChooser.getFileFilter());
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel file (.xlsx)", "xlsx");
        openFileChooser.setFileFilter(filter);

        if (openFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File inputFile = openFileChooser.getSelectedFile();
            try (FileInputStream in = new FileInputStream(inputFile)) {

                XSSFWorkbook imporetedfile = new XSSFWorkbook(in);
                XSSFSheet sheet1 = imporetedfile.getSheetAt(0);

                Iterator<Row> rowiterator = sheet1.iterator();

                while (rowiterator.hasNext()) {
                    Row row = rowiterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    khachhang kh = new khachhang();
                    while (cellIterator.hasNext()) {

                        Cell cell = cellIterator.next();
                        if (row.getRowNum() == 0)
                            title = cell.getStringCellValue();
                        else if (row.getRowNum() == 1)
                            header.add(cell.getStringCellValue());
                        else {
                            if (cell.getColumnIndex() == 0) {
                                stt.add((int) cell.getNumericCellValue());
                            } else if (cell.getColumnIndex() == 1) {
                                kh.setMa((int) cell.getNumericCellValue());
                            } else if (cell.getColumnIndex() == 2) {
                                kh.setTen(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 3) {
                                gt_str = (cell.getStringCellValue());
                                if (gt_str.equalsIgnoreCase("Nam"))
                                    kh.setGioitinh(1);
                                else
                                    kh.setGioitinh(0);
                            } else if (cell.getColumnIndex() == 4) {
                                kh.setDiachi(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 5) {
                                kh.setEmail(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 6) {
                                kh.setSodienthoai(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 7) {
                                kh.setDiem((int) cell.getNumericCellValue());
                            } else if (cell.getColumnIndex() == 8) {
                                kh.setTinhtrang((int) cell.getNumericCellValue());
                            }

                            list.add(kh);
                        }
                    }

                }

            } catch (IOException e) {
                System.out.println("That bai");
            }
        }
        return list;
    }

    public void update_by_excel() {
        list = chucang_khachhang.selecAll();
        ArrayList<khachhang> list_temp = get_by_excel();
        for (int i = 0; i < list_temp.size(); i++) {
            int kt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list_temp.get(i).getMa() == list.get(j).getMa())
                    kt = 1;
            }
            if (kt == 1)
                chucang_khachhang.update(list_temp.get(i));
            else
                chucang_khachhang.insert(list_temp.get(i));
        }
    }
}
