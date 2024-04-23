package cw.group8;

import java.sql.*;
import java.util.ArrayList;

public class ID38App
{

    /**
     * As an Organization I want to produce a report on the population of a city to include
     * city name, country and district so that this population information is easy to access.
     * @return A list of all the cities in the world
     * with city name, country, district, and population or null if there is an error.
     */
    public ArrayList<nonCity> getAllCityPopulation (Connection con)
    {
        ResultSet rset = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            "country.name AS country_name, " +
                            "city.name AS city_name, " +
                            "city.district AS district_name, " +
                            "city.population AS city_population " +
                            "FROM city " +
                            "INNER JOIN country ON city.countryCode = country.code " +
                            "ORDER BY country_name ASC ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<nonCity> cities = new ArrayList< >();
            while (rset.next())
            {
                nonCity cityTable = new nonCity ();
                cityTable.country_name = rset.getString("country_name");
                cityTable.city_name = rset.getString("city_name");
                cityTable.district_name = rset.getString("district_name");
                cityTable.city_population = rset.getLong("city_population");
                cities.add(cityTable);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */
    public void printCities(ArrayList<nonCity> cities)
    {
        if (cities == null)
        {
            System.out.println("No City/Population Found from this Query\n");
            System.out.println("Query needs revisions");
            return;
        }
        // Print header
        System.out.println("A list of all countries with cities,district,and population \n");
        System.out.printf("%-20s\t%-40s\t%-40s\t%-20s","Country Name","City Name","District","Population\n");
        // Loop over all countries in the list
        for (nonCity cf : cities)
        {
            String cf_string =
                    String.format("%-20s\t%-40s\t%-40s\t%-20s",cf.country_name,cf.city_name,cf.district_name,cf.city_population);
            System.out.println(cf_string);
        }
    }
}