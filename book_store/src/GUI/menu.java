package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class menu extends JPanel{
    main obj;
    Color color_54=new Color(54,54,54);
    String[] list_menu={"Ban hang","Nhap hang","San pham","Hoa don","Phieu nhap","Nhan vien","Khach hang","Nha cung cap","Tai khoan","Quyen"} 
    public menu(main obj){
        init(obj);
    }
    private void init(main obj){
        //cai dat giao dien  cho panel menu
        this.setPreferredSize(new Dimension(obj.w_menu,obj.h_menu));
        this.setBackground(color_54);
        this.setLayout(new FlowLayout());
        //them cac chuc nang vao menu chinh
    }

}
