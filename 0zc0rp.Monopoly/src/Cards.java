
public class Cards extends BoardSpace
{
	private String type, content;
	private int value;
	
	public Cards(String t, int v, String c)
	{
		type = t;
		content = c;
	}
	
	public Cards()
	{}

	public String getType()
		{
			return type;
		}

	public void setType(String type)
		{
			this.type = type;
		}

	public String getContent()
		{
			return content;
		}

	public void setContent(String content)
		{
			this.content = content;
		}

	public int getValue()
		{
			return value;
		}

	public void setValue(int value)
		{
			this.value = value;
		}	
}
	
		
	
		
	
