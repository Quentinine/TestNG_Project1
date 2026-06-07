package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _402_loginTestPositive extends Functions {

    private static final Logger logger = getLogger(_402_loginTestPositive.class);

    @Test(groups = {"Smoke", "Login"})
    @Parameters({"usernameSend", "passSend"})
    public void loginTestR(String usernameSend, String passSend) {

        logger.info("Pozitif giriş testi bitti.");

        loginPage pageL = new loginPage(driver);
        driver.get("https://openmrs.org/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(pageL.demo));

        pageL.demo.click();

        scrollTo(pageL.scrollToE);

        wait.until(ExpectedConditions.elementToBeClickable(pageL.scrollToE));

        pageL.scrollToE.click();

        pageL.login.sendKeys(usernameSend);
        pageL.password.sendKeys(passSend);

        pageL.location1.click();
        pageL.loginButton.click();

        Assert.assertTrue(pageL.logged.isDisplayed());
    }

    @Test(dependsOnMethods = {"loginTestR"}, groups = {"Smoke", "Logout"})
    public void logouttest() {

        logger.info("Logout testi tamamlandı.");

        loginPage page = new loginPage(driver);

        page.logout.click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".w-auto")).isDisplayed());

    }
}
