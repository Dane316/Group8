package cw.group8;

import java.sql.*;
import java.util.ArrayList;

/**
 * As an Organization I want to produce a report on the population of people, people
 * living in cities, and people not living in cities in each continent so that this population
 * information is easy to access.
 */
public class ID30App {
    /**
     * Gets Population of People Living or Not Living in Cities by Continent
     **/
    public ArrayList<nonCity> getContinentPopulation(Connection con) {
        ResultSet rset;
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String sql =
                    "SELECT DISTINCT country.continent AS continent_name , " +
                            "     SUM(city.population) AS city_population, " +
                            "     (SUM(country.population) - SUM(city.population)) AS non_city_population " +
                            "FROM country " +
                            "INNER JOIN city ON country.code = city.countryCode " +
                            "GROUP BY country.continent " + //Group by region only
                            "ORDER BY country.continent";



            // Execute SQL statement
            rset = stmt.executeQuery(sql);

            // Extract Population information
            ArrayList<nonCity> continentPopulation = new ArrayList<>();
            while (rset.next()) {
                nonCity nonCities = new nonCity ();
                nonCities.continent_name = rset.getString("continent_name");
                nonCities.city_population = rset.getLong("city_population");
                nonCities.non_city_population = rset.getLong("non_city_population");
                continentPopulation.add(nonCities);
            }
            return continentPopulation;
        }
        catch(Exception e){
            System.out.println("Error in running SQL"+e.getMessage());
            return null;
        }


    }

    //Print Population Report
    public void printPopulation(ArrayList<nonCity> continentPopulation) {
        // check continentPopulation array is not null
        if (continentPopulation == null)
        {
            System.out.println("No Continent Population Found from this Query");
            System.out.println("Query needs revisions");
            return;
        }
        System.out.println(String.format("%-30s\t%20s\t%20s", "Continent", "City Population", "Non-City Population"));
        for (nonCity nc : continentPopulation) {
            String printContinent =
                    String.format("%-30s\t%20s\t%20s",nc.continent_name,nc.city_population,nc.non_city_population);
            System.out.println(printContinent);
        }


    }
}

/* end ID30App */
