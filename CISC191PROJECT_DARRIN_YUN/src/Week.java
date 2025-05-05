import java.util.ArrayList;
public class Week 
{
	private double weekGroceryCost;
	private double weekWeightGain;
	private double weekBMI;
	private int recCalIntake;
	private static int weekNum;
	private ArrayList<Day> weekInfo;
	private PersonalInfo myUser;

	public Week(int week, ArrayList<Day> weekInfo, PersonalInfo user)
	{
		 weekNum = week;
		 this.weekInfo = weekInfo;
		 myUser = user;
	}
	
	public void setWeekGroceryCost(double groceryCost)
	{
		weekGroceryCost = groceryCost;
	}
	
	public double getWeekWeightGain()
	{
		double weightGain = 0;
		for(Day i : weekInfo)
			weightGain += i.getWeight();
		return weightGain;
	}
	
	public int setWeekBMI()
	{
		weekBMI = weekInfo.get(6). myUser.getHeight() * 2.54 + 
	}
}
