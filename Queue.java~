
public class Queue{
        /*
      Author: Dustin Hu
      Date: 08-10-2015
      Purpoes: To hold the linked list queue
      
      Methods:
          count: Returns the number of customers
          Queue: Creates a new Queue
	  isEmpty: Checsk if the queue is empty
	  remove: Removes a customer from the queue
	  customersWait: Adds one to the customer's wait times
	  toString: Gets the string of the Queue
	  add: Adds a customer to the queue
	  
      Fields:
          front: A customer, the root.
	  back: The last customer, the end of the list
    
    */
    protected Customer front;
    protected Customer back;

    public int count(){
	// AUthor: Dsutin Hu
	// Date: 09-01-2015
	// Purpoes: To count the number of customers
	// Input: None
	// Output: The number of customers
	Customer current = front;
	int output = 1;
	while (current != null){
	    current = current.next;
	    output = output + 1;
	}
	return output;
    }

    public Queue(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To create the linked list quee
	// Input: None
	// Output: None
	this.front = null;
	this.back = null;
    }
    public boolean isEmpty(){
	// AUtohr: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To check if the queue is empty
	// Input: None
	// OUtput: True if the queue is empty, false if not
	boolean output;
	if (front == null){
	    output = true;
	}
	else{
	    output = false;
	}
	return output;
    }
    public Customer remove(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: Remove the front
	// Input: None
	// OUtput: THe value of front, null if empty
	Customer output;
	if (!this.isEmpty()){
	    output = this.front;
	    this.front = this.front.next;
	}
	else{
	    output = null;
	}
	return output;

    }
    public void customersWait(){
	// Author: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To make the customers wait, to increase their wait time
	// Input: None
	// Output: None
	Customer current = this.front;
	while (current != null){
	    current.waitTime++;
	    current = current.next;
	}
    }
    public String toString(){
	// author: Dustin Hu
	// Date: 08-01-2015
	// Purpoes: To get the string of the queue
	// Input: None
	// Output: The string of the queue
	String output;
	if (!this.isEmpty()){
	    output = this.front.toString();
	}
	else{
	    output = "None";
	}
	return output;
    }
    public void add(Customer input){
	// AUthor: Dustin Hu
	// Date: 08-01-2015
	// Purpose: To add a customer to the queue
	// Input: The customer to add
	// None
	if (this.isEmpty()){
	    this.front = input;
	    this.back = input;
	}
	else{
	    this.back.next = input;
	    this.back = input;
	}
    }
}
