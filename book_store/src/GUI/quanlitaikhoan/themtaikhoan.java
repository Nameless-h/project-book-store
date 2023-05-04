package GUI.quanlitaikhoan;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.quanlinhanvien;
import BUS.quanlinhomquyen;
import BUS.quanlitaikhoan;
import DTO.taikhoan;
import GUI.*;
import GUI.main_frame.main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class themtaikhoan extends JPanel implements MouseListener {
    main obj;

    quanlinhomquyen quanlinhomquyen = new quanlinhomquyen();
    quanlinhanvien quanlinhanvien = new quanlinhanvien();
    quanlitaikhoan quanlitaikhoan = new quanlitaikhoan();
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    // ----------------------------
    JPanel pan_info;
    Integer[] list_manhomquyen = quanlinhomquyen.danhsach_manhomquyen();
    ArrayList<Integer> list_manhanvien = quanlinhanvien.danhsachmanhanvien_tt();
    Integer[] list_mnv = new Integer[list_manhanvien.size()];
    String[] list_tennhomquyen = quanlinhomquyen.danhsach_tennhomquyen();
    String[] list_lab = { "Ma tai khoan:", "Username:", "Password:", "Ma nhan vien:", "Nhom quyen:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length - 1];
    JComboBox com_tennhomquyen, com_manhanvien;
    JButton bun_them;
    int id;

    public themtaikhoan(main obj, int id) {
        this.obj = obj;
        this.id = id;
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(set.w_center, set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        // --
        pan_info = new JPanel();
        pan_info.setBounds(300, 10, set.w_center - 600, set.h_center - 100);
        pan_info.setBackground(set.color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Them tai khoan",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        this.add(pan_info);
        for (int i = 0; i < list_manhanvien.size(); i++)
            list_mnv[i] = list_manhanvien.get(i);
        for (int i = 0; i < list_lab.length; i++) {
            lab[i] = new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(250, 50));
            lab[i].setFont(new Font(set.font_time_roman, 1, 20));
            pan_info.add(lab[i]);
            if (i == 0) {
                txt[i] = new JTextField(String.valueOf(id));
                txt[i].setPreferredSize(new Dimension(300, 50));
                txt[i].setFont(new Font(set.font_time_roman, 1, 25));
                txt[i].setForeground(Color.black);
                txt[i].setEnabled(false);
                pan_info.add(txt[i]);
            } else if (i == 3) {
                com_manhanvien = new JComboBox(list_mnv);
                com_manhanvien.setPreferredSize(new Dimension(300, 50));
                com_manhanvien.setFont(new Font(set.font_time_roman, 1, 25));
                com_manhanvien.setForeground(Color.black);
                com_manhanvien.addMouseListener(this);
                pan_info.add(com_manhanvien);
            } else if (i == 4) {
                com_tennhomquyen = new JComboBox(list_tennhomquyen);
                com_tennhomquyen.setPreferredSize(new Dimension(500, 50));
                com_tennhomquyen.setForeground(Color.black);
                com_tennhomquyen.setFont(new Font(set.font_time_roman, 1, 25));
                com_tennhomquyen.addMouseListener(this);
                pan_info.add(com_tennhomquyen);
            } else {
                txt[i] = new JTextField();
                txt[i].setPreferredSize(new Dimension(300, 50));
                txt[i].setFont(new Font(set.font_time_roman, 1, 25));
                txt[i].setForeground(Color.black);
                pan_info.add(txt[i]);
            }
        }
        bun_them = new JButton("Them tai khoan", ic_lib.icon_add);
        bun_them.setBounds(400, 590, 300, 50);
        bun_them.setBackground(Color.red);
        bun_them.setFont(new Font(set.font_time_roman, 1, 25));
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
            int ma = this.id;
            String username = txt[1].getText();
            String password = txt[2].getText();
            int mnv_select = Integer.parseInt(com_manhanvien.getSelectedItem().toString());
            int mnq_select = list_manhomquyen[com_tennhomquyen.getSelectedIndex()];
            taikhoan tk = new taikhoan(ma, username, password, mnv_select, mnq_select, 1);
            quanlitaikhoan.themtaikhoan(tk);
            JOptionPane.showMessageDialog(null, "Them tai khoan thanh cong");
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
