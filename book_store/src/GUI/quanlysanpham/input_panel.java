package GUI.quanlysanpham;

import javax.naming.directory.NoSuchAttributeException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class input_panel extends JPanel {
  public input_panel(String[] label_array, int width, int width_of_label) {
    this.setLayout(new BorderLayout(20, 0));
    this.setBackground(Color.white);
    this.setPreferredSize(new Dimension(width, 200));

    this.add(label_panel(label_array, width_of_label), BorderLayout.WEST);
    this.add(text_panel(label_array.length, width - width_of_label), BorderLayout.EAST);

    this.setVisible(true);
  }

  public void init() {

  }

  private JPanel label_panel(String[] label_array, int width) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    panel.setPreferredSize(new Dimension(width, 100));
    labels = new JLabel[label_array.length];
    for (int i = 0; i < label_array.length; i++) {
      labels[i] = new JLabel(label_array[i]);
      labels[i].setPreferredSize(new Dimension((int) (width * 0.6), 30));
      panel.add(labels[i]);
    }
    return panel;
  }

  private JPanel text_panel(int length, int width) {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    panel.setPreferredSize(new Dimension(width, 100));
    textfield = new JTextField[length];
    for (int i = 0; i < length; i++) {
      textfield[i] = new JTextField();
      textfield[i].setPreferredSize(new Dimension((int) (width * 0.6), 30));
      panel.add(textfield[i]);
    }
    return panel;
  }

  private JLabel[] labels;
  private JTextField[] textfield;
}
