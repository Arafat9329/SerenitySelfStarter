package serenity.spartan;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.is;

@SerenityTest
public class SimpleSpartanTest {

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://18.234.102.94";
        RestAssured.basePath="/api";
        RestAssured.port=8000;
    }

    @AfterAll
    public static void afterAll(){
        RestAssured.reset();
    }

    @DisplayName("Testing GET/api hello endpoint")
    @Test
    public void testingHelloEndPoint(){
        when()
                .get("/hello").
        then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .log().body()
                .body(is("Hello from Sparta"))
                ;

        Ensure.that("Make sure endpoint works",
                response -> response.statusCode(200)
        );
    }

    @DisplayName("This is serenity way of providing details")
    @Test
    public void testManyGitHubGetOneUserEndpoint2() {

        given()
                .contentType(ContentType.JSON)
                .pathParam("username","CybertekSchool").
                when()
                .get("https://api.github.com/users/{username}");


        // this is serenity way we can generate custom report for validation steps
        Ensure.that("Response was successful (instead of saying 200 : )",
                response -> response.statusCode( 200  )
        ) ;
        Ensure.that("This is custom message for verifying login field in response",
                response -> response.body("login", is("CybertekSchool")));

    }

}
