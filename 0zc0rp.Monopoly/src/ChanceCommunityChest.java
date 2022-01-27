import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChanceCommunityChest
	{
		static Cards[] Chance = new Cards[16];
		static Cards[] CommunityChest = new Cards[16];
		
		public static void readChance() throws FileNotFoundException
		{
			Scanner file = new Scanner(new File( "Chance.txt" ));
			int numberOfLines = file.nextInt();
			
			for( int i = 0; i < numberOfLines; i++ )
				{
					
				}
		}
		
	}
