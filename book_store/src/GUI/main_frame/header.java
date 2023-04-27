package GUI.main_frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import BUS.quanlinhanvien;
import DTO.taikhoan;
import GUI.*;
import GUI.login_frame.login;

public class header extends JPanel implements MouseListener {
    quanlinhanvien chucnang_nhanvien = new quanlinhanvien();
    JLabel lab_close, lab_hide, lab_exit, lab_ten;
    main obj;
    setting_frame set = new setting_frame();
    icon_lib ic_lib = new icon_lib();
    JPanel pan_cuaso, pan_chuongtrinh;
    // ImageIcon ic_lib.icon_exit=new
    // ImageIcon(getClass().getResource("/icon/close2.png"));
    // ImageIcon icon_hide=new ImageIcon(getClass().getResource("/icon/hide1.png"));
    taikhoan tk;

    public header(main obj, taikhoan tk) {
        this.obj = obj;
        this.tk = tk;
        init();
    }

    private void init() {
        this.setPreferredSize(new Dimension(set.w_head, set.h_head));
        this.setBackground(Color.black);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // set pan_cuaso
        // set lab_close
        pan_cuaso = new JPanel();
        pan_cuaso.setPreferredSize(new Dimension(1000, 30));
        pan_cuaso.setBackground(Color.black);
        pan_cuaso.setLayout(new FlowLayout(FlowLayout.RIGHT));
        // set pan_chuongtrinh
        pan_chuongtrinh = new JPanel();
        pan_chuongtrinh.setPreferredSize(new Dimension(290, 30));
        pan_chuongtrinh.setBackground(Color.black);
        pan_chuongtrinh.setLayout(new FlowLayout(FlowLayout.LEFT));
        lab_close = new JLabel();
        lab_close.setIcon(ic_lib.icon_exit);
        lab_close.setHorizontalAlignment(SwingConstants.RIGHT);
        lab_close.setForeground(Color.white);
        lab_close.setFont(new Font("Segoe UI", 1, 20));
        lab_close.setPreferredSize(new Dimension(50, 30));
        lab_close.setOpaque(true);
        lab_close.setBackground(Color.black);
        lab_close.addMouseListener(this);
        // set lab_hide
        lab_hide = new JLabel();
        lab_hide.setIcon(ic_lib.icon_hide);
        lab_hide.setHorizontalAlignment(SwingConstants.RIGHT);
        lab_hide.setForeground(Color.white);
        lab_hide.setFont(new Font("Segoe UI", 1, 20));
        lab_hide.setPreferredSize(new Dimension(50, 30));
        lab_hide.setOpaque(true);
        lab_hide.setBackground(Color.black);
        lab_hide.addMouseListener(this);
        // set lab_exit
        lab_exit = new JLabel(ic_lib.icon_exit);
        lab_exit.setPreferredSize(new Dimension(50, 30));
        lab_exit.addMouseListener(this);
        pan_chuongtrinh.add(lab_exit);
        // set lab_ten
        // System.out.println(chucnang_nhanvien.tennhanvien(this.tk.getManhanvien()));
        lab_ten = new JLabel(chucnang_nhanvien.tennhanvien(this.tk.getManhanvien()));
        lab_ten.setForeground(Color.white);
        lab_ten.setPreferredSize(new Dimension(200, 30));
        lab_ten.setFont(new Font(set.font_time_roman, 1, 17));
        lab_ten.setOpaque(true);
        lab_ten.setBackground(Color.black);
        lab_ten.setHorizontalAlignment(SwingConstants.LEFT);
        pan_chuongtrinh.add(lab_ten);

        pan_cuaso.add(lab_hide);
        pan_cuaso.add(lab_close);
        // this.add(pan_chuongtrinh);
        this.add(pan_chuongtrinh);
        this.add(pan_cuaso);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lab_close)
            System.exit(0);
        else if (e.getSource() == lab_hide)
            obj.setState(Frame.ICONIFIED);
        else if (e.getSource() == lab_exit) {
            obj.setVisible(false);
            new login();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // if (e.getSource() == lab_close)
        // lab_close.setBackground(Color.red);
        // else
        // if (e.getSource() == lab_hide)
        // lab_hide.setBackground(Color.red);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // lab_close.setBackground(Color.black);
        // lab_hide.setBackground(Color.black);
    }
}
