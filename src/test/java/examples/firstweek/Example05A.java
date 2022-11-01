package examples.firstweek;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Example05A extends RestfulBaseUrl {

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
    public void test05() {

        //1.step:Set the Url
        spec.pathParam("first","booking")
                .queryParams("firstname","Ali","lastname","Cengiz");

        //2.step:Set the data (update with post,put or patch)
        //You know that Passed this step because of the before reason

        //3.Step:Type code to send the request
        Response response=given().spec(spec).get("/{first}");

        //4.Step:Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));
    }
}
