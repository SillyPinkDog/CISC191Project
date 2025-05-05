
public class Day 
{
	private int dayCalories;
	private double eatOutCost;
	private double dayWeight;
	private double mealSum;
	private String addInfo;
	private static String dayOfWeek;

	/**
	 * constructor determines which day of the week the object is when instantiated
	 * sets the eatOutCost to 0 by default
	 * @param day represents which day of the week it is
	 */
	public Day(String day)
	{
		dayOfWeek = day;
		eatOutCost = 0;
	}
	
	/**
	 * 
	 * @param calories represents the amount of calories consumed
	 */
	public void setCalories(int calories)
	{
		dayCalories = calories;
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
	public void setWeightGain(double weight)
	{
		dayWeight = weight;
	}
	
	/**
	 * 
	 * @param sum is the recommended caloric intake for the day
	 */
	public void setSummary(double sum)
	{
		mealSum = sum;
	}
	
	/**
	 * 
	 * @param info is additional information the user would like to add like notes
	 */
	public void setInfo(String info)
	{
		addInfo = info;
	}
	
	/**
	 * 
	 * @return the calories eaten in the day
	 */
	public int getCalories()
	{
		return dayCalories;
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
		return dayWeight;
	}
	
	/**
	 * 
	 * @return the recommended caloric intake for the day
	 */
	public double getSummary()
	{
		return mealSum;
	}
	
	/**
	 *
	 * @return additional notes the user may have written down for that day
	 */
	public String getInfo()
	{
		return addInfo;
	}
	
	/**
	 * 
	 * @return the day of the week
	 */
	public String getDay()
	{
		return dayOfWeek;
	}
}
