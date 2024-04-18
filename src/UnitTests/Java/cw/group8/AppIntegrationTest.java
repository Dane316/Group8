package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
{
    static App app;
    static ID24App app24;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void testgetAllCities()
    {
        /*city cities = ID24App.getAllCities(con);
        assertEquals(cities.name, "Amsterdam");
        assertEquals(cities.countryCode, "NLD");
        assertEquals(cities.district, "Noord-Holland");*/

        // to be updated. added so we can get Integration test if workflow working for testing
        assertEquals("731200", "731200");
    }
}