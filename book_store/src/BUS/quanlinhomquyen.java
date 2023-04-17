package BUS;

import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import DAO.nhomquyenDAO;
import DTO.nhomquyen;

public class quanlinhomquyen {
    nhomquyenDAO chucnang_nhomquyen=new nhomquyenDAO();
    ArrayList<nhomquyen> list = chucnang_nhomquyen.selecAll();
    public void hienthidanhsach_nhomquyen(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        // them thong tin nhan vien vao bang table
        for (int i = 0; i < list.size(); i++) {

            model.addRow(new Object[] { i + 1, 
                                        list.get(i).getMa(),
                                         list.get(i).getTen(),
                                         list.get(i).getNgaytao(),
                                         list.get(i).getNgaycapnhat(),
                                          "Xem chi tiet" });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
    public Integer[] danhsach_manhomquyen(){
        Integer[] list1=new Integer[list.size()];
        for(int i=0;i<list.size();i++)
            list1[i]=list.get(i).getMa();
        return list1;
    }
    public void themnhomquyen(nhomquyen nq){
        chucnang_nhomquyen.insert(nq);
    }
    public void suanhomquyen(nhomquyen nq){
        chucnang_nhomquyen.update(nq);

    }
}
