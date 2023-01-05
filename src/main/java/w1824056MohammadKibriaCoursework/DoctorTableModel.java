package w1824056MohammadKibriaCoursework;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class DoctorTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Name", "Surname", "Medical License Number", "Specialisation"};//outlines the names of each column
    private final ArrayList<Doctor> list;//the list of consultations used

    public DoctorTableModel(ArrayList<Doctor> doctorList) {//the constructor
        list = doctorList;
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
            temp = list.get(rowIndex).getName();
            
        } else if (columnIndex == 1) {
            temp = list.get(rowIndex).getSurname();
            
        } else if (columnIndex == 2) {
            temp = list.get(rowIndex).getMedicalLicenseNumber();
            
        } else if (columnIndex == 3) {
            temp = list.get(rowIndex).getSpecialisation();
            
        }

        return temp;
    }

    // needed to show column names in JTable 
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
}
