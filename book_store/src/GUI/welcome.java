package GUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class welcome extends JPanel {
    main obj;
    JLabel thongbao,logo;
    String name_font1="Times Roman";

    public welcome(main obj){
        init(obj);
    }
    private void init(main obj){
        this.setPreferredSize(new Dimension(obj.w_center,obj.h_center));
        this.setLayout(null);
        //
        thongbao=new JLabel("Xin chao ban da den voi he thong ban sach cua nhom 4");
        thongbao.setBounds(10,10,obj.w_center-10,50);
        thongbao.setFont(new Font(name_font1,1,30));
        thongbao.setHorizontalAlignment(SwingConstants.CENTER);
        //set logo thong bao cua chuong trinh
        logo=new JLabel(new ImageIcon(getClass().getResource("/icon/book-shop_logo_512.png")));
        logo.setBounds(250, 70,600 ,600);
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(logo);
        this.add(thongbao);

    }
}
