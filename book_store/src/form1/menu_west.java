package form1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.lang.model.util.ElementScanner14;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.AncestorListener;

// import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import com.formdev.flatlaf.FlatLightLaf;

import sale.sale_frame;

public class menu_west extends JPanel implements MouseListener, ActionListener {
    menu obj;
    JLabel title;
    String[] list = { "Function group", "Quan li nhan vien", "Chuc nang 3", "Chuc nang 4" };
    Integer[] list2 = new Integer[list.length];
    JLabel[] lab_menu = new JLabel[list.length];
    public static JFrame temp1=null;
    int temp=0;
    public menu_west(menu obj,int width,int heigh) {
        this.obj=obj;
        init(width,heigh);
    }
    public void change_panel(String s) throws IOException{

        if(s.equalsIgnoreCase("Function group")){
                group_function pan_grp_fun=new group_function(obj);
                pan_grp_fun.setBounds(0,0,1000,700);
                obj.pan_center.removeAll();
                obj.pan_center.add(pan_grp_fun);
                obj.pan_center.repaint();
                obj.pan_center.revalidate();
                System.out.println(obj.hih_center);

        }
        else if(s.equalsIgnoreCase("Ban hang")){
                FlatLightLaf.setup();
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                } catch (Exception e) {
                    // TODO: handle exception
                }
                sale_frame pan_grp_fun= new sale_frame();
                pan_grp_fun.setBounds(0,0,1100,700);
                obj.pan_center.removeAll();
                obj.pan_center.add(pan_grp_fun);
                obj.pan_center.repaint();
                obj.pan_center.revalidate();

                }
        }
        else if(s.equalsIgnoreCase("Quan li nhan vien")){
            pan_staff pan_user=new pan_staff(obj);

            pan_user.setBounds(0,0,1000,700);
            obj.pan_center.removeAll();
            obj.pan_center.add(pan_user);
            obj.pan_center.repaint();
            obj.pan_center.revalidate();

        }
    }
    private void init(int width,int heigh) {
        this.setPreferredSize(new Dimension(width,heigh));
        // this.setBackground(new Color(50,168, 76));
        this.setBackground(Color.black);
        this.setLayout(null);
        // set title cho panel chuc nang
        title = new JLabel("Menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", 3, 38));
        title.setForeground(Color.white);
        title.setBounds(10, 20, 200, 40);
        // title.setOpaque(true);
        // title.setBackground(Color.gray);
        this.add(title);
        // set panel chuc nag
        // 50 168 76
        JPanel pan_menu = new JPanel();
        pan_menu.setBackground(Color.black);
        pan_menu.setBounds(0, 90, 200, 450);
        pan_menu.setLayout(new FlowLayout(0, 1, 5));
        this.add(pan_menu);
        // set cac menu chuc nang
        for (int i = 0; i < list.length; i++) {
            list2[i] = 0;
            lab_menu[i] = new JLabel(list[i]);
            lab_menu[i].setHorizontalAlignment(SwingConstants.CENTER);
            // lab_menu[i].setFont(new Font("Segoe UI",0,24));
            lab_menu[i].setPreferredSize(new Dimension(180, 50));
            lab_menu[i].setFont(new Font("Segoe UI", 0, 20));
            lab_menu[i].setForeground(Color.white);
            lab_menu[i].setOpaque(true);
            lab_menu[i].setBackground(Color.black);
            // lab_menu[i].setBorder(BorderFactory.createLineBorder(Color.black));
            lab_menu[i].addMouseListener(this);
            // lab_menu[i].addActionListener(new ActionListener());
            pan_menu.add(lab_menu[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < list.length; i++) {
            if (e.getSource() == lab_menu[i]) {
                change_panel(lab_menu[i].getText());
                lab_menu[i].setBackground(new Color(54,54,54));
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < list.length; i++) {
            if (e.getSource() == lab_menu[i]) {
                lab_menu[i].setBackground(Color.white);
                lab_menu[i].setFont(new Font("Segoe UI", 1, 21));
                lab_menu[i].setForeground(Color.black);
            }

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < list.length; i++) {
            if (list2[i] == 0) {
                lab_menu[i].setBackground(Color.black);
                lab_menu[i].setForeground(Color.white);
                lab_menu[i].setFont(new Font("Segoe UI", 0, 20));
            } else {
                lab_menu[i].setBackground(new Color(54, 54, 54));
                lab_menu[i].setFont(new Font("Segoe UI", 1, 30));
                lab_menu[i].setForeground(Color.white);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}

