package Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class ValidLogin extends BaseTest {
	
	@Test
	void testValidLogin() {
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
		
		String pageTitle=driver.findElement(By.className("title")).getText();
		Assert.assertEquals(pageTitle,"Products","User didn't landed on Products Page");
		
		
		
		
		
	}

}
