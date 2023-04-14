package BUS;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import DTO.nhomquyen;

public class quanlinhomquyen {
    public void hienthidanhsach_nhomquyen(JTable table) {
        ArrayList<nhomquyen> list = new ArrayList<>();
        nhomquyen ac1 = new nhomquyen("q1", "Quan li");
        nhomquyen ac2 = new nhomquyen("q1", "Quan li");
        nhomquyen ac3 = new nhomquyen("q1", "Quan li");
        nhomquyen ac4 = new nhomquyen("q1", "Quan li");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[] { i + 1, list.get(i).getMa(), list.get(i).getTen(), "Xem chi tiet" });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
}
