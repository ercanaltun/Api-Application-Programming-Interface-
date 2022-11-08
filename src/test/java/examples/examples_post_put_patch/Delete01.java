package examples.examples_post_put_patch;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Delete01 extends JsonplaceholderBaseUrl {

          /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
         I send DELETE Request to the Url
      Then
         Status code is 200
         And Response body is { }
     */

    @Test
    public void test01() {

        //set the url
        spec.pathParams("first","todos","second",198);

        //set the expected data
        Map<String,String>expectedData=new HashMap<>();

        //send the request and get the url
        Response response=given().spec(spec).when().delete("/{first}/{second}");

        //Do assertion
       Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

       assertTrue(actualData.isEmpty());

       assertEquals(expectedData,actualData);

       assertEquals(0,actualData.size());



    }
}
