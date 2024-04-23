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
    public ArrayList<city> getAllCityPopulation (Connection con)
    {
        ResultSet rset = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            "city.name AS city_name, " +
                            "city.countryName AS country_name, " +
                            "city.district AS district_name, " +
                            "city.population AS city_population " +
                            "FROM city " +
                            "INNER JOIN country ON country.countryCode = city.code " +
                            "ORDER BY city_name ASC ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city cityTable = new city ();
                cityTable.countryName = rset.getString("country_name");
                cityTable.name = rset.getString("city_name");
                cityTable.district = rset.getString("district_name");
                cityTable.population = rset.getInt("city_population");
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
    public void printCities(ArrayList<city> cities)
    {
        if (cities == null)
        {
            System.out.println("No City/Population Found from this Query\n");
            System.out.println("Query needs revisions");
            return;
        }
        // Print header
        System.out.println("A list of all cities with country,district,and population \n");
        System.out.printf("%-20s\t%-40s\t%-40s\t%-20s", "City Name", "Country Name", "District", "Population");
        // Loop over all countries in the list
        for (city cf : cities)
        {
            String cf_string =
                    String.format("%-20s\t%-40s\t%-40s\t%-20s","cf.name,cf.countryName,cf.district,cf.population");
            System.out.println(cf_string);
        }
    }
}