package examples;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Example03A extends JsonplaceholderBaseUrl {

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
    public void get01() {
        //1.Set the Url
        spec.pathParams("first", "todos", "second", 23);

        //2.Set the expected data  =>put,post,patch işlemi yok geçiyoruz bu kısmı

        //3.Type code to send the request
        Response response = given().when().spec(spec).get("/{first}/{second}");

        //4.Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit")
                        , "completed", equalTo(false), "userId", equalTo(2));

    }
}
