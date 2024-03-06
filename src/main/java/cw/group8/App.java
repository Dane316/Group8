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

        // Extract country information
        ArrayList<country> countries = a.getAllcountries();

        // Print the countries in the table
        a.printCountries(countries);

        // Test the size of the returned data - should be 240124
        //System.out.println(countries.size());

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
    /**
     * Gets the top 10 populated countries in Asia.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
    public ArrayList<country> getAllcountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Code, Name, Population FROM country WHERE Continent = 'asia' ORDER BY Population DESC LIMIT 10";
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
        System.out.printf("The top 10 populated countries in Asia.\n");
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
    /*public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract country information
        ArrayList<country> countries = a.getAllcountries();

        // Print the countries in the table
        a.printCountries(countries);

        // Test the size of the returned data - should be 240124
        //System.out.println(countries.size());

        // Disconnect from database
        a.disconnect();
    }*/
}