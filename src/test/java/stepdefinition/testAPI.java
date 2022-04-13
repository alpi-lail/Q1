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
    @Given("I open URL")
    public void iOpenUrl() {
       RestAssured.get("https://reqres.in/api/users?page=2");

    }

    @And("I validate status code")
    public void iValidateStatusCode() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("Status Code : "+statusCode);
    }
    @Then("I validate email")
    public void iValidateEmail() {
      RestAssured.get("https://reqres.in/api/users?page=2").then().body("data.email[1]", equalTo("lindsay.ferguson@reqres.in"));

    }

    @Given("I hit base URI")
    public void baseURI() {
        RestAssured.post("https://reqres.in/api/users");
        request.put("name", "Alpi Lail");
        request.put("job", "pilot");
    }

    @And("I validate status code create")
    public void iValidateStatusCodeCreate() {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        System.out.println("Status Code : "+statusCode);
    }
    @Then("I print id and jobs")
    public void iPrintIdAndJobs() {
        request.put("name", "Alpi Lail");
        request.put("job", "pilot");
        System.out.println(request);
    }
}
