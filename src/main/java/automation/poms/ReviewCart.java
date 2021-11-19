package automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReviewCart extends AbstractPOM{
    public ReviewCart(WebDriver driver) {
        super(driver);
    }

    //Find all the web elements by their xpath
    @FindBy(xpath = "//*[@id=\"confirmation-drawer\"]/div/div/div/div[2]/a/button")
    private WebElement reviewCart;
    private String itemPrice = "";

    //click on review cart and then record the number of items again and return it
    public String review()
    {
        reviewCart.click();

        try {
            Thread.sleep(5000);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        //get the total price in the review page
        WebElement priceField = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[2]/div[1]/div/div[4]/div/div[3]/div[2]/div/div"));
        String price = priceField.getText();
        itemPrice = price;

        //get the quantity of products in the review page
        WebElement value = driver.findElement(By.className("quantityEdit"));
        String productNumber = value.getAttribute("value");


        return productNumber;
    }

    public String getItemPrice()
    {
        return itemPrice;
    }
}
