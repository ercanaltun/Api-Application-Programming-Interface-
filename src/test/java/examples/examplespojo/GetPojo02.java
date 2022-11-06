package examples.examplespojo;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPojo02 extends RestfulBaseUrl {

        /*
       Given
           https://restful-booker.herokuapp.com/booking/13
       When
         I send GET Request to the URL
      Then
         Status code is 200
     And
         Response body is like:
                    {
    "firstname": "Batman",
    "lastname": "Sevilla",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "No cleaning"
}
    */

    @Test
    public void Getpojo02() {

        //Set the Url
        spec.pathParams("first","booking","second",13);

        //Set the Expected Data(Payload)
        BookingDatePojo bookingdates=new BookingDatePojo("2018-01-01","2019-01-01");
        BookingPojo expectedData= new BookingPojo("Batman","Sevilla",111,true,bookingdates,"No cleaning");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        BookingPojo actualData=response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(bookingdates.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBookingdates().getCheckout());
    }
}
