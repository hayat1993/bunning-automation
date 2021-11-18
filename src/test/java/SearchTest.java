import automation.poms.AddToCart;
import automation.poms.FilterClickAndCollect;
import automation.poms.LandingPage;
import automation.poms.ReviewCart;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    ChromeDriver driver;

    //initiate the driver
    @BeforeTest
    public void initiate() {
        System.setProperty("webdriver.chrome.driver", "src/webDriverExecutables/chrome/chromedriver.exe");
        //make sure that the driver uses full screen for the test
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }


    @Test
    public void test() {
        LandingPage page = new LandingPage(driver);
        page.searchForPaint();
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        FilterClickAndCollect page1 = new FilterClickAndCollect(driver);
        page1.filterSearch();

        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        AddToCart page2 = new AddToCart(driver);
        String productNum = page2.addCartAndRetrieveAmount();

        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ReviewCart page3 = new ReviewCart(driver);
        String productNum2 = page3.review();

        assertThat(productNum.trim().equals(productNum2.trim())).isTrue();

    }

    @AfterTest
    public void killDriver() {
        driver.close();

    }
}
