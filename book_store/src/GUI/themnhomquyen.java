package GUI;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.concurrent.Flow;

import javax.swing.border.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DTO.chitietnhomquyen;
import DTO.chucnang;

public class themnhomquyen extends JPanel implements ItemListener {
    main obj;
    Color color_211 = new Color(211, 211, 211);
    String name_font1 = "Times Roman";
    // ---------------------
    // test

    // ----------------------
    JTextField txt_manhomquyen, txt_tennhomquyen;
    JScrollPane thanhkeo;
    JPanel pan_info, pan_chucnang, pan_add;
    JButton bun_sua;
    int id;
    public themnhomquyen(main obj) {
        this.obj = obj;
        init(obj);
    }

    private void init(main init) {
        ArrayList<chitietnhomquyen> list_chitiet = new ArrayList<>();
        ArrayList<chucnang> list_chucnang = new ArrayList<>();
        chitietnhomquyen temp1 = new chitietnhomquyen(1, 1, "Them", 0);
        chitietnhomquyen temp2 = new chitietnhomquyen(1, 1, "Sua", 1);
        chitietnhomquyen temp3 = new chitietnhomquyen(1, 1, "Xoa", 0);
        chitietnhomquyen temp4 = new chitietnhomquyen(2, 2, "Them", 1);
        chitietnhomquyen temp5 = new chitietnhomquyen(2, 2, "Sua", 0);
        chitietnhomquyen temp6 = new chitietnhomquyen(2, 2, "Xoa", 1);

        // --
        chucnang temp7 = new chucnang(1, "Quan li");
        chucnang temp8 = new chucnang(2, "Nhan vien");
        list_chitiet.add(temp1);
        list_chitiet.add(temp2);
        list_chitiet.add(temp3);
        list_chitiet.add(temp4);
        list_chitiet.add(temp5);
        list_chitiet.add(temp6);
        list_chucnang.add(temp7);
        list_chucnang.add(temp8);
        // --------------------------------------------------------
        this.setPreferredSize(new Dimension(obj.w_center, obj.h_center));
        this.setLayout(null);
        this.setBackground(color_211);
        // set cac panel nho
        pan_info = new JPanel();
        pan_info.setBounds(0, 10, obj.w_center, 80);
        pan_info.setLayout(new FlowLayout(FlowLayout.CENTER));
        pan_info.setBackground(color_211);
        this.add(pan_info);
        txt_manhomquyen = new JTextField();
        txt_manhomquyen.setPreferredSize(new Dimension(300, 60));
        txt_manhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_manhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ma nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_info.add(txt_manhomquyen);
        txt_tennhomquyen = new JTextField();
        txt_tennhomquyen.setPreferredSize(new Dimension(400, 60));
        txt_tennhomquyen.setFont(new Font(name_font1, 1, 25));
        txt_tennhomquyen.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                "Ten nhom quyen",
                TitledBorder.LEFT,
                TitledBorder.TOP));
        ;
        pan_info.add(txt_tennhomquyen);
        pan_chucnang = new JPanel();
        pan_chucnang.setBounds(0, 100, obj.w_center, 480);
        pan_chucnang.setBackground(color_211);
        pan_chucnang.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(pan_chucnang);
        // thanhkeo=new JScrollPane(pan_chucnang);
        JPanel[] pan = new JPanel[list_chucnang.size()];
        for (int i = 0; i < list_chucnang.size(); i++) {
            pan[i] = new JPanel();
            pan[i].setPreferredSize(new Dimension(200, 230));
            pan[i].setBackground(color_211);
            pan[i].setLayout(new FlowLayout());
            pan[i].setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black),
                    list_chucnang.get(i).getTen(),
                    TitledBorder.CENTER,
                    TitledBorder.TOP));
            ;

            for (int j = 0; j < list_chitiet.size(); j++) {
                if (list_chitiet.get(j).getMachucnang()== list_chucnang.get(i).getMa()) {
                    JCheckBox temp = new JCheckBox(list_chitiet.get(j).getHanhdong());
                    temp.setFont(new Font("Segoe UI", 1, 20));
                    temp.setPreferredSize(new Dimension(190, 50));
                    temp.setBackground(color_211);
                    temp.setForeground(Color.black);
                    if (list_chitiet.get(j).getTinhtrang()== 1){
                       
                        System.out.println(list_chitiet.get(j).getMachucnang());
                        temp.setSelected(true);}
                    else{
                        temp.setSelected(false);
                       
                    }
                    temp.addItemListener(this);
                    pan[i].add(temp);
                }
                
                
            }
            pan_chucnang.add(pan[i]);
            
        }
        pan_add = new JPanel();
        pan_add.setBounds(0, 600, obj.w_center, 60);
        pan_add.setBackground(color_211);
        pan_add.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.add(pan_add);
        bun_sua = new JButton("Sua");
        bun_sua.setPreferredSize(new Dimension(200, 50));
        bun_sua.setFont(new Font(name_font1, 1, 25));
        pan_add.add(bun_sua);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println("Event"+e);
        if (e.getStateChange() == ItemEvent.SELECTED) {
            // Checkbox đã được chọn
            // System.out.println(e.getSource().getClass());
            System.out.println(e.getSource().toString());
            // System.out.println(id);
        } else {
            // Checkbox không được chọn
            System.out.println(e.getSource());
        }
    }
}
