package GUI.quanlysanpham;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.loading.PrivateClassLoader;
import javax.naming.InitialContext;
import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;

public class WarningFrame extends JPanel {
  public WarningFrame(String content) {
    this.setLayout(new BorderLayout(10, 10));
    this.setSize(250, 150);
    init(content);
    this.setVisible(true);
  }

  public void init(String content) {
    // init content
    Font fo = new Font("Time New Roman", Font.BOLD, 15);
    JPanel labelContainer = new JPanel();
    labelContainer.setPreferredSize(new Dimension(100, 100));
    labelContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 0));
    this.content = new JLabel(content);
    this.content.setPreferredSize(new Dimension(100, 50));
    this.content.setHorizontalAlignment(JLabel.CENTER);
    this.content.setFont(fo);
    labelContainer.add(this.content);
    // init button
    JPanel btnContainer = new JPanel();
    btnContainer.setPreferredSize(new Dimension(100, 60));
    btnContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    this.confirmBtn = new JButton("Chấp nhận");
    this.confirmBtn.setPreferredSize(new Dimension(100, 60));
    btnContainer.add(confirmBtn);
    // add to frame
    this.add(labelContainer, BorderLayout.CENTER);
    this.add(btnContainer, BorderLayout.SOUTH);

  }

  public JButton getConfirmBtn() {
    return this.confirmBtn;
  }

  private JLabel content;
  private JButton confirmBtn;

  /*
   * public void actionPerformed(ActionEvent e) {
   * if (e.getSource() == this.confirmBtn) {
   * this.setVisible(false);
   * }
   * }
   */
}
