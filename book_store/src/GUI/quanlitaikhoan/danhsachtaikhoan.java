package GUI.quanlitaikhoan;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import BUS.quanlitaikhoan;
import DAO.taikhoanDAO;
import DTO.chitietnhomquyen;
import DTO.taikhoan;
import GUI.*;
import GUI.main_frame.main;

public class danhsachtaikhoan extends JPanel implements MouseListener {
    main obj;
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    quanlitaikhoan quanlitaikhoan = new quanlitaikhoan();
    taikhoanDAO chucnang_tk = new taikhoanDAO();
    ArrayList<chitietnhomquyen> list_ct;
    // -------------------------------
    String[] collums = { "STT", "Ma tai khoan", "Username", "Password", "Ma nhan vien", "Ma nhom quyen", "Tinh trang" };
    String[] list_timkiem = { "Tat ca", "Ma tai khoan", "Ma nhan vien", "Ma nhom quyen" };
    // --------------------------------------------
    JComboBox combo_timkiem;
    JTextField txt_timkiem;
    JTable tab_danhsach;
    JScrollPane thanhcuon;
    JPanel pan_chucnang1, pan_chucnang2, pan_timkiem;
    JButton bun_them, bun_xoa, bun_sua, bun_timkiem, bun_lammoi;

    public danhsachtaikhoan(main obj, ArrayList<chitietnhomquyen> list_ct) {
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
        // ====
        bun_them.addMouseListener(this);
        bun_sua.addMouseListener(this);
        bun_xoa.addMouseListener(this);
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
        bun_timkiem.addMouseListener(this);
        bun_lammoi.addMouseListener(this);
        // set bang nhan vien
        tab_danhsach = new JTable();
        tab_danhsach.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        tab_danhsach.setModel(new DefaultTableModel(new Object[][] {}, collums));

        quanlitaikhoan.hienthidanhsach_taikhoan(tab_danhsach);
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
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("TK") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Them"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        int rowCount = tab_danhsach.getRowCount();
                        Integer ma = Integer.parseInt(tab_danhsach.getValueAt(rowCount - 1, 1).toString());
                        themtaikhoan panel = new themtaikhoan(obj, ma + 1);
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
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("TK") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Sua"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        DefaultTableModel model = (DefaultTableModel) tab_danhsach.getModel();
                        int selectrow = tab_danhsach.getSelectedRow();
                        if (selectrow == -1) {
                            JOptionPane.showMessageDialog(null, "Ban chua chon tai khoan de sua");
                        } else {
                            // String ma,ten,gioitinh,diachi,email,sodienthoai;
                            Integer matk = Integer.parseInt(model.getValueAt(selectrow, 1).toString());
                            String username = (model.getValueAt(selectrow, 2).toString());
                            String pass = (model.getValueAt(selectrow, 3).toString());
                            Integer manv = Integer.parseInt(model.getValueAt(selectrow, 4).toString());
                            Integer manq = Integer.parseInt(model.getValueAt(selectrow, 5).toString());
                            Integer tt = Integer.parseInt(model.getValueAt(selectrow, 6).toString());
                            taikhoan temp = new taikhoan(matk, username, pass, manv, manq, tt);
                            System.out.println(temp);
                            suataikhoan panel = new suataikhoan(obj, temp);
                            panel.setBounds(0, 0, set.w_center, set.h_center);
                            obj.center.removeAll();
                            obj.center.add(panel);
                            obj.center.repaint();
                            obj.center.revalidate();
                        }
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
            // System.out.println(ma+ten);
        } else if (e.getSource() == bun_xoa) {
            for (int i = 0; i < list_ct.size(); i++)
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("TK") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Xoa"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        int rowCount = tab_danhsach.getRowCount();
                        Integer ma = Integer.parseInt(tab_danhsach.getValueAt(rowCount - 1, 1).toString());
                        int choice = JOptionPane.showConfirmDialog(null,
                                "Ban co muon xoa luon tai khoan khong?", "Confirmation",
                                JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            // System.out.println("User clicked Yes button");
                            chucnang_tk.delete_id(ma);
                            quanlitaikhoan.hienthidanhsach_taikhoan(tab_danhsach);
                        }
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == bun_timkiem) {
            int tk = combo_timkiem.getSelectedIndex();
            String str = txt_timkiem.getText();
            if (quanlitaikhoan.timkiem_vitri(tk, str, tab_danhsach) == false) {
                JOptionPane.showMessageDialog(this, "Khong ton tai tai khoan nay", "Thong bao",
                        JOptionPane.WARNING_MESSAGE);
                quanlitaikhoan.hienthidanhsach_taikhoan(tab_danhsach);
            }

        } else if (e.getSource() == bun_lammoi) {
            txt_timkiem.setText("");
            quanlitaikhoan.hienthidanhsach_taikhoan(tab_danhsach);
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
