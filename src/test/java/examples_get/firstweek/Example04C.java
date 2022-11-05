package examples_get.firstweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Example04C extends JsonplaceholderBaseUrl {

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
    public void test04C() {
        //First Step:Set The Url
        spec.pathParam("first", "todos");

        //Second Step: Set the Expected Data

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().accept(ContentType.JSON).get("/{first}");
        response.prettyPrint();


        //Fourt Step:Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("title",hasItem("quis eius est sint explicabo")
                ,"id",hasSize(200)
                      , "userId",hasItems(2,7,9));



    }
}
