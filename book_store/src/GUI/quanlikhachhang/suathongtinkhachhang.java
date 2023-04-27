package GUI.quanlikhachhang;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlikhachhang;
import DTO.khachhang;
import GUI.*;
import GUI.main_frame.main;

public class suathongtinkhachhang extends JPanel implements  MouseListener {
    main obj;
    // Color set.color_211 = new Color(211, 211, 211);
    // String set.font_time_roman = "Times Roman";
    quanlikhachhang quanlikhachhang = new quanlikhachhang();
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Diem tich luy:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    String[] thongtin;
    JPanel pan_info, pan_tinhtrang;
    String ma;
    JButton bun_sua;
    JCheckBox chk_chophep, chk_khong;
    khachhang kh;
    int tinhtrang;
    JRadioButton rdb_nam, rdb_nu, rdb_chophep, rdb_khongchophep;
    ButtonGroup group1, group2;

    public suathongtinkhachhang(main obj, khachhang kh) {
        this.obj = obj;
        this.kh = kh;
        this.thongtin = kh.getthongtin();
        this.tinhtrang = kh.getTinhtrang();
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(set.w_center, set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, set.w_center - 400, set.h_center - 100);
        pan_info.setBackground(set.color_211);
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
            lab[i].setFont(new Font(set.font_time_roman, 1, 20));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab[i].setBackground(set.color_211);
            lab[i].setForeground(Color.black);
            pan_info.add(lab[i]);
            txt[i] = new JTextField(thongtin[i]);
            if (i == 2) {
                rdb_nam = new JRadioButton("Nam");
                rdb_nu = new JRadioButton("Nu");
                if (kh.getGioitinh() == 1)
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
                    txt[i].setText(String.valueOf(kh.getMa()));
                    txt[i].setEnabled(false);
                }

                txt[i].setPreferredSize(new Dimension(400, 50));
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
        pan_tinhtrang.setPreferredSize(new Dimension(690, 100));
        pan_tinhtrang.setBackground(set.color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        rdb_chophep = new JRadioButton("Cho phep");
        rdb_khongchophep = new JRadioButton("Khong cho phep");
        if (kh.getTinhtrang() == 1)
            rdb_chophep.setSelected(true);
        else
            rdb_khongchophep.setSelected(true);
        rdb_chophep.setPreferredSize(new Dimension(200, 50));
        rdb_chophep.setFont(new Font(set.font_time_roman, 1, 25));
        rdb_khongchophep.setPreferredSize(new Dimension(300, 50));
        rdb_khongchophep.setFont(new Font(set.font_time_roman, 1, 25));
        group2 = new ButtonGroup();
        group2.add(rdb_chophep);
        group2.add(rdb_khongchophep);

        pan_tinhtrang.add(rdb_chophep);
        pan_tinhtrang.add(rdb_khongchophep);

        bun_sua = new JButton("Sua",ic_lib.icon_repair);
        bun_sua.setBounds(400, 590, 300, 50);
        bun_sua.setBackground(Color.red);
        bun_sua.setFont(new Font(set.font_time_roman, 1, 25));
        bun_sua.setHorizontalAlignment(SwingConstants.CENTER);
        bun_sua.setForeground(Color.white);
        bun_sua.addMouseListener(this);
        this.add(bun_sua);
    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bun_sua) {
            int ma = kh.getMa();
            String ten = txt[1].getText();
            int gt = 1;
                if (rdb_nam.isSelected())
                    gt = 1;
                if (rdb_nu.isSelected())
                    gt = 0;
            String dc = txt[3].getText();
            String email = txt[4].getText();
            String sdt = txt[5].getText();
            int tt = 1;
                if (rdb_chophep.isSelected())
                    tt = 1;
                if (rdb_khongchophep.isSelected())
                    tt = 0;
            int diem = Integer.parseInt(txt[6].getText());
            khachhang kh = new khachhang(ma, ten, gt, dc, email, sdt, diem, tt);
            // System.out.println(kh);
            quanlikhachhang.suathongtinkhachhang(kh);
            JOptionPane.showMessageDialog(null, "Sua thong tin khach hang thanh cong");
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
