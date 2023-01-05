package w1824056MohammadKibriaCoursework;

public class Patient extends Person{
    public int uniqueID;
    
    //CONSTRUCTOR METHOD--------------------------------------------------------
    public Patient(String name, String surname, String mobileNumber, Date dob, int uniqueID){
        this.name = name;
        this.surname = surname;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.uniqueID = uniqueID;
    }
    
    //SET METHODS---------------------------------------------------------------
    public void setUniqueID(int uniqueID){
        this.uniqueID = uniqueID;
    }
    
    //GET METHODS---------------------------------------------------------------
    public int getUniqueID(){
        return uniqueID;
    }
    
    @Override
    public String toString(){
        return "[Name: " + name + ", Surname: " + surname + ", DOB: " + dob + ", Mobile Number: " + mobileNumber + ", Unique ID: " + uniqueID +"]";
    }
    
}
