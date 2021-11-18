package automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends AbstractPOM{

    public AddToCart(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[2]/div/div[4]/article[2]/a/div[3]/div/div/button")
    private WebElement addToCart;






    public String addCartAndRetrieveAmount()
    {
        addToCart.click();
        try {
            Thread.sleep(5000);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        WebElement value = driver.findElement(By.className("qtyField"));
        String productNumber = value.getAttribute("value");
        //System.out.println(productNumber);

        return productNumber;
    }
}
