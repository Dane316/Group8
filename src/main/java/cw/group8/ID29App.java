package cw.group8;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ID29App
{

    /**
     * As an Organization I want to produce a report on the top N populated
     * capital cities in a region where N is provided by the user
     * so that this population information is easy to access.
     * @return A list of top N populated capital cities in a region
     * with population or null if there is an error.
     */
    public ArrayList<nonCity> getTopCapitalCityPopulation (Connection con)
    {
        ResultSet rset = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            "city.name AS country_capital, " +
                            "country.region AS country_region,"+
                            "city.population AS city_population " +
                            "FROM country " +
                            "INNER JOIN city ON country.code = city.countryCode " +
                            "WHERE country.region = 'Caribbean' " +
                            "ORDER BY city_population DESC " +
                            "LIMIT 10";

            // Prepare statement
          // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<nonCity> topCapitals = new ArrayList<nonCity>();
            while (rset.next())
            {
                nonCity topCapitalsTable = new nonCity ();
                topCapitalsTable.country_region = rset.getString("country_region");
                topCapitalsTable.country_capital = rset.getString("country_capital");
                topCapitalsTable.city_population = rset.getLong("city_population");
                topCapitals.add(topCapitalsTable);
            }
            return topCapitals;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get district details");
            return null;
        }
    }
    /**
     * Prints a list of Top N Capitals By Population.
          */
    public void printTopCapitals (ArrayList<nonCity> top)
    {
        if (top == null)
        {
            System.out.println("No Population Data Found from this Query\n");
            System.out.println("Query needs revisions");
            return;
        }
        // Print header
        System.out.println("Top 10 Populated Capitals in the Caribbean");
        System.out.printf("%-40s %-40s %-20s\n","Region Name" ,"Capital Name" ,"Population");
        // Loop over all districts in the list
        for (nonCity cf : top)
        {
            String cf_string =
                    String.format("%-40s %-40s %-20s\n",cf.country_region,cf.country_capital,cf.city_population);
            System.out.println(cf_string);
        }
    }
}