package cw.group8;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


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
    static ID31App app31;
    static ID33App app33;
    static ID34App app34;
    static ID35App app35;
    static ID36App app36;
    static ID37App app37;
    static ID38App app38;
    static ID39App app39;

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
        app31 = new ID31App();
        app33 = new ID33App();
        app34 = new ID34App();
        app35 = new ID35App();
        app36 = new ID36App();
        app37 = new ID37App();
        app38 = new ID38App();
        app39 = new ID39App();
    }

    //Unit testing for Issue ID 08
    @Test
    void ID08GetAllCountriesWorld() {app08.getAllCountriesWorld(null);}

    //Unit testing for Issue ID 09
    @Test
    void ID09GetAllCountriesContinent() {app09.getAllCountriesContinent(null);}

    //Unit testing for Issue ID 10
    @Test
    void ID10GetAllCountriesRegion() {app10.getAllCountriesRegion(null);}

    //Unit testing for Issue ID 11
    @Test
    void ID11GetTopCountriesWorld() {app11.getTopCountriesWorld(null);}

    //Unit testing for Issue ID 12
    @Test
    void ID12GetTopCountriesContinent() {app12.getTopCountriesContinent(null);}

    //Unit testing for Issue ID 13
    @Test
    void ID13GetTopCountriesRegion()  {app13.getTopCountriesRegion(null);}

    //Unit testing for Issue ID 14
    @Test
    void ID14GetAllCitiesWorld() {app14.getAllCitiesWorld(null);}

    //Unit testing for Issue ID 15
    @Test
    void ID15GetAllCitiesContinent() {app15.getAllCitiesContinent(null);}

    //Unit testing for Issue ID 16
    @Test
    void ID16GetAllCitiesRegion()  {app16.getAllCitiesRegion(null);}

    //Unit testing for Issue ID 17
    @Test
    void ID17GetAllCitiesCountry()  {app17.getAllCitiesCountry(null);}

    //Unit testing for Issue ID 18
    @Test
    void ID18GetAllCitiesDistrict()  {app18.getAllCitiesDistrict(null);}

    //Unit testing for Issue ID 19
    @Test
    void ID19GetTopCitiesWorld() {app19.getTopCitiesWorld(null);}

    //Unit testing for Issue ID 20
    @Test
    void ID20GetTopCitiesContinent()  {app20.getTopCitiesContinent(null);}

    //Unit testing for Issue ID 21
    @Test
    void ID21GetTopCitiesRegion()  {app21.getTopCitiesRegion(null);}

    //Unit testing for Issue ID 22
    @Test
    void ID22GetTopCitiesCountry()  {app22.getTopCitiesCountry(null);}

    //Unit testing for Issue ID 23
    @Test
    void ID23AppGetTopCitiesDistrict() {app23.getTopCitiesDistrict(null);}

    //Unit testing for Issue ID 24
    @Test
    void ID24AppGetAllCitiesTestNull() {app24.getAllCities(null);}
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

    //Unit testing for Issue ID 31
    @Test
    void ID31GetCityPopulationNull()
    {
        app31.getCityPopulation(null);
    }
    @Test
    void ID31PrintPopulationTestNull() {app31.printPopulation(null); }

    //Unit testing for Issue ID 33
    @Test
    void ID33AppgetWorldPopulationTestNull() {app33.getWorldPopulation(null); }
    @Test
    void ID33AppPrintTotalPopulationTestNull() {app33.printTotalPopulation(0); }

    //Unit testing for Issue ID 34
    @Test
    void ID34AppGetContinentPopulationTestNull() {app34.getContinentPopulation(null); }
    @Test
    void ID34AppPrintCitiesTestNull() {app34.printTotalPopulation(0); }

    //Unit testing for Issue ID 35
    @Test
    void ID35AppGetRegionPopulationTestNull() {app35.getRegionPopulation(null); }
    @Test
    void ID35AppPrintTotalPopulationTestNull() {app35.printTotalPopulation(0); }

    //Unit testing for Issue ID 36
    @Test
    void ID36AppGetRegionPopulationTestNull() {app36.getAllCountryPopulation(null); }
    @Test
    void ID36AppPrintTotalPopulationTestNull() {app36.printCountries(null); }

    //Unit testing for Issue ID 37
    @Test
    void ID37AppGetRegionPopulationTestNull() {app37.getAllDistrictPopulation(null);}
    @Test
    void ID37AppPrintTotalPopulationTestNull() {app37.printDistricts(null);}

    //Unit testing for Issue ID 38
    @Test
    void ID38AppGetRegionPopulationTestNull() {app38.getAllCityPopulation(null);}
    @Test
    void ID38AppPrintTotalPopulationTestNull() {app38.printCities(null);}


    //Unit testing for Issue ID 39
    @Test
    void ID39AppGetRegionPopulationTestNull() {app39.getLanguage(null); }
    @Test
    void ID39AppPrintTotalPopulationTestNull() {app39.printLanguageDetails(null); }
}