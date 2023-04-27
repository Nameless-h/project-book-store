package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.ArrayList;
import DTO.Theloai;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import BUS.ChiTietTacGiaBUS;
import BUS.NhaXuatBanBUS;
import BUS.SanPhamBUS;
import BUS.TacGiaBUS;
import BUS.TheLoaiBUS;
import DTO.ChiTietTacGia;
import DTO.NhaXuatBan;
import DTO.Theloai;
import DTO.Sach;
import DTO.tacgia;

public class bookFrame extends JPanel implements ActionListener, ChangeListener {
  // Variables declaration - do not modify
  private JScrollPane scrollPaneBook;
  private JScrollPane scrollPaneNxb;
  private JScrollPane scrollPaneTloai;

  private JPanel book_panel;
  private ModifyButtonPanel button_panel_book;
  private JPanel nxb_panel;
  private ModifyButtonPanel button_panel_nxb;
  private JPanel tloai_panel;
  private ModifyButtonPanel button_panel_tloai;

  private SearchPanel search_Panel;

  private JTabbedPane tabPane;
  private JLabel[] book_detail_labels;
  private JLabel[] nxb_detail_labels;
  private JLabel[] tloai_detail_labels;
  private JLabel searchTen;
  private JLabel searchTheloai;
  private JLabel searchTacgia;
  private JButton selectTacgia;
  private TacGiaSelectFrame selectTacgiaFrame;
  private JComboBox<String> cbbTheloai;
  private JTextField txtMaSach;
  private JTextField txttenSach;
  private JTextField txtNamxb;
  private JTextField txtSoluong;
  private JTextField txtGiatien;
  private JComboBox<String> cbbNXB;
  private JTextField txtMaNxb;
  private JTextField txtTenNxb;
  private JTextField txtMailNxb;
  private JTextField txtSdtNxb;
  private JTextField txtDiaChiNxb;
  private JTextField txtMaTheLoai;
  private JTextField txtTenTheLoai;
  private JTextField txtsearchTen;
  private JComboBox<String> cbbsearchTheloai;
  private JTextField txtsearchTacgia;
  private AddbookFrame addBookFrame;
  private AddNxbFrame addNxbFrame;
  private addTheLoaiFrame addTheLoaiFrame;
  public static SanPhamBUS bookBUS = new SanPhamBUS();
  public static NhaXuatBanBUS nxbBUS = new NhaXuatBanBUS();
  public static TacGiaBUS tacgiaBUS = new TacGiaBUS();
  public static TheLoaiBUS tloaiBUS = new TheLoaiBUS();
  public static ChiTietTacGiaBUS cttgBUS = new ChiTietTacGiaBUS();
  // End of variables declaration

  Font fo = new Font("Time New Roman", Font.BOLD, 20);
  Font searchFo = new Font("Time New Roman", Font.PLAIN, 15);

  public bookFrame() {
    this.setLayout(new BorderLayout());
    bookBUS.listSanPham();
    nxbBUS.listNhaXuatBan();
    tacgiaBUS.listTacGia();
    tloaiBUS.listTheLoai();
    cttgBUS.listChiTietTacGia();
    init();
    this.setVisible(true);
  }

  public void init() {
    // create table
    scrollPaneBook = new JScrollPane();
    scrollPaneNxb = new JScrollPane();
    scrollPaneTloai = new JScrollPane();
    // init panel
    book_panel = new JPanel();
    nxb_panel = new JPanel();
    tloai_panel = new JPanel();
    search_Panel = new SearchPanel(new String[] { "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản" }, 1100,
        (int) Math.floor(700 * 0.1));
    tabPane = new JTabbedPane();
    tabPane.addChangeListener(this);
    // init label of book info
    String[] book_info_label = { "Mã sách: ", "Tên sách: ", "Thể loại: ", "Tác giả: ", "Nhà xuất bản: ",
        "Năm xuất bản : ",
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
    String[] nxb_info_label = { "Mã NXB: ", "Tên nxb:", "Hotmail:", "Hotline:", "Địa chỉ:" };
    nxb_detail_labels = new JLabel[nxb_info_label.length];
    posY = 50;
    posY2 = 50;
    for (int i = 0; i < nxb_info_label.length; i++) {
      if (i < 3) {
        nxb_detail_labels[i] = new JLabel(nxb_info_label[i]);
        nxb_detail_labels[i].setBounds(20, posY - 30, 200, 25);
        nxb_detail_labels[i].setFont(fo);
        nxb_panel.add(nxb_detail_labels[i]);
        posY += 50;
      } else {
        nxb_detail_labels[i] = new JLabel(nxb_info_label[i]);
        nxb_detail_labels[i].setBounds(550, posY2 - 30, 200, 25);
        nxb_detail_labels[i].setFont(fo);
        nxb_panel.add(nxb_detail_labels[i]);
        posY2 += 50;
      }
    }

    // init label of the loai info
    String[] theloai_info_label = { "Mã thể loại: ", "Tên thể loại:" };
    tloai_detail_labels = new JLabel[nxb_info_label.length];
    posY = 50;
    posY2 = 50;
    for (int i = 0; i < theloai_info_label.length; i++) {
      if (i < 3) {
        tloai_detail_labels[i] = new JLabel(theloai_info_label[i]);
        tloai_detail_labels[i].setBounds(20, posY - 30, 200, 25);
        tloai_detail_labels[i].setFont(fo);
        tloai_panel.add(tloai_detail_labels[i]);
        posY += 50;
      } else {
        tloai_detail_labels[i] = new JLabel(theloai_info_label[i]);
        tloai_detail_labels[i].setBounds(550, posY2 - 30, 200, 25);
        tloai_detail_labels[i].setFont(fo);
        tloai_panel.add(tloai_detail_labels[i]);
        posY2 += 50;
      }

    }

    searchTen = new JLabel("Tên sách");
    searchTheloai = new JLabel("Thể loại");
    searchTacgia = new JLabel("Tác giả");
    // init text field
    txtMaSach = new JTextField();
    txttenSach = new JTextField();
    selectTacgia = new JButton("Chọn tác giả");
    selectTacgia.addActionListener(this);
    cbbTheloai = new JComboBox<String>();
    cbbNXB = new JComboBox<String>();
    txtNamxb = new JTextField();
    txtSoluong = new JTextField();
    txtGiatien = new JTextField();
    txtMaNxb = new JTextField();
    txtTenNxb = new JTextField();
    txtMailNxb = new JTextField();
    txtSdtNxb = new JTextField();
    txtDiaChiNxb = new JTextField();

    txtTenTheLoai = new JTextField();
    txtMaTheLoai = new JTextField();

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
      txtMaSach.setBounds(200, 50 - 30, 300, 25);
      txtMaSach.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      txtMaSach.setEditable(false);

      txttenSach.setBounds(200, 100 - 30, 300, 25);
      txttenSach.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbTheloai.setBounds(200, 150 - 30, 300, 25);
      cbbTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      selectTacgiaFrame = new TacGiaSelectFrame(tacgiaBUS.getDanhSachTacGia(), 700, 400);
      selectTacgiaFrame.setVisible(false);

      selectTacgia.setBounds(200, 200 - 30, 300, 25);
      selectTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      cbbNXB.setBounds(750, 50 - 30, 300, 25);
      cbbNXB.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtNamxb.setBounds(750, 100 - 30, 300, 25);
      txtNamxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtSoluong.setBounds(750, 150 - 30, 300, 25);
      txtSoluong.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      txtSoluong.setEnabled(false);

      txtGiatien.setBounds(750, 200 - 30, 300, 25);
      txtGiatien.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      /* -------- book panel --------- */

      txtMaNxb.setBounds(200, 50 - 30, 300, 25);
      txtMaNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      txtMaNxb.setEditable(false);

      txtTenNxb.setBounds(200, 100 - 30, 300, 25);
      txtTenNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtMailNxb.setBounds(200, 150 - 30, 300, 25);
      txtMailNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtSdtNxb.setBounds(750, 50 - 30, 300, 25);
      txtSdtNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtDiaChiNxb.setBounds(750, 100 - 30, 300, 25);
      txtDiaChiNxb.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtMaTheLoai.setBounds(200, 50 - 30, 300, 25);
      txtMaTheLoai.setFont(new Font("Time New Roman", Font.PLAIN, 20));
      txtMaTheLoai.setEditable(false);

      txtTenTheLoai.setBounds(200, 100 - 30, 300, 25);
      txtTenTheLoai.setFont(new Font("Time New Roman", Font.PLAIN, 20));

      txtsearchTen.setBounds(80, 5, 200, 25);
      txtsearchTen.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      cbbsearchTheloai.setBounds(370, 5, 100, 25);
      cbbsearchTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      txtsearchTacgia.setBounds(570, 5, 200, 25);
      txtsearchTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 15));

      tabPane.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));

      book_panel.setLayout(null);
      book_panel.setBackground(new Color(211, 242, 214));

      nxb_panel.setLayout(null);
      nxb_panel.setBackground(new Color(211, 242, 214));

      tloai_panel.setLayout(null);
      tloai_panel.setBackground(new Color(211, 242, 214));

      search_Panel.setBackground(new Color(50, 168, 76));
      search_Panel.getSearchButton().addActionListener(this);

      scrollPaneBook.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.41)));
      scrollPaneBook.setVisible(false);
      scrollPaneBook.setBackground(Color.orange);

      scrollPaneNxb.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.41)));
      scrollPaneNxb.setVisible(false);
      scrollPaneNxb.setBackground(Color.orange);

      scrollPaneTloai.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.41)));
      scrollPaneTloai.setVisible(true);
      scrollPaneTloai.setBackground(Color.orange);

      button_panel_book = new ModifyButtonPanel(150, 210, 800, 50);
      button_panel_book.getAddBtn().addActionListener(this);
      button_panel_book.getEditBtn().addActionListener(this);
      button_panel_book.getDelBtn().addActionListener(this);

      button_panel_nxb = new ModifyButtonPanel(150, 210, 800, 50);
      button_panel_nxb.getAddBtn().addActionListener(this);
      button_panel_nxb.getEditBtn().addActionListener(this);
      button_panel_nxb.getDelBtn().addActionListener(this);

      button_panel_tloai = new ModifyButtonPanel(150, 210, 800, 50);
      button_panel_tloai.getAddBtn().addActionListener(this);
      button_panel_tloai.getEditBtn().addActionListener(this);
      button_panel_tloai.getDelBtn().addActionListener(this);

      /* add component */
      book_panel.add(txtMaSach);
      book_panel.add(txttenSach);
      book_panel.add(cbbTheloai);
      book_panel.add(selectTacgia);
      book_panel.add(cbbNXB);
      book_panel.add(txtNamxb);
      book_panel.add(txtSoluong);
      book_panel.add(txtGiatien);
      book_panel.add(button_panel_book);

      nxb_panel.add(txtMaNxb);
      nxb_panel.add(txtTenNxb);
      nxb_panel.add(txtMailNxb);
      nxb_panel.add(txtSdtNxb);
      nxb_panel.add(txtDiaChiNxb);
      nxb_panel.add(button_panel_nxb);

      tloai_panel.add(txtMaTheLoai);
      tloai_panel.add(txtTenTheLoai);
      tloai_panel.add(button_panel_tloai);

      tabPane.add("Sách", book_panel);
      tabPane.add("Nhà xuất bản", nxb_panel);
      tabPane.add("Thể loại", tloai_panel);

      JPanel container = new JPanel();
      container.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.43)));
      container.add(scrollPaneBook);
      container.add(scrollPaneNxb);
      container.add(scrollPaneTloai);
      this.add(tabPane, BorderLayout.NORTH);
      this.add(search_Panel, BorderLayout.CENTER);
      this.add(container, BorderLayout.SOUTH);
      showCbbTheloai();
      showCbbNxb();
      showBookList();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void showCbbTheloai() {
    cbbTheloai.removeAllItems();
    for (Theloai tmp : tloaiBUS.getDanhSachTheLoai()) {
      cbbTheloai.addItem(tmp.getMaTheloai() + "-" + tmp.getTenTheloai());
      cbbsearchTheloai.addItem(tmp.getMaTheloai() + "-" + tmp.getTenTheloai());
    }

  }

  private void showCbbNxb() {
    cbbNXB.removeAllItems();
    ArrayList<NhaXuatBan> list = nxbBUS.getDanhSachNhaXuatBan();
    for (NhaXuatBan tmp : list) {
      cbbNXB.addItem(tmp.getMaNXB() + "-" + tmp.getTenNXB());
    }

  }

  private void showBookList() throws Exception {
    scrollPaneBook.setViewportView(null);
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
        @Override
        public boolean isCellEditable(int row, int column) {
          // all cells false
          return false;
        }
      });
      // insert value into table
      DefaultTableModel bookModel = (DefaultTableModel) bookTbl.getModel();
      for (Sach tmp : bookBUS.getDanhSachSanPham()) {
        if (tmp.getTrangThai() == 1) {
          Theloai theLoaiTmp = tloaiBUS.timTheLoaiTheoMa(tmp.getMaTheloai());
          NhaXuatBan nxbTmp = nxbBUS.timNhaXuatBanTheoMa(tmp.getMaNXB());
          tacgia tacgiaTmp = tacgiaBUS.timTacgiaTheoMaSach(tmp.getMaSach());
          bookModel.addRow(new Object[] {
              tmp.getMaSach(), tmp.getTenSach(),
              tacgiaTmp.getTenTacgia(), theLoaiTmp.getTenTheloai(),
              nxbTmp.getTenNXB(), tmp.getNamXB(),
              tmp.getGiaTien(), tmp.getSoLuong() });
        }
      }

      bookTbl.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
          int row = bookTbl.rowAtPoint(evt.getPoint());
          int col = bookTbl.columnAtPoint(evt.getPoint());
          if (row >= 0 && col >= 0) {

            int selectedBookID = (int) bookTbl.getValueAt(bookTbl.getSelectedRow(), 0);
            Sach selectedBook = bookBUS.timSachTheoMa(selectedBookID);
            NhaXuatBan nxb_select = nxbBUS.timNhaXuatBanTheoMa(selectedBook.getMaNXB());
            Theloai tl_select = tloaiBUS.timTheLoaiTheoMa(selectedBook.getMaTheloai());
            txtMaSach.setText(String.valueOf(selectedBookID));
            txttenSach.setText(selectedBook.getTenSach());

            if (tl_select.getMaTheloai() == 0) {
              cbbTheloai.setSelectedIndex(-1);
            } else {
              cbbTheloai.setSelectedItem(tl_select);
            }
            if (nxb_select.getMaNXB() == 0) {
              cbbNXB.setSelectedIndex(-1);
            } else {
              cbbNXB.setSelectedItem(tl_select);
            }

            // clear checkbox tac gia
            for (JCheckBox tmp2 : selectTacgiaFrame.getCheckBoxList()) {
              tmp2.setSelected(false);
            }
            // checked checkbox tac gia
            for (int tmp : cttgBUS.timTacGiaTheoMaSach(selectedBookID)) {
              for (JCheckBox tmp2 : selectTacgiaFrame.getCheckBoxList()) {
                if (Integer.parseInt(tmp2.getText().split("-")[0]) == tmp) {
                  tmp2.setSelected(true);
                }
              }
            }
            cbbTheloai.setSelectedItem(tl_select.getTenTheloai());
            txtNamxb.setText(selectedBook.getNamXB());
            txtGiatien.setText(String.valueOf(selectedBook.getGiaTien()));
            txtSoluong.setText(String.valueOf(selectedBook.getSoLuong()));
          }
        }
      });

      scrollPaneBook.setViewportView(bookTbl);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void showNxbList() {
    scrollPaneNxb.setViewportView(null);
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
      /*
       * Class[] types = new Class[] {
       * java.lang.Integer.class, java.lang.String.class, java.lang.String.class,
       * java.lang.String.class,
       * java.lang.String.class
       * };
       * 
       * public Class getColumnClass(int columnIndex) {
       * return types[columnIndex];
       * }
       */
      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    });
    // in ra danh sach nxb
    ArrayList<NhaXuatBan> list = nxbBUS.getDanhSachNhaXuatBan();
    DefaultTableModel nxbModel = (DefaultTableModel) nxbTbl.getModel();
    for (NhaXuatBan tmp : list) {
      if (tmp.getTrangThai() == 1) {
        nxbModel.addRow(new Object[] {
            tmp.getMaNXB(), tmp.getTenNXB(),
            tmp.getEmail(), tmp.getDiaChi(), tmp.getDiaChi() });
      }
    }
    nxbTbl.addMouseListener(new java.awt.event.MouseAdapter() {

      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = nxbTbl.rowAtPoint(evt.getPoint());
        int col = nxbTbl.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
          int selectedNxbID = (int) nxbTbl.getValueAt(nxbTbl.getSelectedRow(), 0);
          NhaXuatBan tmp = nxbBUS.timNhaXuatBanTheoMa(selectedNxbID);
          txtMaNxb.setText(String.valueOf(tmp.getMaNXB()));
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

  private void showTheLoaiList() {
    scrollPaneTloai.setViewportView(null);
    /* create table */
    JTable tLoaiTbl = new JTable();
    tLoaiTbl.setFont(new Font("Time New Roman", Font.PLAIN, 18));
    tLoaiTbl.getTableHeader().setFont(fo);
    /* create table */
    tLoaiTbl.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
        },
        new String[] {
            "Mã thể loại", "Tên thể loại"
        }) {
      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    });
    // in ra danh sach the loai
    DefaultTableModel theLoaiModel = (DefaultTableModel) tLoaiTbl.getModel();
    for (Theloai tmp : tloaiBUS.getDanhSachTheLoai()) {
      // System.out.println(tmp.getTrangThai());
      if (tmp.getTrangThai() == 1) {
        theLoaiModel.addRow(new Object[] {
            tmp.getMaTheloai(), tmp.getTenTheloai() });
      }
    }
    /*
     * for (NhaXuatBan tmp : list) {
     * if (tmp.getTrangThai() == 1) {
     * nxbModel.addRow(new Object[] {
     * tmp.getMaNXB(), tmp.getTenNXB(),
     * tmp.getEmail(), tmp.getDiaChi(), tmp.getDiaChi() });
     * }
     * }
     */
    tLoaiTbl.addMouseListener(new java.awt.event.MouseAdapter() {

      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tLoaiTbl.rowAtPoint(evt.getPoint());
        int col = tLoaiTbl.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
          int selectedTloaiID = (int) tLoaiTbl.getValueAt(tLoaiTbl.getSelectedRow(), 0);
          Theloai tmp = tloaiBUS.timTheLoaiTheoMa(selectedTloaiID);
          txtMaTheLoai.setText(String.valueOf(tmp.getMaTheloai()));
          txtTenTheLoai.setText(tmp.getTenTheloai());
        }
      }
    });
    scrollPaneTloai.setViewportView(tLoaiTbl);
    setCellsAlignment(tLoaiTbl, SwingConstants.CENTER);

  }

  public static void setCellsAlignment(JTable table, int alignment) {
    DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
    rightRenderer.setHorizontalAlignment(alignment);

    TableModel tableModel = table.getModel();

    for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
      table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
    }
  }

  private void resetForm() {

    txtMaNxb.setText("");
    txtMaSach.setText("");
    txtMailNxb.setText("");
    txtDiaChiNxb.setText("");
    txtSdtNxb.setText("");
    txtTenNxb.setText("");
    txtMaSach.setText("");
    txttenSach.setText("");
    txtGiatien.setText("");
    txtNamxb.setText("");
    txtSoluong.setText("");
    cbbNXB.setSelectedIndex(0);
    cbbTheloai.setSelectedIndex(0);
    for (JCheckBox tmp : selectTacgiaFrame.getCheckBoxList()) {
      if (tmp.isSelected()) {
        tmp.setSelected(false);
      }
    }
  }

  private boolean checkInputSach() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(txttenSach.getText())) {
      JOptionPane.showConfirmDialog(this, "Tên sách đang trống", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkNamXuatBan(txtNamxb.getText())) {
      JOptionPane.showConfirmDialog(this, "Năm xuất bản không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkGiaTien(txtGiatien.getText())) {
      JOptionPane.showConfirmDialog(this, "Giá tiền không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkSelectTacGia(selectTacgiaFrame.getCheckBoxList())) {
      JOptionPane.showConfirmDialog(this, "Chưa chọn tác giả", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
  }

  public boolean checkInputNxb() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(txtTenNxb.getText())) {
      JOptionPane.showConfirmDialog(this, "Tên nhà xuất bản đang trống", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotMail(txtMailNxb.getText())) {
      JOptionPane.showConfirmDialog(this, "Hotmail không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotMailTrung(txtMailNxb.getText(), Integer.parseInt(txtMaNxb.getText()))) {
      JOptionPane.showConfirmDialog(this, "Hotmail đã được sử dụng", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotLine(txtSdtNxb.getText())) {
      JOptionPane.showConfirmDialog(this, "Hotline không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkDiaChi(txtDiaChiNxb.getText())) {
      JOptionPane.showConfirmDialog(this, "Địa chỉ không hợp lệ", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
  }

  public boolean checkInputTloai() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(txtTenTheLoai.getText())) {
      JOptionPane.showConfirmDialog(this, "Tên thể loại đang trống", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    /*
     * --------------------------------------------------------------------
     * ---------------------- sách panel --------------------------
     * --------------------------------------------------------------------
     */

    if (e.getSource() == button_panel_book.getAddBtn()) {
      try {
        // neu isVisible hoat dong nghia la da khoi tao add frame, dem no len front
        if (!addBookFrame.isDisplayable()) {
          addBookFrame.setVisible(true);
          addBookFrame.toFront();
        } else {
          addBookFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add frame chua khoi tao, bat dau khoi tao add frame");
        addBookFrame = new AddbookFrame(900, 600);
      }
    }
    // click tacgia btn
    if (e.getSource() == selectTacgia) {
      System.out.println("select tacgia");
      selectTacgiaFrame.setVisible(true);
      return;
    }
    // click edit btn
    if (e.getSource() == button_panel_book.getEditBtn()) {
      System.out.println("edit book click");
      if (txtMaSach.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn sản phẩm để chỉnh sửa, hãy chọn 1 sản phẩm trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      // check input
      if (!checkInputSach()) {
        return;
      }
      if (cbbTheloai.getSelectedIndex() == -1) {
        JOptionPane.showConfirmDialog(this, "Chọn thể loại ", "Thông báo", JOptionPane.CLOSED_OPTION);
        return;
      }
      if (cbbNXB.getSelectedIndex() == -1) {
        JOptionPane.showConfirmDialog(this, "Chọn nhà xuất bản ", "Thông báo", JOptionPane.CLOSED_OPTION);
        return;
      }

      // edit sach
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu chỉnh sửa ?", "Lưu",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        Sach tmp = new Sach();
        tmp.setMaSach(Integer.parseInt(txtMaSach.getText()));
        tmp.setTenSach(txttenSach.getText());
        tmp.setMaNXB(Integer.parseInt(cbbNXB.getSelectedItem().toString().split("-")[0]));
        tmp.setMaTheloai(Integer.parseInt(cbbTheloai.getSelectedItem().toString().split("-")[0]));
        tmp.setNamXB(txtNamxb.getText());
        tmp.setGiaTien(Integer.parseInt(txtGiatien.getText()));
        tmp.setSoLuong(Integer.parseInt(txtSoluong.getText()));
        tmp.setTrangThai(1);
        bookBUS.editSanPham(tmp);
        cttgBUS.delAllCTTGCoMaSach(Integer.parseInt(txtMaSach.getText()));// clear tac gia cu

        for (JCheckBox tmp2 : selectTacgiaFrame.getCheckBoxList()) {
          if (tmp2.isSelected()) {
            ChiTietTacGia cttgTmp = new ChiTietTacGia(Integer.parseInt(txtMaSach.getText()),
                Integer.parseInt(tmp2.getText().split("-")[0]));
            cttgBUS.addChiTietTacGia(cttgTmp);
          }
        }

        try {
          System.out.println(bookBUS.timSachTheoMa(21).toString());
          showBookList();
          resetForm();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
      return;
    }
    // delete btn
    if (e.getSource() == button_panel_book.getDelBtn()) {
      if (txtMaSach.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn sản phẩm để xóa, hãy chọn 1 sản phẩm trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này ?", "Xóa",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        Sach tmp = new Sach();
        tmp.setMaSach(Integer.parseInt(txtMaSach.getText()));
        bookBUS.delSanPham(tmp);
        JOptionPane.showConfirmDialog(this, "Xóa sách thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
        resetForm();
        try {
          showBookList();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }

    /*
     * --------------------------------------------------------------------
     * ---------------------- nhà xuất bản panel --------------------------
     * --------------------------------------------------------------------
     */
    // them
    if (e.getSource() == button_panel_nxb.getAddBtn()) {
      try {
        // neu isVisible hoat dong nghia la da khoi tao add frame, dem no len front
        if (!addNxbFrame.isDisplayable()) {
          addNxbFrame.setVisible(true);
          addNxbFrame.toFront();
        } else {
          addNxbFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add nxb frame chua khoi tao, bat dau khoi tao add frame");
        addNxbFrame = new AddNxbFrame();
      }
    }
    // sua
    if (e.getSource() == button_panel_nxb.getEditBtn()) {
      if (txtMaNxb.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn nhà xuất bản để chỉnh sửa, hãy chọn 1 dòng trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      if (!checkInputNxb()) {
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu chỉnh sửa ?", "Lưu",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        NhaXuatBan tmp = new NhaXuatBan();
        tmp.setMaNXB(Integer.parseInt(txtMaNxb.getText()));
        tmp.setEmail(txtMailNxb.getText());
        tmp.setSdt(txtSdtNxb.getText());
        tmp.setTenNXB(txtTenNxb.getText());
        tmp.setDiaChi(txtDiaChiNxb.getText());
        nxbBUS.editNhaXuatBan(tmp);
        try {
          showNxbList();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    // xoa
    if (e.getSource() == button_panel_nxb.getDelBtn()) {
      if (txtMaNxb.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn sản phẩm để xóa, hãy chọn 1 sản phẩm trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này ?", "Xóa",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        NhaXuatBan tmp = new NhaXuatBan();
        tmp.setMaNXB(Integer.parseInt(txtMaNxb.getText()));
        nxbBUS.delNhaXuatBan(tmp);
        JOptionPane.showConfirmDialog(this, "Xóa sách thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
        resetForm();
        try {
          showNxbList();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- thể loại panel --------------------------
     * --------------------------------------------------------------------
     */
    // them
    if (e.getSource() == button_panel_tloai.getAddBtn()) {
      try {
        // neu isVisible hoat dong nghia la da khoi tao add frame, dem no len front
        if (!addTheLoaiFrame.isDisplayable()) {
          addTheLoaiFrame.setVisible(true);
          addTheLoaiFrame.toFront();
        } else {
          addTheLoaiFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add the loai frame chua khoi tao, bat dau khoi tao add frame");
        addTheLoaiFrame = new addTheLoaiFrame();
      }
    }
    // sua
    if (e.getSource() == button_panel_tloai.getEditBtn()) {
      if (txtMaTheLoai.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn thể loại để chỉnh sửa, hãy chọn 1 dòng trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      if (!checkInputTloai()) {
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu chỉnh sửa ?", "Lưu",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        Theloai tmp = new Theloai();
        tmp.setMaTheloai(Integer.parseInt(txtMaTheLoai.getText()));
        tmp.setTenTheloai(txtTenTheLoai.getText());
        tloaiBUS.editTheLoai(tmp);
        try {
          showTheLoaiList();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    // xoa
    if (e.getSource() == button_panel_tloai.getDelBtn()) {
      if (txtMaTheLoai.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn sản phẩm để xóa, hãy chọn 1 sản phẩm trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa sản phẩm này ?", "Xóa",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        Theloai tmp = new Theloai();
        tmp.setMaTheloai(Integer.parseInt(txtMaTheLoai.getText()));
        tloaiBUS.delTheLoai(tmp);
        JOptionPane.showConfirmDialog(this, "Xóa sách thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
        resetForm();
        try {
          showTheLoaiList();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
  }

  // tabbedpane event
  @Override
  public void stateChanged(ChangeEvent e) {
    JTabbedPane tp = (JTabbedPane) e.getSource();
    if (tp.getSelectedComponent() == book_panel) {
      scrollPaneBook.setVisible(true);
      scrollPaneNxb.setVisible(false);
      scrollPaneTloai.setVisible(false);
      try {
        showBookList();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (tp.getSelectedComponent() == nxb_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(true);
      scrollPaneTloai.setVisible(false);
      try {
        showNxbList();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (tabPane.getSelectedComponent() == tloai_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(false);
      scrollPaneTloai.setVisible(true);
      try {
        showTheLoaiList();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
