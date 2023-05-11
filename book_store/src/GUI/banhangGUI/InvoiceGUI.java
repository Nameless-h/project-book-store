package GUI.banhangGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import BUS.PriceFormatter;
import BUS.quanlihoadonbanhang;
import BUS.quanlikhachhang;
import BUS.quanlinhanvien;
import DTO.hoadonbanhang;
import DTO.khachhang;
import DTO.nhanvien;
import GUI.Mytable;
import GUI.Mybutton.DateButton;
import GUI.Mybutton.DetailButton;
import GUI.Mybutton.ExportExcelButton;
import GUI.Mybutton.ExportPDF;
import GUI.Mybutton.searchbutton;
import support.WritePDF;

public class InvoiceGUI extends JPanel implements ActionListener {

    // action panel
    private JPanel searchPanel;
    private JTextField datefrom;
    private JTextField dateto;
    private DatePicker dp1;
    private DatePicker dp2;
    private JTextField searchinp;
    private searchbutton searchbtn;

    // invoice table
    private Mytable invoiceTable;

    // button panel
    private JPanel buttonPanel;
    private DetailButton detailbtn;
    private ExportExcelButton exportbtn;
    private ExportPDF pdfbtn;

    // action
    private quanlihoadonbanhang qlhdbh = new quanlihoadonbanhang();
    private quanlinhanvien qlnv = new quanlinhanvien();
    private quanlikhachhang qlkh = new quanlikhachhang();

    public InvoiceGUI() {
        init();
    }

    public void init() {
        this.setPreferredSize(new Dimension(1000, 700));
        this.setLayout(new BorderLayout());
        this.add(searchPanel(), BorderLayout.NORTH);
        this.add(invoiceTable(), BorderLayout.CENTER);
        this.add(buttonPanel(), BorderLayout.SOUTH);
    }

    public JPanel searchPanel() {
        searchPanel = new JPanel();
        searchPanel.setPreferredSize(new Dimension(0, 60));
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

        DatePickerSettings pickerSettings = new DatePickerSettings();
        pickerSettings.setVisibleDateTextField(false);
        dp1 = new DatePicker(pickerSettings);
        dp2 = new DatePicker(pickerSettings.copySettings());
        dp1.setDateToToday();
        dp2.setDateToToday();

        new DateButton(dp1);
        new DateButton(dp2);

        datefrom = new JTextField();
        datefrom.setBorder(BorderFactory.createTitledBorder("Từ:"));
        datefrom.setPreferredSize(new Dimension(150, 45));
        dateto = new JTextField();
        dateto.setBorder(BorderFactory.createTitledBorder("Đến:"));
        dateto.setPreferredSize(new Dimension(150, 45));
        datefrom.setEditable(false);
        dateto.setEditable(false);

        searchinp = new JTextField();
        searchinp.setPreferredSize(new Dimension(250, 40));
        searchbtn = new searchbutton();
        searchbtn.setPreferredSize(new Dimension(100, 40));

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

        dp1.addDateChangeListener((dce) -> {
            datefrom.setText(dp1.getDateStringOrEmptyString());
        });
        dp2.addDateChangeListener((dce) -> {
            dateto.setText(dp2.getDateStringOrEmptyString());
        });

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
        invoiceTable.setHeader(
                new String[] { "STT", "Mã HĐ", "Mã KH", "Tên khách hàng", "Tên nhân viên", "Ngày tạo", "Thành tiền" });
        qlhdbh.initList();
        setDataToTable(qlhdbh.getList(), invoiceTable);
        invoiceTable.setPreferredWidth(0, 50);
        invoiceTable.setPreferredWidth(1, 50);
        invoiceTable.setPreferredWidth(2, 50);
        invoiceTable.setPreferredWidth(3, 250);
        invoiceTable.setPreferredWidth(4, 250);
        invoiceTable.setPreferredWidth(5, 150);
        invoiceTable.setPreferredWidth(6, 200);

        int align = JLabel.CENTER;
        invoiceTable.setAlignment(0, align);
        invoiceTable.setAlignment(1, align);
        invoiceTable.setAlignment(2, align);
        invoiceTable.setAlignment(5, align);
        invoiceTable.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        return invoiceTable;
    }

    public JPanel buttonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(0, 100));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        detailbtn = new DetailButton();
        exportbtn = new ExportExcelButton();
        pdfbtn = new ExportPDF();

        detailbtn.setPreferredSize(new Dimension(100, 45));
        exportbtn.setPreferredSize(new Dimension(100, 45));
        pdfbtn.setPreferredSize(new Dimension(100, 45));

        detailbtn.addActionListener(this);
        exportbtn.addActionListener(this);
        pdfbtn.addActionListener(this);

        buttonPanel.add(detailbtn);
        buttonPanel.add(exportbtn);
        buttonPanel.add(pdfbtn);

        return buttonPanel;
    }

    // action
    private void setDataToTable(ArrayList<hoadonbanhang> list, Mytable t) {
        t.clear();
        int i = 1;
        khachhang kh;
        nhanvien nv;
        double tongtien, giamgia, thanhtien;
        for (hoadonbanhang hdbh : list) {
            kh = qlkh.getKhachHang(hdbh.getMakh());
            nv = qlnv.getNhanVien(hdbh.getmanv());
            tongtien = hdbh.getTongtien();
            giamgia = (double) hdbh.getGiamgia();
            thanhtien = Math.ceil((tongtien - tongtien * (Math.ceil(giamgia) / 100)) / 1000) * 1000;
            t.addRow(new String[] {
                    String.valueOf(i++),
                    String.valueOf(hdbh.getmahd()),
                    String.valueOf(hdbh.getMakh()),
                    kh.getTen(),
                    nv.getTen(),
                    hdbh.getngay(),
                    PriceFormatter.format(thanhtien)
            });
        }
    }

    private void searchOnchange() {
        if ((datefrom.getText().equals("") && !dateto.getText().isEmpty())
                || (dateto.getText().equals("") && !datefrom.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this, "Ngày bị thiếu!", "Thông báo", 1);
            return;
        } else if (qlhdbh.searchHoadonbanhang(searchinp.getText(), datefrom.getText(), dateto.getText()) != null) {
            setDataToTable(qlhdbh.searchHoadonbanhang(searchinp.getText(), datefrom.getText(), dateto.getText()),
                    invoiceTable);
        } else {
            JOptionPane.showMessageDialog(this, "Sai thứ tự ngày!", "Thông báo", 1);
            return;
        }
    }

    private void tableMouseClicked(MouseEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == detailbtn) {
            int row = invoiceTable.getTable().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để xem chi tiết !", "Thông báo", 1);
                return;
            } else {
                int mahd = Integer.parseInt((String) invoiceTable.getTable().getValueAt(row, 1));
                new chitiethoadonbanhangGUI(mahd);
            }
        } else if (e.getSource() == exportbtn) {
            qlhdbh.xuatExcel();
        } else if (e.getSource() == pdfbtn) {
            int row = invoiceTable.getTable().getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn để in !", "Thông báo", 1);
                return;
            } else {
                int mahd = Integer.parseInt((String) invoiceTable.getTable().getValueAt(row, 1));
                new WritePDF().writeHoaDonBanHang(mahd);
            }
        }
    }

}
