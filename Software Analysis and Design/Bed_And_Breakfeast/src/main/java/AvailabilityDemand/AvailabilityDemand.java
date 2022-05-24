package AvailabilityDemand;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Responsible for processing the input and sending the required information to the broker so it can complete the command requested
 */
public class AvailabilityDemand {
    //Static broker to handle all the commands
    static Broker broker = new Broker();

    public void processInput(String command) {
        //Formatter to parse the date from String
        SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");
        formatter1.setLenient(false);

        //Splitting the string into each argument
        List<String> commandList = Arrays.asList(command.split(","));
        List<String> temp = new ArrayList<>();
        for (String s:commandList){
            String str = s.toLowerCase();
            temp.add(str.trim());
        }
        commandList = temp;

        //Try catch to catch invalid dates
        try{
            //The first in commandList is always the command
            switch (commandList.get(0)) {
                case "publish":
                    if (commandList.size() == 5){
                        //Get the BnB provider name and create a provider object
                        String providerName = commandList.get(1);
                        BnBProvider provider = new BnBProvider(broker,providerName);

                        //Bnb Provider Location
                        String providerLocation = commandList.get(2);
                        providerLocation = provider.broker.capitalize(providerLocation);

                        //Date available
                        String dateInString1 = commandList.get(3);
                        Date startDate = formatter1.parse(dateInString1);

                        //Last date available
                        String dateInString2 = commandList.get(4);
                        Date endDate = formatter1.parse(dateInString2);

                        //Publish the room with the given information
                        provider.publish(providerName,providerLocation,startDate, endDate);
                    }
                    break;
                case "subscribe":
                    if (commandList.size() == 5){
                        //Get the customer name
                        String customerName = commandList.get(1);

                        //Create a customer with the given name
                        Customer customer = new Customer(broker, customerName);
                        customerName = customer.broker.capitalize(customerName);

                        //Where the customer needs a BnB
                        String location = commandList.get(2);
                        location = customer.broker.capitalize(location);

                        //Starting date for the customer
                        String dateInString3 = commandList.get(3);
                        Date startDate2 = formatter1.parse(dateInString3);

                        //Ending date for the customer
                        String dateInString4 = commandList.get(4);
                        Date endDate2 = formatter1.parse(dateInString4);

                        //Opt the customer into receiving notifications for their desired location, start and end date
                        customer.subscribe(location,startDate2, endDate2);
                    }
                    break;
                case "unsubscribe":
                    if (commandList.size() == 5){
                        //Get customer name
                        String customerName1 = commandList.get(1);

                        //Create a new customer with that name
                        Customer unsubCustomer = new Customer(broker, customerName1);
                        customerName1 = unsubCustomer.broker.capitalize(customerName1);

                        //Where they want to stop receiving notifications from
                        String unsubLocation = commandList.get(2);
                        unsubLocation = unsubCustomer.broker.capitalize(unsubLocation);

                        String dateInString5 = commandList.get(3);
                        Date startDate3 = formatter1.parse(dateInString5);

                        String dateInString6 = commandList.get(4);
                        Date endDate3 = formatter1.parse(dateInString6);

                        //Let the system know the customer no longer wishes to know about this location from these dates
                        unsubCustomer.unsubscribe(unsubLocation,startDate3, endDate3);
                    }
                    break;
            }
        }
        catch(ParseException e){

        }
    }

    public List<String> getAggregatedOutput() {
        //Get the list of actions done by the broker
        return broker.aggregatedResults;
    }

    public void reset() {
        //Remove all published event and subscriptions
        if (broker != null){
            broker.publishedRooms.clear();
            broker.neededRooms.clear();
            broker.aggregatedResults.clear();
        }
    }

}