package GUI.statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import BUS.PriceFormatter;
import DAO.TheLoaiDAO;
import DAO.thongKeSachDAO;
import DTO.Theloai;
import DTO.sachNhap;
import GUI.nhaphangGUI.chonnhacungcapGUI;
import GUI.Mybutton.DateButton;
import GUI.Mybutton.morebutton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class statistic_import extends JPanel implements ActionListener, KeyListener {
    private JPanel headerFilterContainInput;
    private JButton headerSearchBtn, refreshButton;
    private String title_filter[] = { "Khoảng ngày", "Top nhập hàng nhiều", "Thể loại", "Nhà cung cấp" };// menu title
                                                                                                         // filter
    private String[] columnNames = { "ID", "Tên sách", "Thể loại", "Nhà cung cấp", "Giá", "Đã nhập" };
    private JPanel panel_filter_date, panel_filter_bestSeller, panel_filter_supplier, panel_filter_category;
    private JTextField inputDateStart, inputDateEnd, inputSupplier;
    private JLabel dateStart, dateEnd;
    private SpinnerModel model = new SpinnerNumberModel(0, 0, 15, 1);
    private JSpinner inputBestSeller = new JSpinner(model);
    private statisticTable bookSoldTable;
    private morebutton selectSupplier = new morebutton();
    private JComboBox inputcategory;
    private float sumImportMoney = 0;

    private LocalDate currentDate = LocalDate.now();
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String formattedDate = currentDate.format(formatter);
    private DatePicker dp1;
    private DatePicker dp2;

    private JLabel sumNumber;
    private thongKeSachDAO bs;
    private ArrayList<sachNhap> listBS;

    public statistic_import() {
        setLayout(new BorderLayout());
        // header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.lightGray);

        // header search contain input
        headerFilterContainInput = new JPanel();
        headerFilterContainInput.setBackground(Color.lightGray);
        headerFilterContainInput.setPreferredSize(new Dimension(1080, 0));
        headerFilterContainInput.setLayout(new FlowLayout(SwingConstants.RIGHT));
        headerFilterContainInput.setFont(new Font("Arial", Font.PLAIN, 20));

        headerFilterContainInput.setBorder(BorderFactory.createEmptyBorder());

        // panel filter date
        panel_filter_date = new JPanel();
        panel_filter_date.setLayout(new FlowLayout());
        panel_filter_date.setPreferredSize(new Dimension(380, 65));
        panel_filter_date.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderDate = new LineBorder(Color.white);
        TitledBorder titledBorderDate = BorderFactory.createTitledBorder(linedBorderDate, title_filter[0]);
        titledBorderDate.setTitleJustification(TitledBorder.CENTER);

        panel_filter_date.setBorder(titledBorderDate);

        inputDateStart = new JTextField();
        inputDateStart.setHorizontalAlignment(JTextField.CENTER);
        inputDateStart.setPreferredSize(new Dimension(100, 30));
        inputDateEnd = new JTextField();
        inputDateEnd.setHorizontalAlignment(JTextField.CENTER);
        inputDateEnd.setPreferredSize(new Dimension(100, 30));
        inputDateStart.setEditable(false);
        inputDateEnd.setEditable(false);

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dp1 = new DatePicker(pickerSettings);
        dp2 = new DatePicker(pickerSettings.copySettings());
        dp1.setDateToToday();
        dp2.setDateToToday();

        new DateButton(dp1);
        new DateButton(dp2);

        dateStart = new JLabel("Từ");
        dateEnd = new JLabel("đến");
        dp1.setBackground(new Color(242, 59, 46));
        dp1.setOpaque(false);
        dp2.setBackground(new Color(242, 59, 46));
        dp2.setOpaque(false);

        dp1.addDateChangeListener((dce) -> {
            inputDateStart.setText(dp1.getDateStringOrEmptyString());
        });
        dp2.addDateChangeListener((dce) -> {
            inputDateEnd.setText(dp2.getDateStringOrEmptyString());
        });

        panel_filter_date.add(dateStart);
        panel_filter_date.add(inputDateStart);
        panel_filter_date.add(dp1);
        panel_filter_date.add(dateEnd);
        panel_filter_date.add(inputDateEnd);
        panel_filter_date.add(dp2);

        headerFilterContainInput.add(panel_filter_date);

        // panel filter best seller
        panel_filter_bestSeller = new JPanel();
        panel_filter_bestSeller.setPreferredSize(new Dimension(130, 65));
        panel_filter_bestSeller.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderBestSeller = new LineBorder(Color.white);
        TitledBorder titledBorderBestSeller = BorderFactory.createTitledBorder(linedBorderBestSeller, title_filter[1]);
        titledBorderBestSeller.setTitleJustification(TitledBorder.CENTER);
        panel_filter_bestSeller.setBorder(titledBorderBestSeller);

        inputBestSeller.setPreferredSize(new Dimension(100, 30));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) inputBestSeller.getEditor()).getTextField();
        tf.setEditable(false);
        panel_filter_bestSeller.add(inputBestSeller);

        headerFilterContainInput.add(panel_filter_bestSeller);

        // panel filter category
        panel_filter_category = new JPanel();
        panel_filter_category.setPreferredSize(new Dimension(120, 65));
        panel_filter_category.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderCategory = new LineBorder(Color.white);
        TitledBorder titledBorderCategory = BorderFactory.createTitledBorder(linedBorderCategory, title_filter[2]);
        titledBorderCategory.setTitleJustification(TitledBorder.CENTER);
        panel_filter_category.setBorder(titledBorderCategory);

        TheLoaiDAO layTheLoai = new TheLoaiDAO();
        ArrayList<Theloai> dsTheLoai = layTheLoai.selecAll();
        String category_name[] = new String[dsTheLoai.size() + 1];

        category_name[0] = "Tất cả";
        int i = 1;
        for (Theloai tl : dsTheLoai) {
            category_name[i] = tl.getTenTheloai();
            i++;
        }

        inputcategory = new JComboBox(category_name);
        inputcategory.setPreferredSize(new Dimension(100, 30));
        panel_filter_category.add(inputcategory);

        headerFilterContainInput.add(panel_filter_category);

        // panel filter supplier
        panel_filter_supplier = new JPanel();
        panel_filter_supplier.setPreferredSize(new Dimension(130, 65));
        panel_filter_supplier.setBackground(new Color(242, 59, 46));

        LineBorder linedBorderSupplier = new LineBorder(Color.white);
        TitledBorder titledBorderSupplier = BorderFactory.createTitledBorder(linedBorderSupplier, title_filter[3]);
        titledBorderSupplier.setTitleJustification(TitledBorder.CENTER);
        panel_filter_supplier.setBorder(titledBorderSupplier);

        inputSupplier = new JTextField();
        inputSupplier.setPreferredSize(new Dimension(80, 30));
        inputSupplier.addKeyListener(this);
        inputSupplier.setHorizontalAlignment(JTextField.CENTER);
        inputSupplier.setEditable(false);

        panel_filter_supplier.add(inputSupplier);

        selectSupplier.setPreferredSize(new Dimension(30, 30));
        selectSupplier.addActionListener(this);
        panel_filter_supplier.add(selectSupplier);

        headerFilterContainInput.add(panel_filter_supplier);

        // header search button
        headerSearchBtn = new JButton("Tìm");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(242, 59, 46));
        headerSearchBtn.setPreferredSize(new Dimension(100, 40));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 18));
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);

        headerSearchBtn.addActionListener((ae) -> {
            searchOnClick();
        });

        refreshButton = new JButton("Xoá NCC");
        refreshButton.setPreferredSize(new Dimension(100, 30));
        refreshButton.setFocusable(false);
        refreshButton.setFont(new Font("Arial", Font.PLAIN, 15));
        refreshButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        refreshButton.addActionListener(this);

        refreshButton.addActionListener((ae) -> {
            refresh();
        });

        headerFilterContainInput.add(refreshButton);
        headerFilterContainInput.add(headerSearchBtn);

        header.add(headerFilterContainInput, BorderLayout.WEST);

        // table
        bookSoldTable = new statisticTable();
        bookSoldTable.setTablesize(1100, 500);
        bookSoldTable.setBackground(Color.lightGray);
        bookSoldTable.setHeader(columnNames);

        // get table data
        bs = new thongKeSachDAO();
        listBS = bs.selectBookImport("2000-01-01", formattedDate, category_name[0], "", 0);

        inputDateStart.setText("2000-01-01");
        inputDateEnd.setText(formattedDate);

        for (sachNhap bSold : listBS) {
            bookSoldTable.addRow(new Object[] {
                    bSold.getBookID(),
                    bSold.getBookName(),
                    bSold.getBookCategory(),
                    bSold.getSupplierName(),
                    PriceFormatter.format(bSold.getBookPrice()),
                    bSold.getBookImportQuantity()
            });
            sumImportMoney += bSold.getBookImportQuantity() * bSold.getBookPrice();
        }

        bookSoldTable.setPreferredWidth(0, 50);
        bookSoldTable.setPreferredWidth(1, 200);
        bookSoldTable.setPreferredWidth(2, 200);
        bookSoldTable.setPreferredWidth(3, 200);
        bookSoldTable.setPreferredWidth(4, 100);

        bookSoldTable.setAlignment(0, JLabel.CENTER);
        bookSoldTable.setAlignment(2, JLabel.CENTER);
        bookSoldTable.setAlignment(4, JLabel.CENTER);
        bookSoldTable.setAlignment(5, JLabel.CENTER);

        // barSum
        JPanel barSum = new JPanel();
        barSum.setBackground(Color.white);
        barSum.setLayout(null);
        barSum.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JLabel sumTitle = new JLabel("Tổng tiền nhập vào:");
        sumTitle.setFont(new Font("Arial", Font.PLAIN, 22));
        sumTitle.setBackground(Color.green);

        sumNumber = new JLabel(PriceFormatter.format(sumImportMoney));
        sumNumber.setFont(new Font("Arial", Font.PLAIN, 24));
        sumNumber.setForeground(Color.green);

        sumTitle.setBounds(50, 0, 200, 50);
        sumNumber.setBounds(900, 0, 300, 50);

        barSum.add(sumTitle);
        barSum.add(sumNumber);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 70));
        bookSoldTable.setPreferredSize(new Dimension(0, 0));
        barSum.setPreferredSize(new Dimension(0, 50));

        add(header, BorderLayout.NORTH);
        add(bookSoldTable, BorderLayout.CENTER);
        add(barSum, BorderLayout.SOUTH);

    }

    private void setDataToTable(ArrayList<sachNhap> list, statisticTable t) {
        t.clearTable();
        sumImportMoney = 0;
        for (sachNhap bSold : list) {
            t.addRow(new Object[] {
                    bSold.getBookID(),
                    bSold.getBookName(),
                    bSold.getBookCategory(),
                    bSold.getSupplierName(),
                    PriceFormatter.format(bSold.getBookPrice()),
                    bSold.getBookImportQuantity()
            });
            sumImportMoney += bSold.getBookImportQuantity() * bSold.getBookPrice();
        }
        sumNumber.setText(PriceFormatter.format(sumImportMoney));
    }

    private void searchOnClick() {

        if ((inputDateStart.getText().equals("") || inputDateEnd.getText().isEmpty())
                || (inputDateEnd.getText().equals("") || inputDateStart.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Ngày bị thiếu!", "Thông báo", 1);
            return;
        } else if (bs.selectBookImport(inputDateStart.getText(), inputDateEnd.getText(),
                (String) inputcategory.getSelectedItem(), inputSupplier.getText(),
                (Integer) inputBestSeller.getValue()) != null) {
            setDataToTable(bs.selectBookImport(inputDateStart.getText(), inputDateEnd.getText(),
                    (String) inputcategory.getSelectedItem(), inputSupplier.getText(),
                    (Integer) inputBestSeller.getValue()), bookSoldTable);
        } else {
            JOptionPane.showMessageDialog(this, "Sai thứ tự ngày!", "Thông báo", 1);
            return;
        }
    }

    private void refresh() {
        inputSupplier.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if (e.getSource() == headerSearchBtn) {
                System.out.print("Search");
            }
            if (e.getSource() == selectSupplier) {
                System.out.print("supplier");
                new chonnhacungcapGUI(inputSupplier).addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent e) {
                        System.out.print("Closing");
                    }
                });
                this.setEnabled(false);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.remove(bookSoldTable);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
