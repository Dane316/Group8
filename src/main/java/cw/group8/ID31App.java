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
    public ArrayList<country> getCityPopulation(Connection con) {
        ResultSet rset;
            try {
            // Create an SQL statement
            Statement stmt = con.createStatement();

            // Create string for SQL statement
            String sql =
                    "SELECT country.region AS country_region, "+ "SUM(city.population) AS city_population, " +
                            "(country.population - SUM(city.population)) AS city.non_city_population, " +
                            "country.population AS total_population " +
                            "FROM country " +
                            "LEFT JOIN city ON country.code = city.countryCode " +
                            "GROUP BY country.region, country.population";

            // Execute SQL statement
            rset = stmt.executeQuery(sql);

            //String country_region = null;
           // int city_population = 0;
            int non_city_population = 0;
            //int total_population = 0;

            // Extract Population information
            ArrayList cityPopulation;
            cityPopulation = new ArrayList();
            while (rset.next()) {
                city cities = new city();
                country countries = new country();
                countries.region = rset.getString("country_region");
                cities.population = rset.getInt("city_population");
                non_city_population = rset.getInt("non_city_population");
                //cityPopulation.add(country_region);

            }
            return cityPopulation;
        }
        catch(Exception e){
            System.out.println("Error in running SQL");
            return null;
        }


    }

            //Print Population Report
            public void printPopulation(ArrayList cityPopulation) {
                // check cityPopulation array is not null
                if (cityPopulation == null)
                {
                    System.out.println("No city Population Found");
                    return;
                }

                System.out.println("Region\t\tCity Population\tNon-City Population\tTotal Population");
                for (int i = 0; i < cityPopulation.size(); i++) {
                    System.out.println(cityPopulation.get(i));
                    System.out.printf("%s\t\t%d\t\t%d\t\t\t%d\n",
                            cityPopulation);

                }


    }
}

/* end ID31App */
