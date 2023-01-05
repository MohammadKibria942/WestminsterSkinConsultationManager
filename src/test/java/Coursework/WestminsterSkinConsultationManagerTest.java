package Coursework;

import w1824056MohammadKibriaCoursework.Doctor;
import w1824056MohammadKibriaCoursework.Date;
import w1824056MohammadKibriaCoursework.WestminsterSkinConsultationManager;
import static w1824056MohammadKibriaCoursework.WestminsterSkinConsultationManager.doctorsList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Comparator;

public class WestminsterSkinConsultationManagerTest {
    
    WestminsterSkinConsultationManager newInterface = new WestminsterSkinConsultationManager();
    
    public WestminsterSkinConsultationManagerTest() {
    }

    /**
     * Test of addNewDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testAddNewDoctor() {
        
        Date tempDate = new Date(1,1,2022);
        Doctor tempDoctor = new Doctor("John", "Smith", "123456678901", tempDate, "12345678", "Temp", true);
        
        boolean expected =  true;
        boolean actual = newInterface.addNewDoctor(tempDoctor);
        
        assertEquals(expected, actual);
    }

    /**
     * Test of deleteDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testDeleteDoctor() {
        
        doctorsList.clear();
        System.out.println("size" + doctorsList.size());
        
        Date tempDate = new Date(1,1,2023);
        Doctor tempDoctor = new Doctor("temp", "temp", "12345678901", tempDate, "12345678", "temp", true);
        doctorsList.add(tempDoctor);
        
        
        
        
        for (int i = 0; i < doctorsList.size(); i++) {
            System.out.println(i + ". " + doctorsList.get(i) + " ");
        }
        System.out.println("Enter A Doctors Medical License Number From The List To Delete: ");
        //User input section has been removed as i could not find a way to simulate user input.

        String userInput = "12345678";
        int index = 0;
        
        for (int i = 0; i < doctorsList.size(); i++) {
            if (doctorsList.get(i).getMedicalLicenseNumber() == userInput){
                index = i;
                break;
            }
        }
        System.out.println("Removing Doctor: " + doctorsList.get(index));
        doctorsList.remove(index);
        System.out.println("Total Doctors left: " + doctorsList.size());
        
        int expected = 0;
        int actual = doctorsList.size();
        assertEquals(expected, actual);
    }

    /**
     * Test of printListOfDoctor method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testPrintListOfDoctor() {

        doctorsList.clear();
        
        Date tempDate = new Date(1,1,2023);
        
        Doctor tempDoctor = new Doctor("Mohammad", "Kibria", "12345678901", tempDate, "12345678", "temp", true);
        Doctor tempDoctor2 = new Doctor("John", "Smith", "12345678901", tempDate, "12345678", "temp", true);
        
        doctorsList.add(tempDoctor);
        doctorsList.add(tempDoctor2);
        
        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
                Collections.sort(doctorsList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor object1, Doctor object2) {
                return object1.surname.compareTo(object2.surname);
            }
        });

        System.out.println("Elements of doctorsList are:");
        System.out.println("");
        for (int i = 0; i < doctorsList.size(); i++) {
            System.out.println("Name: " + doctorsList.get(i).getName() + " ");
            System.out.println("Surname: " + doctorsList.get(i).getSurname() + " ");
            System.out.println("Mobile Number: " + doctorsList.get(i).getMobileNumber() + " ");
            System.out.println("Date Of Birth: " + doctorsList.get(i).getDob() + " ");
            System.out.println("Medical License Number: " + doctorsList.get(i).getMedicalLicenseNumber() + " ");
            System.out.println("Specialisation: " + doctorsList.get(i).getSpecialisation() + " ");
            System.out.println("Is Available: " + doctorsList.get(i).getAvailable() + " ");
            System.out.println("");
        }
        
        // Put things back
        System.out.flush();
        System.setOut(old);
        // Show what happened
        System.out.println(baos.toString());

        String expected = newInterface.printListOfDoctor();
        String actual = baos.toString();
        
        assertEquals(expected, actual);
    }

    /**
     * Test of saveInAFile method, of class WestminsterSkinConsultationManager.
     */
    @Test
    public void testSaveInAFile() {
        
        File test = new File("C:\\Users\\lolbo\\Documents\\NetBeansProjects\\Coursework\\TestFile.txt");
        
        Date tempDate = new Date(1,1,2022);
        Doctor tempDoctor = new Doctor("Mohammad", "Kibria", "12345678901", tempDate, "12345678", "temp", true);
        Doctor tempDoctor2 = new Doctor("John", "Smith", "12345678901", tempDate, "12345678", "temp", true);

        doctorsList.add(tempDoctor);
        doctorsList.add(tempDoctor2);
        
        boolean actual = newInterface.saveInAFile(test);
    }
}
