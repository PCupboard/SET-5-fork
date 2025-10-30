package org.route;


import org.login.Innlogging;

import javax.swing.*;
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
            System.out.println("Trykk 0 for å logge ut av applikasjonen!");
            x =input_2.nextInt();
            switch (x){
                case 0:
                    System.out.println("Du er nå logget ut!");
                    break;
            }

        }while (x!=0);


    }









}
