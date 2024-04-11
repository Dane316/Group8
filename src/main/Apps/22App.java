package cw.group8;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // ID 22 Extract top cities information in a country
        ArrayList<city> cities = a.getTopCitiesCountry();

        // Print the cities in the table
        a.printCities(cities);

        // Test the size of the returned data - should be 240124
        //System.out.println(cities.size());

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Attempting to connect to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    /** ID 22
     * Gets the top 10 populated cities in a country organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    public ArrayList<city> getTopCitiesCountry()
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
