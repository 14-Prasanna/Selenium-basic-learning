package Selenium_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Demo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/add-padding-to-containers.html");
        
        WebElement search = driver.findElement(By.xpath(null));

	}

}
