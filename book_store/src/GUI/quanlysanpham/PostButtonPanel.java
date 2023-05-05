package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import GUI.Mybutton.ResetFormButton;
import GUI.Mybutton.addbutton;

public class PostButtonPanel extends JPanel {
  public PostButtonPanel(int height) {
    this.height = height;
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
    this.setPreferredSize(new Dimension(100, this.height));
    this.setBackground(Color.red);
    init();
    this.setVisible(true);
  }

  public void init() {
    resetBtn = new ResetFormButton(150, modifyPanelHeight(this.height, 0.6));
    saveBtn = new addbutton(150, modifyPanelHeight(this.height, 0.6));

    this.add(resetBtn);
    this.add(saveBtn);

  }

  private int modifyPanelHeight(int height, double percent) {
    return (int) (height * percent);
  }

  public JButton getSavebtn() {
    return this.saveBtn;
  }

  public JButton getResetbtn() {
    return this.resetBtn;
  }

  private int height;
  private addbutton saveBtn;
  private ResetFormButton resetBtn;

}
