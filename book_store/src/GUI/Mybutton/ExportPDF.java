package GUI.Mybutton;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ExportPDF extends JButton{
    public ExportPDF() {
        this.setText("PDF");
        this.setIcon(new ImageIcon(this.getClass().getResource("../../icon/icons8-pdf-30.png")));
    }
}
