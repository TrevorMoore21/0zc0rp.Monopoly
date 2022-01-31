import java.util.Scanner;

public class Turn
	{
		static Scanner userInput = new Scanner(System.in);
		static boolean freeParking = false;
		static int menuInput;
		
		public static void wierdWorkAroundLol(Player p)
		{
			if(p.isInJail())
				{
					inJailTurn(p);
				}
			else
				{
					turnMenu(p);
				}
		}
		
		public static void turnMenu(Player p)
			{
				System.out.println(p.getPlayerName() + ", it's your turn!\nWould you like to...\n1) Roll the dice\n2) View your stats");
				menuInput = userInput.nextInt();
				
				if(menuInput == 1)
					{
						movePlayer(p);
					}
				else if(menuInput == 2)
					{
						p.displayPlayerStats(p);
						movePlayer(p);
					}
				else if(menuInput == 3)
					{
						goToFreeParking(p);
					}
				else
					{
						System.out.println("That's not an option.\nPlease try again.");
						turnMenu(p);
					}
			}
		
		public static void movePlayer(Player p)
			{
				int playerRoll = DiceRoller.rollDice(2,6);
				if(freeParking == false)
					{
					if((p.getPlayerLocation() + playerRoll) < 39)
						{
							p.setPlayerLocation(p.getPlayerLocation() + playerRoll);
						}
					else
						{
							p.setPlayerLocation((p.getPlayerLocation() + playerRoll) - 39);
							p.setPlayerMoney(p.getPlayerMoney() + 200);
							System.out.println("You passsed GO and collected $200");
						}
					}
				else
					{
						if((p.getPlayerLocation() + playerRoll) < 39)
							{
								p.setPlayerLocation(p.getPlayerLocation() - playerRoll);
							}
						else
							{
								p.setPlayerLocation((p.getPlayerLocation() - playerRoll) + 39);
								p.setPlayerMoney(p.getPlayerMoney() + 200);
								System.out.println("You passsed GO and collected $200");
							}
					}
				
				
				System.out.println("You rolled: " + playerRoll + "\nYou landed on " + MonopDriver.board[p.getPlayerLocation()].getName());
				
				landOnSquare(p);
				
				if(DiceRoller.doubles == true)
					{
						p.setTimesRolledDoubles(p.getTimesRolledDoubles() + 1);
						
						if(p.getTimesRolledDoubles() == 3)
							{
								p.goToJail(p);
							}
						else
							{
								System.out.println("You rolled doubles, so you get to roll again!");
								movePlayer(p);
							}
					}
			}
		
		public static void landOnSquare(Player p)
			{
				if(MonopDriver.board[p.getPlayerLocation()].getType().equals("Property"))
					{
						if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals("none"))
							{
							System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
							menuInput = userInput.nextInt();
							
							if(menuInput == 1)
								{
									p.buyProperty(p);
									//numberOfPropertiesOwned++;
								}
							//need to implement the 'developing' feature (where you can only buy houses if you own all of that color)
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals(p.getPlayerName()))
							{
								System.out.println("You already own this property...\nWould you like to buy houses or a hotel?\n1) Yes\n2) No");
								menuInput = userInput.nextInt();
								
								if(menuInput == 1)
									{
										if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() >= 4)
											{
											System.out.println("Sorry, you have already bought the maximum amount of property on this space.");
											}
										else
											{
											((Properties) MonopDriver.board[p.getPlayerLocation()]).setNumberOfHousesOwned(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned()+1);
											}
									}
							}
						else
							{
								System.out.println("This property is already owned by" + MonopDriver.board[p.getPlayerLocation()].getOwner() + ", you now must pay rent.");
								if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() == 0)
									{
										p.setPlayerMoney(p.getPlayerMoney() - ((Properties) MonopDriver.board[p.getPlayerLocation()]).getBasicRent());
									}
								else if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() == 1)
									{
										p.setPlayerMoney(p.getPlayerMoney() - ((Properties) MonopDriver.board[p.getPlayerLocation()]).getOneHouseRent());
									}
								else if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() == 2)
									{
										p.setPlayerMoney(p.getPlayerMoney() - ((Properties) MonopDriver.board[p.getPlayerLocation()]).getTwoHouseRent());
									}
								else if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() == 3)
									{
										p.setPlayerMoney(p.getPlayerMoney() - ((Properties) MonopDriver.board[p.getPlayerLocation()]).getThreeHouseRent());
									}
								else if(((Properties) MonopDriver.board[p.getPlayerLocation()]).getNumberOfHousesOwned() == 4)
									{
										p.setPlayerMoney(p.getPlayerMoney() - ((Properties) MonopDriver.board[p.getPlayerLocation()]).getHotelRent());
									}
								
								p.checkForBankruptcy(p);
							}
					}
				
				else if(MonopDriver.board[p.getPlayerLocation()].getType().equals("Utility"))
					{
						if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals("none"))
							{
							System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
							menuInput = userInput.nextInt();
							
							if(menuInput == 1)
								{
									p.buyProperty(p);
								}
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals(p.getPlayerName()))
							{
								System.out.println("You already own this utility");
							}
						else
							{
								System.out.println("This utility is already owned by " + MonopDriver.board[p.getPlayerLocation()].getOwner() + ", you now must pay for the service.");
								//need to figure out how to search the array for everything that has one specific field
							}
					}
				else if(MonopDriver.board[p.getPlayerLocation()].getType().equals("Railroad"))
					{
						if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals("none"))
							{
							System.out.println("This location is not owned, would you like to buy it?\n1) Yes\n2) No");
							menuInput = userInput.nextInt();
							
							if(menuInput == 1)
								{
									p.buyProperty(p);
								}
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getOwner().equals(p.getPlayerName()))
							{
								System.out.println("You already own this railroad");
							}
						else
							{
								//once again need to figure the comment from above out
								
								/*System.out.println("This property is already owned by" + MonopDriver.board[playerLocation].getOwner() + ", you now must pay rent.");
								if(((Railroads) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 1)
									{
										playerMoney -= ((Railroads) MonopDriver.board[playerLocation]).getOneOwnedRent();
									}
								else if(((Railroads) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 2)
									{
										playerMoney -= ((Railroads) MonopDriver.board[playerLocation]).getTwoOwnedRent();
									}
								else if(((Railroads) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 3)
									{
										playerMoney -= ((Railroads) MonopDriver.board[playerLocation]).getThreeOwnedRent();
									}
								else if(((Railroads) MonopDriver.board[playerLocation]).getNumberOfHousesOwned() == 4)
									{
										playerMoney -= ((Railroads) MonopDriver.board[playerLocation]).getFourOwnedRent();
									}*/
								
								p.checkForBankruptcy(p);
							}
					}
				else
					{
						if(MonopDriver.board[p.getPlayerLocation()].getName().equals("GO"))
							{
								p.setPlayerMoney(p.getPlayerMoney() + MonopDriver.board[p.getPlayerLocation()].getCost());
								System.out.println("You collected $" + MonopDriver.board[p.getPlayerLocation()].getCost());
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getName().equals("Go_To_Jail"))
							{
								p.goToJail(p);
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getName().equals("Free_Parking"))
							{
								System.out.println("You landed on free parking!");
								freeParking = true;
							}
						else if(MonopDriver.board[p.getPlayerLocation()].getName().equals("Income_Tax") || MonopDriver.board[p.getPlayerLocation()].getName().equals("Luxury_Tax"))
							{
								System.out.println("You have been taxed $" + MonopDriver.board[p.getPlayerLocation()].getCost());
								p.setPlayerMoney(p.getPlayerMoney() - MonopDriver.board[p.getPlayerLocation()].getCost());
							}
						
						//chance cards
						/*else if(MonopDriver.board[playerLocation].getName().equals("Chance"))
							{
								int chanceNumber = (int) (Math.random() * 3) + 1;
								if(chanceNumber == 1)
									{
								System.out.println("You're wife left you. Give 50% of your money to her.");
								playerMoney = playerMoney / 2;
									}
								
								else if(chanceNumber == 2)
									{
										System.out.println("You got your secretary pregnant. Pay $50.");
										playerMoney = playerMoney - 50;
									}
								else
									{
										System.out.println("You found $100 on the street.");
										playerMoney = playerMoney + 100;
									}
							}
						//community chest
						else if(MonopDriver.board[playerLocation].getName().equals("Community Chest"))
							{
								int chestNumber = (int) (Math.random() * 3) + 1;
								if(chestNumber == 1)
									{
								System.out.println("Your dog needs a surgery. Pay the vet $100.");
								playerMoney = playerMoney / 2;
									}
								
								else if(chestNumber == 2)
									{
										System.out.println("You have turned to a life of crime. You mugged a teenage girl for $35.");
										playerMoney = playerMoney + 35;
									}
								else
									{
										System.out.println("You bought the Fortnite battle pass ofr $10.");
										playerMoney = playerMoney - 10;
									}
							}*/
						
					}
				
			}
		
		public static void inJailTurn(Player p)
			{
				//need to implement cards soon
				System.out.println("You are in jail\nWould you like to...\n1) Pay the $50 fee\n2) Roll for doubles");
				menuInput = userInput.nextInt();
				
				if(menuInput == 1)
					{
						p.setPlayerMoney(p.getPlayerMoney() - 50);
						System.out.println("You have now payed the fee and are free to go.");
						p.inJail = false;
					}
				else
					{
						DiceRoller.rollDice(2,6);
						if(DiceRoller.doubles == true)
							{
								System.out.println("You rolled doubles and are free to go.");
								p.inJail = false;
							}
						else
							{
								System.out.println("You failed to roll doubles.");
							}
					}
			}
		
		public static void goToFreeParking(Player p)
		{
			p.setPlayerLocation(20);
			freeParking = true;
		}
	}
