package cw.group8;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;

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
                        "SELECT DISTINCT country.region AS country_region, " +
                                "     SUM(city.population) AS city_population, " +
                                "     (SUM(country.population) - SUM(city.population)) AS non_city_population " +
                                "FROM country " +
                                "INNER JOIN city ON country.code = city.countryCode " +
                                "GROUP BY country.region " + //Group by region only
                                "ORDER BY country.region";



                // Execute SQL statement
            rset = stmt.executeQuery(sql);

           // Extract Population information
            ArrayList<nonCity> regionPopulation = new ArrayList<>();
            while (rset.next()) {
                nonCity nonCities = new nonCity ();
                nonCities.country_region = rset.getString("country_region");
                nonCities.city_population = rset.getLong("city_population");
                nonCities.non_city_population = rset.getLong("non_city_population");
                regionPopulation.add(nonCities);
            }
            return regionPopulation;
        }
        catch(Exception e){
            out.println("Error in running SQL"+e.getMessage());
            return null;
        }


    }

            //Print Population Report
            public void printPopulation(ArrayList<nonCity> regionPopulation) {
                // check regionPopulation array is not null
                if (regionPopulation == null)
                {
                    out.println("No Region Population Found from this Query");
                    out.println("Query needs revisions");
                    return;
                }
                out.println(String.format("%-30s\t%20s\t%20s", "Region", "City Population", "Non-City Population"));
                for (nonCity nc : regionPopulation) {
                    String printRegion =
                    String.format("%-30s\t%20s\t%20s",nc.country_region,nc.city_population,nc.non_city_population);
                    out.println(printRegion);
                }


    }
}

/* end ID31App */
