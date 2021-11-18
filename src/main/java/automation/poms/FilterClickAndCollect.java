package automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class FilterClickAndCollect extends AbstractPOM {

    public FilterClickAndCollect(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"panel1bh-header\"]/div[2]")
    private WebElement filterDropDown;

    @FindBy(xpath = "//*[@id=\"panel1bh-content\"]/div/div/div[2]/button[1]/div/div/span[1]")
    private WebElement clickAndCollectSelection;

    public void filterSearch()
    {
        filterDropDown.click();
        try {
            Thread.sleep(5000);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        clickAndCollectSelection.click();



    }
}
