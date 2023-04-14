package BUS;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DTO.*;

public class quanlinhanvien {
    // hien thi danh sach len 1 table duoc truyen va
    public void hienthidanhsach_nhanvien(JTable table) {
        ArrayList<nhanvien> list = new ArrayList<>();
        nhanvien ac1 = new nhanvien("ADMIN", "kiet", "nam", "XXX", "lamtuanXXX@gmail.com", "0933334");
        nhanvien ac2 = new nhanvien("NV", "hoang", "nu", "XXX", "nguyenhoangXXX@gmail.com", "0933334");
        nhanvien ac3 = new nhanvien("NV", "tuan", "nam", "XXX", "haotuanXXX@gmail.com", "0933334");
        nhanvien ac4 = new nhanvien("KH", "hao", "nam", "XXX", "vihaoXXX@gmail.com", "0933334");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), list.get(i).getGioitinh(),
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
}
