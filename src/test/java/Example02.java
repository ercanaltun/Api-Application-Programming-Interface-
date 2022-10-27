import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Example02 extends RestfulBaseUrl {

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
        // ii) Set the expected Data (beklenen datanin olusturulmasi, Post, Put, Patch)
        // iii) Type code to send request ( Talep gondermek icin kod yazimi)
        spec.pathParams("first","booking","second",1);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


    }
}
