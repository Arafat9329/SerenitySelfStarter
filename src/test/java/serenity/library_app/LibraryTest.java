package serenity.library_app;

import io.restassured.RestAssured;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static net.serenitybdd.rest.SerenityRest.given;

@SerenityTest
public class LibraryTest {
    private EnvironmentVariables environmentVariables ;


    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://library1.cybertekschool.com";
        RestAssured.basePath = "/rest/v1" ;
    }
    @AfterAll
    public static void tearDown(){
        RestAssured.reset();
        SerenityRest.clear();
    }


    @Test
    public void getTokenTest(){


        System.out.println(EnvironmentSpecificConfiguration.from(environmentVariables)
               .getProperty("base.url"));
    }
}
