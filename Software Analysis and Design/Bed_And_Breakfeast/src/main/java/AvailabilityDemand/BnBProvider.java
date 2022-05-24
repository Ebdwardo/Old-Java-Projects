package AvailabilityDemand;

import java.util.Date;

/**
 * The BnB Provider is responsible for listing the rooms they have available. It notifies the customers who needs a room they listed
 */
public class BnBProvider implements IPublisher {
	//Private variables to store a broker and name
	public Broker broker;
	public String providerName;

	//Constructor to initialize the variables
	public BnBProvider(Broker broker1, String name){
		this.broker = broker1;
		this.providerName = name;
	}


	/**
	 * @see IPublisher#publish(String, String, Date, Date)
	 */
	public boolean publish(String providerName, String location, Date availableFrom, Date availableDate) {
		return broker.addRoom(providerName,location,availableFrom,availableDate);
	}

}
