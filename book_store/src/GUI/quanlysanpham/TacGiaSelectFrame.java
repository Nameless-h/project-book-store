package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import DTO.tacgia;

public class TacGiaSelectFrame extends JFrame {
  private int HEIGHT;
  private int WIDTH;
  private JCheckBox[] checkBox_tacgia;
  private int checkbox_index = 0;

  public TacGiaSelectFrame(ArrayList<tacgia> array_tac_gia, int width, int height) {
    super("Tác giả");
    this.HEIGHT = height;
    this.WIDTH = width;
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
    this.setSize(WIDTH, HEIGHT);
    this.setLocationRelativeTo(null);
    init(array_tac_gia);
    this.setVisible(true);
  }

  public void init(ArrayList<tacgia> array_tac_gia) {
    Font fo = new Font("Time new roman", Font.BOLD, 14);
    checkBox_tacgia = new JCheckBox[array_tac_gia.size()];
    JPanel tacgia_container = new JPanel();
    tacgia_container.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
    tacgia_container.setPreferredSize(new Dimension(this.WIDTH, 900));
    for (int i = 0; i < array_tac_gia.size(); i++) {
      if (array_tac_gia.get(i).getTrangThai() == 1) {
        checkBox_tacgia[checkbox_index] = new JCheckBox(
            array_tac_gia.get(i).getMaTacgia() + "-" + array_tac_gia.get(i).getTenTacgia());
        checkBox_tacgia[checkbox_index].setPreferredSize(new Dimension(200, 50));
        checkBox_tacgia[checkbox_index].setFont(fo);
        tacgia_container.add(checkBox_tacgia[i]);
        checkbox_index++;
      }
    }

    JScrollPane container = new JScrollPane(tacgia_container);
    JScrollBar verticalScrollBar = container.getVerticalScrollBar();
    verticalScrollBar.setUnitIncrement(10); // Tăng tốc độ lăn lên 10 pixel mỗi lần
    container.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    this.getContentPane().add(container);
  }

  public JCheckBox[] getCheckBoxList() {
    return this.checkBox_tacgia;
  }

  public int getNumberOfCheckBox() {
    return this.checkbox_index;
  }

  public static void main(String[] args) {

  }

}
