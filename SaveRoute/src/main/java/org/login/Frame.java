package org.login;

import javax.swing.*;

public class Frame extends JFrame {
    //lager konstruktor for å lage GUIen
    public Frame(String title){
        // gir navn til tittelen med tanke på logg inn
        super(title);

        //setter størrelsen Guien skal ha
        setSize(500,700);

        //setter en exit for å avslutte programmet når handlingen er utført
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setter layout på null, slik bestemmer jeg hvordan GUIen skal se ut
        //med tanke på komponent plasering
        setLayout(null);

        // ved å setter locationrelativeto lik null vil GUIen komme opp i midten av skjermen
        setLocationRelativeTo(null);

        //Vi ønsker at GUIen vår skal endre størrelse, defro setter vi resizable false
        setResizable(false);

        //velger å bytte bakgrunnsfargen i GUIen
        getContentPane().setBackground(fargeGUIkonstanter.PRIMARY_COLOR);


    }


}
