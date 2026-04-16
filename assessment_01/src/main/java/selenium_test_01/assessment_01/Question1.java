package selenium_test_01.assessment_01;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Question1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Action Class
		Actions act = new Actions(driver);

		// JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.get("https://demoblaze.com/");
		System.out.println("The application is launched successfully");

		driver.findElement(By.xpath("//a[@id='login2']")).click();

		WebElement login = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@id='loginusername']")));
		login.sendKeys("admin");

		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("admin");
		driver.findElement(By.xpath("//button[text() = 'Log in']")).click();

		WebElement log = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout2")));

		String value = log.getCssValue("display");

		if (value.equals("block")) {
			System.out.println("Successfully Logged In");
		} else {
			System.out.println("Not login");
		}

		// Navigate to Laptops Category using Actions
		WebElement laptopsCategory = driver.findElement(By.xpath("//a[text() = 'Laptops']"));
		act.moveToElement(laptopsCategory).click().perform();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='tbodyid']/div")));

		Thread.sleep(3000);


		List<WebElement> laptops = driver.findElements(By.xpath("//div[@id='tbodyid']/div"));


		List<String> laptopNames = new ArrayList<>();

		for (WebElement lap : laptops) {
			laptopNames.add(lap.getText());
		}

		Collections.sort(laptopNames);

		Set<String> laptopSet = new LinkedHashSet<>(laptopNames);
		for (String name : laptopSet) {
			System.out.println(name);

		}

		// Scroll to MacBook Pro using JavaScript Executor /// AI used
		WebElement macBook = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
		js.executeScript("arguments[0].scrollIntoView(true);", macBook);

		Thread.sleep(2000);


		String productTitle = macBook.getText();

		if (productTitle.equals("MacBook Pro")) {
			System.out.println("Found Laptop: " + productTitle);
		} else {
			System.out.println("MacBook Pro Not Found");
		}


		// Question 3: Add Product to Cart

		// Click MacBook Pro
		WebElement macBook1 = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
		macBook1.click();

		// Wait product page load
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='MacBook Pro']")));

		// Click Add to cart
		WebElement addToCartBtn = driver.findElement(By.xpath("//a[text()='Add to cart']"));
		addToCartBtn.click();

		// Handle Alert
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();

		System.out.println("Product added to cart");
		System.out.println("MacBook Pro added to cart.");


		WebElement cart = driver.findElement(By.xpath("//a[@id= 'cartur']"));
		cart.click();



		// AI
		// Wait until Cart page loads
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Products']")));

		// Click Place Order
		WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
		placeOrderBtn.click();

		// Wait for Order Modal popup
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));

		// Fill all required details
		driver.findElement(By.id("name")).sendKeys("Prasanna");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Trichy");
		driver.findElement(By.id("card")).sendKeys("1234567890123456");
		driver.findElement(By.id("month")).sendKeys("04");
		driver.findElement(By.id("year")).sendKeys("2026");

		// Click Purchase
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();

		// Wait for success message
		WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='lead text-muted ']")));

		String purchase = successMsg.getText();

		if (purchase.contains("Id:")) {
			System.out.println("Order is placed successfully");

			// Print Order ID, Amount, Date
			String[] details = purchase.split("\n");

			for (String line : details) {
				if (line.contains("Id:") || line.contains("Amount:") || line.contains("Date:")) {
					System.out.println(line);
				}
			}

		} else {
			System.out.println("Order is Unsuccessful");
		}

		// Click OK button
		driver.findElement(By.xpath("//button[text()='OK']")).click();


		driver.quit();
	}
}