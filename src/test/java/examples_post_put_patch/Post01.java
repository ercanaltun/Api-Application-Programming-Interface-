package examples_post_put_patch;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post01 extends JsonplaceholderBaseUrl {


           /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2)
   When
       I send POST Request to the Url
   Then
       Status code is 201 {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
                         }
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void testPost01() {

        //First Step:Set the Url
        spec.pathParam("first","todos");

        //Second Step:Set The Expected Data(Payload)
        JsonPlaceHolderTestData obje=new JsonPlaceHolderTestData();
        Map<String,Object>expectedData =obje.expectedDataMethod(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
        Map<String,Object>actualdata=response.as(HashMap.class);
        assertEquals(expectedData.get("userId"),actualdata.get("userId"));
        assertEquals(expectedData.get("title"),actualdata.get("title"));
        assertEquals(expectedData.get("completed"),actualdata.get("completed"));
        assertEquals(201,response.statusCode());
    }
}
