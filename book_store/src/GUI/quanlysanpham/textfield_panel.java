package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.danhsachkhachhang;

public class textfield_panel extends JPanel {
  public textfield_panel(int width) {
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    this.setPreferredSize(new Dimension(width, 100));
    this.setBackground(Color.green);
    init();
    this.setVisible(true);
  }

  public init(){

  }

  private JTextField[] textfield;
}
