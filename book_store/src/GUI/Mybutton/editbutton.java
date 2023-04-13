package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class editbutton extends JButton {
    public editbutton() {
        this.setText("Edit");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8_support_30px.png")));
    }
}