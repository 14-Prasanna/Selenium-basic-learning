package Selenium_Main;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver(); 
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.manage().window().maximize();
        driver.get("https://demoblaze.com/index.html");
        
        
        
        WebElement log_in = driver.findElement(By.xpath("//input[contains(@id,\"sign-username\")]"));
        log_in.click();
        
        
        WebElement username_wait = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername"))) ;
        username_wait.sendKeys("admin");
        
        WebElement password = driver.findElement(By.xpath("input[contains(@id,\\\\\\\"sign-username\\\\\\\")]\\"));
        password.sendKeys("admin");
        
        
        
        
        
        
        
        
        
        

	}

}
