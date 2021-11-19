import automation.poms.AddToCart;
import automation.poms.FilterClickAndCollect;
import automation.poms.LandingPage;
import automation.poms.ReviewCart;
import automation.utils.Constants;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BunningsTest {

    Constants constants = new Constants();
    String property = constants.getSystemProperty();
    String driverDirectory = constants.getDriverDirectoryWindows();
    String getDriverDirectoryAlternate = constants.getDriverDirectoryMac();

    ChromeDriver driver;

    //initiate the driver
    @BeforeTest
    public void initiate() {
        System.setProperty(property, driverDirectory);
        //make sure that the driver uses full screen for the test
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }


    @Test
    public void testBunningWebsite() {
        //load the landing page for the test and search for paint
        LandingPage page = new LandingPage(driver);
        page.searchForPaint();
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //filter for click and collect
        FilterClickAndCollect page1 = new FilterClickAndCollect(driver);
        page1.filterSearch();

        //wait for 5 seconds before proceeding
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Add the paint to cart
        AddToCart page2 = new AddToCart(driver);
        String productNum = page2.addCartAndRetrieveAmount();

        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Review the cart and check if the product value selected earlier is the same as before
        ReviewCart page3 = new ReviewCart(driver);
        String productNum2 = page3.review();

        assertThat(productNum.trim().equals(productNum2.trim())).isTrue();

    }

    @AfterTest
    public void killDriver() {
        //wait for 5 seconds before ending the test
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        driver.close();

    }
}
