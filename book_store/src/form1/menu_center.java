package form1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import user.user_info;

public class menu_center extends JPanel implements MouseListener {
    JLabel logo_user;
    JButton bun_changeinfo,bun_changepass;
    ImageIcon icon_user=new ImageIcon(getClass().getResource("/icon/user_logo128b.png"));
    String[] list={"Mã tài khoản: ","Tên: ","Số điện thoại: ","Giới tính","Ngày sinh: ","Địa chỉ: ","Quyền hạn: "};
    JLabel[] lab=new JLabel[list.length];
    JLabel[] lab2=new JLabel[list.length];
    String[] list_info=new String[list.length];
    public menu_center(user_info user,int width,int heigh){
        list_info=user.getuser_infoStrings(user);
        init(width,heigh);
    }
    private void init(int width,int heigh){
        JPanel pan_info=new JPanel();
        // this.setBackground(new Color(144,238,144));
        this.setBackground(new Color(54,54,54));
        this.setPreferredSize(new Dimension(width,heigh));
        this.setLayout(null);
        //set logo i=user
        logo_user=new JLabel(icon_user);
        logo_user.setBounds(500,10,130,130);
        this.add(logo_user);
        pan_info.setBounds(200,150,680,400);
        // pan_info.setBackground(new Color(144,238,144));
        pan_info.setBackground(new Color(54,54,54));
        // pan_info.setBackground(Color.black);
        pan_info.setLayout(new FlowLayout(0,10,5));
        this.add(pan_info);
        for(int i=0;i<list.length;i++){
            lab[i]=new JLabel(list[i]);
            lab2[i]=new JLabel(list_info[i]);   
            lab[i].setFont(new Font("Segoe UI",3,20));
            lab[i].setForeground(Color.white);
            lab2[i].setFont(new Font("Segoe UI",1,20));
            lab2[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            lab2[i].setForeground(Color.white);
            lab[i].setPreferredSize(new Dimension(200,50));
            lab2[i].setPreferredSize(new Dimension(400,50));
            lab[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab2[i].setHorizontalAlignment(SwingConstants.LEFT);
            pan_info.add(lab[i]);
            pan_info.add(lab2[i]);
        }
        //them nut cap nhat thong tin
        bun_changeinfo=new JButton("Cập nhật thông tin");
        bun_changeinfo.setFont(new Font("Segoe  UI",1,20));
        bun_changeinfo.setBounds(200,580,250,50);
        this.add(bun_changeinfo);
        //them nut thay doi mat khau
        bun_changepass=new JButton("Thay đổi mật khẩu");
        bun_changepass.setFont(new Font("Segoe  UI",1,20));
        bun_changepass.setBounds(600,580,250,50);
        this.add(bun_changepass);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
     }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
