package w1824056MohammadKibriaCoursework;

public class Date {
    public int day;
    public int month;
    public int year;
    
    //CONSTRUCTOR METHOD--------------------------------------------------------
    public Date(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //SET METHODS-------------------------------------
    public void setDay(int day){
        this.day = day;
    }
    
    public void setMonth(int month){
        this.month = month;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public void setDate(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    //GET METHODS--------------------------------------
    public int getDay(){
        return day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getDate(){
        return String.format("%02d/%02d/%04d", day, month, year);
    }
    
    @Override
    public String toString(){
        return "[Day: " + day + ", Month: " + month + ", Year: " + year + "]";
    }
}
