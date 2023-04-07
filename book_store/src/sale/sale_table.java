package sale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class sale_table extends JPanel{
    
    private JTable booktable;
    private JScrollPane scrollPane;
    private DefaultTableModel booktableModel;
    private JTextField inp[];
    private JLabel text[];
    private JLabel image;

    public sale_table() throws IOException {
        this.setLayout(new BorderLayout(0,0));
        this.add(bookdetail(),BorderLayout.EAST);
        this.add(initTable(),BorderLayout.WEST);
    }
    
    public JScrollPane initTable() {
        booktable = new JTable();
        booktable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollPane = new JScrollPane(booktable);
        scrollPane.setPreferredSize(new Dimension(525,350));
        String columns[] = {"ID","Book name","Quantity","Price","Total"};
        String data[][] = {{"1","What a wonderful world","2","20000","40000"},
                            {"2","What a wonderful world","2","20000","40000"},
                            {"3","What a wonderful world","2","20000","40000"},
                            {"4","What a wonderful world","2","20000","40000"},
                            {"5","What a wonderful world","2","20000","40000"},
                            {"6","What a wonderful world","2","20000","40000"},
                            {"7","What a wonderful world","2","20000","40000"},
                            {"8","What a wonderful world","2","20000","40000"},
                            {"9","What a wonderful world","2","20000","40000"},
                            {"10","What a wonderful world","2","20000","40000"},
                            {"11","What a wonderful world","2","20000","40000"},
                            {"12","What a wonderful world","2","20000","40000"},
                            {"13","What a wonderful world","2","20000","40000"}};
        booktableModel = new DefaultTableModel(data,columns);
        booktable.setModel(booktableModel);
        booktable.getColumnModel().getColumn(0).setPreferredWidth(25);
        booktable.getColumnModel().getColumn(1).setPreferredWidth(200);
        booktable.getColumnModel().getColumn(2).setPreferredWidth(75);
        booktable.getColumnModel().getColumn(3).setPreferredWidth(50);
        booktable.getColumnModel().getColumn(4).setPreferredWidth(100);
        booktable.setRowHeight(50);
        booktable.getTableHeader().setBackground(new Color(255,30,30));
        booktable.getTableHeader().setForeground(Color.white);
        booktable.getTableHeader().setFont(new Font("Arial",Font.PLAIN,18));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        booktable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        booktable.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        booktable.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        booktable.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        booktable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        return scrollPane;
    }

    public JPanel bookdetail() throws IOException {
        JPanel pbookdetail = new JPanel();
        String bookdetail[] = {"Book id","Name","Price","Quantity","Total"};
        inp = new JTextField[bookdetail.length];
        text = new JLabel[bookdetail.length];
        pbookdetail.setLayout(null);
        pbookdetail.setBackground(Color.decode("#272727"));
        pbookdetail.setPreferredSize(new Dimension(525,350));
        int xtext=220 , ytext=80 , xinp=330 , yinp=80;
        for(int i=0;i<bookdetail.length;i++) {
            text[i] = new JLabel(bookdetail[i]);
            text[i].setBounds(xtext,ytext,100,30);
            text[i].setBackground(new Color(255,30,30));
            text[i].setForeground(Color.WHITE);
            text[i].setOpaque(true);
            text[i].setHorizontalAlignment(JLabel.CENTER);
            pbookdetail.add(text[i]);
            ytext+=45;
            inp[i] = new JTextField();
            inp[i].setName("input"+i);
            inp[i].setBounds(xinp,yinp,180,30);
            pbookdetail.add(inp[i]);
            yinp+=45;
        }
        image = new JLabel();
        image.setBounds(10,25,200,300);
        image.setOpaque(true);
        BufferedImage bufferedImage = ImageIO.read(new File("D:/Xampp/htdocs/project-NoRenowned-games/assets/img/sky3.jpg"));
        Image img = bufferedImage.getScaledInstance(200, 300, Image.SCALE_DEFAULT);
        image.setIcon(new ImageIcon(img));
        image.setBorder(new LineBorder(new Color(255,30,30),4,true));
        image.setBackground(Color.BLACK);

        pbookdetail.add(image);
        return pbookdetail;
    }

    private void tableMouseClicked(MouseEvent evt) {
        int row = booktable.getSelectedRow();
        String id = (String) booktable.getValueAt(row, 0);
        inp[0].setText(id);
        String name = (String) booktable.getValueAt(row, 1);
        inp[1].setText(name);
        String price = (String) booktable.getValueAt(row, 3);
        inp[2].setText(price);
        String quantity = (String) booktable.getValueAt(row, 2);
        inp[3].setText(quantity);
        String total = (String) booktable.getValueAt(row, 4);
        inp[4].setText(total);
    }

}
