package org.sources;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Login {


    //Run Login Endpoint
    public Response runLoginEndPoint(String url, String email, String password, String token) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body("{\"email\": \"" + email + "\", \"password\": \"" + password + "\", \"token\":\"" + token + "\"}")
                .post(url);
    }

    public String getToken(Response response) {
        return response.jsonPath().getString("token");
    }


    //Login And get token at the same function
    public String loginAndGetToken(String url, String email, String password, String token) {

        Response loginresponse = runLoginEndPoint(url, email, password, token);
        return getToken(loginresponse);
    }

}
