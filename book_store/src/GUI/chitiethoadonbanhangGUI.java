package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import BUS.PriceFormatter;
import BUS.SanPhamBUS;
import BUS.quanlichitiethoadonbanhang;
import BUS.quanlihoadonbanhang;
import BUS.quanlikhachhang;
import BUS.quanlinhanvien;
import DTO.Sach;
import DTO.chitiethoadon;
import DTO.hoadonbanhang;
import DTO.khachhang;
import DTO.nhanvien;

public class chitiethoadonbanhangGUI extends JFrame {
    private int mahd;

    // information panel
    private JPanel infopnl;
    private JTextField mahdtxt;
    private JTextField manvtxt;
    private JTextField tennvtxt;
    private JTextField makhtx;
    private JTextField tenkhtxt;
    private JTextField ngaytxt;
    private JTextField tongtientxt;
    private JTextField giamgiatxt;
    private JTextField thanhtientxt;

    // books table
    private Mytable booktable;

    //others
    private quanlihoadonbanhang qlhdbh = new quanlihoadonbanhang();
    private quanlichitiethoadonbanhang qlcthdbh = new quanlichitiethoadonbanhang();
    private quanlikhachhang qlkh = new quanlikhachhang();
    private quanlinhanvien qlnv = new quanlinhanvien();
    private SanPhamBUS spbus = new SanPhamBUS();
    
    public chitiethoadonbanhangGUI(int _mahd) {
        this.mahd = _mahd;
        this.setTitle("Chi tiết hóa đơn "+this.mahd);
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
        mahdtxt = new JTextField();
        manvtxt = new JTextField();
        tennvtxt = new JTextField();
        makhtx = new JTextField();
        tenkhtxt = new JTextField();
        ngaytxt = new JTextField();
        tongtientxt = new JTextField();
        giamgiatxt = new JTextField();
        thanhtientxt = new JTextField();

        mahdtxt.setBorder(BorderFactory.createTitledBorder("Mã hóa đơn"));
        manvtxt.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        tennvtxt.setBorder(BorderFactory.createTitledBorder("Tên nhân viên"));
        makhtx.setBorder(BorderFactory.createTitledBorder("Mã khách hàng"));
        tenkhtxt.setBorder(BorderFactory.createTitledBorder("Tên khách hàng"));
        ngaytxt.setBorder(BorderFactory.createTitledBorder("Ngày tạo"));
        tongtientxt.setBorder(BorderFactory.createTitledBorder("Tổng tiền"));
        giamgiatxt.setBorder(BorderFactory.createTitledBorder("Giảm giá (%)"));
        thanhtientxt.setBorder(BorderFactory.createTitledBorder("Thành tiền"));

        int w = 250 , h = 50;
        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        infopnl.setBackground(Color.WHITE);
        infopnl.setPreferredSize(new Dimension(0,200));
        mahdtxt.setPreferredSize(new Dimension(w, h));
        manvtxt.setPreferredSize(new Dimension(w, h));
        tennvtxt.setPreferredSize(new Dimension(w, h));
        makhtx.setPreferredSize(new Dimension(w, h));
        tenkhtxt.setPreferredSize(new Dimension(w, h));
        ngaytxt.setPreferredSize(new Dimension(w, h));
        tongtientxt.setPreferredSize(new Dimension(w, h));
        giamgiatxt.setPreferredSize(new Dimension(w, h));
        thanhtientxt.setPreferredSize(new Dimension(w, h));

        mahdtxt.setFont(f);
        manvtxt.setFont(f);
        tennvtxt.setFont(f);
        makhtx.setFont(f);
        tenkhtxt.setFont(f);
        ngaytxt.setFont(f);
        tongtientxt.setFont(f);
        giamgiatxt.setFont(f);
        thanhtientxt.setFont(f);

        mahdtxt.setEditable(false);
        manvtxt.setEditable(false);
        tennvtxt.setEditable(false);
        makhtx.setEditable(false);
        tenkhtxt.setEditable(false);
        ngaytxt.setEditable(false);
        tongtientxt.setEditable(false);
        giamgiatxt.setEditable(false);
        thanhtientxt.setEditable(false);
        
        settext();

        infopnl.add(mahdtxt);
        infopnl.add(manvtxt);
        infopnl.add(tongtientxt);
        infopnl.add(makhtx);
        infopnl.add(tennvtxt);
        infopnl.add(giamgiatxt);
        infopnl.add(tenkhtxt);
        infopnl.add(ngaytxt);
        infopnl.add(thanhtientxt);

        return infopnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 400);
        booktable.setHeader(new String[]{"STT","Mã sách","Tên sách","Số lượng","Đơn giá","Thành tiền"});
        qlcthdbh.initList();
        setDataToTable(qlcthdbh.getList(), booktable);
        booktable.setPreferredWidth(0,50);
        booktable.setPreferredWidth(1,100);
        booktable.setPreferredWidth(2,300);
        booktable.setPreferredWidth(3,100);
        booktable.setPreferredWidth(4,250);
        booktable.setPreferredWidth(5,250);

        int align = JLabel.CENTER;
        booktable.setAlignment(0, align);
        booktable.setAlignment(1, align);
        booktable.setAlignment(3, align);
        return booktable;
    }
    public static void main(String[] args) {
        FlatLightLaf.setup();
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            // TODO: handle exception
        }
        new chitiethoadonbanhangGUI(1);
    }

    private void setDataToTable(ArrayList<chitiethoadon> list , Mytable t) {
        t.clear();
        int i=1;
        Sach s;
        spbus.listSanPham();
        for(chitiethoadon cthd : list) {
            if(cthd.getmahd() == this.mahd) {
                s = spbus.getBook(cthd.getmasach());
                t.addRow(new Object[] {
                    String.valueOf(i++),
                    String.valueOf(cthd.getmasach()),
                    s.getTenSach(),
                    String.valueOf(cthd.getsoluong()),
                    PriceFormatter.format(cthd.getdongia()), 
                    PriceFormatter.format(cthd.getsoluong()*cthd.getdongia())
                });
            }
        }
    }

    private void settext() {
        qlhdbh.initList();
        khachhang kh;
        nhanvien nv ;
        double tongtien,giamgia,thanhtien;
        for(hoadonbanhang hd : qlhdbh.getList()) {
            if(hd.getmahd() == this.mahd) {
                kh = qlkh.getKhachHang(hd.getMakh());
                nv = qlnv.getNhanVien(hd.getmanv());
                tongtien = hd.getTongtien();
                giamgia = (double)hd.getGiamgia();
                thanhtien = tongtien - tongtien * (Math.ceil(giamgia) / 100);
                mahdtxt.setText(String.valueOf(this.mahd) );
                manvtxt.setText(String.valueOf(nv.getMa()));
                tennvtxt.setText(nv.getTen());
                makhtx.setText(String.valueOf(kh.getMa()));
                tenkhtxt.setText(kh.getTen());
                ngaytxt.setText(hd.getngay());
                tongtientxt.setText(PriceFormatter.format(hd.getTongtien()));
                giamgiatxt.setText(String.valueOf(hd.getGiamgia()));
                thanhtientxt.setText(PriceFormatter.format(thanhtien)); 
                break;
            }
        }
    }
}
