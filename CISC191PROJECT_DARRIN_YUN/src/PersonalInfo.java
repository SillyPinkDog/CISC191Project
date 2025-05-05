
public class PersonalInfo 
{
	private double startWeight;
	private int height; //inches
	private String name;
	
	public PersonalInfo()
	{
		startWeight = 0;
		this.height = 0;
		this.name = "";
	}
	
	public void setStartWeight(double weight)
	{
		startWeight = weight;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public double getStartWeight()
	{
		return startWeight;
	}
	
	public int getHeight() //inches
	{
		return height;
	}
	
	public String getName()
	{
		return name;
	}
}
