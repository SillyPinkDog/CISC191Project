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
 * Day stores the user data for a specific day including the calories consumed, cost of eating out, weight, and additional notes.
 */
public class Day 
{
	private int caloriesConsumed; //Day has-a int that holds the calories the user consumed today
	private double eatOutCost; //Day has-a double that holds the amount the user spent eating out today
	private double userWeight; //Day has-a double that holds the user's weight today
	private String comments; //Day has-a String that holds additional info the user might want to add
	private final String dayOfWeek; //Day has-a String that holds the day of the week mon-sun

	/**
	 * default constructor determines which day of the week the object is when instantiated
	 * sets the eatOutCost to 0 by default
	 * @param day represents which day of the week it is
	 */
	public Day(String day)
	{
		dayOfWeek = day;
		eatOutCost = 0;
		caloriesConsumed = 0;
		userWeight = 0;
		comments = "Add something";
	}
	
	/**
	 * copy constructor is used when the program is launched and reading from file
	 * @param day represents which day of the week it is
	 * @param info additional user info
	 * @param weight of user that day
	 * @param cost of eating out that day
	 * @param calories gained that day
	 */
	public Day(String day, String info, double weight, double cost, int calories)
	{
		dayOfWeek = day;
		eatOutCost = cost;
		caloriesConsumed = calories;
		userWeight = weight;
		comments = info;
	}
	
	/**
	 * 
	 * @param calories represents the amount of calories consumed
	 */
	public void setCalories(int calories)
	{
		caloriesConsumed = calories;
	}
	
	/**
	 * 
	 * @param eatOut represents the $ spent eating out that day
	 */
	public void setEatOutCost(double eatOut)
	{
		eatOutCost = eatOut;
	}
	
	/**
	 * 
	 * @param weight is the amount of weight the user is at that day
	 */
	public void setWeight(double weight)
	{
		userWeight = weight;
	}
	
	/**
	 * 
	 * @param info is additional information the user would like to add like notes
	 */
	public void setInfo(String info)
	{
		comments = info;
	}
	
	/**
	 * 
	 * @return the calories eaten in the day
	 */
	public int getCalories()
	{
		return caloriesConsumed;
	}
	
	/**
	 *
	 * @return the amount spent on eating out that day
	 */
	public double getEatOutCost()
	{
		return eatOutCost;
	}
	/**
	 * 
	 * @return the day's weight
	 */
	public double getWeight()
	{
		return userWeight;
	}
	
	/**
	 *
	 * @return additional notes the user may have written down for that day
	 */
	public String getInfo()
	{
		return comments;
	}
	
	/**
	 * 
	 * @return the day of the week
	 */
	public String getDay()
	{
		return dayOfWeek;
	}
	
	/**
	 * @return the data in a day formatted for ease of writing to a file
	 */
	public String toString()
	{
		return getDay() + "\n" + getInfo() + "\n" + getWeight() + "\n" + getEatOutCost() + "\n" + getCalories()
		+ "\n";
	}
}