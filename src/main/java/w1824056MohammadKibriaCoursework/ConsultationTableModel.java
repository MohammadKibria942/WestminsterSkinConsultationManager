package w1824056MohammadKibriaCoursework;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ConsultationTableModel extends AbstractTableModel{
    
    private final String[] columnNames = {"Doctor","Patient","Date","Time","Cost","Notes"};//outlines the names of each column
    private final ArrayList<Consultation> list;//the list of consultations used

    public ConsultationTableModel(ArrayList<Consultation> consultationList) {//the constructor
        list = consultationList;
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
        if (columnIndex == 0) {
            temp = list.get(rowIndex).getDoctor().getSurname();
            
        } else if (columnIndex == 1) {
            temp = list.get(rowIndex).getPatient().getSurname();
            
        } else if (columnIndex == 2) {
            temp = list.get(rowIndex).getAppointmentDate();
            
        } else if (columnIndex == 3) {
            temp = list.get(rowIndex).getAppointmentTime();
            
        } else if (columnIndex == 4) {
            temp = list.get(rowIndex).getCost();
            
        } else if (columnIndex == 5) {
            temp = list.get(rowIndex).getNotes();
            
        }

        return temp;
    }

    // needed to show column names in JTable 
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
