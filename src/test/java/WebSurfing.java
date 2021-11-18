import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebSurfing {
    @Test
    public void test()
    {

        System.setProperty("webdriver.chrome.driver" , "src/webDriverExecutables/chrome/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

    }
}
