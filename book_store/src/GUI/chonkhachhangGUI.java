package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BUS.quanlikhachhang;
import DTO.khachhang;
import GUI.Mybutton.searchbutton;

public class chonkhachhangGUI extends JFrame {
    private JTextField makhinp;
    private quanlikhachhang qlkhBUS = new quanlikhachhang();

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

    public chonkhachhangGUI(JTextField _makhinp) {
        this.setTitle("Chọn khách hàng");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.makhinp = _makhinp;
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
        searchbtn.setPreferredSize(new Dimension(100, 35));

        searchpnl.add(searchinp);
        searchpnl.add(searchbtn);

        return searchpnl;
    }

    public Mytable cusTable() {
        custable = new Mytable();
        custable.setTablesize(0, 500);
        custable.setHeader(new String[]{"Mã KH","Họ tên","Giới tính","Địa chỉ","Email","Số điện thoại","Điểm","Trạng thái"});
        setDataToTable(qlkhBUS.getListKH(), custable);
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

        searchinp.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                searchOnchange();
              }
              public void removeUpdate(DocumentEvent e) {
                searchOnchange();
              }
              public void insertUpdate(DocumentEvent e) {
                searchOnchange();
              }
        });
        searchbtn.addActionListener((ae) -> {
            searchOnchange();
        });

        okbtn.addActionListener((ae) -> {
            int row = custable.getTable().getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng nào!");
            }
            else {
                String makh= (String) custable.getTable().getValueAt(row,0);
                if(makh != null) {
                    this.makhinp.setText(makh);
                    this.dispose();
                }
            }
        });

        cancelbtn.addActionListener((ae) -> {
            this.dispose();
        });
        return buttonpnl;
    }

    private void searchOnchange() {
        setDataToTable(qlkhBUS.searchKH(searchinp.getText()), custable);
    }

    private void setDataToTable(ArrayList<khachhang> list , Mytable t) {
        t.clear();
        String gt="";
        String tinhtrang="";
        for (khachhang kh : list) {
            if(kh.getGioitinh() == 1) {
                gt="Nam";
            }
            else {
                gt="Nữ";
            }
            if(kh.getTinhtrang() == 1) {
                tinhtrang="Hiện";
            }
            else {
                tinhtrang="Ẩn";
            }
            t.addRow(new Object[] {
                String.valueOf(kh.getMa()),
                kh.getTen(),
                gt,
                kh.getDiachi(),
                kh.getEmail(),
                kh.getSodienthoai(),
                String.valueOf(kh.getDiem()),
                tinhtrang
            });
        }
    }
}
