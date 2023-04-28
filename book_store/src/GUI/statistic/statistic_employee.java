package GUI.statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import DAO.nhanvienDAO;
import DAO.thong_ke_sach_banDAO;
import DTO.SachBan;
import DTO.nhanvien;
import GUI.chonNhaCungCapGUI;
import GUI.Mybutton.morebutton;
import GUI.main;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class statistic_employee extends JPanel implements ActionListener,KeyListener{
    private JPanel headerFilterContainInput;
    private JButton headerSearchBtn;
    private String title_filter[] = {"Khoang ngay","Tim kiem","Xem chi tiet"};//menu title filter
    private String[] columnNames = {"ID","Ten nhan vien","Chuc vu","Email","Gioi tinh","SDT"};
    private JPanel panel_filter_date,panel_filter_bestSeller,panel_filter_supplier;
    private JTextField inputDateStart,inputDateEnd;
    private JLabel dateStart,dateEnd;
    private SpinnerModel model = new SpinnerNumberModel(0, 0, 15, 1);     
    private JSpinner inputBestSeller = new JSpinner(model);
    private statisticTable bookSoldTable;
    private morebutton selectSupplier = new morebutton();

    public statistic_employee() {
        setLayout(new BorderLayout());
        // header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());

        // header search
        JPanel headerFilter = new JPanel();
        headerFilter.setPreferredSize(new Dimension(600, 40));
        headerFilter.setLayout(new BorderLayout());
        headerFilter.setBackground(Color.lightGray);
        headerFilter.setFocusable( true );
        header.add(headerFilter);

        // header search contain input
        headerFilterContainInput = new JPanel();
        headerFilterContainInput.setLayout(new FlowLayout(SwingConstants.RIGHT));
        headerFilterContainInput.setBackground(Color.lightGray);
        headerFilterContainInput.setPreferredSize(new Dimension(800, 0));
        headerFilterContainInput.setFont(new Font("Arial", Font.PLAIN, 20));
        
        headerFilterContainInput.setBorder(BorderFactory.createEmptyBorder());
        // inputSearchFocus(headerSearchInput);
        
        // panel filter date
        panel_filter_date = new JPanel();
        panel_filter_date.setLayout(new FlowLayout());
        panel_filter_date.setPreferredSize(new Dimension(300, 60));
        panel_filter_date.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderDate = new LineBorder(Color.white);
        TitledBorder titledBorderDate = BorderFactory.createTitledBorder(linedBorderDate, title_filter[0]);
        titledBorderDate.setTitleJustification(TitledBorder.CENTER);
        // Border titledBorderDate = BorderFactory.createLineBorder(Color.white,2);
        // titledBorderDate.setTitleColor(Color.white);
        // titledBorderDate.set();
        panel_filter_date.setBorder(titledBorderDate);
        
        inputDateStart = new JTextField();
        inputDateStart.setPreferredSize(new Dimension(100, 30));
        inputDateEnd = new JTextField();
        inputDateEnd.setPreferredSize(new Dimension(100, 30));

        dateStart = new JLabel("Tu");
        dateEnd = new JLabel("den");

        panel_filter_date.add(dateStart);
        panel_filter_date.add(inputDateStart);
        panel_filter_date.add(dateEnd);
        panel_filter_date.add(inputDateEnd);
        
        headerFilterContainInput.add(panel_filter_date);

        //panel filter best seller
        panel_filter_bestSeller = new JPanel();
        panel_filter_bestSeller.setPreferredSize(new Dimension(160, 60));
        panel_filter_bestSeller.setBackground(new Color(242, 59, 46));
        // panel_filter_bestSeller.setBorder(BorderFactory.createTitledBorder(title_filter[1]));


        LineBorder linedBorderBestSeller = new LineBorder(Color.white);
        TitledBorder titledBorderBestSeller = BorderFactory.createTitledBorder(linedBorderBestSeller, title_filter[1]);
        titledBorderBestSeller.setTitleJustification(TitledBorder.CENTER);
        panel_filter_bestSeller.setBorder(titledBorderBestSeller);

        inputBestSeller.setPreferredSize(new Dimension(100, 30));
        panel_filter_bestSeller.add(inputBestSeller);

        headerFilterContainInput.add(panel_filter_bestSeller);

        //panel filter supplier
        panel_filter_supplier = new JPanel();
        panel_filter_supplier.setPreferredSize(new Dimension(160, 60));
        panel_filter_supplier.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderSupplier = new LineBorder(Color.white);
        TitledBorder titledBorderSupplier = BorderFactory.createTitledBorder(linedBorderSupplier, title_filter[2]);
        titledBorderSupplier.setTitleJustification(TitledBorder.CENTER);
        panel_filter_supplier.setBorder(titledBorderSupplier);

        /* inputSupplier = new JTextField();
        inputSupplier.setPreferredSize(new Dimension(100, 30));
        inputSupplier.addKeyListener(this);
        panel_filter_supplier.add(inputSupplier); */

        selectSupplier.setPreferredSize(new Dimension(80, 30));
        selectSupplier.setCursor(new Cursor(Cursor.HAND_CURSOR));
        selectSupplier.addActionListener(this);
        panel_filter_supplier.add(selectSupplier);

        headerFilterContainInput.add(panel_filter_supplier);

        // header search button
        headerSearchBtn = new JButton("Tim kiem");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(242, 59, 46));
        headerSearchBtn.setPreferredSize(new Dimension(100, 0));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setBorder(BorderFactory.createEmptyBorder());
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);

        headerFilter.add(headerFilterContainInput,BorderLayout.WEST);
        headerFilter.add(headerSearchBtn,BorderLayout.EAST);
        
        // table
        bookSoldTable = new statisticTable();
        bookSoldTable.setBackground(Color.lightGray);
        bookSoldTable.setHeader(columnNames);

        // get table data
        nhanvienDAO nv=new nhanvienDAO();
        ArrayList<nhanvien> listNV = nv.selecAll();

        for (nhanvien i : listNV) {
            bookSoldTable.addRow(new Object[]{
                i.getMa(),
                i.getTen(),
                i.getChucvu(),
                i.getEmail(),
                i.getGioitinh(),
                i.getSodienthoai()
            });
        }

        bookSoldTable.setPreferredWidth(0, 50);
        bookSoldTable.setPreferredWidth(1, 200);
        bookSoldTable.setPreferredWidth(2, 150);
        bookSoldTable.setPreferredWidth(3, 200);
        bookSoldTable.setPreferredWidth(4, 150);

        bookSoldTable.setAlignment(0, JLabel.CENTER);
        bookSoldTable.setAlignment(4, JLabel.CENTER);


        // barSum
        JPanel barSum = new JPanel();
        barSum.setBackground(Color.white);
        barSum.setLayout(null);
        barSum.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        /* JLabel sumTitle = new JLabel("Tong tien nhap vao:");
        sumTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        sumTitle.setBackground(Color.green); */

       /*  JLabel sumNumber = new JLabel("2.000.000.000d");
        sumNumber.setFont(new Font("Arial", Font.PLAIN, 18));
        sumTitle.setBackground(Color.green); */

       /*  sumTitle.setBounds(50, 0, 200, 50);
        sumNumber.setBounds(900, 0, 300, 50); */

        /* barSum.add(sumTitle);
        barSum.add(sumNumber); */

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 70));
        bookSoldTable.setPreferredSize(new Dimension(0, 0));
        // barSum.setPreferredSize(new Dimension(0,50));

        add(header, BorderLayout.NORTH);
        add(bookSoldTable, BorderLayout.CENTER);
        // add(barSum, BorderLayout.SOUTH);

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
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
