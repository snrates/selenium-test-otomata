package gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SearchResultPage extends HomePage {


    private final By targetPageNumber = By.linkText("2");
    private final By twoPageNumber = By.className("current");
    private final By selectRandomMaterial = randomNumber();


    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public By randomNumber() {
        Random random = new Random();
        int num = random.nextInt(48) + 1;
        return By.cssSelector(".products-container > li:nth-child(" + num + ")");
    }

    public void clickTwoPage() {
        click(twoPageNumber, 10);
    }

    public String getPageNumber() {
        return getText(targetPageNumber);
    }

    public ProductDetailPage getProduct() {
        click(selectRandomMaterial, 10);
        return new ProductDetailPage(webDriver);
    }
}
