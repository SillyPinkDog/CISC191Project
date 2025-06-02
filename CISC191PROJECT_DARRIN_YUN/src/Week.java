/**
 * Lead Author(s):
 * @author Darrin Yun
 * 
 * Other contributors:
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Version/date: v1 5/29/2025
 * 
 * Responsibilities of class:
 * A week class will hold an ArrayList of 7 days which represent days of the week. This class contains methods that can display useful information
 * like BMI, BMR, or the cost of groceries that week.
 */
import java.util.ArrayList;
public class Week 
{
	private double weekGroceryCost; //Week has-a double that holds the cost of groceries
	private final int weekNum; //Week has-a int that holds the week number
	private ArrayList<Day> weekDays; //Week has-many Days, which contains the data of each day of the week
	private PersonalInfo user; //Week has-a PersonalInfo called user, which represents the users info

	/**
	 * default constructor creates a new arraylist of Days and determines the days of week
	 * @param week keeps track of which week this is
	 */
	public Week(int week, PersonalInfo user)
	{
		this.user = user;
		weekNum = week;
		weekDays = new ArrayList<Day>();
		weekDays.add(new Day("Monday"));
		weekDays.add(new Day("Tuesday"));
		weekDays.add(new Day("Wednesday"));
		weekDays.add(new Day("Thursday"));
		weekDays.add(new Day("Friday"));
		weekDays.add(new Day("Saturday"));
		weekDays.add(new Day("Sunday"));
	}
	
	/**
	 * constructor for reading from a file
	 * @param week keeps track of which week this is
	 * @param weekInfo the arraylist being copied over, in this scenario a shallow copy is ok
	 * @param weekGroceryCost the cost of groceries for the week
	 */
	public Week(int week, ArrayList<Day> weekInfo, double weekGroceryCost, PersonalInfo user)
	{
		this.user = user;
		 weekNum = week;
		 this.weekDays = weekInfo;
		 this.weekGroceryCost = weekGroceryCost;
	}
	
	/**
	 * sets the cost of groceries in that week
	 * @param groceryCost
	 */
	public void setWeekGroceryCost(double groceryCost)
	{
		weekGroceryCost = groceryCost;
	}
	
	/**
	 * 
	 * @return 	weight from end of the week subtracted by start of week
	 */
	public double getWeekWeightGain()
	{
		double weightGain = 0;
		weightGain = weekDays.get(6).getWeight() - weekDays.get(0).getWeight();
		return weightGain;
	}
	
	/**
	 * 
	 * @return the total money spent that week
	 */
	public double getMoneySpent()
	{
		double moneySpentThisWeek = 0;
		for(Day day: weekDays) //iterate through the arraylist
			moneySpentThisWeek += day.getEatOutCost(); //add cost of eating out
		moneySpentThisWeek += weekGroceryCost; //add cost in groceries
		return moneySpentThisWeek;
	}
	
	/**
	 * 
	 * @return the arraylist containing the info in each day of a week
	 */
	public ArrayList<Day> getWeekInfo()
	{
		return weekDays;
	}
	
	/**
	 * 
	 * @return the basal metabolic rate 
	 */
	public double getBMR()
	{
		double inToCM = user.getHeight() * 2.54; //convert in to cm
		double lbsToKG = weekDays.get(6).getWeight() * 0.4536; //convert lbs to kgs
		return (10 * lbsToKG) + (6.25 * inToCM) - (5 * user.getAge()) + 5; //formula for BMR
	}
	
	/**
	 * 
	 * @return the cost of groceries
	 */
	public double getWeekGroceryCost()
	{
		return weekGroceryCost;
	}
	
	/**
	 * 
	 * @return the body mass index
	 */
	public double getWeekBMI()
	{
		double inToM = user.getHeight() * 0.0254; //convert in to m
		double lbsToKG = weekDays.get(6).getWeight() * 0.4536; //convert lbs to kgs
		return lbsToKG / (inToM * inToM); //formula for BMI
	}
	
	/**
	 * 
	 * @return which week this is
	 */
	public int getWeekNumber()
	{
		return weekNum;
	}
	
}
