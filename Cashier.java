public class Cashier{
    /*
      Author: Dustin Hu
      Date: 08-01-0215
      Purpoes: To be the Cashier class

      Methods:
          Cashier: Constructor with no parameters
	  toString: To print the cashier

      Fields:
          inLine: The number of customers waiting for this cashier
	  customersServed: The number of customers served by this cashier
	  freeTime: The total amout of free time that the cashier has
	  timeToFillOrder: The time needed to fill the current order
     */
    protected int inLine;
    protected int customersServed;
    protected int freeTime;
    protected int timeToFillOrder;
    
    public Cashier(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create a Cashier
	// Input: None
	// Output: None
	this.inLine = 0;
	this.customersServed = 0;
	this.freeTime = 0;
	this.timeToFillOrder = 0;
    }
    public String toString(){
	// Author: Dsutin Hu
	// Date: 09-01-2015
	// Purpose: To print the string
	// Input: None
	// OutpuT: The string of the cashier

	return "{Customers in Line: " + this.inLine + ", customers served: " + this.customersServed + ", free time: " + this.freeTime + ", time to fill order: " + this.timeToFillOrder + "}";
    }
}
