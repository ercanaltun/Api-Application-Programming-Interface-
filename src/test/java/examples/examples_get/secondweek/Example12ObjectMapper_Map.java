package examples.examples_get.secondweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import test_data.utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Example12ObjectMapper_Map extends JsonplaceholderBaseUrl {

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
    public void test01() {


        //First Step:Set the Url
        spec.pathParams("first","todos","second",198);

        //Second Step:Set The Expected Data(Payload)
         JsonPlaceHolderTestData json=new JsonPlaceHolderTestData();
         String dataInString=json.expectedDataInString(10,"quis eius est sint explicabo",true);
         Map expectedData=ObjectMapperUtils.convertJsonToJava(dataInString,Map.class);
        System.out.println("expectedData = " + expectedData);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //Fourth Step:Do Assertion
        Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
