package GUI.quanlysanpham;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import BUS.ChiTietTacGiaBUS;
import DAO.SanPhamDAO;
import DTO.ChiTietTacGia;
import DTO.Sach;
import DTO.Theloai;
import DTO.tacgia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddbookFrame extends JFrame implements ActionListener {

  private int WIDTH;
  private int HEIGHT;
  private TitlePanel title_panel;
  private InputPanel input_panel;

  private PostButtonPanel post_panel;

  public PostButtonPanel getPostPanel() {
    return this.post_panel;
  }

  public AddbookFrame(int WIDTH, int HEIGHT) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.setLayout(new BorderLayout());
    this.setSize(this.WIDTH, this.HEIGHT);
    this.setLocationRelativeTo(null);
    init();
    this.setVisible(true);
  }

  public void init() {
    String[] label_array = { "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Giá tiền",
        "Trạng thái" };
    title_panel = new TitlePanel("THÊM SẢN PHẨM");
    title_panel.setBackground(Color.red);
    input_panel = new InputPanel(label_array, modifyPanelWidth(this.WIDTH, 0.5), 150);
    post_panel = new PostButtonPanel(70);
    post_panel.getSavebtn().addActionListener(this);
    post_panel.getResetbtn().addActionListener(this);

    this.add(title_panel, BorderLayout.NORTH);
    this.add(input_panel, BorderLayout.WEST);
    this.add(post_panel, BorderLayout.SOUTH);
  }

  private int modifyPanelWidth(int width, double percent) {
    return (int) (width * percent);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == post_panel.getSavebtn()) {
      if (this.input_panel.checkInput()) {// check input
        Sach sachMoi = new Sach();
        sachMoi.setTenSach(input_panel.getTextField()[0].getText());
        sachMoi.setNamXB(input_panel.getTextField()[1].getText());
        sachMoi.setGiaTien(Integer.parseInt(input_panel.getTextField()[2].getText()));
        sachMoi.setSoLuong(0);

        String[] tmp = input_panel.getCbbField()[0].getSelectedItem().toString().split("-");
        int matheloai = Integer.parseInt(tmp[0]);
        String[] tmp2 = input_panel.getCbbField()[1].getSelectedItem().toString().split("-");
        int manxb = Integer.parseInt(tmp2[0]);
        String[] tmp3 = input_panel.getCbbField()[2].getSelectedItem().toString().split("-");
        int trangThai = Integer.parseInt(tmp3[0]);
        sachMoi.setMaTheloai(matheloai);
        sachMoi.setMaNXB(manxb);
        sachMoi.setTrangThai(trangThai);

        bookFrame.bookBUS.addSanPham(sachMoi);
        int maSachMoiThem = bookFrame.bookBUS.getLastInsertId();
        for (JCheckBox cbTmp : input_panel.getSelectFrameCheckBoxList()) {
          if (cbTmp.isSelected()) {
            String[] tmp4 = cbTmp.getText().split("-");
            int maTacgia = Integer.parseInt(tmp4[0]);
            ChiTietTacGia cttg = new ChiTietTacGia(maSachMoiThem, maTacgia);
            bookFrame.cttgBUS.addChiTietTacGia(cttg);
          }
        }
        JOptionPane.showConfirmDialog(this, "Thêm sách thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
        resetForm();
      }

    } else if (e.getSource() == post_panel.getResetbtn()) {
      System.out.println("Reset button");
      resetForm();
    }
  }

  private void resetForm() {
    input_panel.getTextField()[0].setText("");
    input_panel.getTextField()[1].setText("");
    input_panel.getTextField()[2].setText("");
    input_panel.getCbbField()[0].setSelectedIndex(0);
    input_panel.getCbbField()[1].setSelectedIndex(0);
    input_panel.getCbbField()[2].setSelectedIndex(0);
    for (JCheckBox tmp : input_panel.getSelectFrameCheckBoxList()) {
      if (tmp.isSelected()) {
        tmp.setSelected(false);
      }
    }
  }
}
