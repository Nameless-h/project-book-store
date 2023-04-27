package GUI.Mybutton;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class editbutton extends JButton {
    public editbutton() {
        this.setText("Sửa");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_support_30px.png")));
    }

    public editbutton(float width, float height) {
        this.setText("Sửa");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_support_30px.png")));
        this.setPreferredSize(new Dimension((int) width, (int) height));
    }

    public editbutton(float posX, float posY, float width, float height) {
        this.setText("Sửa");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_support_30px.png")));
        this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    }

}