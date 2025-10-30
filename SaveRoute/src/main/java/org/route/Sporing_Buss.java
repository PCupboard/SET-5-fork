package org.route;

public class Sporing_Buss {

    private Integer Bus_Id;
    private double longtitude;
    private double latitude;

    public Sporing_Buss(Integer bus_Id, double longtitude, double latitude) {
        Bus_Id = bus_Id;
        this.longtitude = longtitude;
        this.latitude = latitude;
    }

    public Integer getBus_Id() {
        return Bus_Id;
    }

    public void setBus_Id(Integer bus_Id) {
        Bus_Id = bus_Id;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public double getLatitude() {
        return latitude;
    }
}
