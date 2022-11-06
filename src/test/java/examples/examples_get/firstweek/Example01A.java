package examples.examples_get.firstweek;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Example01A {

            /*
    Given   "https://jsonplaceholder.typicode.com/todos/99"

        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    @Test
    public void test01() {

        //1.Set the Url
        String url = "https://jsonplaceholder.typicode.com/todos/99";

        //2.When
        // User sends a GET Request to the url=>Ama burada herhangi


        // bir değişiklik ve işlem istemiyor.Oyuzden bu kısmı atlıyoruz.

        // 3. Type code to send request ( Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();  //soutprint görevi görüyor

        // 4. Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");


    }




}
