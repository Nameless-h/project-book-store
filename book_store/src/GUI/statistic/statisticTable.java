package GUI.statistic;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class statisticTable extends JPanel{
    private DefaultTableModel tableModel;
    public JTable t;
    private JScrollPane scrollpane;
    JTextField inputs[];

    // private JButton
    public statisticTable() {
        this.add(initTable());
    }

    public JScrollPane initTable() {

        t = new JTable();
        t.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableModel = new DefaultTableModel();
        scrollpane = new JScrollPane(t);
        scrollpane.setPreferredSize(new Dimension(1100, 500));

        t.setAutoCreateRowSorter(true);
        t.getTableHeader().setBackground(Color.red);
        t.getTableHeader().setForeground(Color.white);
        t.getTableHeader().setFont(new Font("Arial", Font.PLAIN, 16));
        t.setRowHeight(30);

        // disable table
        t.setDefaultEditor(Object.class, null);  

        return scrollpane;
    }

    public void setHeader(String[] headers) {
        tableModel.setColumnIdentifiers(headers);
        t.setModel(tableModel);
    }

    public void addRow(Object[] data) {
        tableModel.addRow(data);
    }

    public void setAlignment(int column, int align) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(align);
        t.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
    }

    public void setPreferredWidth(int column , int width){
        t.getColumnModel().getColumn(column).setPreferredWidth(width);
    }

   
}
