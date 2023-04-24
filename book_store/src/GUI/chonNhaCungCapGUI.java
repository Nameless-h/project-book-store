package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import GUI.Mybutton.searchbutton;

public class chonNhaCungCapGUI extends JFrame {
    private JTextField tenkhinp;

    //north panel
    private JPanel searchpnl;
    private JTextField searchinp;
    private searchbutton searchbtn;

    //center panel
    Mytable custable;

    //south panel
    private JPanel buttonpnl;
    private JButton okbtn;
    private JButton cancelbtn;

    public chonNhaCungCapGUI(JTextField _tenkhinp) {
        this.setTitle("Chọn nha cung cap");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.tenkhinp = _tenkhinp;
        init();
        this.setVisible(true);
    }
    public void init() {
        this.add(searchPanel(),BorderLayout.NORTH);
        this.add(cusTable(),BorderLayout.CENTER);
        this.add(buttonPanel(),BorderLayout.SOUTH);
    }

    public JPanel searchPanel() {
        searchpnl = new JPanel();
        searchinp = new JTextField();
        searchbtn = new searchbutton();

        searchpnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        searchpnl.setPreferredSize(new Dimension(0, 50));
        searchinp.setPreferredSize(new Dimension(350, 35));
        searchbtn.setPreferredSize(new Dimension(120, 35));

        searchpnl.add(searchinp);
        searchpnl.add(searchbtn);

        return searchpnl;
    }

    public Mytable cusTable() {
        custable = new Mytable();
        custable.setTablesize(0, 500);
        custable.setHeader(new String[]{"Mã KH","Họ tên","Giới tính","Địa chỉ","Email","Số điện thoại","Điểm","Trạng thái"});
        for (int i = 0; i < 15; i++) {
            custable.addRow(new Object[]{
                String.valueOf(i+1),
                "Hu chuynh " + String.valueOf(i+1),
                "Nam",
                "Guang Dong",
                "huchuynh123@gmail.com",
                "0938446999",
                "100",
                "Hiện"
            });
        }

        int width = 200;
        custable.setPreferredWidth(1,width);
        custable.setPreferredWidth(3,width);
        custable.setPreferredWidth(4,width);
        custable.setPreferredWidth(5,width-50);

        return custable;
    }

    public JPanel buttonPanel() {
        buttonpnl = new JPanel();
        buttonpnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        buttonpnl.setPreferredSize(new Dimension(0, 50));
        okbtn = new JButton("OK", new ImageIcon(this.getClass().getResource("../icon/icons8_ok_30px.png")));
        cancelbtn = new JButton("Hủy", new ImageIcon(this.getClass().getResource("../icon/icons8_cancel_30px_1.png")));
        okbtn.setPreferredSize(new Dimension(150, 35));
        cancelbtn.setPreferredSize(new Dimension(150, 35));
        buttonpnl.add(okbtn);
        buttonpnl.add(cancelbtn);

        okbtn.addActionListener((ae) -> {
            int row = custable.getTable().getSelectedRow();
            String tenkh = (String) custable.getTable().getValueAt(row,1);
            if(tenkh != null) {
                this.tenkhinp.setText(tenkh);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn nha cung cap nào!");
            }
        });

        cancelbtn.addActionListener((ae) -> {
            this.dispose();
        });
        return buttonpnl;
    }

}
