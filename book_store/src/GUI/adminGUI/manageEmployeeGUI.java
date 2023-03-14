package GUI.adminGUI;

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
import java.awt.FlowLayout;

public class manageEmployeeGUI extends JFrame {
    public manageEmployeeGUI() {

        // header
        JPanel header = new JPanel();
        header.setBackground(Color.black);
        header.setLayout(new FlowLayout());

        // header title
        JLabel headerTitle = new JLabel("THE EMPLOYEE MANGAGEMENT", SwingConstants.CENTER);
        headerTitle.setFont(new Font("Arial", Font.PLAIN, 24));
        headerTitle.setPreferredSize(new Dimension(500, 40));
        headerTitle.setForeground(Color.white);
        header.add(headerTitle);

        // header search
        JPanel headerSearch = new JPanel();
        headerSearch.setPreferredSize(new Dimension(600, 50));
        headerSearch.setLayout(new BorderLayout());
        headerSearch.setFocusable( true );
        header.add(headerSearch);

        // header search input
        JTextField headerSearchInput = new JTextField("Type to search...");
        headerSearchInput.setPreferredSize(new Dimension(500, 0));
        headerSearchInput.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchInput.setBorder(BorderFactory.createEmptyBorder());
        inputSearchFocus(headerSearchInput);
        
        // header search button
        JButton headerSearchBtn = new JButton("Search");
        headerSearchBtn.setForeground(Color.white);
        headerSearchBtn.setBackground(new Color(66, 135, 245));
        headerSearchBtn.setPreferredSize(new Dimension(100, 0));
        headerSearchBtn.setFocusable(false);
        headerSearchBtn.setFont(new Font("Arial", Font.PLAIN, 20));
        headerSearchBtn.setBorder(BorderFactory.createEmptyBorder());
        headerSearchBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hoverBtn(headerSearchBtn);

        headerSearch.add(headerSearchInput,BorderLayout.WEST);
        headerSearch.add(headerSearchBtn,BorderLayout.EAST);

        // form
        JPanel leftFormEmployee = new JPanel();
        leftFormEmployee.setBackground(Color.blue);

        String arrSortOfInfo[] = {"employeeId","employeeName","employee"};

        // list
        JPanel rightListEmployee = new JPanel();
        rightListEmployee.setBackground(Color.pink);

        // CRUD bar
        JPanel crudBar = new JPanel();
        crudBar.setBackground(Color.green);

        // set size for borderLayout
        header.setPreferredSize(new Dimension(0, 100));
        leftFormEmployee.setPreferredSize(new Dimension(350, 0));
        rightListEmployee.setPreferredSize(new Dimension(650, 0));
        crudBar.setPreferredSize(new Dimension(0, 100));

        add(header, BorderLayout.NORTH);
        add(leftFormEmployee, BorderLayout.WEST);
        add(rightListEmployee, BorderLayout.EAST);
        add(crudBar, BorderLayout.SOUTH);

        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void inputSearchFocus(JTextField input) {
        input.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (input.getText().equals("Type to search...")) {
                    input.setText("");
                }           
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (input.getText().isEmpty()) {
                    input.setText("Type to search...");
                }
            }
        });
    }

    public void hoverBtn(JButton button) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(66, 84, 245));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(66, 135, 245));
            }
        });
    }

    public static void main(String[] args) {
        new manageEmployeeGUI();
    }
}
