import java.util.ArrayList;
import java.util.Scanner;

public class Player
	{
	static int playerLocation = 0;
	static boolean inJail = false;
	static int playerMoney = 1500;
	static boolean stillPlaying = true;
	static String playerName;
	static int menuInput;
	static int timesRolledDoubles = 0;
	static Scanner userInput = new Scanner(System.in);
	static ArrayList<BoardSpace> inventory = new ArrayList<BoardSpace>();
	
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

	public static int getPlayerLocation()
		{
			return playerLocation;
		}


	public static void setPlayerLocation(int playerLocation)
		{
			Player.playerLocation = playerLocation;
		}


	public static boolean isInJail()
		{
			return inJail;
		}


	public static void setInJail(boolean inJail)
		{
			Player.inJail = inJail;
		}


	public static int getPlayerMoney()
		{
			return playerMoney;
		}


	public static void setPlayerMoney(int playerMoney)
		{
			Player.playerMoney = playerMoney;
		}


	public static boolean isStillPlaying()
		{
			return stillPlaying;
		}


	public static void setStillPlaying(boolean stillPlaying)
		{
			Player.stillPlaying = stillPlaying;
		}


	public static String getPlayerName()
		{
			return playerName;
		}


	public static void setPlayerName(String playerName)
		{
			Player.playerName = playerName;
		}


	public static int getMenuInput()
		{
			return menuInput;
		}

	public static void setMenuInput(int menuInput)
		{
			Player.menuInput = menuInput;
		}

	public static int getTimesRolledDoubles()
		{
			return timesRolledDoubles;
		}

	public static void setTimesRolledDoubles(int timesRolledDoubles)
		{
			Player.timesRolledDoubles = timesRolledDoubles;
		}

	public static Scanner getUserInput()
		{
			return userInput;
		}

	public static void setUserInput(Scanner userInput)
		{
			Player.userInput = userInput;
		}


	public static ArrayList<BoardSpace> getInventory()
		{
			return inventory;
		}

	public static void setInventory(ArrayList<BoardSpace> inventory)
		{
			Player.inventory = inventory;
		}
	
	public static void addInventory()
		{
			inventory.add(MonopDriver.board[playerLocation]);
		}
	
	public static void displayPlayerStats()
	{
		System.out.println("Your name is: " + playerName);
		System.out.println("Current balance: $" + playerMoney);
		System.out.println("Your owned spaces:");
		
		for(BoardSpace k : inventory)
			{
				System.out.print(k.getType() + " ");
				System.out.println(k.getName());
			}
	}

	public static void checkForBankruptcy()
		{
			if(playerMoney <= 0)
				{
					System.out.println("You've gone bankrupt!");
					stillPlaying = false;
				}		
		}
	
	public static void goToJail()
		{
			playerLocation = 10;
			System.out.println("You are now in jail");
			inJail = true;
		}
	
	public static void buyProperty()
		{
			MonopDriver.board[playerLocation].setOwner(playerName);
			playerMoney -= MonopDriver.board[playerLocation].getCost();
			checkForBankruptcy();
			inventory.add(MonopDriver.board[playerLocation]);
		}
	}
