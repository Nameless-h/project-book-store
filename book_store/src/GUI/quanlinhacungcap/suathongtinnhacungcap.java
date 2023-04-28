package GUI.quanlinhacungcap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlinhacungcap;
import DTO.nhacungcap;
import GUI.*;
import GUI.main_frame.main;

public class suathongtinnhacungcap extends JPanel implements MouseListener {
    main obj;
    // Color set.color_211 = new Color(211, 211, 211);
    // String set.font_time_roman = "Times Roman";
    quanlinhacungcap quanlinhacungcap = new quanlinhacungcap();
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    // ------------------------------
    String[] list_lab = { "Ma nha cung:", "Ten:", "Dia chi:", "Email:", "SDT:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    String[] thongtin;
    JPanel pan_info;
    String ma;
    JButton bun_sua;
    nhacungcap ncc;


    public suathongtinnhacungcap(main obj, nhacungcap ncc) {
        this.obj = obj;
        this.ncc = ncc;
        this.thongtin = ncc.getthongtin();
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

            txt[i] = new JTextField(thongtin[i]);
            if (i == 0) {
                txt[i].setText(String.valueOf(ncc.getMa()));
                txt[i].setEnabled(false);
            }

            txt[i].setPreferredSize(new Dimension(400, 50));
            txt[i].setForeground(Color.black);
            txt[i].setFont(new Font(set.font_time_roman, 1, 20));

            pan_info.add(txt[i]);

        }
        // pan_tinhtrang = new JPanel();
        // pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
        // "Cho phep",
        // TitledBorder.LEFT,
        // TitledBorder.TOP));
        // ;
        // pan_tinhtrang.setPreferredSize(new Dimension(690, 100));
        // pan_tinhtrang.setBackground(set.color_211);
        // pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        // pan_info.add(pan_tinhtrang);
        // rdb_chophep = new JRadioButton("Cho phep");
        // rdb_khongchophep = new JRadioButton("Khong cho phep");
        // if (ncc.getTinhtrang() == 1)
        // rdb_chophep.setSelected(true);
        // else
        // rdb_khongchophep.setSelected(true);
        // rdb_chophep.setPreferredSize(new Dimension(200, 50));
        // rdb_chophep.setFont(new Font(set.font_time_roman, 1, 25));
        // rdb_khongchophep.setPreferredSize(new Dimension(300, 50));
        // rdb_khongchophep.setFont(new Font(set.font_time_roman, 1, 25));
        // group2 = new ButtonGroup();
        // group2.add(rdb_chophep);
        // group2.add(rdb_khongchophep);

        // pan_tinhtrang.add(rdb_chophep);
        // pan_tinhtrang.add(rdb_khongchophep);

        bun_sua = new JButton("Sua", ic_lib.icon_repair);
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
            int ma = ncc.getMa();
            String ten = txt[1].getText();
            String dc = txt[2].getText();
            String email = txt[3].getText();
            String sdt = txt[4].getText();

            nhacungcap ncc = new nhacungcap(ma, ten, dc, email, sdt);
            // System.out.println(ncc);
            quanlinhacungcap.suanhacungcap(ncc);
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
