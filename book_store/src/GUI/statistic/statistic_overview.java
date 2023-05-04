package GUI.statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BUS.quanlihoadonbanhang;
import BUS.quanlihoadonnhaphang;
import DAO.SanPhamDAO;
import DAO.khachhangDAO;
import DAO.nhanvienDAO;
import DTO.Sach;
import DTO.khachhang;
import DTO.nhanvien;

public class statistic_overview extends JPanel implements ActionListener{
    private JPanel generality,generality_panels[];
    private String title_name[] = {"Hóa đơn bán","Hóa đơn nhập","Nhân viên","Khách hàng","Sách"};
    private JLabel generality_title[] = new JLabel[title_name.length];
    private ImageIcon icons[] = new ImageIcon[title_name.length];
    private JLabel generality_sales,generality_employ,generality_import;
    public statistic_overview() {
        // lay so luong hoa don ban hang
        quanlihoadonbanhang bh = new quanlihoadonbanhang();
        bh.initList();
        String soLuongBH = Integer.toString(bh.getList().size());
        // lay so luong hoa don nhap hang  
        quanlihoadonnhaphang nh = new quanlihoadonnhaphang();
        nh.initList();
        String soLuongNH = Integer.toString(nh.getList().size());
        // lay so luong nhan vien
        nhanvienDAO nv=new nhanvienDAO();
        ArrayList<nhanvien> listNV=nv.selecAll();
        String soLuongNV = Integer.toString(listNV.size());
        // lay so luong khach hang
        khachhangDAO kh=new khachhangDAO();
        ArrayList<khachhang> listKH = kh.selecAll();
        String soLuongKH = Integer.toString(listKH.size());
        // lay so luong sach
        SanPhamDAO mod_bk = new SanPhamDAO();
        ArrayList<Sach> listBk = mod_bk.selecAll();
        String soLuongBook = Integer.toString(listBk.size());


        setLayout(new BorderLayout());
        generality = new JPanel();
        generality.setLayout(new FlowLayout(FlowLayout.LEFT));
        generality.setBackground(Color.lightGray);
        generality.setPreferredSize(new Dimension(1100, 620));
        generality_panels = new JPanel[title_name.length];

        for (int i = 0; i < title_name.length; i++) {
            generality_panels[i] = new JPanel();
            generality_panels[i].setLayout(new FlowLayout());
            generality_panels[i].setBorder(BorderFactory.createLineBorder(Color.white, 3));
            generality_panels[i].setPreferredSize(new Dimension(542, 180));
            generality_panels[i].setBackground(new Color(242, 59, 46));
            generality_title[i] = new JLabel(title_name[i], SwingConstants.CENTER);
            generality_title[i].setFont(new Font("Arial", Font.PLAIN, 24));
            generality_title[i].setForeground(Color.white);

            if(i == 0) {
                icons[i] = new ImageIcon(this.getClass().getResource("../../icon/icons8-bill-64.png"));
                generality_title[i].setIcon(icons[i]);
                generality_panels[i].add(generality_title[i]);
                generality_sales = new JLabel(soLuongBH,JLabel.CENTER);
                generality_sales.setFont(new Font("Verdana", Font.PLAIN, 30));
                generality_sales.setForeground(Color.green);
                generality_sales.setPreferredSize(new Dimension(520,100));
                generality_panels[i].add(generality_sales);

            } else if(i == 1) {
                icons[i] = new ImageIcon(this.getClass().getResource("../../icon/icons8-shopping-cart-40.png"));
                generality_title[i].setIcon(icons[i]);
                generality_panels[i].add(generality_title[i]);
                generality_import = new JLabel(soLuongNH,JLabel.CENTER);
                generality_import.setFont(new Font("Verdana", Font.PLAIN, 30));
                generality_import.setForeground(Color.green);
                generality_import.setPreferredSize(new Dimension(520,100));
                generality_panels[i].add(generality_import);
                
            } else if(i == 2) {
                icons[i] = new ImageIcon(this.getClass().getResource("../../icon/icons8-employee-48.png"));
                generality_title[i].setIcon(icons[i]);
                generality_panels[i].add(generality_title[i]);
                generality_employ = new JLabel(soLuongNV,JLabel.CENTER);
                generality_employ.setFont(new Font("Verdana", Font.PLAIN, 30));
                generality_employ.setForeground(Color.green);
                generality_employ.setPreferredSize(new Dimension(520,100));
                generality_panels[i].add(generality_employ);

            }  else if(i == 3) {
                icons[i] = new ImageIcon(this.getClass().getResource("../../icon/icons8-customer-40.png"));
                generality_title[i].setIcon(icons[i]);
                generality_panels[i].add(generality_title[i]);
                generality_employ = new JLabel(soLuongKH,JLabel.CENTER);
                generality_employ.setFont(new Font("Verdana", Font.PLAIN, 30));
                generality_employ.setForeground(Color.green);
                generality_employ.setPreferredSize(new Dimension(520,100));
                generality_panels[i].add(generality_employ);

            } else if(i == 4) {
                icons[i] = new ImageIcon(this.getClass().getResource("../../icon/icons8-open-book-48.png"));
                generality_title[i].setIcon(icons[i]);
                generality_panels[i].add(generality_title[i]);
                generality_employ = new JLabel(soLuongBook,JLabel.CENTER);
                generality_employ.setFont(new Font("Verdana", Font.PLAIN, 30));
                generality_employ.setForeground(Color.green);
                generality_employ.setPreferredSize(new Dimension(520,100));
                generality_panels[i].add(generality_employ);

            } 

            generality.add(generality_panels[i]);
        }

        add(generality, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
