/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu.Separator;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

import BUS.quanlitaikhoan;
import DTO.taikhoan;
import GUI.quanlysanpham.button_panel;

/**
 *
 * @author ASUS
 */
public class login extends JFrame implements MouseListener,KeyListener {
    JFrame frame = new JFrame();
    JPanel logo = new JPanel();
    JLabel exit = new JLabel();
    JLabel icon_logo = new JLabel();
    // lien quan den trang login
    JPanel dangnhap = new JPanel();
    JLabel title_login = new JLabel();
    JLabel title_login_down = new JLabel();
    JLabel title_username = new JLabel();
    JLabel title_password = new JLabel();
    JTextField txt_username = new JTextField();
    Separator thanhngang1 = new Separator();
    Separator thanhngang2 = new Separator();
    JPasswordField txt_password = new JPasswordField();
    JLabel for_pass = new JLabel();
    JButton bun_login = new JButton("Login");
    JLabel title_signup = new JLabel("Do you have acount?");
    JLabel signup = new JLabel(" Sign up");
    JLabel icon_user = new JLabel();
    JLabel icon_showpass = new JLabel();
    JLabel icon_dispass = new JLabel();
    // lien quan den trang forget password
    JPanel pan_for_pass = new JPanel();
    JLabel title_for_pass = new JLabel();
    // goi chuc nang cua user_login
    quanlitaikhoan chucnang_taikhoan = new quanlitaikhoan();

    public login() {
        init();
    }

    private void init() {

        // set frame va layout
        this.setSize(900, 550);
        this.setLocation(350, 150);
        this.setUndecorated(true);
        this.setLayout(null);
        // ------------------------------------------------------------------------------------------------------
        // set panel logo
        logo.setLayout(null);
        logo.setBounds(0, 0, 400, 600);
        logo.setBackground(Color.white);
        this.add(logo);
        // ------------------------------------------------------------------------------------------------------
        // set panel dangnhap
        dangnhap.setLayout(null);
        dangnhap.setBounds(400, 0, 500, 600);
        dangnhap.setBackground(Color.blue);
        this.add(dangnhap);
        // ------------------------------------------------------------------------------------------------------
        // logo thoat chuong trinh
        exit.setLayout(null);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png")));
        exit.setBounds(450, 0, 50, 50);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        dangnhap.add(exit);
        // set logo chuong trinh
        icon_logo.setLayout(null);
        icon_logo.setBounds(0, 0, 400, 600);
        icon_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/img_logo (1).png")));
        icon_logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.add(icon_logo);
        // set tieu de cua trang login
        title_login.setText("Login");
        title_login.setHorizontalAlignment(SwingConstants.CENTER);
        title_login.setFont(new java.awt.Font("Segoe UI", 0, 34));
        title_login.setForeground(Color.white);
        title_login.setBounds(0, 10, 500, 50);
        dangnhap.add(title_login);
        // set dong xin chao trong panel dang nhap
        title_login_down.setText("Hello! Wellcome to bookstore.");
        title_login_down.setHorizontalAlignment(SwingConstants.CENTER);
        title_login_down.setFont(new java.awt.Font("Segoe UI", 2, 18));
        title_login_down.setForeground(Color.white);
        title_login_down.setBounds(0, 60, 500, 30);
        dangnhap.add(title_login_down);
        // set dong title username trong dang nhap
        title_username.setText("Username:");
        title_username.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_username.setForeground(Color.white);
        title_username.setBounds(50, 90, 200, 50);
        dangnhap.add(title_username);
        // pan_signup.add(title_username);
        // set cho nhap username
        txt_username.setBounds(45, 130, 350, 30);
        txt_username.setBackground(Color.blue);
        txt_username.setForeground(Color.white);
        txt_username.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_username.setBorder(null);
        dangnhap.add(txt_username);
        // thanh ngang cho username
        thanhngang1.setBounds(45, 160, 380, 10);
        dangnhap.add(thanhngang1);
        // icon user
        icon_user.setIcon(new ImageIcon(getClass().getResource("/icon/user2.png")));
        icon_user.setBounds(400, 130, 50, 30);
        dangnhap.add(icon_user);
        // set dong title password trong dang nhap
        title_password.setText("Password:");
        title_password.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_password.setForeground(Color.white);
        title_password.setBounds(50, 180, 200, 50);
        dangnhap.add(title_password);
        // set cho nhap password
        txt_password.setBounds(45, 220, 350, 30);
        txt_password.setBackground(Color.blue);
        txt_password.setForeground(Color.white);
        txt_password.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_password.setBorder(null);
        dangnhap.add(txt_password);
        // thanh ngang2 cho password
        thanhngang2.setBounds(45, 250, 380, 10);
        dangnhap.add(thanhngang2);
        // set icon dis password
        icon_dispass.setIcon(new ImageIcon(getClass().getResource("/icon/password.png")));
        icon_dispass.setBounds(400, 220, 50, 30);
        dangnhap.add(icon_dispass);
        // set icon show password
        icon_showpass.setIcon(new ImageIcon(getClass().getResource("/icon/show_password.png")));
        icon_showpass.setBounds(400, 220, 50, 30);
        dangnhap.add(icon_showpass);
        // set cho quen mat khau
        for_pass.setText("Forget password");
        for_pass.setForeground(Color.white);
        for_pass.setFont(new java.awt.Font("Segoe UI", 2, 16));
        for_pass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        for_pass.setBounds(300, 280, 150, 25);
        dangnhap.add(for_pass);
        // set nut dang nhap
        bun_login.setBounds(50, 330, 400, 50);
        bun_login.setHorizontalAlignment(SwingConstants.CENTER);
        bun_login.setFont(new java.awt.Font("Segoe UI", 1, 16));
        bun_login.setForeground(Color.blue);
        bun_login.addKeyListener(this);
        dangnhap.add(bun_login);
        // set dong title dang ky
        title_signup.setBounds(150, 400, 150, 50);
        title_signup.setForeground(Color.white);
        title_signup.setHorizontalAlignment(SwingConstants.RIGHT);
        title_signup.setFont(new java.awt.Font("Segoe UI", 2, 14));
        dangnhap.add(title_signup);
        // set chu sign up va tao su kien
        signup.setBounds(300, 400, 100, 50);
        signup.setForeground(Color.white);
        signup.setHorizontalAlignment(SwingConstants.LEFT);
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14));
        dangnhap.add(signup);
        // them su kien cac nut
        bun_login.addMouseListener(this);
        icon_dispass.addMouseListener(this);
        icon_showpass.addMouseListener(this);
        for_pass.addMouseListener(this);
        exit.addMouseListener(this);
        this.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bun_login) {
            String username = txt_username.getText();
            String password = new String(txt_password.getPassword());
            taikhoan user = new taikhoan(0, username, password, 0, 0, 0);
            if ((user = chucnang_taikhoan.kiemtradangnhap(user)) != null) {
                if(user.getTinhtrang()==1){
                    this.setVisible(false);
                // System.out.println(user);
                new main(user);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Tai khoan ban da bi khoa\nVui long lien he admin de mo khoa tai khoan","Canh bao",JOptionPane.WARNING_MESSAGE);
                }
                
            } else
                JOptionPane.showMessageDialog(null, "Dang nhap khong thanh cong");
        } else if (e.getSource() == icon_dispass) {
            txt_password.setEchoChar((char) 0);
            icon_dispass.setVisible(false);
            icon_showpass.setVisible(true);
        } else if (e.getSource() == icon_showpass) {
            txt_password.setEchoChar((char) 8226);

            icon_dispass.setVisible(true);
            icon_showpass.setVisible(false);
        } else if (e.getSource() == for_pass) {
            this.setVisible(false);
            new for_pass();
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

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
        new login();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Hello");
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

}
