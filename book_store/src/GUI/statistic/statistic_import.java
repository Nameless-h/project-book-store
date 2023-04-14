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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class statistic_import extends JPanel implements ActionListener{
    private JPanel headerFilterContainInput;
    private JButton headerSearchBtn;
    private String title_filter[] = {"Khoang ngay","Top nhap nhieu"};//menu title filter
    private JPanel panel_filter_date,panel_filter_bestSeller;
    private JTextField inputDateStart,inputDateEnd;
    private JLabel dateStart,dateEnd;
    private SpinnerModel model = new SpinnerNumberModel(0, 0, 15, 1);     
    private JSpinner inputBestSeller = new JSpinner(model);
    public statistic_import() {
        setLayout(new BorderLayout());
        // header
        JPanel header = new JPanel();
        header.setBackground(Color.red);
        header.setLayout(new BorderLayout());

        // header search
        JPanel headerFilter = new JPanel();
        headerFilter.setPreferredSize(new Dimension(600, 40));
        headerFilter.setLayout(new BorderLayout());
        headerFilter.setFocusable( true );
        header.add(headerFilter);

        // header search contain input
        headerFilterContainInput = new JPanel();
        headerFilterContainInput.setLayout(new FlowLayout(SwingConstants.RIGHT));
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
        
        // list
        JPanel listSold = new statisticTable();
        listSold.setBackground(Color.white);

        // barSum
        JPanel barSum = new JPanel();
        barSum.setBackground(Color.white);
        barSum.setLayout(null);
        barSum.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JLabel sumTitle = new JLabel("Tong tien nhap vao:");
        sumTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        sumTitle.setBackground(Color.green);

        JLabel sumNumber = new JLabel("2.000.000.000d");
        sumNumber.setFont(new Font("Arial", Font.PLAIN, 18));
        sumTitle.setBackground(Color.green);

        sumTitle.setBounds(50, 0, 200, 50);
        sumNumber.setBounds(900, 0, 300, 50);

        barSum.add(sumTitle);
        barSum.add(sumNumber);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 70));
        listSold.setPreferredSize(new Dimension(0, 0));
        barSum.setPreferredSize(new Dimension(0,50));

        add(header, BorderLayout.NORTH);
        add(listSold, BorderLayout.CENTER);
        add(barSum, BorderLayout.SOUTH);

    }

    /* public void inputSearchFocus(JTextField input) {
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Nhap de tim kiem...")) {
                    input.setText("");
                }           
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty() || input.getText() == "") {
                    input.setText("Nhap de tim kiem...");
                }
            }
        });
    } */

    /* public void hoverBtn(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.darkGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.black);
            }
        });
    } */

    public static void main(String[] args) {
        new statistic_sale();
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
