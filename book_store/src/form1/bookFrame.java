package form1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.ArrayList;
import the_loai.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import book_detail.book;
import DAO.The_loai_modify;
import DAO.book_modify;
import DAO.nxb_modify;
import DAO.tac_gia_modify;
import NXB.NXB;
import tac_gia.tacgia;

public class bookFrame extends JPanel implements ActionListener, ChangeListener {
  Font fo = new Font("Time New Roman", Font.BOLD, 20);
  Font searchFo = new Font("Time New Roman", Font.PLAIN, 15);
  book_modify mod_bk = new book_modify();
  nxb_modify mod_nxb = new nxb_modify();
  tac_gia_modify mod_tg = new tac_gia_modify();

  public bookFrame() {
    this.setLayout(new BorderLayout());
    init();
    this.setVisible(true);
  }

  public void init() {
    // create table
    scrollPaneBook = new JScrollPane();
    scrollPaneNxb = new JScrollPane();
    // init panel
    detail_panel = new JPanel();
    nxb_panel = new JPanel();
    search_Panel = new JPanel();
    button_panel = new JTabbedPane();
    button_panel.addChangeListener(this);
    // init label of book info
    String[] book_info_label = { "Tên sách: ", "Thể loại: ", "Tác giả: ", "Nhà xuất bản: ", "Năm xuất bản : ",
        "Số lượng: ", "Giá tiền: " };
    book_detail_labels = new JLabel[book_info_label.length];
    int posY = 50;
    int posY2 = 50;
    for (int i = 0; i < book_info_label.length; i++) {
      if (i < 4) {
        book_detail_labels[i] = new JLabel(book_info_label[i]);
        book_detail_labels[i].setBounds(20, posY - 30, 200, 25);
        book_detail_labels[i].setFont(fo);
        detail_panel.add(book_detail_labels[i]);
        posY += 50;
      } else {
        book_detail_labels[i] = new JLabel(book_info_label[i]);
        book_detail_labels[i].setBounds(550, posY2 - 30, 200, 25);
        book_detail_labels[i].setFont(fo);
        detail_panel.add(book_detail_labels[i]);
        posY2 += 50;
      }

    }

    // init label of nxb info
    String[] nxb_info_label = { "Tên nxb:", "Hotmail:", "Hotline:", "Địa chỉ:" };
    nxb_detail_labels = new JLabel[nxb_info_label.length];
    posY = 50;
    for (int i = 0; i < nxb_info_label.length; i++) {
      nxb_detail_labels[i] = new JLabel(nxb_info_label[i]);
      nxb_detail_labels[i].setBounds(20, posY - 30, 200, 25);
      nxb_detail_labels[i].setFont(fo);
      nxb_panel.add(nxb_detail_labels[i]);
      posY += 50;
    }

    searchTen = new JLabel("Tên sách");
    searchTheloai = new JLabel("Thể loại");
    searchTacgia = new JLabel("Tác giả");
    // init text field
    txttenSach = new JTextField();
    cbbTacgia = new JComboBox<String>();
    cbbTheloai = new JComboBox<String>();
    cbbNXB = new JComboBox<String>();
    txtNamxb = new JTextField();
    txtSoluong = new JTextField();
    txtGiatien = new JTextField();
    txtTenNxb = new JTextField();
    txtMailNxb = new JTextField();
    txtSdtNxb = new JTextField();
    txtDiaChiNxb = new JTextField();
    txtsearchTen = new JTextField();
    cbbsearchTheloai = new JComboBox<String>();
    txtsearchTacgia = new JTextField();
    try {

      searchTen.setBounds(10, 5, 70, 30);
      searchTen.setFont(searchFo);

      searchTheloai.setBounds(300, 5, 70, 30);
      searchTheloai.setFont(searchFo);

      searchTacgia.setBounds(500, 5, 70, 30);
      searchTacgia.setFont(searchFo);
      /* set param cho text va combobox */
      /* -------- book panel --------- */
      txttenSach.setBounds(200, 50 - 30, 300, 25);
      txttenSach.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbTheloai.setBounds(200, 100 - 30, 300, 25);
      cbbTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbTacgia.setBounds(200, 150 - 30, 300, 25);
      cbbTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbNXB.setBounds(200, 200 - 30, 300, 25);
      cbbNXB.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtNamxb.setBounds(750, 50 - 30, 300, 25);
      txtNamxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtSoluong.setBounds(750, 100 - 30, 300, 25);
      txtSoluong.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtGiatien.setBounds(750, 150 - 30, 300, 25);
      txtGiatien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      /* -------- book panel --------- */

      txtTenNxb.setBounds(200, 50 - 30, 350, 25);
      txtTenNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtMailNxb.setBounds(200, 100 - 30, 350, 25);
      txtMailNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtSdtNxb.setBounds(200, 150 - 30, 350, 25);
      txtSdtNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtDiaChiNxb.setBounds(200, 200 - 30, 350, 25);
      txtDiaChiNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtDiaChiNxb.setBounds(200, 200 - 30, 350, 25);
      txtDiaChiNxb.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      txtsearchTen.setBounds(80, 5, 200, 25);
      txtsearchTen.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      cbbsearchTheloai.setBounds(370, 5, 100, 25);
      cbbsearchTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      txtsearchTacgia.setBounds(570, 5, 200, 25);
      txtsearchTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      /* setting cho panel */
      // button_panel.setBounds(0, 0, 1100, (int) Math.floor(700 * 0.52));
      button_panel.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.52)));
      detail_panel.setLayout(null);
      detail_panel.setBackground(new Color(211, 242, 214));

      nxb_panel.setLayout(null);
      nxb_panel.setBackground(new Color(211, 242, 214));

      // search_Panel.setBounds(0, (int) Math.floor(700 * 0.52), 1100, (int)
      // Math.floor(700 * 0.05));
      search_Panel.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.05)));
      search_Panel.setLayout(null);
      search_Panel.setBackground(new Color(50, 168, 76));

      // scrollPaneBook.setBounds(0, (int) Math.floor(700 * 0.57), 1100, (int)
      // Math.floor(700 * 0.43));
      scrollPaneBook.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.43)));
      scrollPaneBook.setVisible(true);
      scrollPaneBook.setBackground(Color.orange);

      // scrollPaneNxb.setBounds(0, (int) Math.floor(700 * 0.57), 1100, (int)
      // Math.floor(700 * 0.43));
      scrollPaneNxb.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.43)));
      scrollPaneNxb.setVisible(false);
      scrollPaneNxb.setBackground(Color.orange);

      /* add component */

      detail_panel.add(txttenSach);
      detail_panel.add(cbbTheloai);
      detail_panel.add(cbbTacgia);
      detail_panel.add(cbbNXB);
      detail_panel.add(txtNamxb);
      detail_panel.add(txtSoluong);
      detail_panel.add(txtGiatien);

      nxb_panel.add(txtTenNxb);
      nxb_panel.add(txtMailNxb);
      nxb_panel.add(txtSdtNxb);
      nxb_panel.add(txtDiaChiNxb);

      search_Panel.add(searchTen);
      search_Panel.add(searchTheloai);
      search_Panel.add(searchTacgia);
      search_Panel.add(txtsearchTen);
      search_Panel.add(cbbsearchTheloai);
      search_Panel.add(txtsearchTacgia);

      button_panel.add("sách", detail_panel);
      button_panel.add("nhà xuất bản", nxb_panel);

      this.add(button_panel, BorderLayout.NORTH);

      JPanel container = new JPanel();
      container.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.43)));
      container.add(scrollPaneBook);
      container.add(scrollPaneNxb);
      this.add(container, BorderLayout.SOUTH);
      this.add(search_Panel, BorderLayout.CENTER);
      showCbbTheloai();
      showCbbNxb();
      showCbbTacgia();
      showBookList();

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  // Variables declaration - do not modify
  private JScrollPane scrollPaneBook;
  private JScrollPane scrollPaneNxb;
  private JPanel detail_panel;
  private JPanel nxb_panel;
  private JPanel search_Panel;
  private JTabbedPane button_panel;
  private JLabel[] book_detail_labels;
  private JLabel[] nxb_detail_labels;
  private JLabel searchTen;
  private JLabel searchTheloai;
  private JLabel searchTacgia;
  private JTextField txttenSach;
  private JComboBox<String> cbbTacgia;
  private JComboBox<String> cbbTheloai;
  private JTextField txtNamxb;
  private JTextField txtSoluong;
  private JTextField txtGiatien;
  private JComboBox<String> cbbNXB;
  private JTextField txtTenNxb;
  private JTextField txtMailNxb;
  private JTextField txtSdtNxb;
  private JTextField txtDiaChiNxb;
  private JTextField txtsearchTen;
  private JComboBox<String> cbbsearchTheloai;
  private JTextField txtsearchTacgia;
  // End of variables declaration

  private void showCbbTheloai() {
    cbbTheloai.removeAllItems();
    ArrayList<Theloai> data = The_loai_modify.allCate();
    for (Theloai tmp : data) {
      cbbTheloai.addItem(tmp.getTenTheloai());
      cbbsearchTheloai.addItem(tmp.getTenTheloai());
    }
  }

  private void showCbbNxb() {
    cbbNXB.removeAllItems();
    ArrayList<NXB> list = mod_nxb.selecAll();
    for (NXB tmp : list) {
      cbbNXB.addItem(tmp.getTenNXB());
    }
    cbbNXB.setEnabled(true);
  }

  private void showCbbTacgia() {
    cbbTacgia.removeAllItems();
    ArrayList<tacgia> list = mod_tg.selecAll();
    for (tacgia tmp : list) {
      cbbTacgia.addItem(tmp.getTenTacgia());
    }
    cbbNXB.setEnabled(true);
  }

  private void showBookList() throws Exception {

    try {
      JTable bookTbl = new JTable();
      // in ra danh sach book
      bookTbl.setFont(new Font("Time New Roman", Font.PLAIN, 18));
      bookTbl.getTableHeader().setFont(fo);
      /* create table */
      bookTbl.setModel(new javax.swing.table.DefaultTableModel(
          new Object[][] {
          },
          new String[] {
              "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản", "Năm xuất bản", "Số lượng", "Giá tiền"
          }) {
        Class[] types = new Class[] {
            java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
            java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
        };

        public Class getColumnClass(int columnIndex) {
          return types[columnIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
          // all cells false
          return false;
        }
      });
      // insert value into table
      ArrayList<book> list = mod_bk.selecAll();
      DefaultTableModel bookModel = (DefaultTableModel) bookTbl.getModel();

      for (book tmp : list) {
        Theloai theLoaiTmp = The_loai_modify.getTheloai(tmp.getMaTheloai());
        NXB nxbTmp = mod_nxb.selectById(tmp.getMaNXB());
        tacgia tacgiaTmp = mod_tg.selectById(tmp.getMaSach());
        bookModel.addRow(new Object[] {
            tmp.getMaSach(), tmp.getTenSach(),
            tacgiaTmp.getTenTacgia(), theLoaiTmp.getTenTheloai(),
            nxbTmp.getTenNXB(), tmp.getNamXB(),
            tmp.getGiaTien(), tmp.getSoLuong() });
      }

      bookTbl.addMouseListener(new java.awt.event.MouseAdapter() {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          int row = bookTbl.rowAtPoint(evt.getPoint());
          int col = bookTbl.columnAtPoint(evt.getPoint());
          if (row >= 0 && col >= 0) {

            int selectedBookID = (int) bookTbl.getValueAt(bookTbl.getSelectedRow(), 0);

            book selectedBook = mod_bk.selectById(selectedBookID);
            NXB nxb_select = mod_nxb.selectById(selectedBook.getMaNXB());
            Theloai tl_select = The_loai_modify.getTheloai(selectedBook.getMaTheloai());
            tacgia tg_select = mod_tg.selectById(selectedBook.getMaSach());

            txttenSach.setText(selectedBook.getTenSach());
            cbbTheloai.setSelectedItem(nxb_select.getTenNXB());
            cbbTacgia.setSelectedItem(tg_select.getTenTacgia());
            cbbTheloai.setSelectedItem(tl_select.getTenTheloai());
            txtNamxb.setText(selectedBook.getNamXB());
            txtGiatien.setText(String.valueOf(selectedBook.getGiaTien()));
            txtSoluong.setText(String.valueOf(selectedBook.getSoLuong()));
          }
        }
      });

      scrollPaneBook.setViewportView(bookTbl);
    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }

  }

  private void showNxbList() {
    /* create table */
    JTable nxbTbl = new JTable();
    nxbTbl.setFont(new Font("Time New Roman", Font.PLAIN, 18));
    nxbTbl.getTableHeader().setFont(fo);
    /* create table */
    nxbTbl.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
        },
        new String[] {
            "Mã nxb", "Tên nxb", "Hotmail", "Hotline", "Địa chỉ"
        }) {
      Class[] types = new Class[] {
          java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class,
          java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
      }

      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    });
    /* end create table */
    // in ra danh sach nxb
    ArrayList<NXB> list = mod_nxb.selecAll();
    DefaultTableModel nxbModel = (DefaultTableModel) nxbTbl.getModel();
    for (NXB tmp : list) {

      nxbModel.addRow(new Object[] {
          tmp.getMaNXB(), tmp.getTenNXB(),
          tmp.getEmail(), tmp.getDiaChi(), tmp.getDiaChi() });
    }
    // end in ra danh sach nxb

    nxbTbl.addMouseListener(new java.awt.event.MouseAdapter() {

      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = nxbTbl.rowAtPoint(evt.getPoint());
        int col = nxbTbl.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
          int selectedNxbID = (int) nxbTbl.getValueAt(nxbTbl.getSelectedRow(), 0);
          NXB tmp = mod_nxb.selectById(selectedNxbID);
          txtTenNxb.setText(tmp.getTenNXB());
          txtMailNxb.setText(tmp.getEmail());
          txtSdtNxb.setText(tmp.getSdt());
          txtDiaChiNxb.setText(tmp.getDiaChi());
        }
      }
    });

    scrollPaneNxb.setViewportView(nxbTbl);
    setCellsAlignment(nxbTbl, SwingConstants.CENTER);

  }

  public static void setCellsAlignment(JTable table, int alignment) {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(alignment);

    TableModel tableModel = table.getModel();

    for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
      table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void stateChanged(ChangeEvent e) {
    JTabbedPane tp = (JTabbedPane) e.getSource();
    if (tp.getSelectedComponent() == detail_panel) {
      scrollPaneBook.setVisible(true);
      scrollPaneNxb.setVisible(false);
      try {
        showBookList();
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    } else if (tp.getSelectedComponent() == nxb_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(true);
      try {
        showNxbList();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

}
