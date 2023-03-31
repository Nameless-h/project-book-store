package form1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.Flow;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class menu_north extends JPanel implements MouseListener {
    JLabel lab_close;
    
    
    public menu_north(JFrame frame,int width,int heigh){
        init(width,heigh);
    }
    private void init(int width,int heigh){
        this.setPreferredSize(new Dimension(width,heigh));
        this.setBackground(Color.white);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT,5,0));
        lab_close=new JLabel("Close");
        lab_close.setFont(new Font("Segoe UI",1,20));
        lab_close.setPreferredSize(new Dimension(50,30));
        lab_close.setOpaque(true);
        lab_close.setBackground(Color.white);
        lab_close.addMouseListener(this);
        this.add(lab_close);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.exit(0);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==lab_close)
        lab_close.setBackground(Color.gray);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        lab_close.setBackground(Color.white);
    }
}
