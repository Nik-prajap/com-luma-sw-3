package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setupBrowser(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessfullyToShoppingCart() {


            mouseHoverToElement(By.xpath("//span[normalize-space()='Gear']"));

            mouseHoverToElementAndClick(By.xpath("//span[normalize-space()='Bags']"));

            clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));
            Assert.assertEquals("Overnight Duffle",getTextFromElement(By.xpath("//span[@class='base']")));

            sendTextToElement(By.xpath("//input[@id='qty']"), "3");
            clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

            Assert.assertEquals("You added Overnight Duffle to your shopping cart.",getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")));
            clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

            Assert.assertEquals("Overnight Duffle",getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']")));

            Assert.assertEquals("3",getAttributeValue(By.xpath("//input[@title='Qty']"), "value"));

            Assert.assertEquals("$135.00",getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));

            sendTextToElement(By.xpath("(//input[@class='input-text qty'])[1]"), "5");

            clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));
            Assert.assertEquals("$225.00",
                    getTextFromElement(By.xpath("(//span[@class='cart-price']//span)[2]")));
        }


    @After
    public void tearDown(){
        closeBrowser();
    }
}
