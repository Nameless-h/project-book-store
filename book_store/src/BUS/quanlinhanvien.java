package BUS;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import DAO.nhanvienDAO;
import DTO.*;

public class quanlinhanvien {
    nhanvienDAO chucnang_nhanvien = new nhanvienDAO();
    ArrayList<nhanvien> list = chucnang_nhanvien.selecAll();

    public String tennhanvien(int manv) {
        for (int i = 0; i < list.size(); i++) {
            if (manv == (list.get(i).getMa()))
                return list.get(i).getTen();
        }
        return null;
    }

    public nhanvien getNhanVien(int manv) {
        for (nhanvien nv : this.list) {
            if (nv.getMa() == manv) {
                return nv;
            }
        }
        return null;
    }

    // hien thi danh sach len 1 table duoc truyen va/
    public void hienthidanhsach_nhanvien(JTable table) {
        list = chucnang_nhanvien.selecAll();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {
            String gt;
            if (list.get(i).getGioitinh() == 1)
                gt = "Nam";
            else
                gt = "Nu";
            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                    list.get(i).getChucvu(), list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void themnhanvien(nhanvien nv) {
        list.add(nv);
        chucnang_nhanvien.insert(nv);
    }

    public void suathongtinnhanvien(nhanvien nv) {
        chucnang_nhanvien.update(nv);
    }

    public Integer[] danhsachmanhanvien() {
        Integer[] list_ds = new Integer[list.size()];
        for (int i = 0; i < list_ds.length; i++)
            list_ds[i] = list.get(i).getMa();
        return list_ds;
    }

    public ArrayList<Integer> danhsachmanhanvien_tt() {
        ArrayList<Integer> list_ds = new ArrayList<Integer>();
        int dem = 0;
        for (int i = 0; i < list.size(); i++)
            if (list.get(i).getTinhtrang() == 1) {
                list_ds.add(list.get(i).getMa());
            }
        return list_ds;
    }

    public boolean timkiem_vitri(int tk, String str, JTable table) {
        boolean kiemtra = false;
        if (tk == 0) {
            hienthidanhsach_nhanvien(table);
            kiemtra = true;
        }
        if (tk == 1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int temp = Integer.parseInt(str);
            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (temp == list.get(i).getMa()) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
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
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
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
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
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
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
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
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
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
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 7) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (str.equalsIgnoreCase(list.get(i).getChucvu())) {
                    String gt;
                    if (list.get(i).getGioitinh() == 1)
                        gt = "Nam";
                    else
                        gt = "Nu";
                    model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                            list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                            list.get(i).getChucvu(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }

        return kiemtra;
    }

    public void xuatds_excel() {
        String[] list_ten = { "STT", "Ma nhan vien", "Ten nhan vien", "Gioi tinh", "Dia chi", "Email", "So dien thoai",
                "Chuc vu", "Tinh trang" };
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Danh sách nhan vien");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, list_ten.length);
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
                    cell.setCellValue(list.get(i).getChucvu());
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

    public void nutxoa(int manv, JTable table) {
        chucnang_nhanvien.update_tt(manv, 0);
        hienthidanhsach_nhanvien(table);
    }

    public ArrayList<nhanvien> get_by_excel() {
        ArrayList<nhanvien> list = new ArrayList<nhanvien>();
        ArrayList<nhanvien> listErr = new ArrayList<nhanvien>();
        String title;
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

                kiemTraInput check = new kiemTraInput();
                int ma = 0, tt = 0;
                String ten = "", dc = "", email = "", sdt = "", cv = "", gt_str = "";
                while (rowiterator.hasNext()) {
                    Row row = rowiterator.next();
                    Iterator<Cell> cellIterator = row.cellIterator();
                    nhanvien nv = new nhanvien();

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
                                ma = (int) cell.getNumericCellValue();
                                nv.setMa((int) cell.getNumericCellValue());
                            } else if (cell.getColumnIndex() == 2) {
                                ten = cell.getStringCellValue();
                                nv.setTen(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 3) {
                                gt_str = (cell.getStringCellValue());
                                if (gt_str.equalsIgnoreCase("Nam"))
                                    nv.setGioitinh(1);
                                else
                                    nv.setGioitinh(0);
                            } else if (cell.getColumnIndex() == 4) {
                                dc = cell.getStringCellValue();
                                nv.setDiachi(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 5) {
                                email = cell.getStringCellValue();
                                nv.setEmail(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 6) {
                                sdt = cell.getStringCellValue();
                                nv.setSodienthoai(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 7) {
                                cv = cell.getStringCellValue();
                                nv.setChucvu(cell.getStringCellValue());
                            } else if (cell.getColumnIndex() == 8) {
                                tt = (int) cell.getNumericCellValue();
                                nv.setTinhtrang((int) cell.getNumericCellValue());
                            }

                            if (ma == 0 || tt == 0 ||
                                    ten.isEmpty() ||
                                    gt_str.isEmpty() ||
                                    dc.isEmpty() ||
                                    email.isEmpty() ||
                                    sdt.isEmpty() ||
                                    cv.isEmpty()) {
                                listErr.add(nv);
                            } else
                                list.add(nv);
                            System.out.println(listErr);
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
        list = chucnang_nhanvien.selecAll();
        ArrayList<nhanvien> list_temp = get_by_excel();
        for (int i = 0; i < list_temp.size(); i++) {
            int kt = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list_temp.get(i).getMa() == list.get(j).getMa())
                    kt = 1;
            }
            if (kt == 1)
                chucnang_nhanvien.update(list_temp.get(i));
            else
                chucnang_nhanvien.insert(list_temp.get(i));
        }
    }
}
