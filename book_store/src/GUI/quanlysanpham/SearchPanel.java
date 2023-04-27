package GUI.quanlysanpham;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.NhaXuatBan;
import DTO.Theloai;
import DTO.tacgia;
import GUI.Mybutton.searchbutton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.rmi.ConnectIOException;
import java.util.ArrayList;

public class SearchPanel extends JPanel {
  private int WIDTH;
  private int HEIGHT;

  private JLabel[] labels;
  private JTextField[] textfield;
  private JComboBox<String>[] cbbfield;
  private JButton searchBtn;
  private int text_field_index = 0;
  private int button_field_index = 0;
  private int cbb_field_index = 0;

  public SearchPanel(String[] label_array, int width, int height) {
    this.WIDTH = width;
    this.HEIGHT = height;
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    init(label_array);
    this.setVisible(true);
  }

  public void init(String[] label_array) {
    Font fo = new Font("Time New Roman", Font.BOLD, 15);
    labels = new JLabel[label_array.length];
    textfield = new JTextField[label_array.length];
    cbbfield = new JComboBox[3];
    for (int i = 0; i < label_array.length; i++) {
      labels[i] = new JLabel(label_array[i]);
      labels[i].setPreferredSize(new Dimension((int) (WIDTH * 0.07), 30));
      labels[i].setFont(fo);
      this.add(labels[i]);
      if (label_array[i].toLowerCase().equalsIgnoreCase("Thể loại")
          || label_array[i].toLowerCase().equalsIgnoreCase("theloai")
          || label_array[i].toLowerCase().equalsIgnoreCase("the loai")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (WIDTH * 0.1), 30));
        // insert data to cbb theloai
        cbbfield[cbb_field_index].removeAllItems();
        for (Theloai tmp : bookFrame.tloaiBUS.getDanhSachTheLoai()) {
          cbbfield[cbb_field_index].addItem(tmp.getMaTheloai() + "-" + tmp.getTenTheloai());
        }
        this.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      } else if (label_array[i].toLowerCase().equalsIgnoreCase("Nhà xuất bản")
          || label_array[i].toLowerCase().equalsIgnoreCase("nhaxuatban")
          || label_array[i].toLowerCase().equalsIgnoreCase("nha xuat ban")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (WIDTH * 0.1), 30));
        // insert data to cbb nha xuat ban
        cbbfield[cbb_field_index].removeAllItems();
        for (NhaXuatBan tmp : bookFrame.nxbBUS.getDanhSachNhaXuatBan()) {
          cbbfield[cbb_field_index].addItem(tmp.getMaNXB() + "-" + tmp.getTenNXB());
        }
        this.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      }
      if (label_array[i].toLowerCase().equalsIgnoreCase("Tác giả")
          || label_array[i].toLowerCase().equalsIgnoreCase("tac gia")
          || label_array[i].toLowerCase().equalsIgnoreCase("tacgia")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (WIDTH * 0.15), 30));
        // insert data to cbb nha xuat ban
        cbbfield[cbb_field_index].removeAllItems();
        for (tacgia tmp : bookFrame.tacgiaBUS.getDanhSachTacGia()) {
          cbbfield[cbb_field_index].addItem(tmp.getMaTacgia() + "-" + tmp.getTenTacgia());
        }
        this.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      } else {
        textfield[text_field_index] = new JTextField();
        textfield[text_field_index].setPreferredSize(new Dimension((int) (WIDTH * 0.15), 30));
        this.add(textfield[text_field_index]);
        text_field_index++;
        continue;
      }
    }
    this.add(searchButton());
  }

  private JButton searchButton() {
    searchBtn = new JButton();
    searchBtn.setText("Tìm");
    searchBtn.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-search-30.png")));
    searchBtn.setPreferredSize(new Dimension(100, 30));
    return searchBtn;
  }

  public static void main(String[] args) {
    bookFrame.bookBUS.listSanPham();
    bookFrame.nxbBUS.listNhaXuatBan();
    bookFrame.tacgiaBUS.listTacGia();
    bookFrame.tloaiBUS.listTheLoai();
    bookFrame.cttgBUS.listChiTietTacGia();
    JFrame fr = new JFrame();
    String[] labels = { "Tên sách", "Tác giả", "Thể loại", "Nhà xuất bản" };

    SearchPanel panel = new SearchPanel(labels, 1000, 200);
    panel.setBackground(Color.red);
    fr.setSize(1000, 400);
    fr.setLayout(new FlowLayout());
    fr.add(panel);
    fr.setVisible(true);
  }

  public JLabel[] getLabels() {

    return this.labels;
  }

  public JTextField[] getTextField() {
    return this.textfield;
  }

  public int getNumberOfTextField() {
    return this.text_field_index;
  }

  public JComboBox<String>[] getCbbField() {
    return this.cbbfield;
  }

  public int getNumberOfCbb() {
    return this.cbb_field_index;
  }

  public JButton getSearchButton() {
    return this.searchBtn;
  }
}
