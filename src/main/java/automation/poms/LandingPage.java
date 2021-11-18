package automation.poms;

import automation.utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LandingPage extends AbstractPOM {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"main-header\"]/div[1]/div[1]/div[1]/div[2]/button")
    private WebElement getSearchButton;

    @FindBy(css = "input[type='search']")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"crossIcon\"]")
    private WebElement searchButton;

    public void searchForPaint()
    {
        driver.get("https://www.bunnings.com.au/");
        //getSearchButton.click();
        searchBox.sendKeys("Paint");
        searchButton.click();
    }
}
