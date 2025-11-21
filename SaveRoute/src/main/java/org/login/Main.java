package org.login;

import javax.swing.*;

public class Main {
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


    }
}
