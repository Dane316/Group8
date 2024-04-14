package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class Group8Tests
{
    static ID24App app;

    @BeforeAll
    static void init()
    {
        app = new ID24App();
    }

    @Test
    void ID24AppGetAllCitiesTestNull()
    {
        app.getAllCities(null);
    }

    @Test
    void ID24AppPrintCitiesTestNull()
    {
        app.printCities(null);
    }



}