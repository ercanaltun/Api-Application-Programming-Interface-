package examples.examples_get.secondweek;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Example10A extends GoRestBaseUrl {

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
            "name": "Navin Talwar",
            "email": "navin_talwar@mclaughlin.name",
            "gender": "male",
            "status": "inactive"
              }
         }
     */

    @Test
    public void test10A() {

        //First Step:Set the Url
        spec.pathParams("first","users","second",2986);

        //Second Step:Set The Expected Data(Payload)
        GoRestTestData obje=new GoRestTestData();
        Map<String,String> dataMap=obje.dataKeyMap("Sen. Narayan Acharya","acharya_narayan_sen@torp-baumbach.org","male","inactive");
        Map<String,Object> expectedDatas=obje.expectedDataMethod(null,dataMap);
        System.out.println("expectedDatas = " + expectedDatas);


        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
       // response.prettyPrint();
        
        //Fourth Step:Do Assertion
        Map<String,Object>actualDatas=response.as(HashMap.class);
        System.out.println("actualDatas = " + actualDatas);
        assertEquals(expectedDatas.get("meta"),actualDatas.get("meta"));
        assertEquals(dataMap.get("name"),((Map)actualDatas.get("data")).get("name"));
        assertEquals(dataMap.get("email"),((Map)actualDatas.get("data")).get("email"));
        assertEquals(dataMap.get("gender"),((Map)actualDatas.get("data")).get("gender"));
        assertEquals(dataMap.get("status"),((Map)actualDatas.get("data")).get("status"));
        assertEquals(200,response.statusCode());

















    }
}
