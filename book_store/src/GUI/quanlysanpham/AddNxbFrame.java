package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import DTO.NhaXuatBan;

public class AddNxbFrame extends JFrame implements ActionListener {
  private int width;
  private int height;
  private InputPanel input_panel;
  private PostButtonPanel button_panel;
  private TitlePanel title_panel;

  public AddNxbFrame() {
    width = 900;
    height = 600;
    this.setLayout(new BorderLayout());
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    init();
    this.setVisible(true);
  }

  public void init() {
    String[] label_array = { "Tên nhà xuất bản", "Hotmail", "Hotline", "Địa chỉ", "Trạng thái" };
    title_panel = new TitlePanel("Thêm nhà xuất bản");
    input_panel = new InputPanel(label_array, 600, 200);
    button_panel = new PostButtonPanel(80);
    button_panel.getSavebtn().addActionListener(this);
    button_panel.getResetbtn().addActionListener(this);
    this.add(title_panel, BorderLayout.NORTH);
    this.add(input_panel, BorderLayout.WEST);
    this.add(button_panel, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    new AddNxbFrame();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button_panel.getSavebtn()) {
      if (!input_panel.checkInputNxb()) {
        return;
      }
      NhaXuatBan tmp = new NhaXuatBan();
      tmp.setTenNXB(input_panel.getTextField()[0].getText());
      tmp.setEmail(input_panel.getTextField()[1].getText());
      tmp.setSdt(input_panel.getTextField()[2].getText());
      tmp.setDiaChi(input_panel.getTextField()[3].getText());
      tmp.setTrangThai(Integer.parseInt(input_panel.getCbbField()[0].getSelectedItem().toString().split("-")[0]));
      bookFrame.nxbBUS.addNhaXuatBan(tmp);
      JOptionPane.showConfirmDialog(this, "Thêm nhà xuất bản thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
      resetForm();
    }
    if (e.getSource() == button_panel.getResetbtn()) {
      resetForm();
    }
  }

  public void resetForm() {
    for (JTextField tmp : input_panel.getTextField()) {
      tmp.setText("");
    }
  }
}
