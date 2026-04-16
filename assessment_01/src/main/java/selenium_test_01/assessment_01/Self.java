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


public class Self {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		// Action 
		Actions action = new Actions(driver);
		
		// Js
		JavascriptExecutor js = (JavascriptExecutor )driver;
		
		// URL of the application
		driver.get("https://demoblaze.com/");
		
		
		
		/*/ Question 1 :     Login to the Application (5 Marks)
			Scenario
				• Navigate to the application.
				• Click on the Login link.
				• Enter valid username and password.
				• Click the Login button.
		Validation
				• Verify successful login by checking:
				o User greeting message OR
				o Presence of a home page element
		Expected Output
				System.out.println("Login Successful");/*/
		
		
			driver.findElement(By.id("login2")).click();
			
			WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(
			        By.cssSelector("#loginusername")));

			username.sendKeys("admin");
			
			WebElement pass = driver.findElement(By.cssSelector("#loginpassword"));
			pass.sendKeys("admin");
			
			driver.findElement(By.xpath("//button[text() = \"Log in\"]")).click();
			
			WebElement logout = wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("#logout2")));
			
			String status = logout.getCssValue("display");
			if(status.equals("block")){
				System.out.println("The user is logged in successfully");
			}
			else {
				System.out.println("The user is not logged in");
			}
			
			/*/
			 * Question 2: Category Navigation & Product Handling (10 Marks)
			   Scenario
					• After login:
					o Navigate to Laptops category.
					o Retrieve all available laptops.
					o Sort products in ascending order.
					o Store results in a Set.
				o Use:
					▪ Action Class
					▪ JavaScript Executor
					• Scroll to MacBook Pro and verify its title. 
			 * 
			 */
			
			WebElement laptops = wait.until(
			        ExpectedConditions.elementToBeClickable(By.linkText("Laptops")));
			action.moveToElement(laptops).click().perform();

			wait.until(ExpectedConditions.textToBePresentInElementLocated(
			        By.cssSelector(".card-title a"), "Sony vaio"));


			List<WebElement> products = driver.findElements(By.cssSelector(".card-title a"));

			List<String> productList = new ArrayList<>();
			for (WebElement product : products) {
			    productList.add(product.getText());
			}

			Collections.sort(productList);
			
			System.out.println("The sorted laptops");
			Set<String> laptopSet = new LinkedHashSet<>(productList);
			for (String name : laptopSet) {
				System.out.println(name);

			}
			
			WebElement macBook = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
			js.executeScript("arguments[0].scrollIntoView(true);", macBook);
			
			String exp = macBook.getText();
			
			if(exp.equals("MacBook Pro")) {
				System.out.print("The Mac book is founded");
			}
			
			/*/
			 * Question 3: Add Product to Cart (5 Marks)
				Scenario
					• Select MacBook Pro.
					• Click Add to Cart.
					• Navigate to Cart page.
				Validation
					• Verify:
					o Product Title
					o Product Price
				Expected Output
					System.out.println("Product added to cart");
					System.out.println("MacBook Pro added to cart.");

			 */
			
			WebElement product1 = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
			action.moveToElement(product1).click().perform();
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='MacBook Pro']")));

			
			WebElement addToCartBtn = driver.findElement(By.xpath("//a[text()='Add to cart']"));
			addToCartBtn.click();

			// 5 question answer
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			System.out.println("Alert handled successfully.");

			System.out.println("Product added to cart");
			System.out.println("MacBook Pro added to cart.");
			
			WebElement cart = driver.findElement(By.xpath("//a[@id= 'cartur']"));
			cart.click();
			
			
			WebElement details = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id = 'tbodyid']")));
			
			WebElement title = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']//td[2]"));
			
			WebElement price = driver.findElement(By.xpath("//tbody[@id = 'tbodyid']//td[3]"));
			
			System.out.print("The product tile " + title.getText());
			System.out.print("The product price " + price.getText());
			
			if((title.getText() ).equals("MacBook Pro")) {
				System.out.print("The tilte matches");
			}
			else {
				System.out.println("Does not match");
			}
			
			if((price.getText()).equals("1100")) {
				System.out.println("The price matches");
			}
			else {
				System.out.println("The prices does not matches");
			}
			
			
			/*/
			 * Question 4: Place Order (5 Marks)
				Scenario
					• Navigate to Cart.
					• Click Place Order.
					• Fill all required details.
					• Click Purchase.
				Validation
					if (purchase.contains("Order Id")) {
 						System.out.println("Order is placed successfully");
 						// Print Order ID, Amount, Date
					} else {
 						System.out.println("Order is Unsuccessful");
					}
			 */
			
			WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
			placeOrderBtn.click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModalLabel")));
			
			driver.findElement(By.id("name")).sendKeys("Prasanna");
			driver.findElement(By.id("country")).sendKeys("India");
			driver.findElement(By.id("city")).sendKeys("Trichy");
			driver.findElement(By.id("card")).sendKeys("1234567890123456");
			driver.findElement(By.id("month")).sendKeys("04");
			driver.findElement(By.id("year")).sendKeys("2026");

			driver.findElement(By.xpath("//button[text()='Purchase']")).click();
			
			
			WebElement msg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='lead text-muted ']")));

			String pur = msg.getText();

			if (pur.contains("Id:")) {
				System.out.println("Order is placed successfully");

				
				String[] detail = pur.split("\n");

				for (String line : detail) {
					if (line.contains("Id:") || line.contains("Amount:") || line.contains("Date:")) {
						System.out.println(line);
					}
				}

			} else {
				System.out.println("Order is Unsuccessful");
			}

			
			driver.findElement(By.xpath("//button[text()='OK']")).click();
			
			
			/*/
			 * Question 5: Alert Handling (5 Marks)
			   Scenario
					• Handle alert pop-ups wherever they appear.
				Validation
					System.out.println("Alert handled successfully.");
			 */
			
			
			// alert is only present in the add to cart is not handle properly in the 3 question
			
			
			driver.close();
	}

}
