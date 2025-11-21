package org.login;

import javax.xml.transform.Result;
import java.sql.*;

// i denne klassen skal vi koble databsen vi har laget sammen med Innloggintjenesten vår
public class SQLconnection {
    //registrer ny bruker
    //true-bruker registrert
    //false-bruker ikke registrert

    public static boolean registrer (String brukernavn, String passord){
        //sjekke om brukeren allerede eksisterer
        try{
            if(!sjekkbruker(brukernavn)){
                //kobler  databasen
                Connection connection = DriverManager.getConnection(fargeGUIkonstanter.DB_adresse,fargeGUIkonstanter.DB_brukernavn,
                        fargeGUIkonstanter.DB_passord);

                //lager en spørring for å legge brukernavn og passord i databasen
                PreparedStatement insertuser = connection.prepareStatement(
                        "INSERT INTO "+ fargeGUIkonstanter.DB_table_name + "(brukernavn,passord,rolle)"+
                                "VALUES (?,?,?)"
                );

                //leger parameterne inni spørringen
                insertuser.setString(1,brukernavn);
                insertuser.setString(2,passord);
                insertuser.setString(3,fargeGUIkonstanter.DB_Rolle);

                //oppdaterer databasen med ny bruker
                insertuser.executeUpdate();
                return true;

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;

    }

    public static boolean sjekkbruker(String brukernavn){

        try {
            Connection connection = DriverManager.getConnection(fargeGUIkonstanter.DB_adresse,fargeGUIkonstanter.DB_brukernavn,
                    fargeGUIkonstanter.DB_passord);

            PreparedStatement sjekkbrukerExists = connection.prepareStatement(
                    "SELECT * FROM "+fargeGUIkonstanter.DB_table_name +
                    " WHERE BRUKERNAVN = ?");

            sjekkbrukerExists.setString(1, brukernavn);

            ResultSet resultSet = sjekkbrukerExists.executeQuery();

            //lager en if test for  å sjekke om brukeren eksisterer
            if(!resultSet.isBeforeFirst()){
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;

    }
    //bekrefte opplysningene med databasen ved innlogging, sjekker om passord/brukernavn eksisterer
    public static boolean bekrefteInnlogging(String brukernavn, String passord){

        try{
            Connection connection = DriverManager.getConnection(fargeGUIkonstanter.DB_adresse,fargeGUIkonstanter.DB_brukernavn,
                    fargeGUIkonstanter.DB_passord);

            //lager en SELECT spørringer
            PreparedStatement validerBruker = connection.prepareStatement(
                    "SELECT * FROM " +fargeGUIkonstanter.DB_table_name +
                            " WHERE BRUKERNAVN = ? AND PASSORD = ?"
            );

            validerBruker.setString(1,brukernavn);
            validerBruker.setString(2,passord);

            ResultSet resultSet = validerBruker.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }



        }catch(SQLException e){
            e.printStackTrace();

        }

        return true;



    }

}
