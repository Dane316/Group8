package cw.group8;

import java.sql.*;
import java.util.ArrayList;

/**
 * As an Organization I want to produce a report on the population of people, people
 * living in cities, and people not living in cities in each region so that this population
 * information is easy to access.
 */
public class ID32App {
    /**
     * Gets Population of People Living or Not Living in Cities by Country
     **/
    public ArrayList<nonCity> getCountryPopulation(Connection con) {
        ResultSet rset;
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String sql =
                    "SELECT DISTINCT country.name AS country_name, " +
                            "     SUM(city.population) AS city_population, " +
                            "     (SUM(country.population) - SUM(city.population)) AS non_city_population " +
                            "FROM country " +
                            "INNER JOIN city ON country.code = city.countryCode " +
                            "GROUP BY country.name " + //Group by region only
                            "ORDER BY country.name";

            // Execute SQL statement
            rset = stmt.executeQuery(sql);

            // Extract Population information
            ArrayList<nonCity> countryPopulation = new ArrayList<>();
            while (rset.next()) {
                nonCity nonCities = new nonCity ();
                nonCities.country_name = rset.getString("country_name");
                nonCities.city_population = rset.getLong("city_population");
                nonCities.non_city_population = rset.getLong("non_city_population");
                countryPopulation.add(nonCities);
            }
            return countryPopulation;
        }
        catch(Exception e){
            System.out.println("Error in running SQL"+e.getMessage());
            return null;
        }


    }

    //Print Population Report
    public void printPopulation(ArrayList<nonCity> countryPopulation) {
        // check regionPopulation array is not null
        if (countryPopulation == null)
        {
            System.out.println("No Country Population Found from this Query");
            System.out.println("Query needs revisions");
            return;
        }
        System.out.println(String.format("%-30s\t%20s\t%20s", "Country", "City Population", "Non-City Population"));
        for (nonCity nc : countryPopulation) {
            String printRegion =
                    String.format("%-30s\t%20s\t%20s",nc.country_name,nc.city_population,nc.non_city_population);
            System.out.println(printRegion);
        }


    }
}

/* end ID31App */
