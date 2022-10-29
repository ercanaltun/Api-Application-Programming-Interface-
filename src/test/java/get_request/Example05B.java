package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example05B extends RestfulBaseUrl {

            /*
    Given
        https://restful-booker.herokuapp.com/booking
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
    Among the data there should be someone whose firstname is "Alex" and lastname is "Parchment"
 */

    @Test
    public void test05B() {

        //1.Step:Set the Url
        spec.pathParam("first","booking")
                .queryParams("firsname","Alex","second","Parchment");

        //2.Step:Set the Expected Data

        //3.Send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}");

        //4.Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
