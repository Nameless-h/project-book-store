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
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import BUS.PriceFormatter;
import DAO.TheLoaiDAO;
import DAO.thongKeSachDAO;
import DTO.SachBan;
import DTO.Theloai;
import GUI.Mybutton.DateButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;  
    
public class statistic_category extends JPanel implements ActionListener{
    private JPanel headerFilterContainInput;
    private JButton headerSearchBtn;
    private String columnNames[] = {"ID","Tên Thể loại","Doanh thu thể loại","Đã bán"};
    private String title_filter[] = {"Khoảng ngày","Top bán chạy","Thể loại"};//menu title filter
    private JPanel panel_filter_date,panel_filter_bestSeller,panel_filter_category;
    private JTextField inputDateStart,inputDateEnd;

    private JLabel dateStart,dateEnd;
    private LineBorder linedBorderDate,linedBorderBestSeller,linedBorderCategory;
    private TitledBorder titledBorderDate,titledBorderBestSeller,titledBorderCategory;
    private SpinnerModel model = new SpinnerNumberModel(0, 0, 15, 1);     
    private JSpinner inputBestSeller = new JSpinner(model);
    
    private statisticTable bookSoldTable;
    private float sumRevenue=0;
    private JComboBox inputcategory;
    private DatePicker dp1;
    private DatePicker dp2;
    private ArrayList<SachBan> listBS;
    private thongKeSachDAO bs;
    private JLabel sumNumber;

    public statistic_category() {
        setLayout(new BorderLayout());
        // header
        JPanel header = new JPanel();
        header.setLayout(new BorderLayout());
        header.setBackground(Color.lightGray); 

        // header search contain input
        headerFilterContainInput = new JPanel();
        headerFilterContainInput.setBackground(Color.lightGray);
        headerFilterContainInput.setPreferredSize(new Dimension(1000, 0));
        headerFilterContainInput.setLayout(new FlowLayout(SwingConstants.RIGHT));
        headerFilterContainInput.setFont(new Font("Arial", Font.PLAIN, 20));
        
        headerFilterContainInput.setBorder(BorderFactory.createEmptyBorder());
        
        // panel filter date
        panel_filter_date = new JPanel();
        panel_filter_date.setLayout(new FlowLayout());
        panel_filter_date.setPreferredSize(new Dimension(400, 65));
        panel_filter_date.setBackground(new Color(242, 59, 46));

        linedBorderDate = new LineBorder(Color.white);
        titledBorderDate = BorderFactory.createTitledBorder(linedBorderDate, title_filter[0]);
        titledBorderDate.setTitleJustification(TitledBorder.CENTER);
        panel_filter_date.setBorder(titledBorderDate);
        
        inputDateStart = new JTextField();
        inputDateStart.setHorizontalAlignment(JTextField.CENTER);
        inputDateStart.setPreferredSize(new Dimension(90, 30));
        inputDateEnd = new JTextField();
        inputDateEnd.setHorizontalAlignment(JTextField.CENTER);
        inputDateEnd.setPreferredSize(new Dimension(90, 30));
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

        dp1.addDateChangeListener((dce)->{
            inputDateStart.setText(dp1.getDateStringOrEmptyString());
        });
        dp2.addDateChangeListener((dce)->{
            inputDateEnd.setText(dp2.getDateStringOrEmptyString());
        });

        panel_filter_date.add(dateStart);
        panel_filter_date.add(inputDateStart);
        panel_filter_date.add(dp1);
        panel_filter_date.add(dateEnd);
        panel_filter_date.add(inputDateEnd);
        panel_filter_date.add(dp2);
        
        headerFilterContainInput.add(panel_filter_date);

        //panel filter best seller
        panel_filter_bestSeller = new JPanel();
        panel_filter_bestSeller.setPreferredSize(new Dimension(160, 65));
        panel_filter_bestSeller.setBackground(new Color(242, 59, 46));

        linedBorderBestSeller = new LineBorder(Color.white);
        titledBorderBestSeller = BorderFactory.createTitledBorder(linedBorderBestSeller, title_filter[1]);
        titledBorderBestSeller.setTitleJustification(TitledBorder.CENTER);
        panel_filter_bestSeller.setBorder(titledBorderBestSeller);

        inputBestSeller.setPreferredSize(new Dimension(100, 30));
        JFormattedTextField tf = ((JSpinner.DefaultEditor) inputBestSeller.getEditor()).getTextField();
        tf.setEditable(false);
        panel_filter_bestSeller.add(inputBestSeller);

        headerFilterContainInput.add(panel_filter_bestSeller);
    
        //panel filter category
        panel_filter_category = new JPanel();
        panel_filter_category.setPreferredSize(new Dimension(160, 65));
        panel_filter_category.setBackground(new Color(242, 59, 46));

        linedBorderCategory = new LineBorder(Color.white);
        titledBorderCategory = BorderFactory.createTitledBorder(linedBorderCategory, title_filter[2]);
        titledBorderCategory.setTitleJustification(TitledBorder.CENTER);
        panel_filter_category.setBorder(titledBorderCategory);

        TheLoaiDAO layTheLoai = new TheLoaiDAO();
        ArrayList<Theloai> dsTheLoai = layTheLoai.selecAll();
        String category_name[] = new String[dsTheLoai.size()+1];

        category_name[0] = "Tất cả";
        int i = 1;
        for (Theloai tl : dsTheLoai) {
            category_name[i] = tl.getTenTheloai();
            i++;
        }

        inputcategory = new JComboBox(category_name);
        inputcategory.setPreferredSize(new Dimension(140, 30));
        panel_filter_category.add(inputcategory);

        headerFilterContainInput.add(panel_filter_category);

        // header search button
        headerSearchBtn = new JButton("Tìm");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(242, 59, 46));
        headerSearchBtn.setPreferredSize(new Dimension(100, 40));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);

        headerSearchBtn.addActionListener((ae) -> {
            searchOnClick();
        });

        headerFilterContainInput.add(headerSearchBtn);
        header.add(headerFilterContainInput,BorderLayout.WEST);
        
        // table
        bookSoldTable = new statisticTable();
        bookSoldTable.setTablesize(1100,500);
        bookSoldTable.setBackground(Color.lightGray);
        bookSoldTable.setHeader(columnNames);
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
       
        // get table data
        bs=new thongKeSachDAO();
        listBS = bs.selectCategory("2000-01-01",formattedDate,category_name[0],0);
        
        inputDateStart.setText("2000-01-01");
        inputDateEnd.setText(formattedDate);

        for (SachBan bSold : listBS) {
            bookSoldTable.addRow(new Object[]{
                bSold.getBookID(),
                bSold.getBookCategory(),
                PriceFormatter.format(bSold.getBookPrice()),
                bSold.getBookSoldQuantity()
            });
            sumRevenue += bSold.getBookPrice();
        }

        bookSoldTable.setPreferredWidth(0, 50);
        bookSoldTable.setPreferredWidth(1, 300);
        bookSoldTable.setPreferredWidth(2, 200);
        bookSoldTable.setPreferredWidth(3, 200);

        bookSoldTable.setAlignment(0, JLabel.CENTER);
        bookSoldTable.setAlignment(2, JLabel.CENTER);
        bookSoldTable.setAlignment(3, JLabel.CENTER);

        // barSum
        JPanel barSum = new JPanel();
        barSum.setBackground(Color.white);
        barSum.setLayout(null);
        barSum.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JLabel sumTitle = new JLabel("Tổng tiền bán ra:");
        sumTitle.setFont(new Font("Arial", Font.PLAIN, 22));
        sumTitle.setBackground(Color.green);

        sumNumber = new JLabel(PriceFormatter.format(sumRevenue));
        sumNumber.setFont(new Font("Arial", Font.PLAIN, 24));
        sumNumber.setForeground(Color.green);

        sumTitle.setBounds(50, 0, 200, 50);
        sumNumber.setBounds(900, 0, 300, 50);

        barSum.add(sumTitle);
        barSum.add(sumNumber);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 70));
        bookSoldTable.setPreferredSize(new Dimension(0, 0));
        barSum.setPreferredSize(new Dimension(1000, 50));

        add(header, BorderLayout.NORTH);
        add(bookSoldTable, BorderLayout.CENTER);
        add(barSum, BorderLayout.SOUTH);

    }

    private void setDataToTable(ArrayList<SachBan> list,statisticTable t) {
        t.clearTable();
        sumRevenue = 0;
        for (SachBan bSold : list) {
            t.addRow(new Object[]{
                bSold.getBookID(),
                bSold.getBookCategory(),
                PriceFormatter.format(bSold.getBookPrice()),
                bSold.getBookSoldQuantity()
            });
            sumRevenue += bSold.getBookPrice();
        }
        sumNumber.setText(PriceFormatter.format(sumRevenue));
    }

    private void searchOnClick() {
        if((inputDateStart.getText().equals("") || inputDateEnd.getText().isEmpty()) || (inputDateEnd.getText().equals("") || inputDateStart.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this,"Ngày bị thiếu!","Thông báo",1);
            return;
        } else if(bs.selectCategory(inputDateStart.getText(),inputDateEnd.getText(),(String) inputcategory.getSelectedItem(),(Integer) inputBestSeller.getValue()) != null) {
            setDataToTable(bs.selectCategory(inputDateStart.getText(),inputDateEnd.getText(),(String) inputcategory.getSelectedItem(),(Integer) inputBestSeller.getValue()), bookSoldTable);
        } else {
            JOptionPane.showMessageDialog(this,"Sai thứ tự ngày!","Thông báo",1);
            return;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if(e.getSource() == headerSearchBtn) {
                System.out.print("Search");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }    
    }
}
