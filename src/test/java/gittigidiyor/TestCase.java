package gittigidiyor;

import gittigidiyor.pages.*;
import gittigidiyor.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase extends BaseTest {

    @Test
    public void goToPage() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        String homePageTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String key = "Bilgisayar";
        String targetPageNumber = "2";
        String basketProductCount = "Ürün Toplamı (2 Adet)";
        String basketInfo = "Sepetinizde ürün bulunmamaktadır.";
        String productCountInfo = "Son 1  ürün!";

        HomePage homePage = new HomePage(webDriver);
        String driverTitle = homePage.
                getHomePageTitle();
        Log4j.info("Driver Title : " + driverTitle);
        Assert.assertEquals(driverTitle, homePageTitle);

        homePage.touchLoginIcon();
        LoginPage loginPage = homePage.goLoginPage();
        User user = new User();
        String email = user.getEmail();
        String password = user.getPassword();
        Log4j.info("Email : " + email + " - Password : " + password);
        loginPage.register(email, password);
        String userName = homePage.getUserName();
        Log4j.info("Username : " + userName);
        Assert.assertEquals(userName, user.getUserName());

        SearchResultPage searchResultPage = homePage.searchAndGo(key);
        Log4j.info("Computer word searched");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        searchResultPage.clickTwoPage();
        String selectPageNumber = searchResultPage.getPageNumber();
        Assert.assertEquals(targetPageNumber, selectPageNumber);
        Log4j.info("Selected page number : " + selectPageNumber);

        ProductDetailPage productDetailPage = searchResultPage.getProduct();
        String selectProductPrice = productDetailPage.getPrice();
        Log4j.info("Select product price: " + selectProductPrice);//sepete eklemeden
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        productDetailPage.addBasket();
        Log4j.info("Product is add basket");


        BasketPage basketPage = productDetailPage.goBasket();
        String basketPrice = basketPage.getCartPrice();//sepetteki fiyatı
        Assert.assertEquals(selectProductPrice, basketPrice);
        Log4j.info("Cart price is equal to product price");

        //String productCount=basketPage.productCount();
        //Assert.assertEquals(productCount,productCountInfo);
        //Log4j.info("Final Product");

        basketPage.increaseProduct();//artır
        Thread.sleep(5000);
        String totalProductInfo = basketPage.getTotalProduct();
        Assert.assertEquals(totalProductInfo, basketInfo);
        Log4j.info("The number of items in the basket is equal");
        basketPage.getEmptyCart();
        String noProduct = basketPage.getNoProductInfo();
        Assert.assertEquals(noProduct, basketProductCount);
        Log4j.info("Basket is empty");
        Log4j.endLog();
    }
}
