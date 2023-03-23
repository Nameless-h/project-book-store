package book_detail;

import java.awt.Color;
import java.awt.Font;
import java.lang.Math;
import java.util.ArrayList;
import the_loai.*;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import NXB.NXB;
import NXB.nxb_modify;

public class bookFrame {
  Font fo = new Font("Time New Roman", Font.BOLD, 20);
  Font searchFo = new Font("Time New Roman", Font.PLAIN, 15);

  public bookFrame() {
    init();
  }

  public void init() {
    fr = new JFrame("book frame");
    // create table
    scrollPaneBook = new JScrollPane();
    scrollPaneNxb = new JScrollPane();

    // init panel
    detail_panel = new JPanel();
    nxb_panel = new JPanel();
    search_Panel = new JPanel();
    button_panel = new JPanel();
    // init label
    tenSach = new JLabel();
    theLoai = new JLabel();
    tacGia = new JLabel();
    NXB = new JLabel();
    namXB = new JLabel();
    soLuong = new JLabel();
    giaTien = new JLabel();
    tenNxb = new JLabel("Tên nxb:");
    mailNxb = new JLabel("Hotmail:");
    sdtNxb = new JLabel("Hotline: ");
    diaChiNxb = new JLabel("Địa chỉ: ");
    searchTen = new JLabel("Tên sách");
    searchTheloai = new JLabel("Thể loại");
    searchTacgia = new JLabel("Tác giả");
    // init text field
    txttenSach = new JTextField();
    txtTacgia = new JTextField();
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

    // init button
    saveBtn = new JButton("Lưu");
    nxbBtn = new JButton("NXB");
    nxbBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          switchToNxb();
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });
    sanPhamBtn = new JButton("Sản phẩm");

    sanPhamBtn.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        try {
          switchToSanpham();
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    });

    try {
      tenSach.setText("Tên sách: ");
      theLoai.setText("Thể loại: ");
      tacGia.setText("Tác giả: ");
      NXB.setText("Nhà xuất bản: ");
      namXB.setText("Năm xuất bản : ");
      soLuong.setText("Số lượng: ");
      giaTien.setText("Giá tiền: ");

      /* set param cho label */
      tenSach.setBounds(20, 50 - 30, 200, 25);
      tenSach.setFont(fo);

      theLoai.setBounds(20, 100 - 30, 200, 25);
      theLoai.setFont(fo);

      tacGia.setBounds(20, 150 - 30, 200, 25);
      tacGia.setFont(fo);

      NXB.setBounds(20, 200 - 30, 200, 25);
      NXB.setFont(fo);

      namXB.setBounds(20, 250 - 30, 200, 25);
      namXB.setFont(fo);

      soLuong.setBounds(20, 300 - 30, 200, 25);
      soLuong.setFont(fo);

      giaTien.setBounds(20, 350 - 30, 200, 25);
      giaTien.setFont(fo);

      tenNxb.setBounds(20, 50 - 30, 200, 25);
      tenNxb.setFont(fo);

      mailNxb.setBounds(20, 100 - 30, 200, 25);
      mailNxb.setFont(fo);

      sdtNxb.setBounds(20, 150 - 30, 200, 25);
      sdtNxb.setFont(fo);

      diaChiNxb.setBounds(20, 200 - 30, 200, 25);
      diaChiNxb.setFont(fo);

      searchTen.setBounds(10, 5, 70, 30);
      searchTen.setFont(searchFo);

      searchTheloai.setBounds(300, 5, 70, 30);
      searchTheloai.setFont(searchFo);

      searchTacgia.setBounds(500, 5, 70, 30);
      searchTacgia.setFont(searchFo);
      /* set param cho text va combobox */

      txttenSach.setBounds(200, 50 - 30, 350, 25);
      txttenSach.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbTheloai.setBounds(200, 100 - 30, 350, 25);
      cbbTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtTacgia.setBounds(200, 150 - 30, 350, 25);
      txtTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbNXB.setBounds(200, 200 - 30, 350, 25);
      cbbNXB.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtNamxb.setBounds(200, 250 - 30, 350, 25);
      txtNamxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtGiatien.setBounds(200, 300 - 30, 350, 25);
      txtGiatien.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtSoluong.setBounds(200, 350 - 30, 350, 25);
      txtSoluong.setFont(new Font("Time New Roman", Font.PLAIN, 20));

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
      button_panel.setBounds(0, 0, 1070, (int) Math.floor(800 * 0.05));
      button_panel.setLayout(null);
      button_panel.setBackground(new Color(19, 105, 36));
      saveBtn.setBounds(50, 8, 100, 25);
      nxbBtn.setBounds(200, 8, 100, 25);
      sanPhamBtn.setBounds(350, 8, 100, 25);

      detail_panel.setBounds(0, (int) Math.floor(800 * 0.05), 1070, (int) Math.floor(800 * 0.47));
      detail_panel.setLayout(null);
      detail_panel.setBackground(new Color(211, 242, 214));

      nxb_panel.setBounds(0, (int) Math.floor(800 * 0.05), 1070, (int) Math.floor(800 * 0.47));
      nxb_panel.setLayout(null);
      nxb_panel.setBackground(new Color(211, 242, 214));
      nxb_panel.setVisible(false);

      search_Panel.setBounds(0, (int) Math.floor(800 * 0.52), 1070, (int) Math.floor(800 * 0.05));
      search_Panel.setLayout(null);
      search_Panel.setBackground(new Color(50, 168, 76));

      scrollPaneBook.setBounds(0, (int) Math.floor(800 * 0.57), 1070, (int) Math.floor(800 * 0.43));
      scrollPaneBook.setVisible(true);
      scrollPaneBook.setBackground(Color.orange);

      scrollPaneNxb.setBounds(0, (int) Math.floor(800 * 0.57), 1070, (int) Math.floor(800 * 0.43));
      scrollPaneNxb.setVisible(false);
      scrollPaneNxb.setBackground(Color.orange);

      /* add component */
      detail_panel.add(tenSach);
      detail_panel.add(txttenSach);
      detail_panel.add(theLoai);
      detail_panel.add(cbbTheloai);
      detail_panel.add(tacGia);
      detail_panel.add(txtTacgia);
      detail_panel.add(NXB);
      detail_panel.add(cbbNXB);
      detail_panel.add(namXB);
      detail_panel.add(txtNamxb);
      detail_panel.add(soLuong);
      detail_panel.add(txtSoluong);
      detail_panel.add(giaTien);
      detail_panel.add(txtGiatien);

      nxb_panel.add(tenNxb);
      nxb_panel.add(mailNxb);
      nxb_panel.add(sdtNxb);
      nxb_panel.add(diaChiNxb);
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

      button_panel.add(saveBtn);
      button_panel.add(nxbBtn);
      button_panel.add(sanPhamBtn);

      fr.add(detail_panel);
      fr.add(nxb_panel);
      fr.add(button_panel);
      fr.getContentPane().add(scrollPaneBook);
      fr.getContentPane().add(scrollPaneNxb);
      fr.add(search_Panel);
      fr.setLayout(null);
      fr.setLocation(250, 20);
      fr.setSize(1070, 800);
      fr.setVisible(true);
      fr.getContentPane().setBackground(Color.BLUE);

      showCbbTheloai();
      showCbbNxb();
      showBookList();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("error" + e);
    }

  }

  public static void main(String[] args) {
    bookFrame fr = new bookFrame();
  }

  // Variables declaration - do not modify
  private JScrollPane scrollPaneBook;
  private JScrollPane scrollPaneNxb;
  private JFrame fr;
  private JPanel detail_panel;
  private JPanel nxb_panel;
  private JPanel search_Panel;
  private JPanel button_panel;
  private JLabel tenSach;
  private JLabel theLoai;
  private JLabel tacGia;
  private JLabel NXB;
  private JLabel namXB;
  private JLabel soLuong;
  private JLabel giaTien;
  private JLabel tenNxb;
  private JLabel mailNxb;
  private JLabel sdtNxb;
  private JLabel diaChiNxb;
  private JLabel searchTen;
  private JLabel searchTheloai;
  private JLabel searchTacgia;
  private JTextField txttenSach;
  private JTextField txtTacgia;
  private JComboBox<String> cbbTheloai;
  private JButton saveBtn;
  private JButton nxbBtn;
  private JTextField txtNamxb;
  private JTextField txtSoluong;
  private JTextField txtGiatien;
  private JComboBox<String> cbbNXB;
  private JButton sanPhamBtn;
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
    cbbsearchTheloai.removeAllItems();
    ArrayList<Theloai> data = The_loai_modify.allCate();
    for (Theloai tmp : data) {
      cbbTheloai.addItem(tmp.getTenTheloai());
      cbbsearchTheloai.addItem(tmp.getTenTheloai());
    }
  }

  private void showCbbNxb() {
    cbbNXB.removeAllItems();
    ArrayList<NXB> list = nxb_modify.allNXB();
    for (NXB tmp : list) {
      cbbNXB.addItem(tmp.getTenNXB());
    }
    cbbNXB.setEnabled(true);
  }

  private void switchToNxb() throws Exception {
    detail_panel.setVisible(false);
    nxb_panel.setVisible(true);

    scrollPaneBook.setVisible(false);
    scrollPaneNxb.setVisible(true);
    showNxbList();

  }

  private void switchToSanpham() throws Exception {
    nxb_panel.setVisible(false);
    detail_panel.setVisible(true);

    scrollPaneBook.setVisible(true);
    scrollPaneNxb.setVisible(false);

    showBookList();

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
      /* end create table */
      ArrayList<book> list = book_modify.allBook();
      DefaultTableModel bookModel = (DefaultTableModel) bookTbl.getModel();

      for (book tmp : list) {
        Theloai theLoaiTmp = The_loai_modify.getTheloai(tmp.getMaTheloai());
        NXB nxbTmp = nxb_modify.getNXB(tmp.getMaNXB());

        bookModel.addRow(new Object[] {
            tmp.getMaSach(), tmp.getTenSach(),
            tmp.gettacGia(), theLoaiTmp.getTenTheloai(),
            nxbTmp.getTenNXB(), tmp.getNamXB(),
            tmp.getGiaTien(), tmp.getSoLuong() });
      }
      // set event khi click vao san pham

      /*
       * bookTbl.getSelectionModel().addListSelectionListener(new
       * ListSelectionListener() {
       * // xu ly event khi click vao san pham
       * public void valueChanged(ListSelectionEvent evt) {
       * 
       * 
       * int selectedBookID = (int) bookTbl.getValueAt(bookTbl.getSelectedRow(), 0);
       * book selectedBook = book_modify.getbook(selectedBookID);
       * 
       * txttenSach.setText(selectedBook.getTenSach());
       * // cbbTheloai.setText(selectedBook.the_loai());
       * txtTacgia.setText(selectedBook.getTenSach());
       * // cbbNXB.setText(selectedBook.getTenSach());
       * txtNamxb.setText(selectedBook.getTenSach());
       * txtGiatien.setText(selectedBook.getTenSach());
       * txtSoluong.setText(selectedBook.getTenSach());
       * 
       * System.out.println("hello book");
       * }
       * 
       * });
       */

      bookTbl.addMouseListener(new java.awt.event.MouseAdapter() {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          int row = bookTbl.rowAtPoint(evt.getPoint());
          int col = bookTbl.columnAtPoint(evt.getPoint());
          if (row >= 0 && col >= 0) {

            int selectedBookID = (int) bookTbl.getValueAt(bookTbl.getSelectedRow(), 0);
            System.out.println(selectedBookID);

            book selectedBook = book_modify.getbook(selectedBookID);

            txttenSach.setText(selectedBook.getTenSach());
            // cbbTheloai.setText(selectedBook.the_loai());
            txtTacgia.setText(selectedBook.getTenSach());
            // cbbNXB.setText(selectedBook.getTenSach());
            txtNamxb.setText(selectedBook.getTenSach());
            txtGiatien.setText(selectedBook.getTenSach());
            txtSoluong.setText(selectedBook.getTenSach());

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
    ArrayList<NXB> list = nxb_modify.allNXB();
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
          System.out.println("hello");

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
}
