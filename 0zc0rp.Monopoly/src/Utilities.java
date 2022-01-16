
public class Utilities extends BoardSpace
	{
		private int oneOwnedRent;
		private int twoOwnedRent;
		
		public Utilities(String n, int c, String o, int l, int oR, int tR)
			{
				setName(n);
				setCost(c);
				setOwner(o);
				setLocation(l);
				oneOwnedRent = oR;
				twoOwnedRent = tR;
			}

		public int getOneOwnedRent()
			{
				return oneOwnedRent;
			}

		public void setOneOwnedRent(int oneOwnedRent)
			{
				this.oneOwnedRent = oneOwnedRent;
			}

		public int getTwoOwnedRent()
			{
				return twoOwnedRent;
			}

		public void setTwoOwnedRent(int twoOwnedRent)
			{
				this.twoOwnedRent = twoOwnedRent;
			}
		
		
	}
