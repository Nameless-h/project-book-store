package GUI;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.border.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DTO.chitietnhomquyen;
import DTO.chucnang;

public class suanhomquyen extends JPanel {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    // ---------------------
    // test

    // ----------------------
    JTextField txt_manhomquyen, txt_tennhomquyen;
    JScrollPane thanhkeo;
    JPanel pan_info, pan_chucnang, pan_add;
    JButton bun_them;
    String ma, ten;

    public suanhomquyen(main obj, String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
        this.obj = obj;
        init(obj);
    }

    private void init(main init) {
        ArrayList<chitietnhomquyen> list_chitiet = new ArrayList<>();
        ArrayList<chucnang> list_chucnang = new ArrayList<>();
        chitietnhomquyen temp1 = new chitietnhomquyen("Q1", "cn1", "Them", "0");
        chitietnhomquyen temp2 = new chitietnhomquyen("Q1", "cn1", "Sua", "1");
        chitietnhomquyen temp3 = new chitietnhomquyen("Q1", "cn1", "Xoa", "0");
        chitietnhomquyen temp4 = new chitietnhomquyen("Q2", "cn2", "Them", "1");
        chitietnhomquyen temp5 = new chitietnhomquyen("Q2", "cn2", "Sua", "0");
        chitietnhomquyen temp6 = new chitietnhomquyen("Q2", "cn2", "Xoa", "1");

        // --
        chucnang temp7 = new chucnang("cn1", "Quan li");
        chucnang temp8 = new chucnang("cn2", "Nhan vien");
        list_chitiet.add(temp1);
        list_chitiet.add(temp2);
        list_chitiet.add(temp3);
        list_chitiet.add(temp4);
        list_chitiet.add(temp5);
        list_chitiet.add(temp6);
        list_chucnang.add(temp7);
        list_chucnang.add(temp8);
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
        txt_manhomquyen = new JTextField(ma);
        txt_manhomquyen.setPreferredSize(new Dimension(300, 60));
        txt_manhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_manhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ma nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        txt_manhomquyen.setEnabled(false);
        pan_info.add(txt_manhomquyen);
        txt_tennhomquyen = new JTextField(ten);
        txt_tennhomquyen.setPreferredSize(new Dimension(400, 60));
        txt_tennhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_tennhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ten nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_info.add(txt_tennhomquyen);
        pan_chucnang = new JPanel();
        pan_chucnang.setBounds(0, 100, obj.w_center, 480);
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
                    JCheckBox temp = new JCheckBox(list_chitiet.get(j).getHanhdong());
                    temp.setFont(new Font("Segoe UI", 1, 20));
                    temp.setPreferredSize(new Dimension(190, 50));
                    temp.setBackground(color_211);
                    temp.setForeground(Color.black);
                    if (list_chitiet.get(j).getTinhtrang().equalsIgnoreCase("1"))
                        temp.setSelected(true);
                    else
                        temp.setSelected(false);

                    pan[i].add(temp);
                }
            }
            pan_chucnang.add(pan[i]);
        }
        pan_add = new JPanel();
        pan_add.setBounds(0, 600, obj.w_center, 60);
        pan_add.setBackground(color_211);
        pan_add.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_add);
        bun_them = new JButton("Them");
        bun_them.setPreferredSize(new Dimension(200, 50));
        bun_them.setFont(new Font(name_font1, 1, 25));
        pan_add.add(bun_them);
    }
}