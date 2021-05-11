package gittigidiyor.pages;

import gittigidiyor.PagesHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PagesHelper {

    private final By userLoginIcon = By.cssSelector("[data-cy='header-user-menu'] .egoSnI");
    private final By loginButton = By.cssSelector("[data-cy='header-login-button']");
    //    private final By searchBox = By.cssSelector("[data-cy='header-search-input']");
    private final By searchBox = By.className("sc-4995aq-0");
    private final By userNameControl = By.cssSelector("[data-cy='header-user-menu'] .egoSnI > span");
    private final By searchButton = By.cssSelector(".qjixn8-0.sc-1bydi5r-0.hKfdXF");


    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getUserName() {

        return getText(userNameControl);
    }

    public String getHomePageTitle() {
        return getTitle();
    }

    public void touchLoginIcon() {
        click(userLoginIcon, 10);
    }

    public LoginPage goLoginPage() {
        click(loginButton, 10);
        return new LoginPage(webDriver);
    }

    public SearchResultPage searchAndGo(String searchKey) {
        sendKeys(searchBox, searchKey);
        click(searchButton, 10);
        return new SearchResultPage(webDriver);
    }

}
