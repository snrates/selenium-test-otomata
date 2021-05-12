package gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends HomePage {

    private final By lowPrice = By.id("sp-price-lowPrice");
    private final By highPrice = By.id("sp-price-highPrice");
    private final By addToBasket = By.id("add-to-basket");
    private final By iconBasket = By.cssSelector(".robot-header-iconContainer-cart");


    public ProductDetailPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getPrice(){
        String price= webDriver.findElement(lowPrice).getText();
        if(price.isEmpty()){
            return getText(highPrice);
        }
        return getText(lowPrice);
    }

    public void addBasket() {
        click(addToBasket, 10);
    }


    public BasketPage goBasket() {
        click(iconBasket, 5);
        return new BasketPage(webDriver);
    }
}
