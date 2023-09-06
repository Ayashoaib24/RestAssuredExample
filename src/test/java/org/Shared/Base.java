package org.Shared;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Base {

    protected static final String LoginUrl = "https://pay2.foodics.dev/cp_internal";
    protected static final String WhoAmI = "https://pay2.foodics.dev/cp_internal/whoami";


    protected static final String bearerToken = "Lyz22cfYKMetFhKQybx5HAmVimF1i0xO";


   /* protected Response performLogin() {
        return given()
                .header("Authorization", "Bearer " + bearerToken)
                .header("Content-Type", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\"}")
                .post(Url);*/
    }


