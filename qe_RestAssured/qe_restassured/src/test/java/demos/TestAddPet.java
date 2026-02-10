package demos;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TestAddPet {

    String baseURL = "https://petstore.swagger.io/v2";

    @Test
    public void addNewPet() {

        String reqBody = """
                {
                "id": 677899,
                "name" : "Jonny",
                "status": "available"
                }
                """;

        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(baseURL + "/pet");

        System.out.println(response.asPrettyString());
        response.then().statusCode(200);

    }
}
