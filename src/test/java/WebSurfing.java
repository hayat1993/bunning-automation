import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebSurfing {
    @Test
    public void test()
    {

        System.setProperty("webdriver.gecko.driver" , "src/webDriverExecutables/firefox/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com");

    }
}
