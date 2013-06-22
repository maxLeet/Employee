//A class to represent Clocked Employees
public abstract class ClockedEmployee extends Employee
{

    public TimeCard card;

    public ClockedEmployee(double r){
            super(r);
            card = new TimeCard();
    }

    //This function displays the gross pay of this employee.
    public double grossPay(){
        return ((this.getPayRate() * 40) * 12);
    }
  
   //Abstract method overtime() - +40 for weekly employees, +9 for
   //daily employees.
   public abstract double overtime();

}
