package services;

import enums.Gender;
import exceptions.*;
import models.Driver;
import models.Location;
import models.User;
import models.Vehicle;

public class CabBookingService {
    private static CabBookingService cabBookingService = null;

    private CabBookingService(){

    }

    public static CabBookingService getInstance(){
        if(cabBookingService == null){
            cabBookingService = new CabBookingService();
        }
        return cabBookingService;
    }

    private UserService userService = UserService.getInstance();

    private RideService rideService = RideService.getInstance();

    public Driver addDriver(String name, int id, Gender gender, Vehicle vehicle, boolean available) throws CreateException{
        return userService.registerDriver(name, id, gender, vehicle, available);
    }

    public User addUser(String name, int id, Gender gender) throws CreateException {
        return userService.registerUser(name, id, gender);
    }

    public void findRide(int userId, Location fromLocation, Location toLocation) throws DriverNotAvailableException {
        rideService.findRide(userId, fromLocation, toLocation);
    }

    public void rideHistory(String name) throws NoRideDetailsException{
        userService.rideHistory(name);
    }

    public void endRide(int userId, String driverName, Location toLocation) throws RideEndedAlreadyException{
        rideService.endRide(userId, driverName, toLocation);
    }
}