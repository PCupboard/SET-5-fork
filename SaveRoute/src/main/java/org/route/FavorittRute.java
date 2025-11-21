package org.route;

public class FavorittRute extends Rute{

    public FavorittRute() {
    }

    public FavorittRute(String destinasjon, String startpunkt) {
        super(destinasjon, startpunkt);
    }

    @Override
    public String getDestinasjon() {
        return super.getDestinasjon();
    }

    @Override
    public void setDestinasjon(String destinasjon) {
        super.setDestinasjon(destinasjon);
    }

    @Override
    public void setStartpunkt(String startpunkt) {
        super.setStartpunkt(startpunkt);
    }

    @Override
    public String getStartpunkt() {
        return super.getStartpunkt();
    }
}
