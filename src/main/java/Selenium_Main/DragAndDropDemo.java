package Selenium_Main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/drag.xhtml");

		Actions act = new Actions(driver);
		
		WebElement source = driver.findElement(By.id("form:drag_content"));
		WebElement dest = driver.findElement(By.id("form:drop_header"));
		
//		act.dragAndDrop(source, dest).perform();
		
		WebElement horizontalDrag = driver.findElement(By.id("form:conpnl_header"));
		act.dragAndDropBy(horizontalDrag, 500, 0).perform();
	}

}
