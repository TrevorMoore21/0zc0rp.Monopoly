import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MonopDriver
	{

		public static void main(String[] args) throws FileNotFoundException
			{
				
				
				Scanner file = new Scanner(new File( "" ));
			      int numberOfLines = file.nextInt();
			      BoardSpace[] board = new BoardSpace[numberOfLines];
			      file.nextLine();
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
			        			  BoardSpace 
			        		  }
			          }
			}

	}
