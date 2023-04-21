package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import BUS.quanlichitietnhomquyen;
import BUS.quanlinhomquyen;
import DTO.chitietnhomquyen;
import DTO.taikhoan;
import GUI.quanlysanpham.bookFrame;
import GUI.statistic.list_statistic;

public class menu extends JPanel implements MouseListener {
    main obj;
    taikhoan tk;
    quanlichitietnhomquyen quanlichitietnhomquyen = new quanlichitietnhomquyen();
    ArrayList<chitietnhomquyen> tk_chitietquyen;
    Color color_54 = new Color(54, 54, 54);
    String name_font1 = "Times Roman";
    String[] list_menu = { "Ban hang", "Nhap hang", "San pham", "Hoa don", "Phieu nhap", "Nhan vien", "Khach hang",
            "Nha cung cap", "Tai khoan", "Quyen" };
    String[] list_icon={ "/icon/store.png",
                        "/icon/nhaphang.png",
                        "/icon/sanpham.png",
                        "/icon/hoadon.png",
                        "/icon/phieunhaphang.png",
                        "/icon/nhanvien.png",
                        "/icon/khachhang.png",
                        "/icon/nhacungcap.png",
                        "/icon/taikhoan.png",
                        "/icon/chucnang.png",
    };
    ImageIcon[] icons=new ImageIcon[list_icon.length];
    //-----
    ImageIcon temp=new ImageIcon(getClass().getResource("/icon/store.png"));
    //---

    JLabel[] list_lab = new JLabel[list_menu.length];
    Integer[] list_lab2 = new Integer[list_menu.length];
    JSeparator thanhnganh;

    public void change_panel(String text) throws IOException {
        int kt_dangnhap = 0;
        if (text.equalsIgnoreCase("Nhan vien")) {
            for (int i = 0; i < tk_chitietquyen.size(); i++)
                if (tk_chitietquyen.get(i).getMachucnang().equalsIgnoreCase("NV") &&
                        tk_chitietquyen.get(i).getHanhdong().equalsIgnoreCase("Xem") &&
                        tk_chitietquyen.get(i).getTinhtrang() == 1) {
                    danhsachnhanvien panel = new danhsachnhanvien(obj);
                    panel.setBounds(0, 0, obj.w_center, obj.h_center);
                    obj.center.removeAll();
                    obj.center.add(panel);
                    obj.center.repaint();
                    obj.center.revalidate();
                    kt_dangnhap = 1;
                }
            if (kt_dangnhap == 0) {
                JOptionPane.showMessageDialog(null, "Ban khong duoc cap quyen xem trang nay");
            }

        } else if (text.equalsIgnoreCase("Khach hang")) {
            for (int i = 0; i < tk_chitietquyen.size(); i++)
                if (tk_chitietquyen.get(i).getMachucnang().equalsIgnoreCase("KH") &&
                        tk_chitietquyen.get(i).getHanhdong().equalsIgnoreCase("Xem") &&
                        tk_chitietquyen.get(i).getTinhtrang() == 1) {
                    danhsachkhachhang panel = new danhsachkhachhang(obj);
                    panel.setBounds(0, 0, obj.w_center, obj.h_center);
                    obj.center.removeAll();
                    obj.center.add(panel);
                    obj.center.repaint();
                    obj.center.revalidate();
                    kt_dangnhap = 1;
                }
            if (kt_dangnhap == 0) {
                JOptionPane.showMessageDialog(null, "Ban khong duoc cap quyen xem trang nay");
            }
        } else if (text.equalsIgnoreCase("Quyen")) {
            for (int i = 0; i < tk_chitietquyen.size(); i++)
                if (tk_chitietquyen.get(i).getMachucnang().equalsIgnoreCase("QH") &&
                        tk_chitietquyen.get(i).getHanhdong().equalsIgnoreCase("Xem") &&
                        tk_chitietquyen.get(i).getTinhtrang() == 1) {
                    danhsachnhomquyen panel = new danhsachnhomquyen(obj);
                    panel.setBounds(0, 0, obj.w_center, obj.h_center);
                    obj.center.removeAll();
                    obj.center.add(panel);
                    obj.center.repaint();
                    obj.center.revalidate();
                    kt_dangnhap = 1;
                }
            if (kt_dangnhap == 0) {
                JOptionPane.showMessageDialog(null, "Ban khong duoc cap quyen xem trang nay");
            }
        } else if (text.equalsIgnoreCase("Tai khoan")) {
            for (int i = 0; i < tk_chitietquyen.size(); i++)
                if (tk_chitietquyen.get(i).getMachucnang().equalsIgnoreCase("TK") &&
                        tk_chitietquyen.get(i).getHanhdong().equalsIgnoreCase("Xem") &&
                        tk_chitietquyen.get(i).getTinhtrang() == 1) {
                    danhsachtaikhoan panel = new danhsachtaikhoan(obj);
                    panel.setBounds(0, 0, obj.w_center, obj.h_center);
                    obj.center.removeAll();
                    obj.center.add(panel);
                    obj.center.repaint();
                    obj.center.revalidate();
                    kt_dangnhap = 1;
                }
            if (kt_dangnhap == 0) {
                JOptionPane.showMessageDialog(null, "Ban khong duoc cap quyen xem trang nay");
            }
        } else if (text.equalsIgnoreCase("Ban hang")) {
            FlatLightLaf.setup();
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception e) {
                // TODO: handle exception
            }
            SaleGUI salegui = new SaleGUI();
            salegui.setBounds(0, 0, 1100, 700);
            obj.center.removeAll();
            obj.center.add(salegui);
            obj.center.repaint();
            obj.center.revalidate();

        } else if (text.equalsIgnoreCase("Hoa don")) {
            FlatLightLaf.setup();
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
            } catch (Exception e) {
                // TODO: handle exception
            }
            InvoiceGUI invoicegui = new InvoiceGUI();
            invoicegui.setBounds(0, 0, 1100, 700);
            obj.center.removeAll();
            obj.center.add(invoicegui);
            obj.center.repaint();
            obj.center.revalidate();

        } else if (text.equalsIgnoreCase("Thong ke")) {
            list_statistic statisticgui = new list_statistic();
            statisticgui.setBounds(0, 0, 1100, 670);
            obj.center.removeAll();
            obj.center.add(statisticgui);
            obj.center.repaint();
            obj.center.revalidate();

        }
    }

    public menu(main obj, taikhoan tk) {
        this.obj = obj;
        this.tk = tk;
        this.tk_chitietquyen = quanlichitietnhomquyen.danhsachchitietnhomquyen_id(tk.getManhomquyen());
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
            icons[i]=new ImageIcon(getClass().getResource(list_icon[i]));
            list_lab[i] = new JLabel(list_menu[i]);
            list_lab[i].setIcon(icons[i]);
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
                try {
                    change_panel(list_lab[i].getText());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    // e1.printStackTrace();
                }
                for (int j = 0; j < list_lab2.length; j++)
                    list_lab2[j] = 0;
                list_lab2[i] = 1;
                mouseExited(e);
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
                if (list_lab2[i] == 1) {
                    list_lab[i].setBackground(Color.white);
                    list_lab[i].setFont(new Font(name_font1, 1, 20));
                    list_lab[i].setForeground(Color.black);
                } else {
                    list_lab[i].setBackground(Color.black);
                    list_lab[i].setFont(new Font(name_font1, 1, 20));
                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for (int i = 0; i < list_lab.length; i++) {
            if (list_lab2[i] == 1) {
                list_lab[i].setBackground(Color.white);
                list_lab[i].setFont(new Font(name_font1, 1, 20));
                list_lab[i].setForeground(Color.black);
            } else {
                list_lab[i].setBackground(color_54);
                list_lab[i].setFont(new Font(name_font1, 1, 15));
                list_lab[i].setForeground(Color.white);
            }

        }
    }

}
