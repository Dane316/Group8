package cw.group8;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;


/**
 * As an Organization I want to produce a report on all the capital cities in a continent
 * organised by largest population to smallest so that this population information is easy to access
 */
public class ID25App {

    /**
     * Gets all the capital cities in a continent organised by largest population to smallest.
     * @param con The connection to the database.
     * @return A list of all the capital cities in a continent, or null if there is an error.
     */
    public ArrayList<city> getAllCitiesContinent(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  city.name, city.population FROM city" +
                            " INNER JOIN country on country.Capital=city.ID " +
                            "where country.Continent='North America' " +
                            "ORDER BY city.population DESC";
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
            System.out.println(e.getMessage());
            System.out.println("Failed to get Capital City details");
            return null;
        }
    }
    /**
     * Prints a list of Capital Cities in a continent.
     * @param cities The list of capital cities to print.
     */
    public void printCities(ArrayList<city> cities)
    {
        // Print header
        System.out.printf("All the Capital Cities in a continent (North America) organised by largest population to smallest.");
        System.out.printf("%-10s %-15s%n", "Capital City Name", "Population");
        // Loop over all countries in the list
        for (city city_population : cities)
        {
            String capital_cities_string =
                    String.format("%-10s %-15s",
                            city_population.name, city_population.population);
            System.out.println(capital_cities_string);
        }
    }//end printCities

}//end ID25App