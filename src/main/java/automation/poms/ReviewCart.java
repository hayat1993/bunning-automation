package automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewCart extends AbstractPOM{
    public ReviewCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"confirmation-drawer\"]/div/div/div/div[2]/a/button")
    private WebElement reviewCart;

    public String review()
    {
        reviewCart.click();

        try {
            Thread.sleep(5000);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        WebElement value = driver.findElement(By.className("quantityEdit"));
        String productNumber = value.getAttribute("value");
        //System.out.println(productNumber);

        return productNumber;
    }
}
