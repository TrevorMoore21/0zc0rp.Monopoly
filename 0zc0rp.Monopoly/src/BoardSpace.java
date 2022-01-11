
public class BoardSpace
	{
		private String type;
		public String getType()
			{
				return type;
			}

		public void setType(String type)
			{
				this.type = type;
			}

		private int cost;
		private String owner;
		private int location;
		
		public BoardSpace()
		{}
		
		public BoardSpace(String t , int c, String o, int l)
		{
			type = t;
			cost = c;
			owner = o;
			location = l;
		}

		public int getCost()
			{
				return cost;
			}

		public void setCost(int cost)
			{
				this.cost = cost;
			}

		public String getOwner()
			{
				return owner;
			}

		public void setOwner(String owner)
			{
				this.owner = owner;
			}

		public int getLocation()
			{
				return location;
			}

		public void setLocation(int location)
			{
				this.location = location;
			}
	}
