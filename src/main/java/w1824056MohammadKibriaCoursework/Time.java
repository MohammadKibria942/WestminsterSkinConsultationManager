package w1824056MohammadKibriaCoursework;

public class Time {
    public int hour;
    public int minute;
    
    //CONSTRUCTOR METHOD--------------------------------------------------------
    public Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }
    
    //SET METHODS---------------------------------------------------------------
    public void setHour(int hour){
        this.hour = hour;
    }
    
    public void setMinute(int minute){
        this.minute = minute;
    }
    
    //GET METHODS---------------------------------------------------------------
    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public String getTime(){
        return String.format("%02d:%02d", hour, minute);
    }
    
    @Override
    public String toString(){
        return "[Hour: " + hour + ", Minute: " + minute + "]";
    }
    
}
