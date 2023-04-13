package statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;

import java.awt.FlowLayout;

public class list_statistic extends JPanel implements MouseListener,ActionListener{
    private JTextField headerSearchInput;
    private JButton headerSearchBtn;
    private JPanel content;
    private String[] list_sta_name = {"Tong quat","Ban hang","Nhap hang"};
    private JButton[] list_sta_btn = new JButton[list_sta_name.length];

    public list_statistic() {
        setLayout(new BorderLayout());
        // header
        JPanel list_sta = new JPanel(new FlowLayout(FlowLayout.LEFT));
        list_sta.setBackground(Color.darkGray);

         for (int i = 0; i < list_sta_name.length; i++) {
            list_sta_btn[i] = new JButton(list_sta_name[i]);
            list_sta_btn[i].setPreferredSize(new Dimension(100, 50));
            list_sta_btn[i].setFocusable(false);
            list_sta_btn[i].setBackground(Color.white);
            list_sta_btn[i].setForeground(Color.black);
            list_sta_btn[i].setBorder(BorderFactory.createEmptyBorder());
            list_sta_btn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
            list_sta_btn[i].addActionListener(this);
            list_sta.add(list_sta_btn[i]);
        }        

        // content
        list_sta_btn[0].setBackground(Color.red);
        list_sta_btn[0].setForeground(Color.white);

        content = new statistic_main();
        content.setBackground(Color.lightGray);

        // set size for borderLayout
        list_sta.setPreferredSize(new Dimension(0, 50));
        content.setPreferredSize(new Dimension(0, 620));

        add(list_sta, BorderLayout.NORTH);
        add(content, BorderLayout.SOUTH);

    }
    @Override
    public void mousePressed(MouseEvent e) {
        /* for (int i = 0; i < list_sta_btn.length; i++) {
            if (e.getSource() == list_sta_btn[i]) {
                try {
                    change_panel(list_sta_btn[i].getText());
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                lab_menu[i].setBackground(new Color(54,54,54));
            }

        } */
        
    }
    /* public void inputSearchFocus(JTextField input) {
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Nhap de tim kiem...")) {
                    input.setText("");
                }           
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty() || input.getText() == "") {
                    input.setText("Nhap de tim kiem...");
                }
            }
        });
    } */

    public void hoverBtn(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.darkGray);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.black);
            }
        });
    }

    public static void main(String[] args) {
        new statistic_sale();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        this.remove(content);
        try {
            /* if(e.getSource() == headerSearchBtn) {
                System.out.print("Search");
            } */
            
            content.removeAll();
            
            for (int i = 0; i < list_sta_name.length; i++) {
                list_sta_btn[i].setBackground(Color.white);
                list_sta_btn[i].setForeground(Color.black);
            }

            if(e.getSource() == list_sta_btn[0]) {
                content = new statistic_main();
                list_sta_btn[0].setBackground(Color.red);
                list_sta_btn[0].setForeground(Color.white);
                System.out.print(list_sta_name[0]);
            }
            else if(e.getSource() == list_sta_btn[1]) {
                content = new statistic_sale();
                list_sta_btn[1].setBackground(Color.red);
                list_sta_btn[1].setForeground(Color.white);
                System.out.print(list_sta_name[1]);

            }
            else if(e.getSource() == list_sta_btn[2]) {
                content = new statistic_import();
                list_sta_btn[2].setBackground(Color.red);
                list_sta_btn[2].setForeground(Color.white);
                System.out.print(list_sta_name[2]);

            }
            content.setPreferredSize(new Dimension(0, 620));
        } catch (Exception ex) {
            System.out.println(ex);
        }    
        this.add(content, BorderLayout.SOUTH);
        this.repaint();
        this.validate();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
