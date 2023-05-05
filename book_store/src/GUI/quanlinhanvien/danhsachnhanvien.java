package GUI.quanlinhanvien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.*;
import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning;

import BUS.quanlinhanvien;
import DTO.chitietnhomquyen;
import DTO.nhanvien;
import GUI.*;
import GUI.main_frame.main;

public class danhsachnhanvien extends JPanel implements MouseListener {
    main obj;
    quanlinhanvien chucnang = new quanlinhanvien();
    ArrayList<chitietnhomquyen> list_ct;
    // goi thu vien icon
    icon_lib ic_lib = new icon_lib();
    // goi thu vien cai dat da co san
    setting_frame set = new setting_frame();

    // String name_font1 = "Times Roman";
    String[] collums = { "STT", "Ma nhan vien", "Ten", "Gioi tinh", "Dia chi", "Email", "SDT", "Chuc vu",
            "Tinh trang" };
    String[] list_timkiem = { "Tat ca", "Ma nhan vien", "Ten", "Gioi tinh", "Dia chi", "Email", "SDT", "Chuc vu" };
    JComboBox combo_timkiem;
    JTextField txt_timkiem;
    JTable tab_danhsach;
    JScrollPane thanhcuon;
    JPanel pan_chucnang1, pan_chucnang2, pan_timkiem;
    JButton bun_them, bun_xoa, bun_sua, bun_in_excel, bun_timkiem, bun_lammoi;

    public danhsachnhanvien(main obj, ArrayList<chitietnhomquyen> list_ct) {
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
        // bun xuat thong tin ra file excel
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
        // nut lam moi
        bun_lammoi = new JButton("Lam moi");
        bun_lammoi.setPreferredSize(new Dimension(100, 30));
        pan_timkiem.add(bun_lammoi);
        // them chuc nang cho cac cut
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
        tab_danhsach.getTableHeader().setBackground(Color.red);
        tab_danhsach.getTableHeader().setForeground(Color.white);
        tab_danhsach.setDefaultEditor(Object.class, null);  
        tab_danhsach.addMouseListener(this);
        chucnang.hienthidanhsach_nhanvien(tab_danhsach);
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
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("NV") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Them"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        int rowCount = tab_danhsach.getRowCount() + 1;
                        themnhanvien panel = new themnhanvien(obj, rowCount);
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
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("NV") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Sua"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        DefaultTableModel model = (DefaultTableModel) tab_danhsach.getModel();
                        int selectrow = tab_danhsach.getSelectedRow();
                        if (selectrow == -1) {
                            JOptionPane.showMessageDialog(null, "Ban chua chon nhan vien de sua");
                        } else {
                            // String ma,ten,gioitinh,diachi,email,sodienthoai;
                            Integer ma = Integer.parseInt(model.getValueAt(selectrow, 1).toString());
                            String ten = model.getValueAt(selectrow, 2).toString();
                            String gt_str = model.getValueAt(selectrow, 3).toString();
                            Integer gt;
                            if (gt_str.equalsIgnoreCase("Nam"))
                                gt = 1;
                            else
                                gt = 0;
                            String dc = model.getValueAt(selectrow, 4).toString();
                            String email = model.getValueAt(selectrow, 5).toString();
                            String sdt = model.getValueAt(selectrow, 6).toString();
                            String cv = model.getValueAt(selectrow, 7).toString();
                            int tt = Integer.parseInt(model.getValueAt(selectrow, 8).toString());
                            nhanvien temp = new nhanvien(ma, ten, gt, dc, email, sdt, cv, tt);
                            suathongtinnhanvien panel = new suathongtinnhanvien(obj, temp);
                            panel.setBounds(0, 0, set.w_center, set.h_center);
                            obj.center.removeAll();
                            obj.center.add(panel);
                            obj.center.repaint();
                            obj.center.revalidate();

                        }
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == bun_timkiem) {
            int tk = combo_timkiem.getSelectedIndex();
            String str = txt_timkiem.getText();
            if (chucnang.timkiem_vitri(tk, str, tab_danhsach) == false) {
                JOptionPane.showMessageDialog(this, "Khong ton tai nhan vien nay", "Thong bao",
                        JOptionPane.WARNING_MESSAGE);
                chucnang.hienthidanhsach_nhanvien(tab_danhsach);
            }

        } else if (e.getSource() == bun_xoa) {
            for (int i = 0; i < list_ct.size(); i++)
                if (list_ct.get(i).getMachucnang().equalsIgnoreCase("NV") &&
                        list_ct.get(i).getHanhdong().equalsIgnoreCase("Sua"))
                    if (list_ct.get(i).getTinhtrang() == 1) {
                        DefaultTableModel model = (DefaultTableModel) tab_danhsach.getModel();
                        int selectrow = tab_danhsach.getSelectedRow();
                        if (selectrow == -1) {
                            JOptionPane.showMessageDialog(null, "Ban chua chon nhan vien de sua");
                        } else {
                            // String ma,ten,gioitinh,diachi,email,sodienthoai;
                            Integer ma = Integer.parseInt(model.getValueAt(selectrow, 1).toString());
                            int selection = JOptionPane.showConfirmDialog(null, "Ban co muon an nhan vien nay ko?",
                                    "Xac nhan",
                                    JOptionPane.YES_NO_OPTION);
                            if (selection == JOptionPane.YES_OPTION) {
                                chucnang.nutxoa(ma, tab_danhsach);
                                JOptionPane.showMessageDialog(null, "An thanh cong");
                            }
                        }
                    } else
                        JOptionPane.showMessageDialog(this, "Ban khong duoc cap quyen nay", "Thong bao",
                                JOptionPane.WARNING_MESSAGE);
        } else if (e.getSource() == bun_lammoi) {
            txt_timkiem.setText("");
            chucnang.hienthidanhsach_nhanvien(tab_danhsach);
            combo_timkiem.setSelectedIndex(0);
        } else if (e.getSource() == bun_in_excel) {
            chucnang.xuatds_excel();
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
