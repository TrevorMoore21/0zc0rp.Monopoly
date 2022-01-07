
public class DiceRoller
	{
		public static int rollDice(int i, int j)
		    {
		      int sumOfDice = 0;
		      for(int k = 0 ; k < i ; k++)
		        {
		          //roll the dice
		          int diceRollNumber = (int) (Math.random()*j)+1;
		          sumOfDice = diceRollNumber+sumOfDice;
		          System.out.println("You rolled a "+diceRollNumber+".");
		        }
		      System.out.print("Your total is ");
		      return sumOfDice;
		    }
	}
