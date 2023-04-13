package GUI.sale;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import GUI.Mytable;
import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;
import GUI.Mybutton.searchbutton;

public class SaleGUI extends JPanel implements ActionListener {
    /* panel chinh */
    private JPanel leftPanel;
    private JPanel rightPanel;

    /* left panle */
    //search panel
    private JPanel searchpnl;
    private JTextField searchinp;
    //book table
    private Mytable booktable;
    //book detail
    private JTextField inp[];
    private JLabel image;
    addbutton addbtn;

    /* right panle */
    //cart button
    private JPanel actionpnl;
    //cart table
    Mytable carttable;
    //information panel
    private JPanel infopnl;
    private JTextField cusidinp;
    private JTextField empnameinp;
    private JTextField dateinp;
    private JTextField subtotalinp;
    private JTextField discountinp;
    private JTextField grandtotalinp;
    private JButton paybtn;
    private JButton cancelbtn;
    editbutton editbtn;
    deletebutton delbtn;

    /*------------------------------------------- METHOD -------------------------------------------*/

    public SaleGUI() throws IOException {
        init();
    }

    public void init() throws IOException {
        this.setPreferredSize(new Dimension(1000,700));
        this.setLayout(new GridLayout(1,2));
        this.add(leftPanel());
        this.add(rightPanel());
    }

    /*------------------------------------------- LEFT PANEL -------------------------------------------*/
    public JPanel leftPanel() throws IOException {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout(0,10));
        leftPanel.add(searchPanel(),BorderLayout.NORTH);
        leftPanel.add(bookTable(),BorderLayout.CENTER);
        leftPanel.add(bookDetail(),BorderLayout.SOUTH);
        return leftPanel;
    }

    public JPanel searchPanel() {
        searchpnl = new JPanel();
        searchinp = new JTextField();
        searchbutton searchbtn = new searchbutton();
        searchinp.setPreferredSize(new Dimension(350,40));
        searchbtn.setPreferredSize(new Dimension(100,40));
        searchpnl.add(searchinp);
        searchpnl.add(searchbtn);
        searchpnl.setPreferredSize(new Dimension(0,50));
        searchpnl.setLayout(new FlowLayout(FlowLayout.CENTER,5,10));
        return searchpnl;
    }

    public Mytable bookTable() {
        booktable = new Mytable();
        booktable.setTablesize(0, 350);
        booktable.setHeader(new String[]{"ID","Book name","Price","Quantity"});
        for(int i=0;i<15;i++) {
            booktable.addRow(new String[]{
                String.valueOf(i+1),
                "What a wonderful world "+(i+1),
                "20000",
                "5"
            });
        }
        booktable.setPreferredWidth(0, 25);
        booktable.setPreferredWidth(1, 250);
        booktable.setPreferredWidth(2, 75);
        booktable.setPreferredWidth(3, 100);

        int align = JLabel.CENTER;
        booktable.setAlignment(0,align);
        booktable.setAlignment(2,align);
        booktable.setAlignment(3,align);

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
        String bookdetail[] = {"Book id","Name","Price","Quantity"};
        inp = new JTextField[bookdetail.length];
        addbtn = new addbutton();
        pbookdetail.setLayout(null);
        pbookdetail.setPreferredSize(new Dimension(0,300));
        inputpnl.setLayout(new GridLayout(3,2,5,40));
        inputpnl.setBounds(185,10,350,210);
        for(int i=0;i<bookdetail.length;i++) {
            inp[i] = new JTextField();
            inp[i].setName("input"+i);
            inp[i].setBorder(BorderFactory.createTitledBorder(bookdetail[i]));
            inp[i].setFont(f);
            if(inp[i].getName().equalsIgnoreCase("input3"))
                inp[i].setEditable(true);
            else 
                inp[i].setEditable(false);
            inputpnl.add(inp[i]);
        }
/*         image = new JLabel();
        image.setBounds(10,10,170,250);
        image.setOpaque(true);
        BufferedImage bufferedImage = ImageIO.read(new File("../../icon/arrow_left.png"));
        Image img = bufferedImage.getScaledInstance(170, 250, Image.SCALE_DEFAULT);
        image.setIcon(new ImageIcon(img));
        image.setBorder(new LineBorder(Color.BLACK,1,true)); */

        addbtn.setBounds(195,220,330,40);
        addbtn.addActionListener(this);
        
        pbookdetail.add(addbtn);
        //pbookdetail.add(image);
        pbookdetail.add(inputpnl);
        return pbookdetail;
    }

    /*------------------------------------------- RIGHT PANEL -------------------------------------------*/
    public JPanel rightPanel() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout(0,10));
        rightPanel.add(actionPanel(),BorderLayout.NORTH);
        rightPanel.add(cartTable(),BorderLayout.CENTER);
        rightPanel.add(informationPanel(),BorderLayout.SOUTH);
        return rightPanel;
    }
    
    public JPanel actionPanel() {
        actionpnl = new JPanel();
        editbtn = new editbutton();
        delbtn = new deletebutton();
        editbtn.setPreferredSize(new Dimension(100,35));
        delbtn.setPreferredSize(new Dimension(100,35));
        editbtn.addActionListener(this);
        delbtn.addActionListener(this);
        actionpnl.add(editbtn);
        actionpnl.add(delbtn);
        actionpnl.setPreferredSize(new Dimension(0,50));
        actionpnl.setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        return actionpnl;
    }

    public JPanel cartTable() {
        carttable = new Mytable();
        carttable.setTablesize(0, 400);
        carttable.setHeader(new String[]{"ID","Book name","Price","Quantity","Total"});
        carttable.setPreferredWidth(0, 25);
        carttable.setPreferredWidth(1, 200);
        carttable.setPreferredWidth(2, 50);
        carttable.setPreferredWidth(3, 75);
        carttable.setPreferredWidth(4, 100);

        int align = JLabel.CENTER;
        carttable.setAlignment(0,align);
        carttable.setAlignment(3,align);

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

        infopnl.setLayout(new FlowLayout(FlowLayout.CENTER,15,5));
        infopnl.setPreferredSize(new Dimension(0,250));

        cusidinp.setBorder(BorderFactory.createTitledBorder("Customer ID"));
        empnameinp.setBorder(BorderFactory.createTitledBorder("Employee name"));
        dateinp.setBorder(BorderFactory.createTitledBorder("Due Date"));
        subtotalinp.setBorder(BorderFactory.createTitledBorder("Subtotal"));
        discountinp.setBorder(BorderFactory.createTitledBorder("Discount"));
        grandtotalinp.setBorder(BorderFactory.createTitledBorder("Grand total"));

        int w=250,h=50;

        cusidinp.setPreferredSize(new Dimension(w,h));
        empnameinp.setPreferredSize(new Dimension(w,h));
        dateinp.setPreferredSize(new Dimension(w,h));
        subtotalinp.setPreferredSize(new Dimension(w,h));
        discountinp.setPreferredSize(new Dimension(w,h));
        grandtotalinp.setPreferredSize(new Dimension(w,h));
        paybtn.setPreferredSize(new Dimension(250,40));
        cancelbtn.setPreferredSize(new Dimension(250,40));

        cusidinp.setEditable(true);
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

        cancelbtn.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_cancel_30px_1.png")));
        paybtn.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_us_dollar_30px.png")));
        
        cancelbtn.addActionListener(this);

        infopnl.add(cusidinp);
        infopnl.add(subtotalinp);
        infopnl.add(empnameinp);
        infopnl.add(discountinp);
        infopnl.add(dateinp);
        infopnl.add(grandtotalinp);
        infopnl.add(cancelbtn);
        infopnl.add(paybtn);

        return infopnl;
    }

    /*------------------------------------------- ACTION -------------------------------------------*/
    private void tableMouseClicked(MouseEvent evt) {
        int row = booktable.getTable().getSelectedRow();
        String id = (String) booktable.getTable().getValueAt(row, 0);
        inp[0].setText(id);
        String name = (String) booktable.getTable().getValueAt(row, 1);
        inp[1].setText(name);
        String price = (String) booktable.getTable().getValueAt(row, 2);
        inp[2].setText(price);
        inp[3].setText("1");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addbtn) {
            int total = Integer.parseInt(inp[2].getText()) * Integer.parseInt(inp[3].getText());
            Object data[] = {inp[0].getText(),inp[1].getText(),inp[2].getText(),inp[3].getText(),total};
            carttable.getTableModel().addRow(data);
        }
        if(e.getSource() == editbtn) {
            int row = carttable.getTable().getSelectedRow();
            String id = (String) carttable.getTable().getValueAt(row, 0);
            inp[0].setText(id);
            String name = (String) carttable.getTable().getValueAt(row, 1);
            inp[1].setText(name);
            String price = (String) carttable.getTable().getValueAt(row, 2);
            inp[2].setText(price);
            String quantity = (String) carttable.getTable().getValueAt(row, 3);
            inp[3].setText(quantity);
            carttable.getTableModel().removeRow(row);
        }
        if(e.getSource() == delbtn) {
            int row = carttable.getTable().getSelectedRow();
            carttable.getTableModel().removeRow(row);
        }
        if(e.getSource() == cancelbtn) {
            carttable.clear();
        }
    }
}
