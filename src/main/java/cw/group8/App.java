package cw.group8;

import java.sql.*;

import static java.lang.System.*;

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


        //ID08 Get all countries population in the world
        ID08App ID08 = new ID08App();
        ID08.printCountries(ID08.getAllCountriesWorld(con));


        //ID09 Get all countries population in a continent
         ID09App ID09 = new ID09App();
         ID09.printCountries(ID09.getAllCountriesContinent(con));

        
        //ID10 Get all countries population in a region
         ID10App ID10 = new ID10App();
         ID10.printCountries(ID10.getAllCountriesRegion(con));

        
        //ID11 Get top countries population in the world
         ID11App ID11 = new ID11App();
         ID11.printCountries(ID11.getTopCountriesWorld(con));

        
        //ID12 Get top countries population in a continent
         ID12App ID12 = new ID12App();
         ID12.printCountries(ID12.getTopCountriesContinent(con));

        
        //ID13 Get top countries population in a region
         ID13App ID13 = new ID13App();
         ID13.printCountries(ID13.getTopCountriesRegion(con));

        
        //ID14 Get all city population in the world
         ID14App ID14 = new ID14App();
         ID14.printCities(ID14.getAllCitiesWorld(con));

        
        //ID15 Get all city population in a continent
         ID15App ID15 = new ID15App();
         ID15.printCities(ID15.getAllCitiesContinent(con));

        
        //ID16 Get all city population in a region
         ID16App ID16 = new ID16App();
         ID16.printCities(ID16.getAllCitiesRegion(con));

        
        //ID17 Get all city population in a country
         ID17App ID17 = new ID17App();
         ID17.printCities(ID17.getAllCitiesCountry(con));

        
        //ID18 Get all city population in a district
         ID18App ID18 = new ID18App();
         ID18.printCities(ID18.getAllCitiesDistrict(con));

        
        //ID19 Get top city population in the world
         ID19App ID19 = new ID19App();
         ID19.printCities(ID19.getTopCitiesWorld(con));


        //ID20 Get top city population in a continent
        ID20App ID20 = new ID20App();
        ID20.printCities(ID20.getTopCitiesContinent(con));


        //ID21 Get top city population in a region
        ID21App ID21 = new ID21App();
        ID21.printCities(ID21.getTopCitiesRegion(con));


        //ID22 Get top city population in a country
        ID22App ID22 = new ID22App();
        ID22.printCities(ID22.getTopCitiesCountry(con));


        // ID23 Get top city population in a district
        ID23App ID23 = new ID23App();
        ID23.printCities(ID23.getTopCitiesDistrict(con));


        // ID24 Get population of all capital cities in the world
        ID24App ID24 = new ID24App();
        ID24.printCities(ID24.getAllCities(con));


        // ID25 Get population for all capital cities in a Continent
        ID25App ID25 = new ID25App();
        ID25.printCities(ID25.getAllCitiesContinent(con));


        // ID26 Get population for all capital cities in a region
        ID26App ID26 = new ID26App();
        ID26.printCities(ID26.getAllCitiesRegion(con));

        // ID27 Get Top N populated capital cities in the world
        ID27App ID27 = new ID27App();
        ID27.printCities(ID27.getAllCities(con));

        //ID28App Returns a list of Top Population by City Capitals in a Continent
        ID28App ID28 = new ID28App();
        ID28.printTopCapitals (ID28.getTopCapitalCityPopulation(con));

        //ID29App Returns a list of Top Population by City Capitals in a Region
        ID29App ID29 = new ID29App();
        ID29.printTopCapitals (ID29.getTopCapitalCityPopulation(con));

        // ID30 Get City and Non-City Population by Continent
       ID30App ID30 = new ID30App();
       ID30.printPopulation(ID30.getContinentPopulation(con));

       // ID31 Get City and Non-City Population for a Region
       ID31App ID31 = new ID31App();
       ID31.printPopulation(ID31.getCityPopulation(con));

       // ID32 Get City and Non-City Population for a Region
       ID32App ID32 = new ID32App();
       ID32.printPopulation(ID32.getCountryPopulation(con));


       // ID33App Get World Population
       ID33App ID33 = new ID33App();
       ID33.printTotalPopulation(ID33.getWorldPopulation(con));


       //ID34 Get Population for a Continent
        ID34App ID34 = new ID34App();
        ID34.printTotalPopulation(ID34.getContinentPopulation(con));

        //ID35 Get Population for a Region
        ID35App ID35 = new ID35App();
        ID35.printTotalPopulation(ID35.getRegionPopulation(con));

        //ID36App Returns a list of all the countries in the world
        // with country code, name, continent, region, capital, and population
         ID36App ID36 = new ID36App();
         ID36.printCountries(ID36.getAllCountryPopulation(con));


        //ID37App Returns a list of all the districts and population
        ID37App ID37 = new ID37App();
        ID37.printDistricts(ID37.getAllDistrictPopulation(con));


        //ID38App Returns a list of all the countries in the world with city,district,and population
        ID38App ID38 = new ID38App();
        ID38.printCities(ID38.getAllCityPopulation(con));



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
            out.println("Could not load SQL driver");
            exit(-1);
        }

        int retries = 10;
        boolean shouldWait = false;
        for (int i = 0; i < retries; ++i)
        {
            out.println("Attempting to connect to database...");
            try
            {
                if (shouldWait) {
                    // Wait a bit for db to start
                    Thread.sleep(delay);
                }
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://"+location+"/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
                out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                out.println("Failed to connect to database attempt " + Integer.toString(i));
                out.println(sqle.getMessage());

                // Let's wait before attempting to reconnect
                shouldWait = true;
            }
            catch (InterruptedException ie)
            {
                out.println("Thread interrupted? Should not happen.");
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
                out.println("Error closing connection to database");
            }
        }
    }

}