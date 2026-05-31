package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class AddMultipleProductsToCartTest extends BaseTest {

	@Test
	void verifyUserCanAddMultipleProductsToCart() throws InterruptedException{
		
		login("standard_user","secret_sauce");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		Thread.sleep(4000);
		
		String cartproductnum=driver.findElement(By.className("shopping_cart_badge")).getText();
		int cartItems=Integer.parseInt(cartproductnum);
		Assert.assertEquals(cartItems,2,"Items not added" );
		
		Thread.sleep(4000);
		
		
		driver.findElement(By.className("shopping_cart_link")).click();
		List<WebElement> cartProdName=driver.findElements(By.className("inventory_item_name"));
		
		Thread.sleep(4000);
		
		List<String> prodNames=new ArrayList<>();
		
		for(WebElement pname:cartProdName) {
			String name=pname.getText();
			prodNames.add(name);
		}
		
		
		System.out.println(prodNames);
		
		Assert.assertTrue(prodNames.contains("Sauce Labs Backpack"), "Backpack not found");
		Assert.assertTrue(prodNames.contains("Sauce Labs Bike Light"),"Bike Light not found");
		
		
		
		
		
	}
	
}
