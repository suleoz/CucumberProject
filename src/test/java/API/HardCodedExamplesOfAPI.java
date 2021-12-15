package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamplesOfAPI {

    // Given -precondition -prepare req
    //When -action- sending req / hitting the endpoint
    //Then - result-verify response

    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzkwMTAyODMsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzOTA1MzQ4MywidXNlcklkIjoiMzMyNiJ9.duEJa1jm9DT_lHmVjy7SaR-OXCdnDCfEtUsleelabJ8";
    static String employee_id;



    @Test
    public void acreateEmployee() {
        //GIVEN PART

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "        \"employee_id\": \"26001A\",\n" +
                        "        \"emp_firstname\": \"Mia\",\n" +
                        "        \"emp_middle_name\": \"G\",\n" +
                        "        \"emp_lastname\": \"Sabah\",\n" +
                        "        \"emp_birthday\": \"1990-12-04\",\n" +
                        "        \"emp_job_title\": \"BA\",\n" +
                        "        \"emp_status\": \"Employee\"\n" +
                        "    }");
        //WHEN PART
        Response response = preparedRequest.when().post("/createEmployee.php");

        //THEN PART
        response.prettyPrint();
        //this prettyprint does same as sout  System.out.println(response.asString());

        // jsonpath() we use this to get  specific
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        // then point
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Mavi"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }
@Test
    public void bgetCreatedEmployee() {

        //Given part
        RequestSpecification preparequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);
//when part
        Response response = preparequest.when().get("/getOneEmployee.php");
//then part
        String empId = response.jsonPath().getString("employee.employee_id");

      response.then().assertThat().body(empId, equalTo(employee_id));
//        boolean comparingEmpId =empId.contentEquals(employee_id);
//        Assert.assertTrue(comparingEmpId);

        String firstname=response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstname.contentEquals("Mia"));

        String lastname=response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastname.contentEquals("Sabah"));

    }
@Test
public void cupdateCreatedEmployee(){


    RequestSpecification preparedRequest = given().header("Authorization", token)
            .header("Content-Type", "application/json").body("    \"employee_id\":"+ employee_id +
                    "        \"emp_firstname\": \"Havi\",\n" +
                    "        \"emp_middle_name\": \"heyB\",\n" +
                    "        \"emp_lastname\": \"Dee2s\",\n" +
                    "        \"emp_gender\": \"F\",\n" +
                    "        \"emp_birthday\": \"2010-12-14\",\n" +
                    "        \"emp_job_title\": \"BA\",\n" +
                    "        \"emp_status\": \"Employee\"");


    Response response = preparedRequest.when().get("/updateEmployee.php");
}

    @Test
    public void dgetDetailOfOneEmployee() {
        //restassure consider base url as base uri

        //GIVEN PART
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", "25520A");

        //WHEN PART
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        //THEN PART== ASSERTION PART

        response.then().assertThat().statusCode(200);
    }
}