package sale;

import java.awt.*;
import javax.swing.*;

public class sale_frame extends JFrame {
    public sale_frame() {
        init();
        setLocation(230,0);
        setSize(1070,800);
        setResizable(false);
        setVisible(true);
        setLayout(new BorderLayout(0,0));
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    public void init() {
        sale_search search_pnl = new sale_search();
        JPanel table_pnl = new JPanel();
        sale_action action_pnl = new sale_action();
        search_pnl.setPreferredSize(new Dimension(0,60));
        table_pnl.setPreferredSize(new Dimension(0,400));
        action_pnl.setPreferredSize(new Dimension(0,340));
        
        table_pnl.setBackground(Color.GREEN);
        
        this.add(action_pnl,BorderLayout.SOUTH);
        this.add(table_pnl,BorderLayout.CENTER);
        this.add(search_pnl,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new sale_frame();
    }
}
