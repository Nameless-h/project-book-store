package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import DTO.khachhang;

public class suathongtinkhachhang extends JPanel {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Diem tich luy:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    String[] thongtin;
    JPanel pan_info, pan_tinhtrang;
    String ma;
    JButton bun_them;
    JCheckBox chk_chophep, chk_khong;
    khachhang kh;

    public suathongtinkhachhang(main obj, khachhang kh) {
        this.obj = obj;
        this.kh = kh;
        this.thongtin = kh.getthongtin();
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, obj.w_center - 400, obj.h_center - 100);
        pan_info.setBackground(color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Them khach hang",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        this.add(pan_info);
        for (int i = 0; i < list_lab.length; i++) {

            lab[i] = new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(200, 50));
            lab[i].setFont(new Font(name_font1, 1, 20));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab[i].setBackground(color_211);
            lab[i].setForeground(Color.black);
            txt[i] = new JTextField(thongtin[i]);
            if (i == 0) {
                txt[i].setEnabled(false);
            }

            txt[i].setPreferredSize(new Dimension(400, 50));
            txt[i].setForeground(Color.black);
            txt[i].setFont(new Font(name_font1, 1, 20));

            pan_info.add(lab[i]);
            pan_info.add(txt[i]);
        }
        pan_tinhtrang = new JPanel();
        pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Cho phep",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_tinhtrang.setPreferredSize(new Dimension(690, 100));
        pan_tinhtrang.setBackground(color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        chk_chophep = new JCheckBox("Cho phep");
        chk_chophep.setPreferredSize(new Dimension(150, 50));
        chk_chophep.setFont(new Font(name_font1, 1, 25));
        chk_khong = new JCheckBox("Khong cho phep");
        chk_khong.setPreferredSize(new Dimension(250, 50));
        chk_khong.setFont(new Font(name_font1, 1, 22));
        if (kh.getTinhtrang().equalsIgnoreCase("hien")) {
            chk_chophep.setSelected(true);
            chk_khong.setSelected(false);
        } else {
            chk_chophep.setSelected(false);
            chk_khong.setSelected(true);
        }
        pan_tinhtrang.add(chk_chophep);
        pan_tinhtrang.add(chk_khong);

        bun_them = new JButton("Sua");
        bun_them.setBounds(400, 590, 300, 50);
        bun_them.setBackground(Color.red);
        bun_them.setFont(new Font(name_font1, 1, 25));
        bun_them.setHorizontalAlignment(SwingConstants.CENTER);
        bun_them.setForeground(Color.white);
        this.add(bun_them);
    }

    private void hienthongtin() {

    }
}
