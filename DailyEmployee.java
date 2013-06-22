//A concrete class to represent Daily Employees
public class DailyEmployee extends ClockedEmployee{
    public TimeCard card;
    public DailyEmployee(){
        super(7.25);
	card = new TimeCard();
	 }

    public double overtime(){
        double ot = 0.0;
        TimeCard c;
        for(TimeCard.DayOfWeek a: TimeCard.DayOfWeek.values()){
            if(this.card.getHours(a) > 9)
                ot+=this.card.getHours(a)-9;
        }
        return ot;
    }

}
