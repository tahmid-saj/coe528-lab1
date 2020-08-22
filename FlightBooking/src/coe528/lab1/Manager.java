/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

//Importing the relevant ArrayList and List to be used in the Manager class
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tahmi
 */
public class Manager {
    //Declare the ArrayList for flights and issuedTickets, as well as the ticketNumber
    public static List<Flight> flights = new ArrayList<Flight>();
    public static List<Ticket> issuedTickets = new ArrayList<Ticket>();
    public static int ticketNumber = 0;
    
    //This method should populate the array of flights
    public void createFlights() {
        flights.add(new Flight(123,"Toronto", "Dallas","01/02/20 7:30 pm", 90, 900.10));
        flights.add(new Flight(456,"Toronto", "London","03/04/20 6:30 pm", 100, 1000.50));
        flights.add(new Flight(789,"Miami", "Edmonton","05/06/20 4:30 pm", 110, 1500.60));
        flights.add(new Flight(1011,"Dallas", "London","07/08/20 2:30 pm", 90, 500.80));
        flights.add(new Flight(1213,"Dallas", "Tokyo","09/10/20 2:30 am", 90, 1500.05));
        flights.add(new Flight(1415,"Hamilton", "Toronto","11/12/20 11:30 pm", 90, 300.50));
        flights.add(new Flight(1617,"North Pole", "South Pole","12/13/20 5:30 pm", 100, 800.40));
        flights.add(new Flight(1819,"New Mexico", "Vancouver","12/14/20 12:30 am", 110, 700.30));
        
        //Secret flight:
        //flights.add(new Flight(777, "Toronto", "Hawaii", "Congratulations! You just won a flight to Hawaii!"))
    }
    
    //This method should display all the available flights from origin to destination 
    //It should display only those flights that are not yet fully booked
    public void displayAvailableFlights(String origin, String destination) {
        for (Flight f : flights) {
            if (f.getDestination().equals(destination) && f.getOrigin().equals(origin)) {
                if (f.getNumberOfSeatsLeft()>0)
                    System.out.println(f.toString());
            }
        }
    }
    
    //This method should return the Flight object for the specified flightNumber
    public Flight getFlight(int flightNumber) {
        for (Flight f : flights) {
            if (f.getFlightNumber() == flightNumber) {
                return f;
            }
        }
        System.out.println("There were no flights for the specified flight number.");
        return null;
    } 
    
    //This method first tries to find a flight for the given flight number 
    //If such flight exists, then it tries to book a seat in that flight 
    //If booking is successful, then applies the appropriate discount on the price depending on 
    //the passenger being a member or a non-member
    public void bookSeat(int flightNumber, Passenger p){
        Flight f = getFlight(flightNumber);
        
        if(f!=null){
            issuedTickets.add(new Ticket(p, f, p.applyDiscount(f.getOriginalPrice())));
            System.out.println(issuedTickets.get(ticketNumber).toString());
            ticketNumber++;
        }
    }
    
    /**
     * @param args the command line arguments
     * This  method  should  call  all  the  other  methods  of  the Manager class to see if they work
     * It will work as follows:
     * -The object of type Manager, tahmid is created and this object will call the createFlights method to generate the flights
     * -Arbitrary values of passengers (john, bob, barney) are set as members or non-members and given discounts accordingly through 
     * the Member and NonMember class depending on their age and number of years of membership
     * -The tahmid object will call displayAvailableFlights to show the flights from the desired origin and destination
     * -The tahmid object will call getFlight to get the flights of the flightNumber given to the call
     * -The tahmid object will lastly book the seats for the passengers for the specified flightNumber and if they're a member or non-member
     */
    public static void main(String[] args) {
        Manager tahmid = new Manager(); 
        
        //The createFlights method works
        tahmid.createFlights();
       
        Passenger john = new NonMember("John", 20);
        Passenger bob = new Member(7, "Bob", 25);
        Passenger barney = new NonMember("Barney", 99);
       
        //The displayAvailableFlights method works and initially displays all the available flights
        System.out.println("Displaying all the available flights for the desired origin and destination:");
        tahmid.displayAvailableFlights("Toronto", "London");
        tahmid.displayAvailableFlights("Dallas", "Tokyo");
        System.out.println("\n");
       
        //The getFlight method works and displays the specified flight object for the flightNumber
        System.out.println("Displaying the flights for the specified flight number:");
        System.out.println(tahmid.getFlight(123).toString());
        System.out.println(tahmid.getFlight(789).toString());
        System.out.println("\n");
       
        //The bookSeat method works and issues the ticket according to the discount as shown when run the file
        System.out.println("Displaying the issued tickets:");
        tahmid.bookSeat(123, john);
        tahmid.bookSeat(789, bob);
        tahmid.bookSeat(1011, barney);
        tahmid.bookSeat(1415, john);
    }
    
}
