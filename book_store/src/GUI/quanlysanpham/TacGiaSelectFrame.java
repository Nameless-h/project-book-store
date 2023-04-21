package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;

import DTO.tacgia;

public class TacGiaSelectFrame extends JFrame {
  private JCheckBox[] checkBox_tacgia;

  public TacGiaSelectFrame(ArrayList<tacgia> array_tac_gia) {
    super("Tác giả");
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));
    this.setSize(500, 400);
    this.setLocationRelativeTo(null);
    init(array_tac_gia);
    this.setVisible(true);
  }

  public void init(ArrayList<tacgia> array_tac_gia) {
    Font fo = new Font("Time new roman", Font.BOLD, 14);
    checkBox_tacgia = new JCheckBox[array_tac_gia.size()];
    for (int i = 0; i < array_tac_gia.size(); i++) {
      checkBox_tacgia[i] = new JCheckBox(
          array_tac_gia.get(i).getMaTacgia() + "-" + array_tac_gia.get(i).getTenTacgia());
      checkBox_tacgia[i].setPreferredSize(new Dimension(200, 50));
      checkBox_tacgia[i].setFont(fo);
      this.add(checkBox_tacgia[i]);
    }
  }

  public JCheckBox[] getCheckBoxList() {
    return this.checkBox_tacgia;
  }

  public static void main(String[] args) {

  }

}
