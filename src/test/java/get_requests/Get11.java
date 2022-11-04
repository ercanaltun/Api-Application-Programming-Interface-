package get_requests;

import base_url.GoRestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GoRestBaseUrl {

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
        Fr. Paramartha Bandopadhyay, Navin Panicker and Sunita Ahuja are among the users
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
        //response.prettyPrint();

        //Fourth Step:Do Assertion
        JsonPath json=response.jsonPath();
       response.then()
               .assertThat().statusCode(200)
               .body("meta.pagination.limit",equalTo(10),
                "meta.pagination.links.current",equalTo("https://gorest.co.in/public/v1/users?page=1"),
                "data",hasSize(10),
                "data.status",hasItem("active"),
                "data.name",hasItems("Malti Verma","Navin Panicker","Sunita Ahuja"));

       //The female users are less than or equals to male users
        //1.Yol:
              List<String>genders =response.jsonPath().getList("data.gender");

              int numberOfFemale=0;
        for (String w:genders  ){

            if(w.equalsIgnoreCase("female")){
                numberOfFemale++;
            }

        }
           assertTrue(numberOfFemale<=genders.size()-numberOfFemale);

        //2.Yol:Kadın ve erkek sayilarini Groovy ile bulalım
        List<String>femaleNames=response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println("femaleNames = " + femaleNames);

        List<String>maleNames=response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("maleNames = " + maleNames);

        assertTrue(femaleNames.size()<=maleNames.size());


    }
}
