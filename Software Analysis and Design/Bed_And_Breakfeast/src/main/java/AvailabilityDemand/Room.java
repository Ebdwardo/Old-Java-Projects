package AvailabilityDemand;

/**
 * Defines a room a customer wants or a publish lists. It contains the location and the stayPeriod
 */
public class Room {
	//Private variables to store location and stayPeriod
	private String location;
	private StayPeriod stayPeriod;

	//Constructor to initialize the variables
	public Room(String loc, StayPeriod period){
		this.location = loc;
		this.stayPeriod = period;
	}

	//Location getter
	public String getLocation(){
		return location;
	}

	//stayPeriod getter
	public StayPeriod getStayPeriod(){
		return stayPeriod;
	}

}
