package GUI.quanlysanpham;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import BUS.NhaXuatBanBUS;
import BUS.TacGiaBUS;
import BUS.TheLoaiBUS;
import DTO.NhaXuatBan;
import DTO.Theloai;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class InputPanel extends JPanel implements ActionListener {

  private JLabel[] labels;
  private JTextField[] textfield;
  private JButton[] buttonfield;
  private JComboBox<String>[] cbbfield;
  private int length_of_input_arr;
  private TacGiaSelectFrame selectFrame;
  private int text_field_index = 0;
  private int button_field_index = 0;
  private int cbb_field_index = 0;

  public InputPanel(String[] label_array, int width, int width_of_label) {
    this.length_of_input_arr = label_array.length;
    this.setLayout(new BorderLayout(20, 0));
    this.setBackground(Color.white);
    this.setPreferredSize(new Dimension(width, 200));

    this.add(label_panel(label_array, width_of_label), BorderLayout.WEST);
    this.add(text_panel(label_array, width - width_of_label), BorderLayout.EAST);

    this.setVisible(true);
  }

  private JPanel label_panel(String[] label_array, int width) {
    Font fo = new Font("Time New Roman", Font.BOLD, 15);
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    panel.setPreferredSize(new Dimension(width, 100));
    labels = new JLabel[label_array.length];
    for (int i = 0; i < label_array.length; i++) {
      labels[i] = new JLabel(label_array[i]);
      labels[i].setPreferredSize(new Dimension((int) (width * 0.8), 30));
      labels[i].setFont(fo);
      panel.add(labels[i]);
    }
    return panel;
  }

  private JPanel text_panel(String[] label_array, int width) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    panel.setPreferredSize(new Dimension(width, 100));
    textfield = new JTextField[label_array.length];
    buttonfield = new JButton[1];
    cbbfield = new JComboBox[3];

    for (int i = 0; i < label_array.length; i++) {
      // create button tac gia
      if (label_array[i].toLowerCase().equalsIgnoreCase("Tác giả")
          || label_array[i].toLowerCase().equalsIgnoreCase("tac gia")
          || label_array[i].toLowerCase().equalsIgnoreCase("tacgia")) {
        selectFrame = new TacGiaSelectFrame(bookFrame.tacgiaBUS.getDanhSachTacGia(), 700, 400);// init select tac gia
                                                                                               // frame
        selectFrame.setVisible(false);
        buttonfield[button_field_index] = new JButton("Chọn tác giả");
        buttonfield[button_field_index].setPreferredSize(new Dimension((int) (width * 0.7), 30));
        buttonfield[button_field_index].addActionListener(this);
        panel.add(buttonfield[button_field_index]);
        button_field_index++;
        continue;
      } else if (label_array[i].toLowerCase().equalsIgnoreCase("Thể loại")
          || label_array[i].toLowerCase().equalsIgnoreCase("theloai")
          || label_array[i].toLowerCase().equalsIgnoreCase("the loai")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (width * 0.7), 30));
        // insert data to cbb theloai
        cbbfield[cbb_field_index].removeAllItems();
        ArrayList<Theloai> data = bookFrame.tloaiBUS.getDanhSachTheLoai();
        for (Theloai tmp : data) {
          cbbfield[cbb_field_index].addItem(tmp.getMaTheloai() + "-" + tmp.getTenTheloai());
        }
        panel.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      } else if (label_array[i].toLowerCase().equalsIgnoreCase("Nhà xuất bản")
          || label_array[i].toLowerCase().equalsIgnoreCase("nhaxuatban")
          || label_array[i].toLowerCase().equalsIgnoreCase("nha xuat ban")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (width * 0.7), 30));
        // insert data to cbb nha xuat ban
        cbbfield[cbb_field_index].removeAllItems();
        ArrayList<NhaXuatBan> list = bookFrame.nxbBUS.getDanhSachNhaXuatBan();
        for (NhaXuatBan tmp : list) {
          cbbfield[cbb_field_index].addItem(tmp.getMaNXB() + "-" + tmp.getTenNXB());
        }
        panel.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      } else if (label_array[i].toLowerCase().equalsIgnoreCase("Trạng thái")
          || label_array[i].toLowerCase().equalsIgnoreCase("trangthai")
          || label_array[i].toLowerCase().equalsIgnoreCase("Trang thai")) {
        cbbfield[cbb_field_index] = new JComboBox<String>();
        cbbfield[cbb_field_index].setPreferredSize(new Dimension((int) (width * 0.7), 30));
        // insert data to cbb trang thai
        cbbfield[cbb_field_index].removeAllItems();
        cbbfield[cbb_field_index].addItem("1-HIỆN");
        cbbfield[cbb_field_index].addItem("0-ẨN");
        panel.add(cbbfield[cbb_field_index]);
        cbb_field_index++;
        continue;
      } else {
        textfield[text_field_index] = new JTextField();
        textfield[text_field_index].setPreferredSize(new Dimension((int) (width * 0.7), 30));
        panel.add(textfield[text_field_index]);
        text_field_index++;
      }
    }
    return panel;
  }

  public boolean checkInput() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(this.textfield[0].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Tên sách đang trống", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkNamXuatBan(this.textfield[1].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Năm xuất bản không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkGiaTien(this.textfield[2].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Giá tiền không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkSelectTacGia(this.selectFrame.getCheckBoxList())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Chưa chọn tác giả", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
  }

  public boolean checkInputNxb() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(this.textfield[0].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Tên nhà xuất bản đang trống", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotMail(this.textfield[1].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Hotmail không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotMailTrung(this.textfield[1].getText(), -1)) {
      JOptionPane.showConfirmDialog(this.getParent(), "Hotmail đã được sử dụng", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkHotLine(this.textfield[2].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Hotline không hợp lệ", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    if (!check.checkDiaChi(this.textfield[3].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Địa chỉ không hợp lệ", "Lỗi input !", JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
  }

  public boolean checkInputTheLoai() {
    CheckInput check = new CheckInput();
    if (!check.checkTen(this.textfield[0].getText())) {
      JOptionPane.showConfirmDialog(this.getParent(), "Tên thể loại đang trống", "Lỗi input !",
          JOptionPane.CLOSED_OPTION);
      return false;
    }
    return true;
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

  public JCheckBox[] getSelectFrameCheckBoxList() {
    return this.selectFrame.getCheckBoxList();
  }

  public int getNumberOfInput() {
    return this.length_of_input_arr;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.buttonfield[0] && !selectFrame.isVisible()) {
      selectFrame.setVisible(true);
    } else if (selectFrame.isVisible()) {
      selectFrame.toFront();
    }

  }

}
