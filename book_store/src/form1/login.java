/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu.Separator;
import user.user_login;
import model.staff_model;



/**
 *
 * @author ASUS
 */
public class login {
    JFrame frame=new JFrame();
        JPanel logo=new JPanel();
        JLabel exit=new JLabel();
        JLabel icon_logo=new JLabel();
        //lien quan den trang login
        JPanel dangnhap=new JPanel();
        JLabel title_login=new JLabel();
        JLabel title_login_down=new JLabel();
        JLabel title_username=new JLabel();
        JLabel title_password=new JLabel();
        JTextField txt_username=new JTextField();
        Separator thanhngang1=new Separator();
        Separator thanhngang2=new Separator();
        JPasswordField txt_password=new JPasswordField();
        JLabel for_pass=new JLabel();
        JButton bun_login=new JButton("Login");
        JLabel title_signup=new JLabel("Do you have acount?");
        JLabel signup=new JLabel(" Sign up");
        JLabel icon_user=new JLabel();
        JLabel icon_showpass=new JLabel();
        JLabel icon_dispass=new JLabel();
        //lien quan den trang forget password
        JPanel pan_for_pass=new JPanel();
        JLabel title_for_pass=new JLabel();
        //goi chuc nang cua user_login
        staff_model chucnang_user=new staff_model();
    public login() {
        init();
    }

    private void init() {
        
        
        
        //set frame va layout
        frame.setSize(900,550);
        frame.setLocation(200,100);
        frame.setUndecorated(true);
        frame.setLayout(null);
//------------------------------------------------------------------------------------------------------
        // set panel logo
        logo.setLayout(null);
        logo.setBounds(0, 0, 400, 600);
        logo.setBackground(Color.white);
        frame.add(logo);
//------------------------------------------------------------------------------------------------------
        //set panel dangnhap
        dangnhap.setLayout(null);
        dangnhap.setBounds(400, 0, 500, 600);
        dangnhap.setBackground(Color.blue);
        frame.add(dangnhap);
//------------------------------------------------------------------------------------------------------
        //logo thoat chuong trinh
        exit.setLayout(null);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png")));
        exit.setBounds(450, 0, 50, 50);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        dangnhap.add(exit);
        //set logo chuong trinh
        icon_logo.setLayout(null);
        icon_logo.setBounds(0,0,400,600);
        icon_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/img_logo (1).png")));
        icon_logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.add(icon_logo);
        //set tieu de cua trang login
        title_login.setText("Login");
        title_login.setHorizontalAlignment(SwingConstants.CENTER);
        title_login.setFont(new java.awt.Font("Segoe UI", 0, 34));
        title_login.setForeground(Color.white);
        title_login.setBounds(0,10, 500, 50);
        dangnhap.add(title_login);
        //set dong xin chao trong panel dang nhap
        title_login_down.setText("Hello! Wellcome to bookstore.");
        title_login_down.setHorizontalAlignment(SwingConstants.CENTER);
        title_login_down.setFont(new java.awt.Font("Segoe UI", 2, 18));
        title_login_down.setForeground(Color.white);
        title_login_down.setBounds(0,60,500,30);
        dangnhap.add(title_login_down);
        //set dong title username trong dang nhap
        title_username.setText("Username:");
        title_username.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_username.setForeground(Color.white);
        title_username.setBounds(50,90,200,50);
        dangnhap.add(title_username);
//        pan_signup.add(title_username);
        //set cho nhap username
        txt_username.setBounds(45,130,350,30);
        txt_username.setBackground(Color.blue);
        txt_username.setForeground(Color.white);
        txt_username.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_username.setBorder(null);
        dangnhap.add(txt_username);
        //thanh ngang cho username
        thanhngang1.setBounds(45,160,380,10);
        dangnhap.add(thanhngang1);
        //icon user
        icon_user.setIcon(new ImageIcon(getClass().getResource("/icon/user2.png")));
        icon_user.setBounds(400,130,50,30);
        dangnhap.add(icon_user);
        //set dong title password trong dang nhap
        title_password.setText("Password:");
        title_password.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_password.setForeground(Color.white);
        title_password.setBounds(50,180,200,50);
        dangnhap.add(title_password);
        //set cho nhap password
        txt_password.setBounds(45,220,350,30);
        txt_password.setBackground(Color.blue);
        txt_password.setForeground(Color.white);
        txt_password.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_password.setBorder(null);
        dangnhap.add(txt_password);
        //thanh ngang2 cho password
        thanhngang2.setBounds(45,250,380,10);
        dangnhap.add(thanhngang2);
        //set icon dis password
        icon_dispass.setIcon(new ImageIcon(getClass().getResource("/icon/password.png")));
        icon_dispass.setBounds(400,220,50,30);
        dangnhap.add(icon_dispass);
        //set icon show password
        icon_showpass.setIcon(new ImageIcon(getClass().getResource("/icon/show_password.png")));
        icon_showpass.setBounds(400,220,50,30);
        dangnhap.add(icon_showpass);
        //set cho quen mat khau
        for_pass.setText("Forget password");
        for_pass.setForeground(Color.white);
        for_pass.setFont(new java.awt.Font("Segoe UI", 2, 16));
        for_pass.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        for_pass.setBounds(300,280,150,25);
        dangnhap.add(for_pass);
        //set nut dang nhap
        bun_login.setBounds(50,330,400,50);
        bun_login.setHorizontalAlignment(SwingConstants.CENTER);
        bun_login.setFont(new java.awt.Font("Segoe UI", 1, 16));
        bun_login.setForeground(Color.blue);
        dangnhap.add(bun_login);
        //set dong title dang ky
        title_signup.setBounds(150,400,150,50);
        title_signup.setForeground(Color.white);
        title_signup.setHorizontalAlignment(SwingConstants.RIGHT);
        title_signup.setFont(new java.awt.Font("Segoe UI", 2, 14));
        dangnhap.add(title_signup);
        //set chu sign up va tao su kien
        signup.setBounds(300,400,100,50);
        signup.setForeground(Color.white);
        signup.setHorizontalAlignment(SwingConstants.LEFT);
        signup.setFont(new java.awt.Font("Segoe UI", 1, 14));
        dangnhap.add(signup);
        

       
        frame.setVisible(true);
        //tao su kien thoat chuong trinh
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_main(evt);
            }
        });
        //tao su dien dang nhap
        bun_login.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dangnhap();
            }
        });
        icon_dispass.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_pass(evt);
            }
            
        });
        icon_showpass.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diss_pass(evt);
            }
            
        });
        signup.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_signup();
            }   
        });
        for_pass.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_forpass();
            }   

            
        });
        bun_login.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                check_login(evt);
            }
            //kiemtra dang nhap
            private void check_login(MouseEvent evt) {
                String username=txt_username.getText();
                String password=new String(txt_password.getPassword());
                user_login user=new user_login("",username,password,"");
                if(chucnang_user.check_login(user)!=null)
                    JOptionPane.showMessageDialog(null,"Dang nhap thanh cong");
                else
                    JOptionPane.showMessageDialog(null,"Dang nhap khong thanh cong");
            }
        });
    }
    
    public static void main(String[] args) {
        login frame=new login();
    }
    //su kien thoat chuong trinh
    private void close_main(java.awt.event.MouseEvent evt) {
            System.exit(0);
        }
   
    //su kien dang nhap
    private void dangnhap() {
            }
    //su kien hien password
    private  void show_pass(MouseEvent evt){
        txt_password.setEchoChar((char)0);
        icon_dispass.setVisible(false);
        //icon_dispass.setEnabled(false);
        icon_showpass.setVisible(true);
        //icon_showpass.setEnabled(true);
    }
    //su kien an password
    private  void diss_pass(MouseEvent evt){
        txt_password.setEchoChar((char)8226);

        icon_dispass.setVisible(true);
        //icon_dispass.setEnabled(true);
        icon_showpass.setVisible(false);
        //icon_showpass.setEnabled(false);
    }
    private void go_signup() {
        
        frame.setVisible(false);
        signup frame1=new signup();
    }
    private void go_forpass() {
        frame.setVisible(false);
        for_pass frame1=new for_pass();
    }
        
        
        
}
