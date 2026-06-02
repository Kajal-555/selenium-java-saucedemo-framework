package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class CheckoutTest extends BaseTest{
	
	@Test
	void verifyUserCanCheckoutSuccessfully(){
		
        login("standard_user","secret_sauce");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		String cartproductnum=driver.findElement(By.className("shopping_cart_badge")).getText();
		int cartItems=Integer.parseInt(cartproductnum);
		Assert.assertEquals(cartItems,2,"Items not added" );
		
		
		
		//  Checkout Information page
		driver.findElement(By.className("shopping_cart_link")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		String pageTitle=driver.findElement(By.className("title")).getText();
		
		Assert.assertEquals(pageTitle, "Checkout: Your Information", "User not navigated to Checkout Information page");
		
		
		
		//Checkout Overview page
		
		driver.findElement(By.id("first-name")).sendKeys("Kajal");
		driver.findElement(By.id("last-name")).sendKeys("Kothiyal");
		driver.findElement(By.id("postal-code")).sendKeys("45667");
		driver.findElement(By.id("continue")).click();

		String checkPageTitle=driver.findElement(By.className("title")).getText();
		Assert.assertEquals(checkPageTitle, "Checkout: Overview", "User not navigated to Checkout Overview page");
		driver.findElement(By.id("finish")).click();
		
		//Checkout Complete page
		
       String checkComTitle=driver.findElement(By.className("title")).getText();
		Assert.assertEquals(checkComTitle, "Checkout: Complete");
		String completePage=driver.findElement(By.className("complete-header")).getText();
		Assert.assertEquals(completePage, "Thank you for your order!", "User not navigated to Checkout Complete page");
	
		
		
	}

}
