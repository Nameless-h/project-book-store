package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import BUS.PriceFormatter;
import BUS.SanPhamBUS;
import BUS.quanlichitiethoadonbanhang;
import BUS.quanlihoadonbanhang;
import BUS.quanlinhanvien;
import DAO.khachhangDAO;
import DAO.nhanvienDAO;
import DAO.quanlihoadonbanhangDAO;
import DTO.Sach;
import DTO.chitiethoadon;
import DTO.hoadonbanhang;
import DTO.khachhang;
import DTO.nhanvien;
import GUI.Mybutton.DateButton;

public class hienThiThongKeKH extends JFrame {
    private int makh;

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

    private DatePicker dp1;
    private DatePicker dp2;

    //  array
    private quanlichitiethoadonbanhang qlcthdbh = new quanlichitiethoadonbanhang();
    private quanlihoadonbanhangDAO qlhdbh = new quanlihoadonbanhangDAO(); 
    private quanlinhanvien qlnv = new quanlinhanvien();
    private SanPhamBUS spbus = new SanPhamBUS();


    public hienThiThongKeKH(int makh) {
        this.makh = makh;
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
        
        

        manvtxt.setBorder(BorderFactory.createTitledBorder("Mã khách hàng"));
        tennvtxt.setBorder(BorderFactory.createTitledBorder("Tên khách hàng"));
        sdttxt.setBorder(BorderFactory.createTitledBorder("Số điện thoại"));
        emailtxt.setBorder(BorderFactory.createTitledBorder("Email"));
        chucvutxt.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));
        doanhthuNVtxt.setBorder(BorderFactory.createTitledBorder("Doanh thu khách hàng"));
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

        manvtxt.setFont(f);
        tennvtxt.setFont(f);
        sdttxt.setFont(f);
        emailtxt.setFont(f);
        chucvutxt.setFont(f);
        doanhthuNVtxt.setFont(f);
        panel_filter_date.setFont(f);

        manvtxt.setEditable(false);
        tennvtxt.setEditable(false);
        sdttxt.setEditable(false);
        emailtxt.setEditable(false);
        chucvutxt.setEditable(false);
        doanhthuNVtxt.setEditable(false);
        
        settext();

        infopnl.add(manvtxt);
        infopnl.add(tennvtxt);
        infopnl.add(sdttxt);
        infopnl.add(emailtxt);
        infopnl.add(chucvutxt);
        infopnl.add(doanhthuNVtxt);
        infopnl.add(panel_filter_date);

        return infopnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 400);
        booktable.setHeader(new String[]{"Mã HD","Mã sách","Tên sách","Số lượng","Đơn giá","Thành tiền"});
        qlcthdbh.initList();
        setDataToTable(qlcthdbh.getList(), booktable);
        booktable.setPreferredWidth(0,100);
        booktable.setPreferredWidth(1,100);
        booktable.setPreferredWidth(2,300);
        booktable.setPreferredWidth(3,100);
        booktable.setPreferredWidth(4,200);
        booktable.setPreferredWidth(5,250);

        int align = JLabel.CENTER;
        booktable.setAlignment(0, align);
        booktable.setAlignment(1, align);
        booktable.setAlignment(3, align);
        booktable.setAlignment(4, align);
        booktable.setAlignment(5, align);

        return booktable;
    }

    private void setDataToTable(ArrayList<chitiethoadon> list , Mytable t) {
        t.clear();
        int i=1;
        Sach s;
        spbus.listSanPham();
        System.out.println("Mang");
        for (hoadonbanhang hd : qlhdbh.list()) {
            if(hd.getMakh() == this.makh) {
                for(chitiethoadon cthd : list) {
                    if(cthd.getmahd() == 1) {
                        s = spbus.getBook(cthd.getmasach());
                        t.addRow(new Object[] {
                            String.valueOf(hd.getmahd()),
                            String.valueOf(cthd.getmasach()),
                            s.getTenSach(),
                            String.valueOf(cthd.getsoluong()),
                            PriceFormatter.format(cthd.getdongia()), 
                            PriceFormatter.format(cthd.getsoluong()*cthd.getdongia())
                        });
                    }
                }
            }
        }
        
    }

    private void settext() {
        khachhangDAO kh=new khachhangDAO();
        ArrayList<khachhang> listkh=kh.selecAll();   
        // double tongtien,giamgia,thanhtien;
        for(khachhang i : listkh) {
            if(i.getMa() == this.makh) {
               /*  kh = qlkh.getKhachHang(hd.getMakh());
                nv = qlnv.getNhanVien(hd.getmanv());
                tongtien = hd.getTongtien();
                giamgia = (double)hd.getGiamgia();
                thanhtien = tongtien - tongtien * (Math.ceil(giamgia) / 100); */


                manvtxt.setText(String.valueOf(this.makh) );
                tennvtxt.setText(String.valueOf(i.getTen()));
                sdttxt.setText(i.getSodienthoai());
                emailtxt.setText(String.valueOf(i.getEmail()));
                chucvutxt.setText(i.getDiachi());
                doanhthuNVtxt.setText("");

                /* tongtientxt.setText(PriceFormatter.format(hd.getTongtien()));
                giamgiatxt.setText(String.valueOf(hd.getGiamgia()));
                thanhtientxt.setText(PriceFormatter.format(thanhtien));  */
                break;
            }
        }
    }
}

