package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.fun_frp_model;

public class group_function extends JPanel implements MouseListener{
    menu1 obj;
    JLabel lab1,add_fun;
    JTable tab_fun;
    JScrollPane sp;
    String[] columnNames = { "ID", "Name group","Date created","Date update","Action"};
    JButton bun_del,bun_up;
    
    
    
    
    fun_frp_model fun_frp_model=new fun_frp_model();
    public void change_add_fun_grp(){
        add_group_function pan1=new add_group_function(obj.wd_center,obj.hih_center);
        pan1.setBounds(0,0,obj.wd_center,obj.hih_center);
        obj.pan_center.removeAll();
        obj.pan_center.add(pan1);
        obj.pan_center.repaint();
        obj.pan_center.revalidate();
    }
    public group_function(menu1 obj,int w,int h){
        this.obj=obj;
        init(w,h);
    }
    private void init(int w,int h){
        //tao mau background
        this.setPreferredSize(new Dimension(w,h));
        this.setBackground(new Color(54,54,54));
        //set layout cho panel
        
        this.setLayout(null);
        //tao moi va thiet ke jlabel lap 1(title cua panel group_fun)
        lab1=new JLabel("Function groups");
        lab1.setBounds(80,30,400,60);
        lab1.setBackground(new Color(54,54,54));
        lab1.setForeground(Color.white);
        lab1.setFont(new Font("Segoe UI",1,40));
        this.add(lab1);
        //tao moi va thiet ke jlabel add_fun(nut de tao moi nhom quyen)
        add_fun=new JLabel("Add group");
        add_fun.setBounds(850,30,130,60);
        add_fun.setOpaque(true);
        add_fun.setBackground(Color.red);
        add_fun.setForeground(Color.white);
        add_fun.setFont(new Font("Segoe UI",1,25));
        this.add(add_fun);
        add_fun.addMouseListener(this);
        //set  nut delete va update
        bun_del=new JButton("Delete");
        bun_up=new JButton("Update");
        bun_del.setPreferredSize(new Dimension(100,30));
        bun_up.setPreferredSize(new Dimension(100,30));
        //tao bang thong ke cac nhom quyen
        tab_fun=new JTable();
        tab_fun.setModel(new DefaultTableModel(
			new Object[][] {
			},
			columnNames
		));
        fun_frp_model.hienthisanpham(tab_fun);
        sp=new JScrollPane(tab_fun);
        sp.setBounds(80,150,900,150);
        this.add(sp);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }
    @Override
    public void mousePressed(MouseEvent e) {
      if(e.getSource()==add_fun){
        change_add_fun_grp();
      }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==add_fun){
            add_fun.setOpaque(true);
            add_fun.setBackground(Color.blue);
        }
    }
    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==add_fun){
            add_fun.setOpaque(true);
            add_fun.setBackground(Color.red);
        }
    }
}
