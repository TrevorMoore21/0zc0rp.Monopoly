
public class BoardSpace
	{
		private int cost;
		private String owner;
		private int location;
		
		public BoardSpace()
		{}
		
		public BoardSpace(int c, String o, int l)
		{
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
