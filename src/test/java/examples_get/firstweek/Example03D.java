package examples_get.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class Example03D extends JsonplaceholderBaseUrl {

            /*
        Given
            https://jsonplaceholder.typicode.com/todos/23
        When
            User send GET Request to the URL
        Then
            HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
     */


    @Test
    public void test03D() {

        //First Step:Set the Url
        spec.pathParams("first","todos","second",23);

        //Second Step:Set The Expected Data(Payload)

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");


        //Fourth Step:Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.contentType().contains("application/json"));
        response.then().body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
        ,"completed",equalTo(false),"userId",equalTo(2));
    }
}
