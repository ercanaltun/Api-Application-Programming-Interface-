package examples.firstweek;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Example06E extends ReqresBaseUrl {

         /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        //1)Status code is 200
        //2)Print all pantone_values
        //3)Print all ids greater than 3 on the console
        //  Assert that there are 3 ids greater than 3
        //4)Print all names whose ids are less than 3 on the console
        //  Assert that the number of names whose ids are less than 3 is 2
*/

    @Test
    public void test06E(){

        //1.Step:Set the Url
        spec.pathParam("first","unknown");

        //2.Step:set the Expected Data (Payload)

        //3.Step:Send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}");

        //4.Step:Da Assertion
        //1)Status code is 200
        assertEquals(200,response.statusCode());

        //2)Print all pantone_values
        JsonPath json=response.jsonPath();
        List<String>pantones=json.getList("data.findAll{it.id}.pantone_value");
        System.out.println("pantones = " + pantones);

        //3)Print all ids greater than 3 on the console
        List<Integer>idler=json.getList("data.findAll{it.id>3}.id");
        System.out.println("idler = " + idler);

        //  Assert that there are 3 ids greater than 3
        assertEquals(3, idler.size());

        //4)Print all names whose ids are less than 3 on the console
        List<String>names=json.getList("data.findAll{it.id<3}.name");
        System.out.println("names = " + names);

        //  Assert that the number of names whose ids are less than 3 is 2
        assertEquals(2,names.size());

    }
}
