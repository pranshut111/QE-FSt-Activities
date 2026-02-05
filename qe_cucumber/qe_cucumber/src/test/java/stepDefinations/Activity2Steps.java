// package stepDefinations;

// import org.junit.jupiter.api.Assertions;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.ExpectedConditions;

// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;

// public class Activity2Steps extends Base {

//     @Given("the user is on the login page")
//     public void userIsOnLoginPage() {
//         driver.get("https://training-support.net/webelements/login-form");
//         wait.until(ExpectedConditions.titleContains("Login"));
//     }

//     @When("the user enters username and password")
//     public void enterUsernameAndPassword() {
//         WebElement username = driver.findElement(By.id("username"));
//         WebElement password = driver.findElement(By.id("password"));

//         username.sendKeys("admin");
//         password.sendKeys("password");
//     }

//     @And("clicks the submit button")
//     public void clickSubmitButton() {
//         driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/form/button")).click();
//     }

//     @Then("get the confirmation message and verify it")
//     public void verifyConfirmationMessage() {
//         WebElement message = wait.until(
//                 ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/main/div/div/div/div/div"))
//         );

//         String confirmationText = message.getText();
//         Assertions.assertTrue(
//                 confirmationText.contains("Welcome"),
//                 "Login confirmation message not displayed"
//         );

//         System.out.println("Confirmation Message: " + confirmationText);
//     }
// }
