package get_requests;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get06b extends ReqresBaseUrl {

     /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2
*/

    @Test
    public void test06() {

        //First Step:Set the Url
        spec.pathParam("first", "unknown");

        //Second Step:Set The Expected Data

        //Third Step:Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //Fourth Step:Do Assertion
        // 1)Status code is 200
        assertEquals(200, response.statusCode());

        //2)Print all pantone_values
        JsonPath json = response.jsonPath();
        List<String> pantone_value = json.getList("data.pantone_value");
        System.out.println("pantone_value = " + pantone_value);

        //  3)Print all ids greater than 3 on the console
        List<Integer> idler = json.getList("data.findAll{it.id>3}.id"); //findAll{it.id>3}.id=>Groovy language
        System.out.println("idler = " + idler);
        // Assert that there are 3 ids greater than 3
        assertEquals(3, idler.size());


        //4)Print all names whose ids are less than 3 on the console
        List<String> names = json.getList("data.findAll{it.id<3}.name");
        System.out.println("names = " + names);


        //  Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2, names.size());



    }




}
