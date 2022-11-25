package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static utils.Authentication.generateToken;

public class Get18 {

    @Test
    public void testName() {

        String url="https://www.medunna.com/api/appointments";

        Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(url);
        response.prettyPrint();


        JsonPath json=response.jsonPath();
        List<Integer>idler=json.getList("findAll{it.id}.id");
        System.out.println("idler = " + idler);


    }
}
