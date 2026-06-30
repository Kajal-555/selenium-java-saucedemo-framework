package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class CheckoutValidationTest extends BaseTest {

    @Test
    public void verifyCheckoutFailsWhenFirstNameIsMissing() {

        // Login
        login("standard_user", "secret_sauce");

        // Add a product
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        // Verify cart badge
        String cartCount = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(cartCount, "1", "Product was not added to cart");

        // Navigate to cart
        driver.findElement(By.className("shopping_cart_link")).click();

        // Checkout
        driver.findElement(By.id("checkout")).click();

        // Leave First Name blank
        driver.findElement(By.id("last-name")).sendKeys("Kothiyal");
        driver.findElement(By.id("postal-code")).sendKeys("201310");

        // Continue
        driver.findElement(By.id("continue")).click();

        // Verify error message
        String errorMessage = driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(
                errorMessage.contains("First Name is required"),
                "Expected validation message for missing first name is not displayed");
    }
}