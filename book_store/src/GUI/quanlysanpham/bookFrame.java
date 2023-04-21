package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.ArrayList;
import DTO.Theloai;

import javax.print.event.PrintServiceAttributeEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BUS.NhaXuatBanBUS;
import BUS.SanPhamBUS;
import BUS.TacGiaBUS;
import BUS.TheLoaiBUS;
import DTO.NhaXuatBan;
import DTO.Theloai;
import DTO.Sach;
import DTO.tacgia;

public class bookFrame extends JPanel implements ActionListener, ChangeListener {
  Font fo = new Font("Time New Roman", Font.BOLD, 20);
  Font searchFo = new Font("Time New Roman", Font.PLAIN, 15);
  SanPhamBUS bookBUS = new SanPhamBUS();
  NhaXuatBanBUS nxbBUS = new NhaXuatBanBUS();
  TacGiaBUS tacgiaBUS = new TacGiaBUS();
  TheLoaiBUS tloaiBUS = new TheLoaiBUS();

  public bookFrame() {
    this.setLayout(new BorderLayout());
    bookBUS.listSanPham();
    nxbBUS.listNhaXuatBan();
    tacgiaBUS.listTacGia();
    tloaiBUS.listTheLoai();

    init();
    this.setVisible(true);
  }

  public void init() {
    // create table
    scrollPaneBook = new JScrollPane();
    scrollPaneNxb = new JScrollPane();
    // init panel
    book_panel = new JPanel();
    nxb_panel = new JPanel();
    search_Panel = new JPanel();
    tabPane = new JTabbedPane();
    tabPane.addChangeListener(this);
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
        book_panel.add(book_detail_labels[i]);
        posY += 50;
      } else {
        book_detail_labels[i] = new JLabel(book_info_label[i]);
        book_detail_labels[i].setBounds(550, posY2 - 30, 200, 25);
        book_detail_labels[i].setFont(fo);
        book_panel.add(book_detail_labels[i]);
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
      // tabPane.setBounds(0, 0, 1100, (int) Math.floor(700 * 0.52));
      tabPane.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.52)));
      book_panel.setLayout(null);
      book_panel.setBackground(new Color(211, 242, 214));

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
      button_panel = new ModifyButtonPanel(150, 250, 800, 50);
      button_panel.getAddBtn().addActionListener(this);
      button_panel.getEditBtn().addActionListener(this);
      button_panel.getDelBtn().addActionListener(this);

      book_panel.add(txttenSach);
      book_panel.add(cbbTheloai);
      book_panel.add(cbbTacgia);
      book_panel.add(cbbNXB);
      book_panel.add(txtNamxb);
      book_panel.add(txtSoluong);
      book_panel.add(txtGiatien);
      book_panel.add(button_panel);

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

      tabPane.add("sách", book_panel);
      tabPane.add("nhà xuất bản", nxb_panel);

      this.add(tabPane, BorderLayout.NORTH);

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
  private JPanel book_panel;
  private ModifyButtonPanel button_panel;
  private JPanel nxb_panel;
  private JPanel search_Panel;
  private JTabbedPane tabPane;
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
  private AddbookFrame addFrame;
  // End of variables declaration

  private void showCbbTheloai() {
    cbbTheloai.removeAllItems();
    ArrayList<Theloai> data = tloaiBUS.getDanhTheloaiTheLoai();
    for (Theloai tmp : data) {
      cbbTheloai.addItem(tmp.getTenTheloai());
      cbbsearchTheloai.addItem(tmp.getTenTheloai());
    }
  }

  private void showCbbNxb() {
    cbbNXB.removeAllItems();
    ArrayList<NhaXuatBan> list = nxbBUS.getDanhSachNhaXuatBan();
    for (NhaXuatBan tmp : list) {
      cbbNXB.addItem(tmp.getTenNXB());
    }
    cbbNXB.setEnabled(true);
  }

  private void showCbbTacgia() {
    cbbTacgia.removeAllItems();
    ArrayList<tacgia> list = tacgiaBUS.getDanhSachTacGia();
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
      ArrayList<Sach> list = bookBUS.getDanhSachSanPham();
      DefaultTableModel bookModel = (DefaultTableModel) bookTbl.getModel();

      for (Sach tmp : list) {
        Theloai theLoaiTmp = tloaiBUS.timTheLoaiTheoMa(tmp.getMaTheloai());
        NhaXuatBan nxbTmp = nxbBUS.timNhaXuatBanTheoMa(tmp.getMaNXB());
        tacgia tacgiaTmp = tacgiaBUS.timTacgiaTheoMaSach(tmp.getMaSach());
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

            Sach selectedBook = bookBUS.timTheLoaiTheoMa(selectedBookID);
            NhaXuatBan nxb_select = nxbBUS.timNhaXuatBanTheoMa(selectedBook.getMaNXB());
            Theloai tl_select = tloaiBUS.timTheLoaiTheoMa(selectedBook.getMaTheloai());
            tacgia tg_select = tacgiaBUS.timTacgiaTheoMa(selectedBook.getMaSach());

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
    ArrayList<NhaXuatBan> list = nxbBUS.getDanhSachNhaXuatBan();
    DefaultTableModel nxbModel = (DefaultTableModel) nxbTbl.getModel();
    for (NhaXuatBan tmp : list) {

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
          NhaXuatBan tmp = nxbBUS.timNhaXuatBanTheoMa(selectedNxbID);
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
    if (e.getSource() == button_panel.getAddBtn()) {
      try {
        // neu isVisible hoat dong nghia la da khoi tao add frame, dem no len front
        if (!addFrame.isDisplayable()) {
          addFrame.setVisible(true);
          addFrame.toFront();
        } else {
          addFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add frame chua khoi tao, bat dau khoi tao add frame");
        addFrame = new AddbookFrame(900, 600);

      }
    }
    if (e.getSource() == button_panel.getEditBtn()) {
      System.out.println("edit book click");
      return;
    }
    if (e.getSource() == button_panel.getDelBtn()) {

      System.out.println("delete book click");
      return;
    }
  }

  // tabbedpane event
  @Override
  public void stateChanged(ChangeEvent e) {
    JTabbedPane tp = (JTabbedPane) e.getSource();
    if (tp.getSelectedComponent() == book_panel) {
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
