package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DTO.tacgia;

public class AddTacGiaFrame extends JFrame implements ActionListener {
  private int width;
  private int height;
  private InputPanel input_panel;
  private PostButtonPanel button_panel;
  private TitlePanel title_panel;

  public AddTacGiaFrame() {
    width = 500;
    height = 300;
    this.setLayout(new BorderLayout());
    this.setSize(width, height);
    this.setLocationRelativeTo(null);
    init();
    this.setVisible(true);
  }

  public void init() {
    String[] label_array = { "Tên tác giả" };
    title_panel = new TitlePanel("Thêm tác giả");
    input_panel = new InputPanel(label_array, 400, 220);
    button_panel = new PostButtonPanel(80);
    button_panel.getSavebtn().addActionListener(this);
    button_panel.getResetbtn().addActionListener(this);
    this.add(title_panel, BorderLayout.NORTH);
    this.add(input_panel, BorderLayout.WEST);
    this.add(button_panel, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    new addTheLoaiFrame();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == button_panel.getSavebtn()) {
      if (!input_panel.checkInputTheLoai()) {
        return;
      }
      tacgia tmp = new tacgia();
      tmp.setTenTacgia(input_panel.getTextField()[0].getText());
      tmp.setTrangThai(1);
      bookFrame.tacgiaBUS.addTacGia(tmp);
      JOptionPane.showConfirmDialog(this, "Thêm tác giả thành công", "Thông báo !", JOptionPane.CLOSED_OPTION);
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
