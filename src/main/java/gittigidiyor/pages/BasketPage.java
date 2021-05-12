package gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage extends HomePage {

    private final By totalPrice = By.className("total-price");
    private final By numberOfProduct = By.cssSelector("option[value='2']");
    private final By totalProduct = By.cssSelector("li[class='clearfix total-price-sticky-container']>:nth-child(1)");
    private final By deleteCart = By.cssSelector("a[title='Sil']");
    private final By noProduct = By.cssSelector("div[class='gg-w-22 gg-d-22 gg-t-21 gg-m-18']>:nth-child(1)");
    private final By endProduct = By.className("count-desc");

    public BasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCartPrice() {
        return getText(totalPrice);
    }

    public void increaseProduct() {
        click(numberOfProduct, 10);
    }

public String productCount(){
        String product=webDriver.findElement(endProduct).getText();
        return product;
}
    public String getTotalProduct() {
        return getText(totalProduct);
    }

    public void getEmptyCart() {
        click(deleteCart, 10);
    }

    public String getNoProductInfo() {
        return getText(noProduct);
    }

}
