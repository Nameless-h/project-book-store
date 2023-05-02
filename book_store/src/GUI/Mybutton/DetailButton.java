package GUI.Mybutton;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DetailButton extends JButton {
    public DetailButton() {
        this.setText("Xem");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-analyze-30.png")));
    }
}
