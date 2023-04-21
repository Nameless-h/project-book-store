package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Mytable extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane pane;

    public Mytable() {
        this.setLayout(new BorderLayout());

        table = new JTable();
        tableModel = new DefaultTableModel();
        pane = new JScrollPane(table);

        table.setFont(new Font("Segoe UI", 0, 16));
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        table.getTableHeader().setBackground(new Color(255,30,30));
        table.getTableHeader().setForeground(Color.white);
        table.setRowHeight(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setDefaultEditor(Object.class, null);

        this.add(pane,BorderLayout.CENTER);
    }
    public JTable getTable() {
            return this.table;
    }

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }

    public void setHeader(String[] headers) {
        tableModel.setColumnIdentifiers(headers);
        table.setModel(tableModel);
    }

    public void setAlignment(int column, int align) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(align);
        table.getColumnModel().getColumn(column).setCellRenderer(centerRenderer);
    }

    public void setPreferredWidth(int column , int width){
        table.getColumnModel().getColumn(column).setPreferredWidth(width);
    }

    public void setTablesize(int width , int height) {
        this.setPreferredSize(new Dimension(width,height));
    }

    public void addRow(Object[] data) {
        tableModel.addRow(data);
    }

    public void clear() {
        tableModel.setRowCount(0);
    }
}
