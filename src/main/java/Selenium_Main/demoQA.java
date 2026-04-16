package Selenium_Main;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoQA {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/browser-windows");
		String parent = driver.getWindowHandle();
		System.out.println("Parent Unique Code: "+parent);
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Count: "+allWindowHandles.size());
		
		WebElement windowButton = driver.findElement(By.id("windowButton"));
		windowButton.click();
		
		Set<String> newallWindowHandles = driver.getWindowHandles();
		System.out.println("Count of Window: "+newallWindowHandles);
		System.out.println("Count: "+newallWindowHandles.size());
		
		Iterator<String> iterator = newallWindowHandles.iterator();
		String parentWindow = iterator.next();
		String child = iterator.next();
		driver.switchTo().window(child);
		
		WebElement text = driver.findElement(By.xpath("//h1[contains(@id,'sampleHeading')]"));
		
		System.out.println("Text: "+text.getText());
		
		driver.switchTo().window(parentWindow);
		
		WebElement tabWindow = driver.findElement(By.id("tabButton"));
		tabWindow.click();
		
		
	}

}