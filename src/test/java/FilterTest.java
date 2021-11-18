import automation.poms.FilterClickAndCollect;
import automation.poms.LandingPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FilterTest {

    ChromeDriver driver;

    @BeforeTest
    public void initiate() {
        System.setProperty("webdriver.chrome.driver" , "src/webDriverExecutables/chrome/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void test()
    {
        FilterClickAndCollect page = new FilterClickAndCollect(driver);

    }
}
