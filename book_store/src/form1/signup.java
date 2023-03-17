/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form1;

import java.awt.Color;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import model.user_model;
import user.user_login;
/**
 *
 * @author ASUS
 */
public class signup {
        JFrame frame=new JFrame();
        JPanel logo=new JPanel();
        JLabel exit=new JLabel();
        JLabel icon_logo=new JLabel();
        JLabel title_username_signup=new JLabel();
        JLabel title_password_signup=new JLabel();
        JTextField txt_username_signup=new JTextField();
        JPopupMenu.Separator thanhngang5=new JPopupMenu.Separator();
        JPopupMenu.Separator thanhngang6=new JPopupMenu.Separator();
        JPasswordField txt_password_signup=new JPasswordField();
        JPanel pan_signup=new JPanel();
        JLabel title_signup2=new JLabel("Sign up");
        JPasswordField check_pass=new JPasswordField();
        JLabel icon_showpass2=new JLabel();
        JLabel icon_dispass2=new JLabel();
        JLabel title_ver_pass=new JLabel("Verify password:");
        JPopupMenu.Separator thanhngang3=new JPopupMenu.Separator();
        JPasswordField ver_pass=new JPasswordField();
        JLabel title_email_signup=new JLabel("Email:");
        JTextField txt_email=new JTextField();
        JPopupMenu.Separator thanhngang4=new JPopupMenu.Separator();
        ImageIcon icon_email=new ImageIcon(getClass().getResource("/icon/email.png"));
        JLabel lab_icon_email=new JLabel(icon_email);
        JButton bun_signup=new JButton("Sign up");
        ImageIcon icon_return=new ImageIcon(getClass().getResource("/icon/arrow_left.png"));
        JLabel lab_icon_return=new JLabel(icon_return);
        JLabel lab_icon_user_signup=new JLabel(new ImageIcon(getClass().getResource("/icon/user2.png")));
        JLabel lab_icon_showpass_signup=new JLabel(new ImageIcon(getClass().getResource("/icon/show_password.png")));
        JLabel lab_icon_dispass_signup=new JLabel(new ImageIcon(getClass().getResource("/icon/password.png")));
        user_model chucnang_user=new user_model();
    public signup() {
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
        //set panel sign up
        pan_signup.setLayout(null);
        pan_signup.setBounds(400, 0, 500, 600);
        pan_signup.setBackground(Color.blue);
        frame.add(pan_signup);
        title_signup2.setBounds(0,10,500,50);
        title_signup2.setFont(new Font("Segoe UI",0,30));
        title_signup2.setHorizontalAlignment(SwingConstants.CENTER);
        title_signup2.setForeground(Color.white);
        pan_signup.add(title_signup2);
        //set dong title username trong sign up
        title_username_signup.setText("Username:");
        title_username_signup.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_username_signup.setForeground(Color.white);
        title_username_signup.setBounds(50,90,200,50);
        pan_signup.add(title_username_signup);
        //set cho nhap username sign up
        txt_username_signup.setBounds(45,130,350,30);
        txt_username_signup.setBackground(Color.blue);
        txt_username_signup.setForeground(Color.white);
        txt_username_signup.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_username_signup.setBorder(null);
        pan_signup.add(txt_username_signup);
        //thanh ngang cho username sign up
        thanhngang5.setBounds(45,160,380,10);
        pan_signup.add(thanhngang5);
        //icon user sign up
        lab_icon_user_signup.setBounds(400,130,50,30);
        pan_signup.add(lab_icon_user_signup);
        //set dong title password trong dang nhap
        title_password_signup.setText("Password:");
        title_password_signup.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_password_signup.setForeground(Color.white);
        title_password_signup.setBounds(50,180,200,50);
        pan_signup.add(title_password_signup);
        //set cho nhap password
        txt_password_signup.setBounds(45,220,350,30);
        txt_password_signup.setBackground(Color.blue);
        txt_password_signup.setForeground(Color.white);
        txt_password_signup.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_password_signup.setBorder(null);
        pan_signup.add(txt_password_signup);
        //thanh ngang6 cho password sign up
        thanhngang6.setBounds(45,250,380,10);
        pan_signup.add(thanhngang6);
        //set icon dis password sign up
        lab_icon_dispass_signup.setBounds(400,220,50,30);
        pan_signup.add(lab_icon_dispass_signup);
        //set icon show password signup
        lab_icon_showpass_signup.setBounds(400,220,50,30);
        pan_signup.add(lab_icon_showpass_signup);
        //set title password verify
        title_ver_pass.setBounds(50,260,200,60);
        title_ver_pass.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_ver_pass.setForeground(Color.white);
        pan_signup.add(title_ver_pass);
        //set cho nhap verify password
        ver_pass.setBounds(45,310,350,30);
        ver_pass.setBackground(Color.blue);
        ver_pass.setForeground(Color.white);
        ver_pass.setFont(new java.awt.Font("Segoe UI", 2, 18));
        ver_pass.setBorder(null);
        pan_signup.add(ver_pass);
        //set thanh ngang so 3
        thanhngang3.setBounds(45,340,380,10);
        pan_signup.add(thanhngang3);
        //set icon dis password verify
        icon_dispass2.setIcon(new ImageIcon(getClass().getResource("/icon/password.png")));
        icon_dispass2.setBounds(400,310,50,30);
        pan_signup.add(icon_dispass2);
        //set icon show password verify
        icon_showpass2.setIcon(new ImageIcon(getClass().getResource("/icon/show_password.png")));
        icon_showpass2.setBounds(400,310,50,30);
        pan_signup.add(icon_showpass2);
        //set title email
        title_email_signup.setBounds(45,360,350,30);
        title_email_signup.setForeground(Color.white);
        title_email_signup.setFont(new java.awt.Font("Segoe UI", 2, 22));
        pan_signup.add(title_email_signup);
        //set cho nhap email
        txt_email.setBounds(45,390,350,30);
        txt_email.setBackground(Color.blue);
        txt_email.setForeground(Color.white);
        txt_email.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_email.setBorder(null);
        pan_signup.add(txt_email);
        //set thanh ngang 4
        thanhngang4.setBounds(45,420,380,10);
        pan_signup.add(thanhngang4);
        //set icon email
        lab_icon_email.setBounds(390,390,50,30);
        pan_signup.add(lab_icon_email);
        //set nut sign up
        bun_signup.setBounds(50,450,370,50);
        bun_signup.setForeground(Color.blue);
        bun_signup.setFont(new java.awt.Font("Segoe UI", 1, 18));
        pan_signup.add(bun_signup);
        //set icon return
        lab_icon_return.setBounds(0,10,50,50);
        lab_icon_return.setEnabled(true);
        pan_signup.add(lab_icon_return);
//------------------------------------------------------------------------------------------------------
        //logo thoat chuong trinh
        exit.setLayout(null);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png")));
        exit.setBounds(450, 0, 50, 50);
        exit.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        pan_signup.add(exit);
        pan_signup.add(exit);
        //set logo chuong trinh
        icon_logo.setLayout(null);
        icon_logo.setBounds(0,0,400,600);
        icon_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/img_logo (1).png")));
        icon_logo.setText("text");
        icon_logo.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        logo.add(icon_logo);
        
        
        
        
        frame.setVisible(true);
        //tao su kien thoat chuong trinh
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_main(evt);
            }
        });
        
        icon_dispass2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_pass(evt);
            }
            //an passsword verify
            private void show_pass(MouseEvent evt) {
                ver_pass.setEchoChar((char)0);
                icon_dispass2.setVisible(false);
                //icon_dispass.setEnabled(false);
                icon_showpass2.setVisible(true);
                //icon_showpass.setEnabled(true);
            }
            
        });
        icon_showpass2.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diss_pass(evt);
            }
            //hien passsword verify
            private void diss_pass(MouseEvent evt) {
                ver_pass.setEchoChar((char)8226);
                icon_dispass2.setVisible(true);
                //icon_dispass.setEnabled(false);
                icon_showpass2.setVisible(false);
                //icon_showpass.setEnabled(true);
            }
            
        });
        lab_icon_dispass_signup.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                show_pass2(evt);
            }
            // an password 
            private void show_pass2(MouseEvent evt) {
                txt_password_signup.setEchoChar((char)0);
                lab_icon_dispass_signup.setVisible(false);
                //icon_dispass.setEnabled(false);
                lab_icon_showpass_signup.setVisible(true);
                //icon_showpass.setEnabled(true);
            }
            
        });
        lab_icon_showpass_signup.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diss_pass2(evt);
            }
            //hien password 
            private void diss_pass2(MouseEvent evt) {
                txt_password_signup.setEchoChar((char)8226);
                lab_icon_dispass_signup.setVisible(true);
                //icon_dispass.setEnabled(false);
                lab_icon_showpass_signup.setVisible(false);
                //icon_showpass.setEnabled(true);
            }
            
        });
        lab_icon_return.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_login();
            }

            private void go_login() {
                login frame1=new login();
                frame.setVisible(false);
            }
           
            
        });
        bun_signup.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                signup_user();
            }
            //dang ky tai khoan
            private void signup_user() {
                String username=txt_username_signup.getText();
                String password=new String(txt_password_signup.getPassword());
                String verify_password=new String(ver_pass.getPassword());
                String email=txt_email.getText();
                if(password.equalsIgnoreCase(verify_password))
                    if(chucnang_user.check_username(username))
                        if(chucnang_user.check_email(email))
                        {
                            user_login user=new user_login(chucnang_user.spawn_matk(),username,password,email);
                            chucnang_user.add_user(user);
                            JOptionPane.showMessageDialog(null,"Dang ky thanh cong");
                        }
                        else
                            JOptionPane.showMessageDialog(null,"Da ton tai email");
                    else
                        JOptionPane.showMessageDialog(null,"Da ton tai tai khoan nay");
                else
                    JOptionPane.showMessageDialog(null, "Mat khau xac nhan hong dung");
            }
        });
    }
    public static void main(String[] args) {
        signup frame=new signup();
    }
    //su kien thoat chuong trinh
    private void close_main(java.awt.event.MouseEvent evt) {
            System.exit(0);
        }
        
}
