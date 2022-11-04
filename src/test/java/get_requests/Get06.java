package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class Get06 extends RestfulBaseUrl {

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
    "firstname": "Bradley",
    "lastname": "Pearson",
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
    public void test01() {

        //Set the Url
        spec.pathParams("first", "booking", "second", 2325);

        //Set the expected data

        //Type code to send the Request (Send The Request and Get The Response)
        Response response = given().spec(spec).when().get("/{first}/{second}");
        // response.prettyPrint();

        //Do Assertion
        //1.Yol:
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("firstname", equalTo("Bradley"),
                        "lastname", equalTo("Pearson"),
                        "totalprice", equalTo(132),
                        "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2022-10-27"),
                        "bookingdates.checkout", equalTo("2022-11-07"),
                        "additionalneeds", equalTo("None"));

        //2.Yol:Jsonpath class'ın kullanımı
        JsonPath json = response.jsonPath();
        assertEquals("Bradley", json.getString("firstname"));
        assertEquals("Pearson", json.getString("lastname"));
        assertEquals(132, json.getInt("totalprice"));
        assertFalse(json.getBoolean("depositpaid"));
        assertEquals("2022-10-27", json.getString("bookingdates.checkin"));
        assertEquals("2022-11-07", json.getString("bookingdates.checkout"));
        assertEquals("None", json.getString("additionalneeds"));

        // 3. Yol : Soft Assertion
        // softAssert class 3 adimda kullanilir

        // i) Obje olusturma

        SoftAssert softAssert = new SoftAssert();

        // ii) Do Assertion ( dogrulama Yapma)

        softAssert.assertEquals(json.getString("firstname"), "Bradley", "First Name Hatali");
        softAssert.assertEquals(json.getString("lastname"), "Pearson", "Last Name Hatali");
        softAssert.assertEquals(json.getInt("totalprice"), 132, "Total Price Hatali");
        softAssert.assertEquals(json.getBoolean("depositpaid"), false, "Depositpaid Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"), "2022-10-27", "Check In Tarihi Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkout"), "2022-11-07", "Check out Tarihi Hatali");
        softAssert.assertEquals(json.getString("additionalneeds"), "None", "Additionalneeds Hatali");
        softAssert.assertAll();

        /* iii) Dogrulama islemleri sonunda softAssert.assertAll()
                diyerek yaptigimiz tum dogrulama islemlerinin kontrol edilmesini sagliyoruz.

               Eger islemin sonunda softAssert.assertAll() kullanmaz isek taleplerimiz
               hatalı bile olsa testimiz pass olacaktir.
         */


    }
}
