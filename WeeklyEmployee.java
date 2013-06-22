//A concrete class to represent Weekly Employees
public class WeeklyEmployee extends ClockedEmployee{
    public TimeCard card;
    public WeeklyEmployee(double r){
        super(r);
	card = new TimeCard();
    }
    public double overtime(){
        double ot = 0.0;
        for(TimeCard.DayOfWeek a: TimeCard.DayOfWeek.values()){
            ot += this.card.getHours(a);
        }
        if(ot > 40)
            return ot-40;
        return 0.0;
    }

}
