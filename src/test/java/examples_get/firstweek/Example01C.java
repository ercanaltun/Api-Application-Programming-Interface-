package examples_get.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Example01C extends JsonplaceholderBaseUrl {

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
    public void test01C() {

        //First Step:Set the Url
        spec.pathParams("first","todos","second",99);

        //Second Step:Set the Expected Data

        //Third Step:Send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .statusLine("HTTP/1.1 200 OK");


    }



}
