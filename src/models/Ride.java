package models;

public class Ride {
    private Driver driver;
    private User user;
    private Location fromLocation;
    private Location toLocation;
    private Boolean tripOngoing;

    public Ride(Driver driver, User user, Location fromLocation, Location toLocation, Boolean tripOngoing){
        this.driver = driver;
        this.user = user;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.tripOngoing=tripOngoing;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public boolean istripOngoing() {
        return tripOngoing;
    }

    public void setTripOngoing(Boolean tripOngoing) {
        this.tripOngoing = tripOngoing;
    }
}
