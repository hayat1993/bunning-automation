package automation.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCart extends AbstractPOM{

    public AddToCart(WebDriver driver) {
        super(driver);
    }
    private String itemPrice = "";


    //Find all the web elements by their xpath
    @FindBy(xpath = "//*[@id=\"__next\"]/main/div/div[2]/div/div[4]/article[2]/a/div[3]/div/div/button")
    private WebElement addToCart;

    //add an item to cart and record its value and then return it
    public String addCartAndRetrieveAmount()
    {
        //get the price of the item
        WebElement priceField = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div/div[2]/div/div[4]/article[2]/a/div[3]/a/div/p"));
        String price = priceField.getText();
        itemPrice = price;

        addToCart.click();
        try {
            Thread.sleep(5000);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
        //get the quantity of items
        WebElement value = driver.findElement(By.className("qtyField"));
        String productNumber = value.getAttribute("value");



        return productNumber;
    }

    public String getItemPrice()
    {
        return itemPrice;
    }
}
