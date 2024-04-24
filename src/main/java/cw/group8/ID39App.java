package cw.group8;

import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;

import static java.lang.System.*;


/**
 * As an Organization I want to produce a report on the number of people who
 * speak Chinese, English, Hindi, Spanish and Arabic from greatest number to smallest,
 * including the percentage of the world population so that this population information is easy to access.
 */
public class ID39App {

    /**
     * Gets the number of people who speak Chinese, English, Hindi, Spanish and Arabic
     * @param con The connection to the database.
     * @return list of with language name, total and percentage, or null if there is an error.
     */
    public ArrayList<language> getLanguage(Connection con)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT countrylanguage.Language, SUM(country.population), " +
                            "SUM(country.population / (SELECT SUM(Population) FROM country)) * 100 as percentage "+
                            "FROM countrylanguage "+
                            "INNER JOIN country ON country.Code=countrylanguage.CountryCode "+
                            "WHERE countrylanguage.Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "+
                            "AND countrylanguage.Percentage > '0.0' "+
                             "GROUP BY countrylanguage.Language "+
                                "ORDER BY SUM(country.population) DESC";


            //"SELECT SUM(Population) as world_population FROM country";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract continent information
            ArrayList<language> world_languages = new ArrayList<>();
            while (rset.next())
            {
                language languages = new language();
                languages.language_name=rset.getString(1);
                languages.total_speakers=rset.getLong(2);
                languages.percentage=rset.getBigDecimal(3);
                world_languages.add(languages);
            }
            return world_languages;

        }
        catch (Exception e)
        {
            out.println(e.getMessage());
            out.println("Failed to get language details");
            return null;
        }
    }//end getLanguage

    /**
     * Prints The total population speaks language defined and percentage.
     * @param world_languages The total population that speaks particular language and percentage.
     */
    public void printLanguageDetails(ArrayList<language> world_languages)
    {
        // check total if 0
        if (world_languages == null)
        {
            out.println("Failed to get language details");
            return;
        }

        // Print header
        out.printf("People who speak Chinese, English, Hindi, Spanish and Arabic \n" +
                        "%-10s %-15s %-25s%n", "Language", "Total", "Percentage");
        // Loop over all language details in the list
        for (language five_languages : world_languages)
        {
            String language_string =
                    String.format("%-10s %-15s %-25f",five_languages.language_name, five_languages.total_speakers, five_languages.percentage);
            out.println(language_string);
        }
    }//end printLanguageDetails

}//end ID39App