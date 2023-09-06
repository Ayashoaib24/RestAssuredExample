package Tests;

import io.restassured.response.Response;
import org.sources.Login;
import org.testng.annotations.Test;
import static org.sources.Credentials.*;


public class LoginTests {



    //Test 200 ok login status code
    @Test(priority = 1)
    public void LoginStatusCode() {
        Login login = new Login();
        Response response = login.runLoginEndPoint(loginUrl, email, password, loginToken);


        // Check the response status code
        int statusCode = response.getStatusCode();
        response.then()
                .statusCode(200);


        //Print the response body
        String ResponseBody = response.getBody().asString();
        System.out.println("Response body :" + ResponseBody);
    }



    //Test 405 method not allowed status code
    @Test(priority = 2)
    public void Login4xxStatusCode() {


        Login login = new Login();
        Response response = login.runLoginEndPoint(WrongUrl, email, password, loginToken);


        // Check the response status code
        int statusCode = response.getStatusCode();
        response.then()
                .statusCode(405);



        //Print the response body
        String ResponseBody = response.getBody().asString();
        System.out.println("Response body :" + ResponseBody);


    }



    //Test 401 method not allowed status code
    @Test(priority = 3)
    public void LoginWithWrongCredentials() {


        Login login = new Login();
        Response response = login.runLoginEndPoint(loginUrl, email, wrongPassword, loginToken);

        // Check the response status code
        int statusCode = response.getStatusCode();
        response.then()
                .statusCode(401);

        //Print the response body
        String ResponseBody = response.getBody().asString();
        System.out.println("Response body :" + ResponseBody);


    }

}
