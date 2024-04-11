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

        // ID 08 Extract world country information
        //ArrayList<country> countries = a.getAllCountriesWorld();

        // ID 09 Extract country in a continent information
        //ArrayList<country> countries = a.getAllCountriesContinent();

        // ID 10 Extract country information in a region
        //ArrayList<country> countries = a.getAllCountriesRegion();

        // ID 11 Extract top populated country information in the world
        //ArrayList<country> countries = a.getTopCountriesWorld();

        // ID 12 Extract the top countries information in a continent
        //ArrayList<country> countries = a.getTopCountriesContinent();

        // ID 13 Extract top countries information in a region
        //ArrayList<country> countries = a.getTopCountriesRegion();

        // ID 14 Extract all cities in the world information
        //ArrayList<city> cities = a.getAllCitiesWorld();

        // ID 15 Extract city information from a continent
        //ArrayList<city> cities = a.getAllCitiesContinent();

        // ID 16 Extract city information in a region
        //ArrayList<city> cities = a.getAllCitiesRegion();

        // ID 17 Extract city information from a country
        //ArrayList<city> cities = a.getAllCitiesCountry();

        // ID 18 Extract city information in a district
        //ArrayList<city> cities = a.getAllCitiesDistrict();

        // ID 19 Extract top cities in the world information
        //ArrayList<city> cities = a.getTopCitiesWorld();

        // ID 20 Extract top cities information in a continent
        //ArrayList<city> cities = a.getTopCitiesContinent();

        // ID 21 Extract top cities information in a region
        //ArrayList<city> cities = a.getTopCitiesRegion();

        // ID 22 Extract top cities information in a country
        //ArrayList<city> cities = a.getTopCitiesCountry();

        // ID 23 Extract top cities information in a district
        ArrayList<city> cities = a.getTopCitiesDistrict();

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

    /** ID 08
     * Gets all the countries in the world organised by largest population to smallest.
     *
     * @return A list of all the countries in the world, or null if there is an error.
     */
    /* public ArrayList<country> getAllCountriesWorld()
    {
        try
        {
            // Create an SQL statement.
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
    }*/

    /** ID 09
     * Gets all the countries in North America organised by largest population to smallest.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
    /*public ArrayList<country> getAllCountriesContinent()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population FROM country WHERE Continent = 'north america' ORDER BY Population DESC";
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
    }*/

    /** ID 10
     * Gets all the countries in the Caribbean region organised by largest population to smallest.
     *
     * @return A list of all the countries in the Caribbean, or null if there is an error.
     */
    /*public ArrayList<country> getAllCountriesRegion()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, Population FROM country WHERE Region = 'caribbean' ORDER BY Population DESC";
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
    }*/

    /** ID 11
     * Gets the top 10 populated countries in the world.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
    /*public ArrayList<country> getTopCountriesWorld()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT name, Population FROM country ORDER BY Population DESC LIMIT 10";
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
    }*/

    /** ID 12
     * Gets the top 10 populated countries in the continent of Asia.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
   /* public ArrayList<country> getTopCountriesContinent()
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
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }*/

    /** ID 13
     * Gets the top 10 populated countries in the Caribbean region.
     *
     * @return A list of all the countries in the table, or null if there is an error.
     */
    /*public ArrayList<country> getTopCountriesRegion()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name, Population FROM country WHERE region = 'caribbean' ORDER BY Population DESC LIMIT 10";
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
    }*/

    /** ID 14
     * Gets all the cities in the world organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getAllCitiesWorld()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
                            "ORDER BY city.Population DESC;";
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
    }*/

    /** ID 15
     * Gets all the cities in the continent of North America organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getAllCitiesContinent()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.Continent = 'North America'\n" +
                            "ORDER BY city.Population DESC;";
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
    }*/

    /** ID 16
     * Gets all the cities in the Caribbean region organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getAllCitiesRegion()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.Region = 'Caribbean'\n" +
                            "ORDER BY city.Population DESC;";
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
    }*/

    /** ID 17
     * Gets all the cities in the country of Afghanistan organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getAllCitiesCountry()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "WHERE city.CountryCode = 'AFG'\n" +
                            "ORDER BY city.Population DESC;";
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
    }*/

    /** ID 18
     * Gets all the cities in the district of Noord-Brabant organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getAllCitiesDistrict()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "WHERE city.District = 'Noord-Brabant'\n" +
                            "ORDER BY city.Population DESC;";
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
    }*/

    /** ID 19
     * Gets the top 10 populated cities in the world organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
   /* public ArrayList<city> getTopCitiesWorld()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
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
    }*/

    /** ID 20
     * Gets the top 10 populated cities in a continent organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getTopCitiesContinent()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.Continent = 'north america'\n" +
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
    }*/

    /** ID 21
     * Gets the top 10 populated cities in a region organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getTopCitiesRegion()
    {
        try
        {
            // Create an SQL statement.
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "INNER JOIN country ON city.CountryCode = country.Code\n" +
                            "WHERE country.region = 'western europe'\n" +
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
    }*/

    /** ID 22
     * Gets the top 10 populated cities in a country organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    /*public ArrayList<city> getTopCitiesCountry()
    {
        try
        {
            // Create an SQL statement.
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
    }*/

    /** ID 23
     * Gets the top 10 populated cities in a district organised by largest population to smallest.
     *
     * @return A list of all the cites in the table, or null if there is an error.
     */
    public ArrayList<city> getTopCitiesDistrict()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.Name, city.Population\n" +
                            "FROM city\n" +
                            "WHERE city.District = 'texas'\n" +
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
        System.out.printf("The top 10 populated cities in the district of Texas by largest population to smallest.\n");
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
