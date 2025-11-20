package org.route;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.login.Innlogging;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Applikasjon {

    //her ønsker vi å sette innloggingen sammen i programmet, slik kan kunden verifisere seg
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                //instansierer en objekt av klassen Innlogging og slik kan vi sjekke om funksjonene vi legger funker som de skal
                new Innlogging().setVisible(true);
                //new Registrering().setVisible(true);

                //sjekker om brukeren eksisterer vi får true=ja eller false=nei
                //System.out.println(SQLconnection.sjekkbruker("k"));

                //sjekker om vi kan registrere
                //System.out.println(SQLconnection.registrer("Ava","1234"));

                //prøver å sjekke om vi kan logge inn eller sjekke om det kommer false for feil passord/brukernavn
                //System.out.println(SQLconnection.bekrefteInnlogging("Ava","123"));

            }
        });



        Scanner input_2 = new Scanner(System.in);
        int x;

        do {
            System.out.println("Velg en av de følgende: ");
            System.out.println("1.Finn reise!");
            System.out.println("2.Se avganger!");
            System.out.println("3.Se favoritter ruter!");
            System.out.println("Trykk 0 for å logge ut av applikasjonen!");
            x =input_2.nextInt();
            switch (x) {
                case 0:
                    System.out.println("Du er nå logget ut!");
                    System.exit(0);
                    break;

                case 1:

                    Scanner scan = new Scanner(System.in);
                    System.out.print("Destinasjon: ");
                    String destinasjon = scan.nextLine();

                    System.out.print("Startpunkt: ");
                    String startpunkt = scan.nextLine();


                    Rute nyrute = new Rute();
                    nyrute.setDestinasjon(destinasjon);
                    nyrute.setStartpunkt(startpunkt);

                    scan.close();
                    //Her oppretter jeg en forbindelse med databasen
                    DatabaseConnection databaseConnection_Rute = new DatabaseConnection("root"," ");

                    try{
                        //etablerer vi forbindelsen
                        databaseConnection_Rute.connect();

                        //lager spørring som skal spesifikt vise fram de dataene jeg ønsker, mulig må legge klokkeslett
                        //bruker ustrupstegn fordi det er en alternativ måte for å sette ekstern input(Scanner) i databasen
                        String sql = "Select * FROM RUTE WHERE startpunkt = ? AND destinasjon = ?";// spøringer men må bruke en eller annet identifikasjonmåte
                        PreparedStatement preparedStatement= databaseConnection_Rute.getConnection().prepareStatement(sql);
                        preparedStatement.setString(1,destinasjon);
                        preparedStatement.setString(2,startpunkt);


                        databaseConnection_Rute.connect();
                        ResultSet resultSet = preparedStatement.executeQuery(sql);

                        while (resultSet.next()){

                            System.out.println("Startpunkt : " + resultSet.getString("Startpunkt"));
                            System.out.println("Destinasjon: " + resultSet.getString("Destinasjon"));

                        }
                        resultSet.close();
                        preparedStatement.close();
                        databaseConnection_Rute.closeConnection();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println();
                    break;

                case 2:
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Se avganger for: ");

                    scan2.close();

                    DatabaseConnection databaseConnection_Holdeplass = new DatabaseConnection("root"," ");
                    String sql_1 = "Select * FROM HOLDEPLASS WHERE navn = ? ";// spøringer men må bruke en eller annet identifikasjonmåte

                    try {
                        databaseConnection_Holdeplass.connect();
                        ResultSet resultSet = databaseConnection_Holdeplass.getStatement().executeQuery(sql_1);

                        while (resultSet.next()){

                        }
                        resultSet.close();
                        databaseConnection_Holdeplass.closeConnection();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    System.out.println();
                    break;

                case 3:
                    try{
                        ObjectMapper objectMapper1 = new ObjectMapper();
                        FavorittRute leser_rute_oversikt = objectMapper1.readValue(new File("favoritt_rute.json"), FavorittRute.class);
                        System.out.println("Fra "+leser_rute_oversikt.getStartpunkt()+" til "+ leser_rute_oversikt.getDestinasjon());}
                    catch (IOException e){
                        System.out.println("Klarer ikke å lese filen du spør etter! " + e);
                    }
                    System.out.println();
                    break;
            }


        }while (x!=0);




    }

    

}