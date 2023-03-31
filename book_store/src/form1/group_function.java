package form1;

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
    JLabel lab1,add_fun;
    JTable tab_fun;
    JScrollPane sp;
    String[] columnNames = { "ID", "Name group","Date created","Date update","Action"};
    JButton bun_del,bun_up;
    
    
    
    
    fun_frp_model fun_frp_model=new fun_frp_model();
    public group_function(){
        init();
    }
    private void init(){
        //tao mau background
        this.setPreferredSize(new Dimension(700,700));
        this.setBackground(new Color(54,54,54));
        //set layout cho panel
        this.setLayout(null);
        //tao moi va thiet ke jlabel lap 1(title cua panel group_fun)
        lab1=new JLabel("Function groups");
        lab1.setBounds(20,30,400,60);
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
        sp.setBounds(50,150,900,150);
        this.add(sp);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
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
