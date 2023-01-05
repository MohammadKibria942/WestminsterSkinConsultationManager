package w1824056MohammadKibriaCoursework;

import static w1824056MohammadKibriaCoursework.WestminsterSkinConsultationManager.*;
import static w1824056MohammadKibriaCoursework.DoctorsTableGUI.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddConsultationGUI extends JFrame implements ActionListener {
    
    Patient tempPatient;

    //CREATING THE LABELS AND BUTTONS-------------------------------------------
    int tempSelectedDoc = selctedRow;
    int tempSelectedTimeSlot = selectedTimeSlot;
    
    JLabel title = new JLabel("Book A Consultation");
    JLabel doctorLabel = new JLabel("Doctor Selected: " + doctorsList.get(tempSelectedDoc).getName() + " " + doctorsList.get(tempSelectedDoc).getSurname());
    JLabel nameLabel = new JLabel("Name: ");
    JLabel surnameLabel = new JLabel("Surname: ");
    JLabel mobileNumberLabel = new JLabel("Mobile Number: ");
    JLabel dayLabel = new JLabel("Day: ");
    JLabel monthLabel = new JLabel("Month: ");
    JLabel yearLabel = new JLabel("Year: ");
    JLabel timeLabel = new JLabel("Time Selected: " + timeSlots.get(tempSelectedTimeSlot) + ":00");
    static JLabel dateLabel = new JLabel("Date Selected: " + tempAppointmentDate.getDate());
    JLabel costLabel = new JLabel("Cost: £25 Per Hour, First Consultation Is £15");
    JLabel uniqueIDLabel = new JLabel("Unique ID");
    JLabel notesLabel = new JLabel("Notes");

    JButton btn = new JButton("Create");

    JTextField nameText = new JTextField("");
    JTextField surnameText = new JTextField("");
    JTextField mobileNumberText = new JTextField("");
    JTextField uniqueID = new JTextField("");
    JTextArea notes = new JTextArea(11,30);
    //DATE--------------------------------------------------------
    String[] days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] years = {"1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022"};
    JComboBox<String> day = new JComboBox(days);
    JComboBox month = new JComboBox(months);
    JComboBox<String> year = new JComboBox(years);
    
    Date tempDate;
    Time tempTime;
    int tempCost;
    
    int tempUniqueID;
    
    public AddConsultationGUI() {

        //FRAME SETTINGS--------------------------------------------------------      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 500);
        this.setTitle("Add Consultation");
        this.setLocationRelativeTo(null);

        this.setLayout(null);

        //LABELS----------------------------------------------------------------
        //setting the bounds for all labels
        title.setBounds(30, 20, 200, 20);
        nameLabel.setBounds(30, 70, 200, 20);
        surnameLabel.setBounds(30, 100, 200, 20);
        mobileNumberLabel.setBounds(30, 130, 200, 20);
        dayLabel.setBounds(30, 160, 200, 20);
        monthLabel.setBounds(30, 190, 200, 20);
        yearLabel.setBounds(30, 220, 200, 20);
        doctorLabel.setBounds(30, 320, 200, 20);
        timeLabel.setBounds(30, 350, 200, 20);
        dateLabel.setBounds(30, 380, 200, 20);
        costLabel.setBounds(430, 40, 400, 20);
        notesLabel.setBounds(430, 140, 400, 20);
        uniqueIDLabel.setBounds(430, 70, 400, 20);
        
        //TEXT AREAS------------------------------------------------------------
        //setting the counds for all the text areas
        nameText.setBounds(190, 70, 200, 20);
        surnameText.setBounds(190, 100, 200, 20);
        mobileNumberText.setBounds(190, 130, 200, 20);
        day.setBounds(190, 160, 200, 20);
        month.setBounds(190, 190, 200, 20);
        year.setBounds(190, 220, 200, 20);
        uniqueID.setBounds(430, 100, 200, 20);
        notes.setBounds(430, 160, 200, 100);
        notes.setCaretPosition(0);

        //BUTTON----------------------------------------------------------------
        btn.setBounds(190, 250, 200, 20);
        btn.addActionListener(this);  
        
        
        //adding all the labels and text areas to the frame
        this.add(nameLabel);
        this.add(surnameLabel);
        this.add(mobileNumberLabel);
        this.add(dayLabel);
        this.add(monthLabel);
        this.add(yearLabel);
        this.add(doctorLabel);
        this.add(timeLabel);
        this.add(dateLabel);
        this.add(costLabel);
        this.add(notesLabel);
        this.add(uniqueIDLabel);
        
        this.add(title);
        this.add(nameText);
        this.add(surnameText);
        this.add(mobileNumberText);
        this.add(day);
        this.add(month);
        this.add(year);
        this.add(uniqueID);
        this.add(notes);

        

        this.add(btn);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        //when the button is pressed this function is performed
        
        String tempDay = (String) day.getSelectedItem();
        String tempMonth = (String) month.getSelectedItem();
        String tempYear = (String) year.getSelectedItem();  

        int tempDay2 = Integer.parseInt(tempDay);
        int tempMonth2 = 0;
        int tempYear2 = Integer.parseInt(tempYear);
        
        //this gets the date from the combobox and turns it into a number
        
        if ("January".equals(tempMonth)) {
            tempMonth2 = 1;
        } else if ("February".equals(tempMonth)) {
            tempMonth2 = 2;
        } else if ("March".equals(tempMonth)) {
            tempMonth2 = 3;
        } else if ("April".equals(tempMonth)) {
            tempMonth2 = 4;
        } else if ("May".equals(tempMonth)) {
            tempMonth2 = 5;
        } else if ("June".equals(tempMonth)) {
            tempMonth2 = 6;
        } else if ("July".equals(tempMonth)) {
            tempMonth2 = 7;
        } else if ("August".equals(tempMonth)) {
            tempMonth2 = 8;
        } else if ("September".equals(tempMonth)) {
            tempMonth2 = 9;
        } else if ("October".equals(tempMonth)) {
            tempMonth2 = 10;
        } else if ("November".equals(tempMonth)) {
            tempMonth2 = 11;
        } else if ("December".equals(tempMonth)) {
            tempMonth2 = 12;
        }

        if (evt.getSource() == btn) {
            //if the button is pressed do this

            int timeTempHour = timeSlots.get(tempSelectedTimeSlot);
            
            int timeTempMinute = 00;
            
            //get all the informatino that the user entered and make a temporary patient from them
            
            tempDate = new Date(tempDay2, tempMonth2, tempYear2);
            tempTime = new Time(timeTempHour, timeTempMinute);
            
            tempUniqueID = Integer.parseInt(uniqueID.getText());

            tempPatient = new Patient(nameText.getText(), surnameText.getText(),mobileNumberText.getText(), tempDate, tempUniqueID);
            System.out.println(tempPatient);
            
            if (!patientList.isEmpty()) {//this is to check if the patient exists already or not
                System.out.println(patientList.size());
                for (int i = 0; i < patientList.size(); i++) {//loops through the lsit and checks if the patient already exists in the system
                    System.out.println("looping through patientis");
                    if (patientList.get(i).getUniqueID() == tempUniqueID) {//calculates the cost based on this
                        tempCost = 25;
                        break;
                    } else {
                        patientList.add(tempPatient);
                        savePatient();
                        tempCost = 15;
                        break;
                    }
                }
            } else if(patientList.isEmpty()){
               
                patientList.add(tempPatient);
                System.out.println("patient doesnt exist from empty one");
                savePatient();
                tempCost = 15;
            }
            
            if (doctorsList.get(tempSelectedDoc).getAvailable() == true) {//this checks the doctors availability
                doctorsList.get(tempSelectedDoc).setAvailable(false);//if hes available then they add him to the consultation
                Consultation tempConsultation = new Consultation(doctorsList.get(tempSelectedDoc), tempPatient, tempAppointmentDate, tempTime, tempCost, notes.getText());
                consultationList.add(tempConsultation);
                System.out.println(doctorsList.get(tempSelectedDoc));
                saveConsultation();

            } else if (doctorsList.get(tempSelectedDoc).getAvailable() == false) {//if hes not available then another doctor is selected
                for(int i = 0; i < doctorsList.size(); i++){
                    if (doctorsList.get(i).getAvailable() == true){
                        doctorsList.get(i).setAvailable(false);
                        Consultation tempConsultation = new Consultation(doctorsList.get(i), tempPatient, tempAppointmentDate, tempTime, tempCost, notes.getText());
                        consultationList.add(tempConsultation);
                        JOptionPane.showMessageDialog(null, "Doctor is unavailable Dr. " + doctorsList.get(i).getSurname() + " has been selected instead");
                        System.out.println(doctorsList.get(i));
                        break;
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Consultation Booked, returning to Main Menu");
            this.dispose();
            MainMenuGUI frame4 = new MainMenuGUI();//retrurns back to the main menu
        }  
    }
    
    public void savePatient(){//method is used to save the patient to the file
        try {
            FileWriter myWriter = new FileWriter(patientsListFile, true);
            BufferedWriter bw = new BufferedWriter(myWriter);

            bw.append(tempPatient.getName());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getSurname());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getDob().toString());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getMobileNumber());
            bw.append(System.lineSeparator());
            bw.append(Integer.toString(tempPatient.getUniqueID()));
            bw.append(System.lineSeparator());
            bw.close();
            myWriter.close();
            System.out.println("Successfully wrote patient to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
    
    public void saveConsultation(){//method is used to save the consultation to the file
        try {
            FileWriter myWriter = new FileWriter(consultationListFile, true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            Doctor tempDoctor;
            tempDoctor = doctorsList.get(tempSelectedDoc);
            
            bw.append(tempDoctor.getName());
            bw.append(System.lineSeparator());
            bw.append(tempDoctor.getSurname());
            bw.append(System.lineSeparator());
            bw.append(tempDoctor.getDob().toString());
            bw.append(System.lineSeparator());
            bw.append(tempDoctor.getMobileNumber());
            bw.append(System.lineSeparator());
            bw.append(tempDoctor.getMedicalLicenseNumber());
            bw.append(System.lineSeparator());
            bw.append(tempDoctor.getSpecialisation());
            bw.append(System.lineSeparator());
            bw.append(String.valueOf(tempDoctor.getAvailable()));
            bw.append(System.lineSeparator());
            
            bw.append(tempPatient.getName());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getSurname());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getDob().toString());
            bw.append(System.lineSeparator());
            bw.append(tempPatient.getMobileNumber());
            bw.append(System.lineSeparator());
            bw.append(Integer.toString(tempPatient.getUniqueID()));
            bw.append(System.lineSeparator());
            
            bw.append(tempAppointmentDate.toString());
            bw.append(System.lineSeparator());
            
            bw.append(tempTime.getTime());
            bw.append(System.lineSeparator());
            
            bw.append(Integer.toString(tempCost));
            bw.append(System.lineSeparator());
            
            bw.append(notes.getText());
            bw.append(System.lineSeparator());
            
            bw.close();
            myWriter.close();
            System.out.println("Successfully wrote consultation to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
