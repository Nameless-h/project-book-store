package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlinhanvien;
import DTO.nhanvien;

public class themnhanvien extends JPanel implements MouseListener {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Chuc vu" };
    String[] list_giotinh = { "Nam", "Nu" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    JPanel pan_info;
    Integer ma;
    JButton bun_them;
    JComboBox com_gioitinh;
    quanlinhanvien chucnang_nhanvien = new quanlinhanvien();
    JRadioButton rdb_nam, rdb_nu;
    ButtonGroup group;

    public themnhanvien(main obj, Integer ma) {
        this.obj = obj;
        this.ma = ma;
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
                "Them nhan vien",
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
                rdb_nam = new JRadioButton("Nam", true);
                rdb_nu = new JRadioButton("Nu");
                rdb_nam.setPreferredSize(new Dimension(200, 50));
                rdb_nam.setFont(new Font(name_font1, 1, 25));
                rdb_nu.setPreferredSize(new Dimension(200, 50));
                rdb_nu.setFont(new Font(name_font1, 1, 25));
                group = new ButtonGroup();
                group.add(rdb_nam);
                group.add(rdb_nu);
                rdb_nam.addMouseListener(this);
                rdb_nu.addMouseListener(this);
                pan_info.add(rdb_nam);
                pan_info.add(rdb_nu);
            } else {
                txt[i] = new JTextField();
                if (i == 0) {
                    txt[i].setText(String.valueOf(ma));
                    txt[i].setEnabled(false);
                }

                txt[i].setPreferredSize(new Dimension(400, 50));
                txt[i].setForeground(Color.black);
                txt[i].setFont(new Font(name_font1, 1, 20));

                pan_info.add(txt[i]);
            }
            

        }
        bun_them = new JButton("Them");
        bun_them.setBounds(400, 590, 300, 50);
        bun_them.setBackground(Color.red);
        bun_them.setFont(new Font(name_font1, 1, 25));
        bun_them.setHorizontalAlignment(SwingConstants.CENTER);
        bun_them.setForeground(Color.white);
        bun_them.addMouseListener(this);
        this.add(bun_them);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bun_them) {
            int gt=1;
            if (rdb_nam.isSelected()) {
                gt=1;
            }
            if (rdb_nu.isSelected()) {
                gt=0;
            }
                Integer manv = this.ma;
                String ten = txt[1].getText();
                String dc = txt[3].getText();
                String email = txt[4].getText();
                String sdt = txt[5].getText();
                String cv = txt[6].getText();
                nhanvien nv = new nhanvien(manv, ten, gt, dc, email, sdt, cv);
                chucnang_nhanvien.themnhanvien(nv);
                JOptionPane.showMessageDialog(null, "Them thanh cong");
           

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

   
}
