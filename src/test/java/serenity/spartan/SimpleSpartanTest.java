package serenity.spartan;

import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.*;
import static io.restassured.RestAssured.* ;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class SimpleSpartanTest {

    @BeforeAll
    public static void setUp(){
        baseURI = "http://18.234.102.94";
        basePath="/api";
        port=8000;
    }

    @AfterAll
    public static void afterAll(){
reset();
    }

    @DisplayName("Testing GET/api hello endpoint")
    @Test
    public void testingHelloEndPoint(){
        SerenityRest.
        when()
                .get("/hello").
        then()
                .statusCode(200)
                .contentType(ContentType.TEXT)
                .log().body()
                .body(is("Hello from Sparta"))
                ;
    }
}
