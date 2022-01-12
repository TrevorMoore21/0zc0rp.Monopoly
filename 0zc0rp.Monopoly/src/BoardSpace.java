
public class BoardSpace
	{
		private String type, name, owner;
		private int cost, location;
		
		public BoardSpace()
		{}
		
		public BoardSpace(String t , String n, int c, String o, int l)
		{
			type = t;
			name = n;
			cost = c;
			owner = o;
			location = l;
		}
		

		public String getType()
			{
				return type;
			}

		public void setType(String type)
			{
				this.type = type;
			}
		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
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
