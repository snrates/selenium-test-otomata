package gittigidiyor.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends HomePage {

    private final By userName = By.id("L-UserNameField");
    private final By userPassword = By.id("L-PasswordField");
    private final By loginButton = By.id("gg-login-enter");

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage register(String mail, String password) {
        sendKeys(userName, mail);
        sendKeys(userPassword, password);
        click(loginButton, 5);
        return new HomePage(webDriver);
    }

}
