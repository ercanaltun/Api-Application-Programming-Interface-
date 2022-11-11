package examples.homeworks;

import base_url.Petstore_SwaggerBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.PetStore_Swagger_Pojo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Homework5 extends Petstore_SwaggerBaseUrl {

    //5:
    /*  NOT:Otomasyonda Post ve Put yapılamıyor.Ancak Swagger ve Postman de
            Post(create) yaptıktan sonra intelij de Get yapabiliriz.
    https://petstore.swagger.io/ documantation adresini kullanarak
    'user' oluşturan ve oluşan bu user'ı silen bir otomasyon kodu yazınız.

    1:Set the Post like following=>
                                    {
                                    "username": "ercan01",
                                    "firstName": "ercan",
                                    "lastName": "altın",
                                    "email": "ercan@gfh.com",
                                    "password": "12345",
                                    "phone": "123654789",
                                    }
    2:statusCode should be 201

    3:Response look like following=>
                                  {
                                    "id": 9223372000001105865,
                                    "username": "ercan01",
                                    "firstName": "ercan",
                                    "lastName": "altın",
                                    "email": "ercan@gfh.com",
                                    "password": "12345",
                                    "phone": "123654789",
                                    "userStatus": 0
                                  }

    */

    @Test
    public void homework5(){

        //1.Step:Set the Url
          spec.pathParams("first","user");

        //2.Step:Set the Expected Data(Payload)
        PetStore_Swagger_Pojo expecteddataPojo=new PetStore_Swagger_Pojo("ercan01",
          "salih","selim","ercan@gfh.com","12345","123654789");
        System.out.println("expecteddataPojo = " + expecteddataPojo);

        //3.Step:Send the Request and Get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expecteddataPojo).when().post("/{first}");
        response.prettyPrint();

        //4.Step:Do Assertion
        PetStore_Swagger_Pojo actualDataPojo=response.as(PetStore_Swagger_Pojo.class);
        System.out.println("actualDataPojo = " + actualDataPojo);

        assertEquals(201,response.statusCode());
        assertEquals(expecteddataPojo.getFirstName(),actualDataPojo.getFirstName());
        assertEquals(expecteddataPojo.getLastName(),actualDataPojo.getLastName());
        assertEquals(expecteddataPojo.getEmail(),actualDataPojo.getEmail());
        assertEquals(expecteddataPojo.getPassword(),actualDataPojo.getPassword());
        assertEquals(expecteddataPojo.getPhone(),actualDataPojo.getPhone());


    }
   @Test
   public void homework5Delete() {
       spec.pathParams("first","user","second","ercan01");
       Map<String,String>expectedData=new HashMap<>();
       Response response1=given().spec(spec).contentType(ContentType.JSON).when().delete("/{first}/{second}");
       System.out.println("response1 = " + response1);
       assertEquals(404,response1.statusCode());
       Map<String,String>actualData=response1.as(HashMap.class);
       assertTrue(actualData.isEmpty());
   }

}
