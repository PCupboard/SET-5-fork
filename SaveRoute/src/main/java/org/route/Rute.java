package org.route;

import java.util.ArrayList;

public class Rute {

    private String destinasjon;
    private String startpunkt;
    private ArrayList<Holdeplass> stopp;
    private String rute_navn;
    private String tidstabell;

    public Rute(){}

    public Rute(String destinasjon,String startpunkt) {
        this.destinasjon = destinasjon;
        this.stopp = stopp;
        this.startpunkt = startpunkt;
    }

    public String getDestinasjon() {
        return destinasjon;
    }

    public void setDestinasjon(String destinasjon) {
        this.destinasjon = destinasjon;
    }

    public void setStartpunkt(String startpunkt) {
        this.startpunkt = startpunkt;
    }

    public String getStartpunkt() {
        return startpunkt;
    }
}
