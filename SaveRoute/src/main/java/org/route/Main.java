package org.route;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;


import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {

        //System.out.print("Hei og velkommen!");

        Scanner scan = new Scanner(System.in);
        System.out.print("Destinasjon: ");
        String destinasjon = scan.nextLine();

        System.out.print("Startpunkt: ");
        String startpunkt = scan.nextLine();




        Rute nyrute = new Rute();
        nyrute.setDestinasjon(destinasjon);
        nyrute.setStartpunkt(startpunkt);



        /*try{
        ObjectMapper objectMapper = new ObjectMapper();
        Rute rute1 = new Rute(nyrute.getDestinasjon(), nyrute.getStartpunkt());
        objectMapper.writeValue(new File("rute.json"),rute1);}
        catch (IOException e){
            System.out.println("Klarer ikke å skrive i filen!");
        }

        try{
        ObjectMapper objectMapper1 = new ObjectMapper();
        Rute leser = objectMapper1.readValue(new File("rute.json"), Rute.class);
        System.out.println("Fra "+leser.getStartpunkt()+" til "+ leser.getDestinasjon());}
        catch (IOException e){
            System.out.println("Klarer ikke å lese filen du spør etter! " + e);
        }*/

        FavorittRute rute = new FavorittRute();
        rute.setDestinasjon(destinasjon);
        rute.setDestinasjon(startpunkt);

        System.out.println("Vil du lagre den i favoritt rute ?");
        String favoritt_linjer = scan.nextLine();

        scan.close();

        if (favoritt_linjer.equalsIgnoreCase("ja")){
            try{
                ObjectMapper objectMapper = new ObjectMapper();
                FavorittRute ruteoversikt = new FavorittRute(nyrute.getDestinasjon(), nyrute.getStartpunkt());
                objectMapper.writeValue(new File("favoritt_rute.json"),ruteoversikt);}
            catch (IOException e){
                System.out.println("Klarer ikke å skrive i filen!");
            }

            try{
                ObjectMapper objectMapper1 = new ObjectMapper();
                FavorittRute leser_rute_oversikt = objectMapper1.readValue(new File("favoritt_rute.json"), FavorittRute.class);
                System.out.println("Fra "+leser_rute_oversikt.getStartpunkt()+" til "+ leser_rute_oversikt.getDestinasjon());}
            catch (IOException e){
                System.out.println("Klarer ikke å lese filen du spør etter! " + e);
            }
            System.out.println("Favoritt rute lagret");
        }
        else if (favoritt_linjer.equalsIgnoreCase("nei")) {
            System.out.println("Rute ikke lagret!");
        }
        else{
            System.out.println("Noe gikk galt!");
        }

    }
}