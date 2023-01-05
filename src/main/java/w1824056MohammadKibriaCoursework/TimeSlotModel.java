package w1824056MohammadKibriaCoursework;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TimeSlotModel extends AbstractTableModel{
    
    private final String[] columnNames = {"Time"};//outlines the names of each column
    private final ArrayList<Integer> list;//the list of consultations used

    public TimeSlotModel(ArrayList<Integer> timeSlots) {//the constructor
        list = timeSlots;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//this inserts the list into the table
        Object temp = null;
            temp = list.get(rowIndex) + ":00"; 
            return temp;
    }

    // needed to show column names in JTable 
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
