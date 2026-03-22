package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop=new Properties();
	public static FileReader fr;
	@BeforeMethod
	public void setup() throws IOException{
		if(driver==null) {
			//FileReader fr=new FileReader("C:\\Eclipse-workspace\\Sauce\\sauce-selenium-framework\\src\\main\\resources\\config.properties");
			String path = System.getProperty("user.dir") +
			        "\\src\\main\\resources\\config.properties";

			FileReader fr = new FileReader(path);
			prop.load(fr);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop.getProperty("baseUrl"));				
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("baseUrl"));
		}
		
	}
	
	public void login(String username, String password) {

	    driver.findElement(By.id("user-name")).sendKeys(username);
	    driver.findElement(By.id("password")).sendKeys(password);
	    driver.findElement(By.id("login-button")).click();
	}
	
	@AfterMethod
	public void teardown() {
		if(driver!=null) {
			driver.quit();
			System.out.println("Teardown Successful");
		}
	}
	
	
	
	
}
