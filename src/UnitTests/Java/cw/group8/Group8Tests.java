package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class Group8Tests
{
    static ID24App app24;
    static ID27App app27;

    @BeforeAll
    static void init()
    {
        app24 = new ID24App();
        app27 = new ID27App();
    }

    //Unit testing for Issue ID 24
    @Test
    void ID24AppGetAllCitiesTestNull()
    {
        app24.getAllCities(null);
    }

    @Test
    void ID24AppPrintCitiesTestNull() {app24.printCities(null); }

   //Unit testing for Issue ID 27
   @Test
   void ID27AppGetAllCitiesTestNull()
   {
       app27.getAllCities(null);
   }

    @Test
    void ID27AppPrintCitiesTestNull() {app27.printCities(null); }




}