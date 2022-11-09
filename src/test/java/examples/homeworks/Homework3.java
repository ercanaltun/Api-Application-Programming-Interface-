package examples.homeworks;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Reqres_Name_Job_Pojo;
import test_data.RegresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework3 extends ReqresBaseUrl {

    //3: Map ile ve Pojo Class ile ayrı ayrı Gson kullanarak yapınız.

/*
        Given
            1) https://reqres.in/api/users/2
            2) {
                "name": "morpheus",
                "job": "zion president"
                }
        When
            I send Put Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "zion president",
                                                "updatedAt": "2022-10-02T11:35:05.693Z"
                                            }
*/

    @Test
    public void Homework03() {
        /*
        //1.Map ile:
        //Set the Url
        spec.pathParam("first","users");

        //Set the Expected Data
        RegresTestData obje=new RegresTestData();
        Map expectedData=obje.reqresMethodMap("morpheus","zion president");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
       Map<String,String> actualData=response.as(HashMap.class);
       assertEquals(201,response.statusCode());
       assertEquals(expectedData.get("name"),actualData.get("name"));
       assertEquals(expectedData.get("job"),actualData.get("job"));

       */

        //1.Pojo ile:
        //Set the Url
        spec.pathParam("first","users");

        //Set the Expected Data
        Reqres_Name_Job_Pojo expextedData=new Reqres_Name_Job_Pojo("morpheus","zion president");
        System.out.println("expextedData = " + expextedData);

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expextedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
       Reqres_Name_Job_Pojo actualData= response.as(Reqres_Name_Job_Pojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expextedData.getName(),actualData.getName());
        assertEquals(expextedData.getJob(),actualData.getJob());


    }
}


