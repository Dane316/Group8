package cw.group8;

import java.sql.*;

public class App
{
    static private Connection con = null;

    public static void main(String[] args)
    {

        App a = new App();

        if (args.length < 1) {
            a.connect("localhost:33060", 10000);
        } else {
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        // Please comment out each issue once working properly

        //ID08 Get all countries population in the world
        /*
             ID08App ID08 = new ID08App();
             ID08.printCities(ID08.getAllCountriesWorld(con));
         */

        //ID09 Get all countries population in a continent
        /*
         ID09App ID09 = new ID09App();
         ID09.printCities(ID09.getAllCountriesContinent(con));
         */
        
        //ID10 Get all countries population in a region
        /*
         ID10App ID10 = new ID10App();
         ID10.printCities(ID10.getAllCountriesRegion(con));
         */
        
        //ID11 Get top countries population in the world
        /*
         ID11App ID11 = new ID11App();
         ID11.printCities(ID11.getTopCountriesWorld(con));
         */
        
        //ID12 Get top countries population in a continent
        /*
         ID12App ID12 = new ID12App();
         ID12.printCities(ID12.getTopCountriesContinent(con));
         */
        
        //ID13 Get top countries population in a region
        /*
         ID13App ID13 = new ID13App();
         ID13.printCities(ID13.getTopCountriesRegion(con));
         */
        
        //ID14 Get all city population in the world
        /*
         ID14App ID14 = new ID14App();
         ID14.printCities(ID14.getAllCitiesWorld(con));
         */
        
        //ID15 Get all city population in a continent
        /*
         ID15App ID15 = new ID15App();
         ID15.printCities(ID15.getAllCitiesContinent(con));
         */
        
        //ID16 Get all city population in a region
        /*
         ID16App ID16 = new ID16App();
         ID16.printCities(ID16.getAllCitiesRegion(con));
         */
        
        //ID17 Get all city population in a country
        /*
         ID17App ID17 = new ID17App();
         ID17.printCities(ID17.getAllCitiesCountry(con));
         */
        
        //ID18 Get all city population in a district
        /*
         ID18App ID18 = new ID18App();
         ID18.printCities(ID18.getAllCitiesDistrict(con));
         */
        
        //ID19 Get top city population in the world
        /*
         ID19App ID19 = new ID19App();
         ID19.printCities(ID19.getTopCitiesWorld(con));
         */

        //ID20 Get top city population in a continent
        /*
            ID20App ID20 = new ID20App();
            ID20.printCities(ID20.getTopCitiesContinent(con));
         */

        //ID21 Get top city population in a region
        /*
            ID21App ID21 = new ID21App();
            ID21.printCities(ID21.getTopCitiesRegion(con));
         */

        //ID22 Get top city population in a country
        /*
            ID22App ID22 = new ID22App();
            ID22.printCities(ID22.getTopCitiesCountry(con));
         */

        // ID23 Get top city population in a district
         /*
              ID23App ID23 = new ID23App();
              ID23.printCities(ID23.getTopCitiesDistrict(con));
          */

         // ID24 Get population of all capital cities in the world
        /*

            ID24App ID24 = new ID24App();
            ID24.printCities(ID24.getAllCities(con));
         */

        // ID25 Get population for all capital cities in a Continent
        /*
            ID25App ID25 = new ID25App();
            ID25.printCities(ID25.getAllCitiesContinent(con));
         */

        // ID26 Get population for all capital cities in a region
        /*
            ID26App ID26 = new ID26App();
            ID26.printCities(ID26.getAllCitiesRegion(con));
        */

        // ID27 Get Top N populated capital cities in the world
        /*
            ID27App ID27 = new ID27App();
            ID27.printCities(ID27.getAllCities(con));
        */

        // ID34 Get Population for a Region

        ID34App ID34 = new ID34App();
        ID34.printTotalPopulation(ID34.getContinentPopulation(con));

        // ID35 Get Population for a Region
        /*
        ID35App ID35 = new ID35App();
        ID35.printTotalPopulation(ID35.getRegionPopulation(con));
         */






        a.disconnect(); //call database disconnect function

    }//end main


    public void connect(String location, int delay)
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
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Attempting to connect to database...");
            try
            {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
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

}