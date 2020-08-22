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
public class Member extends Passenger{
    //The instance variable is declared
    public int yearsOfMembership;
    
    //The constructor Member initializes the instance variables
    public Member(int yearsOfMembership, String name, int age) {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    //The optional constructor Member accepts member of type Member
    public Member(Member member) {
        super(member.getName(), member.getAge());
        this.yearsOfMembership = member.yearsOfMembership;
    }
    
    //The following are the setter and getter of the instance variable
    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }
    
    public int getYearsOfMembership() {
        return this.yearsOfMembership;
    }
    
    //The Member class overrides the Passenger class
    //If the member has membership for more than 5 years, then 50% discount will be applied
    //If the member has membership for more than 1 year but less than or equal to 5 years, then 10% discount will be applied
    //Otherwise no discount
    @Override
    public double applyDiscount(double p) {
        if (this.yearsOfMembership > 5) {
            return p * 0.5D; 
        }
        if (this.yearsOfMembership > 1) {
            return p * 0.9D; 
        }
        return p;
    }
}
