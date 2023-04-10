package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.concurrent.ThreadLocalRandom;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;

import function_user.detail_fun_group;
import function_user.function;

public class add_group_function extends JPanel implements MouseListener  {
    JPanel pan_txt_add, pan_fun;
    JLabel title1, id_grp, name_grp, datecrt, dateup, title2, bun_add;
    JTextField txt_id_grp, txt_name_grp, txt_datecrt, txt_dateup;
    // lay ngay hien tai
    LocalDate time_present = LocalDate.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    String str_dat_pre = time_present.format(dateFormatter);
    // test

    public add_group_function(int w,int h) {
        init(w,h);
    }

    private void init(int w,int h) {

        // test
        ArrayList<detail_fun_group> list1 = new ArrayList<>();
        ArrayList<function> list2 = new ArrayList<>();
        detail_fun_group test1 = new detail_fun_group("1", "1", "Them", "1");
        function test1_fu = new function("1", "Admin");
        detail_fun_group test2 = new detail_fun_group("1", "1", "Xoa", "1");
        detail_fun_group test3 = new detail_fun_group("2", "2", "Can thiep", "1");
        function test3_fu = new function("2", "Customer");
        detail_fun_group test4 = new detail_fun_group("2", "2", "Edit", "1");
        list1.add(test1);
        list1.add(test2);
        list1.add(test3);
        list1.add(test4);
        list2.add(test1_fu);
        list2.add(test3_fu);

        // khoi tao panel
        this.setPreferredSize(new Dimension(w,h));
        this.setBackground(new Color(54, 54, 54));
        this.setLayout(null);
        // set title1
        title1 = new JLabel("Add group function");
        title1.setBounds(0, 0, w, 50);
        title1.setFont(new Font("Segoe UI", 1, 30));
        title1.setOpaque(true);
        title1.setBackground(Color.red);
        title1.setForeground(Color.white);
        title1.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title1);
        // set pan_txt_add
        pan_txt_add = new JPanel();
        pan_txt_add.setBounds(10, 60, 700, 250);
        pan_txt_add.setBackground(new Color(54, 54, 54));
        // pan_txt_add.setBackground(new Color(54, 54, 54));
        pan_txt_add.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
        this.add(pan_txt_add);
        // set id_grp va txt_id_grp
        id_grp = new JLabel("Group ID: ");
        id_grp.setPreferredSize(new Dimension(200, 40));
        id_grp.setOpaque(true);
        id_grp.setBackground(new Color(54, 54, 54));
        id_grp.setFont(new Font("Segoe UI", 1, 20));
        id_grp.setForeground(Color.white);
        pan_txt_add.add(id_grp);
        // ---
        int ranNum = ThreadLocalRandom.current().nextInt(10000001,99999999);
        String str_id_grp_fun="IGP"+String.valueOf(ranNum);
        txt_id_grp = new JTextField(str_id_grp_fun);
        txt_id_grp.setPreferredSize(new Dimension(400, 40));
        txt_id_grp.setBackground(new Color(28, 28, 28));
        txt_id_grp.setFont(new Font("Segoe UI", 1, 20));
        txt_id_grp.setForeground(Color.white);
        txt_id_grp.setBorder(BorderFactory.createLineBorder(Color.black));
        txt_id_grp.setEnabled(false);
        pan_txt_add.add(txt_id_grp);
        // set name_grp va txt_name_grp
        name_grp = new JLabel("Name group: ");
        name_grp.setPreferredSize(new Dimension(200, 40));
        name_grp.setOpaque(true);
        name_grp.setBackground(new Color(54, 54, 54));
        name_grp.setFont(new Font("Segoe UI", 1, 20));
        name_grp.setForeground(Color.white);
        pan_txt_add.add(name_grp);
        // ---
        txt_name_grp = new JTextField();
        txt_name_grp.setPreferredSize(new Dimension(400, 40));
        txt_name_grp.setBackground(new Color(28, 28, 28));
        txt_name_grp.setFont(new Font("Segoe UI", 1, 20));
        txt_name_grp.setForeground(Color.white);
        txt_name_grp.setBorder(BorderFactory.createLineBorder(Color.black));
        pan_txt_add.add(txt_name_grp);
        // set datecrt va txt_datexrt
        datecrt = new JLabel("Date created: ");
        datecrt.setPreferredSize(new Dimension(200, 40));
        datecrt.setOpaque(true);
        datecrt.setBackground(new Color(54, 54, 54));
        datecrt.setFont(new Font("Segoe UI", 1, 20));
        datecrt.setForeground(Color.white);
        pan_txt_add.add(datecrt);
        // ---
        txt_datecrt = new JTextField(str_dat_pre);
        txt_datecrt.setPreferredSize(new Dimension(400, 40));
        txt_datecrt.setBackground(new Color(28, 28, 28));
        txt_datecrt.setFont(new Font("Segoe UI", 1, 20));
        txt_datecrt.setForeground(Color.white);
        txt_datecrt.setBorder(BorderFactory.createLineBorder(Color.black));
        txt_datecrt.setEnabled(false);
        pan_txt_add.add(txt_datecrt);
        // set datecrt va txt_datexrt
        dateup = new JLabel("Date last update: ");
        dateup.setPreferredSize(new Dimension(200, 40));
        dateup.setOpaque(true);
        dateup.setBackground(new Color(54, 54, 54));
        dateup.setFont(new Font("Segoe UI", 1, 20));
        dateup.setForeground(Color.white);
        pan_txt_add.add(dateup);
        // ---
        txt_dateup = new JTextField(str_dat_pre);
        txt_dateup.setPreferredSize(new Dimension(400, 40));
        txt_dateup.setBackground(new Color(28, 28, 28));
        txt_dateup.setFont(new Font("Segoe UI", 1, 20));
        txt_dateup.setForeground(Color.white);
        txt_dateup.setBorder(BorderFactory.createLineBorder(Color.black));
        txt_dateup.setEnabled(false);
        pan_txt_add.add(txt_dateup);
        // set title2
        title2 = new JLabel("Function:");
        title2.setBounds(20, 310, 200, 50);
        title2.setFont(new Font("Segoe UI", 1, 20));
        title2.setOpaque(true);
        title2.setForeground(Color.white);
        title2.setBackground(new Color(54, 54, 54));
        this.add(title2);
        // set pan_fun
        pan_fun = new JPanel();
        pan_fun.setBounds(10, 370, 970, 250);
        pan_fun.setBackground(new Color(54, 54, 54));
        pan_fun.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pan_fun);
        JPanel[] pan = new JPanel[list2.size()];
        for (int i = 0; i < list2.size(); i++) {
            pan[i] = new JPanel();
            pan[i].setPreferredSize(new Dimension(200, 200));
            pan[i].setBackground(new Color(28, 28, 28));
            pan[i].setLayout(new FlowLayout());
            JLabel title_pan = new JLabel(list2.get(i).getName_fun());
            title_pan.setPreferredSize(new Dimension(200, 50));
            title_pan.setOpaque(true);
            title_pan.setBackground(new Color(28, 28, 28));
            title_pan.setFont(new Font("Segoe UI", 1, 20));
            title_pan.setForeground(Color.white);
            title_pan.setHorizontalAlignment(SwingConstants.CENTER);
            pan[i].add(title_pan);
            for (int j = 0; j < list1.size(); j++) {
                if (list1.get(j).getCode_fun().equalsIgnoreCase(list2.get(i).getCode_fun())) {
                    JCheckBox temp = new JCheckBox(list1.get(j).getAction());
                    temp.setFont(new Font("Segoe UI", 1, 20));
                    temp.setPreferredSize(new Dimension(200, 50));
                    temp.setBackground(new Color(28, 28, 28));
                    temp.setForeground(Color.white);
                    if (list1.get(j).getVisibel().equalsIgnoreCase("1"))
                        temp.setSelected(true);
                    else
                        temp.setSelected(false);
                    pan[i].add(temp);
                }
            }
            pan_fun.add(pan[i]);
        }
        bun_add=new JLabel("ADD");
        bun_add.setBounds(800,120,200,50);
        bun_add.setOpaque(true);
        bun_add.setForeground(Color.white);
        bun_add.setBackground(Color.red);
        bun_add.setFont(new Font("Segoe UI", 1, 30));
        bun_add.setHorizontalAlignment(SwingConstants.CENTER);
        bun_add.addMouseListener(this);
        this.add(bun_add);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==bun_add){
            bun_add.setBackground(Color.blue);
            bun_add.setFont(new Font("Segoe UI", 1, 40));
        }  
    }

    @Override
    public void mouseExited(MouseEvent e) {
         
        bun_add.setBackground(Color.red);
        bun_add.setFont(new Font("Segoe UI", 1, 30));  
    }
}
