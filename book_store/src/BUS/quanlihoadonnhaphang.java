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

import DAO.quanlihoadonnhaphangDAO;
import DTO.hoadonnhaphang;

public class quanlihoadonnhaphang {
    private quanlinhacungcap qlncc = new quanlinhacungcap();
    private quanlinhanvien qlnv = new quanlinhanvien(); 
    private ArrayList<hoadonnhaphang> listhdnh = new ArrayList<hoadonnhaphang>();

    public void initList() {
        quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
        this.listhdnh = qlhdnhdao.list();
    }

    public Boolean themHoaDon(hoadonnhaphang hd) {
        if(hd != null) {
            listhdnh.add(hd);
            quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
            qlhdnhdao.themHoaDon(hd);
            return true;
        } else {
            JOptionPane.showMessageDialog(null,"Hóa đơn không hợp lệ!","Thông báo",1);
            return false;
        }
    }

    public int getNextID() {
        quanlihoadonnhaphangDAO qlhdnhdao = new quanlihoadonnhaphangDAO();
        return qlhdnhdao.getNextID();
    }

    public ArrayList<hoadonnhaphang> getList() {
        return this.listhdnh;
    }

    public ArrayList<hoadonnhaphang> searchhoadonnhaphang(String query,String datefrom,String dateto) {
        ArrayList<hoadonnhaphang> resultList = new ArrayList<hoadonnhaphang>();
        qlncc.initList();
        if(datefrom.equals("") && dateto.equals("")){
            this.listhdnh.forEach((hdnh) -> {
                if(qlncc.getNCC(hdnh.getMancc()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                    qlnv.getNhanVien(hdnh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase())||
                    String.valueOf(hdnh.getmahd()).equals(query) ||
                    String.valueOf(hdnh.getMancc()).equals(query)) {
                        resultList.add(hdnh);
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
                    this.listhdnh.forEach((hdnh) -> {
                        try {
                            Date ngay = new SimpleDateFormat("yyyy-MM-dd").parse(hdnh.getngay());
                            if((qlncc.getNCC(hdnh.getMancc()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                qlnv.getNhanVien(hdnh.getmanv()).getTen().toLowerCase().contains(query.toLowerCase()) ||
                                String.valueOf(hdnh.getmahd()).equals(query)) && (!date1.after(ngay) && !date2.before(ngay))) {
                                    resultList.add(hdnh);
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

    public hoadonnhaphang getHDNH(int mahd) {
        for(hoadonnhaphang hdnh : this.listhdnh) {
            if(hdnh.getmahd() == mahd) {
                return hdnh;
            }
        }
        return null;
    }  

    public void xuatExcel() {
        String[] list_ten = { "STT", "Tên nhân viên","Tên nhà cung cấp","Ngày lập","Thành tiền"};
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("DSHĐNH");
        XSSFRow row;
        // tao sheet title
        row = sheet.createRow(0);
        // gop 7 o vao lai
        CellRangeAddress mergedRegion = new CellRangeAddress(0, 0, 0, list_ten.length-1);
        sheet.addMergedRegion(mergedRegion);
        Cell cell_title = row.createCell(0);
        // cjen chu danh sach nhan vien
        cell_title.setCellValue("DANH SÁCH HÓA ĐƠN NHẬP HÀNG");
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
        qlncc.initList();
        for (int i = 0; i < this.listhdnh.size(); i++) {
            row = sheet.createRow(i + 2);
            for (int j = 0; j < this.listhdnh.size(); j++) {
                Cell cell = row.createCell(j);
                if (cell.getColumnIndex() == 0) {
                    cell.setCellValue(i + 1);
                } else if (cell.getColumnIndex() == 1) {
                    cell.setCellValue(qlnv.getNhanVien(this.listhdnh.get(i).getmanv()).getTen());
                } else if (cell.getColumnIndex() == 2) {
                    cell.setCellValue(qlncc.getNCC(this.listhdnh.get(i).getMancc()).getTen());
                } else if (cell.getColumnIndex() == 3) {
                    cell.setCellValue(this.listhdnh.get(i).getngay());
                } else if (cell.getColumnIndex() == 4) {
                    cell.setCellValue(PriceFormatter.format(this.listhdnh.get(i).getTongtien()));
                }
            }
        }

        for (int i = 0; i < this.listhdnh.size(); i++)
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