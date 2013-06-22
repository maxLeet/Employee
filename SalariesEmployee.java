//A class to represent Salaries Employees
public class SalariesEmployee extends Employee
{

    public SalariesEmployee(){
        super();
    }
    public SalariesEmployee(double r){
        super(r);
    }

    public double grossPay(){
        return ((this.getPayRate() * 40)* 12);
    }

}
