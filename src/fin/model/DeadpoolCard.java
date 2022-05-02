package fin.model;

public class DeadpoolCard extends Card
{
	
	public DeadpoolCard(String name, int value, String path)
	{
		super(name, value, path);
	}
	
	@Override
	public String getPath()
	{
		return "/fin/view/deadpool/";
	}
}
