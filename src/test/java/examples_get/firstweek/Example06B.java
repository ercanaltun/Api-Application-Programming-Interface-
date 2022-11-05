package examples_get.firstweek;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Example06B extends RestfulBaseUrl {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/1234
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;
         {
{
    "firstname": "Edgar",
    "lastname": "Parchment",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void test06() {

        //1.Step:Set the Url
        spec.pathParams("first","booking","second",1234);

        //2.Step:Set the Expected Data

        //3.Step:Send The Requset and get The Response
        Response response=given().spec(spec).when().get("/{first}/{second}");

        //4.Step:Do Assertion
        response.then().assertThat().statusCode(200).
                        contentType(ContentType.JSON).
                        body("firstname",equalTo("Edgar"),
                        "lastname",equalTo("Parchment"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01") ,
                        "bookingdates.checkout",equalTo("2019-01-01"),
                         "additionalneeds",equalTo("Breakfast"));

    }
}
