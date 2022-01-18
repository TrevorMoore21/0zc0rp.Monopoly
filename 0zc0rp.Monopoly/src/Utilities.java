
public class Utilities extends BoardSpace
	{
		private int oneOwnedRent;
		private int twoOwnedRent;
		
		public Utilities(String n, String o, int c, int l, int oR, int tR)
			{
				setName(n);
				setOwner(o);
				setCost(c);
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
