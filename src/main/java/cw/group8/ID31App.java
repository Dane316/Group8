package cw.group8;

import java.sql.*;
import java.util.ArrayList;

/**
 * As an Organization I want to produce a report on the population of people, people
 * living in cities, and people not living in cities in each region so that this population
 * information is easy to access.
 */
public class ID31App {
    /**
     * Gets Population of People Living or Not Living in Cities by Region
     **/
    public ArrayList<nonCity> getCityPopulation(Connection con) {
        ResultSet rset;
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String sql =
                    "SELECT country.region AS country_region, country.population, city.population," +
                            "SUM(city.population) AS city_population," +
                            "(country.population - SUM(city.population)) AS non_city_population " +
                            "FROM country " +
                            "INNER JOIN city ON country.code = city.countryCode " +
                            "GROUP BY country.region " +
                            "ORDER BY country.population";

            // Execute SQL statement
            rset = stmt.executeQuery(sql);

            // Extract Population information
            ArrayList<nonCity> regionPopulation = new ArrayList<>();
            while (rset.next()) {
                nonCity nonCities = new nonCity ();
                nonCities.coutry_region = rset.getString("country_region");
                nonCities.city_population = rset.getInt("city_population");
                nonCities.non_city_population = rset.getInt("non_city_population");
                regionPopulation.add(nonCities);
            }
            return regionPopulation;
        }
        catch(Exception e){
            System.out.println("Error in running SQL"+e.getMessage());
            return null;
        }


    }

    //Print Population Report
    public void printPopulation(ArrayList<nonCity> regionPopulation) {
        // check cityPopulation array is not null
        if (regionPopulation == null)
        {
            System.out.println("No Region Population Found");
            return;
        }

        System.out.println("Region\t\tCity Population\tNon-City Population");
        for (nonCity nc : regionPopulation) {
            String printRegion =
                    String.format("%-10s %-15s %25s",nc.coutry_region,nc.city_population,nc.non_city_population);
            System.out.println(printRegion);
        }


    }
}

/* end ID31App */