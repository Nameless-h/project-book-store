package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlinhanvien;
import DTO.chucnang;
import DTO.nhanvien;

public class suathongtinnhanvien extends JPanel {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    quanlinhanvien quanlinhanvien = new quanlinhanvien();
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Chuc vu" };
    JLabel[] lab = new JLabel[list_lab.length];
    String[] thongtin;
    JTextField[] txt = new JTextField[list_lab.length];
    JPanel pan_info;
    nhanvien nv;
    JButton bun_sua;
    JRadioButton rdb_nam, rdb_nu;
    ButtonGroup group;

    public suathongtinnhanvien(main obj, nhanvien nv) {
        this.nv = nv;
        this.obj = obj;
        this.thongtin = nv.getthongtin();
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, obj.w_center - 400, obj.h_center - 150);
        pan_info.setBackground(color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 20));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Sua thong tin",
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
            pan_info.add(lab[i]);
            if (i == 2) {
                rdb_nam = new JRadioButton("Nam");
                rdb_nu = new JRadioButton("Nu");
                if (nv.getGioitinh() == 1)
                    rdb_nam.setSelected(true);
                else
                    rdb_nu.setSelected(true);
                rdb_nam.setPreferredSize(new Dimension(200, 50));
                rdb_nam.setFont(new Font(name_font1, 1, 25));
                rdb_nu.setPreferredSize(new Dimension(200, 50));
                rdb_nu.setFont(new Font(name_font1, 1, 25));
                group = new ButtonGroup();
                group.add(rdb_nam);
                group.add(rdb_nu);

                pan_info.add(rdb_nam);
                pan_info.add(rdb_nu);
            } else {
                txt[i] = new JTextField(thongtin[i]);
                if (i == 0) {
                    txt[i].setText(String.valueOf(nv.getMa()));
                    txt[i].setEnabled(false);
                }

                txt[i].setPreferredSize(new Dimension(400, 50));
                txt[i].setForeground(Color.black);
                txt[i].setFont(new Font(name_font1, 1, 20));

                pan_info.add(txt[i]);
            }
        }
        bun_sua = new JButton("Sua");
        bun_sua.setBounds(400, 590, 300, 50);
        bun_sua.setBackground(Color.red);
        bun_sua.setFont(new Font(name_font1, 1, 25));
        bun_sua.setHorizontalAlignment(SwingConstants.CENTER);
        bun_sua.setForeground(Color.white);
        bun_sua.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int gt = 1;
                if (rdb_nam.isSelected())
                    gt = 1;
                if (rdb_nu.isSelected())
                    gt = 0;
                nhanvien nv = new nhanvien(Integer.parseInt(txt[0].getText()), txt[1].getText(), gt,
                        txt[3].getText(),
                        txt[4].getText(), txt[5].getText(), txt[6].getText());
                quanlinhanvien.suathongtinnhanvien(nv);
                JOptionPane.showMessageDialog(null, "Sua thanh cong");
            }
        });
        this.add(bun_sua);
    }
}
