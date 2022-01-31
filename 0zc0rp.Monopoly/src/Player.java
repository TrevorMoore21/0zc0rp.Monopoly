import java.util.ArrayList;
import java.util.Scanner;

public class Player
	{
	 int playerLocation = 0;
	 boolean inJail = false;
	 int playerMoney = 1500;
	 boolean stillPlaying = true;
	 String playerName;
	 int menuInput;
	 int timesRolledDoubles = 0;
	 Scanner userInput = new Scanner(System.in);
	 ArrayList<BoardSpace> inventory = new ArrayList<BoardSpace>();
	
	public Player(int pL, boolean iJ, int pM, boolean sP, String pN, int tD, ArrayList<BoardSpace> i)
	{
		playerLocation = pL;
		inJail = iJ;
		playerMoney = pM;
		stillPlaying = sP;
		playerName = pN;
		timesRolledDoubles = tD;
		inventory = i;
	}

	public int getPlayerLocation()
		{
			return playerLocation;
		}

	public void setPlayerLocation(int playerLocation)
		{
			this.playerLocation = playerLocation;
		}

	public boolean isInJail()
		{
			return inJail;
		}

	public void setInJail(boolean inJail)
		{
			this.inJail = inJail;
		}

	public int getPlayerMoney()
		{
			return playerMoney;
		}

	public void setPlayerMoney(int playerMoney)
		{
			this.playerMoney = playerMoney;
		}

	public boolean isStillPlaying()
		{
			return stillPlaying;
		}

	public void setStillPlaying(boolean stillPlaying)
		{
			this.stillPlaying = stillPlaying;
		}

	public String getPlayerName()
		{
			return playerName;
		}

	public void setPlayerName(String playerName)
		{
			this.playerName = playerName;
		}

	public int getMenuInput()
		{
			return menuInput;
		}

	public void setMenuInput(int menuInput)
		{
			this.menuInput = menuInput;
		}

	public int getTimesRolledDoubles()
		{
			return timesRolledDoubles;
		}

	public void setTimesRolledDoubles(int timesRolledDoubles)
		{
			this.timesRolledDoubles = timesRolledDoubles;
		}

	public Scanner getUserInput()
		{
			return userInput;
		}

	public void setUserInput(Scanner userInput)
		{
			this.userInput = userInput;
		}

	public ArrayList<BoardSpace> getInventory()
		{
			return inventory;
		}

	public void setInventory(ArrayList<BoardSpace> inventory)
		{
			this.inventory = inventory;
		}
	
	public static void addInventory(Player p)
		{
			p.inventory.add(MonopDriver.board[p.getPlayerLocation()]);
		}
	
	public static void displayPlayerStats(Player p)
	{
		System.out.println("Your name is: " + p.getPlayerName());
		System.out.println("Current balance: $" + p.getPlayerMoney());
		System.out.println("Your location is space: " + p.getPlayerLocation());
		System.out.println("Your owned spaces:");
		
		for(BoardSpace k : p.getInventory())
			{
				System.out.print(k.getType() + " ");
				System.out.println(k.getName());
			}
	}

	public static void checkForBankruptcy(Player p)
		{
			if(p.getPlayerMoney() <= 0)
				{
					System.out.println("You've gone bankrupt!");
					p.setStillPlaying(false);
				}		
		}
	
	public static void goToJail(Player p)
		{
			p.setPlayerLocation(10);
			System.out.println("You are now in jail");
			p.setInJail(true);
		}
	
	public static void buyProperty(Player p)
		{
			MonopDriver.board[p.getPlayerLocation()].setOwner(p.getPlayerName());
			p.setPlayerMoney(p.getPlayerMoney() - MonopDriver.board[p.getPlayerLocation()].getCost());
			checkForBankruptcy(p);
			p.addInventory(p);
		}
	}
