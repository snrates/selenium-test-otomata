package gittigidiyor;


import gittigidiyor.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver webDriver;

    @BeforeClass
    public static void setup() {

        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupBrowser() {

        String browserUrl = "https://www.gittigidiyor.com/";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        Log4j.startLog();
        webDriver.get(browserUrl);
        Log4j.info("Open Browser Page : " + browserUrl);
    }

    @After
    public void testEnd() {
        Log4j.endLog();
        webDriver.quit();
    }
}
