package examples;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;


public class Example05C extends RestfulBaseUrl {

              /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
       Among the data there should be someone whose firstname is "Ali" and lastname is "Cengiz"
 */

    @Test
    public void test05C() {

        //First Step:Set The Url
        spec.pathParam("first","booking").queryParams("firstname","Ali","lastname","Cengiz");

        //Second Step:Set The Expected data

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assetion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));





    }
}
