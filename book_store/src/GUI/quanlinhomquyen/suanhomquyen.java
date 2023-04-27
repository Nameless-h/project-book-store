package GUI.quanlinhomquyen;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;


import javax.swing.border.*;
import javax.swing.*;

import BUS.quanlichitietnhomquyen;
import BUS.quanlichucnang;
import BUS.quanlinhomquyen;
import DTO.chitietnhomquyen;
import DTO.chucnang;
import DTO.nhomquyen;
import GUI.*;
import GUI.main_frame.main;

public class suanhomquyen extends JPanel {
    quanlichucnang quanlichucnang = new quanlichucnang();
    quanlinhomquyen quanlinhomquyen = new quanlinhomquyen();
    quanlichitietnhomquyen quanlichitietnhomquyen = new quanlichitietnhomquyen();
    main obj;
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    // ---------------------
    // test

    // ----------------------
    JTextField txt_manhomquyen, txt_tennhomquyen, txt_ngaytao, txt_ngaycapnhat;
    JScrollPane thanhkeo;
    JPanel pan_info, pan_chucnang, pan_add;
    JButton bun_them;
    JScrollPane thanhcuon;
    int id;
    String ten,ngaytao;
    public suanhomquyen(main obj, int id,String ten,String ngaytao) {
        this.id = id;
        this.ten=ten;
        this.ngaytao=ngaytao;
        this.obj = obj;
        init(obj);
    }

    private void init(main init) {
        ArrayList<chitietnhomquyen> list_chitiet = quanlichitietnhomquyen.danhsachchitietnhomquyen_id(this.id);
        ArrayList<chucnang> list_chucnang = quanlichucnang.danhsachchucnang();
        LocalDate currentDate = LocalDate.now();
        String ngayhientai = currentDate.toString();
        // System.out.println("Ngày hiện tại là: " + currentDateStr);
        // --------------------------------------------------------
        this.setPreferredSize(new Dimension(set.w_center,set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        // set cac panel nho
        pan_info = new JPanel();
        pan_info.setBounds(0, 10, set.w_center, 80);
        pan_info.setLayout(new FlowLayout(FlowLayout.CENTER));
        pan_info.setBackground(set.color_211);
        this.add(pan_info);
        txt_manhomquyen = new JTextField(String.valueOf(id));
        txt_manhomquyen.setPreferredSize(new Dimension(200, 60));
        txt_manhomquyen.setFont(new Font(set.font_time_roman, 1, 25));
        txt_manhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ma nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_manhomquyen.setEnabled(false);
        pan_info.add(txt_manhomquyen);
        txt_tennhomquyen = new JTextField(ten);
        txt_tennhomquyen.setPreferredSize(new Dimension(300, 60));
        txt_tennhomquyen.setFont(new Font(set.font_time_roman, 1, 25));
        txt_tennhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ten nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_info.add(txt_tennhomquyen);
        txt_ngaytao = new JTextField(ngaytao);
        txt_ngaytao.setPreferredSize(new Dimension(200, 60));
        txt_ngaytao.setFont(new Font(set.font_time_roman, 1, 25));
        txt_ngaytao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ngay tao",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_ngaytao.setEnabled(false);
        pan_info.add(txt_ngaytao);
        txt_ngaycapnhat = new JTextField(ngayhientai);
        txt_ngaycapnhat.setPreferredSize(new Dimension(200, 60));
        txt_ngaycapnhat.setFont(new Font(set.font_time_roman, 1, 25));
        txt_ngaycapnhat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ngay cap nhat",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_ngaycapnhat.setEnabled(false);
        pan_info.add(txt_ngaycapnhat);
        pan_chucnang = new JPanel();
        pan_chucnang.setBounds(0, 90, set.w_center, 490);
        pan_chucnang.setBackground(set.color_211);
        pan_chucnang.setLayout(new GridLayout(3,5));
        thanhcuon=new JScrollPane(pan_chucnang);
        thanhcuon.setBounds(0, 90, set.w_center, 490);
        this.add(thanhcuon);
        // thanhkeo=new JScrollPane(pan_chucnang);
        JPanel[] pan = new JPanel[list_chucnang.size()];
        for (int i = 0; i < list_chucnang.size(); i++) {
            pan[i] = new JPanel();
            pan[i].setPreferredSize(new Dimension(200, 230));
            pan[i].setBackground(set.color_211);
            pan[i].setLayout(new FlowLayout());
            pan[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                    list_chucnang.get(i).getTen(),
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
            ;

            for (int j = 0; j < list_chitiet.size(); j++) {
                if (list_chitiet.get(j).getMachucnang().equalsIgnoreCase(list_chucnang.get(i).getMa())) {
                    JCheckBox temp = new JCheckBox(
                            list_chitiet.get(j).getHanhdong() + " " + list_chucnang.get(i).getMa());
                    temp.setFont(new Font("Segoe UI", 1, 20));
                    temp.setPreferredSize(new Dimension(190, 50));
                    temp.setBackground(set.color_211);
                    temp.setForeground(Color.black);
                    if(list_chitiet.get(j).getTinhtrang()==1)
                    temp.setSelected(true);
                    else
                    temp.setSelected(false);
                    temp.addItemListener(new ItemListener() {
                        public void itemStateChanged(ItemEvent e) {
                            if (e.getStateChange() == ItemEvent.SELECTED) {
                                String[] words = temp.getText().split("\\s+");
                                for (int k = 0; k < list_chitiet.size(); k++) {
                                    if (list_chitiet.get(k).getMachucnang().equalsIgnoreCase(words[1])
                                            && list_chitiet.get(k).getHanhdong().equalsIgnoreCase(words[0])) {
                                        list_chitiet.get(k).setTinhtrang(1);
                                    }
                                }
                            } else {
                                String[] words = temp.getText().split("\\s+");
                                for (int k = 0; k < list_chitiet.size(); k++) {
                                    if (list_chitiet.get(k).getMachucnang().equalsIgnoreCase(words[1])
                                            && list_chitiet.get(k).getHanhdong().equalsIgnoreCase(words[0])) {
                                        list_chitiet.get(k).setTinhtrang(0);
                                    }
                                }
                            }
                        }
                    });
                    // temp.addItemListener(this);
                    pan[i].add(temp);
                }

            }
            pan_chucnang.add(pan[i]);
        }
        // thanhcuon=new JScrollPane(pan_chucnang);
        // thanhcuon.setBounds(0, 100, set.w_center, 480);
        // this.add(thanhcuon);
        pan_add = new JPanel();
        pan_add.setBounds(0, 600, set.w_center, 60);
        pan_add.setBackground(set.color_211);
        pan_add.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_add);
        bun_them = new JButton("Sua",ic_lib.icon_repair);
        bun_them.setPreferredSize(new Dimension(200, 50));
        bun_them.setFont(new Font(set.font_time_roman, 1, 25));
        bun_them.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {

                    nhomquyen nq = new nhomquyen(id, txt_tennhomquyen.getText(), ngaytao, ngayhientai);
                     quanlinhomquyen.suanhomquyen(nq);;
                     quanlichitietnhomquyen.suachitietnhomquyen(list_chitiet);
                    JOptionPane.showMessageDialog(null, "Sua nhom quyen thanh cong");
                
            }
        });
        pan_add.add(bun_them);
    }

}
