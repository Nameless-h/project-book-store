package BUS;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import DAO.taikhoanDAO;
import DTO.taikhoan;

public class quanlitaikhoan {
    taikhoanDAO chucnang_taikhoan = new taikhoanDAO();
    ArrayList<taikhoan> list = chucnang_taikhoan.selecAll();

    public ArrayList<taikhoan> laydanhsach() {
        ArrayList<taikhoan> list = chucnang_taikhoan.selecAll();
        return list;
    }

    public taikhoan kiemtradangnhap(taikhoan tk) {
        for (int i = 0; i < list.size(); i++) {
            if (tk.getUsername().equalsIgnoreCase(list.get(i).getUsername()) &&
                    tk.getPassword().equalsIgnoreCase(list.get(i).getPassword()))
                return list.get(i);
        }
        return null;
    }

    public void hienthidanhsach_taikhoan(JTable table) {
        // ArrayList<taikhoan> list = laydanhsach();
        list = chucnang_taikhoan.selecAll();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(
                    new Object[] { i + 1, list.get(i).getMatk(), list.get(i).getUsername(), list.get(i).getPassword(),
                            list.get(i).getManhanvien(), list.get(i).getManhomquyen(), list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }

    public void themtaikhoan(taikhoan tk) {
        list.add(tk);
        chucnang_taikhoan.insert(tk);
    }

    public void suataikhoan(taikhoan tk) {
        chucnang_taikhoan.update(tk);
    }

    public boolean timkiem_vitri(int tk, String str, JTable table) {
        list = chucnang_taikhoan.selecAll();
        boolean kiemtra = false;
        if (tk == 0) {
            hienthidanhsach_taikhoan(table);
            kiemtra = true;
        }
        if (tk == 1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int temp = Integer.parseInt(str);
            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {
                if (temp == list.get(i).getMatk()) {

                    model.addRow(new Object[] { i + 1, list.get(i).getMatk(), list.get(i).getUsername(),
                            list.get(i).getPassword(),
                            list.get(i).getManhanvien(), list.get(i).getManhomquyen(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 2) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int temp = Integer.parseInt(str);
            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {

                if (temp == list.get(i).getManhanvien()) {

                    model.addRow(new Object[] { i + 1, list.get(i).getMatk(), list.get(i).getUsername(),
                            list.get(i).getPassword(),
                            list.get(i).getManhanvien(), list.get(i).getManhomquyen(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        } else if (tk == 3) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);
            int temp = Integer.parseInt(str);
            // them thong tin nhan vien vao bang table
            for (int i = 0; i < list.size(); i++) {

                if (temp == list.get(i).getManhomquyen()) {

                    model.addRow(new Object[] { i + 1, list.get(i).getMatk(), list.get(i).getUsername(),
                            list.get(i).getPassword(),
                            list.get(i).getManhanvien(), list.get(i).getManhomquyen(), list.get(i).getTinhtrang() });
                    kiemtra = true;
                }

            }
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        }

        return kiemtra;
    }

    public void suanhomquyen_tk(int ma) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getManhanvien() == ma) {
                chucnang_taikhoan.update_nq_ao(ma);
            }
        }
    }
}
