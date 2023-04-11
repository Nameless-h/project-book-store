package sale;

import javax.swing.*;
import java.awt.*;

public class sale_search extends JPanel{
    private JTextField input;
    private JButton button;
    public sale_search() {
        init();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(Color.WHITE);
    }

    public void init() {
        input = new JTextField();
        button = new JButton("Search");
        input.setPreferredSize(new Dimension(800,40));
        button.setPreferredSize(new Dimension(100,40));
        this.add(input);
        this.add(button);
    }
    /* public void init(){
        JPanel left_pnl = new JPanel();
        JPanel right_pnl = new JPanel();
        JPanel title_pnl = new JPanel();
        JPanel input_pnl = new JPanel();
        JLabel name_lable = new JLabel("Book name",SwingConstants.CENTER);
        JLabel id_lable = new JLabel("Book ID",SwingConstants.CENTER);
        JLabel price_lable = new JLabel("Price",SwingConstants.CENTER);
        JLabel quantity_lable = new JLabel("Quantity",SwingConstants.CENTER);
        JTextField name_txt = new JTextField();
        JTextField id_txt = new JTextField();
        JTextField price_txt = new JTextField();
        JPanel quantity_pnl = new JPanel();
        JTextField quantity_txt = new JTextField();
        JButton minus_btn = new JButton("-");
        JButton search_btn = new JButton("Search");
        JButton plus_btn = new JButton("+");
        JButton add_btn = new JButton("Add");

        left_pnl.setLayout(new GridLayout(2,1));
        right_pnl.setLayout(new FlowLayout(FlowLayout.CENTER,5,15));
        right_pnl.setBackground(new Color(39,39,39));
        title_pnl.setLayout(new GridLayout(1,4));
        title_pnl.setBackground(new Color(255,30,30));
        input_pnl.setLayout(new GridLayout(1,4));
        input_pnl.setBackground(Color.GRAY);
        quantity_pnl.setLayout(new GridLayout(1,3));
        name_lable.setForeground(Color.white);
        id_lable.setForeground(Color.white);
        price_lable.setForeground(Color.white);
        quantity_lable.setForeground(Color.white);
        
        left_pnl.setPreferredSize(new Dimension(856,0));
        right_pnl.setPreferredSize(new Dimension(214,0));
        search_btn.setPreferredSize(new Dimension(100,30));
        add_btn.setPreferredSize(new Dimension(100,30));
        
        title_pnl.add(id_lable);
        title_pnl.add(name_lable);
        title_pnl.add(price_lable);
        title_pnl.add(quantity_lable);
        input_pnl.add(id_txt);
        input_pnl.add(name_txt);
        input_pnl.add(price_txt);

        quantity_pnl.add(minus_btn);
        quantity_pnl.add(quantity_txt);
        quantity_pnl.add(plus_btn);

        input_pnl.add(quantity_pnl);
        
        left_pnl.add(title_pnl);
        left_pnl.add(input_pnl);
        right_pnl.add(search_btn);
        right_pnl.add(add_btn);
        
        this.add(left_pnl);
        this.add(right_pnl);
    } */
} 
