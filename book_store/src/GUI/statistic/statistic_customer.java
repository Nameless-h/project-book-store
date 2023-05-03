package GUI.statistic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


import BUS.PriceFormatter;
import DAO.quanlihoadonbanhangDAO;
import DAO.thongKeSachDAO;
import DTO.khachhang;
import GUI.hienThiThongKeKH;
import GUI.Mybutton.morebutton;
import java.awt.FlowLayout;


public class statistic_customer extends JPanel implements ActionListener,KeyListener{

    private JPanel headerFilterContainInput;
    private JButton headerSearchBtn;
    private String title_filter[] = {"Tìm kiếm","Xem chi tiết"};//menu title filter
    private String[] columnNames = {"ID","Tên Khách hàng","Email","Chi trả"};
    private JPanel panel_filter_bestSeller,panel_filter_supplier;
    private JTextField inputSearchName;
    private statisticTable bookSoldTable;
    private morebutton selectSupplier = new morebutton();

    private thongKeSachDAO kh;
    private ArrayList<khachhang> listKH;

    public statistic_customer() {
        setLayout(new BorderLayout());
        // header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.lightGray);

        // header search contain input
        headerFilterContainInput = new JPanel();
        headerFilterContainInput.setBackground(Color.lightGray);
        headerFilterContainInput.setPreferredSize(new Dimension(850, 0));
        headerFilterContainInput.setLayout(new FlowLayout(SwingConstants.RIGHT));
        headerFilterContainInput.setFont(new Font("Arial", Font.PLAIN, 20));
        
        headerFilterContainInput.setBorder(BorderFactory.createEmptyBorder());
  
        //panel filter best seller
        panel_filter_bestSeller = new JPanel();
        panel_filter_bestSeller.setPreferredSize(new Dimension(300, 60));
        panel_filter_bestSeller.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderBestSeller = new LineBorder(Color.white);
        TitledBorder titledBorderBestSeller = BorderFactory.createTitledBorder(linedBorderBestSeller, title_filter[0]);
        titledBorderBestSeller.setTitleJustification(TitledBorder.CENTER);
        panel_filter_bestSeller.setBorder(titledBorderBestSeller);

        inputSearchName = new JTextField();
        inputSearchName.setPreferredSize(new Dimension(250, 30));
        inputSearchName.getDocument().addDocumentListener(new DocumentListener() {
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
        
        panel_filter_bestSeller.add(inputSearchName);

        headerFilterContainInput.add(panel_filter_bestSeller);

        //panel filter supplier
        panel_filter_supplier = new JPanel();
        panel_filter_supplier.setPreferredSize(new Dimension(160, 60));
        panel_filter_supplier.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderSupplier = new LineBorder(Color.white);
        TitledBorder titledBorderSupplier = BorderFactory.createTitledBorder(linedBorderSupplier, title_filter[1]);
        titledBorderSupplier.setTitleJustification(TitledBorder.CENTER);
        panel_filter_supplier.setBorder(titledBorderSupplier);

        selectSupplier.setPreferredSize(new Dimension(80, 30));
        selectSupplier.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectSupplier.addActionListener(this);
        panel_filter_supplier.add(selectSupplier);

        headerFilterContainInput.add(panel_filter_supplier);

        // header search button
        headerSearchBtn = new JButton("Tìm");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(242, 59, 46));
        headerSearchBtn.setPreferredSize(new Dimension(100, 40));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);
        headerFilterContainInput.add(headerSearchBtn);

        header.add(headerFilterContainInput,BorderLayout.WEST);
        
        // table
        bookSoldTable = new statisticTable();
        bookSoldTable.setTablesize(1100,535);
        bookSoldTable.setBackground(Color.lightGray);
        bookSoldTable.setHeader(columnNames);

        // get table data
        kh = new thongKeSachDAO();
        listKH = kh.selectThongKeKH();

        for (khachhang i : listKH) {
            bookSoldTable.addRow(new Object[]{
                i.getMa(),
                i.getTen(),
                i.getEmail(),
                PriceFormatter.format(i.getGioitinh())
            });
        }

        bookSoldTable.setPreferredWidth(0, 50);
        bookSoldTable.setPreferredWidth(1, 200);
        bookSoldTable.setPreferredWidth(2, 150);
        bookSoldTable.setPreferredWidth(3, 200);

        bookSoldTable.setAlignment(0, JLabel.CENTER);
        bookSoldTable.setAlignment(3, JLabel.CENTER);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 70));
        bookSoldTable.setPreferredSize(new Dimension(0, 0));
        
        add(header, BorderLayout.NORTH);
        add(bookSoldTable, BorderLayout.CENTER);

    }

    private void searchOnchange() {
        setDataToTable(inputSearchName.getText(), bookSoldTable);
    }

    private void setDataToTable(String name , statisticTable t) {
        t.clearTable();
        for (khachhang i : listKH) {
            if( String.valueOf(i.getMa()).contains(name) || 
                i.getTen().toLowerCase().contains(name.toLowerCase()) || 
                i.getEmail().toLowerCase().contains(name.toLowerCase())
            ) { 
                t.addRow(new Object[]{
                    i.getMa(),
                    i.getTen(),
                    i.getEmail(),
                    PriceFormatter.format(i.getGioitinh())
                });
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == selectSupplier) {
            int row = bookSoldTable.getTable().getSelectedRow();
            if(row == -1) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn khách hàng để xem chi tiết !","Thông báo",1);
                return;
            } else {
                int makh = (int) bookSoldTable.getTable().getModel().getValueAt(row,0);
                // System.out.print(manv);
                new hienThiThongKeKH(makh);
            }
        }
    }
}
