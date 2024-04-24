package cw.group8;

import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;

public class ID37App
{

    /**
     * As an Organization I want to produce a report on the population of a district
     * so that this population information is easy to access.
     * @return A list of all the districts in the world
     * with population or null if there is an error.
     */
    public ArrayList<nonCity> getAllDistrictPopulation (Connection con)
    {
        ResultSet rset = null;
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT " +
                            "city.district AS district_name, " +
                            "city.population AS city_population " +
                            "FROM city " +
                            "ORDER BY city_population DESC ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            // Extract country information
            ArrayList<nonCity> districts = new ArrayList< >();
            while (rset.next())
            {
                nonCity districtTable = new nonCity ();
                districtTable.district_name = rset.getString("district_name");
                districtTable.city_population = rset.getLong("city_population");
                districts.add(districtTable);
            }
            return districts;
        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get district details");
            return null;
        }
    }
    /**
     * Prints a list of districts.
     * @param districts The list of districts to print.
     */
    public void printDistricts (ArrayList<nonCity> districts)
    {
        if (districts == null)
        {
            out.println("No Population Data Found from this Query\n");
            out.println("Query needs revisions");
            return;
        }
        // Print header
        out.println("A list of all Districts and population \n");
        out.printf("%-40s\t%-20s","District Name","Population\n");
        // Loop over all districts in the list
        for (nonCity cf : districts)
        {
            String cf_string =
                    String.format("%-40s\t%-20s",cf.district_name,cf.city_population);
            out.println(cf_string);
        }
    }
}