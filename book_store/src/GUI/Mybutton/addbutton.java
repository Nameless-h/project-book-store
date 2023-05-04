package GUI.Mybutton;

import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;

public class addbutton extends JButton {
    public addbutton() {
        this.setText("Thêm");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
    }

    public addbutton(int width, int height) {
        this.setText("Thêm");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
        this.setPreferredSize(new Dimension((int) width, (int) height));

    }

    public addbutton(int posX, int posY, int width, int height) {
        this.setText("Thêm");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
        this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    }

    private int modifyPanelWidth(int width, double percent) {
        return (int) (width * percent);
    }

}
