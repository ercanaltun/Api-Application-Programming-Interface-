package examples.examplespojo;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Reqres_DataPojo;
import pojos.Reqres_ResponsePOjo;
import pojos.Reqres_SupportPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetPojo_Reqres extends ReqresBaseUrl {
/*
{
   {
    "data": {
        "id": 1,
        "email": "george.bluth@reqres.in",
        "first_name": "George",
        "last_name": "Bluth",
        "avatar": "https://reqres.in/img/faces/1-image.jpg"
    },
    "support": {
        "url": "https://reqres.in/#support-heading",
        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    }
}
 */
    @Test
    public void test01() {

        //Set the Url
        spec.pathParams("first","users","second",1);

        //Set the Expected Data
        Reqres_DataPojo reqresDataPojo=new Reqres_DataPojo(1,"george.bluth@reqres.in","George","Bluth","https://reqres.in/img/faces/1-image.jpg");
        Reqres_SupportPojo reqresSupportPojo=new Reqres_SupportPojo("https://reqres.in/#support-heading","To keep ReqRes free, contributions towards server costs are appreciated!");
        Reqres_ResponsePOjo expectedData=new Reqres_ResponsePOjo(reqresDataPojo,reqresSupportPojo);
        System.out.println("expectedData = " + expectedData);

        //Send the Requet and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Reqres_ResponsePOjo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(),Reqres_ResponsePOjo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(reqresDataPojo.getId(),actualData.getData().getId());
        assertEquals(reqresDataPojo.getFirst_name(),actualData.getData().getFirst_name());
        assertEquals(reqresDataPojo.getLast_name(),actualData.getData().getLast_name());
        assertEquals(reqresDataPojo.getAvatar(),actualData.getData().getAvatar());
        assertEquals(reqresSupportPojo.getUrl(),actualData.getSupport().getUrl());
        assertEquals(reqresSupportPojo.getText(),actualData.getSupport().getText());

    }
}
