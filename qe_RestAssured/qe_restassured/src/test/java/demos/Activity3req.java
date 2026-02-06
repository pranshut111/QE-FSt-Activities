package demos;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity3req {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2/pet")
                .setContentType(ContentType.JSON)
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();
    }

    @DataProvider(name = "petData")
    public Object[][] petData() {
        return new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "available" }
        };
    }

    @Test(priority = 0, dataProvider = "petData")
    public void addPet(int id, String name, String status) {

        HashMap<String, Object> body = new HashMap<>();
        body.put("id", id);
        body.put("name", name);
        body.put("status", status);

        given()
                .spec(requestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(responseSpec);
    }

    @Test(priority = 1, dataProvider = "petData")
    public void getPet(int id, String name, String status) {

        given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .when()
                .get("/{petId}")
                .then()
                .spec(responseSpec)
                .body("name", equalTo(name))
                .body("status", equalTo(status));
    }

    @Test(priority = 2, dataProvider = "petData")
    public void deletePet(int id, String name, String status) {

        given()
                .spec(requestSpec)
                .pathParam("petId", id)
                .when()
                .delete("/{petId}")
                .then();
    }
}
