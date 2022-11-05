package examples_get.secondweek;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Example10B extends GoRestBaseUrl {

             /*
        Given
            https://gorest.co.in/api/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
        "meta": null,
        "data": {
            "id": 2986,
            "name": "Sen. Narayan Acharya",
            "email": "acharya_narayan_sen@torp-baumbach.org",
            "gender": "male",
            "status": "inactive"
              }
*/


    @Test
    public void test10B() {

        //First Step:Set the Url
        spec.pathParams("first","users","second",2986);

        //Second Step:Set The Expected Data(Payload)
        GoRestTestData obji=new GoRestTestData();
        Map<String,String>data=obji.dataKeyMap("Sen. Narayan Acharya","acharya_narayan_sen@torp-baumbach.org","male","inactive");
        Map<String,Object>expectedData= obji.expectedDataMethod(null,data);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //Fourth Step:Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(data.get("name"),((Map)actualData.get("data")).get("name"));
        assertEquals(data.get("email"),((Map)actualData.get("data")).get("email"));
        assertEquals(data.get("gender"),((Map)actualData.get("data")).get("gender"));
        assertEquals(data.get("status"),((Map)actualData.get("data")).get("status"));
        assertEquals(200,response.statusCode());

    }
}
