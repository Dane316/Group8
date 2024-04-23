package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.lang.System.*;
import static org.junit.jupiter.api.Assertions.*;


public class AppIntegrationTest
{
    static private Connection con = null;
    static ID08App app08;
    static ID09App app09;
    static ID10App app10;
    static ID11App app11;
    static ID12App app12;
    static ID13App app13;
    static ID14App app14;
    static ID15App app15;
    static ID16App app16;
    static ID17App app17;
    static ID18App app18;
    static ID19App app19;
    static ID20App app20;
    static ID21App app21;
    static ID22App app22;
    static ID23App app23;
    static ID24App app24;
    static ID25App app25;
    static ID26App app26;
    static ID27App app27;
    //static ID28App app28;
    //static ID29App app29;
    static ID30App app30;
    static ID31App app31;
    static ID32App app32;
    static ID33App app33;
    static ID34App app34;
    static ID35App app035;
    //static ID36App app036;
    //static ID37App app037;
    //static ID38App app038;
    static ID39App app039;

    @BeforeAll
    static void init()
    {
        AppIntegrationTest a = new AppIntegrationTest();
        a.connect("localhost:33060", 30000);
    }

    @Test
    void TestGetAllCountriesWorld()
    {
        app08 = new ID08App();
        ArrayList<country> CountriesWorld= new ArrayList<country>();
        CountriesWorld=app08.getAllCountriesWorld(con);

        for (country IT : CountriesWorld)
        {
            assertEquals(IT.name, "China");
            assertEquals(IT.population, 1277558000);
            break;
        }

    }//end TestGetAllCountriesWorld

    @Test
    void TestgetAllCountriesContinent()
    {
        app09 = new ID09App();
        ArrayList<country> CountriesContinent = new ArrayList<country>();
        CountriesContinent =app09.getAllCountriesContinent(con);

        for (country IT : CountriesContinent)
        {
            assertEquals(IT.name, "United States");
            assertEquals(IT.population, 278357000);
            break;
        }
    }//end TestgetAllCountriesContinent

    @Test
    void TestgetAllCountriesRegion()
    {
        app10 = new ID10App();
        ArrayList<country> CountriesRegion = new ArrayList<country>();
        CountriesRegion=app10.getAllCountriesRegion(con);

        for (country IT : CountriesRegion)
        {
            assertEquals(IT.name,"Cuba");
            assertEquals(IT.population, 11201000);
            break;
        }
    }//end TestgetAllCountriesRegion

    @Test
    void TestgetTopCountriesWorld()
    {
        app11 = new ID11App();
        ArrayList<country> getTopCountriesWorld = new ArrayList<country>();
        getTopCountriesWorld=app11.getTopCountriesWorld(con);

        for (country IT : getTopCountriesWorld)
        {
            assertEquals(IT.name,"China");
            assertEquals(IT.population, 1277558000);
            break;
        }
    }//end TestgetTopCountriesWorld

    @Test
    void TestgetTopCountriesContinent()
    {
        app12 = new ID12App();
        ArrayList<country> getTopCountriesContinent = new ArrayList<country>();
        getTopCountriesContinent=app12.getTopCountriesContinent(con);

        for (country IT : getTopCountriesContinent)
        {
            assertEquals(IT.name,"China");
            assertEquals(IT.population, 1277558000);
            break;
        }
    }//end TestgetTopCountriesContinent

    @Test
    void TestgetTopCountriesRegion()
    {
        app13 = new ID13App();
        ArrayList<country> getTopCountriesRegion = new ArrayList<country>();
        getTopCountriesRegion=app13.getTopCountriesRegion(con);

        for (country IT : getTopCountriesRegion)
        {
            assertEquals(IT.name,"Cuba");
            assertEquals(IT.population, 11201000);
            break;
        }
    }//end TestgetTopCountriesRegion

    @Test
    void TestgetAllCitiesWorld()
    {
        app14 = new ID14App();
        ArrayList<city> getAllCitiesWorld = new ArrayList<city>();
        getAllCitiesWorld=app14.getAllCitiesWorld(con);

        for (city IT : getAllCitiesWorld)
        {
            assertEquals(IT.name,"Mumbai (Bombay)");
            assertEquals(IT.population, 10500000);
            break;
        }
    }//end TestgetAllCitiesWorld

    @Test
    void TestgetAllCitiesContinentNorthAmerica()
    {
        app15 = new ID15App();
        ArrayList<city> getAllCitiesContinent = new ArrayList<city>();
        getAllCitiesContinent=app15.getAllCitiesContinent(con);

        for (city IT : getAllCitiesContinent)
        {
            assertEquals(IT.name,"Ciudad de México");
            assertEquals(IT.population, 8591309);
            break;
        }
    }//end TestgetAllCitiesContinentNorthAmerica


    @Test
    void TestgetAllCitiesRegionCaribbean()
    {
        app16 = new ID16App();
        ArrayList<city> getAllCitiesRegion = new ArrayList<city>();
        getAllCitiesRegion=app16.getAllCitiesRegion(con);

        for (city IT : getAllCitiesRegion)
        {
            assertEquals(IT.name,"La Habana");
            assertEquals(IT.population, 2256000);
            break;
        }
    }//end TestgetAllCitiesRegionCaribbean


    @Test
    void TestgetAllCitiesCountry()
    {
        app17 = new ID17App();
        ArrayList<city> getAllCitiesCountry = new ArrayList<city>();
        getAllCitiesCountry=app17.getAllCitiesCountry(con);

        for (city IT : getAllCitiesCountry)
        {
            assertEquals(IT.name,"Kabul");
            assertEquals(IT.population, 1780000);
            break;
        }
    }//end TestgetAllCitiesCountry


    @Test
    void TestgetAllCitiesDistrict()
    {
        app18 = new ID18App();
        ArrayList<city> getAllCitiesDistrict = new ArrayList<city>();
        getAllCitiesDistrict=app18.getAllCitiesDistrict(con);

        for (city IT : getAllCitiesDistrict)
        {
            assertEquals(IT.name,"Eindhoven");
            assertEquals(IT.population, 201843);
            break;
        }
    }//end TestgetAllCitiesDistrict


    @Test
    void TestgetTopCitiesWorld()
    {
        app19 = new ID19App();
        ArrayList<city> getTopCitiesWorld = new ArrayList<city>();
        getTopCitiesWorld=app19.getTopCitiesWorld(con);

        for (city IT : getTopCitiesWorld)
        {
            assertEquals(IT.name,"Mumbai (Bombay)");
            assertEquals(IT.population, 10500000);
            break;
        }
    }//end TestgetTopCitiesWorld


    @Test
    void TestgetTopCitiesContinent()
    {
        app20 = new ID20App();
        ArrayList<city> getTopCitiesContinent = new ArrayList<city>();
        getTopCitiesContinent=app20.getTopCitiesContinent(con);

        for (city IT : getTopCitiesContinent)
        {
            assertEquals(IT.name,"Ciudad de México");
            assertEquals(IT.population, 8591309);
            break;
        }
    }//end TestgetTopCitiesContinent


    @Test
    void TestgetTopCitiesRegion()
    {
        app21 = new ID21App();
        ArrayList<city> getTopCitiesRegion = new ArrayList<city>();
        getTopCitiesRegion=app21.getTopCitiesRegion(con);

        for (city IT : getTopCitiesRegion)
        {
            assertEquals(IT.name,"Berlin");
            assertEquals(IT.population, 3386667);
            break;
        }
    }//end TestgetTopCitiesRegion


    @Test
    void TestgetTopCitiesCountry()
    {
        app22 = new ID22App();
        ArrayList<city> getTopCitiesCountry = new ArrayList<city>();
        getTopCitiesCountry=app22.getTopCitiesCountry(con);

        for (city IT : getTopCitiesCountry)
        {
            assertEquals(IT.name,"New York");
            assertEquals(IT.population, 8008278);
            break;
        }
    }//end TestgetTopCitiesCountry


    @Test
    void TestgetTopCitiesDistrict()
    {
        app23 = new ID23App();
        ArrayList<city> getTopCitiesDistrict = new ArrayList<city>();
        getTopCitiesDistrict=app23.getTopCitiesDistrict(con);

        for (city IT : getTopCitiesDistrict)
        {
            assertEquals(IT.name,"Houston");
            assertEquals(IT.population, 1953631);
            break;
        }
    }//end TestgetTopCitiesDistrict


    @Test
    void TestgetAllCities()
    {
        app24 = new ID24App();
        ArrayList<city> getAllCities = new ArrayList<city>();
        getAllCities=app24.getAllCities(con);

        for (city IT : getAllCities)
        {
            assertEquals(IT.name,"Seoul");
            assertEquals(IT.population, 9981619);
            break;
        }
    }//end TestgetAllCities


    @Test
    void TestgetAllCitiesContinent()
    {
        app25 = new ID25App();
        ArrayList<city> getAllCitiesContinent = new ArrayList<city>();
        getAllCitiesContinent=app25.getAllCitiesContinent(con);

        for (city IT : getAllCitiesContinent)
        {
            assertEquals(IT.name,"Ciudad de México");
            assertEquals(IT.population, 8591309);
            break;
        }
    }//end TestgetAllCitiesContinent


    @Test
    void TestgetAllCitiesRegion()
    {
        app26 = new ID26App();
        ArrayList<city> getAllCitiesRegion = new ArrayList<city>();
        getAllCitiesRegion=app26.getAllCitiesRegion(con);

        for (city IT : getAllCitiesRegion)
        {
            assertEquals(IT.name,"La Habana");
            assertEquals(IT.population, 2256000);
            break;
        }
    }//end TestgetAllCitiesRegion


    @Test
    void TestgetTopNAllCities()
    {
        app27 = new ID27App();
        ArrayList<city> getAllCities = new ArrayList<city>();
        getAllCities=app27.getAllCities(con);

        for (city IT : getAllCities)
        {
            assertEquals(IT.name,"Seoul");
            assertEquals(IT.population, 9981619);
            break;
        }
    }//end TestgetTopNAllCities


    @Test
    void TestgetContinentPopulation()
    {
        app30 = new ID30App();
        ArrayList<nonCity> getContinentPopulation = new ArrayList<nonCity>();
        getContinentPopulation=app30.getContinentPopulation(con);

        for (nonCity IT : getContinentPopulation)
        {
            assertEquals(IT.continent_name,"Asia");
            assertEquals(IT.city_population, 697604103);
            assertEquals(IT.non_city_population, 900239995297l);
            break;
        }
    }//end TestgetContinentPopulation


    /*
    @Test
    void TestgetCityPopulation()
    {
        app31 = new ID31App();
        ArrayList<nonCity> getCityPopulation = new ArrayList<nonCity>();
        getCityPopulation=app31.getCityPopulation(con);

        for (nonCity IT : getCityPopulation)
        {
            assertEquals(IT.continent_name,"Australia and New Zealand");
            assertEquals(IT.city_population, 13163436);
            assertEquals(IT.non_city_population, 286884264);
            break;
        }
    }//end TestgetCityPopulation



    @Test
    void TestgetCountryPopulation()
    {
        app32 = new ID32App();
        ArrayList<nonCity> getCountryPopulation = new ArrayList<nonCity>();
        getCountryPopulation= app32.getCountryPopulation(con);

        for (nonCity IT : getCountryPopulation)
        {
            assertEquals(IT.continent_name,"Afghanistan");
            assertEquals(IT.city_population, 2332100);
            assertEquals(IT.non_city_population, 88547988);
            break;
        }
    }//end TestgetCountryPopulation

 */

    @Test
    void TestgetWorldPopulation()
    {
        app33 = new ID33App();
        long world_population;
        world_population= app33.getWorldPopulation(con);

            assertEquals(world_population,6078749450l);

    }//end TestgetWorldPopulation


    @Test
    void TestgetContinentPopulationSouthAmerica()
    {
        app34 = new ID34App();
        long Continent_population;
        Continent_population= app34.getContinentPopulation(con);

        assertEquals(Continent_population,345780000);

    }//end TestgetContinentPopulationSouthAmerica






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
    }//end disconnect

}
