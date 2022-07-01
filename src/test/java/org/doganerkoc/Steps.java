package org.doganerkoc;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver = new ChromeDriver();
    @Given("Browser is open")
    public void browser_is_open() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @And("User is on {string} page")
    public void user_is_on_page(String url) {
        driver.get(url);
    }

    @When("User clicks on sign in")
    public void user_clicks_on_sign_in(){
        driver.findElement(By.className("login")).click();
    }

    @And("User login with valid credentials")
    public void user_login() {
        driver.findElement(By.id("email")).sendKeys("merkoc71.on@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Ankara12.");
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("User logged in successfully")
    public void successful(){
        assertTrue("User not logged in",driver.findElement(By.className("account")).isDisplayed());
    }

    @Then("Women category is open")
    public void category_women_opened(){
        driver.findElement(By.linkText("Women")).click();
    }

    @Then("Tops and Dresses categories seen")
    public void categories_seen(){
        assertTrue("Tops category not seen",driver.findElement(By.xpath("//a[@class='subcategory-name' and text()='Tops']")).isDisplayed());
        assertTrue("Dresses category not seen",driver.findElement(By.xpath("//a[@class='subcategory-name' and text()='Dresses']")).isDisplayed());
    }

    @Then("Go to 5th product on the list")
    public void go_to_5th_product(){
        driver.findElement(By.xpath("(//a[@class='product-name'])[6]")).click();
    }

    @Then("Add 3 times")
    public void add_3_times(){
        for(int i=0; i<2; i++){
            driver.findElement(By.className("icon-plus")).click();
        }
    }

    @Then("Add to cart")
    public void add_to_cart(){
        driver.findElement(By.xpath("//button[@class='exclusive']")).click();
    }

    @Then("Proceed to checkout")
    public void proceed_to_checkout(){
        driver.findElement(By.linkText("Proceed to checkout")).click();
    }

    @Then("Check Total {string}, Total Products {string} and Quantity {string}")
    public void check_results(String total, String total_products, String quantity){
        assertEquals("Total is wrong",total.trim(), driver.findElement(By.id("total_product_price_5_19_716333")).getText());
        assertEquals("Total Product is wrong",total_products.trim(), driver.findElement(By.id("total_product")).getText());
        assertEquals("Quantity is wrong",quantity.trim(), driver.findElement(By.xpath("//input[contains(@class,'cart_quantity_input')]")).getAttribute("value"));
    }

}
