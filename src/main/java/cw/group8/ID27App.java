package cw.group8;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;

import static java.lang.System.*;


/**
 * As an Organization I want to produce a report on the top N populated capital cities in the world
 * where N is provided by the user so that this population information is easy to access
 */
public class ID27App {

    /**
     * Gets Top N populated capital cities in the world
     * @param con The connection to the database.
     * @return A list of top N populated capital cities in the world, or null if there is an error.
     */
    public ArrayList<city> getAllCities(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.name, city.population FROM city" +
                            " INNER JOIN country on country.Capital=city.ID " +
                            "ORDER BY city.population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city city_population = new city();
                city_population.name = rset.getString("city.name");
                city_population.population = rset.getInt("city.population");
                cities.add(city_population);
            }
            return cities;
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get Capital City details");
            return null;
        }
    }
    /**
     * Prints a list of Top N Populated Capital Cities in the world.
     * @param cities The list of capital cities to print.
     */
    public void printCities(ArrayList<city> cities)
    {
        // check cities array is not null
        if (cities == null)
        {
            out.println("No Capital Cities Found");
            return;
        }

        // Print header
        out.printf("Top N (10) Populated Capital Cities in the world");
        out.printf("%-10s %-15s%n", "Capital City Name", "Population");
        // Loop over all countries in the list
        for (city city_population : cities)
        {
            String capital_cities_string =
                    String.format("%-10s %-15s",
                            city_population.name, city_population.population);
            out.println(capital_cities_string);
        }
    }//end printCities

}//end ID26App