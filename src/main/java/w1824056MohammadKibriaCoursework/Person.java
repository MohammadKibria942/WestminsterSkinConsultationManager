package w1824056MohammadKibriaCoursework;

public class Person {
    public String name;
    public String surname;
    public Date dob;
    public String mobileNumber;
    
    //SET METHODS---------------------------------------------------------------
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public void setDob(Date dob){
        this.dob = dob;
    }
    
    public void setMobileNumber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    
    //GET METHODS---------------------------------------------------------------
    public String getName(){
        return name;
    }
    
    public String getSurname(){
        return surname;
    }
    
    public Date getDob(){
        return dob;
    }
    
    public String getMobileNumber(){
        return mobileNumber;
    }
    
    @Override
    public String toString(){
        return "[Name: " + name + ", Surname: " + surname + ", DOB" + dob + ", Mobile Number" + mobileNumber + "]";
    }
    
}
