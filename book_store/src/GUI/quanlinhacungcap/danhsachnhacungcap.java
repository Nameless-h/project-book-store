package GUI.quanlinhacungcap;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.*;
import DTO.*;
import GUI.icon_lib;
import GUI.setting_frame;
import GUI.main_frame.main;
import DTO.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class danhsachnhacungcap extends JPanel implements MouseListener {
    main obj;

    // Color set.color_211 = new Color(211, 211, 211);
    // String set.font_time_roman = "Times Roman";
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();

    quanlinhacungcap quanlinhacungcap = new quanlinhacungcap();
    ArrayList<chitietnhomquyen> list_ct;
    // -------------------------------
    String[] collums = { "STT", "Ma nha cung cap", "Ten nha cung cap", "Dia chi", "Email", "SDT" };
    String[] list_timkiem = { "Tat ca", "Ma khach hang", "Ten", "Dia chi", "Email", "SDT" };

    JComboBox combo_timkiem;
    JTextField txt_timkiem;
    JTable tab_danhsach;
    JScrollPane thanhcuon;
    JPanel pan_chucnang1, pan_chucnang2, pan_timkiem;
    JButton bun_them, bun_xoa, bun_sua, bun_in_excel, bun_timkiem, bun_lammoi;

    public danhsachnhacungcap(main obj, ArrayList<chitietnhomquyen> list_ct) {
        this.obj = obj;
        this.list_ct = list_ct;
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(set.w_center, set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        // set panel cac chuc nag co ban them ,xoa,sua,..
        pan_chucnang1 = new JPanel();
        pan_chucnang1.setBounds(0, 0, set.w_center, 50);
        pan_chucnang1.setBackground(set.color_211);
        pan_chucnang1.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_chucnang1);
        // nut them
        bun_them = new JButton("Them", ic_lib.icon_add);
        bun_them.setPreferredSize(new Dimension(200, 40));
        bun_them.setFont(new Font(set.font_time_roman, 1, 20));
        pan_chucnang1.add(bun_them);
        // nut xoa
        bun_xoa = new JButton("Xoa", ic_lib.icon_remove);
        bun_xoa.setPreferredSize(new Dimension(200, 40));
        bun_xoa.setFont(new Font(set.font_time_roman, 1, 20));
        pan_chucnang1.add(bun_xoa);
        // nut sua
        bun_sua = new JButton("Sua", ic_lib.icon_repair);
        bun_sua.setPreferredSize(new Dimension(200, 40));
        bun_sua.setFont(new Font(set.font_time_roman, 1, 20));
        pan_chucnang1.add(bun_sua);
        // nut in excel
        bun_in_excel = new JButton("Export Excel", ic_lib.icon_export_excel);
        bun_in_excel.setPreferredSize(new Dimension(200, 40));
        bun_in_excel.setFont(new Font(set.font_time_roman, 1, 20));
        pan_chucnang1.add(bun_in_excel);
        // cai dat panel chuc nang 2
        pan_chucnang2 = new JPanel();
        pan_chucnang2.setBounds(0, 60, set.w_center, 100);
        pan_chucnang2.setBackground(set.color_211);
        pan_chucnang2.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_chucnang2);
        // set panel tim kiem
        pan_timkiem = new JPanel();
        pan_timkiem.setPreferredSize(new Dimension(600, 60));
        pan_timkiem.setBackground(set.color_211);
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
        txt_timkiem.setFont(new Font(set.font_time_roman, 1, 15));
        pan_timkiem.add(txt_timkiem);
        // set nut tim kiem
        bun_timkiem = new JButton("Tim kiem");
        bun_timkiem.setPreferredSize(new Dimension(100, 30));
        pan_timkiem.add(bun_timkiem);
        bun_lammoi = new JButton("Lam moi");
        bun_lammoi.setPreferredSize(new Dimension(100, 30));
        pan_timkiem.add(bun_lammoi);
        bun_sua.addMouseListener(this);
        bun_them.addMouseListener(this);
        bun_xoa.addMouseListener(this);
        bun_timkiem.addMouseListener(this);
        bun_lammoi.addMouseListener(this);
        bun_in_excel.addMouseListener(this);
        // set bang nhan vien
        tab_danhsach = new JTable();
        tab_danhsach.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tab_danhsach.setModel(new DefaultTableModel(new Object[][] {}, collums));

        quanlinhacungcap.hienthidanhsach_ncc(tab_danhsach);
        thanhcuon = new JScrollPane(tab_danhsach);
        thanhcuon.setBounds(0, 200, set.w_center, set.h_center - 200);
        this.add(thanhcuon);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == bun_them) {
            for (int i = 0; i < list_ct.size(); i++)
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("NCC") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Them"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        int rowCount = tab_danhsach.getRowCount() + 1;
                        themnhacungcap panel = new themnhacungcap(obj, rowCount);
                        panel.setBounds(0, 0, set.w_center, set.h_center);
                        obj.center.removeAll();
                        obj.center.add(panel);
                        obj.center.repaint();
                        obj.center.revalidate();
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == bun_sua) {
            for (int i = 0; i < list_ct.size(); i++)
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("NCC") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Sua"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        DefaultTableModel model = (DefaultTableModel) tab_danhsach.getModel();
                        int selectrow = tab_danhsach.getSelectedRow();
                        if (selectrow == -1) {
                            JOptionPane.showMessageDialog(null, "Ban chua chon khach hang de sua");
                        } else {
                            // String ma,ten,gioitinh,diachi,email,sodienthoai;
                            Integer ma = Integer.parseInt(model.getValueAt(selectrow, 1).toString());
                            String ten = model.getValueAt(selectrow, 2).toString();
                            String dc = model.getValueAt(selectrow, 3).toString();
                            String email = model.getValueAt(selectrow, 4).toString();
                            String sdt = model.getValueAt(selectrow, 5).toString();
                            nhacungcap temp = new nhacungcap(ma, ten, dc, email, sdt);
                            suathongtinnhacungcap panel = new suathongtinnhacungcap(obj, temp);
                            panel.setBounds(0, 0, set.w_center, set.h_center);
                            obj.center.removeAll();
                            obj.center.add(panel);
                            obj.center.repaint();
                            obj.center.revalidate();
                        }
                        // System.out.println(ma+ten);
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == bun_timkiem) {
            int tk = combo_timkiem.getSelectedIndex();
            String str = txt_timkiem.getText();
            if (quanlinhacungcap.timkiem_vitri(tk, str, tab_danhsach) == false) {
                JOptionPane.showMessageDialog(this, "Khong ton tai nha cung cap nay", "Thong bao",
                        JOptionPane.WARNING_MESSAGE);
                quanlinhacungcap.hienthidanhsach_ncc(tab_danhsach);
            }

        } else if (e.getSource() == bun_lammoi) {
            txt_timkiem.setText("");
            quanlinhacungcap.hienthidanhsach_ncc(tab_danhsach);
            combo_timkiem.setSelectedIndex(0);
        } else if (e.getSource() == bun_in_excel) {
            quanlinhacungcap.xuatds_excel();
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
