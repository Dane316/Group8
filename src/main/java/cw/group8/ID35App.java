package cw.group8;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;


/**
 * As an Organization I want to produce a report on the population of a region
 * so that this population information is easy to access.
 */
public class ID35App {

    /**
     * Gets total population for a region
     * @param con The connection to the database.
     * @return int value of total population for a region, or 0 if there is an error.
     */
    public int getRegionPopulation(Connection con)
    {
        int RegionPopulation=0;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Population FROM country where Region= 'Caribbean'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract region information
            while (rset.next())
            {
                RegionPopulation= RegionPopulation + rset.getInt("country.Population") ;
            }
            return RegionPopulation;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Region Population details");
            return 0;
        }
    }
    /**
     * Prints The total population of the region.
     * @param total The total population of the region to print.
     */
    public void printTotalPopulation(int total)
    {
        // check total if 0
        if (total == 0)
        {
            System.out.println("Failed to get Region Population details");
            return;
        }

        // Print header
        System.out.printf("Population for Caribbean Region :");
        System.out.println(total);
    }//end printTotalPopulation

}//end ID35App