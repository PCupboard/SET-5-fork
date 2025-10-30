package org.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Registrering extends Frame {

    public Registrering(){
        super("Registrering");
        GUIkomponenter();
    }

    protected void GUIkomponenter(){
        //lager Registrerings merken i GUIen vår
        JLabel registrer_Label = new JLabel("Registrer deg!");
        //presisere hvor akkurat innloggingdsmerken skal være
        registrer_Label.setBounds(0,25,520,100);

        //setter farge i innlogginsteksten
        registrer_Label.setForeground(fargeGUIkonstanter.TEXT_COLOR);

        //lager litt større bokstaver
        registrer_Label.setFont(new Font("Dialog",Font.BOLD,40));

        //sentrerer innloggingsmerken
        registrer_Label.setHorizontalAlignment(SwingConstants.CENTER);

        //legger inloggins merken i GUIen
        add(registrer_Label);

        //lager en brukernavn merke iGuien og legger en tastefunskjon for å skrive navnet,
        // brukernavn=navn skrev feil opp
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
        passord_label.setBounds(30, 256, 400, 25);
        passord_label.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        passord_label.setFont(new Font("Dialog",Font.PLAIN,20));

        //skriv passordet en gang til
        //her lager jeg merke for passord i tillegg legger jeg en tastefunksjon
        JLabel repassord_label = new JLabel("Skriv Passordet på nytt: ");
        repassord_label.setBounds(30, 365, 400, 25);
        repassord_label.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        repassord_label.setFont(new Font("Dialog",Font.PLAIN,20));


        // jeg bruker JPasswordField for å skjule passordet mens brukeren skriver et, et sikkerhetstiltak
        JPasswordField passord_field = new JPasswordField();
        passord_field.setBounds(30,280,450,55);
        passord_field.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        passord_field.setFont(new Font("Dialog",Font.PLAIN,20));

        // Gjenta passordet.jeg bruker JPasswordField for å skjule passordet mens brukeren skriver et, et sikkerhetstiltak
        JPasswordField repassord_field = new JPasswordField();
        repassord_field.setBounds(30,395,450,55);
        repassord_field.setForeground(fargeGUIkonstanter.TEXT_COLOR);
        repassord_field.setFont(new Font("Dialog",Font.PLAIN,20));


        //legger dette i GUIen
        add(passord_label);
        add(passord_field);
        add(repassord_field);
        add(repassord_label);

        //lager en knapp for utføre innlogging
        JButton registrerings_knapp = new JButton("Registrer deg");
        registrerings_knapp.setFont(new Font("Dialog",Font.BOLD,16));

        //med denne funskjonen når vi setter pekern i logg inn boksen, så skifter den til hånd
        registrerings_knapp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registrerings_knapp.setBackground(fargeGUIkonstanter.SECONDARY_COLOR);
        registrerings_knapp.setBounds(125,500,245,50);
        registrerings_knapp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get brukernavn
                String brukernavn = brukernavn_field.getText();

                //get passord
                String passord =  new String(passord_field.getPassword());

                //get skriv på nytt passordet
                String repassord = new String(repassord_field.getPassword());

                if(validerbrukerInput(brukernavn, passord,repassord)) {
                    if (SQLconnection.registrer(brukernavn, passord)) {
                        //lukke GUI vindu
                        Registrering.this.dispose();

                        //gå tilbake til innloggingen
                        Innlogging innlogging = new Innlogging();
                        innlogging.setVisible(true);

                        JOptionPane.showMessageDialog(innlogging, "Du har registrert deg!");


                    } else {
                        JOptionPane.showMessageDialog(Registrering.this, "Brukernavn eksisterer allerede!");
                    }
                }else{
                        JOptionPane.showMessageDialog(Registrering.this,"" +
                                "Brukernavnet må være minst 6 bokstav eller/og passordene må være like!");
                    }



            }
        });
        add(registrerings_knapp);

        // her skal jeg lage  en registreringsknapp som skal hjelpe med å få registrert nye brukere("kunder" bare)
        JLabel logginnmerke = new JLabel("Har du en konto? Logg inn her!");
        logginnmerke.setHorizontalAlignment(SwingConstants.CENTER);
        logginnmerke.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logginnmerke.setBackground(fargeGUIkonstanter.TEXT_COLOR);

        //Etter litt research så fant jeg ut at vi kan ikke bruke ActionListener i Jlabel,
        //men vi kan bruke MouseListener, som skal hjelpe oss å initiliasere registreringsfunksjonen
        logginnmerke.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //lukke innlogginsvindu
                Registrering.this.dispose();

                //åpne registreringsvindu
                new Innlogging().setVisible(true);
            }
        });

        logginnmerke.setBounds(125,600,245,20);
        add(logginnmerke);


    }


    private boolean validerbrukerInput(String brukernavn, String passord, String repassord){

        if(brukernavn.length()==0  || passord.length() ==0 || repassord.length()==0 ) return false;

        //legger en ekstra valgfritt funksjon, som sier minst 6 bokstaver for brukenavn
        if(brukernavn.length() < 6) return false;

        //her ønsker jeg at passordene skal være lik
        if(!passord.equals(repassord)) return false;

        //betyr at alle kravene er oppfylt
        return true;

    }

}
