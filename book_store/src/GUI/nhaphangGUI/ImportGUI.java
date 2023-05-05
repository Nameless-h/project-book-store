package GUI.nhaphangGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.lang.Integer;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
import DTO.taikhoan;
import GUI.Mytable;
import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;
import GUI.Mybutton.morebutton;
import GUI.Mybutton.searchbutton;
import support.WritePDF;

public class ImportGUI extends JPanel implements ActionListener {
    /* panel chinh */
    private JPanel leftPanel;
    private JPanel rightPanel;

    /* left panle */
    // search panel
    private JPanel searchpnl;
    private JTextField searchinp;
    private searchbutton searchbtn;
    //book table
    private Mytable booktable;
    // book detail
    private JTextField inp[];
    private addbutton addbtn;

    /* right panle */
    // cart button
    private JPanel actionpnl;
    // cart table
    private Mytable carttable;
    // information panel
    private JPanel infopnl;
    private JTextField nccinp;
    private JTextField empnameinp;
    private JTextField dateinp;
    private JTextField grandtotalinp;
    private JButton paybtn;
    private JButton cancelbtn;
    private editbutton editbtn;
    private deletebutton delbtn;
    private morebutton morebtn;

    //action
    private SanPhamBUS bookbus = new SanPhamBUS();
    private quanlihoadonnhaphang qlhdnh = new quanlihoadonnhaphang();
    private quanlichitiethoadonnhaphang qlcthdnh = new quanlichitiethoadonnhaphang();
    private ArrayList<chitiethoadon> listcthd = new ArrayList<chitiethoadon>();
    private quanlinhacungcap qlncc = new quanlinhacungcap();
    private quanlinhanvien qlnv = new quanlinhanvien();
    private nhacungcap ncc;
    private nhanvien nv;
    private double grandtotal;

    /*------------------------------------------- METHOD -------------------------------------------*/

    public ImportGUI(taikhoan tk) throws IOException {
        init();
        getNhanviendangnhap(tk);
    }

    public void init() throws IOException {
        this.setPreferredSize(new Dimension(1000, 700));
        this.setLayout(new GridLayout(1, 2));
        this.add(leftPanel());
        this.add(rightPanel());
    }

    /*------------------------------------------- LEFT PANEL -------------------------------------------*/
    public JPanel leftPanel() throws IOException {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(0, 10));
        leftPanel.add(searchPanel(), BorderLayout.NORTH);
        leftPanel.add(bookTable(), BorderLayout.CENTER);
        leftPanel.add(bookDetail(), BorderLayout.SOUTH);
        return leftPanel;
    }

    public JPanel searchPanel() {
        searchpnl = new JPanel();
        searchinp = new JTextField();
        searchbtn = new searchbutton();
        searchinp.setPreferredSize(new Dimension(350, 40));
        searchbtn.setPreferredSize(new Dimension(100, 40));
        searchpnl.add(searchinp);
        searchpnl.add(searchbtn);
        searchpnl.setPreferredSize(new Dimension(0, 50));
        searchpnl.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));

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
        
        return searchpnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 350);
        booktable.setHeader(new String[] { "Mã", "Tên sách", "Đơn giá", "SL" });
        bookbus.listSanPham();
        for(Sach book : bookbus.getDanhSachSanPham()) {
            booktable.addRow(new Object[]{
                book.getMaSach(),
                book.getTenSach(),
                PriceFormatter.format(book.getGiaTien()),
                book.getSoLuong()
            });
        }
        booktable.setPreferredWidth(0, 25);
        booktable.setPreferredWidth(1, 250);
        booktable.setPreferredWidth(2, 75);
        booktable.setPreferredWidth(3, 100);

        int align = JLabel.CENTER;
        booktable.setAlignment(0, align);
        booktable.setAlignment(2, align);
        booktable.setAlignment(3, align);

        booktable.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        return booktable;
    }

    public JPanel bookDetail() throws IOException {
        JPanel pbookdetail = new JPanel();
        JPanel inputpnl = new JPanel();
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        String bookdetail[] = { "Mã sách", "Tên sách", "Đơn giá", "Số lượng" };
        inp = new JTextField[bookdetail.length];
        addbtn = new addbutton();
        pbookdetail.setLayout(null);
        pbookdetail.setPreferredSize(new Dimension(0, 300));
        inputpnl.setLayout(new GridLayout(4, 1, 5, 5));
        inputpnl.setBounds(20, 0, 500, 210);
        for (int i = 0; i < bookdetail.length; i++) {
            inp[i] = new JTextField();
            inp[i].setName("input" + i);
            inp[i].setBorder(BorderFactory.createTitledBorder(bookdetail[i]));
            inp[i].setFont(f);
            if (inp[i].getName().equalsIgnoreCase("input3"))
                inp[i].setEditable(true);
            else
                inp[i].setEditable(false);
            inputpnl.add(inp[i]);
        }

        addbtn.setBounds(20, 215, 500, 40);
        addbtn.addActionListener(this);

        pbookdetail.add(addbtn);
        pbookdetail.add(inputpnl);
        return pbookdetail;
    }

    /*------------------------------------------- RIGHT PANEL -------------------------------------------*/
    public JPanel rightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout(0, 10));
        rightPanel.add(actionPanel(), BorderLayout.NORTH);
        rightPanel.add(cartTable(), BorderLayout.CENTER);
        rightPanel.add(informationPanel(), BorderLayout.SOUTH);
        return rightPanel;
    }

    public JPanel actionPanel() {
        actionpnl = new JPanel();
        editbtn = new editbutton();
        delbtn = new deletebutton();
        editbtn.setPreferredSize(new Dimension(100, 35));
        delbtn.setPreferredSize(new Dimension(100, 35));
        editbtn.addActionListener(this);
        delbtn.addActionListener(this);
        actionpnl.add(editbtn);
        actionpnl.add(delbtn);
        actionpnl.setPreferredSize(new Dimension(0, 50));
        actionpnl.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        return actionpnl;
    }

    public JPanel cartTable() {
        carttable = new Mytable();
        carttable.setTablesize(0, 400);
        carttable.setHeader(new String[] { "Mã", "Tên sách", "Đơn giá", "SL", "Thành tiền" });
        carttable.setPreferredWidth(0, 25);
        carttable.setPreferredWidth(1, 200);
        carttable.setPreferredWidth(2, 100);
        carttable.setPreferredWidth(3,25);
        carttable.setPreferredWidth(4, 100);

        int align = JLabel.CENTER;
        carttable.setAlignment(0, align);
        carttable.setAlignment(3, align);

        carttable.getTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        return carttable;
    }

    public JPanel informationPanel() {
        Font f = new Font(Font.SANS_SERIF, Font.BOLD, 13);
        infopnl = new JPanel();

        nccinp = new JTextField();
        empnameinp = new JTextField();
        dateinp = new JTextField();
        grandtotalinp = new JTextField();

        paybtn = new JButton("Nhập hàng");
        cancelbtn = new JButton("Hủy");
        morebtn = new morebutton();

        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 23));
        infopnl.setPreferredSize(new Dimension(0, 250));

        nccinp.setBorder(BorderFactory.createTitledBorder("Nhà cung cấp"));
        empnameinp.setBorder(BorderFactory.createTitledBorder("Nhân viên"));
        dateinp.setBorder(BorderFactory.createTitledBorder("Ngày lập hóa đơn"));
        grandtotalinp.setBorder(BorderFactory.createTitledBorder("Thành tiền"));

        int w = 250, h = 48;

        nccinp.setPreferredSize(new Dimension(200, h));
        empnameinp.setPreferredSize(new Dimension(w, h));
        dateinp.setPreferredSize(new Dimension(w, h));
        grandtotalinp.setPreferredSize(new Dimension(w, h));
        paybtn.setPreferredSize(new Dimension(250, 40));
        cancelbtn.setPreferredSize(new Dimension(250, 40));
        morebtn.setPreferredSize(new Dimension(40, 35));

        nccinp.setEditable(false);
        empnameinp.setEditable(false);
        dateinp.setEditable(false);
        grandtotalinp.setEditable(false);
        nccinp.setFont(f);
        empnameinp.setFont(f);
        dateinp.setFont(f);
        grandtotalinp.setFont(f);

        cancelbtn.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_cancel_30px_1.png")));
        paybtn.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_us_dollar_30px.png")));

        cancelbtn.addActionListener(this);
        paybtn.addActionListener(this);

        int total = 0;
        int tmp;
        for (int i = 0; i < carttable.getTable().getRowCount(); i++) {
            tmp = (int) carttable.getTable().getValueAt(i,5);
            total+= tmp;
        }
        grandtotalinp.setText(PriceFormatter.format(total));
        dateinp.setText(java.time.LocalDate.now().toString());
        new Timer().scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if(empnameinp.getText().equals("") || nccinp.getText().equals("") || listcthd.isEmpty()) {
                    paybtn.setEnabled(false);
                } else 
                    paybtn.setEnabled(true);
            }
        }, 0, 1000);
        

        infopnl.add(nccinp);
        infopnl.add(morebtn);
        infopnl.add(empnameinp);
        infopnl.add(dateinp);
        infopnl.add(grandtotalinp);
        infopnl.add(cancelbtn);
        infopnl.add(paybtn);

        morebtn.addActionListener((ae) -> {
            showFormChonNCC();
        });

        return infopnl;
    }

    /*------------------------------------------- ACTION -------------------------------------------*/
    
    private void getNhanviendangnhap(taikhoan tk) {
        nv = qlnv.getNhanVien(tk.getManhanvien());
        empnameinp.setText(nv.getTen());
    }


    private void addtoCart(int masach,int soluong) {
        Sach b = bookbus.getBook(masach);
        boolean inCart = false;
        int tongsoluong;

        for(chitiethoadon cthd : listcthd) {
            if(cthd.getmasach() == b.getMaSach()) {
                tongsoluong = soluong + cthd.getsoluong();
                cthd.setsoluong(tongsoluong);
                inCart = true;
            }
        }

        if(!inCart) {
            chitiethoadon cthd = new chitiethoadon(qlhdnh.getNextID(),masach,b.getGiaTien(),soluong);
            System.out.println(cthd);
            listcthd.add(cthd);
        }
        setDataToCartTable(listcthd, carttable); 
    }

    private void setDataToCartTable(ArrayList<chitiethoadon> list,Mytable t) {
        t.clear();
        Sach b = null;
        int totalprice;
        grandtotal = 0;
        for(chitiethoadon cthd : list){
            b = bookbus.getBook(cthd.getmasach());
            totalprice = b.getGiaTien() * cthd.getsoluong();
            t.addRow(new Object[]{
                String.valueOf(cthd.getmasach()),
                b.getTenSach(),
                PriceFormatter.format(b.getGiaTien()),
                String.valueOf(cthd.getsoluong()),
                PriceFormatter.format(totalprice)
            });
            grandtotal+=totalprice;
        }
        grandtotalinp.setText(PriceFormatter.format(grandtotal));
    }

    private void setDataToBookTable(ArrayList<Sach> list,Mytable t) {
        t.clear();
        for(Sach b : list) {
            t.addRow(new Object[]{
                String.valueOf(b.getMaSach()),
                b.getTenSach(),
                PriceFormatter.format(b.getGiaTien()),
                b.getSoLuong()
            });
        }
    }

    private void searchOnchange() {
        setDataToBookTable(bookbus.searchBooks(searchinp.getText()), booktable);
    }
    
    private void refresh() {
        listcthd.clear();
        carttable.clear();
        nccinp.setText("");
        for(int i=0;i<inp.length;i++) {
            inp[i].setText("");
        }
        setDataToCartTable(listcthd, carttable);
    }

    private void showFormChonNCC() {
        new chonnhacungcapGUI(nccinp).addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                int mancc = Integer.parseInt(nccinp.getText());
                qlncc.initList();
                ncc = qlncc.getNCC(mancc);
                if(ncc != null) {
                    nccinp.setText(ncc.getTen());
                }
            }
        });
    }

    private void tableMouseClicked(MouseEvent evt) {
        int row = booktable.getTable().getSelectedRow();
        String id = String.valueOf(booktable.getTable().getValueAt(row, 0));
        inp[0].setText(id);
        String name = (String) booktable.getTable().getValueAt(row, 1);
        inp[1].setText(name);
        String price = String.valueOf(booktable.getTable().getValueAt(row, 2));
        inp[2].setText(price);
        inp[3].setText("1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addbtn) {
            if(nccinp.getText().equals("")) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Vui lòng chọn nhà cung cấp !","Thông báo",2);
                if(dialogResult == JOptionPane.YES_OPTION){
                    showFormChonNCC();
                } else {
                    return;
                }
            } else {
                int masach = 0;
                try {
                    masach = Integer.parseInt(inp[0].getText());
                    int soluong = Integer.parseInt(inp[3].getText());
                    if(soluong > 0) {
                        addtoCart(masach, soluong);
                    } else {
                        JOptionPane.showMessageDialog(this,"Số lượng phải là số dương !");
                        inp[3].requestFocus();
                    }
                } catch (NumberFormatException ex) {
                    if(masach == 0) {
                        JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm trước khi thêm vào giỏ hàng !");
                    } else {
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(this,"Số lượng phải là số nguyên !");
                        inp[3].requestFocus();
                    }
                    
                }
            }
        }
        if (e.getSource() == editbtn) {
            int row = carttable.getTable().getSelectedRow();
            if(row == -1 && listcthd.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Giỏ hàng rỗng!","Thông báo",1);
                return;
            } else if(row == -1 && !listcthd.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần chỉnh sửa!","Thông báo",1);
                return;
            } else {
                String id = (String) carttable.getTable().getValueAt(row, 0);
                inp[0].setText(id);
                String name = (String) carttable.getTable().getValueAt(row, 1);
                inp[1].setText(name);
                String price = (String) carttable.getTable().getValueAt(row, 2);
                inp[2].setText(price);
                String quantity = (String) carttable.getTable().getValueAt(row, 3);
                inp[3].setText(quantity);
                listcthd.remove(row);
                carttable.getTableModel().removeRow(row);
                setDataToCartTable(listcthd, carttable);
            }
        }
        if (e.getSource() == delbtn) {
            int row = carttable.getTable().getSelectedRow();
            if(row == -1 && listcthd.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Giỏ hàng rỗng!","Thông báo",1);
                return;
            } else if(row == -1 && !listcthd.isEmpty()) {
                JOptionPane.showMessageDialog(this,"Vui lòng chọn sản phẩm cần chỉnh sửa!","Thông báo",1);
                return;
            } else {
                listcthd.remove(row);
                carttable.getTableModel().removeRow(row);  
                setDataToCartTable(listcthd, carttable);
            }
        }
        if (e.getSource() == cancelbtn) {
            if(!listcthd.isEmpty()) {
                int dialogResult = JOptionPane.showConfirmDialog (null, "Xác nhận hủy thanh toán !","Cảnh báo",2);
                if(dialogResult == JOptionPane.YES_OPTION){
                    refresh();
                } else {
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this,"Giỏ hàng rỗng !","Thông báo",1);
                return;
            }
        }
        if (e.getSource() == paybtn) {
            int mahd = qlhdnh.getNextID();
            hoadonnhaphang hdnh = new hoadonnhaphang(ncc.getMa(),mahd,nv.getMa(),dateinp.getText(),grandtotal);
            
            if(qlhdnh.themHoaDon(hdnh)/* them hoa don */) {
                //them chi tiet hoa don
                qlcthdnh.themChiTietHoaDon(listcthd);
                //cap so luong sach
                for(chitiethoadon cthd: listcthd) {
                    bookbus.updateSoLuongNhapHang(cthd.getmasach(),cthd.getsoluong());
                }
                int reply = JOptionPane.showConfirmDialog(getRootPane(),
                "Nhập hàng thành công, bạn có muốn IN HÓA ĐƠN NHẬP HÀNG?", "Thành công",
                JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.OK_OPTION) {
                    new WritePDF().writeHoaDonNhapHang(mahd);
                }                
                //refresh
                refresh();
                bookbus.listSanPham();
                setDataToBookTable(bookbus.getDanhSachSanPham(), booktable);
                return;
            } else {
                JOptionPane.showMessageDialog(this,"Nhập hàng thất bại !","Thông báo",1);
                return;
            }
        }
    }
}
