package examples.homeworks;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Reqres_DataPojo;
import pojos.Reqres_Name_Job_Pojo;
import test_data.RegresTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Homework2 extends ReqresBaseUrl {

//2:  Map ve Pojo Class ile ayrı ayrı yapınız.
/*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }


 */


    @Test
    public void homework2() {
        /*
      //1.ObjectMapper kullanarak Pojo Class ile:
        //Set the Url
        spec.pathParam("first","users");

        //Set the Expected Data
        Reqres_Name_Job_Pojo expectedData=new Reqres_Name_Job_Pojo("morpheus","leader");

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");

        //Do Assertion
       Reqres_Name_Job_Pojo actualdata=ObjectMapperUtils.convertJsonToJava(response.asString(),Reqres_Name_Job_Pojo.class);
        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getName(),actualdata.getName());
        assertEquals(expectedData.getJob(),actualdata.getJob());

         */

        //2.ObjectMapper kullanarak Map ile:
        //Set the Url
        spec.pathParam("first","users");

        //Set the Expected Data
        RegresTestData obj=new RegresTestData();
        String fakeExpectedInString=obj.dataInString("morpheus","leader");
        Map expecteddata=ObjectMapperUtils.convertJsonToJava(fakeExpectedInString, HashMap.class);
        System.out.println("expecteddata = " + expecteddata);

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expecteddata).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        Map actualdata=ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);
        System.out.println("actualdata = " + actualdata);
        assertEquals(201,response.statusCode());
        assertEquals(expecteddata.get("name"),actualdata.get("name"));
        assertEquals(expecteddata.get("job"),actualdata.get("job"));
/*
        //3.Pojo ile:

        spec.pathParam("1","users");

        Reqres_Name_Job_Pojo expectedDatas=new Reqres_Name_Job_Pojo("morpheus","leader");

        Response response1=given().spec(spec).contentType(ContentType.JSON).body(expectedDatas).when().post("/{1}");

        Reqres_Name_Job_Pojo actualDatas=response1.as(Reqres_Name_Job_Pojo.class);
        response1.then().assertThat().statusCode(201)
                .body("name",equalTo("morpheus"),
                        "job",equalTo("leader"));
     */

/*
        //4.Map ile:
        spec.pathParam("1","users");

        RegresTestData obij=new RegresTestData();
       Map<String,String> expected=obij.reqresMethodMap("morpheus","leader");
        System.out.println("expected = " + expected);

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expected).when().post("/{1}");
        response.prettyPrint();

       Map<String,String> actual=response.as(HashMap.class);
        System.out.println("actual = " + actual);

        response.then().assertThat().statusCode(201)
                .body("name",equalTo("morpheus"),
                        "job",equalTo("leader"));
*/
    }

}


























