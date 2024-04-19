package cw.group8;

import java.sql.ResultSet;
import java.sql.*;


/**
 *As an Organization I want to produce a report on the population
 * of the world so that this population information is easy to access.
 */
public class ID33App {

    /**
     * Gets total population for a continent
     * @param con The connection to the database.
     * @return int value of total population of the world, or null if there is an error.
     */
    public int getWorldPopulation(Connection con)
    {
        int WorldPopulation=0;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Population FROM country" +"sum(country.population),";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract continent information
            while (rset.next())
            {
                WorldPopulation= WorldPopulation + rset.getInt("country.Population") ;
            }
            return WorldPopulation;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get World Population details");
            return 0;
        }
    }
    /**
     * Prints The total population of the continent.
     * @param total The total population of the continent to print.
     */
    public void printTotalPopulation(int total)
    {
        // check total if 0
        if (total == 0)
        {
            System.out.println("Failed to get world Population details");
            return;
        }

        // Print header
        System.out.printf("Population for the World :");
        System.out.println(total);
    }//end printTotalPopulation

}//end ID33App