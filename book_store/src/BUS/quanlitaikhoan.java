package BUS;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import DTO.taikhoan;

public class quanlitaikhoan {
    public void hienthidanhsach_taikhoan(JTable table) {
        ArrayList<taikhoan> list = new ArrayList<>();
        taikhoan ac1 = new taikhoan("TK1", "kiet", "123", "ADMIN1", "q1", "hien");
        taikhoan ac2 = new taikhoan("TK2", "hoang", "123", "NV1", "q2", "hien");
        taikhoan ac3 = new taikhoan("TK3", "tuan", "123", "NV2", "q2", "hien");
        taikhoan ac4 = new taikhoan("Tk4", "hao", "123", "QL1", "q3", "hien");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
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
}
