package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.awt.Cursor;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import BUS.PriceFormatter;
import BUS.SanPhamBUS;
import BUS.quanlichitiethoadonbanhang;
import BUS.quanlihoadonbanhang;
import BUS.quanlinhanvien;
import DAO.nhanvienDAO;
import DAO.quanlihoadonbanhangDAO;
import DAO.thongKeSachDAO;
import DTO.Sach;
import DTO.SachBan;
import DTO.chitiethoadon;
import DTO.hoadonbanhang;
import DTO.nhanvien;
import GUI.Mybutton.DateButton;

public class hienThiThongKeNV extends JFrame implements ActionListener{
    private int manv;

    // books table
    private Mytable booktable;
    
    // information panel
    private JPanel infopnl;
    private JPanel panel_filter_date;
    private JTextField manvtxt;
    private JTextField tennvtxt;    
    private JTextField sdttxt;
    private JTextField emailtxt;
    private JTextField chucvutxt;
    private JTextField doanhthuNVtxt;
    private JTextField inputDateStart,inputDateEnd;
    private JLabel dateStart,dateEnd;
    private JButton headerSearchBtn;

    private DatePicker dp1;
    private DatePicker dp2;

    //  array
    private quanlichitiethoadonbanhang qlcthdbh = new quanlichitiethoadonbanhang();
    private quanlihoadonbanhangDAO qlhdbh = new quanlihoadonbanhangDAO(); 
    private quanlinhanvien qlnv = new quanlinhanvien();
    private SanPhamBUS spbus = new SanPhamBUS();
    private thongKeSachDAO sach;
    private ArrayList<SachBan> listBS;
    private int sumRevenue = 0;

    public hienThiThongKeNV(int maNV) {
        this.manv = maNV;
        this.setTitle("Chi tiết thống kê");
        this.setLayout(new BorderLayout());
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        init();
        this.setVisible(true);
    }
    
    public void init() {        
        this.add(infoPanel(),BorderLayout.NORTH);
        this.add(bookTable(),BorderLayout.CENTER);

    }

    public JPanel infoPanel() {
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        infopnl = new JPanel();
        panel_filter_date = new JPanel();
        manvtxt = new JTextField();
        tennvtxt = new JTextField();
        sdttxt = new JTextField();
        emailtxt = new JTextField();
        chucvutxt = new JTextField();
        doanhthuNVtxt = new JTextField();
        headerSearchBtn = new JButton("Tìm");
        
        

        manvtxt.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        tennvtxt.setBorder(BorderFactory.createTitledBorder("Tên nhân viên"));
        sdttxt.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        emailtxt.setBorder(BorderFactory.createTitledBorder("Email"));
        chucvutxt.setBorder(BorderFactory.createTitledBorder("Chức vụ"));
        doanhthuNVtxt.setBorder(BorderFactory.createTitledBorder("Doanh thu nhân viên"));
        panel_filter_date.setBorder(BorderFactory.createTitledBorder("Khoảng ngày"));

        int w = 250 , h = 50;
        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        infopnl.setBackground(Color.WHITE);
        infopnl.setPreferredSize(new Dimension(0,200));

        panel_filter_date.setLayout(new FlowLayout());
        panel_filter_date.setPreferredSize(new Dimension(400, 60));
        // panel_filter_date.setBackground(new Color(242, 59, 46));

        inputDateStart = new JTextField();
        inputDateStart.setPreferredSize(new Dimension(100, 30));
        inputDateEnd = new JTextField();
        inputDateEnd.setPreferredSize(new Dimension(100, 30));

        dateStart = new JLabel("Từ");
        dateEnd = new JLabel("đến");
        dateStart.setFont(f);
        dateEnd.setFont(f);
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


        manvtxt.setPreferredSize(new Dimension(w, h));
        tennvtxt.setPreferredSize(new Dimension(w, h));
        sdttxt.setPreferredSize(new Dimension(w, h));
        emailtxt.setPreferredSize(new Dimension(w, h));
        chucvutxt.setPreferredSize(new Dimension(w, h));
        doanhthuNVtxt.setPreferredSize(new Dimension(w, h));
        headerSearchBtn.setPreferredSize(new Dimension(100, 40));

        manvtxt.setFont(f);
        tennvtxt.setFont(f);
        sdttxt.setFont(f);
        emailtxt.setFont(f);
        chucvutxt.setFont(f);
        doanhthuNVtxt.setFont(f);
        panel_filter_date.setFont(f);
        headerSearchBtn.setFont(f);

        manvtxt.setEditable(false);
        tennvtxt.setEditable(false);
        sdttxt.setEditable(false);
        emailtxt.setEditable(false);
        chucvutxt.setEditable(false);
        doanhthuNVtxt.setEditable(false);
        
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(242, 59, 46));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);

        headerSearchBtn.addActionListener((ae) -> {
            searchOnClick();
        });

        settext();

        infopnl.add(manvtxt);
        infopnl.add(tennvtxt);
        infopnl.add(sdttxt);
        infopnl.add(emailtxt);
        infopnl.add(chucvutxt);
        infopnl.add(doanhthuNVtxt);
        infopnl.add(panel_filter_date);
        infopnl.add(headerSearchBtn);

        return infopnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 400);
        booktable.setHeader(new String[]{"STT","Tên sách","Số lượng","Đơn giá","Thành tiền"});
        
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        
        sach = new thongKeSachDAO();
        listBS = sach.chiTietThongKeNV("2000-01-01",formattedDate,this.manv);
        
        inputDateStart.setText("2000-01-01");
        inputDateEnd.setText(formattedDate);

        setDataToTable(listBS, booktable);
        booktable.setPreferredWidth(0,100);
        booktable.setPreferredWidth(1,300);
        booktable.setPreferredWidth(2,100);
        booktable.setPreferredWidth(3,200);
        booktable.setPreferredWidth(4,250);

        int align = JLabel.CENTER;
        booktable.setAlignment(0, align);
        booktable.setAlignment(2, align);
        booktable.setAlignment(3, align);
        booktable.setAlignment(4, align);

        return booktable;
    }

    private void setDataToTable(ArrayList<SachBan> list , Mytable t) {
        t.clear();
        int i = 1;
        sumRevenue=0;
        System.out.println(list);
        for (SachBan s : list) {
            if (s.getBookID() == this.manv){
                t.addRow(new Object[]{
                    i,
                    s.getBookName(),
                    s.getBookCategory(),
                    s.getBookPrice(),
                    PriceFormatter.format(s.getBookSoldQuantity())
                });
                sumRevenue += s.getBookSoldQuantity();
                i++;
            }
        }
        doanhthuNVtxt.setText(PriceFormatter.format(sumRevenue));
        
    }

    private void searchOnClick() {
        if((inputDateStart.getText().equals("") || inputDateEnd.getText().isEmpty()) || (inputDateEnd.getText().equals("") || inputDateStart.getText().isEmpty())) {
            JOptionPane.showMessageDialog(this,"Ngày bị thiếu!","Thông báo",1);
            return;
        } else if(sach.chiTietThongKeNV(inputDateStart.getText(),inputDateEnd.getText(),this.manv) != null) {
            setDataToTable(sach.chiTietThongKeNV(inputDateStart.getText(),inputDateEnd.getText(),this.manv), booktable);
        } else {
            JOptionPane.showMessageDialog(this,"Sai thứ tự ngày!","Thông báo",1);
            return;
        }
    }

    private void settext() {
        nhanvienDAO nv=new nhanvienDAO();
        ArrayList<nhanvien> listNV=nv.selecAll();   
        // double tongtien,giamgia,thanhtien;
        for(nhanvien NV : listNV) {
            if(NV.getMa() == this.manv) {
               /*  kh = qlkh.getKhachHang(hd.getMakh());
                nv = qlnv.getNhanVien(hd.getmanv());
                tongtien = hd.getTongtien();
                giamgia = (double)hd.getGiamgia();
                thanhtien = tongtien - tongtien * (Math.ceil(giamgia) / 100); */

                System.out.println(NV.toString());

                manvtxt.setText(String.valueOf(this.manv) );
                tennvtxt.setText(String.valueOf(NV.getTen()));
                sdttxt.setText(NV.getSodienthoai());
                emailtxt.setText(String.valueOf(NV.getEmail()));
                chucvutxt.setText(NV.getChucvu());
                doanhthuNVtxt.setText("");

                /* tongtientxt.setText(PriceFormatter.format(hd.getTongtien()));
                giamgiatxt.setText(String.valueOf(hd.getGiamgia()));
                thanhtientxt.setText(PriceFormatter.format(thanhtien));  */
                break;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
