package Utilities;

import Pages.loginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.List;

public class BaseDriver {

    public WebDriver driver;
    public WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(BaseDriver.class);

    @BeforeClass(alwaysRun = true)
    public void initialOP() {

        logger.trace("Web sitesine giriş yapıldı.");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        System.out.println("Driver çalıştı.");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    @AfterClass(alwaysRun = true)
    public void finalOP() throws InterruptedException {

        Thread.sleep(3000);
        driver.quit();
        System.out.println("Driver kapatıldı, test sonlandı.");

    }

    // farklı bir classtan metoda dependant ise depends yerine dependongroups kullanırız.
    public void loginOP() {

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(page.demo));

        page.demo.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", page.scrollToE);

        wait.until(ExpectedConditions.elementToBeClickable(page.scrollToE));

        page.scrollToE.click();

        page.login.sendKeys("admin");
        page.password.sendKeys("Admin123");

        List<WebElement> locations = page.locations;
        int rasgele = (int) (Math.random() * locations.size());
        WebElement randomElement = locations.get(rasgele);
        randomElement.click();

        page.loginButton.click();

    }
}


