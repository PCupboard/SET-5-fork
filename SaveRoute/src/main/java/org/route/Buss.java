package org.route;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Buss {

    private String buss_Id;
    private String rute_navn;
    private String startpunkt;
    private String destinasjon;
    private LocalDateTime avgang;

    public Buss(String buss_Id, String rute_navn, String startpunkt, String destinasjon, LocalDateTime avgang) {
        this.buss_Id = buss_Id;
        this.rute_navn = rute_navn;
        this.startpunkt = startpunkt;
        this.destinasjon = destinasjon;
        this.avgang = avgang;
    }

    public String getBuss_Id() {
        return buss_Id;
    }

    public void setBuss_Id(String buss_Id) {
        this.buss_Id = buss_Id;
    }

    public String getRute_navn() {
        return rute_navn;
    }

    public void setRute_navn(String rute_navn) {
        this.rute_navn = rute_navn;
    }

    public String getStartpunkt() {
        return startpunkt;
    }

    public void setStartpunkt(String startpunkt) {
        this.startpunkt = startpunkt;
    }

    public String getDestinasjon() {
        return destinasjon;
    }

    public void setDestinasjon(String destinasjon) {
        this.destinasjon = destinasjon;
    }

    public LocalDateTime getAvgang() {
        return avgang;
    }

    public void setAvgang(LocalDateTime avgang) {
        this.avgang = avgang;
    }

    @Override
    public String toString() {
        return "Buss{" +
                "buss_Id='" + buss_Id + '\'' +
                ", rute_navn='" + rute_navn + '\'' +
                ", startpunkt='" + startpunkt + '\'' +
                ", destinasjon='" + destinasjon + '\'' +
                ", avgang=" + avgang +
                '}';
    }
}
