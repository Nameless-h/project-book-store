package GUI.Mybutton;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ResetFormButton extends JButton {
  public ResetFormButton() {
    this.setText("Xóa hết");
    this.setIcon(new ImageIcon(this.getClass().getResource("../../icons8-reset-30.png")));
  }

  public ResetFormButton(float width, float height) {
    this.setText("Xóa hết");
    this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-reset-30.png")));
    this.setPreferredSize(new Dimension((int) width, (int) height));
  }

  public ResetFormButton(float posX, float posY, float width, float height) {
    this.setText("Xóa hết");
    this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-reset-30.png")));
    this.setBounds((int) posX, (int) posY, (int) width, (int) height);
  }

}
