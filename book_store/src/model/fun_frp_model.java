package model;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import function_user.fun_group;

public class fun_frp_model {
    public void hienthisanpham(JTable table_1) {
        ArrayList<fun_group> list=new ArrayList<>();
        fun_group test1=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test2=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
        fun_group test3=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test4=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test5=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
        fun_group test6=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test7=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
        fun_group test8=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test9=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
		fun_group test10=new fun_group("admin1","Quan li", "25-3-2023", "25-3-2023");
        list.add(test1);
        list.add(test2);
        list.add(test3);
        list.add(test4);
        list.add(test5);
        list.add(test6);
        list.add(test7);
        list.add(test8);
        list.add(test9);
        list.add(test10);

        
        DefaultTableModel model=(DefaultTableModel)table_1.getModel();
		model.setRowCount(0);
		for(int i=0;i<list.size();i++) {
			model.addRow(new Object[] {list.get(i).getMa(),list.get(i).getTen(),list.get(i).getDatecrt(),list.get(i).getDateup()});
		}
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table_1.getColumnModel().getColumn(0).setCellRenderer( centerRenderer);
	}
}
