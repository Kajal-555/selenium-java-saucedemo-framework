package Testcases;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;

public class LockedOutUserLogin extends BaseTest{

	@Test
	void verifyLockedOutUserCannotLogin() {
	driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
		
		
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		driver.findElement(By.id("login-button")).click();
	
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		String errmsg=wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message-container"))).getText();
			//String errmsg=driver.findElement(By.className("error-message-container")).getText();
		
		Assert.assertTrue(errmsg.contains("locked out"),
		        "Proper error message is not displayed for invalid login");
	}
}
