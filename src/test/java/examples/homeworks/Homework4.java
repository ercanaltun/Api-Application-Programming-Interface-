package examples.homeworks;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Reqres_Name_Pojo;
import test_data.RegresTestData;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Homework4 extends ReqresBaseUrl {

    //4: Map ile ve Pojo Class ile ayrı ayrı Object Mapper kullanarak yapınız.
  /*
       Given
           1) https://reqres.in/api/users/2
           2) {
                "name": "neo"
               }
       When
            I send PATCH Request to the Url
       Then
             Status code is 200
             And response body is like   {
                                                "name": "neo",
                                                "updatedAt": "2022-10-02T12:53:21.675Z"
                                         }
    */

    @Test
    public void Homework04() {
        /*
        //1.ObjectMapper kulanarak Map ile yapma:
        //Set the Url
        spec.pathParams("first","users","second",2);

        //Set the Expected Data
        RegresTestData obje=new RegresTestData();
       String dataInString=obje.TekParametreliDataInString("neo");
       Map expectedData=ObjectMapperUtils.convertJsonToJava(dataInString,Map.class);
        System.out.println("expectedData = " + expectedData);

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
      Map actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("name"),actualData.get("name"));

        */

        //2.ObjectMapper kulaanarak Pojo Class ile yapma:
        //Set the Url
        spec.pathParams("first","users","second",2);

        //Set the Expected Data
        Reqres_Name_Pojo expectedData=new Reqres_Name_Pojo("neo");
        System.out.println("expectedData = " + expectedData);

        //Send the Request and get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().patch("/{first}/{second}");

        //Do Assertion

        Reqres_Name_Pojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),Reqres_Name_Pojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getName(),actualData.getName());

    }
}
