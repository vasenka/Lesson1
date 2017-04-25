package task3;

import javax.swing.table.AbstractTableModel;

class MyTableModel extends AbstractTableModel {
    String[] columnNames;
    double[][] data;
    MyTableModel(double[][] data, String[] columnNames) {
        this.columnNames = columnNames;
        this.data = data;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return data.length;
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

}