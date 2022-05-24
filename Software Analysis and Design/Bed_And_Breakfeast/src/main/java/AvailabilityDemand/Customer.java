package AvailabilityDemand;

import java.util.Date;

/**
 * The Customer Class is responsible for subscribing to notifications. When they subscribe, they recieve a notification if any rooms that were already published meet their needs
 */

public class Customer implements ISubscriber {
	//Private variables to store a broker and name
	public Broker broker;
	public String name;

	//Constructor to initialize the variables
	public Customer(Broker broker1, String name){
		this.broker = broker1; this.name = name;
	}


	/**
	 * @see ISubscriber#subscribe(String, Date, Date)
	 */
	public boolean subscribe(String location, Date from, Date to) {
		return broker.subscribe(name, location, from, to);
	}


	/**
	 * @see ISubscriber#unsubscribe(String, Date, Date)
	 */
	public boolean unsubscribe(String location, Date from, Date to) {
		return broker.unsubscribe(name,location, from,to);
	}

}
