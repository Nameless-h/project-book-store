package GUI.Mybutton;

import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class addbutton extends JButton {
    public addbutton() {
        this.setText("Add");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
    }

    public addbutton(float width, float height) {
        this.setText("Add");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
        this.setPreferredSize(new Dimension((int) width, (int) height));
    }

    public addbutton(float posX, float posY, float width, float height) {
        this.setText("Add");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
        this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    }
}
