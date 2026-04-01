package Selenium_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.Keys;
public class FlipkartDemo {
	public static void main(String[] args) {
		WebDriver driver = new  EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
//		WebElement search = driver.findElement(By.name("q"));
//		search.sendKeys("Samsung",Keys.ENTER);
		
		String title = driver.getTitle();
		System.out.println("page title is :"+ title +"Title length :"+title.length());
		
		System.out.println("page current url is :"+driver.getCurrentUrl());
		
		String page = driver.getPageSource();
		System.out.println("page page source is :"+ page +"Page length :"+ page.length());
		
		driver.close();
	}

}
