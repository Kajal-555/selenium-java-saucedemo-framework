package Testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class AddSingleProductToCart extends BaseTest{
	
	@Test
	void verifyUserCanAddSingleProductToCart() {
		
		login("standard_user","secret_sauce");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		//checking Button Text Change
		WebElement button=driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")); 
		String buttonText=button.getText();
		Assert.assertEquals(buttonText, "Remove", "Product not added to Cart");
		
		//Checking Cart Badge Count
        String ItemNos=driver.findElement(By.className("shopping_cart_badge")).getText();
		int cartItemNo=Integer.parseInt(ItemNos);		
		Assert.assertEquals(cartItemNo, 1,"Item not added to cart");
		
		//checking correct product added to cart
		driver.findElement(By.className("shopping_cart_link")).click();
		
		WebElement productName = driver.findElement(By.className("inventory_item_name"));
		String actualName = productName.getText();

		Assert.assertEquals(actualName, "Sauce Labs Bolt T-Shirt", "Incorrect product in cart");
		
		
		
	}
	

}
