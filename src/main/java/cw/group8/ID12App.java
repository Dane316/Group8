package cw.group8;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class ID12App
{    
    /**
     * Gets the top 10 populated countries in the continent of Asia.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
    public ArrayList<country> getTopCountriesContinent(Connection con)
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population FROM country WHERE Continent = 'asia' ORDER BY Population DESC LIMIT 10";
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
            out.println(e.getMessage());
            out.println("Failed to get country details");
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
        out.printf("The top 10 populated countries in Asia.\n");
        out.printf("%-10s %-15s%n","Name", "Population");
        // Loop over all countries in the list
        for (country emp : countries)
        {
            String emp_string =
                    String.format("%-10s %-15s",
                            emp.name, emp.population);
            out.println(emp_string);
        }
    }
}
