package GUI.adminGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class employeeTable extends JPanel implements ActionListener{
    private String[] columnNames = {"ID","Name","Age"};
    private DefaultTableModel employeeTableModel;
    private JTable t;
    private JScrollPane scrollpane;
    // private JButton
    public employeeTable() {
        this.add(initEmployeeTable());
    }

    public JScrollPane initEmployeeTable() {
        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        scrollpane = new JScrollPane(t);
        scrollpane.setPreferredSize(new Dimension(650, 460));
        String[] headers = columnNames;
        Object[][] tableData = {
            {"1", "Vineet", "22"},
            {"2", "Archana", "31"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"3", "Krishna", "27"},
            {"4", "Krishna", "27"},
        };
        employeeTableModel = new DefaultTableModel(tableData,headers);
        t.setModel(employeeTableModel);
        t.setAutoCreateRowSorter(true);
        t.getTableHeader().setBackground(Color.red);
        t.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 16));
        t.getTableHeader().setForeground(Color.white);
        t.setRowHeight(30);
        t.getColumnModel().getColumn(0).setPreferredWidth(100);
        t.getColumnModel().getColumn(1).setPreferredWidth(200);
        t.getColumnModel().getColumn(2).setPreferredWidth(100);

        DefaultTableCellRenderer centerRenderer= new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        t.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        t.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

        return scrollpane;
    }

    private void tableMouseClicked() {
        int row;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }


}
