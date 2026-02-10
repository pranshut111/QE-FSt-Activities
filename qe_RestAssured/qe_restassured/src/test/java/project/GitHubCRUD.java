package project;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GitHubCRUD {

    RequestSpecification requestSpec;

    String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFOFtFL+539X+Lx/RwrSDIrrSsT7mfDVRdnOlU68eqZH azuread\\pranshutiwari@IBM-HTLR8F4";

    int keyId;

    @BeforeClass
    public void setup() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "token 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/////////")
                .build();
    }

    @Test(priority = 1)
    public void addSSHKey() {

        HashMap<String, String> reqBody = new HashMap<>();
        reqBody.put("title", "TestAPIKey");
        reqBody.put("key",
                "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFOFtFL+539X+Lx/RwrSDIrrSsT7mfDVRdnOlU68eqZH azuread\\pranshutiwari@IBM-HTLR8F4///////");

        // String requestBody = """
        // {
        // "title": "TestAPIKey",
        // "key": "ssh-ed25519
        // AAAAC3NzaC1lZDI1NTE5AAAAIFOFtFL+539X+Lx/RwrSDIrrSsT7mfDVRdnOlU68eqZH
        // azuread\\pranshutiwari@IBM-HTLR8F4"
        // }
        // """;

        Response response = given()
                .log().all()
                .spec(requestSpec)
                .body(reqBody)
                .when()
                .post("/user/keys");

        response.then().log().all();

        response.then().statusCode(201);

        keyId = response.then().extract().path("id");
        Reporter.log("SSH Key created with ID: " + keyId, true);
        Assert.assertTrue(keyId > 0);
    }

    @Test(priority = 2)
    public void getSSHKey() {

        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .get("/user/keys/{keyId}");

        response.then().statusCode(200);
        Reporter.log(response.asPrettyString(), true);
    }

    @Test(priority = 3)
    public void deleteSSHKey() {

        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .delete("/user/keys/{keyId}");

        response.then().statusCode(204);
        Reporter.log("SSH Key deleted successfully", true);
    }
}
