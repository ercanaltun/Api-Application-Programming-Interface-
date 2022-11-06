package examples.examples_get.firstweek;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Example06C extends RestfulBaseUrl {

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
    ""firstname"": "Sarah",
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

    //First Step:Set the Url
    //Second Step:Set The Expected Data(Payload)
    //Third Step:Send The Request and Get The Response
    //Fourth Step:Do Assertion


    @Test
    public void test06C() {

        //First Step:Set the Url
        spec.pathParams("first", "booking", "second", 2325);

        //Second Step:Set The Expected Data

        //Third Step:Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");

        //Fourt Step:Do Assertion
        response.then().assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Sarah")
                        , "lastname", equalTo("Davis")
                        , "totalprice", equalTo(132)
                        , "depositpaid", equalTo(false),
                        "bookingdates.checkin", equalTo("2022-10-27")
                        , "bookingdates.checkout", equalTo("2022-11-07")
                        , "additionalneeds", equalTo("None"));

    }
}
