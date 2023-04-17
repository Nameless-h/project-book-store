package BUS;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import DAO.nhanvienDAO;
import DTO.*;

public class quanlinhanvien {
    nhanvienDAO chucnang_nhanvien=new nhanvienDAO();
    ArrayList<nhanvien> list=chucnang_nhanvien.selecAll();
    public String tennhanvien(int manv){
        for(int i=0;i<list.size();i++)
        {
            if(manv == (list.get(i).getMa()))
            return list.get(i).getTen();
        }
        return null;
    }
    // hien thi danh sach len 1 table duoc truyen va/
    public void hienthidanhsach_nhanvien(JTable table) {
        
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
                    list.get(i).getDiachi(), list.get(i).getEmail(), list.get(i).getSodienthoai(),list.get(i).getChucvu() });
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
    }
    public void themnhanvien(nhanvien nv){
        list.add(nv);
        chucnang_nhanvien.insert(nv);
    }
    public void suathongtinnhanvien(nhanvien nv){
        chucnang_nhanvien.update(nv);
    }
    public Integer[] danhsachmanhanvien(){
        Integer[] list_ds=new Integer[list.size()];
        for(int i=0;i<list_ds.length;i++)
            list_ds[i]=list.get(i).getMa();
        return list_ds;
    }
}
