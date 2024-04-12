package cw.group8;

import java.sql.*;
import java.util.ArrayList;

public class ID08App
{
    
    /**
     * Gets all the countries in the world organised by largest population to smallest.
     *
     * @return A list of all the countries in the world, or null if there is an error.
     */
    public ArrayList<country> getAllCountriesWorld(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, population FROM country ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract country information
            ArrayList<country> countries = new ArrayList<country>();
            while (rset.next())
            {
                country emp = new country();
                emp.name = rset.getString("country.name");
                emp.population = rset.getInt("country.population");
                countries.add(emp);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }
    /**
     * Prints a list of countries.
     * @param countries The list of countries to print.
     */
    public void printCountries(ArrayList<country> countries)
    {
        // Print header
        System.out.printf("All the countries in the world organised by largest population to smallest.");
        System.out.printf("%-10s %-15s%n","Name", "Population");
        // Loop over all countries in the list
        for (country emp : countries)
        {
            String emp_string =
                    String.format("%-10s %-15s",
                            emp.name, emp.population);
            System.out.println(emp_string);
        }
    }
}