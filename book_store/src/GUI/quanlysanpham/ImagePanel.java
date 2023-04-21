package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
  public ImagePanel(int width) {
    this.setPreferredSize(new Dimension(width, 100));
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
    init(width);
    this.setVisible(true);
  }

  public void init(int width) {
    label_pane = new JLabel("Ảnh bìa: ");
    label_pane.setPreferredSize(new Dimension(modifyPanelWidth(width, 0.5), 30));

    img_pane = new JPanel();
    img_pane.setPreferredSize(new Dimension(modifyPanelWidth(width, 0.80), modifyPanelWidth(width, 0.80)));
    img_pane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    img_pane.setVisible(true);
    img_pane.setBackground(Color.red);
    this.add(label_pane);
    this.add(img_pane);
  }

  private int modifyPanelWidth(int width, double percent) {
    return (int) (width * percent);
  }

  private JPanel img_pane;
  private JLabel label_pane;
}
