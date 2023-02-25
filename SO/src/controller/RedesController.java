package controller;

public class RedesController 
{

	public RedesController() 
	{
		super();
	}
	public String Os()
	{
		String os = System.getProperty("os.name");
		return os;
	}
	
}
