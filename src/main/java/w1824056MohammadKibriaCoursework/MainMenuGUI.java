package w1824056MohammadKibriaCoursework;

import java.awt.event.*;
import javax.swing.*;
import static w1824056MohammadKibriaCoursework.WestminsterSkinConsultationManager.*;

public class MainMenuGUI extends JFrame implements ActionListener{
    
    //CREATING THE LABELS AND BUTTONS-------------------------------------------
    JLabel mainMenu = new JLabel("Westminster Skin Consultation Manager");
    JButton veiwConsultation = new JButton("Veiw Consultation");
    JButton veiwDoctors = new JButton("Veiw Doctors");
    
    MainMenuGUI(){
        
        //FRAME SETTINGS--------------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setTitle("Westminster Skin Consultation Manager Main Menu");
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        //MAIN MENU LABEL-------------------------------------------------------       
        mainMenu.setBounds(125,30,240,50);

        //VEIW DOCTORS BUTTON-----------------------------------------------
        veiwDoctors.setBounds(165,220,160,50);
        veiwDoctors.setFocusable(false);
        veiwDoctors.addActionListener(this);    
        
        //VEIW CONSLTATION BUTTON-----------------------------------------------
        veiwConsultation.setBounds(165,280,160,50);
        veiwConsultation.setFocusable(false);
        veiwConsultation.addActionListener(this);      

        //ADD BUTTONS TO FRAME--------------------------------------------------       
        this.add(mainMenu);
        this.add(veiwConsultation);
        this.add(veiwDoctors);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {                              //Method for checking what action has been performed
            
        if(evt.getSource() == veiwConsultation){
            VeiwConsultationGUI frame4 = new VeiwConsultationGUI(consultationList);
            this.dispose();
            
        }else if(evt.getSource() == veiwDoctors){
            this.dispose();
            DoctorsTableGUI frame3 = new DoctorsTableGUI(doctorsList, timeSlots);
            
        }
    }
}
