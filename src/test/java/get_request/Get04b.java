package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get04b extends RestfulBaseUrl {

       /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
   And
   Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

 */

    @Test
    public void test04() {

        //First Step:Set the Url
        spec.pathParams("first", "booking")
                .queryParams("firstname", "Almedin", "lastname", "Alikadic");

        //Second Step:Set The Expected Data

        //Third Step:Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //Fourth Step:Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.body().asString().contains("bookingid"));


    }
}
