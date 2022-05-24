package AvailabilityDemand;

import java.util.Date;

/**
 * Defines the length of a stay using a start and an end Date
 */
public class StayPeriod {
	//Private variable to store the start and end dates
	private Date startDate;
	private Date endDate;

	//Constructor to set the dates
	public StayPeriod(Date start, Date end){
		this.startDate = start;
		this.endDate = end;
	}

	//Getter for the start date
	public Date getStartDate(){
		return startDate;
	}

	//Getter for the end date
	public Date getEndDate(){
		return endDate;
	}

	//Methods to check if a Room's stayPeriod overlaps
	public boolean overlaps(Room room) {
		boolean startMatch = getStartDate().toString().equals(room.getStayPeriod().getStartDate().toString());
		boolean endMatch = getEndDate().toString().equals(room.getStayPeriod().getEndDate().toString());

		boolean cond1 = getStartDate().before(room.getStayPeriod().getStartDate()) && getEndDate().after(room.getStayPeriod().getStartDate());
		boolean cond2 = getStartDate().before(room.getStayPeriod().getEndDate()) && getEndDate().after(room.getStayPeriod().getEndDate());
		boolean cond3 = getStartDate().before(room.getStayPeriod().getStartDate()) && getEndDate().after(room.getStayPeriod().getEndDate());
		boolean cond4 = getStartDate().after(room.getStayPeriod().getStartDate()) && getEndDate().before(room.getStayPeriod().getEndDate());
		return (cond1 || cond2 || cond3 || cond4 || startMatch || endMatch);
	}
}
