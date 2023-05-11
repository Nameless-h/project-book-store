package BUS;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import DAO.quanlihoadonbanhangDAO;
import DTO.hoadonbanhang;

public class quanlihoadonbanhang {
    private quanlikhachhang qlkh = new quanlikhachhang();
    private quanlinhanvien qlnv = new quanlinhanvien(); 
    private ArrayList<hoadonbanhang> listhdbh = new ArrayList<hoadonbanhang>();

    public void initList() {
        quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
        this.listhdbh = qlhdbhdao.list();
    }

    public Boolean themHoaDon(hoadonbanhang hd) {
        if(hd != null) {
            listhdbh.add(hd);
            quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
            qlhdbhdao.themHoaDon(hd);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Hóa đơn không hợp lệ!","Thông báo",1);
            return false;
        }
    }

    public int getNextID() {
        quanlihoadonbanhangDAO qlhdbhdao = new quanlihoadonbanhangDAO();
        return qlhdbhdao.getNextID();
    }

    public ArrayList<hoadonbanhang> getList() {
        return this.listhdbh;
    }

    public ArrayList<hoadonbanhang> searchHoadonbanhang(String query,String datefrom,String dateto) {
        ArrayList<hoadonbanhang> resultList = new ArrayList<hoadonbanhang>();
        if(datefrom.equals("") && dateto.equals("")) {
            this.listhdbh.forEach((hdbh) -> {
                    if(qlkh.getKhachHang(hdbh.getMakh()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                        qlnv.getNhanVien(hdbh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                        String.valueOf(hdbh.getmahd()).equals(query) ||
                        String.valueOf(hdbh.getMakh()).equals(query)) {
                            resultList.add(hdbh);
                    }
            });
        } else {
            Date date1;
            Date date2;
            try {
                date1 = new SimpleDateFormat("yyyy-MM-dd").parse(datefrom);
                date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateto);
                if(date1.after(date2)) {
                    return null;
                } else {
                    this.listhdbh.forEach((hdbh) -> {
                        try {
                            Date ngay = new SimpleDateFormat("yyyy-MM-dd").parse(hdbh.getngay());
                            if((qlkh.getKhachHang(hdbh.getMakh()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                qlnv.getNhanVien(hdbh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                String.valueOf(hdbh.getmahd()).equals(query)) && (!date1.after(ngay) && !date2.before(ngay))) {
                                    resultList.add(hdbh);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    });
                }
                
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }

    public hoadonbanhang getHDBH(int mahd) {
        for(hoadonbanhang hdbh : this.listhdbh) {
            if(hdbh.getmahd() == mahd) {
                return hdbh;
            }
        }
        return null;
    }  
    
    public void xuatExcel() {
        String[] list_ten = { "STT", "Tên nhân viên","Tên khách hàng","Ngày lập","Tổng tiền","Giảm giá(%)","Thành tiền"};
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DSHĐBH");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, list_ten.length-1);
        sheet.addMergedRegion(mergedRegion);
        Cell cell_title = row.createCell(0);
        // dien chu danh sach nhan vien
        cell_title.setCellValue("DANH SÁCH HÓA ĐƠN BÁN HÀNG");
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
        double tongtien,giamgia,thanhtien;
        for (int i = 0; i < this.listhdbh.size(); i++) {
            row = sheet.createRow(i + 2);
            tongtien = this.listhdbh.get(i).getTongtien();
            giamgia = (double)this.listhdbh.get(i).getGiamgia();
            thanhtien = Math.ceil((tongtien - tongtien * (Math.ceil(giamgia) / 100))/1000)*1000;
            for (int j = 0; j < this.listhdbh.size(); j++) {
                Cell cell = row.createCell(j);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(i + 1);
                } else if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(qlnv.getNhanVien(this.listhdbh.get(i).getmanv()).getTen());
                } else if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(qlkh.getKhachHang(this.listhdbh.get(i).getMakh()).getTen());
                } else if (cell.getColumnIndex() == 3) {
                    cell.setCellValue(this.listhdbh.get(i).getngay());
                } else if (cell.getColumnIndex() == 4) {
                    cell.setCellValue(PriceFormatter.format(this.listhdbh.get(i).getTongtien()));
                } else if (cell.getColumnIndex() == 5) {
                    cell.setCellValue(this.listhdbh.get(i).getGiamgia());
                } else if (cell.getColumnIndex() == 6) {
                    cell.setCellValue(PriceFormatter.format(thanhtien));
                }
            }
        }

        for (int i = 0; i < this.listhdbh.size(); i++)
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