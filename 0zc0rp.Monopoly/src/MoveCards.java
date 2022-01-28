
public class MoveCards extends Cards
	{
		private int value;
		
		public MoveCards(String t, String c, int v)
		{
			setType(t);
			setContent(c);
			value = v;
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
