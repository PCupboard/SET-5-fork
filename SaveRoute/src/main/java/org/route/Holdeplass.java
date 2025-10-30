package org.route;

public class Holdeplass {

    private String navn;
    private  int id;
    private String lokasjon;


    public Holdeplass(String navn, int id, String lokasjon) {
        this.navn = navn;
        this.id = id;
        this.lokasjon = lokasjon;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLokasjon() {
        return lokasjon;
    }

    public void setLokasjon(String lokasjon) {
        this.lokasjon = lokasjon;
    }
}
