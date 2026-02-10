package demos;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity1 {

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

        // post method
        Response response = given().contentType(ContentType.JSON)
                .body(reqBody).when().post(baseURL + "/pet");
        System.out.println("This is  for the post method done");
        System.out.println(response.asPrettyString());
        response.then().statusCode(200);

        // Get method
        Response response1 = given().contentType(ContentType.JSON)
                .pathParam("petId", 677899)
                .when().get(baseURL + "/pet/{petId}");
        System.out.println("This is  for the get method done");
        System.out.println(response1.asPrettyString());

        // Delete method
        Response response2 = given().contentType(ContentType.JSON)
                .pathParam("petId", 677899)
                .when().delete(baseURL + "/pet/{petId}");
        System.out.println("This is  for the delete method done");
        System.out.println(response2.asPrettyString());

    }
}
