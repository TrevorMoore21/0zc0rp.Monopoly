
public class Players
	{

		private String name;
		private String gamePiece; 
		private int money;
		
		
		public Players(String n, String g, int m)
		{
			name = n;
			gamePiece = g;
			money = m;
		}


		public String getName()
			{
				return name;
			}


		public void setName(String name)
			{
				this.name = name;
			}


		public String getGamePiece()
			{
				return gamePiece;
			}


		public void setGamePiece(String gamePiece)
			{
				this.gamePiece = gamePiece;
			}


		public int getMoney()
			{
				return money;
			}


		public void setMoney(int money)
			{
				this.money = money;
			}
		
		
		
		
	}
