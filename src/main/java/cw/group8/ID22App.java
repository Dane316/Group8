package cw.group8;

import java.sql.*;
import java.util.ArrayList;

public class ID22App
{
    /** ID 22
     * Gets the top 10 populated cities in a country organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    public ArrayList<city> getTopCitiesCountry(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                    "FROM city\n" +
                    "WHERE city.CountryCode = 'usa'\n" +
                    "ORDER BY city.Population DESC\n" +
                    "LIMIT 10;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<city> cities = new ArrayList<city>();
            while (rset.next())
            {
                city emp = new city();
                emp.name = rset.getString("city.name");
                emp.population = rset.getInt("city.population");
                cities.add(emp);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */
    public void printCities(ArrayList<city> cities)
    {
        // Print header
        System.out.printf("The top 10 populated cities in the country of North America by largest population to smallest.\n");
        System.out.printf("%-10s %-15s%n","Name", "Population");
        // Loop over all cities in the list
        for (city emp : cities)
        {
            String emp_string =
                    String.format("%-10s %-15s",
                            emp.name, emp.population);
            System.out.println(emp_string);
        }
    }
}