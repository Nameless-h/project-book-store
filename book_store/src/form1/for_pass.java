/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form1;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import support.SendEmail;
/**
 *
 * @author ASUS
 */
public class for_pass {
    JFrame frame=new JFrame();
    JPanel logo=new JPanel();
    JLabel exit=new JLabel();
    JLabel icon_logo=new JLabel();
    JPanel pan_forpass=new JPanel();
    JLabel title=new JLabel("Forget password");
    JLabel title_email=new JLabel("Email:");
    JTextField txt_email=new JTextField();
    Separator thanhngang1=new Separator();
    ImageIcon icon_email=new ImageIcon(getClass().getResource("/icon/email.png"));
    JLabel lab_icon_email=new JLabel(icon_email);
    ImageIcon icon_return=new ImageIcon(getClass().getResource("/icon/arrow_left.png"));
    JLabel lab_icon_return=new JLabel(icon_return);
    JButton bun_sendemail=new JButton("Send code verify to email");
    JButton bun_verify=new JButton("Verify");
    JLabel title_sendcodeverify1=new JLabel("Vui long doi trong it phut de chung toi gui ");
    JLabel title_sendcodeverify2=new JLabel("ma xac nhan vao email cua ban.");

    JLabel title_reload=new JLabel("Neu ban cho qua lau vui long tai lai trang tai day.");
    JLabel lab_reload=new JLabel("Reload");
    JLabel lab_code=new JLabel("Nhap ma xac nhan:");
    JTextField txt_codeverify=new JTextField();
    //goi cac chuc nang cua cac package khac
    SendEmail chucnang_sendemail=new SendEmail();
    public for_pass() {
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
        logo.setBounds(0, 0, 400, 550);
        logo.setBackground(Color.white);
        frame.add(logo);
        //set logo 
        icon_logo.setLayout(null);
        icon_logo.setBounds(0,0,400,600);
        icon_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/img_logo (1).png")));
        icon_logo.setHorizontalAlignment(SwingConstants.CENTER);
        logo.add(icon_logo);
        //set panel forget password
        pan_forpass.setLayout(null);
        pan_forpass.setBounds(400,0,500,550);
        pan_forpass.setBackground(Color.blue);
        frame.add(pan_forpass);
        //set nut thoat chuong trinh
        exit.setLayout(null);
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/close.png")));
        exit.setBounds(450, 0, 50, 50);
        exit.setHorizontalAlignment(SwingConstants.CENTER);
        pan_forpass.add(exit);
        //set title cua trang forget password
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new java.awt.Font("Segoe UI", 0, 34));
        title.setForeground(Color.white);
        title.setBounds(0,10, 500, 50);
        pan_forpass.add(title);
        //set title cho nhap email
        title_email.setFont(new java.awt.Font("Segoe UI", 2, 22));
        title_email.setForeground(Color.white);
        title_email.setBounds(50,90,200,50);
        pan_forpass.add(title_email);
        //set cho de nhap email
        txt_email.setBounds(45,130,350,30);
        txt_email.setBackground(Color.blue);
        txt_email.setForeground(Color.white);
        txt_email.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_email.setBorder(null);
        pan_forpass.add(txt_email);
        //set thang ngang 1
        thanhngang1.setBounds(45,160,380,10);
        pan_forpass.add(thanhngang1);
        //set icon cho nhap email
        lab_icon_email.setBounds(400,130,50,30);
        lab_icon_email.setHorizontalAlignment(SwingConstants.LEFT);
        pan_forpass.add(lab_icon_email);
        //set icon return
        lab_icon_return.setBounds(0,10,50,50);
        lab_icon_return.setEnabled(true);
        pan_forpass.add(lab_icon_return);
        //set nut send code verify
        bun_sendemail.setBounds(80,200,300,60);
        bun_sendemail.setFont(new java.awt.Font("Segoe UI", 1, 20));
        bun_sendemail.setForeground(Color.blue);
        pan_forpass.add(bun_sendemail);
        //set title send verify code
        title_sendcodeverify1.setBounds(50,270,500,25);
        title_sendcodeverify1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        title_sendcodeverify1.setHorizontalAlignment(SwingConstants.LEFT);
        title_sendcodeverify1.setForeground(Color.white);
        pan_forpass.add(title_sendcodeverify1);
        title_sendcodeverify1.setVisible(false);
        title_sendcodeverify2.setBounds(80,295,500,25);
        title_sendcodeverify2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        title_sendcodeverify2.setHorizontalAlignment(SwingConstants.LEFT);
        title_sendcodeverify2.setForeground(Color.white);
        pan_forpass.add(title_sendcodeverify2);
        title_sendcodeverify2.setVisible(false);
        //set cho reload
        title_reload.setBounds(10,330,390,25);
        title_reload.setFont(new java.awt.Font("Segoe UI", 2, 18));
        title_reload.setHorizontalAlignment(SwingConstants.LEFT);
        title_reload.setForeground(Color.white);
        pan_forpass.add(title_reload);
        title_reload.setVisible(false);
        lab_reload.setBounds(410,330,390,25);
        lab_reload.setFont(new java.awt.Font("Segoe UI", 1, 18));
        lab_reload.setHorizontalAlignment(SwingConstants.LEFT);
        lab_reload.setForeground(Color.white);
        pan_forpass.add(lab_reload);
        lab_reload.setVisible(false);
        //set title cho nhap code verify
        lab_code.setFont(new java.awt.Font("Segoe UI", 2, 22));
        lab_code.setForeground(Color.white);
        lab_code.setBounds(50,90,200,50);
        pan_forpass.add(lab_code);
        lab_code.setVisible(false);
        //set cho de nhap email
        txt_codeverify.setBounds(45,130,350,30);
        txt_codeverify.setBackground(Color.blue);
        txt_codeverify.setForeground(Color.white);
        txt_codeverify.setFont(new java.awt.Font("Segoe UI", 2, 18));
        txt_codeverify.setBorder(null);
        pan_forpass.add(txt_codeverify);
        txt_codeverify.setVisible(false);






        //set nui verify code
        bun_verify.setBounds(80,200,300,60);
        bun_verify.setFont(new java.awt.Font("Segoe UI", 1, 20));
        bun_verify.setForeground(Color.blue);
        pan_forpass.add(bun_verify);
        bun_verify.setVisible(false);
        
        
        
        
        
        
        
        frame.setVisible(true);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close_main(evt);
            }

            private void close_main(MouseEvent evt) {
                System.exit(0);
            }
        });
        //su kien nut quay lai trang chu
        lab_icon_return.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                go_login();
            }

            private void go_login() {
                login frame1=new login();
                frame.setVisible(false);
            } 
        });
        //su kien gui code xac nhan
        bun_sendemail.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt){
                send_email_code_verify();
            }

            private void send_email_code_verify() {
                String email=txt_email.getText();
                //an 
                bun_sendemail.setVisible(false);
                title_email.setVisible(false);
                txt_email.setVisible(false);
                lab_icon_email.setVisible(false);
                //hien
                title_sendcodeverify1.setVisible(true);
                title_sendcodeverify2.setVisible(true);
                title_reload.setVisible(true);
                lab_reload.setVisible(true);
                bun_verify.setVisible(true);
                lab_code.setVisible(true);
                txt_codeverify.setVisible(true);
                //chucnang_sendemail.sendmail(email);
            }
        });
        //su kien nut reload
        lab_reload.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt){
                reload();
            }

            private void reload() {
                frame.setVisible(false);
                for_pass frame2=new for_pass();
            }
        });
    }
    public static void main(String[] args) {
        for_pass frame=new for_pass();
    }
}
