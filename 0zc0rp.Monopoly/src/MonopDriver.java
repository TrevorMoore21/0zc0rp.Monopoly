import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
//run class
public class MonopDriver
	{	
		static Scanner userInput = new Scanner(System.in);
		static String input;
		static BoardSpace[] board = new BoardSpace[40];
		static Scanner file;
		static Player player1 = new Player(0, false, 1500, true, "none", 0, new ArrayList<BoardSpace>());
		static Player player2 = new Player(0, false, 1500, true, "none", 0, new ArrayList<BoardSpace>());
		public static void main(String[] args) throws FileNotFoundException
			{
				selectVersion();
			    greetPlayer1();
			    
			      while(Player.stillPlaying == true)
			    	  {
			    		  if(Player.inJail == false)
			    			  {
			    				  Player.turnMenu();
			    			  }
			    		  else
			    			  {
			    				  Player.inJailTurn();
			    			  }
			    	  }
			    
			}
		
		public static void greetPlayer1()
			{
				System.out.println("What is your name?");
				input = userInput.nextLine();
				player1.setPlayerName(input);
				System.out.println("Welcome, " + player1.getPlayerName() + "!");
			}
			
		public static void greetPlayer2()
			{
				System.out.println("What is your name?");
				input = userInput.nextLine();
				player2.setPlayerName(input);
				System.out.println("Welcome, " + player2.getPlayerName() + "!");
			}
		
		public static void selectVersion() throws FileNotFoundException
		{
			System.out.println("Which version of Monopoly would you like to play?\n1)American Monopoly (default)\n2) SpongeBob Monopoly");
			int input = userInput.nextInt();
			
			if(input == 1)
				{
					file = new Scanner(new File( "AmericanMonopoly.txt" ));
				}
			else if(input == 2)
				{
					file = new Scanner(new File("SpongeBobMonopoly.txt"));
				}
			else
				{
					selectVersion();
				}
			
			fillBoard(file);
		}
		
		public static void fillBoard(Scanner b)
		{
		int numberOfLines = b.nextInt();
	     
	      for( int i = 0; i < numberOfLines; i++ )
	          {
	        	  String type = b.next();
	        	  
	        	  if(type.equals("Property"))
	        		  {
					  String n = b.next(); 
					  String o = b.next();
					  int c = b.nextInt(); 
					  int l = b.nextInt(); 
					  boolean d = b.nextBoolean(); 
					  int r = b.nextInt();
					  int h = b.nextInt();
					  int r1 = b.nextInt();
					  int r2 = b.nextInt();
					  int r3 = b.nextInt();
					  int hr = b.nextInt();
					  int hn = b.nextInt();
					  String co = b.next();
	        					  
					  board[i] = new Properties("Property", n, o, c, l, d, r, h, r1, r2, r3, hr, hn, co);	
	        		  }

	        	  else if(type.equals("Railroad"))
	        		  {
					  String rn = b.next(); 
					  String ro = b.next();
					  int rc = b.nextInt(); 
					  int rl = b.nextInt(); 
					  int rr1 = b.nextInt(); 
					  int rr2 = b.nextInt(); 
					  int rr3 = b.nextInt(); 
					  int rr4 = b.nextInt();
	        					  
					  board[i] = new Railroads("Railroads", rn, ro, rc, rl, rr1, rr2, rr3, rr4);
	        		  }
	        	  
	        	  else if(type.equals("Utility"))
	        		  {
					  String un = b.next(); 
					  String uo = b.next();
					  int uc = b.nextInt(); 
					  int ul = b.nextInt(); 
//					  int r1 = DiceRoller.rollDice(2,6)*4;
//					  int r2 = DiceRoller.rollDice(2,6)*10;
	        					  
      			  board[i] = new Utilities("Utility", un, uo, uc, ul); 
	        		  }
	        	  else if(type.equals("Other")) 
	        		  {
					  String name = b.next();
					  String owner = b.next();
					  int cost = b.nextInt();
					  int location = b.nextInt();
					  board[i] = new BoardSpace("Other", name, owner, cost, location);
	        		  }
	          }
	      //this is for if you want to display the board filling
	      /*for(BoardSpace s : board)
	    	  {
	    		  System.out.println(s);
	    	  }*/
		}

	}
