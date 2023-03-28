package driverCode;

import enums.Gender;
import exceptions.CreateException;
import exceptions.NoRideDetailsException;
import models.*;
import services.CabBookingService;

public class Main {
    public static void main(String[] args) throws NoRideDetailsException{
        CabBookingService cabBookingService = CabBookingService.getInstance();

        User u1 =  null;
        User u2 =  null;
        User u3 =  null;
        try
        {
            System.out.println("REGISTERING USERS:");
            u1 = cabBookingService.addUser("Abhisek", 23, Gender.MALE);
            System.out.println(u1.getName() + " registered successfully.");

            u2 = cabBookingService.addUser("Rahul", 29, Gender.MALE);
            System.out.println(u2.getName() + " registered successfully.");

            u3 = cabBookingService.addUser("Nandini", 22, Gender.FEMALE);
            System.out.println(u3.getName() + " registered successfully.");
            System.out.println();
        }
        catch(CreateException e){
            System.out.println(e.getMessage());
        }

        Location l1 = new Location(10, 1);
        Vehicle v1 = new Vehicle("Swift", "KA-01-12341", l1);
        Driver d1 = null;

        Location l2 = new Location(11, 10);
        Vehicle v2 = new Vehicle("Indica", "KA-01-12342", l2);
        Driver d2 = null;

        Location l3 = new Location(5, 3);
        Vehicle v3 = new Vehicle("BMW", "KA-01-12343", l3);
        Driver d3 = null;        

        try{
            System.out.println("REGISTERING DRIVERS:");
            d1 = cabBookingService.addDriver("Driver1", 22, Gender.MALE, v1, true);
            System.out.println(d1.getName() + " registered successfully.");
            d2 = cabBookingService.addDriver("Driver2", 29, Gender.MALE, v2, true);
            System.out.println(d2.getName() + " registered successfully.");
            d3 = cabBookingService.addDriver("Driver3", 24, Gender.MALE, v3, true);
            System.out.println(d3.getName() + " registered successfully.");
            System.out.println();
        }
        catch(CreateException e)
        {
            System.out.println(e.getMessage());
        }

        Location pick1 = new Location(0,0);
        Location drop1 = new Location(20, 1);
        Location pick2 = new Location(10,0);
        Location drop2 = new Location(15, 3);
        Location pick3 = new Location(15,6);
        Location drop3 = new Location(20, 4);

        try {
            cabBookingService.findRide(23, pick1, drop1);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }
        try {
            cabBookingService.findRide(29, pick2, drop2);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }
        try {
            cabBookingService.findRide(22, pick3, drop3);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try {
            cabBookingService.rideHistory("Rahul");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }

        try {
            cabBookingService.rideHistory("Abhisek");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}