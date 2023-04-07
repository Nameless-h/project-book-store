package form1;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import model.pan_staff_model;
import nameclass.customer;

public class pan_staff extends JPanel implements MouseListener {
    menu obj;
    pan_staff_model chucnang = new pan_staff_model();
    JPanel pan_list_staff, pan_info,pan_chucnang;
    JLabel title, lab_staff, lab_nhomuyen;
    JButton bun_them,bun_sua,bun_xoa;
    JTable tab_list;
    JScrollPane sp_list_staff, sp_list_customer;
    String[] collum = { "Ma nhan vien", "Ten", "Gioi tinh", "Dia chi", "Email", "So dien thoai", "Ma nhom quyen" };

    // String ma,ten,gioitinh,diachi,email,sodienthoai;
    // int diem;
    String[] info_field = { "Ma nhan vien:", "Ten:", "Gioi tinh:", "Dia chi:", "Email:", "So dien thoai:",
            "Nhom quyen" };
    JLabel[] lab_info_field = new JLabel[info_field.length];
    JTextField[] txt_info_field = new JTextField[info_field.length];
    JComboBox com_nhomquyen;


    String[] com_nhomquyen_str ={"Quan ly","Nhan vien","Khach hang"};
    String name_font = "Segoe UI";
    Color color_54 = new Color(54, 54, 54);

    public pan_staff(menu obj) {
        this.obj = obj;
        init();
    }

    private void init() {
        this.setBackground(new Color(54, 54, 54));
        this.setLayout(null);
        // set title cua panel
        title = new JLabel("Quan li nhan vien");
        title.setBounds(0, 0, 1000, 50);
        title.setFont(new Font(name_font, 1, 30));
        title.setOpaque(true);
        title.setForeground(Color.white);
        title.setBackground(Color.red);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(title);
        // set panel info
        // noi hien thi thong tin nhan vien
        pan_info = new JPanel();
        pan_info.setLayout(new FlowLayout(0, 5, 10));
        pan_info.setBounds(10, 80, 600, 300);
        pan_info.setBackground(color_54);
        this.add(pan_info);
        // set cac label cac text nam trong panel info
        for (int i = 0; i < info_field.length - 1; i++) {
            lab_info_field[i] = new JLabel(info_field[i]);
            lab_info_field[i].setPreferredSize(new Dimension(150, 30));
            lab_info_field[i].setOpaque(true);
            lab_info_field[i].setBackground(color_54);
            lab_info_field[i].setFont(new Font(name_font, 3, 15));
            lab_info_field[i].setHorizontalAlignment(SwingConstants.LEFT);
            lab_info_field[i].setForeground(Color.white);
            pan_info.add(lab_info_field[i]);
            // set text
            txt_info_field[i] = new JTextField();
            txt_info_field[i].setPreferredSize(new Dimension(350, 30));
            txt_info_field[i].setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            txt_info_field[i].setOpaque(true);
            txt_info_field[i].setBackground(color_54);
            txt_info_field[i].setFont(new Font(name_font, 3, 15));
            txt_info_field[i].setHorizontalAlignment(SwingConstants.LEFT);
            txt_info_field[i].setForeground(Color.white);
            pan_info.add(txt_info_field[i]);
        }
        lab_nhomuyen = new JLabel("Nhom quyen");
        lab_nhomuyen.setPreferredSize(new Dimension(150, 30));
        lab_nhomuyen.setOpaque(true);
        lab_nhomuyen.setBackground(color_54);
        lab_nhomuyen.setFont(new Font(name_font, 3, 15));
        lab_nhomuyen.setHorizontalAlignment(SwingConstants.LEFT);
        lab_nhomuyen.setForeground(Color.white);
        pan_info.add(lab_nhomuyen);

        com_nhomquyen=new JComboBox(com_nhomquyen_str);
        com_nhomquyen.setPreferredSize(new Dimension(350,30));
        com_nhomquyen.setOpaque(true);
        com_nhomquyen.setBackground(color_54);
        com_nhomquyen.setFont(new Font(name_font,1,15));
        com_nhomquyen.setForeground(Color.white);
        pan_info.add(com_nhomquyen);
        //set panel det chua bang chua danh sach nhan vien
        pan_list_staff=new JPanel();
        pan_list_staff.setLayout(null);
        pan_list_staff.setBounds(30,400,950,250);
        pan_list_staff.setBackground(Color.red);
        this.add(pan_list_staff);
        // set tabel danh sach nhan vien
        tab_list=new JTable();
        tab_list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
                DefaultTableModel model=(DefaultTableModel)tab_list.getModel();
				int selectrow=tab_list.getSelectedRow();
				// String tk=model.getValueAt(selectrow, 1).toString();
				txt_info_field[0].setText(model.getValueAt(selectrow, 0).toString());
				txt_info_field[1].setText(model.getValueAt(selectrow, 1).toString());
				txt_info_field[2].setText(model.getValueAt(selectrow,2).toString());
				txt_info_field[3].setText(model.getValueAt(selectrow, 3).toString());
				txt_info_field[4].setText(model.getValueAt(selectrow, 4).toString());
                txt_info_field[5].setText(model.getValueAt(selectrow, 5).toString());
                txt_info_field[6].setText(model.getValueAt(selectrow, 6).toString());
                
				//System.out.println(tk);
			}
		});
        tab_list.setModel(new DefaultTableModel(
			new Object[][] {
			},
			collum
		));
        chucnang.show_list_staff(tab_list);
        sp_list_staff=new JScrollPane(tab_list);
        sp_list_staff.setBounds(0,0,950,250);
        pan_list_staff.add(sp_list_staff);
        //set panel chuc nag cac nut them sua xoa
        pan_chucnang=new JPanel();
        pan_chucnang.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        pan_chucnang.setBackground(color_54);
        pan_chucnang.setBounds(600,80,300,300);
        this.add(pan_chucnang);
        //tao cac nut them sua xoa
        bun_them=new JButton("Them");
        bun_sua=new JButton("Sua");
        bun_xoa=new JButton("Xoa");
        bun_them.setPreferredSize(new Dimension(250,50));
        bun_sua.setPreferredSize(new Dimension(250,50));
        bun_xoa.setPreferredSize(new Dimension(250,50));
        bun_them.setFont(new Font(name_font,1,40));
        bun_sua.setFont(new Font(name_font,1,40));
        bun_xoa.setFont(new Font(name_font,1,40));
        pan_chucnang.add(bun_them);
        pan_chucnang.add(bun_sua);
        pan_chucnang.add(bun_xoa);
        tab_list.addMouseListener(this);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       
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
