package examples.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Example03C extends JsonplaceholderBaseUrl {

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
        And
            "id"    is 23
     */

    @Test
    public void test03C() {

        //First Step:Set The Url
        spec.pathParams("first","todos","second",23);

        //Second Step:Set The Expected Data

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed",equalTo(false)
                        ,"userId",equalTo(2),"id",equalTo(23));


    }
}
