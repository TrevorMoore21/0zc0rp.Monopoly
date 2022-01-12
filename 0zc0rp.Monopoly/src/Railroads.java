
public class Railroads extends BoardSpace
	{

		private int oneOwnedRent;
		private int twoOwnedRent;
		private int threeOwnedRent;
		private int fourOwnedRent;
		
		public Railroads(int onR, int twR, int thR, int foR)
		{
			oneOwnedRent = onR;
			twoOwnedRent = twR;
			threeOwnedRent = thR;
			fourOwnedRent = foR;
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

		public int getThreeOwnedRent()
			{
				return threeOwnedRent;
			}

		public void setThreeOwnedRent(int threeOwnedRent)
			{
				this.threeOwnedRent = threeOwnedRent;
			}

		public int getFourOwnedRent()
			{
				return fourOwnedRent;
			}

		public void setFourOwnedRent(int fourOwnedRent)
			{
				this.fourOwnedRent = fourOwnedRent;
			}
		
	}
