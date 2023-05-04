package GUI.nhaphangGUI;

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

import BUS.quanlinhacungcap;
import DTO.nhacungcap;
import GUI.Mytable;
import GUI.Mybutton.searchbutton;

public class chonnhacungcapGUI extends JFrame {
    private JTextField nccinp;
    private quanlinhacungcap qlncc = new quanlinhacungcap();

    //north panel
    private JPanel searchpnl;
    private JTextField searchinp;
    private searchbutton searchbtn;

    //center panel
    Mytable ncctable;

    //south panel
    private JPanel buttonpnl;
    private JButton okbtn;
    private JButton cancelbtn;

    public chonnhacungcapGUI(JTextField _nccinp) {
        this.setTitle("Chọn nhà cung cấp");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.nccinp = _nccinp;
        init();
        this.setVisible(true);
    }
   
     public void init() {
        this.add(searchPanel(),BorderLayout.NORTH);
        this.add(nccTable(),BorderLayout.CENTER);
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

    public Mytable nccTable() {
        ncctable = new Mytable();
        ncctable.setTablesize(0, 500);
        ncctable.setHeader(new String[]{"Mã NCC","Họ tên","Địa chỉ","Email","Số điện thoại"});
        qlncc.initList();
        setDataToTable(qlncc.getList(), ncctable);
        int width = 200;
        ncctable.setPreferredWidth(1,width);
        ncctable.setPreferredWidth(2,width);
        ncctable.setPreferredWidth(3,width);
        ncctable.setPreferredWidth(4,width);

        return ncctable;
    }

    public JPanel buttonPanel() {
        buttonpnl = new JPanel();
        buttonpnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        buttonpnl.setPreferredSize(new Dimension(0, 50));
        okbtn = new JButton("Chọn", new ImageIcon(this.getClass().getResource("../../icon/icons8_ok_30px.png")));
        cancelbtn = new JButton("Hủy", new ImageIcon(this.getClass().getResource("../../icon/icons8_cancel_30px_1.png")));
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
            int row = ncctable.getTable().getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(this, "Chưa chọn nhà cung cấp nào!");
            }
            else {
                String makh= (String) ncctable.getTable().getValueAt(row,0);
                if(makh != null) {
                    this.nccinp.setText(makh);
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
        setDataToTable(qlncc.searchNCC(searchinp.getText()), ncctable);
    }

    private void setDataToTable(ArrayList<nhacungcap> list , Mytable t) {
        t.clear();
        t.addRow(new Object[] {
            "0",
            "Tất cả",
            "",
            "",
            "",
        });
        for (nhacungcap ncc : list) {
            if(ncc.getTinhtrang()==0) {
                continue;
            } else {
                t.addRow(new Object[] {
                    String.valueOf(ncc.getMa()),
                    ncc.getTen(),
                    ncc.getDiaChi(),
                    ncc.getEmail(),
                    ncc.getSDT()
                });
            }
        }
    }
}

