package sale;

import javax.swing.*;
import java.awt.*;

public class sale_action extends JPanel {
    public sale_action() {
        this.setBackground(Color.GRAY);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        init();
    }
    public void init() {
        JPanel info_pnl = new JPanel();
        JPanel btn_pnl = new JPanel();
        JPanel employee_pnl = new JPanel();

        JPanel bill_pnl1 = new JPanel();
        JPanel bill_pnl2 = new JPanel();
        
        
        info_pnl.setLayout(new GridLayout(1,3));
        btn_pnl.setLayout(new FlowLayout(FlowLayout.CENTER));
        btn_pnl.setBackground(Color.CYAN);
        employee_pnl.setLayout(new FlowLayout(FlowLayout.LEFT));
        employee_pnl.setBackground(Color.BLACK);
        
        bill_pnl1.setBackground(Color.ORANGE);
        bill_pnl2.setBackground(Color.MAGENTA);
        
        info_pnl.setPreferredSize(new Dimension(0,230));
        btn_pnl.setPreferredSize(new Dimension(0,70));
        employee_pnl.setPreferredSize(new Dimension(0,40));
        
        //Them thong tin vao panel customer
        String []cus_lable = {"Customer id:","Name:","Phone:","Address:"};
        JPanel customer_pnl = new JPanel();
        customer_pnl.setLayout(new GridLayout(cus_lable.length+2,1));
        customer_pnl.setBackground(Color.LIGHT_GRAY);
        JLabel cus = new JLabel("Customer",JLabel.CENTER);
        cus.setFont(new Font("",Font.PLAIN,25));
        customer_pnl.add(cus);
        JPanel []cus_pnl = new JPanel[cus_lable.length];
        JTextField []cus_txt = new JTextField[cus_lable.length];
        for(int i=0;i<cus_pnl.length;i++) {
            cus_pnl[i] = new JPanel();
            cus_pnl[i].setLayout(new FlowLayout(FlowLayout.LEFT));
            cus_txt[i] = new JTextField();
            cus_txt[i].setPreferredSize(new Dimension(250,25));
            cus_pnl[i].add(new JLabel(cus_lable[i]));         
            cus_pnl[i].add(cus_txt[i]);
            customer_pnl.add(cus_pnl[i]);         
        }
        JButton cus_btn = new JButton("Search");
        customer_pnl.add(cus_btn);
        info_pnl.add(customer_pnl);
        
        info_pnl.add(bill_pnl1);
        info_pnl.add(bill_pnl2);

        this.add(info_pnl);
        this.add(btn_pnl);
        this.add(employee_pnl);
    }
}
