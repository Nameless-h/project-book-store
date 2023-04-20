package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DTO.khachhang;
import DTO.taikhoan;
import BUS.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class suataikhoan extends JPanel  implements MouseListener{
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    String[] thongtin;
    taikhoan tk;
    quanlinhomquyen quanlinhomquyen = new quanlinhomquyen();
    quanlinhanvien quanlinhanvien = new quanlinhanvien();
    quanlitaikhoan quanlitaikhoan=new quanlitaikhoan();
    // ----------------------------
    JPanel pan_info, pan_tinhtrang;
    Integer[] list_manhomquyen = quanlinhomquyen.danhsach_manhomquyen();
    Integer[] list_manhanvien = quanlinhanvien.danhsachmanhanvien();
    String[] list_combox = { "q1", "q2" };
    String[] list_lab = { "Ma tai khoan:", "Username:", "Password:", "Ma nhan vien:", "Nhom quyen:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length - 1];
    JComboBox com;
    JButton bun_them;
    JCheckBox chk_chophep, chk_khong;
    CheckboxGroup cbg = new CheckboxGroup();
    JComboBox com_manhomquyen, com_manhanvien;
    int tinhtrang;
    JRadioButton  rdb_chophep, rdb_khongchophep;
    ButtonGroup group;
    public suataikhoan(main obj, taikhoan tk) {
        this.tk = tk;
        this.thongtin = tk.getthongtin();
        this.obj = obj;
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        // --
        pan_info = new JPanel();
        pan_info.setBounds(300, 10, obj.w_center - 600, obj.h_center - 100);
        pan_info.setBackground(color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Sua tai khoan",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        this.add(pan_info);
        for (int i = 0; i < list_lab.length; i++) {
            lab[i] = new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(250, 30));
            lab[i].setFont(new Font(name_font1, 1, 25));
            pan_info.add(lab[i]);
            if (i == 0) {
                txt[i] = new JTextField(String.valueOf(tk.getManhanvien()));
                txt[i].setPreferredSize(new Dimension(300, 40));
                txt[i].setFont(new Font(name_font1, 1, 25));
                txt[i].setForeground(Color.black);
                txt[i].setEnabled(false);
                pan_info.add(txt[i]);
            } else if (i == 3) {
                int temp1=0;
                for(int k=0;k<list_manhanvien.length;k++)
                    if(list_manhanvien[k]==tk.getManhanvien())
                    temp1=k;
                com_manhanvien = new JComboBox(list_manhanvien);
                com_manhanvien.setPreferredSize(new Dimension(300, 40));
                com_manhanvien.setFont(new Font(name_font1, 1, 25));
                com_manhanvien.setForeground(Color.black);
                com_manhanvien.setSelectedIndex(temp1);
                com_manhanvien.addMouseListener(this);
                pan_info.add(com_manhanvien);
            } else if (i == 4) {
                int temp1=0;
                for(int k=0;k<list_manhomquyen.length;k++)
                    if(list_manhomquyen[k]==tk.getManhomquyen())
                    temp1=k;
                com_manhomquyen = new JComboBox(list_manhomquyen);
                com_manhomquyen.setPreferredSize(new Dimension(250, 40));
                com_manhomquyen.setForeground(Color.black);
                com_manhomquyen.setFont(new Font(name_font1, 1, 25));
                com_manhomquyen.setSelectedIndex(temp1);
                com_manhomquyen.addMouseListener(this);
                pan_info.add(com_manhomquyen);
            } else {
                if(i==1)
                txt[i]=new JTextField(tk.getUsername());
                else
                txt[i]=new JTextField(tk.getPassword());
                txt[i].setPreferredSize(new Dimension(300, 40));
                txt[i].setFont(new Font(name_font1, 1, 25));
                txt[i].setForeground(Color.black);
                pan_info.add(txt[i]);
            }
        }
        pan_tinhtrang = new JPanel();
        pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Cho phep",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_tinhtrang.setPreferredSize(new Dimension(480, 100));
        pan_tinhtrang.setBackground(color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        rdb_chophep = new JRadioButton("Cho phep");
        rdb_khongchophep = new JRadioButton("Khong cho phep");
        if (tk.getTinhtrang() == 1)
            rdb_chophep.setSelected(true);
        else
            rdb_khongchophep.setSelected(true);
        rdb_chophep.setPreferredSize(new Dimension(200, 50));
        rdb_chophep.setFont(new Font(name_font1, 1, 20));
        rdb_khongchophep.setPreferredSize(new Dimension(200, 50));
        rdb_khongchophep.setFont(new Font(name_font1, 1, 20));
        group = new ButtonGroup();
        group.add(rdb_chophep);
        group.add(rdb_khongchophep);

        pan_tinhtrang.add(rdb_chophep);
        pan_tinhtrang.add(rdb_khongchophep);

        bun_them = new JButton("Sua");
        bun_them.setBounds(400, 590, 300, 50);
        bun_them.setBackground(Color.red);
        bun_them.setFont(new Font(name_font1, 1, 25));
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
        if(e.getSource()==bun_them){
            int ma=tk.getMatk();
            String username=txt[1].getText();
            String password=txt[2].getText();
            int mnv_select = Integer.parseInt(com_manhanvien.getSelectedItem().toString());
            int mnq_select = Integer.parseInt(com_manhomquyen.getSelectedItem().toString());
            int tt = 1;
                if (rdb_chophep.isSelected())
                    tt = 1;
                if (rdb_khongchophep.isSelected())
                    tt = 0;
        taikhoan tk=new taikhoan(ma, username, password, mnv_select,mnq_select,tt);
        quanlitaikhoan.suataikhoan(tk);
        JOptionPane.showMessageDialog(null,"Sua thong tin nhan vien thanh cong");
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
