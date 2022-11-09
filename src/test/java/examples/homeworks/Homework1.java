package examples.homeworks;

import base_url.AutoexercisesBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework1 extends AutoexercisesBaseUrl {

     /*
        Given
            https://automationexercise.com/api/brandsList
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be "text/html; charset=utf-8"
        And
            Status Line should be HTTP/1.1 200 OK
        And
             Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
*/
    //Set the Url
    //Set the Expected Data
    //Send the Request and get Response
    //Do Assertion

    @Test
    public void Homework1() {

        //Set the Url
        spec.pathParam("first","brandsList");

        //Set the Expected Data

        //Send the Request and get Response
        Response response=given().spec(spec).when().get("/{first}");

        //Do Assertion
        assertEquals(200,response.statusCode());
        assertEquals("text/html; charset=utf-8",response.contentType());
        assertEquals("HTTP/1.1 200 OK",response.statusLine());

        //Number of H&M brands must be equal to Polo(H&M marka sayısı Polo marka sayısına eşit olmalı)
        JsonPath json= response.jsonPath();
        List<String>polo =json.getList("brands.findAll{it.brand=='Polo'}.brand");
        List<String>hm =json.getList("brands.findAll{it.brand=='H&M'}.brand");
        assertEquals(polo.size(),hm.size());






    }
}
