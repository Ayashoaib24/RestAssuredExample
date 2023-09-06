package org.sources;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class WhoAmI {


    // Send a GET request to the 'whoami' endpoint with the captured token
    public Response performRequest(String url,String token) {
        if (token == null) {
            throw new RuntimeException("Token not found. Login may have failed.");
        }

       return   given()
                .header("Authorization", "Bearer " + token)
                .get(url);
    }
}
