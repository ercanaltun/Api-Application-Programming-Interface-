package examples_get.secondweek;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example08B extends JsonplaceholderBaseUrl {

          /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */


    @Test
    public void test08B(){

        //1.Step:Set the Url
        spec.pathParams("first","todos","second",2);

        //2.Step:Set the Expected Data
        Map<String,Object> expectedData=new HashMap<>();
        expectedData.put("id",2);
        expectedData.put("userId",1);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);

        //3.Step:Send the Requset and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //4.Step:Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.getHeader("Via"));
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(200,response.statusCode());

    }




















}
