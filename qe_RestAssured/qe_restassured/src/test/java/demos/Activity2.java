package demos;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity2 {

    String baseURL = "https://petstore.swagger.io/v2";

    @Test(priority = 0)
    public void addUser() {

        // String reqBody = """
        // {
        // "id": 121,
        // "username": "virat18",
        // "firstName": "Virat",
        // "lastName": "Kohli",
        // "email": "virat18@gmail.com",
        // "password": "kohli_virat18",
        // "phone": "6678793667",
        // "userStatus": 0
        // }
        // """;

        // HashMap<String, Object> userData = new HashMap<>();
        // userData.put("id", 12038713);
        // userData.put("username", "abhiram");
        // userData.put("firstName", "Abhiram");
        // userData.put("lastName", "K");
        // userData.put("email", "abhiram@xyz.com");
        // userData.put("password", "hunter2");
        // userData.put("phone", 123980134);

        File jsonFile = new File("src/test/java/resources/input.json");

        // post method
        Response response = given().contentType(ContentType.JSON)
                .body(jsonFile).when().post(baseURL + "/user");
        response.then().statusCode(200);
        System.out.println(response.asPrettyString());
        System.out.println("This is  for the post method done");

    }

    @Test(priority = 1)
    public void gettUser() {

        Response response1 = given().contentType(ContentType.JSON)
                .pathParam("username", "virat18")
                .when().get(baseURL + "/user/{username}");

        System.out.println(response1.asPrettyString());
        System.out.println("This is  for the get method done");
        response1.then().statusCode(200);

    }

    @Test(priority = 2)
    public void deleteuser() {

        Response response2 = given().contentType(ContentType.JSON)
                .pathParam("username", "virat18")
                .when().delete(baseURL + "/user/{username}");

        System.out.println(response2.asPrettyString());
        System.out.println("This is  for the delete method done");
        response2.then().statusCode(200);
    }

}
