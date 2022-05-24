package AvailabilityDemand;

import java.util.Date;

public abstract interface IPublisher {

	public abstract boolean publish(String providerName, String location, Date availableFrom, Date availableDate);

}
