package cw.group8;

import java.sql.ResultSet;
import java.sql.*;


/**
 *As an Organization I want to produce a report on the population
 * of the world so that this population information is easy to access.
 */
public class ID33App {

    /**
     * Gets total population of the world
     * @param con The connection to the database.
     * @return long value of total population for a continent, or null if there is an error.
     */
    public long getWorldPopulation(Connection con)
    {
        long WorldPopulation=0;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT SUM(Population) as world_population FROM country";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract continent information
            while (rset.next())
            {
                WorldPopulation= Long.parseLong((String.valueOf(rset.getLong(1))));
            }
            return WorldPopulation;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to World Population details");
            return 0;
        }
    }
    /**
     * Prints The total population of the World.
     * @param total The total population of the world to print.
     */
    public void printTotalPopulation(long total)
    {
        // check total if 0
        if (total == 0)
        {
            System.out.println("Failed to get World Population details");
            return;
        }

        // Print result
        System.out.println("Population of the World is : " + total);
    }//end printTotalPopulation

}//end ID33App