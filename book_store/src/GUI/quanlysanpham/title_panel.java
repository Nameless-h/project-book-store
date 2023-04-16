package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class title_panel extends JPanel {
  public title_panel(String title) {
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 19));
    this.setBackground(Color.blue);
    this.setPreferredSize(new Dimension(200, 50));

    init(title);
    this.setVisible(true);
  }

  public void init(String title) {
    this.title = new JLabel(title);
    this.add(this.title);

  }

  private JLabel title;

}
