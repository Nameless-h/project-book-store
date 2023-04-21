package GUI;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.quanlinhomquyen;

import javax.swing.JPanel;

public class danhsachnhomquyen extends JPanel implements MouseListener {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    quanlinhomquyen chucnang = new quanlinhomquyen();
    // -------------------------------
    String[] collums = { "STT", "Ma nhom quyen", "Ten nhom quyen", "Ngay tao", "Ngay cap nhat", "Chi tiet nhom quyen" };
    String[] list_timkiem = { "Tat ca", "Ma nhom quyen", "Ten nhom quyen" };
    // --------------------------------------------
    JComboBox combo_timkiem;
    JTextField txt_timkiem;
    JTable tab_danhsach;
    JScrollPane thanhcuon;
    JPanel pan_chucnang1, pan_chucnang2, pan_timkiem;
    JButton bun_them, bun_xoa, bun_sua, bun_timkiem, bun_lammoi;

    public danhsachnhomquyen(main obj) {
        this.obj = obj;
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        // set panel cac chuc nag co ban them ,xoa,sua,..
        pan_chucnang1 = new JPanel();
        pan_chucnang1.setBounds(0, 0, obj.w_center, 50);
        pan_chucnang1.setBackground(color_211);
        pan_chucnang1.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_chucnang1);
        // nut them
        bun_them = new JButton("Them");
        bun_them.setPreferredSize(new Dimension(200, 40));
        bun_them.setFont(new Font(name_font1, 1, 20));
        pan_chucnang1.add(bun_them);
        // nut xoa
        bun_xoa = new JButton("Xoa");
        bun_xoa.setPreferredSize(new Dimension(200, 40));
        bun_xoa.setFont(new Font(name_font1, 1, 20));
        pan_chucnang1.add(bun_xoa);
        // nut sua
        bun_sua = new JButton("Sua");
        bun_sua.setPreferredSize(new Dimension(200, 40));
        bun_sua.setFont(new Font(name_font1, 1, 20));
        pan_chucnang1.add(bun_sua);
        // ---------
        bun_them.addMouseListener(this);
        bun_sua.addMouseListener(this);
        bun_xoa.addMouseListener(this);
        // cai dat panel chuc nang 2
        pan_chucnang2 = new JPanel();
        pan_chucnang2.setBounds(0, 60, obj.w_center, 100);
        pan_chucnang2.setBackground(color_211);
        pan_chucnang2.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_chucnang2);
        // set panel tim kiem
        pan_timkiem = new JPanel();
        pan_timkiem.setPreferredSize(new Dimension(600, 60));
        pan_timkiem.setBackground(color_211);
        pan_timkiem.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Tim kiem",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_timkiem.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_chucnang2.add(pan_timkiem);
        // set combo box list tim kiem
        combo_timkiem = new JComboBox(list_timkiem);
        combo_timkiem.setPreferredSize(new Dimension(150, 30));
        pan_timkiem.add(combo_timkiem);
        // set text field o tim kiem
        txt_timkiem = new JTextField();
        txt_timkiem.setPreferredSize(new Dimension(150, 30));
        txt_timkiem.setFont(new Font(name_font1, 1, 15));
        pan_timkiem.add(txt_timkiem);
        // set nut tim kiem
        bun_timkiem = new JButton("Tim kiem");
        bun_timkiem.setPreferredSize(new Dimension(100, 30));
        pan_timkiem.add(bun_timkiem);
        bun_lammoi = new JButton("Lam moi");
        bun_lammoi.setPreferredSize(new Dimension(100, 30));
        pan_timkiem.add(bun_lammoi);
        bun_timkiem.addMouseListener(this);
        bun_lammoi.addMouseListener(this);
        // set bang nhan vien
        tab_danhsach = new JTable();
        tab_danhsach.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tab_danhsach.setModel(new DefaultTableModel(new Object[][] {}, collums));
        tab_danhsach.addMouseListener(this);
        chucnang.hienthidanhsach_nhomquyen(tab_danhsach);
        thanhcuon = new JScrollPane(tab_danhsach);
        thanhcuon.setBounds(0, 200, obj.w_center, obj.h_center - 200);
        this.add(thanhcuon);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bun_them) {
            int rowCount = tab_danhsach.getRowCount();
            Integer ma = Integer.parseInt(tab_danhsach.getValueAt(rowCount - 1, 1).toString());
            themnhomquyen panel = new themnhomquyen(obj, ma + 1);
            panel.setBounds(0, 0, obj.w_center, obj.h_center);
            obj.center.removeAll();
            obj.center.add(panel);
            obj.center.repaint();
            obj.center.revalidate();
        } else if (e.getSource() == bun_sua) {
            DefaultTableModel model = (DefaultTableModel) tab_danhsach.getModel();
            int selectrow = tab_danhsach.getSelectedRow();
            if (selectrow == -1) {
                JOptionPane.showMessageDialog(null, "Ban chua chon nhom quyen de sua");
            } else {
                Integer ma = Integer.parseInt(model.getValueAt(selectrow, 1).toString());
                String ten = model.getValueAt(selectrow, 2).toString();
                String ngaytao = model.getValueAt(selectrow, 3).toString();

                suanhomquyen panel = new suanhomquyen(obj, ma, ten, ngaytao);
                panel.setBounds(0, 0, obj.w_center, obj.h_center);
                obj.center.removeAll();
                obj.center.add(panel);
                obj.center.repaint();
                obj.center.revalidate();
            }
            // System.out.println(ma+ten);
        } else if (e.getSource() == bun_timkiem) {
            int tk = combo_timkiem.getSelectedIndex();
            String str = txt_timkiem.getText();
            if (chucnang.timkiem_vitri(tk, str, tab_danhsach) == false) {
                JOptionPane.showMessageDialog(this, "Khong ton tai nhom quyen nay", "Thong bao",
                        JOptionPane.WARNING_MESSAGE);
                chucnang.hienthidanhsach_nhomquyen(tab_danhsach);
            }

        } else if (e.getSource() == bun_lammoi) {
            txt_timkiem.setText("");
            chucnang.hienthidanhsach_nhomquyen(tab_danhsach);
            combo_timkiem.setSelectedIndex(0);
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
