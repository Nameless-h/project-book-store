package GUI.nhaphangGUI;

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

import BUS.PriceFormatter;
import BUS.SanPhamBUS;
import BUS.quanlichitiethoadonnhaphang;
import BUS.quanlihoadonnhaphang;
import BUS.quanlinhacungcap;
import BUS.quanlinhanvien;
import DTO.Sach;
import DTO.chitiethoadon;
import DTO.hoadonnhaphang;
import DTO.nhacungcap;
import DTO.nhanvien;
import GUI.Mytable;

public class chitiethoadonnhaphangGUI extends JFrame {
    private int mahd;

    // information panel
    private JPanel infopnl;
    private JTextField mahdtxt;
    private JTextField manvtxt;
    private JTextField tennvtxt;
    private JTextField mancctx;
    private JTextField tenncctxt;
    private JTextField ngaytxt;
    private JTextField thanhtientxt;

    // books table
    private Mytable booktable;

    //others
    private quanlihoadonnhaphang qlhdnh = new quanlihoadonnhaphang();
    private quanlichitiethoadonnhaphang qlcthdnh = new quanlichitiethoadonnhaphang();
    private quanlinhacungcap qlncc = new quanlinhacungcap();
    private quanlinhanvien qlnv = new quanlinhanvien();
    private SanPhamBUS spbus = new SanPhamBUS();
    
    public chitiethoadonnhaphangGUI(int _mahd) {
        this.mahd = _mahd;
        this.setTitle("Chi tiết phiếu nhập "+this.mahd);
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
        mancctx = new JTextField();
        tenncctxt = new JTextField();
        ngaytxt = new JTextField();
        thanhtientxt = new JTextField();

        mahdtxt.setBorder(BorderFactory.createTitledBorder("Mã phiếu nhập"));
        manvtxt.setBorder(BorderFactory.createTitledBorder("Mã nhân viên"));
        tennvtxt.setBorder(BorderFactory.createTitledBorder("Tên nhân viên"));
        mancctx.setBorder(BorderFactory.createTitledBorder("Mã nhà cung cấp"));
        tenncctxt.setBorder(BorderFactory.createTitledBorder("Tên nhà cung cấp"));
        ngaytxt.setBorder(BorderFactory.createTitledBorder("Ngày tạo"));
        thanhtientxt.setBorder(BorderFactory.createTitledBorder("Thành tiền"));

        int w = 250 , h = 50;
        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        infopnl.setBackground(Color.WHITE);
        infopnl.setPreferredSize(new Dimension(0,200));
        mahdtxt.setPreferredSize(new Dimension(w, h));
        manvtxt.setPreferredSize(new Dimension(w, h));
        tennvtxt.setPreferredSize(new Dimension(w, h));
        mancctx.setPreferredSize(new Dimension(w, h));
        tenncctxt.setPreferredSize(new Dimension(w, h));
        ngaytxt.setPreferredSize(new Dimension(w, h));
        thanhtientxt.setPreferredSize(new Dimension(w, h));

        mahdtxt.setFont(f);
        manvtxt.setFont(f);
        tennvtxt.setFont(f);
        mancctx.setFont(f);
        tenncctxt.setFont(f);
        ngaytxt.setFont(f);
        thanhtientxt.setFont(f);

        mahdtxt.setEditable(false);
        manvtxt.setEditable(false);
        tennvtxt.setEditable(false);
        mancctx.setEditable(false);
        tenncctxt.setEditable(false);
        ngaytxt.setEditable(false);
        thanhtientxt.setEditable(false);
        
        settext();

        infopnl.add(mahdtxt);
        infopnl.add(manvtxt);
        infopnl.add(mancctx);
        infopnl.add(ngaytxt);
        infopnl.add(tennvtxt);
        infopnl.add(tenncctxt);
        infopnl.add(thanhtientxt);

        return infopnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 400);
        booktable.setHeader(new String[]{"STT","Mã sách","Tên sách","Số lượng","Đơn giá","Thành tiền"});
        qlcthdnh.initList();
        setDataToTable(qlcthdnh.getList(), booktable);
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
        qlhdnh.initList();
        qlncc.initList();
        nhacungcap ncc;
        nhanvien nv ;
        for(hoadonnhaphang hd : qlhdnh.getList()) {
            if(hd.getmahd() == this.mahd) {
                ncc = qlncc.getNCC(hd.getMancc());
                nv = qlnv.getNhanVien(hd.getmanv());
                mahdtxt.setText(String.valueOf(this.mahd) );
                manvtxt.setText(String.valueOf(nv.getMa()));
                tennvtxt.setText(nv.getTen());
                mancctx.setText(String.valueOf(ncc.getMa()));
                tenncctxt.setText(ncc.getTen());
                ngaytxt.setText(hd.getngay());
                thanhtientxt.setText(PriceFormatter.format(hd.getTongtien())); 
                break;
            }
        }
    }
}
