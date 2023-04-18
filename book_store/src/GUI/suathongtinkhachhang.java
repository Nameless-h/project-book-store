package GUI;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlikhachhang;
import DTO.khachhang;

public class suathongtinkhachhang extends JPanel implements ItemListener,MouseListener {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    quanlikhachhang quanlikhachhang =new quanlikhachhang();
    // ------------------------------
    String[] list_lab = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "SDT:", "Diem tich luy:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    String[] thongtin;
    JPanel pan_info, pan_tinhtrang;
    String ma;
    JButton bun_sua;
    JCheckBox chk_chophep, chk_khong;
    khachhang kh;
    int tinhtrang;
    public suathongtinkhachhang(main obj, khachhang kh) {
        this.obj = obj;
        this.kh = kh;
        this.thongtin = kh.getthongtin();
        this.tinhtrang=kh.getTinhtrang();
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, obj.w_center - 400, obj.h_center - 100);
        pan_info.setBackground(color_211);
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
            lab[i].setFont(new Font(name_font1, 1, 20));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab[i].setBackground(color_211);
            lab[i].setForeground(Color.black);
            txt[i] = new JTextField(thongtin[i]);
            if (i == 0) {
                txt[i].setEnabled(false);
            }
            if (i == 2) {
                if (thongtin[i].equalsIgnoreCase("1"))
                    txt[i].setText("Nam");
                else
                    txt[i].setText("Nu");
            }
            txt[i].setPreferredSize(new Dimension(400, 50));
            txt[i].setForeground(Color.black);
            txt[i].setFont(new Font(name_font1, 1, 20));

            pan_info.add(lab[i]);
            pan_info.add(txt[i]);
        }
        pan_tinhtrang = new JPanel();
        pan_tinhtrang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Cho phep",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_tinhtrang.setPreferredSize(new Dimension(690, 100));
        pan_tinhtrang.setBackground(color_211);
        pan_tinhtrang.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_info.add(pan_tinhtrang);
        chk_chophep = new JCheckBox("Cho phep");
        chk_chophep.setPreferredSize(new Dimension(150, 50));
        chk_chophep.setFont(new Font(name_font1, 1, 25));
        chk_khong = new JCheckBox("Khong cho phep");
        chk_khong.setPreferredSize(new Dimension(250, 50));
        chk_khong.setFont(new Font(name_font1, 1, 22));
        if (kh.getTinhtrang()==1) {
            chk_chophep.setSelected(true);
            chk_khong.setSelected(false);
        } else {
            chk_chophep.setSelected(false);
            chk_khong.setSelected(true);
        }
        chk_chophep.addItemListener(this);
        chk_khong.addItemListener(this);
        pan_tinhtrang.add(chk_chophep);
        pan_tinhtrang.add(chk_khong);

        bun_sua = new JButton("Sua");
        bun_sua.setBounds(400, 590, 300, 50);
        bun_sua.setBackground(Color.red);
        bun_sua.setFont(new Font(name_font1, 1, 25));
        bun_sua.setHorizontalAlignment(SwingConstants.CENTER);
        bun_sua.setForeground(Color.white);
        bun_sua.addMouseListener(this);
        this.add(bun_sua);
    }

    private void hienthongtin() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==bun_sua){
            int ma=kh.getMa();
            String ten=txt[1].getText();
            String gt_str=txt[2].getText();
            int gt;
            if(gt_str.equalsIgnoreCase("Nam"))
                gt=1;
                else
            gt=0;
            String dc=txt[3].getText();
            String email=txt[4].getText();
            String sdt=txt[5].getText();
            int diem=Integer.parseInt(txt[6].getText());
        khachhang kh=new khachhang(ma, ten, gt, dc, email, sdt, diem, tinhtrang);
        // System.out.println(kh);
        quanlikhachhang.suathongtinkhachhang(kh);
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

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (chk_chophep.isSelected() && chk_khong.isSelected()) {
            if (e.getSource() == chk_chophep) {
                chk_khong.setSelected(false);
                this.tinhtrang=1;
            } else {
                chk_chophep.setSelected(false);
                this.tinhtrang=0;
            }
            // System.out.println(tinhtrang);
        }
    }
}
