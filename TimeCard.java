//A class to represent a clocked employee's 7-day time-card
public class TimeCard
{
   public enum DayOfWeek
   {
      MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
   }
   
   //Instance Variable: records the hours worked on each day of the week
   private double[] card;
   
   //Constructor: create a new TimeCard with 0.0 hours for each day
   public TimeCard(double[] a){
	card = a;	
   }
   public TimeCard()
   {
       card = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
   }
   
   //Accessor: return the recorded hours from this TimeCard for the indicated day
   public double getHours(DayOfWeek day)
   {
      return this.card[day.ordinal()-1];
   }
   //Accessor: return the recorded hours from this TimeCard for the entire week 
   public double[] getHours()
   {
       double[] hrs = new double[7];
       hrs = this.card;
       return hrs;
   }

   //Mutator: Accumulate the hours in this TimeCard for the indicated day
   public void updateHours(DayOfWeek day, double hrs)
   {
        this.card[day.ordinal()] += hrs;

   }
   
   //Override: return an image of this TimeCard
   public String toString()
   {
       String dowString = "";
        for(DayOfWeek dow: DayOfWeek.values()){
            dowString = dow.toString() + ": " + getHours(dow) ;
        }
      return dowString;
   }
}
