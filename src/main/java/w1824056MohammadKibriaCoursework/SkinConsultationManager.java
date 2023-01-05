package w1824056MohammadKibriaCoursework;

import java.io.File;

public interface SkinConsultationManager {
    
    public void consoleMainMenu();
    public boolean addNewDoctor(Doctor tempDoctor);
    public void deleteDoctor();
    public String printListOfDoctor();
    public boolean saveInAFile(File textFile);
    public void readingIn();
    public void initialise();
    
}