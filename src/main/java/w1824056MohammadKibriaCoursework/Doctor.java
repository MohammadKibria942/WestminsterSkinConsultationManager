package w1824056MohammadKibriaCoursework;

public class Doctor extends Person {

    public String medicalLicenseNumber;
    public String specialisation;
    public boolean available;

    //CONSTRUCTOR METHOD--------------------------------------------------------------------------
    public Doctor(String name, String surname, String mobileNumber, Date dob, String medicalLicenseNumber, String specialisation, boolean available) {
        this.name = name;
        this.surname = surname;
        this.mobileNumber = mobileNumber;
        this.dob = dob;
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialisation = specialisation;
        this.available = true;
    }

    //SET METHODS----------------------------------------------------------------------------------
    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    //GET METHODS----------------------------------------------------------------------------------
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public String getSpecialisation() {
        return specialisation;
    }
    
    public boolean getAvailable(){
        return available;
    }
    
    @Override
    public String toString(){
        return name + " " +  surname  + " " + dob + " " + mobileNumber + " " + medicalLicenseNumber + " " + specialisation + available;
    }

}
