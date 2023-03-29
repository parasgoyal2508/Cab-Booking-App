package services;

import enums.Gender;
import exceptions.CreateException;
import exceptions.NoRideDetailsException;
import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {

    private static UserService userService = null;

    private UserService(){

    }

    public Map<Integer, User> userMap = new HashMap<Integer, User>();

    public Map<Integer, Driver> driverMap = new HashMap<Integer, Driver>();

    public Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public Driver registerDriver(String name, int id, Gender gender, Vehicle v1, boolean available) throws CreateException {
        Driver driver = new Driver(name, id, gender, v1, available);
        if(driver == null || driverMap.containsKey(driver.getId())){
            throw new CreateException("Oops!! Driver was not registered.");
        }
        driverMap.put(driver.getId(), driver);
        vehicleMap.put(driver.getVehicle().getvehicleId(), driver.getVehicle());
        return driver;
    }

    public User registerUser(String name, int id, Gender gender) throws CreateException{
        User user = new User(name, id, gender);
        if(user == null || userMap.containsKey(user.getId())){
            throw new CreateException("Oops!! User was not registered.");
        }
        userMap.put(user.getId(), user);
        return user;
    }

    public void rideHistory(String name) throws NoRideDetailsException{
        System.out.println("Ride history of "+name+":"); 
        for(User user : getUserMap().values()){
            if( user.getName().equals(name)){
                List<Ride> ridelist = user.getRideList();
                if(ridelist.size()==0){
                    throw new NoRideDetailsException("User hasn't taken any ride yet!");
                }
                for(Ride ride : ridelist){
                    System.out.println("Ride with "+ ride.getDriver().getName()+" from ("+ ride.getFromLocation().getX()+","+ride.getFromLocation().getY()+") to ("+ride.getToLocation().getX()+","+ride.getToLocation().getY()+").");
                }
                System.out.println();
            }
        }
    }

    public Map<Integer, Driver> getDriverMap(){
        return driverMap;
    }

    public Map<Integer, User> getUserMap(){
        return userMap;
    }

    public Map<String, Vehicle> getVehicleMap(){
        return vehicleMap;
    }
    
}
