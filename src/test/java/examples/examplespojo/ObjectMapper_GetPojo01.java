package examples.examplespojo;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ObjectMapper_GetPojo01 extends JsonplaceholderBaseUrl {

         /*
        Given
           https://jsonplaceholder.typicode.com/todos/198
        When
         I send GET Request to the URL
      Then
         Status code is 200
         And response body is like {
                               "userId": 10,
                               "id": 198,
                               "title": "quis eius est sint explicabo",
                               "completed": true
                             }
     */

    @Test
    public void ObjectMapperPojo01() {


        //First Step:Set the Url
        spec.pathParams("first","todos","second",198);

        //Second Step:Set The Expected Data(Payload)
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Fourth Step:Do Assertion
      JsonPlaceHolderPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }

























}
