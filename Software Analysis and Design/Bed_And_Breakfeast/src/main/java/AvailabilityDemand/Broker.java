package AvailabilityDemand;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Responsible for managing subscription and publish events as well as notifying the providers and customers when these happen.
 */
public class Broker {
    //Maps to store what publisher list what room, what customer needs what room, and a list to keep track of subscriptions
    public Map<String, List<Room>> publishedRooms = new HashMap<>();
    public Map<String, List<Room>> neededRooms = new HashMap<>();
    public List<String> aggregatedResults = new ArrayList<>();
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    public Broker(){

    }

    //Adds a room to published Rooms if valid and notifies customers who have chosen to subscribe
    public boolean addRoom(String providerName, String location, Date availableFrom, Date availableDate){
        StayPeriod stay = new StayPeriod(availableFrom, availableDate);
        Room room = new Room(location, stay);

        boolean roomExists = false;
        boolean roomAdded = false;

        //If the provider has no rooms
        if (publishedRooms.get(providerName.toLowerCase()) == null){
            publishedRooms.put(providerName.toLowerCase(), new ArrayList<>());
            publishedRooms.get(providerName.toLowerCase()).add(room);
            notifyCustomers(room, providerName);
            roomAdded = true;
        }
        else{
            List<Room> temp = publishedRooms.get(providerName.toLowerCase());
            for(Room r : temp){
                if (roomExists){
                    break;
                }
                //If this provider has already listed this room
                boolean locationMatch = r.getLocation().equals(room.getLocation());
                boolean overlaps = r.getStayPeriod().overlaps(room);
                if ((locationMatch && overlaps)){
                    roomExists = true;
                }
            }
            if (!roomExists) {
                //If this is a new room the provider is listing
                publishedRooms.get(providerName.toLowerCase()).add(room);
                notifyCustomers(room, providerName);
                roomAdded = true;
            }
        }
        return roomAdded;
    }

    public boolean subscribe(String customer, String location, Date from, Date to) {
        StayPeriod stay = new StayPeriod(from, to);
        Room room = new Room(location, stay);

        boolean subExists = false;
        boolean subAdded = false;

        //If the provider has no rooms
        if (neededRooms.get(customer) == null){
            neededRooms.put(customer, new ArrayList<>());
            neededRooms.get(customer).add(room);
            notifyProviders(room, customer);
            subAdded = true;
        }
        else{
            List<Room> temp = neededRooms.get(customer);
            for(Room r : temp){
                if (subExists){
                    break;
                }
                //If the customer is already subscribed
                boolean locationMatch = r.getLocation().equals(room.getLocation());
                boolean startMatch = r.getStayPeriod().getStartDate().toString().equals(room.getStayPeriod().getStartDate().toString());
                boolean endMatch = r.getStayPeriod().getEndDate().toString().equals(room.getStayPeriod().getEndDate().toString());
                if (locationMatch && startMatch && endMatch){
                    subExists = true;
                }
            }
            if (!subExists) {
                //If the customer is not subscribed
                neededRooms.get(customer).add(room);
                notifyProviders(room, customer);
                subAdded = true;
            }
        }
        return subAdded;

    }

    //Lets the customers who are interested know when a new room is published
    public void notifyCustomers(Room room, String name){
        Set<String> strings = neededRooms.keySet();
        if (strings != null){
            for (String s: strings){
                List<Room> rooms = neededRooms.get(s);
                for (Room r: rooms){
                    boolean locationMatch = r.getLocation().equals(room.getLocation());
                    boolean startMatch = r.getStayPeriod().getStartDate().compareTo(room.getStayPeriod().getStartDate()) >= 0;
                    boolean endMatch = r.getStayPeriod().getEndDate().compareTo(room.getStayPeriod().getEndDate()) <= 0;
                    if (locationMatch && startMatch && endMatch){
                        String result = s + " notified of B&B availability in " + room.getLocation() + " from " + formatter.format(room.getStayPeriod().getStartDate())  +
                                " to " + formatter.format(room.getStayPeriod().getEndDate()) + " by " + name + " B&B";
                        notify(result);
                    }
                }
            }
        }
    }

    //Lets the providers who may have rooms know that a customer needs it
    public void notifyProviders(Room room, String name){
        Set<String> strings = publishedRooms.keySet();
        if (strings != null){
            for (String s: strings){
                List<Room> rooms = publishedRooms.get(s);
                for (Room r: rooms){
                    boolean locationMatch = r.getLocation().equals(room.getLocation());
                    boolean startMatch = r.getStayPeriod().getStartDate().before(room.getStayPeriod().getStartDate()) || r.getStayPeriod().getStartDate().equals(room.getStayPeriod().getStartDate());
                    boolean endMatch = r.getStayPeriod().getEndDate().after(room.getStayPeriod().getEndDate()) || r.getStayPeriod().getEndDate().equals(room.getStayPeriod().getEndDate());
                    if (locationMatch && startMatch && endMatch){
                        String result = name + " notified of B&B availability in " + room.getLocation() + " from "
                                + formatter.format(r.getStayPeriod().getStartDate()) + " to " + formatter.format(r.getStayPeriod().getEndDate()) + " by " + s + " B&B";
                        notify(result);
                    }
                }
            }
        }
    }

    //Stop receiving notifications for a location, start and end time
    public boolean unsubscribe(String customer, String location, Date from, Date to) {
        StayPeriod stay = new StayPeriod(from, to);
        Room room = new Room(location, stay);

        if (neededRooms.get(customer) != null){
            List<Room> rooms = neededRooms.get(customer);
            List<Room> temp = new ArrayList<>();
            for (Room r: rooms){
                boolean locationMatch = r.getLocation().equals(room.getLocation());
                boolean startMatch = r.getStayPeriod().getStartDate().before(room.getStayPeriod().getStartDate()) || r.getStayPeriod().getStartDate().equals(room.getStayPeriod().getStartDate());
                boolean endMatch = r.getStayPeriod().getEndDate().after(room.getStayPeriod().getEndDate()) || r.getStayPeriod().getEndDate().equals(room.getStayPeriod().getEndDate());
                if (!(locationMatch && startMatch && endMatch)){
                    temp.add(room);
                }
            }
            neededRooms.put(customer, temp);
        }

        return false;
    }

    //Add the command result to the list of actions the broker has taken
    public void notify(String notif){
        aggregatedResults.add(notif);
    }

    public String capitalize(String Name){
        String words[]=Name.split("\\s");
        String capitalizeWord="";
        for(String w:words){
            String first=w.substring(0,1);
            String afterfirst=w.substring(1);
            capitalizeWord+=first.toUpperCase()+afterfirst+" ";
        }
        Name = capitalizeWord.trim();
        return Name;
    }
}
