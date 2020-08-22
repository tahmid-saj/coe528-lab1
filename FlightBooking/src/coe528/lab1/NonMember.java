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
public class NonMember extends Passenger{
    //This class has no instance variables
    
    //The constructors of the NonMember class
    public NonMember(String name, int age) {
        super(name, age);
    }
  
    public NonMember(NonMember nonMember) {
        super(nonMember);
    }
    
    //The NonMember class overrides the Passenger class
    //If the age of the person is more than 65, 10% discount will be applied
    //Otherwise no discount
    @Override
    public double applyDiscount(double p) {
        if (this.getAge() > 65)                                                 //The this keyword is opptional here
            return p * 0.9D; 
        return p;
    }
}
