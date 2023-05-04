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
import javax.swing.BorderFactory;
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
  private JScrollPane scrollPaneTacGia;
  private JTabbedPane tabPane;

  private JPanel book_panel;
  private ModifyButtonPanel button_panel_book;
  private JPanel nxb_panel;
  private ModifyButtonPanel button_panel_nxb;
  private JPanel tloai_panel;
  private ModifyButtonPanel button_panel_tloai;
  private JPanel tacgia_panel;
  private ModifyButtonPanel button_panel_tacgia;

  private SearchPanel search_sach_panel;
  private SearchPanel search_nhaxuatban_panel;
  private SearchPanel search_theloai_panel;
  private SearchPanel search_tacgia_panel;

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
  private JTextField txtMaTacGia;
  private JTextField txtTenTacGia;
  private JComboBox<String> cbbsearchTheloai;
  private AddbookFrame addBookFrame;
  private AddNxbFrame addNxbFrame;
  private addTheLoaiFrame addTheLoaiFrame;
  private AddTacGiaFrame addTacGiaFrame;
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
    scrollPaneTacGia = new JScrollPane();

    // init panel
    book_panel = new JPanel();
    nxb_panel = new JPanel();
    tloai_panel = new JPanel();
    tacgia_panel = new JPanel();
    search_sach_panel = new SearchPanel(new String[] { "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản" },
        1100,
        (int) Math.floor(700 * 0.1));
    search_nhaxuatban_panel = new SearchPanel(
        new String[] { "Mã nhà xuất bản", "Tên nhà xuất bản", "Hotmail", "Hotline", "Địa chỉ" }, 1100,
        (int) Math.floor(700 * 0.1));
    search_theloai_panel = new SearchPanel(
        new String[] { "Mã thể loại", "Tên thể loại" }, 1100, (int) Math.floor(700 * 0.1));
    search_tacgia_panel = new SearchPanel(
        new String[] { "Mã tác giả", "Tên tác giả" }, 1100, (int) Math.floor(700 * 0.1));

    tabPane = new JTabbedPane();
    tabPane.addChangeListener(this);

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
    txtTenTacGia = new JTextField();
    txtMaTacGia = new JTextField();
    try {

      /* set param cho text va combobox */
      /* -------- book panel --------- */
      txtMaSach.setBounds(20, 50 - 30, 300, 37);
      txtMaSach.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtMaSach.setEditable(false);
      txtMaSach.setBorder(BorderFactory.createTitledBorder("Mã sách"));
      txtMaSach.setForeground(Color.blue);

      txttenSach.setBounds(20, 100 - 30, 300, 37);
      txttenSach.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txttenSach.setBorder(BorderFactory.createTitledBorder("Tên sách"));

      cbbTheloai.setBounds(20, 150 - 30, 300, 37);
      cbbTheloai.setFont(new Font("Time New Roman", Font.PLAIN, 18));
      cbbTheloai.setBorder(BorderFactory.createTitledBorder("Thể loại"));

      selectTacgiaFrame = new TacGiaSelectFrame(tacgiaBUS.getDanhSachTacGia(), 700, 400);
      selectTacgiaFrame.setVisible(false);

      selectTacgia.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      selectTacgia.setBounds(20, 200 - 30, 300, 37);
      selectTacgia.setBorder(BorderFactory.createTitledBorder("Tác giả"));

      cbbNXB.setBounds(400, 50 - 30, 300, 37);
      cbbNXB.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      cbbNXB.setBorder(BorderFactory.createTitledBorder("Nhà xuất bản"));

      txtNamxb.setBounds(400, 100 - 30, 300, 37);
      txtNamxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtNamxb.setBorder(BorderFactory.createTitledBorder("Năm xuất bản"));

      txtSoluong.setBounds(400, 150 - 30, 300, 37);
      txtSoluong.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtSoluong.setBorder(BorderFactory.createTitledBorder("Số lượng"));
      txtSoluong.setEnabled(false);

      txtGiatien.setBounds(400, 200 - 30, 300, 37);
      txtGiatien.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtGiatien.setBorder(BorderFactory.createTitledBorder("Giá tiền"));
      /* -------- nhà xuất bản panel --------- */

      txtMaNxb.setBounds(20, 50 - 30, 300, 37);
      txtMaNxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtMaNxb.setEditable(false);
      txtMaNxb.setBorder(BorderFactory.createTitledBorder("Mã nhà xuất bản"));

      txtTenNxb.setBounds(20, 100 - 30, 300, 37);
      txtTenNxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtTenNxb.setBorder(BorderFactory.createTitledBorder("Tên nhà xuất bản"));

      txtMailNxb.setBounds(20, 150 - 30, 300, 37);
      txtMailNxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtMailNxb.setBorder(BorderFactory.createTitledBorder("Hotmail"));

      txtSdtNxb.setBounds(400, 50 - 30, 300, 37);
      txtSdtNxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtSdtNxb.setBorder(BorderFactory.createTitledBorder("Hotline"));

      txtDiaChiNxb.setBounds(400, 100 - 30, 300, 37);
      txtDiaChiNxb.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtDiaChiNxb.setBorder(BorderFactory.createTitledBorder("Địa chỉ"));

      /* -------- thể loại panel --------- */
      txtMaTheLoai.setBounds(20, 50 - 30, 300, 37);
      txtMaTheLoai.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtMaTheLoai.setBorder(BorderFactory.createTitledBorder("Mã thể loại"));
      txtMaTheLoai.setEditable(false);

      txtTenTheLoai.setBounds(20, 100 - 30, 300, 37);
      txtTenTheLoai.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtTenTheLoai.setBorder(BorderFactory.createTitledBorder("Tên thể loại"));
      /* -------- tác giả panel --------- */
      txtMaTacGia.setBounds(20, 50 - 30, 300, 37);
      txtMaTacGia.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtMaTacGia.setBorder(BorderFactory.createTitledBorder("Mã tác giả"));
      txtMaTacGia.setEditable(false);

      txtTenTacGia.setBounds(20, 100 - 30, 300, 37);
      txtTenTacGia.setFont(new Font("Time New Roman", Font.PLAIN, 16));
      txtTenTacGia.setBorder(BorderFactory.createTitledBorder("Tên tác giả"));

      tabPane.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));

      book_panel.setLayout(null);
      book_panel.setBackground(new Color(211, 242, 214));

      nxb_panel.setLayout(null);
      nxb_panel.setBackground(new Color(211, 242, 214));

      tloai_panel.setLayout(null);
      tloai_panel.setBackground(new Color(211, 242, 214));

      tacgia_panel.setLayout(null);
      tacgia_panel.setBackground(new Color(211, 242, 214));

      search_sach_panel.setBackground(new Color(50, 168, 76));
      search_sach_panel.getSearchButton().addActionListener(this);

      search_nhaxuatban_panel.setBackground(new Color(50, 168, 76));
      search_nhaxuatban_panel.setVisible(false);
      search_nhaxuatban_panel.getSearchButton().addActionListener(this);

      search_theloai_panel.setBackground(new Color(50, 168, 76));
      search_theloai_panel.setVisible(false);
      search_theloai_panel.getSearchButton().addActionListener(this);

      search_tacgia_panel.setBackground(new Color(50, 168, 76));
      search_tacgia_panel.setVisible(false);
      search_tacgia_panel.getSearchButton().addActionListener(this);

      scrollPaneBook.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));
      scrollPaneBook.setVisible(false);
      scrollPaneBook.setBackground(Color.orange);

      scrollPaneNxb.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));
      scrollPaneNxb.setVisible(false);
      scrollPaneNxb.setBackground(Color.orange);

      scrollPaneTloai.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));
      scrollPaneTloai.setVisible(false);
      scrollPaneTloai.setBackground(Color.orange);

      scrollPaneTacGia.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));
      scrollPaneTacGia.setVisible(false);
      scrollPaneTacGia.setBackground(Color.orange);

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

      button_panel_tacgia = new ModifyButtonPanel(150, 210, 800, 50);
      button_panel_tacgia.getAddBtn().addActionListener(this);
      button_panel_tacgia.getEditBtn().addActionListener(this);
      button_panel_tacgia.getDelBtn().addActionListener(this);

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

      tacgia_panel.add(txtMaTacGia);
      tacgia_panel.add(txtTenTacGia);
      tacgia_panel.add(button_panel_tacgia);

      tabPane.add("Sách", book_panel);
      tabPane.add("Nhà xuất bản", nxb_panel);
      tabPane.add("Thể loại", tloai_panel);
      tabPane.add("Tác giả", tacgia_panel);

      JPanel container = new JPanel();
      JPanel container_search = new JPanel();
      container.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.45)));
      container.add(scrollPaneBook);
      container.add(scrollPaneNxb);
      container.add(scrollPaneTloai);
      container.add(scrollPaneTacGia);

      container_search.setPreferredSize(new Dimension(1100, (int) Math.floor(700 * 0.1)));
      container_search.add(search_sach_panel);
      container_search.add(search_nhaxuatban_panel);
      container_search.add(search_theloai_panel);
      container_search.add(search_tacgia_panel);

      this.add(tabPane, BorderLayout.NORTH);
      this.add(container_search, BorderLayout.CENTER);
      this.add(container, BorderLayout.SOUTH);
      showCbbTheloai();
      showCbbNxb();
      showBookList(bookBUS.getDanhSachSanPham());
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void showCbbTheloai() {
    cbbTheloai.removeAllItems();
    for (Theloai tmp : tloaiBUS.getDanhSachTheLoai()) {
      if (tmp.getTrangThai() == 1) {
        cbbTheloai.addItem(tmp.getMaTheloai() + "-" + tmp.getTenTheloai());
      }
    }
  }

  private void showCbbNxb() {
    cbbNXB.removeAllItems();
    ArrayList<NhaXuatBan> list = nxbBUS.getDanhSachNhaXuatBan();
    for (NhaXuatBan tmp : list) {
      if (tmp.getTrangThai() == 1) {
        cbbNXB.addItem(tmp.getMaNXB() + "-" + tmp.getTenNXB());
      }
    }
  }

  private void showBookList(ArrayList<Sach> arr_sanpham) throws Exception {
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
      for (Sach tmp : arr_sanpham) {
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
            System.out.println(tl_select);
            txtMaSach.setText(String.valueOf(selectedBookID));
            txttenSach.setText(selectedBook.getTenSach());

            if (tl_select.getMaTheloai() == 0) {
              cbbTheloai.setSelectedIndex(-1);
            } else {
              cbbTheloai.setSelectedItem(tl_select.toString());
            }
            if (nxb_select.getMaNXB() == 0) {
              cbbNXB.setSelectedIndex(-1);
            } else {
              cbbNXB.setSelectedItem(nxb_select.toString());
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

  private void showNxbList(ArrayList<NhaXuatBan> arr_nxb) {
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
      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    });
    // in ra danh sach nxb
    DefaultTableModel nxbModel = (DefaultTableModel) nxbTbl.getModel();
    for (NhaXuatBan tmp : arr_nxb) {
      if (tmp.getTrangThai() == 1) {
        nxbModel.addRow(new Object[] {
            tmp.getMaNXB(), tmp.getTenNXB(),
            tmp.getEmail(), tmp.getSdt(), tmp.getDiaChi() });
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

  private void showTheLoaiList(ArrayList<Theloai> arr_theloai) {
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
    for (Theloai tmp : arr_theloai) {
      if (tmp.getTrangThai() == 1) {
        theLoaiModel.addRow(new Object[] {
            tmp.getMaTheloai(), tmp.getTenTheloai() });
      }
    }
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

  private void showTacGiaList(ArrayList<tacgia> arr_Tacgia) {
    scrollPaneTacGia.setViewportView(null);
    /* create table */
    JTable tacGiaTbl = new JTable();
    tacGiaTbl.setFont(new Font("Time New Roman", Font.PLAIN, 18));
    tacGiaTbl.getTableHeader().setFont(fo);
    /* create table */
    tacGiaTbl.setModel(new javax.swing.table.DefaultTableModel(
        new Object[][] {
        },
        new String[] {
            "Mã tác giả", "Tên tác giả"
        }) {
      @Override
      public boolean isCellEditable(int row, int column) {
        // all cells false
        return false;
      }
    });
    // in ra danh sach the loai
    DefaultTableModel tacgiaModel = (DefaultTableModel) tacGiaTbl.getModel();
    for (tacgia tmp : arr_Tacgia) {

      if (tmp.getTrangThai() == 1) {
        System.out.println(tmp.toString());
        tacgiaModel.addRow(new Object[] {
            tmp.getMaTacgia(), tmp.getTenTacgia() });
      }
    }
    tacGiaTbl.addMouseListener(new java.awt.event.MouseAdapter() {
      @Override
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        int row = tacGiaTbl.rowAtPoint(evt.getPoint());
        int col = tacGiaTbl.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
          int selectedTacGiaID = (int) tacGiaTbl.getValueAt(tacGiaTbl.getSelectedRow(), 0);
          tacgia tmp = tacgiaBUS.timTacgiaTheoMa(selectedTacGiaID);
          txtMaTacGia.setText(String.valueOf(tmp.getMaTacgia()));
          txtTenTacGia.setText(tmp.getTenTacgia());
        }
      }
    });
    scrollPaneTacGia.setViewportView(tacGiaTbl);
    setCellsAlignment(tacGiaTbl, SwingConstants.CENTER);

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

  public boolean checkInputTacGia() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(txtTenTacGia.getText())) {
      JOptionPane.showConfirmDialog(this, "Tên tác giả đang trống", "Lỗi input !",
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
        if (!addBookFrame.isVisible()) {
          addBookFrame.setVisible(true);
          addBookFrame.toFront();
        } else {
          addBookFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add frame chua khoi tao, bat dau khoi tao add frame");
        addBookFrame = new AddbookFrame(900, 600);
        addBookFrame.toFront();
      }
    }
    // click tacgia btn
    if (e.getSource() == selectTacgia) {

      selectTacgiaFrame.setVisible(true);
      return;
    }
    // click edit btn
    if (e.getSource() == button_panel_book.getEditBtn()) {

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
          showBookList(bookBUS.getDanhSachSanPham());
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
          showBookList(bookBUS.getDanhSachSanPham());
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
        if (!addNxbFrame.isVisible()) {
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
          showNxbList(nxbBUS.getDanhSachNhaXuatBan());
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
          showNxbList(nxbBUS.getDanhSachNhaXuatBan());
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
        if (!addTheLoaiFrame.isVisible()) {
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
          showTheLoaiList(tloaiBUS.getDanhSachTheLoai());
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
          showTheLoaiList(tloaiBUS.getDanhSachTheLoai());
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- tác giả panel --------------------------
     * --------------------------------------------------------------------
     */
    // them
    if (e.getSource() == button_panel_tacgia.getAddBtn()) {
      try {
        // neu isVisible hoat dong nghia la da khoi tao add frame, dem no len front
        if (!addTacGiaFrame.isVisible()) {
          addTacGiaFrame.setVisible(true);
          addTacGiaFrame.toFront();
        } else {
          addTacGiaFrame.toFront();
        }
      } catch (Exception ex) {
        System.err.println("add tác giả frame chua khoi tao, bat dau khoi tao add frame");
        addTacGiaFrame = new AddTacGiaFrame();
      }
    }
    // sua
    if (e.getSource() == button_panel_tacgia.getEditBtn()) {
      if (txtMaTacGia.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn tác giả để chỉnh sửa, hãy chọn 1 dòng trong bảng dưới. ", "Thông báo",
            JOptionPane.CLOSED_OPTION);
        return;
      }
      if (!checkInputTacGia()) {
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn lưu chỉnh sửa ?", "Lưu",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        tacgia tmp = new tacgia();
        tmp.setMaTacgia(Integer.parseInt(txtMaTacGia.getText()));
        tmp.setTenTacgia(txtTenTacGia.getText());
        tacgiaBUS.editTacGia(tmp);
        try {
          showTheLoaiList(tloaiBUS.getDanhSachTheLoai());
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    // xoa
    if (e.getSource() == button_panel_tacgia.getDelBtn()) {
      if (txtMaTheLoai.getText().equalsIgnoreCase("")) {
        JOptionPane.showConfirmDialog(this,
            "Bạn chưa chọn tác giả để xóa, hãy chọn 1 sản phẩm trong bảng dưới. ", "Thông báo",
            JOptionPane.WARNING_MESSAGE);
        return;
      }
      int confirmSave = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa tác giả này ?", "Xóa",
          JOptionPane.YES_NO_OPTION);
      if (confirmSave == JOptionPane.YES_OPTION) {
        tacgia tmp = new tacgia();
        tmp.setMaTacgia(Integer.parseInt(txtMaTacGia.getText()));
        tacgiaBUS.delTacGia(tmp);
        JOptionPane.showConfirmDialog(this, "Xóa tác giả thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
        resetForm();
        try {
          showTacGiaList(tacgiaBUS.getDanhSachTacGia());
        } catch (Exception e1) {
          e1.printStackTrace();
        }
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- search SÁCH panel --------------------------
     * --------------------------------------------------------------------
     */
    if (e.getSource() == search_sach_panel.getSearchButton()) {
      try {
        showBookList(bookBUS.searchBooks(search_sach_panel.getTextField()[0].getText(),
            search_sach_panel.getTextField()[1].getText(),
            Integer.parseInt(search_sach_panel.getCbbField()[0].getSelectedItem().toString().split("-")[0]),
            Integer.parseInt(search_sach_panel.getCbbField()[1].getSelectedItem().toString().split("-")[0]),
            Integer.parseInt(search_sach_panel.getCbbField()[2].getSelectedItem().toString().split("-")[0])));
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- search NXB panel --------------------------
     * --------------------------------------------------------------------
     */
    if (e.getSource() == search_nhaxuatban_panel.getSearchButton()) {
      try {
        showNxbList(nxbBUS.searchNhaXuatBan(search_nhaxuatban_panel.getTextField()[0].getText(),
            search_nhaxuatban_panel.getTextField()[1].getText(),
            search_nhaxuatban_panel.getTextField()[2].getText(),
            search_nhaxuatban_panel.getTextField()[3].getText(),
            search_nhaxuatban_panel.getTextField()[4].getText()));
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- search Thể loại panel --------------------------
     * --------------------------------------------------------------------
     */
    if (e.getSource() == search_theloai_panel.getSearchButton()) {
      try {
        showTheLoaiList(tloaiBUS.searchTheLoai(search_theloai_panel.getTextField()[0].getText(),
            search_theloai_panel.getTextField()[1].getText()));
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
    /*
     * --------------------------------------------------------------------
     * ---------------------- search tác giả panel --------------------------
     * --------------------------------------------------------------------
     */
    if (e.getSource() == search_tacgia_panel.getSearchButton()) {
      try {
        showTacGiaList(tacgiaBUS.searchtacgia(search_tacgia_panel.getTextField()[0].getText(),
            search_tacgia_panel.getTextField()[1].getText()));
      } catch (NumberFormatException e1) {
        e1.printStackTrace();
      } catch (Exception e1) {
        e1.printStackTrace();
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
      scrollPaneTacGia.setVisible(false);

      search_sach_panel.setVisible(true);
      search_nhaxuatban_panel.setVisible(false);
      search_theloai_panel.setVisible(false);
      search_tacgia_panel.setVisible(false);

      try {
        showBookList(bookBUS.getDanhSachSanPham());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (tp.getSelectedComponent() == nxb_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(true);
      scrollPaneTloai.setVisible(false);
      scrollPaneTacGia.setVisible(false);

      search_sach_panel.setVisible(false);
      search_nhaxuatban_panel.setVisible(true);
      search_theloai_panel.setVisible(false);
      search_tacgia_panel.setVisible(false);
      try {
        showNxbList(nxbBUS.getDanhSachNhaXuatBan());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (tabPane.getSelectedComponent() == tloai_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(false);
      scrollPaneTloai.setVisible(true);
      scrollPaneTacGia.setVisible(false);

      search_sach_panel.setVisible(false);
      search_nhaxuatban_panel.setVisible(false);
      search_theloai_panel.setVisible(true);
      search_tacgia_panel.setVisible(false);
      try {
        showTheLoaiList(tloaiBUS.getDanhSachTheLoai());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    } else if (tabPane.getSelectedComponent() == tacgia_panel) {
      scrollPaneBook.setVisible(false);
      scrollPaneNxb.setVisible(false);
      scrollPaneTloai.setVisible(false);
      scrollPaneTacGia.setVisible(true);

      search_sach_panel.setVisible(false);
      search_nhaxuatban_panel.setVisible(false);
      search_theloai_panel.setVisible(false);
      search_tacgia_panel.setVisible(true);
      try {
        // System.out.println(tacgiaBUS.getDanhSachTacGia().size());
        showTacGiaList(tacgiaBUS.getDanhSachTacGia());
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
