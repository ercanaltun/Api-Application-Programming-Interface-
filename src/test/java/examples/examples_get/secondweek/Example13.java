package examples.examples_get.secondweek;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Example13 extends DummyRestApiBaseUrl {

         /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language

           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    /*
    Given
         https://dummy.restapiexample.com/api/v1/employees

     Then
         HTTP Request Method: GET Request

     And
        HTTP Request Method: GET Request

     And
        ii) There are 24 employees

     And
        iii) "Airi Satou" and "Cedric Kelly " are among the employees

    And
       iv) The greatest age is 66   lowest age

    And
       v) The name of the lowest age is "Tatyana Fitzpatrick"

    And
       vi) Total salary of all employees is 6,644,770
     */

    @Test
    public void test13() {

        spec.pathParam("first","employees");

        Response response=given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        //i) Status code is 200
        assertEquals(200,response.statusCode());

        // ii) There are 24 employees
        List<String>employees =response.jsonPath().getList("data.findAll{it.id}.id");
        assertEquals(24,employees.size());

        //iii) "Airi Satou" and "Cedric Kelly " are among the employees
        response.then().body("data.employee_name",hasItems("Airi Satou","Cedric Kelly"));

        //iv) The greatest age is 66   lowest age
        List<Integer>employeeAges=response.jsonPath().getList("data.findAll{it.id}.employee_age");
        Collections.sort(employeeAges);
        System.out.println("employeeAges = " + employeeAges);
        assertEquals(66,(int)employeeAges.get(employeeAges.size()-1));

        //v) The name of the lowest age is "Tatyana Fitzpatrick"
        String lowestAgeEmployeeName=response.jsonPath().getString("data.findAll{it.employee_age=="+employeeAges.get(0)+"}.employee_name");
        System.out.println("lowestAgeEmployeeName = " + lowestAgeEmployeeName);
        assertEquals("[Tatyana Fitzpatrick]",lowestAgeEmployeeName);

       //vi) Total salary of all employees is 6,644,770
        List<Integer>employeeSalary=response.jsonPath().getList("data.findAll{it.id}.employee_salary");
        //1.Yol:
        Integer employeesalarySum=0;
        for (Integer w:employeeSalary
             ) {
            employeesalarySum +=w;
        }
        System.out.println("employeesalarySum = " + employeesalarySum);
        //2.Yol:
        Integer sum1=employeeSalary.stream().reduce(0,Integer::sum);

        //3.Yol:
        Integer sum2=employeeSalary.stream().reduce(0,Math::addExact);

        assertEquals(6644770,(int)employeesalarySum);

    }
}
