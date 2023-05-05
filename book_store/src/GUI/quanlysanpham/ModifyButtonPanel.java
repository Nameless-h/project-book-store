package GUI.quanlysanpham;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;

public class ModifyButtonPanel extends JPanel {
  private addbutton addBtn;
  private editbutton editBtn;
  private deletebutton delBtn;

  public ModifyButtonPanel(float posX, float posY, float width, float height) {
    addBtn = new addbutton((int) (width * 0.2), (int) (height * 0.6));
    editBtn = new editbutton((int) (width * 0.2), (int) (height * 0.6));
    delBtn = new deletebutton((int) (width * 0.2), (int) (height * 0.6));
    this.setBackground(new Color(242, 225, 226));
    this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    this.setLayout(new FlowLayout(FlowLayout.CENTER, 30, (int) (height * 0.23)));
    this.add(addBtn);
    this.add(editBtn);
    this.add(delBtn);
    this.setVisible(true);
  }

  public ModifyButtonPanel(float posX, float posY, float width, float height, float horizonGap, float verticalGap) {
    addBtn = new addbutton((int) (width * 0.2), (int) (height * 0.6));
    editBtn = new editbutton((int) (width * 0.2), (int) (height * 0.6));
    delBtn = new deletebutton((int) (width * 0.2), (int) (height * 0.6));
    this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    this.setLayout(new FlowLayout(FlowLayout.CENTER, (int) horizonGap, (int) verticalGap));
    this.add(addBtn);
    this.add(editBtn);
    this.add(delBtn);
    this.setVisible(true);
  }

  public JButton getAddBtn() {
    return this.addBtn;
  }

  public JButton getEditBtn() {
    return this.editBtn;
  }

  public JButton getDelBtn() {
    return this.delBtn;
  }
}
