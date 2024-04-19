package cw.group8;

import java.sql.ResultSet;
import java.sql.*;


/**
 *As an Organization I want to produce a report on the population
 * of a continent so that this population information is easy to access.
 */
public class ID34App {

    /**
     * Gets total population for a continent
     * @param con The connection to the database.
     * @return int value of total population for a continent, or null if there is an error.
     */
    public int getContinentPopulation(Connection con)
    {
        int ContinentPopulation=0;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Population FROM country where continent= 'South America'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract continent information
            while (rset.next())
            {
                ContinentPopulation= ContinentPopulation + rset.getInt("country.Population") ;
            }
            return ContinentPopulation;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Continent Population details");
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
            System.out.println("Failed to get continent Population details");
            return;
        }

        // Print header
        System.out.printf("Population for South America continent :");
        System.out.println(total);
    }//end printTotalPopulation

}//end ID34App