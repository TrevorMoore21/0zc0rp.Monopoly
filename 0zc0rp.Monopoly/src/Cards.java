
public class Cards extends BoardSpace
{
	private String type, content;
	private int value;
	
	public Cards(String t, String c, int v)
	{
		type = t;
		content = c;
		value = v;
	}

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
	
		
	
		
	
