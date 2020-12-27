package serenity.zipcode_app;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.yecht.Data;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.is;

public class ZipToCityEndpointTest {
    //https://api.zippopotam.us/{{country}}/{{zipcode}}

    @BeforeAll
    public static void setUp(){
        RestAssured.reset();
        RestAssured.baseURI = "https://api.zippopotam.us" ;
    }
    @AfterAll
    public static void cleanUp(){
        clear();
    }


    @DisplayName("Testing 1 zip code and get the result")
    @Test
    public void test1ZipCode(){
        given()
                .pathParam("country","CA")
                .pathParam("zipcode","M1R").
        when()
                .get("/{country}/{zipcode}").
        then()
                .statusCode(200)
                .log().body()
                .body("'post code'",is("M1R") )
                .body("places[0].'place name'", is("Scarborough (Wexford / Maryvale)"))
        ;
    }


    /**
     * {index}  --->> to represent iteration number
     * {arguments} -->>
     * {methodParameterIndexNumber}  -->>
     *
     */
    @DisplayName("Testing multiple zipcodes and get the result")
    @ParameterizedTest(name = "☺♂o☻▬▐♥!M♣♦╝♠♠ Iteration number {index} : {arguments}")
    @ValueSource(strings={"M4C","M1R","N4L","A0A"})
    public void testZipCodes(String zip){
            given()
                    .pathParam("country","ca")
                    .pathParam("zipcode",zip).
            when()
                    .get("/{country}/{zipcode}").
            then()
                    .statusCode(200)
                    .log().body()
                    .body("'post code'",is(zip))
                    //.body("places[0].'place name'", is("Scarborough (Wexford / Maryvale)"))
                    ;

    }

    @ParameterizedTest(name = "Iteration number {index} country is {0}, zipcode is {1}")
    @CsvFileSource(resources = "/zipcode.csv",numLinesToSkip = 1)
    public void testCountryZip(String country , int zipcode ){
        System.out.println("country = " + country);
        System.out.println("zipcode = " + zipcode);

    }


}
