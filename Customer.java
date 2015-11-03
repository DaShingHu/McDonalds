import java.util.Random;

public class Customer{

    /*
      Author: Dustin Hu
      Date: 08-01-2015
      Purpose: To be the customer class
      
      Methods:
          Constructor: Cerates the Customer, with no parameters
	  Consturctor: Creates the Customer with the parameter of max order time
	  toSTring: Gets the string of the customer
      Fields:
          orderTime: An integer between 1 and x
	  waitTime: The time the customer has to wait
	  next: The next customer in line
     */
    protected int orderTime;
    protected int waitTime;
    protected Customer next;

    public Customer(){
	// Author: Dsutin Hu
	// Date: 08-01-2015
	// Purpose: To ceraet the customer with no parameters
	// Input: None
	// Output: None
	this.orderTime = 1;
	this.waitTime = 0;
	this.next = null;
    }
    public Customer(int x){
	// Author: Dsutin Hu
	// Date: 08-01-2015
	// Purpose: To ceraet the customer with no parameters
	// Input: The order time
	// Output: None
	this.orderTime = new Random().nextInt(x) + 1;
	this.waitTime = 0;
	this.next = null;
    }
    public String toString() {
	// AUthor: Dusitn Hu
	// Date: 11-25-2014
	// Purpose: To create the string 
	// Input: None
	// OUtput: THe node as a string
	String output = "";
	if (this.next == null){
	    output = output + "{Order time: " + this.orderTime + ", wait time: " + this.waitTime + "}" + " <- End";
	}
	else{
	    output = output +"{" + this.orderTime + ", " + this.waitTime + "}"  + " <- " + this.next.toString();
	}
	return output;

    }

	
}
