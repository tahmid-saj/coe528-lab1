/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

/**
 *
 * @author Tahmi
 */
public class Flight {
    //The seven instance variables of the Flight class are declared
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    //The Flight constructor performs accordingly:
    //-The constructor accepts six parameters and initializes the instance variables
    //-If the origin and destination parameters are equal, an IllegalArgumentException will be thrown
    //-The numberOfSeatsLeft instance variable will be initialized using the capacity
    //-The constructor will catch the IllegalArgumentException and print the message, e
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, double originalPrice) {
        try {
            if (origin.equals(destination)) {
                throw new IllegalArgumentException("The origin cannot equal the destination");
            }
            this.flightNumber = flightNumber;
            this.origin = origin;
            this.destination = destination;
            this.departureTime = departureTime;
            this.numberOfSeatsLeft = capacity;
            this.originalPrice = originalPrice;
        } 
        catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    } 
    
    //The copied Flight constructor will only take a Flight object and is therefore optionally included in the class
    //The constructor initializes the instance variables using the getters instead
    public Flight(Flight flight) {
        try {
            if (flight.getOrigin().equals(flight.getDestination())) {
                throw new IllegalArgumentException("Invalid input, the origin and destination cannot equal");
            }
            this.flightNumber = flight.getFlightNumber();
            this.origin = flight.getOrigin();
            this.destination = flight.getDestination();
            this.departureTime = flight.getDepartureTime();
            this.capacity = flight.getCapacity();
            this.numberOfSeatsLeft = flight.getNumberOfSeatsLeft();
            this.originalPrice = flight.getOriginalPrice();
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    
    //The following are the setter methods as follows:
    
    //setFlightNumber: accepts flightNumber and initializes the flightNumber instance variable
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    //setOrigin: accepts origin and if the parameter origin doesn't equal instance variable destination, the instance variable origin 
    //will be initialized to origin. Otherwise, an IllegalArgumentException will be thrown and a catch will display the message, e.
    public void setOrigin(String origin) {
        try {
            if (!origin.equals(this.destination)) {
                this.origin = origin;
            }
            else {
                throw new IllegalArgumentException("Invalid input, the origin and destination cannot equal");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    
    //setDestination: accepts destination and if the parameter destination doesn't equal instance variable origin, the instance variable
    //destination will be initialized to destination. Otherwise, an IllegalArgumentException will be thrown and a catch will display the message, e.
    public void setDestination(String destination) {
        try {
            if (!destination.equals(this.origin)) {
                this.destination = destination;
            }
            else {
                throw new IllegalArgumentException("Invalid input, the origin and destination cannot equal");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
    }
    
    //setDepartureTime: accepts departureTime and initializes instance variable departureTime
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    
    //setCapacity: accepts capacity, and initializes instance variable capacity to capacity
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    //setNumberOfSeatsLeft: accepts numberOfSeatsLeft and initializes instance variable numberOfSeatsLeft
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    //setOriginPrice: accepts originalPrice and initializes instance variable originPrice
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    //The following are the getter methods as follows:
    
    //getFlightNumber: returns instance variable flightNumber
    public int getFlightNumber() {
        return this.flightNumber;
    }
    
    //getOrigin: returns instance variable origin
    public String getOrigin() {
        return this.origin;
    }
    
    //getDestination: returns instance variable destination
    public String getDestination() {
        return this.destination;
    }
    
    //getDepartureTime: returns instance variable departureTime
    public String getDepartureTime() {
        return this.departureTime;
    }
    
    //getCapacity: returns instance variable capacity
    public int getCapacity() {
        return this.capacity;
    }
    
    //getNumberOfSeatsLeft: returns instance variable numberOfSeatsLeft
    public int getNumberOfSeatsLeft() {
        return this.numberOfSeatsLeft;
    }
    
    //getOriginalPrice: returns instance variable originalPrice
    public double getOriginalPrice() {
        return this.originalPrice;
    }
    
    // If the instance variable numberOfSeatsLeftis greater than 0, the method decrements the numberOfSeatsLeft 
    //and returns true. Otherwise, it returns false
    public boolean bookASeat() {
        if (this.numberOfSeatsLeft > 0) {
            numberOfSeatsLeft--;
            return true;
        }
        return false;
    }
    
    //The toString method returns the string representation of the Flight object, including the flightNumber, origin, destination,
    //departureTime, and originalPrice
    @Override
    public String toString() {
        return "Flight " + this.flightNumber + ", " + this.origin + " to " + this.destination + ", " + this.departureTime + ", original price: $" + this.originalPrice; 
    }
}

