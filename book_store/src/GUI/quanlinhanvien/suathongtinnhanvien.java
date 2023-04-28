package GUI.quanlinhanvien;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlinhanvien;
import DTO.chucnang;
import DTO.nhanvien;
import GUI.icon_lib;
import GUI.setting_frame;
import GUI.main_frame.main;

public class suathongtinnhanvien extends JPanel {
    main obj;
    // Color set.color_211 = new Color(211, 211, 211);
    // String name_font1 = "Times Roman";
    quanlinhanvien quanlinhanvien = new quanlinhanvien();
    // goi thu vien icon
    icon_lib ic_lib = new icon_lib();
    // goi thu vien cai dat da co san
    setting_frame set = new setting_frame();
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Chuc vu" };
    JLabel[] lab = new JLabel[list_lab.length];
    String[] thongtin;
    JTextField[] txt = new JTextField[list_lab.length];
    JPanel pan_info, pan_tinhtrang;
    nhanvien nv;
    JButton bun_sua;
    JRadioButton rdb_nam, rdb_nu;
    int tinhtrang;
    JRadioButton rdb_chophep, rdb_khongchophep;
    ButtonGroup group1, group2;

    public suathongtinnhanvien(main obj, nhanvien nv) {
        this.nv = nv;
        this.obj = obj;
        this.thongtin = nv.getthongtin();
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(set.w_center, set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, set.w_center - 400, set.h_center - 150);
        pan_info.setBackground(set.color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Sua thong tin",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        this.add(pan_info);
        for (int i = 0; i < list_lab.length; i++) {

            lab[i] = new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(200, 40));
            lab[i].setFont(new Font(set.font_time_roman, 1, 20));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab[i].setBackground(set.color_211);
            lab[i].setForeground(Color.black);
            pan_info.add(lab[i]);
            if (i == 2) {
                rdb_nam = new JRadioButton("Nam");
                rdb_nu = new JRadioButton("Nu");
                if (nv.getGioitinh() == 1)
                    rdb_nam.setSelected(true);
                else
                    rdb_nu.setSelected(true);
                rdb_nam.setPreferredSize(new Dimension(200, 50));
                rdb_nam.setFont(new Font(set.font_time_roman, 1, 25));
                rdb_nu.setPreferredSize(new Dimension(200, 50));
                rdb_nu.setFont(new Font(set.font_time_roman, 1, 25));
                group1 = new ButtonGroup();
                group1.add(rdb_nam);
                group1.add(rdb_nu);

                pan_info.add(rdb_nam);
                pan_info.add(rdb_nu);
            } else {
                txt[i] = new JTextField(thongtin[i]);
                if (i == 0) {
                    txt[i].setText(String.valueOf(nv.getMa()));
                    txt[i].setEnabled(false);
                }

                txt[i].setPreferredSize(new Dimension(400, 40));
                txt[i].setForeground(Color.black);
                txt[i].setFont(new Font(set.font_time_roman, 1, 20));

                pan_info.add(txt[i]);
            }
        }
        pan_tinhtrang = new JPanel();
        pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Cho phep",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_tinhtrang.setPreferredSize(new Dimension(480, 100));
        pan_tinhtrang.setBackground(set.color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        rdb_chophep = new JRadioButton("Cho phep");
        rdb_khongchophep = new JRadioButton("Khong cho phep");
        if (nv.getTinhtrang() == 1)
            rdb_chophep.setSelected(true);
        else
            rdb_khongchophep.setSelected(true);
        rdb_chophep.setPreferredSize(new Dimension(200, 50));
        rdb_chophep.setFont(new Font(set.font_time_roman, 1, 20));
        rdb_khongchophep.setPreferredSize(new Dimension(200, 50));
        rdb_khongchophep.setFont(new Font(set.font_time_roman, 1, 20));
        group2 = new ButtonGroup();
        group2.add(rdb_chophep);
        group2.add(rdb_khongchophep);
        pan_tinhtrang.add(rdb_chophep);
        pan_tinhtrang.add(rdb_khongchophep);

        pan_tinhtrang.add(rdb_chophep);
        pan_tinhtrang.add(rdb_khongchophep);
        bun_sua = new JButton("Sua", ic_lib.icon_repair);
        bun_sua.setBounds(400, 590, 300, 50);
        bun_sua.setBackground(Color.red);
        bun_sua.setFont(new Font(set.font_time_roman, 1, 25));
        bun_sua.setHorizontalAlignment(SwingConstants.CENTER);
        bun_sua.setForeground(Color.white);
        bun_sua.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int gt = 1;
                if (rdb_nam.isSelected())
                    gt = 1;
                if (rdb_nu.isSelected())
                    gt = 0;
                int tt = 1;
                if (rdb_chophep.isSelected())
                    tt = 1;
                if (rdb_khongchophep.isSelected())
                    tt = 0;
                nhanvien nv = new nhanvien(Integer.parseInt(txt[0].getText()), txt[1].getText(), gt,
                        txt[3].getText(),
                        txt[4].getText(), txt[5].getText(), txt[6].getText(), tt);
                quanlinhanvien.suathongtinnhanvien(nv);
                JOptionPane.showMessageDialog(null, "Sua thanh cong");
            }
        });
        this.add(bun_sua);
    }
}
