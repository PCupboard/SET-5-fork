package org.login;

import java.awt.*;

public class fargeGUIkonstanter {

    public static final Color PRIMARY_COLOR = Color.decode("#AFEEEE");
    //Secondary color kan brukes til brukkernavn og passord taste merkene eller logg inn knappen
    public static final Color SECONDARY_COLOR = Color.decode("#00B496");
    public static final Color TEXT_COLOR = Color.decode("000000");

    //mysql adresse, brukernav og passord fra workbench
    public static final String DB_adresse = "jdbc:mysql://127.0.0.1:3306/innlogging";
    //public static final String DB_ID = "idBruker";
    public static final String DB_brukernavn = "gruppe25";
    public static final String DB_passord = "softeng25";//her må jeg bruke innloggings passord for MySQL workbench
    public static final String DB_Rolle = "Kunde";
    public static final String DB_table_name="bruker";


}
