package w1824056MohammadKibriaCoursework;

import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {

    public static ArrayList<Doctor> doctorsList = new ArrayList(9);//doctor list
    public static ArrayList<Consultation> consultationList = new ArrayList<>();//consultations list
    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Integer> timeSlots = new ArrayList<>();
    
    static File doctorsListFile = new File("C:\\Users\\lolbo\\Documents\\NetBeansProjects\\Coursework\\DoctorsList.txt");//text files where the program saves to
    static File patientsListFile = new File("C:\\Users\\lolbo\\Documents\\NetBeansProjects\\Coursework\\PatientsList.txt");
    static File consultationListFile = new File("C:\\Users\\lolbo\\Documents\\NetBeansProjects\\Coursework\\ConsultationListFile.txt");


    static WestminsterSkinConsultationManager newInterface = new WestminsterSkinConsultationManager();//interface used to call functions

    //temp variables
    static String tempName;
    String tempSurname;
    String tempMobileNumber;
    String tempMedicalLicenseNumber;
    String tempSpecialisation;
    boolean tempAvailable;
    
    Date tempDoctorDOB;
    Doctor tempDoctor;
    
    int tempUniqueID;
    Date tempPatientDOB;
    Patient tempPatient;
    
    Date tempAppointmentDate;
    
    int tempHour;
    int tempMinute;
    
    Time tempAppointmentTime;
    
    List<String> integerList = new ArrayList<>();
    int tempDay;
    int tempMonth;
    int tempYear;    
    
    int tempCost;
    
    String tempNotes;
    
    String newLine = System.getProperty("line.separator");
    
    public static void main(String[] args) {//main program reads from files, then shows the main menu
        newInterface.initialise();
        newInterface.readingIn();
        newInterface.consoleMainMenu();
    }

    @Override
    public void consoleMainMenu() {
        System.out.println("");
        try {
            System.out.println("Welcome To Westminster Skin Consultation Manager Please Choose A Number For What You Would Like To Do:");
            System.out.println("1. Add A New Doctor");
            System.out.println("2. Delete A Doctor");
            System.out.println("3. Veiw A List Of All Doctors");
            System.out.println("4. Save All Doctors Into A File");
            System.out.println("5. To Open GUI");
            System.out.println("6. To Quit");

            Scanner myObj = new Scanner(System.in);
            System.out.print("Enter A Number: ");

            String userInput = myObj.nextLine();
            int choice = Integer.parseInt(userInput);//allows user to select a choice

            if (choice == 1) {
                if (doctorsList.size() < 10) {
                    
                    System.out.print("Enter The First Name: ");
                    tempName = myObj.next();
                    System.out.print("Enter The Surname: ");
                    tempSurname = myObj.next();
                    System.out.print("Enter The Mobile Number: ");
                    tempMobileNumber = myObj.next();
                    System.out.print("Enter The Day for DOB: ");
                    tempDay = Integer.parseInt(myObj.next());
                    System.out.print("Enter The Month for DOB: ");
                    tempMonth = Integer.parseInt(myObj.next());
                    System.out.print("Enter The Year for DOB: ");
                    tempYear = Integer.parseInt(myObj.next());
                    System.out.print("Enter The Medical License Number: ");
                    tempMedicalLicenseNumber = myObj.next();
                    System.out.print("Enter Specialisation: ");
                    tempSpecialisation = myObj.next();
                    System.out.println("");
                    tempAvailable = true;
                    Date tempDate = new Date(tempDay, tempMonth, tempYear);

                    Doctor tempDoctor = new Doctor(tempName, tempSurname, tempMobileNumber, tempDate, tempMedicalLicenseNumber, tempSpecialisation, tempAvailable);
                    
                    newInterface.addNewDoctor(tempDoctor);//adds the doctor to the list

                } else {
                    System.out.println("Doctors List is Full cannot add more doctors");
                }
                
                
                newInterface.consoleMainMenu();

            } else if (choice == 2) {
                newInterface.deleteDoctor();
                newInterface.consoleMainMenu();

            } else if (choice == 3) {
                newInterface.printListOfDoctor();
                newInterface.consoleMainMenu();

            } else if (choice == 4) {
                newInterface.saveInAFile(doctorsListFile);
                newInterface.consoleMainMenu();
                

            } else if (choice == 5) {
                MainMenuGUI frame = new MainMenuGUI();
                
            } else if (choice == 6){
                System.out.println("Exiting...");
            }else{
                System.out.println("");
                System.out.println("That Is Not An Option");
                newInterface.consoleMainMenu();
            }
        } catch (NumberFormatException e) {
            System.out.println("That Is Not A Number");
            newInterface.consoleMainMenu();
        }
    }

    @Override
    public boolean addNewDoctor(Doctor tempDoctor) {//adds doctor to the list
        
        doctorsList.add(tempDoctor);

        System.out.println("Added Doctor: " + tempDoctor);
        return true;
    }

    @Override
    public void deleteDoctor() {//loops through the iist allows the user to select a doctor then removes it from the lsit.
        for (int i = 0; i < doctorsList.size(); i++) {
            System.out.println(i + ". " + doctorsList.get(i) + " ");
        }
        System.out.println("Enter A Doctors Medical License Number From The List To Delete: ");
        Scanner myObj = new Scanner(System.in);

        String userInput = myObj.nextLine();
        int index = 0;
        
        for (int i = 0; i < doctorsList.size(); i++) {
            if (doctorsList.get(i).getMedicalLicenseNumber().equals(userInput)){
                index = i;
                break;
            }
        }
        System.out.println("Removing Doctor: " + doctorsList.get(index));//tehn outputs the removed doctor and how many doctors are left
        doctorsList.remove(index);
        System.out.println("Total Doctors left: " + doctorsList.size());
    }

    @Override
    public String printListOfDoctor() {

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        // sort using comparator: sort by surname
        Collections.sort(doctorsList, new Comparator<Doctor>() {
            @Override
            public int compare(Doctor object1, Doctor object2) {
                return object1.surname.compareTo(object2.surname);
            }
        });

        System.out.println("Elements of doctorsList are:");
        System.out.println("");
        for (int i = 0; i < doctorsList.size(); i++) {//loops througn the list of doctors and prints them
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
        
        
        
        return baos.toString();
    }

    @Override
    public boolean saveInAFile(File doctorsListFile) {
        //WRITE TO A FILE
        System.out.println("Saving doctors to file");
        int i;
        Doctor tempDoc;

        try {
            FileWriter myWriter = new FileWriter(doctorsListFile);//creating objects to save to the file
            BufferedWriter bw = new BufferedWriter(myWriter);

            for (i = 0; i < doctorsList.size(); i++) {//loops through the list and then saves them

                System.out.println("");
                tempDoc = doctorsList.get(i);
                bw.write(tempDoc.getName());
                bw.write(System.lineSeparator());
                bw.write(tempDoc.getSurname());
                bw.write(System.lineSeparator());
                bw.write(tempDoc.getDob().toString());
                bw.write(System.lineSeparator());
                bw.write(tempDoc.getMobileNumber());
                bw.write(System.lineSeparator());
                bw.write(tempDoc.getMedicalLicenseNumber());
                bw.write(System.lineSeparator());
                bw.write(tempDoc.getSpecialisation());
                bw.write(System.lineSeparator());
                bw.write(String.valueOf(tempDoc.getAvailable()));
                bw.write(System.lineSeparator());
            }
            bw.close();
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            return false;
        }
    }

    @Override
    public void readingIn(){
        System.out.println("Reading in");//funtion reads through the file then saves it into the list
        int lineCount = 0;
        Doctor tempDoctor;
        FileReader fr = null;
        Date tempDOB = null;
        
        try {
            fr = new FileReader(doctorsListFile);//create object to read file
            try (BufferedReader br = new BufferedReader(fr)) {
                String line;
                while((line = br.readLine()) != null){//loop through the file
                    if(lineCount == 0){
                        tempName = line;//add lines to the temp variables
                        lineCount++;
                        
                    }else if(lineCount == 1){
                        tempSurname = line;
                        lineCount++;
                        
                    }else if(lineCount == 2){//this checks for the integers in the line
                        integerList.clear();
                        Pattern integerPattern = Pattern.compile("-?\\d+");
                        Matcher matcher = integerPattern.matcher(line);

                        while (matcher.find()) {
                            integerList.add(matcher.group());
                        }
                        tempDay = Integer.parseInt(integerList.get(0));//saves them to the right variable
                        tempMonth = Integer.parseInt(integerList.get(1));
                        tempYear = Integer.parseInt(integerList.get(2));
                        tempDOB = new Date(tempDay, tempMonth, tempYear);//and creates the date from it.
                        lineCount++;
                        
                    }else if(lineCount == 3){
                        tempMobileNumber = line;
                        lineCount++;
                        
                    }else if(lineCount == 4){
                        tempMedicalLicenseNumber = line;
                        lineCount++;
                    }else if(lineCount == 5){
                        tempSpecialisation = line;
                        lineCount++;
                    }else if(lineCount == 6){
                        tempAvailable =  Boolean.parseBoolean(line);
                        tempDoctor = new Doctor(tempName, tempSurname, tempMobileNumber, tempDOB, tempMedicalLicenseNumber, tempSpecialisation, tempAvailable);
                        doctorsList.add(tempDoctor);
                        lineCount = 0;
                    }
                }
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println("IOException");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
    }
    
    @Override
    public void initialise() { //reads through the patients and cionsultations list seperatley.
        FileReader fr = null;
        String line;
        int lineCount = 0;
        
        //Initialise the Timeslots
        for(int count = 0; count < 24; count++){
            timeSlots.add(count);
        }
           
        try {
            fr = new FileReader(consultationListFile);
            BufferedReader br = new BufferedReader(fr);
            
            while ((line = br.readLine()) != null) {
                if(lineCount == 0){
                    tempName = line;
                    lineCount++;
                    
                } else if(lineCount == 1){
                    tempSurname = line;
                    lineCount++;
                    
                } else if(lineCount == 2){
                    integerList.clear();
                    Pattern integerPattern = Pattern.compile("-?\\d+");
                    Matcher matcher = integerPattern.matcher(line);

                    while (matcher.find()) {
                        integerList.add(matcher.group());
                    }
                    tempDay = Integer.parseInt(integerList.get(0));
                    tempMonth = Integer.parseInt(integerList.get(1));
                    tempYear = Integer.parseInt(integerList.get(2));
                    lineCount++;
                    
                } else if(lineCount == 3){
                    tempMobileNumber = line;
                    lineCount++;
                    
                } else if(lineCount == 4){
                    tempMedicalLicenseNumber = line;
                    lineCount++;
                    
                } else if(lineCount == 5){
                    tempSpecialisation = line;
                    lineCount++;
                    
                }else if(lineCount == 6){
                    tempAvailable =  Boolean.parseBoolean(line);
                    tempDoctorDOB = new Date(tempDay, tempMonth, tempYear);
                    tempDoctor = new Doctor(tempName, tempSurname, tempMobileNumber, tempDoctorDOB, tempMedicalLicenseNumber, tempSpecialisation, tempAvailable);
                    lineCount++;
                }else if(lineCount == 7){
                    tempName = line;
                    lineCount++;
                    
                }else if(lineCount == 8){
                    tempSurname = line;
                    lineCount++;
                    
                } else if (lineCount == 9) {
                    integerList.clear();
                    System.out.println();
                    Pattern integerPattern = Pattern.compile("-?\\d+");
                    Matcher matcher = integerPattern.matcher(line);

                    while (matcher.find()) {
                        integerList.add(matcher.group());
                    }
                    tempDay = Integer.parseInt(integerList.get(0));
                    tempMonth = Integer.parseInt(integerList.get(1));
                    tempYear = Integer.parseInt(integerList.get(2));
                    lineCount++;
                    
                }else if(lineCount == 10){
                    tempMobileNumber = line;
                    lineCount++;
                    
                }else if(lineCount == 11){
                    tempUniqueID = Integer.parseInt(line);
                    tempPatientDOB = new Date(tempDay, tempMonth, tempYear);
                    tempPatient = new Patient(tempName, tempSurname, tempMobileNumber, tempPatientDOB, tempUniqueID);
                    lineCount++;
                    
                }else if(lineCount == 12){
                    integerList.clear();
                    Pattern integerPattern = Pattern.compile("-?\\d+");
                    Matcher matcher = integerPattern.matcher(line);

                    while (matcher.find()) {
                        integerList.add(matcher.group());
                    }
                    tempDay = Integer.parseInt(integerList.get(0));
                    tempMonth = Integer.parseInt(integerList.get(1));
                    tempYear = Integer.parseInt(integerList.get(2));
                    
                    tempAppointmentDate = new Date(tempDay, tempMonth, tempYear);
                    lineCount++;
                    
                }else if(lineCount == 13){
                    integerList.clear();
                    Pattern integerPattern = Pattern.compile("-?\\d+");
                    Matcher matcher = integerPattern.matcher(line);

                    while (matcher.find()) {
                        integerList.add(matcher.group());
                    }
                    tempHour = Integer.parseInt(integerList.get(0));
                    tempMinute = Integer.parseInt(integerList.get(1));
                    
                    tempAppointmentTime = new Time(tempHour, tempMinute);
                    lineCount++;
                    
                } else if(lineCount == 14){
                    tempCost = Integer.parseInt(line);
                    lineCount++;
                    
                }else if(lineCount == 15){
                    tempNotes = line;
                    
                    Consultation tempConsultation = new Consultation(tempDoctor, tempPatient, tempAppointmentDate, tempAppointmentTime, tempCost, tempNotes);
                    consultationList.add(tempConsultation);
                    lineCount = 0;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println("IOException");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
        
        try {
            lineCount = 0;
            fr = new FileReader(patientsListFile);
            BufferedReader br = new BufferedReader(fr);
            
            while ((line = br.readLine()) != null) {
                if(lineCount == 0){
                    tempName = line;
                    lineCount++;
                    
                } else if(lineCount == 1){
                    tempSurname = line;
                    lineCount++;
                    
                }else if(lineCount == 2){
                    integerList.clear();
                    Pattern integerPattern = Pattern.compile("-?\\d+");
                    Matcher matcher = integerPattern.matcher(line);

                    while (matcher.find()) {
                        integerList.add(matcher.group());
                    }
                    tempDay = Integer.parseInt(integerList.get(0));
                    tempMonth = Integer.parseInt(integerList.get(1));
                    tempYear = Integer.parseInt(integerList.get(2));

                    tempPatientDOB = new Date(tempDay, tempMonth, tempYear);
                    lineCount++;                    
                    
                }else if(lineCount == 3){
                    tempMobileNumber = line;
                    lineCount++;
                    
                }else if(lineCount == 4){
                    tempUniqueID = Integer.parseInt(line);
                    tempPatient = new Patient(tempName, tempSurname, tempMobileNumber, tempPatientDOB, tempUniqueID);
                    patientList.add(tempPatient);
                    lineCount = 0;
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        } catch (IOException ex) {
            System.out.println("IOException");
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                System.out.println("IOException");
            }
        }
    }
}
    