package Selenium_Main;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		
		Select select = new Select(driver.findElement(By.className("ui-selectonemenu")));
//		select.selectByVisibleText("doc 2");
//		select.selectByIndex(1);
//		select.selectByValue();
		
//		select.deselectByIndex(1);
//		select.selectByContainsVisibleText("Play");
		List<WebElement> list = select.getOptions();
		
		for(WebElement e : list) {
			System.out.println(e.getText());
		}
		
	}

}
