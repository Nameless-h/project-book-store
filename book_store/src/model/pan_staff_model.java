package model;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import nameclass.taikhoan;
import nameclass.khachhang;
import nameclass.nhanvien;

public class pan_staff_model {
    //tra ve vi tri cua nhom quyen
    public int vitri_nhomquyen(String[] com_nhomquyen_str,String manhomquyen){
        for(int i=0;i<com_nhomquyen_str.length;i++){
            if(manhomquyen.equalsIgnoreCase(com_nhomquyen_str[i]))
             return i;
        }
        return 0;
    }
    //kiem tra nhan vien do thuoc ve tai khaon nao
    public taikhoan staff_account(String manhanvien){
        ArrayList<taikhoan> list=new ArrayList<>();
        taikhoan ac1=new taikhoan("1","username1", "password1", "Admin1", "ADMIN");
        taikhoan ac2=new taikhoan("2","username2", "password2", "NV11", "NV");
        taikhoan ac3=new taikhoan("3","username3", "password3", "Nv12", "NV");
        taikhoan ac4=new taikhoan("4","username4", "password4", "KH11", "KH");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
        for(int i=0;i<list.size();i++)
        {
            if(manhanvien.equalsIgnoreCase(list.get(i).getManhomquyen()))
                return list.get(i);
        }
        return null;
    }
    
    public void show_list_staff(JTable table){
        ArrayList<nhanvien> list=new ArrayList<>();
        nhanvien ac1=new nhanvien("ADMIN","kiet","nam","XXX","lamtuanXXX@gmail.com","0933334");
        nhanvien ac2=new nhanvien("NV","hoang","nu","XXX","nguyenhoangXXX@gmail.com","0933334");
        nhanvien ac3=new nhanvien("NV","tuan","nam","XXX","haotuanXXX@gmail.com","0933334");
        nhanvien ac4=new nhanvien("KH","hao","nam","XXX","vihaoXXX@gmail.com","0933334");
        list.add(ac1);
        list.add(ac2);
        list.add(ac3);
        list.add(ac4);
        DefaultTableModel model=(DefaultTableModel)table.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
            taikhoan temp=staff_account(list.get(i).getMa());
			model.addRow(new Object[] {list.get(i).getMa(),list.get(i).getTen(),list.get(i).getGioitinh(),list.get(i).getDiachi()
                                        ,list.get(i).getEmail(),list.get(i).getSodienthoai(),temp.getManhomquyen()});
		}
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer);
	
    }

}
