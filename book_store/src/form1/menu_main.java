/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form1;

import DAO.user_functionDAO;
import DAO.user_infoDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.List;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import model.staff_model;
import user.*;
/**
 *
 * @author ASUS
 */
public class menu_main {
    user_functionDAO chucnang_user_functionDAO=new user_functionDAO();
    user_infoDAO chucnang_user_infoDAO=new user_infoDAO();
    staff_model chucnang_user=new staff_model();
    
    
    
    JFrame frame1=new JFrame();
    JPanel pan_background=new JPanel();
    ImageIcon icon_eixt=new ImageIcon(getClass().getResource("/icon/exit_logo_menu2.png"));
    JLabel lab_icon_exit=new JLabel(icon_eixt);
    JPanel pan_chucnang=new JPanel();
    JLabel lab_title_menu_main=new JLabel("Menu cửa hàng bán sách.");
    JPanel pan_info=new JPanel();
    
    
    
    
    
    
    
    
    
    
    Integer temp_y=10;
    
    
    public menu_main(user_login user) {
        
        init(user);
    }
    
    private void init(user_login user) {
        // user_function user_fun=chucnang_user_functionDAO.selectById(user.getMatk());
        // ArrayList<String> list_chucnang_user=chucnang_user.user_fun(user_fun);
        // user_info user_info=chucnang_user_infoDAO.selectById(user.getMatk());
        
        
        // Integer height=(480/(list_chucnang_user.size()));
        
        
        
        frame1.setLayout(null);
        frame1.setSize(1000,650);
        frame1.setLocation(100,100);
        frame1.setUndecorated(true);
        //set back ground cuar menu main
        pan_background.setLayout(null);
        pan_background.setBounds(0,0,1300,650);
        pan_background.setBackground(new java.awt.Color(0,75,158));
        frame1.add(pan_background);
        //set logo thoat cua chuong trinh
        lab_icon_exit.setBounds(10,10,50,50);
        pan_background.add(lab_icon_exit);
        //set panel chuc nang
        pan_chucnang.setBounds(50,100,400,530);
        pan_chucnang.setLayout(new FlowLayout(0,5,10));
        pan_chucnang.setBackground(new java.awt.Color(0,75,158));
        pan_background.add(pan_chucnang);
        //set cac nut chuc nag vao panel chuc nang
        // for(int i=0;i<list_chucnang_user.size();i++)
        // {
            
        //     JButton bun_temp=new JButton(list_chucnang_user.get(i));
        //     bun_temp.setPreferredSize(new Dimension(350,60));
        //     pan_chucnang.add(bun_temp);
        // }
        //set title chuong trinh
        lab_title_menu_main.setBounds(250,10,400,50);
        lab_title_menu_main.setForeground(Color.white);
        lab_title_menu_main.setHorizontalAlignment(SwingConstants.CENTER);
        lab_title_menu_main.setFont(new Font("Segoe UI", 3, 30));
        pan_background.add(lab_title_menu_main);
        //set panel info 
        pan_info.setBounds(500, 100, 450, 530);
        pan_info.setBackground(Color.cyan);
        pan_background.add(pan_info);
                
        
        
        
        frame1.setVisible(true);
        //thoat chuong trinh
        lab_icon_exit.addMouseListener(new MouseAdapter(){
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_menu(evt);
            }

            private void exit_menu(MouseEvent evt) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        user_login user=new user_login("kh3566","1","1","1");
        //user_login user=new user_login("admin0001","1","1","1");
        new menu_main(user);
    }

    
}
    


