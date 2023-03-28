package models;

public class Vehicle {
    private String name;
    private String vehicleId;
    private Location location;

    public Vehicle(String name, String vehicleId, Location location)
    {
        this.name = name;
        this.vehicleId = vehicleId;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getvehicleId() {
        return vehicleId;
    }

    public void setvehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
