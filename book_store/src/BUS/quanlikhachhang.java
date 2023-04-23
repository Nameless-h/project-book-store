package BUS;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import DAO.khachhangDAO;
import DTO.khachhang;

public class quanlikhachhang {
    // hien thi danh sach khach hang
    khachhangDAO chucang_khachhang=new khachhangDAO();
    ArrayList<khachhang> list = chucang_khachhang.selecAll();
    public void hienthidanhsach_khachhang(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {
            String gt;
            if(list.get(i).getGioitinh()==1)
            gt="Nam";
            else
            gt="Nu";
            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), gt,
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                    list.get(i).getDiem(), list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void themkhachhang(khachhang kh){
        list.add(kh);
        chucang_khachhang.insert(kh);
    }

    public void suathongtinkhachhang(khachhang kh){
        chucang_khachhang.update(kh);
    }

    public ArrayList<khachhang> getListKH() {
        return this.list;
    }

    public ArrayList<khachhang> searchKH(String query) {
        ArrayList<khachhang> resultList = new ArrayList<khachhang>();
        list.forEach((kh) -> {
            if( String.valueOf(kh.getMa()).contains(query) || 
                kh.getTen().toLowerCase().contains(query.toLowerCase()) || 
                kh.getEmail().toLowerCase().contains(query.toLowerCase()) ||
                kh.getSodienthoai().contains(query)) {
                    resultList.add(kh);
                }
        });
        return resultList;
    }

    public khachhang getKhachHang(int makh) {
        for (khachhang kh : list){
            if(kh.getMa() == makh) 
                return kh;
        }
        return null;
    }
    
    public boolean timkiem_vitri(int tk, String str, JTable table) {
        boolean kiemtra=false;
        if(tk==0){
            hienthidanhsach_khachhang(table);
            kiemtra=true;
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
                            kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        else
        if (tk == 2) {
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
                    kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        else
        if (tk == 3) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int gt1;
            if(str.equalsIgnoreCase("Nam"))
                gt1=1;
            else
                gt1=0;
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
                    kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        else
        if (tk == 4) {
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
                    kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        else
        if (tk == 5) {
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
                    kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        else
        if (tk == 6) {
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
                    kiemtra=true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }
        
        
    return kiemtra;
    }

    public void updateDiem(int makh,int diem) {
        for(khachhang kh : this.list) {
            if(kh.getMa() == makh) {
                kh.setDiem(diem);
                chucang_khachhang.update(kh);
                break;
            }
        }
    }
}
