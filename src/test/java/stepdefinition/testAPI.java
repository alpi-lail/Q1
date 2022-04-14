package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static  io.restassured.matcher.RestAssuredMatchers.*;
import static  org.hamcrest.Matchers.*;

public class testAPI {
    Response response = RestAssured.get("https://reqres.in/api/users?page=2");
    String responseBody;
    JSONObject request = new JSONObject();
    @Given("user hit endpoint get")
    public void endpointGet() {
       RestAssured.get("https://reqres.in/api/users?page=2");
       System.out.println("User navigate to hit endpoint");

    }

    @And("user validate status code")
    public void iValidateStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("User navigate to validate status code");
        System.out.println("Status Code : "+statusCode);
    }
    @Then("user validate email")
    public void iValidateEmail() {
      RestAssured.get("https://reqres.in/api/users?page=2").then().body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"));
      System.out.println("User navigate to validate email");
    }

    @Given("user hit endpoint create")
    public void endpointCreate() {
        RestAssured.post("https://reqres.in/api/users");
        request.put("name", "Alpi Lail");
        request.put("job", "pilot");
        System.out.println("User navigate to hit endpoint create");
    }

    @And("user validate status code create")
    public void iValidateStatusCodeCreate() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("User navigate to validate status code create");
        System.out.println("Status Code : "+statusCode);
    }
    @Then("user print id and jobs")
    public void iPrintIdAndJobs() {
        request.put("name", "Alpi Lail");
        request.put("job", "pilot");
        System.out.println("User navigate to print id and jobs");
        System.out.println(request);
    }
}
