package testsuite;

import Utility.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //  * Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        //* Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();

        //* Verify the text “PRODUCTS”
        verifyTextElement("Products", By.xpath("//span[contains(text(),'Products')]"));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //* Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //  * Enter “secret_sauce” password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // * Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        //* Verify that six products are displayed on page

        List<WebElement> image = driver.findElements(By.className("inventory_item"));
        System.out.println("The number of image is" + image.size());
        int expectedImage = 6;
        int actualImage = image.size();
        Assert.assertEquals("", expectedImage, actualImage);
    }

}
