package examples.examples_get.secondweek;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Example09A extends RestfulBaseUrl {

        /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
  {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
  }
 */


    @Test
    public void test09A() {

        //First Step:Set the Url
        spec.pathParams("first","booking","second",91);

        //Second Step:Set The Expected Data(Payload)
        Map<String,String> bookinDate =new HashMap<>();
        bookinDate.put("checkin","2013-02-23");
        bookinDate.put("checkout","2014-10-23");

        Map<String,Object> expextedData=new HashMap<>();
        expextedData.put("firstname","Sally");
        expextedData.put("laststname","Brown");
        expextedData.put("totalprice",111);
        expextedData.put("depositpaid",true);
        expextedData.put("additionalneeds","Breakfast");

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //Fourth Step:Do Assertion
        Map<String,Object>actualData=response.as(HashMap.class);
        assertEquals(expextedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expextedData.get("laststname"),actualData.get("laststname"));
        assertEquals(expextedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expextedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(expextedData.get("additionalneeds"),actualData.get("additionalneeds"));
        assertEquals(bookinDate.get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        assertEquals(bookinDate.get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));
        //Key-Value ikilileri String-Object şeklinde olduğundan,
        // Bookingdata value kısmını casting ile Map yaptık.

    }






















}
