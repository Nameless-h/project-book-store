package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import BUS.quanlinhomquyen;

public class menu extends JPanel implements MouseListener {
    main obj;

    Color color_54 = new Color(54, 54, 54);
    String name_font1 = "Times Roman";
    String[] list_menu = { "Ban hang", "Nhap hang", "San pham", "Hoa don", "Phieu nhap", "Nhan vien", "Khach hang",
            "Nha cung cap", "Tai khoan", "Quyen" };
    JLabel[] list_lab = new JLabel[list_menu.length];
    Integer[] list_lab2 = new Integer[list_menu.length];
    JSeparator thanhnganh;

    public void change_panel(String text) {
        if (text.equalsIgnoreCase("Nhan vien")) {
            danhsachnhanvien panel = new danhsachnhanvien(obj);
            panel.setBounds(0, 0, obj.w_center, obj.h_center);
            obj.center.removeAll();
            obj.center.add(panel);
            obj.center.repaint();
            obj.center.revalidate();
        }
        else
        if (text.equalsIgnoreCase("Khach hang")) {
            danhsachkhachhang panel = new danhsachkhachhang(obj);
            panel.setBounds(0, 0, obj.w_center, obj.h_center);
            obj.center.removeAll();
            obj.center.add(panel);
            obj.center.repaint();
            obj.center.revalidate();
        }
        else
        if (text.equalsIgnoreCase("Quyen")) {
            danhsachnhomquyen panel =new danhsachnhomquyen(obj);
            panel.setBounds(0, 0, obj.w_center, obj.h_center);
            obj.center.removeAll();
            obj.center.add(panel);
            obj.center.repaint();
            obj.center.revalidate();
        }
        else
        if (text.equalsIgnoreCase("Tai khoan")) {
            danhsachtaikhoan panel =new danhsachtaikhoan(obj);
            panel.setBounds(0, 0, obj.w_center, obj.h_center);
            obj.center.removeAll();
            obj.center.add(panel);
            obj.center.repaint();
            obj.center.revalidate();
        }
    }

    public menu(main obj) {
        this.obj = obj;
        init(obj);
    }

    private void init(main obj) {
        for (int j = 0; j < list_lab.length; j++)
            list_lab2[j] = 0;
        // cai dat giao dien cho panel menu
        this.setPreferredSize(new Dimension(obj.w_menu, obj.h_menu));
        this.setBackground(color_54);
        this.setLayout(new FlowLayout());
        // them cac chuc nang vao menu chinh
        for (int i = 0; i < list_menu.length; i++) {
            if (i == 2 || i == 5 || i == 8) {
                thanhnganh = new JSeparator();
                thanhnganh.setPreferredSize(new Dimension(obj.w_menu, 10));
                this.add(thanhnganh);
            }
            list_lab[i] = new JLabel(list_menu[i]);
            list_lab[i].setPreferredSize(new Dimension(obj.w_menu, 55));
            list_lab[i].setFont(new Font(name_font1, 1, 15));
            list_lab[i].setOpaque(true);
            list_lab[i].setBackground(color_54);
            list_lab[i].setForeground(Color.white);
            list_lab[i].setHorizontalAlignment(SwingConstants.CENTER);
            list_lab[i].addMouseListener(this);
            this.add(list_lab[i]);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < list_lab.length; i++) {
            if (e.getSource() == list_lab[i]) {
                change_panel(list_lab[i].getText());
                for (int j = 0; j < list_lab2.length; j++)
                    list_lab2[j] = 0;
                list_lab2[i] = 1;
            }

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for (int i = 0; i < list_lab.length; i++) {
            if (e.getSource() == list_lab[i]) {
                list_lab[i].setBackground(Color.black);
                list_lab[i].setFont(new Font(name_font1, 1, 20));
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < list_lab.length; i++) {
            if (list_lab2[i] == 1) {
                list_lab[i].setBackground(Color.black);
                list_lab[i].setFont(new Font(name_font1, 1, 20));
            } else {
                list_lab[i].setBackground(color_54);
                list_lab[i].setFont(new Font(name_font1, 1, 15));
            }

        }
    }

}
