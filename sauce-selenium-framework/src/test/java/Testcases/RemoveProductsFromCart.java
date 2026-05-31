package Testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class RemoveProductsFromCart extends BaseTest{
	@Test
	void verifyUserCanRemoveProductsFromCart() {
		
		login("standard_user","secret_sauce");
		
		driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		String prodNum=driver.findElement(By.className("shopping_cart_badge")).getText();
		Integer itemNum=Integer.parseInt(prodNum);
		Assert.assertEquals(itemNum,2,"Items not added");
		
		//Removing the Bike Light from Cart
		driver.findElement(By.className("shopping_cart_link")).click();
		driver.findElement(By.id("remove-sauce-labs-bike-light")).click();
		
		
		//check Badge count
		prodNum=driver.findElement(By.className("shopping_cart_badge")).getText();
		itemNum=Integer.parseInt(prodNum);
		Assert.assertEquals(itemNum,1,"Items not removed");
		
		List<WebElement> itemNames=driver.findElements(By.className("inventory_item_name"));
		List<String> prodName=new ArrayList<>();
		
		for(WebElement names:itemNames) {
			String items=names.getText();
			prodName.add(items);
		}
		
		Assert.assertFalse(prodName.contains("Sauce Labs Bike Light"), "Item still in cart");
		
		Assert.assertTrue(prodName.contains("Sauce Labs Backpack"), "Remaining Item not in cart");
		
		
		
		
		
		
	}

}
