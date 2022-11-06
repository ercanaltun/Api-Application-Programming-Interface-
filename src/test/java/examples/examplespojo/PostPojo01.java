package examples.examplespojo;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatePojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class PostPojo01 extends RestfulBaseUrl {

        /*
        Given
         1)  https://restful-booker.herokuapp.com/booking
         2)   {
               "firstname": "Ali",
               "lastname": "Can",
               "totalprice": 999,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2021-09-21",
                   "checkout": "2021-12-21"
                },
                "additionalneeds": "Breakfast"
            }
       When
         I send POST Request to the URL
      Then
         Status code is 200
     And
         Response body is like {
                                 "bookingid": 16,
                                 "booking" :{
                                       "firstname": "Ali",
                                       "lastname": "Can",
                                       "totalprice": 999,
                                       "depositpaid": true,
                                       "bookingdates": {
                                           "checkin": "2021-09-21",
                                           "checkout": "2021-12-21"
                                       },
                                       "additionalneeds": "Breakfast"
                                    }
                                 }
    */


    @Test
    public void PostPojo01() {

        //Set the Url:
        spec.pathParam("first","booking");

        //Set the Expected Data:
        BookingDatePojo bookingdates=new BookingDatePojo("2021-09-21","2021-12-21");
        BookingPojo expectedData=new BookingPojo("AliCan","CanCan",999,true,bookingdates,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and Get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        BookingResponseBodyPojo actualData=response.as(BookingResponseBodyPojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());
        assertEquals(bookingdates.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());



    }
}
