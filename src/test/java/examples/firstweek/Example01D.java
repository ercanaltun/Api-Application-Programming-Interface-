package examples.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example01D extends JsonplaceholderBaseUrl {

                /*
    Given   "https://jsonplaceholder.typicode.com/todos/99"

        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void test01D() {

        //1.Step:Set the Url
        spec.pathParams("first","todos","second",99);

        //2.Step:Set the Expected Data(Payload)

        //3.Step:Send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //4.Step:Do Assertion
        assertEquals(200,response.statusCode());
        response.then().contentType(ContentType.JSON);


    }
}
