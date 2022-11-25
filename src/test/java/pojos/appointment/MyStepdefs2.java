package pojos.appointment;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utils.Authentication.generateToken;

public class MyStepdefs2 {

    @Test
    public void testName() {

            /*
      "physician": {
        "id": 322856,
        "firstName": "DoktorCerrah",
        "lastName": "Elihafif",
     */

           String url="https://www.medunna.com/api/appointments/331516";


        Appointment_physician_user_Pojo user =new Appointment_physician_user_Pojo("anonymousUser","2022-11-22T10:40:49.325099Z",322573,"doktorcerrah",
                    "DoktorCerrah", "Elihafif","doktorcerrah@gmail.com",true,"en",null,null,"789-65-0123");
        Appointment_physician_country_Pojo country =new Appointment_physician_country_Pojo(77109,"The United Kingdom");

        Appointment_physician_Pojo physician =new Appointment_physician_Pojo("batch81","2022-11-22T10:49:08.677845Z",
                    322856,"DoktorCerrah","Elihafif","1979-11-21T21:00:00Z","123-456-7890","MALE","Apositive",
                    "Freway  Avue 123CE","",user,"ALLERGY_IMMUNOLOGY",country,null,300.00,"",null);

        Appointment_patient_user_Pojo patientUser=new Appointment_patient_user_Pojo("anonymousUser","2022-11-24T09:10:15.875634Z",330538,"haktan","Haktan",
                    "Herşey", "haktan@gmail.com",true,"en",null,null,"369-45-9862");
        Appointment_patient_country_Pojo patientCountry=new Appointment_patient_country_Pojo(77109,"The United Kingdom");

        Appointment_patient_Pojo patient=new Appointment_patient_Pojo("batch81","2022-11-22T10:49:08.677845Z",
                    322856,"DoktorCerrah","Elihafif","1979-11-21T21:00:00Z","123-456-7890","MALE","Apositive",
                    "Freway  Avue 123CE","haktan@gmal.com",null,patientUser,null,patientCountry,null);

        Appointment_Pojo appointments=new Appointment_Pojo("anonymousUser","2022-11-24T08:55:45.066245Z",331516,
                    "2022-11-24T00:00:00Z","2022-12-08T01:00:00Z","PENDING",null,null,
                    null,null,null,physician,patient,null);
            System.out.println("expectedData " + physician);


           Response response=given().headers("Authorization","Bearer "+generateToken()).when().get(url);
          //  response.prettyPrint();


            Appointment_Pojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),Appointment_Pojo.class);
            System.out.println("actualData = " + actualData);



            System.out.println("appointments = " + appointments);
            assertEquals(physician.getId(),actualData.getPhysician().getId());
            assertEquals(physician.getFirstName(),actualData.getPhysician().getFirstName());
            assertEquals(physician.getLastName(),actualData.getPhysician().getLastName());





    }
}
