package GUI.Mybutton;

import javax.swing.JButton;

import java.awt.Dimension;

import javax.swing.ImageIcon;

public class deletebutton extends JButton {
    public deletebutton() {
        this.setText("Delete");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_delete_forever_30px_1.png")));
    }

    public deletebutton(float width, float height) {
        this.setText("Delete");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_delete_forever_30px_1.png")));
        this.setPreferredSize(new Dimension((int) width, (int) height));
    }

    public deletebutton(float posX, float posY, float width, float height) {
        this.setText("Delete");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_delete_forever_30px_1.png")));
        this.setBounds((int) posX, (int) posY, (int) width, (int) height);
    }
}
