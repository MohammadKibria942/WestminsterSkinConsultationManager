package w1824056MohammadKibriaCoursework;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class DoctorsTableGUI extends JFrame implements ActionListener{
    
    //createing all the variables and labels
    ArrayList<Doctor> times;
    JTable doctorTable;
    JTable timeSlotTable;
    DoctorTableModel tableModel;
    TimeSlotModel timeSlotModel;
    JButton bookADoctor = new JButton("Book A Doctor");
    ArrayList<Integer> timeSlots;
    public static int selctedRow;
    public static int selectedTimeSlot;
    
    JLabel dayLabel = new JLabel("Day: ");
    JLabel monthLabel = new JLabel("Month: ");
    JLabel yearLabel = new JLabel("Year: ");
    
    String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] years = {"2022", "2023", "2024", "2025", "2026"};
    JComboBox<String> consultationDay = new JComboBox(days);
    JComboBox<String> consultationMonth = new JComboBox(months);
    JComboBox<String> consultationYear = new JComboBox(years);
        
    JButton backButton = new JButton("Go Back");
    
    static Date tempAppointmentDate;
    
    public DoctorsTableGUI(ArrayList<Doctor> list, ArrayList<Integer> times) {
        this.timeSlots = times;
        this.times = list;
        
        tableModel = new DoctorTableModel(list);//creates the tables froo thte doctors list and timeslot
        timeSlotModel = new TimeSlotModel(times);
        doctorTable = new JTable(tableModel);
        timeSlotTable = new JTable(timeSlotModel);

        setBounds(0,0,800,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        doctorTable.setAutoCreateRowSorter(true);

        JScrollPane scrollPane = new JScrollPane(doctorTable);//create scroll panes for the tables
        JScrollPane scrollPane2 = new JScrollPane(timeSlotTable);
        scrollPane.setPreferredSize(new Dimension(380,100));
        scrollPane2.setPreferredSize(new Dimension(380,100)); 
        
        JPanel panel = new JPanel();
        panel.add(scrollPane);//add the scrollpane to the panel
        panel.add(scrollPane2);
        add(panel, BorderLayout.CENTER);
        
        bookADoctor.setFocusable(false);
        bookADoctor.addActionListener(this);
        
        backButton.setFocusable(false);
        backButton.addActionListener(this);
 
        panel.add(dayLabel);//add the other labels
        panel.add(consultationDay);
        panel.add(monthLabel);
        panel.add(consultationMonth);
        panel.add(yearLabel);
        panel.add(consultationYear);
        panel.add(bookADoctor);
        panel.add(backButton);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {//if  an action is performed
        int tempSelectedDay2;
        int tempSelectedMonth = 0;
        int tempSelectedYear2;

        if (evt.getSource() == backButton) {//if the button pressed it the back button then go back to the main menu
            this.dispose();
            MainMenuGUI frame5 = new MainMenuGUI();
        }

        if (evt.getSource() == bookADoctor) {//if the button pressed is the book doctor button
            if (doctorTable.getSelectionModel().isSelectionEmpty()) {//check to see if a doctor and a time is selected
                JOptionPane.showMessageDialog(null, "Select A Doctor");

            } else if (timeSlotTable.getSelectionModel().isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Select A Time Slot");
                
            } else {
                
                selctedRow = doctorTable.getSelectedRow();//gets therselected time and doctor
                selectedTimeSlot = timeSlotTable.getSelectedRow();
                
                if ("January".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 1;
                } else if ("February".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 2;
                } else if ("March".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 3;
                } else if ("April".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 4;
                } else if ("May".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 5;
                } else if ("June".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 6;
                } else if ("July".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 7;
                } else if ("August".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 8;
                } else if ("September".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 9;
                } else if ("October".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 10;
                } else if ("November".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 11;
                } else if ("December".equals(consultationMonth.getSelectedItem())) {
                    tempSelectedMonth = 12;
                }
                
                
                tempSelectedDay2 = Integer.parseInt((String) consultationDay.getSelectedItem());
                tempSelectedYear2 = Integer.parseInt((String) consultationYear.getSelectedItem());
                
                tempAppointmentDate = new Date(tempSelectedDay2, tempSelectedMonth, tempSelectedYear2);//creates a new date

                this.dispose();
                AddConsultationGUI frame4 = new AddConsultationGUI();//goes to the next frame
            }
        }
    }
}
