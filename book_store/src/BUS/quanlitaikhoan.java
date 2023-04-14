package BUS;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import DAO.taikhoanDAO;
import nameclass.taikhoan;

public class quanlitaikhoan {
    taikhoanDAO chucnang_taikhoan=new taikhoanDAO();
    public ArrayList<taikhoan> laydanhsach(){
        ArrayList<taikhoan> list=chucnang_taikhoan.selecAll();
        return list;
    }
    public void hienthidanhsach_taikhoan(JTable table) {
        ArrayList<taikhoan> list = laydanhsach();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[] { i + 1, list.get(i).getMatk(), list.get(i).getUsername(),list.get(i).getPassword(),
                    list.get(i).getManhanvien(), list.get(i).getManhomquyen(), list.get(i).getTinhtrang() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
}
