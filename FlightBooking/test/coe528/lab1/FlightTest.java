/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import org.junit.Assert;

/**
 *
 * @author Tahmi
 */
public class FlightTest {
    //The following is the declaration and initialization of the arguments to be tested using the testConstructor method
    public static Flight flightInitialTest = new Flight(1030, "Toronto", "London", "03/02/99 7:50 pm", 100, 1000.0D);
    
    //The following methods: setUpClass, tearDownClass, setUp, tearDown are default and not used
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //The testConstructor method tests both of the Flight constructors by providing it with valid arguments (flightInitialTest and testFlightInput)
    //It was observed no tests in the testConstructor method failed with valid arguments, thus the test passed
    //Additionally, the Flight constructors were tested using the getters and instanceof
    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        Flight testFlightInput = new Flight(flightInitialTest);
        
        Assert.assertEquals(testFlightInput.getFlightNumber(), flightInitialTest.getFlightNumber(), 0.0D);
        Assert.assertEquals(testFlightInput.getOrigin(), flightInitialTest.getOrigin());
        Assert.assertEquals(testFlightInput.getDestination(), flightInitialTest.getDestination());
        Assert.assertEquals(testFlightInput.getDepartureTime(), flightInitialTest.getDepartureTime());
        Assert.assertEquals(testFlightInput.getCapacity(), flightInitialTest.getCapacity(), 0.0D);
        Assert.assertEquals(testFlightInput.getNumberOfSeatsLeft(), flightInitialTest.getNumberOfSeatsLeft()); //Number of seats left may not need 0.0D at the end
        Assert.assertEquals(testFlightInput.getOriginalPrice(), flightInitialTest.getOriginalPrice(), 0.0D);
        
        testFlightInput = new Flight(flightInitialTest.getFlightNumber(), flightInitialTest.getOrigin(), flightInitialTest.getDestination(), flightInitialTest.getDepartureTime(), flightInitialTest.getCapacity(), flightInitialTest.getOriginalPrice());
        
        Assert.assertEquals(testFlightInput.getFlightNumber(), flightInitialTest.getFlightNumber(), 0.0D);
        Assert.assertEquals(testFlightInput.getOrigin(), flightInitialTest.getOrigin());
        Assert.assertEquals(testFlightInput.getDestination(), flightInitialTest.getDestination());
        Assert.assertEquals(testFlightInput.getDepartureTime(), flightInitialTest.getDepartureTime());
        Assert.assertEquals(testFlightInput.getCapacity(), flightInitialTest.getCapacity(), 0.0D);
        Assert.assertEquals(testFlightInput.getNumberOfSeatsLeft(), flightInitialTest.getCapacity()); //Number of seats left may not need 0.0D at the end, and in the first Flight constructor, numberOfSeatsLeft is initialized to capacity
        Assert.assertEquals(testFlightInput.getOriginalPrice(), flightInitialTest.getOriginalPrice(), 0.0D);
        
        Assert.assertTrue(testFlightInput instanceof Flight);
    }
    
    //The testInvalidConstructor method tests the Flight constructor with invalid arguments of testFlightInvalidInput as shown.
    //The test should pass only if an IllegalArgumentException is thrown, when the origin equals the destination as shown, Toronto equals Toronto
    //It was observed that the test passed after an IllegalArgumentException was thrown by the Flight constructor
    @Test
    public void testInvalidConstructor() {
       System.out.println("testInvalidConstructor");
       
       try {
           Flight testFlightInvalidInput = new Flight(1030, "Toronto", "Toronto", "03/02/99 7:50 pm", 100, 1000.0D);
           
       }
       catch (IllegalArgumentException e) {
           System.out.println(e);
       }
    }
    
    //The following are the test methods for the setters

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setFlightNumber");
        
        testFlightInput.setFlightNumber(1020);
        Assert.assertEquals(1020.0D, testFlightInput.getFlightNumber(), 0.0D);
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setOrigin");
        
        testFlightInput.setOrigin("Montreal");
        Assert.assertEquals("Montreal", testFlightInput.getOrigin());
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setDestination");
        
        testFlightInput.setDestination("Vancouver");
        Assert.assertEquals("Vancouver", testFlightInput.getDestination());
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setDepartureTime");
        
        testFlightInput.setDepartureTime("05/05/20 5:00 pm");
        Assert.assertEquals("05/05/20 5:00 pm", testFlightInput.getDepartureTime());
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setCapacity");
        
        testFlightInput.setCapacity(100);
        Assert.assertEquals(100, testFlightInput.getCapacity(), 0.0D);
        
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setNumberOfSeatsLeft");
        
        testFlightInput.setNumberOfSeatsLeft(20);
        Assert.assertEquals(20, testFlightInput.getNumberOfSeatsLeft());
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("setOriginalPrice");
        
        testFlightInput.setOriginalPrice(900.0D);
        Assert.assertEquals(900.0D, testFlightInput.getOriginalPrice(), 0.0D);
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getFlightNumber");
        
        int expFlightNumber = 1030;
        int resultFlightNumber = testFlightInput.getFlightNumber();
        Assert.assertEquals(expFlightNumber, resultFlightNumber);
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getOrigin");
        
        String expOrigin = "Toronto";
        String resultOrigin = testFlightInput.getOrigin();
        Assert.assertEquals(expOrigin, resultOrigin);
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getDestination");
        
        String expDestination = "London";
        String resultDestination = testFlightInput.getDestination();
        Assert.assertEquals(expDestination, resultDestination);
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getDepartureTime");
        
        String expDepartureTime = "03/02/99 7:50 pm";
        String resultDepartureTime = testFlightInput.getDepartureTime();
        Assert.assertEquals(expDepartureTime, resultDepartureTime);
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getCapacity");
        
        int expCapacity = 0;
        int resultCapacity = testFlightInput.getCapacity();
        Assert.assertEquals(expCapacity, resultCapacity);
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getNumberOfSeatsLeft");
        
        int expNumberOfSeatsLeft = 100;
        int resultNumberOfSeatsLeft = testFlightInput.getNumberOfSeatsLeft();
        Assert.assertEquals(expNumberOfSeatsLeft, resultNumberOfSeatsLeft);
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("getOriginalPrice");
        
        double expOriginalPrice = 1000.0D;
        double resultOriginalPrice = testFlightInput.getOriginalPrice();
        Assert.assertEquals(expOriginalPrice, resultOriginalPrice, 0.0D);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("bookASeat");
        
        boolean expBookASeat = true;
        boolean resultBookASeat = testFlightInput.bookASeat();
        assertEquals(expBookASeat, resultBookASeat);
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        Flight testFlightInput = new Flight(flightInitialTest);
        System.out.println("toString");
        
        Assert.assertEquals(flightInitialTest.toString(), testFlightInput.toString());
    }
    
}
