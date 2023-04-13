package GUI.invoice;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import GUI.Mytable;
import GUI.Mybutton.DateButton;
import GUI.Mybutton.DetailButton;
import GUI.Mybutton.ExportExcelButton;
import GUI.Mybutton.ExportPDF;
//import GUI.Mybutton.ImportExcelButton;
import GUI.Mybutton.searchbutton;

public class InvoiceGUI extends JPanel {

    //action panel
    private JPanel searchPanel;
    private JTextField datefrom;
    private JTextField dateto;
    private DatePicker dp1; 
    private DatePicker dp2; 
    private JTextField searchinp;
    private searchbutton searchbtn;
    
    //invoice table
    private Mytable invoiceTable;

    //button panel
    private JPanel buttonPanel;
    private DetailButton detailbtn;
    //private ImportExcelButton importbtn;
    private ExportExcelButton exportbtn;
    private ExportPDF pdfbtn;
    
    public InvoiceGUI() {
        init();
    }
    public void init() {
        this.setPreferredSize(new Dimension(1000,700));
        this.setLayout(new BorderLayout());
        this.add(searchPanel(),BorderLayout.NORTH);
        this.add(invoiceTable(),BorderLayout.CENTER);
        this.add(buttonPanel(),BorderLayout.SOUTH);
    }

    public JPanel searchPanel() {
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(0,60));
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,5));
        
        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dp1 = new DatePicker(pickerSettings);
        dp2 = new DatePicker(pickerSettings.copySettings());
        dp1.setDateToToday();
        dp2.setDateToToday();

        new DateButton(dp1);
        new DateButton(dp2);

        datefrom = new JTextField();
        datefrom.setBorder(BorderFactory.createTitledBorder("From:"));
        datefrom.setPreferredSize(new Dimension(150,45));
        dateto = new JTextField();
        dateto.setBorder(BorderFactory.createTitledBorder("To:"));
        dateto.setPreferredSize(new Dimension(150,45));

        searchinp = new JTextField();
        searchinp.setPreferredSize(new Dimension(250,40));
        searchbtn = new searchbutton();
        searchbtn.setPreferredSize(new Dimension(100,40));

        searchPanel.add(datefrom);
        searchPanel.add(dp1);
        searchPanel.add(dateto);
        searchPanel.add(dp2);
        searchPanel.add(searchinp);
        searchPanel.add(searchbtn);

        return searchPanel;
    }

    public Mytable invoiceTable() {
        invoiceTable = new Mytable();
        invoiceTable.setTablesize(1000, 540);
        invoiceTable.setHeader(new String[]{"No","Invoice ID","Employee ID","Customer ID","Discount(%)","Date create","Total"});
        for(int i=0;i<15;i++) {
            invoiceTable.addRow(new String[]{
                String.valueOf(i+1),
                String.valueOf(i+1),
                "2",
                "3",
                "50",
                "2023-01-01",
                "110.000"
            });
        }
        invoiceTable.setPreferredWidth(0, 100);
        invoiceTable.setPreferredWidth(1, 100);
        invoiceTable.setPreferredWidth(2, 100);
        invoiceTable.setPreferredWidth(3, 100);
        invoiceTable.setPreferredWidth(4, 100);
        invoiceTable.setPreferredWidth(5, 250);
        invoiceTable.setPreferredWidth(6, 250);

        int align = JLabel.CENTER;
        invoiceTable.setAlignment(0,align);
        invoiceTable.setAlignment(1,align);
        invoiceTable.setAlignment(2,align);
        invoiceTable.setAlignment(3,align);
        invoiceTable.setAlignment(4,align);
        invoiceTable.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        return invoiceTable;
    }

    public JPanel buttonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(0,100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

        detailbtn = new DetailButton();
        exportbtn = new ExportExcelButton();
        //importbtn = new ImportExcelButton();
        pdfbtn = new ExportPDF();
        
        detailbtn.setPreferredSize(new Dimension(100,45));
        exportbtn.setPreferredSize(new Dimension(100,45));
        //importbtn.setPreferredSize(new Dimension(100,45));
        pdfbtn.setPreferredSize(new Dimension(100,45));

        buttonPanel.add(detailbtn);
        buttonPanel.add(exportbtn);
        //buttonPanel.add(importbtn);
        buttonPanel.add(pdfbtn);

        return buttonPanel;
    }

    private void tableMouseClicked(MouseEvent evt) {

    }
}
