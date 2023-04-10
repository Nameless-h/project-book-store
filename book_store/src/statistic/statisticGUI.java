package statistic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.SwingConstants;

import GUI.Mybutton.addbutton;
import GUI.Mybutton.deletebutton;
import GUI.Mybutton.editbutton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class statisticGUI extends JPanel implements ActionListener{
    JTextField headerSearchInput;
    JButton headerSearchBtn;
    public statisticGUI() {
        // System.out.print("manage employee");
        setLayout(new BorderLayout());
        // setSize(1500, 600);
        // setPreferredSize(new Dimension(1500, 600));
        // header
        JPanel header = new JPanel();
        header.setBackground(Color.red);
        header.setLayout(new FlowLayout());

        // header title
        JLabel headerTitle = new JLabel("Thong ke", SwingConstants.CENTER);
        headerTitle.setFont(new Font("Arial", Font.PLAIN, 24));
        headerTitle.setPreferredSize(new Dimension(500, 40));
        headerTitle.setForeground(Color.white);
        header.add(headerTitle);

        // header search
        JPanel headerSearch = new JPanel();
        headerSearch.setPreferredSize(new Dimension(600, 40));
        headerSearch.setLayout(new BorderLayout());
        headerSearch.setFocusable( true );
        header.add(headerSearch);

        // header search input
        headerSearchInput = new JTextField("Nhap de tim kiem...");
        headerSearchInput.setPreferredSize(new Dimension(500, 0));
        headerSearchInput.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchInput.setBorder(BorderFactory.createEmptyBorder());
        inputSearchFocus(headerSearchInput);
        
        // header search button
        headerSearchBtn = new JButton("Tim");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(Color.black);
        headerSearchBtn.setPreferredSize(new Dimension(100, 0));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setBorder(BorderFactory.createEmptyBorder());
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        headerSearchBtn.addActionListener(this);
        hoverBtn(headerSearchBtn);

        headerSearch.add(headerSearchInput,BorderLayout.WEST);
        headerSearch.add(headerSearchBtn,BorderLayout.EAST);
        
        // list
        JPanel rightListEmployee = new statisticTable();
        rightListEmployee.setBackground(Color.lightGray);

        // form
        JPanel leftFormEmployee = ((statisticTable) rightListEmployee).showLeftForm();
        leftFormEmployee.setBackground(Color.lightGray);


        // CRUD bar
        JPanel crudBar = new JPanel();
        crudBar.setBackground(Color.darkGray);
        JButton addButton = new addbutton();
        JButton deButton = new deletebutton();
        JButton editButton = new editbutton();

        //button add, delete, edit
        addButton.setPreferredSize(new Dimension(100, 50));
        deButton.setPreferredSize(new Dimension(100, 50));
        editButton.setPreferredSize(new Dimension(100, 50));

        addButton.setFocusable(false);
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        deButton.setFocusable(false);
        deButton.setBorder(BorderFactory.createEmptyBorder());
        deButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        editButton.setFocusable(false);
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        crudBar.add(addButton);
        crudBar.add(deButton);
        crudBar.add(editButton);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 100));
        leftFormEmployee.setPreferredSize(new Dimension(295, 0));
        rightListEmployee.setPreferredSize(new Dimension(710, 0));
        crudBar.setPreferredSize(new Dimension(0, 60));

        add(header, BorderLayout.NORTH);
        add(leftFormEmployee, BorderLayout.WEST);
        add(rightListEmployee, BorderLayout.EAST);
        add(crudBar, BorderLayout.SOUTH);

        // this.setUndecorated(true);
        
        // setLayout(null);
        // setResizable(false);
        // setLocationRelativeTo(null);
        // setVisible(true);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void inputSearchFocus(JTextField input) {
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
    }

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
        new statisticGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        try {
            if(e.getSource() == headerSearchBtn) {
                System.out.print("Search");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }    
    }
}
