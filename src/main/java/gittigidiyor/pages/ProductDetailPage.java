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
        String price= getText(highPrice);
        if(price.isEmpty()){
            return getText(lowPrice);
        }
        return getText(highPrice);
    }

    public void addBasket() {
        click(addToBasket, 10);
    }


    public BasketPage goBasket() {
        click(iconBasket, 10);
        return new BasketPage(webDriver);
    }
}
