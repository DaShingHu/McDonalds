import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class McDonalds{
    /*
      AUthor: Dustin Hu
      Date: 08-01-2015
      Purpose: To demonstrate the McDonalds' queue simulation
      
      Methods:
          main: The main
     */



    public static void main (String [] args) throws IOException{
	// Autohr: Dustin Hu
	// Date: 12-01-2015
	// Purpose: To demonstrateh the Restaurant
	// Input: None
	// OUtput: None
	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	Restaurant harveys;
	boolean exit = false;
	boolean loop = true;
	String userInput;
	int run = 0;
	System.out.println("Welcome to the restaurant simulator");

	while (!exit){
	    System.out.println("Would you like to simulate a restaurant? Y/N");
	    userInput = input.readLine();
	    if (userInput.equals("Y")){
		System.out.println("How would you like your file to be written? ");
		System.out.println("1) Write scenario only");
		System.out.println("2) Write statistics only");
		System.out.println("3) Write both scenario and statistics");

		while (loop){
		    userInput = input.readLine();
		    if (userInput.equals("1")){
			run = 0;
			loop = false;
		    }
		    else if (userInput.equals("2")){
			run = 1;
			loop = false;
		    }
		    else if (userInput.equals("3")){
			run = 2;
			loop = false;
		    }
		    else{
			System.out.println("Invalid input.");
			System.out.println("How would you like your file to be written? ");
			System.out.println("1) Write scenario only");
			System.out.println("2) Write statistics only");
			System.out.println("3) Write both scenario and statistics");
		    }
		    
		}
		harveys = new Restaurant();
		harveys.getInfo();
		harveys.run(run);
	    }
	    else if (userInput.equals("N")){
		exit = true;
		System.out.println("Bye bye!");
	    }
	    else{
		System.out.println("Invalid input, please try again");
	    }

	}

	
	
	
    }
}
