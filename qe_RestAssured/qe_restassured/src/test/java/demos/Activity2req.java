package demos;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2req {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2/user")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test(priority = 0)
    public void addUser() {

        File jsonFile = new File("src/test/java/resources/input.json");

        // post method
        Response response = given().spec(requestSpec)
                .body(jsonFile).when().post();

        System.out.println(response.asPrettyString());
        response.then().spec(responseSpec);

        System.out.println("This is  for the post method done");

    }

    @Test(priority = 1)
    public void gettUser() {

        Response response = given().spec(requestSpec)
                .pathParam("username", "virat18")
                .when().get("/{username}");

        System.out.println(response.asPrettyString());
        response.then().spec(responseSpec);
        System.out.println("This is  for the get method done");

    }

    @Test(priority = 2)
    public void deleteuser() {

        Response response = given().spec(requestSpec)
                .pathParam("username", "virat18")
                .when().delete("/{username}");

        System.out.println(response.asPrettyString());
        response.then().spec(responseSpec);
        System.out.println("This is  for the delete method done");

    }

}
