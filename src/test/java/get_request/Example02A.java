package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example02A extends RestfulBaseUrl {

        /* Given
            https://restful-booker.herokuapp.com/booking/1
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */


    @Test
    public void test1() {

        //Set the Url
        spec.pathParams("first","booking","second",1);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)

        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        response.then().assertThat().statusCode(404)  //=>statusCode'un 404 olduğu test ediliyor
            .statusLine("HTTP/1.1 404 Not Found"); //=>statusLine'nın=>HTTP/1.1 404 Not Found olduğu test ediliyor

        //Response body'nin "Not Found" içerdiği test ediliyor:
        assertTrue(response.asString().contains("Not Found"));

        //Response body'nin "TechProEd"  içermediği test ediliyor:
        assertFalse(response.asString().contains("TechProEd"));

        //Server'ın "Cowboy" olduğu test ediliyor:
        assertEquals("Cowboy",response.getHeader("Server"));




    }

}
