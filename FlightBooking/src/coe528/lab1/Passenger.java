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
public abstract class Passenger {
    //The two instance variables of the Passenger class are declared
    public String name;
    public int age;
    
    //Constructor Passenger initializes the instance variables
    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    //Optional constructor Passenger accepts passenger of type Passenger
    public Passenger(Passenger passenger) {
        this.name = passenger.getName();
        this.age = passenger.getAge();
    }
    
    //The following are the setters
    public void setName(String name) {
        this.name = name;
    }
  
    public void setAge(int age) {
        this.age = age;
    }
    
    //The following are the getters
    public String getName() {
        return this.name;
    }
  
    public int getAge() {
        return this.age;
    }
    
    //The following is the abstract method
    public abstract double applyDiscount(double p);
}
