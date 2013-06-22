//A class to represent Employee
public abstract class Employee 
{
    //Static public variable
    public static int ID = 100000000;
    
    //idNumber is the number that is used to identify an employee
    private String idNumber;
    //payRate is the weekly gross pay (salary) for a salaried employee, buy the
    //hourly pay-rate for a clocked employee;
    private double payRate = 0.0;

    public Employee(){
        this.idNumber = Integer.toString(++ID);
    }
    public Employee(double r){
        this.payRate = r;
        this.idNumber = Integer.toString(++ID);
    }
    public String getID(){
        return this.idNumber;
    }
    public double getPayRate(){
        return this.payRate;
    }
    public String toString(){
        return "Employee: "+this.idNumber.substring(0,this.idNumber.length()-6)
            +"-"+this.idNumber.substring(idNumber.length()-6,idNumber.length()-3)
            +"-"+this.idNumber.substring(3,this.idNumber.length());
    }
    public abstract double grossPay();
    
    /*public int compareTo(Employee other){
        if(this.getPayRate() > other.getPayRate())
            return 1;
        else if(this.getPayRate() < other.getPayRate())
            return -1;
        else if(this.getPayRate() == other.getPayRate())
            return 0;
        
    }*/
}
