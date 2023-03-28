package services;

import models.Driver;
import models.User;
import models.Location;
import models.Ride;
import java.util.*;
import exceptions.DriverNotAvailableException;

public class RideService {

    private static RideService rideService = null;

    private UserService userService = UserService.getInstance();

    private static Integer MAX_DISTANCE = 5;
    private Scanner sc= new Scanner(System.in);
    private RideService(){

    }

    public static RideService getInstance(){
        if(rideService == null){
            rideService = new RideService();
        }
        return rideService;
    }

    public void findRide(int userId, Location fromLocation, Location toLocation) throws DriverNotAvailableException {
        User user = userService.userMap.get(userId);
        System.out.println("SERCHING DRIVER'S FOR "+user.getName());
        List<Driver> driverList =getAllAvailableDrivers(fromLocation);
        System.out.println("List of Available Drivers:");
        if(driverList.isEmpty()){
            throw new DriverNotAvailableException("We are really sorry. There are no Driver's available at your location currently. Please try again after some time.");
        }
        for(int i=0;i<driverList.size();i++){
            System.out.println(driverList.get(i).getName()+" is available with "+driverList.get(i).getVehicle().getName()+" "+driverList.get(i).getVehicle().getvehicleId()+".");
        }
        System.out.println();
        System.out.println("Enter the driver name you want to select:");
        String driverName = sc.nextLine();

        for(Driver driver : userService.getDriverMap().values()){
            if( driver.getName().equals(driverName) && driver.isAvailable()){
                driver.setAvailable(false);
                System.out.println("Your ride is booked successfully!!");
                System.out.println(driver.getName()+" is on it's way to pick you up.");
                System.out.println();
                Ride ride = new Ride(driver, user, fromLocation, toLocation);
                user.getRideList().add(ride);
            }
        }
    }

    public List<Driver> getAllAvailableDrivers(Location location) {
        List<Driver> driverList = new ArrayList<Driver>();
        for(Driver driver : userService.getDriverMap().values()){
            if(driver.isAvailable() && distance(driver.getVehicle().getLocation(), location) <= MAX_DISTANCE){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    public Double distance(Location l1, Location l2){
        return Math.sqrt((l1.getX() - l2.getX())*(l1.getX() - l2.getX()) + (l1.getY() - l2.getY())*(l1.getY() - l2.getY()));
    }

}
