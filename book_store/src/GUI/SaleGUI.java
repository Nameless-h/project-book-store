package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Integer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import BUS.PriceFormatter;
import BUS.bookBUS;
import DTO.book;
import DTO.chitiethoadon;
import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;
import GUI.Mybutton.morebutton;
import GUI.Mybutton.searchbutton;

public class SaleGUI extends JPanel implements ActionListener {
    /* panel chinh */
    private JPanel leftPanel;
    private JPanel rightPanel;

    /* left panle */
    // search panel
    private JPanel searchpnl;
    private JTextField searchinp;
    private searchbutton searchbtn;
    //book table
    private bookBUS bookbus = new bookBUS();
    private Mytable booktable;
    // book detail
    private JTextField inp[];
    private JLabel image;
    private addbutton addbtn;

    /* right panle */
    // cart button
    private JPanel actionpnl;
    // cart table
    private Mytable carttable;
    // information panel
    private JPanel infopnl;
    private JTextField cusidinp;
    private JTextField empnameinp;
    private JTextField dateinp;
    private JTextField subtotalinp;
    private JTextField discountinp;
    private JTextField grandtotalinp;
    private JButton paybtn;
    private JButton cancelbtn;
    private editbutton editbtn;
    private deletebutton delbtn;
    private morebutton morebtn;

    //action
    private ArrayList<chitiethoadon> listcthd = new ArrayList<chitiethoadon>();

    /*------------------------------------------- METHOD -------------------------------------------*/

    public SaleGUI() throws IOException {
        init();
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
        booktable.setHeader(new String[]{"ID","Book name","Price","Quantity"});
        bookbus.initbookList();
        for(book book : bookbus.getbookList()) {
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
        String bookdetail[] = { "Book id", "Name", "Price", "Quantity" };
        inp = new JTextField[bookdetail.length];
        addbtn = new addbutton();
        pbookdetail.setLayout(null);
        pbookdetail.setPreferredSize(new Dimension(0, 300));
        inputpnl.setLayout(new GridLayout(3, 2, 5, 40));
        inputpnl.setBounds(185, 10, 350, 210);
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
        try {
            image = new JLabel();
            image.setBounds(10,10,170,250);
            image.setOpaque(true);
            BufferedImage bufferedImage = ImageIO.read(new File("book_store/src/img/doraemon.jpg"));
            Image img = bufferedImage.getScaledInstance(170, 250, Image.SCALE_DEFAULT);
            image.setIcon(new ImageIcon(img));
            image.setBorder(new LineBorder(Color.BLACK,1,true));
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Working Directory = " + System.getProperty("user.dir"));
        }
        
        

        addbtn.setBounds(195, 220, 330, 40);
        addbtn.addActionListener(this);

        pbookdetail.add(addbtn);
        pbookdetail.add(image);
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
        carttable.setHeader(new String[] { "ID", "Book name", "Price", "Quantity", "Total" });
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

        cusidinp = new JTextField();
        empnameinp = new JTextField();
        dateinp = new JTextField();
        subtotalinp = new JTextField();
        discountinp = new JTextField();
        grandtotalinp = new JTextField();

        paybtn = new JButton("Pay");
        cancelbtn = new JButton("Cancel");
        morebtn = new morebutton();

        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));
        infopnl.setPreferredSize(new Dimension(0, 250));

        cusidinp.setBorder(BorderFactory.createTitledBorder("Customer ID"));
        empnameinp.setBorder(BorderFactory.createTitledBorder("Employee name"));
        dateinp.setBorder(BorderFactory.createTitledBorder("Due Date"));
        subtotalinp.setBorder(BorderFactory.createTitledBorder("Subtotal"));
        discountinp.setBorder(BorderFactory.createTitledBorder("Discount"));
        grandtotalinp.setBorder(BorderFactory.createTitledBorder("Grand total"));

        int w = 250, h = 50;

        cusidinp.setPreferredSize(new Dimension(200, h));
        empnameinp.setPreferredSize(new Dimension(w, h));
        dateinp.setPreferredSize(new Dimension(w, h));
        subtotalinp.setPreferredSize(new Dimension(w, h));
        discountinp.setPreferredSize(new Dimension(w, h));
        grandtotalinp.setPreferredSize(new Dimension(w, h));
        paybtn.setPreferredSize(new Dimension(250, 40));
        cancelbtn.setPreferredSize(new Dimension(250, 40));
        morebtn.setPreferredSize(new Dimension(40, 35));

        cusidinp.setEditable(false);
        empnameinp.setEditable(false);
        dateinp.setEditable(false);
        subtotalinp.setEditable(false);
        discountinp.setEditable(false);
        grandtotalinp.setEditable(false);
        cusidinp.setFont(f);
        empnameinp.setFont(f);
        dateinp.setFont(f);
        subtotalinp.setFont(f);
        discountinp.setFont(f);
        grandtotalinp.setFont(f);

        cancelbtn.setIcon(new ImageIcon(this.getClass().getResource("../icon/icons8_cancel_30px_1.png")));
        paybtn.setIcon(new ImageIcon(this.getClass().getResource("../icon/icons8_us_dollar_30px.png")));
        
        cancelbtn.addActionListener(this);

        int total = 0;
        int tmp;
        for (int i = 0; i < carttable.getTable().getRowCount(); i++) {
            tmp = (int) carttable.getTable().getValueAt(i,5);
            total+= tmp;
        }
        subtotalinp.setText(String.valueOf(total));
        dateinp.setText(java.time.LocalDate.now().toString());

        infopnl.add(cusidinp);
        infopnl.add(morebtn);
        infopnl.add(subtotalinp);
        infopnl.add(empnameinp);
        infopnl.add(discountinp);
        infopnl.add(dateinp);
        infopnl.add(grandtotalinp);
        infopnl.add(cancelbtn);
        infopnl.add(paybtn);

        morebtn.addActionListener((ae) -> {
            new chonkhachhangGUI(cusidinp).addWindowListener(new WindowAdapter() {
                public void windowClosed(WindowEvent e) {
                    //cusidinp.setText("");
                }
            });
        });

        return infopnl;
    }

    /*------------------------------------------- ACTION -------------------------------------------*/
    
    public void addtoCart(int masach,int soluong) {
        book b = bookbus.getBook(masach);
        boolean inCart = false;
        int tongsoluong;

        for(chitiethoadon cthd : listcthd) {
            if(cthd.getmasach() == b.getMaSach()) {
                tongsoluong = soluong + cthd.getsoluong();
                if(tongsoluong > b.getSoLuong()){
                    JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + b.getSoLuong() + ")");
                    return;
                }
                cthd.setsoluong(tongsoluong);
                inCart = true;
            }
        }

        if(!inCart) {
            if(soluong > b.getSoLuong()) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ (" + b.getSoLuong() + ")");
                return;
            }
            chitiethoadon cthd = new chitiethoadon(masach,b.getGiaTien(),soluong);
            listcthd.add(cthd);
        }
        setDataToCartTable(listcthd, carttable);
    }

    public void setDataToCartTable(ArrayList<chitiethoadon> list,Mytable t) {
        t.clear();
        book b = null;
        int totalprice;
        int subtotal = 0;
        for(chitiethoadon cthd : list){
            b = bookbus.getBook(cthd.getmasach());
            totalprice = b.getGiaTien() * cthd.getsoluong();
            carttable.getTableModel().addRow(new Object[]{
                String.valueOf(cthd.getmasach()),
                b.getTenSach(),
                PriceFormatter.format(b.getGiaTien()),
                String.valueOf(cthd.getsoluong()),
                PriceFormatter.format(totalprice)
            });
            subtotal+=totalprice;
        }
        subtotalinp.setText(PriceFormatter.format(subtotal));
    }

    public void setDataToBookTable(ArrayList<book> list,Mytable t) {
        t.clear();
        for(book b : list) {
            booktable.getTableModel().addRow(new Object[]{
                String.valueOf(b.getMaSach()),
                b.getTenSach(),
                PriceFormatter.format(b.getGiaTien()),
                b.getSoLuong()
            });
        }
    }

    public void searchOnchange() {
        setDataToBookTable(bookbus.searchBooks(searchinp.getText()), booktable);
    }
    
    private void tableMouseClicked(MouseEvent evt) {
        int row = booktable.getTable().getSelectedRow();
        String id = String.valueOf(booktable.getTable().getValueAt(row, 0)) ;
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
            int masach = Integer.parseInt(inp[0].getText());
            int soluong = Integer.parseInt(inp[3].getText());
            addtoCart(masach, soluong);
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
            int dialogResult = JOptionPane.showConfirmDialog (null, "Thanh toán mới?","Warning",1);
            if(dialogResult == JOptionPane.YES_OPTION){
                listcthd.clear();
                carttable.clear();
                cusidinp.setText("");
                for(int i=0;i<inp.length;i++) {
                    inp[i].setText("");
                }
                setDataToCartTable(listcthd, carttable);
            } else {
                return;
            }
        }
    }
}
