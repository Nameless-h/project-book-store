package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {
  public TitlePanel(String title) {
    Font fo = new Font("Time New Roman", Font.BOLD, 25);
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
    this.setBackground(Color.blue);
    this.setPreferredSize(new Dimension(100, 30));
    init(title, fo);
    this.setVisible(true);
  }

  public void init(String title, Font font) {
    this.title = new JLabel(title);
    this.title.setFont(font);
    this.add(this.title);

  }

  private JLabel title;

}
