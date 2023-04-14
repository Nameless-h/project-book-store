package GUI;

import java.awt.*;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import DTO.taikhoan;

public class main extends JFrame {
    JPanel header, menu, center;
    // chieu dai va chieu cao cua frame main
    int w = 1300;
    int h = 700;
    // chieu dai va chieu cao cua header
    int w_head = 1300;
    int h_head = 40;
    // chieu dai va chieu cao cua menu
    int w_menu = 200;
    int h_menu = 670;
    // chieu dai va chieu cao cua giao dien giau
    int w_center = 1100;
    int h_center = 670;
    taikhoan tk;
    public main(taikhoan tk) {
        this.tk=tk;
        init();
       
        System.out.println(this.tk);
    }

    private void init() {
        // cai dat giao dien man hinh chinh
        this.setSize(w, h);
        this.setLayout(new BorderLayout());
        this.setLocation(100, 50);
        this.setUndecorated(true);
        // them cac panel
        header = new header(this,this.tk);
        menu = new menu(this);
        center = new welcome(this);
        this.add(header, BorderLayout.NORTH);
        this.add(menu, BorderLayout.WEST);
        this.add(center, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatMacLightLaf());
                    UIManager.put("TextComponent.arc", 300);
                    UIManager.put("Button.arc", 999);
                } catch (UnsupportedLookAndFeelException ex) {
                    System.out.println("That bai");
                }
            }
        });
        taikhoan user=new taikhoan(1,"admin","admin",1,1,1);
        new main(user);

    }
}
