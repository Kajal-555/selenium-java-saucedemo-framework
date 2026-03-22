package Testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class SortProductsByPriceLoHi extends BaseTest{

	@Test
	void verifyProductsSortedByPriceLowToHigh(){
		

	    // Step 1: Login to the application
	    login("standard_user","secret_sauce");

	    // Step 2: Select sorting option "Price (low to high)" from dropdown
	    Select sortDropdown = new Select(driver.findElement(By.className("product_sort_container")));
	    sortDropdown.selectByVisibleText("Price (low to high)");

	    // Step 3: Fetch all product price elements from the page
	    List<WebElement> priceElements = driver.findElements(By.className("inventory_item_price"));

	    // Step 4: Convert price text (e.g., "$9.99") into numeric values (Double)
	    List<Double> actualPrices = new ArrayList<>();

	    for(WebElement price : priceElements) {
	        String priceText = price.getText().replace("$", ""); // remove "$" symbol
	        actualPrices.add(Double.parseDouble(priceText));     // convert to number and store
	    }

	    // Step 5: Create a copy of the list and sort it in ascending order
	    List<Double> sortedPrices = new ArrayList<>(actualPrices);
	    Collections.sort(sortedPrices);

	    // Step 6: Verify that actual UI order matches expected sorted order
	    Assert.assertEquals(actualPrices, sortedPrices,
	            "Products are not sorted by price low to high");
	}
		
		
		
	}
	

