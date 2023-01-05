package w1824056MohammadKibriaCoursework;

public class Consultation {
    public Doctor doctor;
    public Patient patient;
    public Date appointmentDate;
    public Time appointmentTime;
    public int cost;
    public String notes;
    
    //CONSTRUCTOR METHOD--------------------------------------------------------
    public Consultation(Doctor doctor, Patient patient, Date appointmentDate, Time appointmentTime, int cost, String notes){//constructot for all the consultation class
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.cost = cost;
        this.notes = notes;
    }
    
    //SET METHODS---------------------------------------------------------------
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    
    public void setPatientID(Patient patient){
        this.patient = patient;
    }
    
    public void setAppointmentDate(Date appointmentDate){
        this.appointmentDate = appointmentDate;
    }
    
    public void setAppointmentTime(Time appointmentTime){
        this.appointmentTime = appointmentTime;
    }
    
    public void setCost(int cost){
        this.cost = cost;
    }
    
    public void setNotes(String notes){
        this.notes = notes;
    }
    
    //GET METHODS---------------------------------------------------------------
    public Doctor getDoctor(){
        return doctor;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public Date getAppointmentDate(){
        return appointmentDate;
        
    }
    
    public Time getAppointmentTime(){
        return appointmentTime;
    }
    
    public double getCost(){
        return cost;
    }
    
    public String getNotes(){
        return notes;
    }
    
}
