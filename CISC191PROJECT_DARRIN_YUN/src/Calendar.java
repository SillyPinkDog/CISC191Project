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
 * Calendar will read the user data and store it in an ArrayList of Weeks. Calendar holds all of the Days, and can calculate useful
 * information about the aggregated data. Such as average weight gain, cost of groceries, cost of eating out, and total cost across all days.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Calendar 
{
	//Calendar has-many weeks
	private ArrayList<Week> calendar = new ArrayList<Week>(); //this arraylist of weeks will hold all of the user's data
	private PersonalInfo user; //Calendar has-a PersonalInfo that represents the user's data

	/**
	 * reads the users data from a file
	 * @param file the file to read from
	 * @param user the user's personal data
	 */
	public Calendar(PersonalInfo user)
	{
		this.user = user;
	}
	
	public void readUserData(String file, PersonalInfo user)
	{
		File userdata = new File(file); //make file object from the name of the file to read
		this.user = user;
		Scanner scan = null;

		//in the case that scanner cannot find the file 
		try
		{
			if(userdata.exists())
			{
				int weekNum = 0; //keep track of which week we are in
				double weekGroceryCost = 0; //the cost of groceries to set for that week
				scan = new Scanner(userdata); //Create a Scanner object using the File object 	
				
				user.setName(scan.nextLine());
				user.setHeight(Integer.parseInt(scan.nextLine()));
				user.setStartWeight(Double.parseDouble(scan.nextLine()));
				user.setAge(Integer.parseInt(scan.nextLine()));
				
				while(scan.hasNextLine()) //go through file as long as there is a line
				{
					int daysOfWeek = 0; //keep track of which day we are on and reset to 0
					weekNum = Integer.parseInt(scan.nextLine()); //read in which week this is
					weekGroceryCost = Double.parseDouble(scan.nextLine()); //read in the cost of groceries for that week
					ArrayList<Day> weekInfo = new ArrayList<Day>(); //create a new arraylist of days
					//go through that week and add data for each day of that week
					while(daysOfWeek < 7) //loop for 7 days of the week
					{ 
						String dayName = scan.nextLine(); //get the name of the day
					    String info = scan.nextLine(); //get the additional info
					    double weight = Double.parseDouble(scan.nextLine()); //get the weight 
					    double eatOutCost = Double.parseDouble(scan.nextLine()); //get the cost of eating out
					    int calories = Integer.parseInt(scan.nextLine()); //get the calories consumed 
					    Day day = new Day(dayName, info, weight, eatOutCost, calories); //create a new Day object with this data
					    weekInfo.add(day); //add this day to the arraylist of days
						daysOfWeek++;
					}
					//add a new week to the calendar by passing a Week object that includes some data
					calendar.add(new Week(weekNum, weekInfo, weekGroceryCost, user));
				}
			} 
		}
		//If all the UserDataWriter formats data as intended, then reading data should go smoothly!
		
		catch (FileNotFoundException e) 
		{  
		    // This block of code runs if the file is not found 
			e.printStackTrace(); 
		} 
		
		//this finally block will close the stream
		finally 
		{
		   if(scan!=null)
		    {
		       scan.close();
		    } 
		}
	}
	
	/**
	 * 
	 * @return the average cost of groceries per week
	 */
	public double getAvgGroceryCost()
	{
		double avgGrocery = 0;
		for(Week week:calendar) //iterate through the calendar
			avgGrocery += week.getWeekGroceryCost(); //sum the cost
		avgGrocery = avgGrocery / calendar.size(); //calculate average
		return avgGrocery;
	}
	
	/**
	 * calculates the average weight of the user
	 * @return average weight of the user
	 */
	public double getDailyAvg()
	{
		int numberOfDays = 0;
		double sum = 0;
		for(Week week:calendar) //iterate through calendar
		{
			for(Day day:week.getWeekInfo()) //iterate through each day 
			{
				if(day.getWeight() != 0) //if the weight exists for that day then add it to the sum
				{
					numberOfDays++; //increase number of days for every time sum is added to
					sum += day.getWeight();
				}
			}
		}
		return sum / numberOfDays; //mean
	}
	
	/**
	 * 	calculate the average amount spent on eating out per day
	 * @return average amount user spends eating out per day
	 */
	public double getAvgEatOutCost()
	{
		int numberOfDays = 0;
		double sum = 0;
		for(Week week:calendar) //iterate through calendar
		{
			for(Day day:week.getWeekInfo()) //iterate through each day
			{
				numberOfDays++; //increase number of days for every time sum is added to
				sum += day.getEatOutCost(); //sum the cost
			}
		}
		return sum / numberOfDays; //mean
	}
	
	/**
	 * 
	 * @return the sum of all weeks grocery costs
	 */
	public double getTotalGrocery()
	{
		double sum = 0;
		for(Week week:calendar) //iterate through calendar
			sum += week.getWeekGroceryCost(); //add it up
		return sum;
	}
	
	/**
	 * sum all the costs of eating out throughout the use of the health calendar
	 * @return
	 */
	public double getTotalEatOut()
	{
		double sum = 0;
		for(Week week:calendar) //iterate through calendar
			for(Day day:week.getWeekInfo()) //iterate through each day
				sum += day.getEatOutCost();//add it up
		return sum;
	}
	
	/**
	 * 
	 * @return the cost of eating out + the cost of all groceries
	 */
	public double getTotalSpent()
	{
		return getTotalGrocery() + getTotalEatOut();
	}
	
	/**
	 * calculates the average BMI of the user across weeks
	 * @return BMI of the user
	 */
	public double getAvgBMI()
	{
		double avgBMI = 0;
		for(Week week:calendar) //iterate through each week
			if(week.getWeekBMI() != 0) //only count weeks with a BMI
				avgBMI += week.getWeekBMI(); //add it up
		avgBMI = avgBMI / calendar.size(); //mean
		return avgBMI;
	}
	
	/**
	 * 
	 * @return the arraylist of weeks containing the full calendar's data
	 */
	public ArrayList<Week> getCalendar()
	{
		return calendar;
	}
	
	/**
	 * adds a new week to the calendar
	 */
	public void addWeek()
	{
		calendar.add(new Week(calendar.size()+1, user));
	}

}