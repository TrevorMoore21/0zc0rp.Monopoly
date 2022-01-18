import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MonopDriver
	{	
		
		static BoardSpace[] board = new BoardSpace[40];
		
		public static void main(String[] args) throws FileNotFoundException
			{
				Scanner file = new Scanner(new File( "AmericanMonopoly.txt" ));
				int numberOfLines = file.nextInt();
			     
			      for( int i = 0; i < numberOfLines; i++ )
			          {
			        	  /*the txt file will be structured as follows:
			        	   * the first line will be an int that represents the amount of lines that follow it (think A+)
			        	   *each line will be one square
			        	   *type cost owner location
			        	   *then whatever applies to each thing (properties or taxes etc.)
			        	  */
			        	  if(file.next().equals("Property"))
			        		  {
			        			  board[i] = new Properties(file.next(), 
			        					  file.nextInt(), 
			        					  file.next(), 
			        					  file.nextInt(), 
			        					  file.nextBoolean(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(),
			        					  file.nextInt(),
			        					  file.next());
			        		  }
			        	  
			        	  else if(file.next().equals("Railroad"))
			        		  {
			        			  board[i] = new Railroads(file.next(),
			        					  file.nextInt(), 
			        					  file.next(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt(), 
			        					  file.nextInt());
			        		  }
			        	  
			        	  else if(file.next().equals("Utilities"))
			        		  {
			        			  board[i] = new Utilities(file.next(),
			        					  file.nextInt(),
			        					  file.next(),
			        					  file.nextInt(),
			        					  DiceRoller.rollDice(2,6)*4,
			        					  DiceRoller.rollDice(2,6)*10);
			        		  }
			        	  else if(file.next().equals("Other")) 
			        		  {
			        			  board[i] = new BoardSpace(file.next(),
			        					  file.next(),
			        					  file.nextInt(),
			        					  file.next(),
			        					  file.nextInt());
			        		  }
			          }
			      
			      Player.greetPlayer();
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

	}
