package examples_get.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Example04B extends JsonplaceholderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    When
   I send a GET request to the Url
 And
     Accept type is "application/json"
 Then
     HTTP Status Code should be 200
 And
     Response format should be "application/json"
 And
     There should be 200 todos
 And
     "quis eius est sint explicabo" should be one of the todos title
 And
     2, 7, and 9 should be among the userIds
 */

    @Test
    public void get04B() {

        //1.Step:Set the Url
        spec.pathParam("first","todos");

        //2.Step:Set the data(update with=>put,post,patch)
        //But there isn't any update date so passed this step

        //3.Step:Type code to send the request
        Response response=given().spec(spec).when().accept(ContentType.JSON)
                .get("/{first}");

        //4.Step:Do Assertion

        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("id",hasSize(200),
                "title",hasItem("quis eius est sint explicabo"),
                "userId",hasItems(2,7,9));


    }
}
