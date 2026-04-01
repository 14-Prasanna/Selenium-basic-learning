
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.junit.jupiter.api.Test;

public class testDemo {

    @Test
    void testFlipkartTitle() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new"); // important for Jenkins
        options.addArguments("--disable-gpu");

        WebDriver driver = new EdgeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        String title = driver.getTitle();
        System.out.println("Page title: " + title + " | Length: " + title.length());

        driver.quit();
    }
}