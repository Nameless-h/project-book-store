package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class addbutton extends JButton {
    public addbutton() {
        this.setText("Add");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_add_30px.png")));
    }
}
