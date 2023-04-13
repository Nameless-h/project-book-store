package BUS;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import nameclass.khachhang;

public class quanlikhachhang {
    //hien thi danh sach khach hang
    public void hienthidanhsach_khachhang(JTable table) {
        ArrayList<khachhang> list = new ArrayList<>();
        khachhang ac1 = new khachhang("KH1","Kiet", "Nam","XXX","lamtuankiet@gmail", "01XXX", 50, "Hien");
        khachhang ac2 = new khachhang("KH1","Kiet", "Nam","XXX","lamtuankiet@gmail", "01XXX", 50, "Hien");
        khachhang ac3 = new khachhang("KH1","Kiet", "Nam","XXX","lamtuankiet@gmail", "01XXX", 50, "Hien");
        khachhang ac4 = new khachhang("KH1","Kiet", "Nam","XXX","lamtuankiet@gmail", "01XXX", 50, "Hien");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), list.get(i).getGioitinh(),
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),
                    list.get(i).getDiem(),list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
}
