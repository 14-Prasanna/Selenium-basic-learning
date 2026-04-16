package Selenium_Main;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ControlWithKeyBoard {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		Actions act = new Actions(driver);
		
		WebElement keyControl = driver.findElement(By.linkText("compendiumdev"));
		act.keyDown(Keys.CONTROL).moveToElement(keyControl).click().keyUp(Keys.CONTROL).build().perform();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Count: "+allWindowHandles.size());

		for( String id : allWindowHandles) {
			driver.switchTo().window(id);
			System.out.println("ID :"+driver.getWindowHandle());
		}
	}

}
