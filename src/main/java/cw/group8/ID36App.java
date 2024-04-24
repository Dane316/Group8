package cw.group8;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class ID36App
{

    /**
     * Produces a Country report on the population of a country
     * Report includes country code, name, continent, region and capital
     * @return A list of all the countries in the world
     * with country code, name, continent, region, capital, and population or null if there is an error.
     */
    public ArrayList<nonCity> getAllCountryPopulation (Connection con)
    {
        ResultSet rset = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            "country.code AS country_code, " +
                            "country.name AS country_name, " +
                            "country.continent AS continent_name, " +
                            "country.region as country_region, " +
                            "city.name as country_capital, " +
                            "country.population AS country_population " +
                            "FROM country " +
                            "INNER JOIN city ON country.Capital = city.ID " +
                            "ORDER BY country.code ASC ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<nonCity> countries = new ArrayList<nonCity>();
            while (rset.next())
            {
                nonCity countryTable = new nonCity ();
                countryTable.country_code = rset.getString("country_code");
                countryTable.country_name = rset.getString("country_name");
                countryTable.continent_name = rset.getString("continent_name");
                countryTable.country_region = rset.getString("country_region");
                countryTable.country_capital =  rset.getString("country_capital");
                countryTable.country_population = rset.getLong("country_population");
                countries.add(countryTable);
            }
            return countries;
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<nonCity> countries)
    {
        if (countries == null)
        {
            out.println("No Country/Population Found from this Query\n");
            out.println("Query needs revisions");
            return;
        }
        // Print header
        out.println("A list of all the countries in the world with country code, name, continent, region, capital, and population \n");
        out.printf("%-20s\t%-40s\t%-20s\t%-40s\t%-20s\t%-20s","Country Code", "Country Name", "Continent", "Region", "Capital","Population");
        // Loop over all countries in the list
        for (nonCity cf : countries)
        {
            String cf_string =
                    String.format("%-20s\t%-40s\t%-20s\t%-40s\t%-20s\t%-20s",
                            cf.country_code,cf.country_name,cf.continent_name,cf.country_region,cf.country_capital,cf.country_population);
            out.println(cf_string);
        }
    }
}