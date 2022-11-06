package examples.examples_get.firstweek;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example02B extends RestfulBaseUrl {

            /* Given
            https://restful-booker.herokuapp.com/booking/1
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    @Test
    public void test02B() {

        //1.Step:Set the Url
        spec.pathParams("first","booking","second",1);
        //2.Step:Set the expected data

        //3.Step:Send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //4.Step:Do Assertion
        response.then().assertThat().statusCode(404).
                statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals(response.getHeader("Server"),"Cowboy");

    }
}
