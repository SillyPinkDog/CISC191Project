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
 * Holds the data of a user's personal info including their name, starting weight, height, and age
 */
public class PersonalInfo 
{
	private double startWeight = 0; //PersonalInfo has-a double. It makes sense to make this variable final, but I'll leave it up to the user to change their starting weight if they desire
	private int height = 0; //PersonalInfo has-a int that holds the height of the user
	private String name = ""; //PersonalInfo has-a String that holds the name of the user
	private int age = 0; //PersonalInfo has-a age that holds the age of the user
	
	/**
	 * 
	 * @param weight starting weight of the user
	 */
	public void setStartWeight(double weight)
	{
		startWeight = weight;
	}
	
	/**
	 * 
	 * @param age of the user
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * 
	 * @param height of the user
	 */
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	/**
	 * 
	 * @param name of the user
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 
	 * @return the starting weight of the user
	 */
	public double getStartWeight() //pounds
	{
		return startWeight;
	}
	
	/**
	 * 
	 * @return the height of the user in inches
	 */
	public int getHeight() //inches
	{
		return height;
	}
	
	/**
	 * 
	 * @return the age of the user in years
	 */
	public int getAge()
	{
		return age;
	}
	
	/**
	 * 
	 * @return name of the user 
	 */
	public String getName()
	{
		return name;
	}
}
