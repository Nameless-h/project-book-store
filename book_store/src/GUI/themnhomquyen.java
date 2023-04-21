package GUI;

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

public class themnhomquyen extends JPanel {
    quanlichucnang quanlichucnang = new quanlichucnang();
    quanlinhomquyen quanlinhomquyen = new quanlinhomquyen();
    quanlichitietnhomquyen quanlichitietnhomquyen = new quanlichitietnhomquyen();
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    // ---------------------
    // test

    // ----------------------
    JTextField txt_manhomquyen, txt_tennhomquyen, txt_ngaytao, txt_ngaycapnhat;
    JScrollPane thanhkeo;
    JPanel pan_info, pan_chucnang, pan_add;
    JButton bun_them;
    JScrollPane thanhcuon;
    int id;

    public themnhomquyen(main obj, int id) {
        this.id = id;
        this.obj = obj;
        init(obj);
    }

    private void init(main init) {
        ArrayList<String> list_them = new ArrayList<>();
        ArrayList<chitietnhomquyen> list_chitiet = quanlichitietnhomquyen.danhsachchitietnhomquyen();
        ArrayList<chucnang> list_chucnang = quanlichucnang.danhsachchucnang();
        for (int i = 0; i < list_chitiet.size(); i++) {
            list_chitiet.get(i).setTinhtrang(0);
        }
        LocalDate currentDate = LocalDate.now();
        String ngayhientai = currentDate.toString();
        // System.out.println("Ngày hiện tại là: " + currentDateStr);
        // --------------------------------------------------------
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        // set cac panel nho
        pan_info = new JPanel();
        pan_info.setBounds(0, 10, obj.w_center, 80);
        pan_info.setLayout(new FlowLayout(FlowLayout.CENTER));
        pan_info.setBackground(color_211);
        this.add(pan_info);
        txt_manhomquyen = new JTextField(String.valueOf(id));
        txt_manhomquyen.setPreferredSize(new Dimension(200, 60));
        txt_manhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_manhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ma nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_manhomquyen.setEnabled(false);
        pan_info.add(txt_manhomquyen);
        txt_tennhomquyen = new JTextField();
        txt_tennhomquyen.setPreferredSize(new Dimension(300, 60));
        txt_tennhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_tennhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ten nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_info.add(txt_tennhomquyen);
        txt_ngaytao = new JTextField(ngayhientai);
        txt_ngaytao.setPreferredSize(new Dimension(200, 60));
        txt_ngaytao.setFont(new Font(name_font1, 1, 25));
        txt_ngaytao.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ngay tao",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_ngaytao.setEnabled(false);
        pan_info.add(txt_ngaytao);
        txt_ngaycapnhat = new JTextField(ngayhientai);
        txt_ngaycapnhat.setPreferredSize(new Dimension(200, 60));
        txt_ngaycapnhat.setFont(new Font(name_font1, 1, 25));
        txt_ngaycapnhat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ngay cap nhat",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_ngaycapnhat.setEnabled(false);
        pan_info.add(txt_ngaycapnhat);
        pan_chucnang = new JPanel();
        pan_chucnang.setBounds(0, 90, obj.w_center, 490);
        pan_chucnang.setBackground(color_211);
        pan_chucnang.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pan_chucnang);
        // thanhkeo=new JScrollPane(pan_chucnang);
        JPanel[] pan = new JPanel[list_chucnang.size()];
        for (int i = 0; i < list_chucnang.size(); i++) {
            pan[i] = new JPanel();
            pan[i].setPreferredSize(new Dimension(200, 230));
            pan[i].setBackground(color_211);
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
                    temp.setBackground(color_211);
                    temp.setForeground(Color.black);
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
        // thanhcuon.setBounds(0, 100, obj.w_center, 480);
        // this.add(thanhcuon);
        pan_add = new JPanel();
        pan_add.setBounds(0, 600, obj.w_center, 60);
        pan_add.setBackground(color_211);
        pan_add.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_add);
        bun_them = new JButton("Them");
        bun_them.setPreferredSize(new Dimension(200, 50));
        bun_them.setFont(new Font(name_font1, 1, 25));
        bun_them.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == bun_them) {
                    nhomquyen nq = new nhomquyen(id, txt_tennhomquyen.getText(), ngayhientai, ngayhientai);
                    quanlinhomquyen.themnhomquyen(nq);
                    quanlichitietnhomquyen.themchitietnhomquyen(id, list_chitiet);
                    JOptionPane.showMessageDialog(null, "Them nhom quyen thanh cong");
                }
            }
        });
        pan_add.add(bun_them);
    }

}
