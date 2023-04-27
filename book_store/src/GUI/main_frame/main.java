package GUI.main_frame;

import java.awt.*;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.*;

import DTO.taikhoan;
import GUI.setting_frame;

public class main extends JFrame {
    JPanel header, menu;
    public JPanel center;
    setting_frame set=new setting_frame();
    // chieu dai va chieu cao cua frame main
    // int w = 1300;
    // int h = 700;
    // // chieu dai va chieu cao cua header
    // int w_head = 1300;
    // int h_head = 40;
    // // chieu dai va chieu cao cua menu
    // int w_menu = 200;
    // int h_menu = 670;
    // // chieu dai va chieu cao cua giao dien giau
    // int w_center = 1100;
    // int h_center = 670;
    taikhoan tk;
    public main(taikhoan tk) {
        this.tk=tk;
        init();
    }

    private void init() {
        // cai dat giao dien man hinh chinh
        this.setSize(set.w_main, set.h_main);
        this.setLayout(new BorderLayout());
        this.setLocation(100, 50);
        this.setUndecorated(true);
        // them cac panel
        header = new header(this,this.tk);
        menu = new menu(this,tk);
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
