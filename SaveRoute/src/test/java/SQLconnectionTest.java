import org.h2.engine.User;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.login.SQLconnection;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class SQLconnectionTest {

    @Test
    public void sjekk_brukernavn() throws Exception {


        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;")) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE bruker(brukernavn VARCHAR(50))");
                statement.execute("INSERT INTO bruker VALUES ('Ola')");
            }

            assertTrue(SQLconnection.sjekkbruker("Ola"));
            assertFalse(SQLconnection.sjekkbruker("Kari"));


        }
    }

    @Test
    public void registrer() throws Exception{

        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;")) {
                Statement statement = connection.createStatement();
                statement.execute("CREATE TABLE Bruker(brukernavn VARCHAR(50),passord VARCHAR(10))");

                //assertFalse eller True var litt forvirende med tanke på at man må huske når koden kjøres
                // det som var assertTrue true før koden kjører, kommer til å være false hvis man
                assertFalse(SQLconnection.registrer("Ola","1234"),"SOMething wrong");
                assertFalse(SQLconnection.registrer("Kimi","1234"),"Passed");
        }

    }

    @Test
    public void bekrefte_innlogging() throws Exception{
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test;")) {
            Statement statement = connection.createStatement();

            //dette er en fin måte å bruke brukernavet og passordet fra metoden register
            //for å faktisk sjekke om brukeren finnes i "databasen"
            //hvis man vil teste det det er bare å opprette en ny bruker og bytte til assertfalse under
            //i metode f.eks:assertFalse(SQLconnection.bekrefteInnlogging("Kimi","1234"));

            assertTrue(SQLconnection.bekrefteInnlogging("Kimi","1234"));
        }
    }
}



