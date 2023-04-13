package GUI;

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

public class header extends JPanel implements MouseListener {
    JLabel lab_close, lab_hide;
    main obj;

    public header(main obj) {
        this.obj = obj;
        init();
    }
    private void init() {
        this.setPreferredSize(new Dimension(obj.w_head,obj.h_head));
        this.setBackground(Color.white);
        this.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        // set lab_close
        lab_close = new JLabel("Close");
        lab_close.setFont(new Font("Segoe UI", 1, 20));
        lab_close.setPreferredSize(new Dimension(50, 30));
        lab_close.setOpaque(true);
        lab_close.setBackground(Color.white);
        lab_close.addMouseListener(this);
        // set lab_hide
        lab_hide = new JLabel("Hide");
        lab_hide.setFont(new Font("Segoe UI", 1, 20));
        lab_hide.setPreferredSize(new Dimension(50, 30));
        lab_hide.setOpaque(true);
        lab_hide.setBackground(Color.white);
        lab_hide.addMouseListener(this);
        this.add(lab_hide);
        this.add(lab_close);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == lab_close)
            System.exit(0);
        else if (e.getSource() == lab_hide)
            obj.setState(Frame.ICONIFIED);
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
        if (e.getSource() == lab_close)
            lab_close.setBackground(Color.gray);
        else
            if (e.getSource() == lab_hide)
            lab_hide.setBackground(Color.gray);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        lab_close.setBackground(Color.white);
        lab_hide.setBackground(Color.white);
    }
}
