import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class EmployeeClient
{
   //A Comparator for Employees
   // Primary key   : Employee category - Salaried > Weekly > Daily
   // Secondary key : Employee gross pay
   private static class EmployeeComparator implements Comparator
   {
       public int compare(Object one, Object two)
        {
          Employee Employee1 = (Employee)one;
          Employee Employee2 = (Employee)two;
          if(Employee1.getClass() ==  Employee2.getClass()){
            return (int)(Employee1.grossPay() - Employee2.grossPay())*100;
          }

          else if(Employee1 instanceof SalariesEmployee){
            if(Employee2 instanceof ClockedEmployee){
              return 1;
            }
          }

          else if(Employee1 instanceof ClockedEmployee){
            if(Employee2 instanceof SalariesEmployee){
              return -1;
            }
          }
          return -9;
        }
   }

   //Application program
   // 1) Load employee data into a list of Employee elements
   // 2) Create a weekly payroll file from the Employee list
   public static void main(String[] args) throws IOException
   {
      ArrayList<Employee> company = new ArrayList<Employee>();
      
      Scanner inStream = new Scanner( new FileReader("employees.txt") );
      loadEmployeeData(company, inStream);
      
      PrintWriter payRollFile = new PrintWriter("payroll.txt");
      runPayroll(company, payRollFile);
   }
   
   //Load Employee data from a data file into aList of Employee elements 
   // Pre-Condition: A scanner for the data file is provided as a parameter
   // Pre-Condition: An empty list to store the data is provided as a parameter
   // Post-condition: Each data record from the data file is recorded in a list element
   // Post-Condition: The list is sorted
   public static void loadEmployeeData(List<Employee> company, Scanner source)
   {      
       Comparator Cmp = new EmployeeComparator();
       while ( source.hasNext() )
       {
         String input = source.nextLine();
         Scanner scan = new Scanner(input);
	 Employee emp = null;
         SalariesEmployee semp;
         WeeklyEmployee wemp;
         DailyEmployee demp;
         
         int day = 0; 
         //Create an Employee record from the input 
         String EmployeeType;
         double wage = 0.0;
         EmployeeType = scan.next();
         EmployeeType = EmployeeType.trim();
	 TimeCard.DayOfWeek[] dow = TimeCard.DayOfWeek.values();
 	          
         if(EmployeeType.equalsIgnoreCase("S")){
             semp = new SalariesEmployee(scan.nextDouble());
             emp = (Employee)semp;
         }
         else if(EmployeeType.equalsIgnoreCase("W")){
             wemp = new WeeklyEmployee(scan.nextDouble());
               while(scan.hasNext() || (day < 7)){
		wemp.card.updateHours(dow[day], scan.nextDouble());
                day++;
               }
               emp = (Employee)wemp;
         }
         else if (EmployeeType.equalsIgnoreCase("D")){
               demp = new DailyEmployee();
               while(scan.hasNext() || (day < 7 )){
                demp.card.updateHours(dow[day], scan.nextDouble()); 
                day++;
              }
               emp = (Employee)demp;
         }
         else if(emp == null)
             throw new RuntimeException("No employee was created");
         company.add(emp);
      }
      Collections.sort(company, new EmployeeComparator());
   }
   
   //Create a payroll output file
   // Each record of the output file describes a single employee including - 
   //    Stored employee data, overtime hours (if applicable), gross pay amount
   public static void runPayroll(ArrayList<Employee> company, PrintWriter outFile)
   {
      for (Employee emp : company){
         outFile.println( emp );
         }
       outFile.close();
   }


}   
