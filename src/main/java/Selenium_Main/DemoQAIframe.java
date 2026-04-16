package Selenium_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoQAIframe {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/frames");
		
		WebElement iframe = driver.findElement(By.id("frame1"));
		driver.switchTo().frame(iframe);
		
		String text1 = driver.findElement(By.id("sampleheading")).getText();
		System.out.println("text :"+text1);
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(0);
		String text2 = driver.findElement(By.id("sampleheading")).getText();
		System.out.println("text :"+text2);
		
		
		
		
	}

}
