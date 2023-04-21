package GUI.quanlysanpham;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddbookFrame extends JFrame implements ActionListener {
  public AddbookFrame(int WIDTH, int HEIGHT) {
    this.WIDTH = WIDTH;
    this.HEIGHT = HEIGHT;
    this.setLayout(new BorderLayout());
    this.setSize(WIDTH, HEIGHT);
    this.setLocation(320, 90);
    init();
    this.setVisible(true);
  }

  public void init() {
    String[] label_array = { "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Giá tiền",
        "Trạng thái" };
    title_panel = new TitlePanel("THÊM SẢN PHẨM");
    title_panel.setBackground(Color.red);
    input_panel = new InputPanel(label_array, modifyPanelWidth(this.WIDTH, 0.5), 150);
    img_panel = new ImagePanel(modifyPanelWidth(this.WIDTH, 0.5));
    post_panel = new PostButtonPanel(70);
    post_panel.getSavebtn().addActionListener(this);
    post_panel.getResetbtn().addActionListener(this);

    this.add(title_panel, BorderLayout.NORTH);
    this.add(input_panel, BorderLayout.WEST);
    this.add(img_panel, BorderLayout.EAST);
    this.add(post_panel, BorderLayout.SOUTH);
  }

  private int modifyPanelWidth(int width, double percent) {
    return (int) (width * percent);
  }

  private int WIDTH;
  private int HEIGHT;
  private TitlePanel title_panel;
  private InputPanel input_panel;
  private ImagePanel img_panel;
  private PostButtonPanel post_panel;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == post_panel.getSavebtn()) {
      if (this.input_panel.checkInput()) {// check input
        for (int i = 0; i < input_panel.getNumberOfTextField(); i++) {
          System.out.println(input_panel.getTextField()[i].getText());
        }
        for (int i = 0; i < input_panel.getNumberOfCbb(); i++) {
          System.out.println(input_panel.getCbbField()[i].getSelectedItem());
        }
        for (JCheckBox cbTmp : input_panel.getSelectFrameCheckBoxList()) {
          if (cbTmp.isSelected())
            System.out.println(cbTmp.getText());
        }
      }
    } else if (e.getSource() == post_panel.getResetbtn()) {
      System.out.println("Reset button");
    }
  }

  public static void main(String[] args) {
    new AddbookFrame(900, 600);
  }
}
