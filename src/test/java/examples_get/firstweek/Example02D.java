package examples_get.firstweek;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Example02D extends RestfulBaseUrl {

            /* Given
            https://restful-booker.herokuapp.com/booking/01
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
            Connection is "keep-alive"
     */

    @Test
    public void test02D() {

        //First Step:Set the Url
        spec.pathParams("first","booking","second",01);

        //Second Step:Set The Expected Data(Payload)

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //Fourth Step:Do Assertion
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertTrue(response.body().asString().contains("Not Found"));
        assertFalse(response.body().asString().contains("TechProEd"));
        assertEquals("keep-alive",response.getHeader("Connection"));

    }

























}
