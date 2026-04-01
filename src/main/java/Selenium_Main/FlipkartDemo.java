package Selenium_Main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartDemo {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver(); // Chrome instead of Edge

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        String title = driver.getTitle();
        System.out.println("Page title is: " + title + " | Title length: " + title.length());

        System.out.println("Page current URL is: " + driver.getCurrentUrl());

        String page = driver.getPageSource();
        System.out.println("Page length: " + page.length());

        driver.quit(); // better than close()
    }
}