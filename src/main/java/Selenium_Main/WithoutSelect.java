package Selenium_Main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithoutSelect {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.leafground.com/select.xhtml");

        String[] value = {"JMeter", "AWS"};

        for (String e1 : value) {

            
            WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='j_idt87:auto-complete']/button")
            ));
            btn.click();

           
            WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[@id='j_idt87:auto-complete_panel']/ul/li[text()='" + e1 + "']")
            ));

            action.moveToElement(option).click().perform();
            System.out.println(e1 + " Clicked");
        }
        

        
    }
}