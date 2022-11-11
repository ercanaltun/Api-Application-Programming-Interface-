package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RestfulTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post02 extends RestfulBaseUrl {

     /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
*/




    @Test
    public void testPut02() {

        //First Step:Set the Urlş
        spec.pathParam("first","booking");

        //Second Step:Set The Expected Data(Payload)
        RestfulTestData obje=new RestfulTestData();
        Map<String,String> bookingdatesMap=obje.bookingdatesMethod("2021-09-09","2021-09-21");
        Map<String,Object> expectedData=obje.restfulMethod("John","Doe",11111,true,bookingdatesMap);

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        System.out.println("expectedData = " + expectedData);

        //Fourth Step:Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);//De-Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("firstname"),((Map)actualData.get("booking")).get("firstname"));
        assertEquals(expectedData.get("lastname"),((Map)actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("totalprice"),((Map)actualData.get("booking")).get("totalprice"));
        assertEquals(expectedData.get("depositpaid"),((Map)actualData.get("booking")).get("depositpaid"));
        assertEquals(bookingdatesMap.get("checkin"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map)((Map)actualData.get("booking")).get("bookingdates")).get("checkout"));

























    }
}
