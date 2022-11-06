package examples.examples_get.secondweek;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Example11A extends GoRestBaseUrl {

        /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        Aryan Adiga, Deven Khanna and Rajiv Saini are among the users
    And
        The female users are less than or equals to male users
 */


    @Test
    public void test11() {

        //First Step:Set the Url
        spec.pathParam("first","users");

        //Second Step:Set The Expected Data(Payload)

        //Third Step:Send The Request and Get The Response
        Response response=given().spec(spec).when().get("/{first}");
       // response.prettyPrint();

        //Fourth Step:Do Assertion

        response.then().assertThat()
                .body("meta.pagination.limit",equalTo(10)
                ,"meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1")
                ,"data",hasSize(10)
                ,"data.status",hasItem("active")
                ,"data.name",hasItems("Aryan Adiga","Deven Khanna","Rajiv Saini"));
        //Kadınların sayısını bulmanın 1.yolu:
        List<String>genders =response.jsonPath().getList("data.gender");
        System.out.println("genders = " + genders);

         int countFemale=0;
        for (String w:genders
             ) {
            if (w.equalsIgnoreCase("female")){
                countFemale++;
            }
        } assertTrue(countFemale<=genders.size()-countFemale);

        //Kadınların sayısını bulmanın 2.yolu(Groovy=>findAll):
        List<String>females=response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println("females = " + females);

        List<String>males=response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("males = " + males);
        assertTrue(females.size()<=males.size());


    }



}
