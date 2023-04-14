package GUI;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcome extends JPanel {
    main obj;
    JLabel thongbao;
    String name_font1="Times Roman";
    public welcome(main obj){
        init(obj);
    }
    private void init(main obj){
        this.setPreferredSize(new Dimension(obj.w_center,obj.h_center));
        this.setLayout(null);
        //
        thongbao=new JLabel("Xin chao ban da den voi he thong ban sach cua nhom 4");
        thongbao.setBounds(10,300,1000,50);
        thongbao.setFont(new Font(name_font1,1,30));
        this.add(thongbao);

    }
}
