import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

import java.util.Random;
    
public class Restaurant{
    /*
      Author: Dustin Hu
      Date: 08-01-2015
      Prupose: To be the restaurant class

      Methods: 
          Restaurant: Craetes the restaurant
          getInfo: Gets the info from the user
	  newCustomerArrives: Adds a new customer to the restaurant
	  serversDoJob: The cashiers go to work
	  screenSetUp: Sets up the screen
	  printStatistics: Prints out the statitics of the crrent restaurant
	  run: Runs the simulation
	  writeStatistics: Writes the statitistics to a file

      Fields:
          n: The number of cashiers/queues
	  cashiers: The cashier array
	  queues: Array of queues
	  oneLine: A boolean indicating if there is a single line, true if there is only one
	  totalMinutes: The number of minutes passed
	  clock: The clock
	  arrivalProbability: The probablity of another customer arriving
	  maxOrderTime: The maximum time for an order
	  totalWaitTime: THe total time for waiting
	  totalOrderTime: The total time used for ordering
	  totalCustomers: The total number of customers
	  averageWaitTime: The average wait time
	  totalLineLength: The total line length
	  averageLineLength: The average length of the line
	  filename: The filename to write to
     */
    
    protected int n;
    protected Cashier[] cashiers;
    protected Queue[] queues;
    protected boolean oneLine;
    protected int totalMinutes;
    protected int clock;
    protected int arrivalProbability;
    protected int maxOrderTime;
    protected int totalWaitTime;
    protected int totalOrderTime;
    protected int totalCustomers;
    protected int averageWaitTime;
    protected int totalLineLength;
    protected int averageLineLength;
    protected String filename; 
    
    public Restaurant(){
	// author: Dustin Hu
	// Daet: 08-01-2015
	// Purpoes: To Create the Restaurant
	// Input: None
	// Output: None
	this.n = 0;
	this.cashiers = new Cashier[0];
	this.queues = new Queue[0];
	this.oneLine = false;
	this.totalMinutes = 0;
	this.clock = 0;
	this.arrivalProbability = 0;
	this.maxOrderTime = 0;
	this.totalWaitTime = 0;
	this.totalOrderTime = 0;
	this.totalCustomers = 0;
	this.averageWaitTime = 0;
	this.totalLineLength = 0;
	this.averageLineLength = 0;
	this.filename = "";
    }
    public void getInfo() throws IOException{
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To get the info from the user
	// Input: None
	// Output: None
	BufferedReader input = new BufferedReader(
						  new InputStreamReader(System.in));
	String userInput = "";
	boolean loop = false;
	boolean line;
	System.out.print("The number of Cashiers is: ");
	userInput = input.readLine();
	while (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 50){
	    System.out.println("Please enter a number of cashiers greater than 0 and less than 50");
	    System.out.print("The number of Cashiers is: ");
	    userInput = input.readLine();
	}

	this.n = Integer.parseInt(userInput);
	this.cashiers = new Cashier[this.n];
	for (int i = 0; i < this.n; i++){
	    this.cashiers[i] = new Cashier();
	}

	System.out.println("Is this a single queue? Y/N");
	userInput = input.readLine();

	if (userInput.equals("Y")){
	    line = true;
	    loop = false;
	}
	else if (userInput.equals("N")){
	    line = false;
	    loop = false;
	}
	else{
	    loop = true;
	}
	while (loop){
	    System.out.println("Incorrect input.");
	    System.out.println("Is this a single queue? Y/N");
	    userInput = input.readLine();
	    if (userInput.equals("Y")){
		line = true;
		loop = false;
	    }
	    else if (userInput.equals("N")){
		line = false;
		loop = false;
	    }
	}
	if (userInput.equals("Y")){
	    this.oneLine = true;
	    this.queues = new Queue[n + 1];
	    for (int i = 0; i < this.n + 1; i++){
		this.queues[i] = new Queue();
	    }
	}
	else{
	    this.oneLine = false;
	    this.queues = new Queue[n];
	    for (int i = 0; i < this.n; i++){
		this.queues[i] = new Queue();
	    }
	}

	System.out.println("The arrival probability is: ");
	userInput = input.readLine();
	while (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 100){
	    System.out.println("Please enter a arrival probability between 1 and 100");
	    userInput = input.readLine();
	}
	this.arrivalProbability = Integer.parseInt(userInput);

	System.out.println("The maximum time of your simulation in minutes?");
	userInput = input.readLine();
	while (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > 1440){
	    System.out.println("Invalid, please enter a time between 1 minute and 1440 minutes.");
	    userInput = input.readLine();
	}
	this.totalMinutes = Integer.parseInt(userInput);

	System.out.println("The maximum order time in minutes");
	userInput = input.readLine();
	while (Integer.parseInt(userInput) < 1 || Integer.parseInt(userInput) > this.totalMinutes){
	    System.out.println("The maximum order is out of bounds");
	    System.out.println("Please enter a time between 1 and " + this.totalMinutes);
	    userInput = input.readLine();
	}
	this.maxOrderTime = Integer.parseInt(userInput);

	System.out.println("The file to write to? (Include extension)");
	this.filename = input.readLine();

    }
    public void newCustomerArrives(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To add a new customer to the restaurant
	// Input: None
	// Output: None
	Customer temp;
	// int probability = (int) (Math.random() * this.arrivalProbability)
	int probability = new Random().nextInt(this.arrivalProbability) ;
	int shortest = 0;
	if (probability == 0){
	    temp = new Customer(this.maxOrderTime);
	    if (this.oneLine){
		this.queues[n].add(temp);
		System.out.println("Added a customer");
	    }
	    else{
		for (int i = 0; i < this.n; i++){
		    if (this.cashiers[shortest].inLine > this.cashiers[i].inLine){
			shortest = i;
		    }
		}
		this.queues[shortest].add(temp);
		this.cashiers[shortest].inLine++;
	    }
	}
    }
    public void serversDoJob(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To cause the servers to remove a customer if the time to fill order is 0
	// Input: None
	// Output: None
	Customer removed;
	clock++;
	// If the cashier is serving a new customer, set their timeToFillOrder to that customer's order time
	// Else decrement timeToFillOrder and wait()
	if (this.oneLine){
	    for (int i = 0; i < this.n; i++){
		if (this.queues[i].isEmpty() && !this.queues[this.n].isEmpty()){
		    this.queues[i].front = this.queues[this.n].remove();
		    this.queues[i].front.next = null;
		    this.cashiers[i].timeToFillOrder = this.queues[i].front.orderTime;
		    
		}
		else if (this.queues[i].isEmpty() && this.queues[this.n].isEmpty()){
		    this.cashiers[i].freeTime++;
		}

		else if (!this.queues[i].isEmpty() && this.cashiers[i].timeToFillOrder > 0){
		    this.cashiers[i].timeToFillOrder--;
		    this.queues[i].customersWait();
		    if (this.cashiers[i].timeToFillOrder == 0){
			removed = this.queues[i].remove();
			this.totalCustomers++;
			this.totalOrderTime += removed.orderTime;
			this.totalWaitTime += removed.waitTime;
			this.cashiers[i].customersServed++;
		    }
		}

	    }
	}
	else{
	    for (int i = 0; i < this.n; i++){
		if (this.cashiers[i].inLine == 0){
		    this.cashiers[i].freeTime++;
		}
		else{
		    if (this.cashiers[i].timeToFillOrder == 0 && !this.queues[i].isEmpty()){
			// This part sets the cashier to the current customer at the front of the queue
			this.cashiers[i].timeToFillOrder = this.queues[i].front.orderTime;
		    }
		    else{
			this.cashiers[i].timeToFillOrder--;
			this.queues[i].customersWait();
			if (this.cashiers[i].timeToFillOrder == 0){
			    removed = this.queues[i].remove();
			    this.totalCustomers++;
			    this.totalOrderTime += removed.orderTime;
			    this.totalWaitTime += removed.waitTime;
			    this.cashiers[i].customersServed++;
			    this.cashiers[i].inLine--;

			}
		    }
		}
	    }
	}
	
    }
    public void screenSetUp(){
	// Author: Dustin Hu
	// Date: 08-01-205
	// Purpoes: To set up the screen for the simulation
	// Input: None
	// Output: None

	String line = "";
	for (int i = 0; i < this.n; i++){
	    line = this.cashiers[i].toString() + " "+ i + ": " + this.queues[i].toString();
	    System.out.println(line);
	}

	System.out.println(" ");

    }
    public void printStatistics(){
    	// Author: Dustin Hu
    	// Date: 08-01-2015
    	// Purpoes: To get the statitistcs
    	// Input: None
    	// Output: None
	System.out.println("Total customers:     " + this.totalCustomers);
	System.out.println("Total order time:    " + this.totalOrderTime);
	System.out.println("Total wait time:     " + this.totalWaitTime);
	System.out.println("Average wait time:   " + this.totalWaitTime / this.totalCustomers);
	System.out.println("One line:            " + this.oneLine);

	if (!this.oneLine){
	    for (int i = 0; i < this.n; i++){
		this.totalLineLength = this.totalLineLength + this.queues[i].count();
	    }
	}
	else{
	    this.totalLineLength = this.queues[this.n].count();
	}
	this.averageLineLength = this.totalLineLength / this.n;
	System.out.println("Average Line Length: " + this.totalLineLength);

    }
    public void run(int write) throws IOException{
	// autohr: Dustin HU
	// Date: 13-01-2015
	// Purpoes: To run the simulation
	// Input: An integer, what kind of writing you want
	//        0 - writeScenario() only
	//        1 - writeStatistics() only
	//        2 - writeScenario() and writeStatistics()
	// OUtput: None
	for (int i = 0; i < this.totalMinutes; i++){
	    this.newCustomerArrives();
	    this.serversDoJob();
	    this.screenSetUp();
	    if (write == 0){
		this.writeScenario(this.filename);
	    }
	    else if (write == 1){
		this.writeStatistics(this.filename);
	    }
	    else{
		this.writeScenario(this.filename);
		this.writeStatistics(this.filename);

	    }
		
	}
    }

    public void writeScenario(String filename) throws IOException{
    	// Author: Dustin Hu
    	// Date: 08-01-2015
    	// Puproes: to write the current state to a file
    	// Input: The file name to write to
    	// Output: None
	PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
	String line = "";
	output.println("----------------------------------------------------------------------");
	output.println("Instance of Restaurant at " + this.clock + " out of " + this.totalMinutes);
	output.println("Cashiers:            " + this.n);
	output.println("");
	for (int i = 0; i < this.n; i++){
	    line = this.cashiers[i].toString() + " "+ i + ": " + this.queues[i].toString();
	    output.println(line);
	}
	output.println("");
	output.println("End of scenario for instance of restaurant at "+ this.clock + " out of " + this.totalMinutes);
	output.println("----------------------------------------------------------------------");
	output.close();
	
    }
    public void writeStatistics(String filename) throws IOException{
    	// Author: Dustin Hu
    	// Date: 08-01-2015
    	// Puproes: to write the statistics to a file
    	// Input: The file name to write to
    	// Output: None
	PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)));
	output.println("----------------------------------------------------------------------");
	output.println("Instance of Restaurant at " + this.clock + " out of " + this.totalMinutes);
	output.println("Statistics: ");
	output.println("Cashiers:            " + this.n);
	output.println("Total customers:     " + this.totalCustomers);
	output.println("Total order time:    " + this.totalOrderTime);
	output.println("Total wait time:     " + this.totalWaitTime);
	if (this.totalCustomers != 0){
	    output.println("Average wait time:   " + this.totalWaitTime / this.totalCustomers);	    
	}
	else{
	    output.println("Average wait time:   " + this.totalWaitTime );
	}
  

	output.println("One line:            " + this.oneLine);

	if (!this.oneLine){
	    for (int i = 0; i < this.n; i++){
		this.totalLineLength = this.totalLineLength + this.queues[i].count();
	    }
	}
	else{
	    this.totalLineLength = this.queues[this.n].count();
	}
	this.averageLineLength = this.totalLineLength / this.n;
	output.println("Average Line Length: " + this.totalLineLength);
	output.println("");
	output.println("End of statistics for instance of restaurant at "+ this.clock + "out of " + this.totalMinutes);
	output.println("----------------------------------------------------------------------");
	output.close();

    }
}
    
