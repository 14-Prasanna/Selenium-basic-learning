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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Self {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        // options.addArguments("--headless"); // optional

        WebDriver driver = new ChromeDriver(options);

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Action
        Actions action = new Actions(driver);

        // JS
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // URL of the application
        driver.get("https://demoblaze.com/");

        // ---------------- Question 1 Login ----------------

        driver.findElement(By.id("login2")).click();

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#loginusername")));

        username.sendKeys("admin");

        WebElement pass = driver.findElement(By.cssSelector("#loginpassword"));
        pass.sendKeys("admin");

        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement logout = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logout2")));

        String status = logout.getCssValue("display");
        if (status.equals("block")) {
            System.out.println("The user is logged in successfully");
        } else {
            System.out.println("The user is not logged in");
        }

        // ---------------- Question 2 Laptops ----------------

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

        if (exp.equals("MacBook Pro")) {
            System.out.println("The MacBook Pro is found");
        }

        // ---------------- Question 3 Add to Cart ----------------

        WebElement product1 = driver.findElement(By.xpath("//a[text()='MacBook Pro']"));
        action.moveToElement(product1).click().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='MacBook Pro']")));

        WebElement addToCartBtn = driver.findElement(By.xpath("//a[text()='Add to cart']"));
        addToCartBtn.click();

        // Alert Handling
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        System.out.println("Alert handled successfully.");

        System.out.println("Product added to cart");
        System.out.println("MacBook Pro added to cart.");

        WebElement cart = driver.findElement(By.xpath("//a[@id='cartur']"));
        cart.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']")));

        WebElement title = driver.findElement(By.xpath("//tbody[@id='tbodyid']//td[2]"));
        WebElement price = driver.findElement(By.xpath("//tbody[@id='tbodyid']//td[3]"));

        System.out.println("The product title: " + title.getText());
        System.out.println("The product price: " + price.getText());

        if (title.getText().equals("MacBook Pro")) {
            System.out.println("The title matches");
        } else {
            System.out.println("Title does not match");
        }

        if (price.getText().equals("1100")) {
            System.out.println("The price matches");
        } else {
            System.out.println("The price does not match");
        }

        // ---------------- Question 4 Place Order ----------------

        WebElement placeOrderBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Place Order']")));
        placeOrderBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModalLabel")));

        driver.findElement(By.id("name")).sendKeys("Prasanna");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Trichy");
        driver.findElement(By.id("card")).sendKeys("1234567890123456");
        driver.findElement(By.id("month")).sendKeys("04");
        driver.findElement(By.id("year")).sendKeys("2026");

        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        WebElement msg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='lead text-muted ']")));

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

        driver.quit();
    }
}
