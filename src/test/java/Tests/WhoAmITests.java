package Tests;

import io.restassured.response.Response;
import org.sources.Login;
import org.sources.WhoAmI;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.sources.Credentials.*;


public class WhoAmITests {


    //Test WhoAmI status code
    @Test(priority = 1)
    public void testWhoAmIWithToken() {

        String token = new Login().loginAndGetToken(loginUrl, email, password, loginToken);
        WhoAmI whoAmI = new WhoAmI();
        Response response = whoAmI.performRequest(whoAmIUrl, token);
        response.then()
                .statusCode(200);

    }

    //Assertion on "business_name": "FOODICS"
    @Test(priority = 2)
    public void testBusinessName() {

        String token = new Login().loginAndGetToken(loginUrl, email, password, loginToken);
        WhoAmI whoAmI = new WhoAmI();
        Response response = whoAmI.performRequest(whoAmIUrl, token);
        String ResponseBody = response.getBody().asString();
        System.out.println("Response body :" + ResponseBody);
        String expectedBusinessName = "FOODICS";

        response.then()
                .body("user.merchant.business_name", equalTo(expectedBusinessName));
    }

}
