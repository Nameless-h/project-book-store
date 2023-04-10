package GUI;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class main extends JFrame {
    JPanel header,menu;
    //chieu dai va chieu cao cua frame main
    int w=1300;
    int h=700;
    //chieu dai va chieu cao cua header
    int w_head=1300;
    int h_head=30;
    //chieu dai va chieu cao cua menu
    int w_menu=200;
    int h_menu=630;
    public main(){
        init();
    }
    private void init(){
        //cai dat giao dien man hinh chinh
        this.setSize(w,h);
        this.setLayout(new BorderLayout());
        this.setLocation(100,50);
        this.setUndecorated(true);
        //them cac panel
        header=new header(this);
        menu=new menu(this);

        this.add(header,BorderLayout.NORTH);
        this.add(menu,BorderLayout.WEST);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new main();
    }
}
