package GUI.quanlinhacungcap;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.*;

import BUS.quanlikhachhang;
import BUS.quanlinhacungcap;
import DTO.khachhang;
import DTO.kiemTraInput;
import DTO.nhacungcap;
import GUI.*;
import GUI.main_frame.main;

public class themnhacungcap extends JPanel implements MouseListener {
    main obj;

    quanlinhacungcap quanlinhacungcap = new quanlinhacungcap();
    icon_lib ic_lib = new icon_lib();
    setting_frame set = new setting_frame();
    // ------------------------------
    String[] list_lab = { "Ma nha cung:", "Ten:", "Dia chi:", "Email:", "SDT:" };
    JLabel[] lab = new JLabel[list_lab.length];
    JTextField[] txt = new JTextField[list_lab.length];
    JPanel pan_info, pan_tinhtrang;
    Integer ma;
    JButton bun_them;
    JCheckBox chk_chophep, chk_khong;
    JRadioButton rdb_nam, rdb_nu;
    ButtonGroup group;

    public themnhacungcap(main obj, Integer ma) {
        this.obj = obj;
        this.ma = ma;
        init(obj);
    }

    private void init(main obj) {
        this.setPreferredSize(new Dimension(set.w_center, set.h_center));
        this.setLayout(null);
        this.setBackground(set.color_211);
        pan_info = new JPanel();
        pan_info.setBounds(250, 10, set.w_center - 400, set.h_center - 100);
        pan_info.setBackground(set.color_211);
        pan_info.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 50));
        pan_info.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Them nha cung cap",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        this.add(pan_info);
        for (int i = 0; i < list_lab.length; i++) {

            lab[i] = new JLabel(list_lab[i]);
            lab[i].setPreferredSize(new Dimension(200, 50));
            lab[i].setFont(new Font(set.font_time_roman, 1, 20));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab[i].setBackground(set.color_211);
            lab[i].setForeground(Color.black);
            pan_info.add(lab[i]);

            txt[i] = new JTextField();
            if (i == 0) {
                txt[i].setText(String.valueOf(ma));
                txt[i].setEnabled(false);
            }

            txt[i].setPreferredSize(new Dimension(400, 50));
            txt[i].setForeground(Color.black);
            txt[i].setFont(new Font(set.font_time_roman, 1, 20));

            pan_info.add(txt[i]);

        }

        bun_them = new JButton("Them", ic_lib.icon_add);
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
            int mancc = Integer.parseInt(txt[0].getText());
            String ten = txt[1].getText();
            String diachi = txt[2].getText();
            String email = txt[3].getText();
            String sdt = txt[4].getText();

            kiemTraInput check = new kiemTraInput();
    
            if(!check.checkEmpty(ten) || !check.checkEmpty(diachi) ||
            !check.checkEmpty(email) ||!check.checkEmpty(sdt)) {
                return;
            } else if(!check.validateEmail(email)) {
                txt[3].requestFocus();
                return;
            } else if(!check.validatePhoneNumber(sdt)) {
                txt[4].requestFocus();
                return;
            }
            
            nhacungcap temp = new nhacungcap(mancc, ten, diachi, sdt, email, 1);
            quanlinhacungcap.themnhacungcap(temp);
            JOptionPane.showMessageDialog(null, "Them thanh cong");

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
