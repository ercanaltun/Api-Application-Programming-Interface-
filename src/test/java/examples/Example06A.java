package examples;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Example06A extends RestfulBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/2325
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
    "firstname": "Sarah",
    "lastname": "Davis",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": {        ====> //=>Outer Json
        "checkin": "2022-10-27",  //=>inner Json
        "checkout": "2022-11-07"  //=>inner Json
    },
    "additionalneeds": ""None""
}
     */


    @Test
    public void test06() {

        //1.Step:Set the Url
        spec.pathParams("first","booking","second",2325);

        //2.Step:Set the Expected Data

        //3.Step:Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //4.Step:Do Asserion
        //1.Way of Solving:
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Sarah"),
                        "lastname", equalTo("Davis"),
                        "totalprice", equalTo(132),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2022-10-27"),
                        "bookingdates.checkout", equalTo("2022-11-07"),
                        "additionalneeds", equalTo("None"));



       // //2.Way of Solving:
       JsonPath json=response.jsonPath();
       assertEquals("Bradley",json.getString("firstname"));
       assertEquals("Pearson",json.getString("lastname"));
       assertEquals(132,json.getInt("totalprice"));
       assertEquals("2022-10-27",json.getString("bookingdates.checkin"));
       assertEquals("2022-11-07",json.getString("bookingdates.checkout"));
       assertEquals("None",json.getString("additionalneeds"));


        //3.Way of Solving
        //SoftAssert kullanmak için; 1_Obje olusturma
                                  // 2_softassert leri yazma
                                  // 3_Sonuda assetAll(); kullanma

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(json.getString("firstname"), "Bradley", "First Name Hatali");
        softAssert.assertEquals(json.getString("lastname"), "Pearson", "Last Name Hatali");
        softAssert.assertEquals(json.getInt("totalprice"), 132, "Total Price Hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"), false, "Depositpaid Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2022-10-27", "Check In Tarihi Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2022-11-07", "Check out Tarihi Hatali");
        softAssert.assertEquals(json.getString("additionalneeds"), "None", "Additionalneeds Hatali");
        softAssert.assertAll();


    }
}
