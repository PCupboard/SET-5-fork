package org.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Innlogging extends Frame {
    public Innlogging(){
        super("Innlogging");
        GUIkomponenter();
    }

    protected void GUIkomponenter(){
        //lager Innloggins merken i GUIen vår
        JLabel logg_innLabel = new JLabel("Logg inn");
        //presisere hvor akkurat innloggingdsmerken skal være
        logg_innLabel.setBounds(0,25,520,100);

        //setter farge i innlogginsteksten
        logg_innLabel.setForeground(fargeGUIkonstanter.TEXT_COLOR);

        //lager litt større bokstaver
        logg_innLabel.setFont(new Font("Dialog",Font.BOLD,40));

        //sentrerer innloggingsmerken
        logg_innLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //legger inloggins merken i GUIen
        add(logg_innLabel);

        //lager en navn merke iGuien og legger en tastefunskjon for å skrive navnet(brukernavn =navn, +logikk
        // feil fra min side)
        JLabel brukernavn_label = new JLabel("Navn: ");
        brukernavn_label.setBounds(30, 150, 400, 25);
        brukernavn_label.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        brukernavn_label.setFont(new Font("Dialog",Font.PLAIN,20));


        JTextField brukernavn_field = new JTextField();
        brukernavn_field.setBounds(30,185,450,55);
        brukernavn_field.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        brukernavn_field.setFont(new Font("Dialog",Font.PLAIN,20));

        add(brukernavn_label);
        add(brukernavn_field);

        //her lager jeg merke for passord i tillegg legger jeg en tastefunksjon
        JLabel passord_label = new JLabel("Passord: ");
        passord_label.setBounds(30, 335, 400, 25);
        passord_label.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        passord_label.setFont(new Font("Dialog",Font.PLAIN,20));


        // jeg bruker JPasswordField for å skjule passordet mens brukeren skriver et, et sikkerhetstiltak
        JPasswordField passord_field = new JPasswordField();
        passord_field.setBounds(30,360,450,55);
        passord_field.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        passord_field.setFont(new Font("Dialog",Font.PLAIN,20));


        //legger dette i GUIen
        add(passord_label);
        add(passord_field);

        //lager en knapp for utføre innlogging
        JButton logginn_knapp = new JButton("Logg inn");
        logginn_knapp.setFont(new Font("Dialog",Font.BOLD,16));

        //med denne funskjonen når vi setter pekern i logg inn boksen, så skifter den til hånd
        logginn_knapp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logginn_knapp.setBackground(fargeGUIkonstanter.SECONDARY_COLOR);
        logginn_knapp.setBounds(125,500,245,50);
        logginn_knapp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //hent brukernavn
                String brukernavn = brukernavn_field.getText();

                //hent passord
                String passord = new String(passord_field.getPassword());

                //sjekker mot databsen om innlogings info stemmer
                if(SQLconnection.bekrefteInnlogging(brukernavn,passord)){
                    // innlogging vellyket
                    JOptionPane.showMessageDialog(Innlogging.this,
                            "Du er nå logget inn!");
                    Innlogging.this.dispose();
                }else{
                    //innlogging mislyktes
                    JOptionPane.showMessageDialog(Innlogging.this,
                            "Innlogging mislyktes, prøv på nytt!");
                }
            }
        });
        add(logginn_knapp);

        // her skal jeg lage  en registreringsknapp som skal hjelpe med å få registrert nye brukere("kunder" bare)
        JLabel registreringmerke  = new JLabel("Ny Bruker? Registrer deg!");
        registreringmerke.setHorizontalAlignment(SwingConstants.CENTER);
        registreringmerke.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registreringmerke.setBackground(fargeGUIkonstanter.TEXT_COLOR);

        //Etter litt research så fant jeg ut at vi kan ikke bruke ActionListener i Jlabel,
        //men vi kan bruke MouseListener, som skal hjelpe oss å initiliasere registreringsfunksjonen
        registreringmerke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               //lukke innlogginsvindu
                Innlogging.this.dispose();

                //åpne registreringsvindu
                new Registrering().setVisible(true);
            }
        });
        registreringmerke.setBounds(125,600,245,20);
        add(registreringmerke);


    }

}
