package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class Group8Tests
{
    static ID08App app08;
    static ID09App app09;
    static ID10App app10;
    static ID11App app11;
    static ID12App app12;
    static ID13App app13;
    static ID14App app14;
    static ID15App app15;
    static ID16App app16;
    static ID17App app17;
    static ID18App app18;
    static ID19App app19;
    static ID20App app20;
    static ID21App app21;
    static ID22App app22;
    static ID23App app23;
    static ID24App app24;
    static ID25App app25;
    static ID26App app26;
    static ID27App app27;

    @BeforeAll
    static void init()
    {
        app08 = new ID08App();
        app09 = new ID09App();
        app10 = new ID10App();
        app11 = new ID11App();
        app12 = new ID12App();
        app13 = new ID13App();
        app14 = new ID14App();
        app15 = new ID15App();
        app16 = new ID16App();
        app17 = new ID17App();
        app18 = new ID18App();
        app19 = new ID19App();
        app20 = new ID20App();
        app21 = new ID21App();
        app22 = new ID22App();
        app23 = new ID23App();
        app24 = new ID24App();
        app25 = new ID25App();
        app26 = new ID26App();
        app27 = new ID27App();
    }

    //Unit testing for Issue ID 08
    @Test
    void ID08GetAllCountriesWorld() throws Exception {app08.getAllCountriesWorld(null);}

    //Unit testing for Issue ID 09
    @Test
    void ID09GetAllCountriesContinent() throws Exception {app09.getAllCountriesContinent(null);}

    //Unit testing for Issue ID 10
    @Test
    void ID10GetAllCountriesRegion() throws Exception {app10.getAllCountriesRegion(null);}

    //Unit testing for Issue ID 11
    @Test
    void ID11GetTopCountriesWorld() throws Exception {app11.getTopCountriesWorld(null);}

    //Unit testing for Issue ID 12
    @Test
    void ID12GetTopCountriesContinent() throws Exception {app12.getTopCountriesContinent(null);}

    //Unit testing for Issue ID 13
    @Test
    void ID13GetTopCountriesRegion() throws Exception {app13.getTopCountriesRegion(null);}

    //Unit testing for Issue ID 14
    @Test
    void ID14GetAllCitiesWorld() throws Exception {app14.getAllCitiesWorld(null);}

    //Unit testing for Issue ID 15
    @Test
    void ID15GetAllCitiesContinent() throws Exception {app15.getAllCitiesContinent(null);}

    //Unit testing for Issue ID 16
    @Test
    void ID16GetAllCitiesRegion() throws Exception {app16.getAllCitiesRegion(null);}

    //Unit testing for Issue ID 17
    @Test
    void ID17GetAllCitiesCountry() throws Exception {app17.getAllCitiesCountry(null);}

    //Unit testing for Issue ID 18
    @Test
    void ID18GetAllCitiesDistrict() throws Exception {app18.getAllCitiesDistrict(null);}

    //Unit testing for Issue ID 19
    @Test
    void ID19GetTopCitiesWorld() throws Exception {app19.getTopCitiesWorld(null);}

    //Unit testing for Issue ID 20
    @Test
    void ID20GetTopCitiesContinent() throws Exception {app20.getTopCitiesContinent(null);}

    //Unit testing for Issue ID 21
    @Test
    void ID21GetTopCitiesRegion() throws Exception {app21.getTopCitiesRegion(null);}

    //Unit testing for Issue ID 22
    @Test
    void ID22GetTopCitiesCountry() throws Exception {app22.getTopCitiesCountry(null);}

    //Unit testing for Issue ID 23
    @Test
    void ID23AppGetTopCitiesDistrict() {app23.getTopCitiesDistrict(null);}

    //Unit testing for Issue ID 24
    @Test
    void ID24AppGetAllCitiesTestNull()
    {
        app24.getAllCities(null);
    }

    @Test
    void ID24AppPrintCitiesTestNull() {app24.printCities(null); }

    //Unit testing for Issue ID 25
    @Test
    void ID25AppGetAllCitiesTestNull() {app25.getAllCitiesContinent(null);}

    @Test
    void ID25AppPrintCitiesTestNull() {app25.printCities(null); }

    //Unit testing for Issue ID 26
    @Test
    void ID26AppGetAllCitiesTestNull()
    {
        app26.getAllCitiesRegion(null);
    }

    @Test
    void ID26AppPrintCitiesTestNull() {app26.printCities(null); }

   //Unit testing for Issue ID 27
   @Test
   void ID27AppGetAllCitiesTestNull()
   {
       app27.getAllCities(null);
   }

    @Test
    void ID27AppPrintCitiesTestNull() {app27.printCities(null); }

}