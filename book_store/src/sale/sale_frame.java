package sale;

import java.awt.*;
import java.io.IOException;

import javax.swing.*;

public class sale_frame extends JPanel {
    private sale_search search_pnl;
    private sale_table table_pnl;
    private sale_action action_pnl;
    public sale_frame() throws IOException {
        this.setPreferredSize(new Dimension(1000,700));
        setLayout(new BorderLayout(0,0));
        init();
    }
    public void init() throws IOException {
        search_pnl = new sale_search();
        table_pnl = new sale_table();
        action_pnl = new sale_action();
        search_pnl.setPreferredSize(new Dimension(0,50));
        table_pnl.setPreferredSize(new Dimension(0,400));
        action_pnl.setPreferredSize(new Dimension(0,350));

        this.add(action_pnl,BorderLayout.SOUTH);
        this.add(table_pnl,BorderLayout.CENTER);
        this.add(search_pnl,BorderLayout.NORTH);
    }
}
