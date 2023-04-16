package GUI.quanlysanpham;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;
import java.security.PrivilegedAction;

public class AddbookFrame extends JFrame {
  public AddbookFrame() {
    this.setBackground(Color.RED);
    this.setLayout(new BorderLayout());
    this.setSize(900, 600);
    init();
    this.setVisible(true);
  }

  public void init() {
    title_pane = new title_panel("THÊM SẢN PHẨM");
    title_pane.setBackground(Color.red);

    String[] label_array = { "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Giá tiền",
        "Trạng thái" };

    input_panel = new input_panel(label_array, 500, 150);

    this.add(title_pane, BorderLayout.NORTH);
    this.add(input_panel, BorderLayout.WEST);
  }

  public static void main(String[] args) {
    new AddbookFrame();
  }

  private title_panel title_pane;
  private input_panel input_panel;
}
