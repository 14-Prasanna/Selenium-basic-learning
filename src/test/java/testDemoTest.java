import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;

public class testDemoTest {

    @Test
    void testFlipkartTitle() {

        ChromeOptions options = new ChromeOptions();

        // Required for Jenkins (VERY IMPORTANT)
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        String title = driver.getTitle();
        System.out.println("Page title: " + title + " | Length: " + title.length());

        driver.quit();
    }
}