package stepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Activity3Steps extends Base {

    WebDriver driver;
    Alert alert;

    @Given("User is on the page")
    public void user_is_on_the_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://training-support.net/webelements/alerts");
    }

    @When("User clicks the Simple Alert button")
    public void user_clicks_simple_alert() {
        driver.findElement(By.id("simple")).click();
    }

    @When("User clicks the Confirm Alert button")
    public void user_clicks_confirm_alert() {
        driver.findElement(By.id("confirmation")).click();
    }

    @When("User clicks the Prompt Alert button")
    public void user_clicks_prompt_alert() {
        driver.findElement(By.id("prompt")).click();
    }

    @Then("Alert opens")
    public void alert_opens() {
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void read_alert_text() {
        System.out.println("Alert text: " + alert.getText());
    }

    @And("Write {string} in the alert")
    public void write_in_prompt(String message) {
        alert.sendKeys(message);
    }

    @And("Close the alert")
    public void close_alert() {
        alert.accept();
    }

    @And("Read the result text")
    public void read_result_text() {
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result: " + result);
        driver.quit();
    }
}