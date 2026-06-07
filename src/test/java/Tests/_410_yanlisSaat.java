package Tests;

import Pages.yanlisSaatPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _410_yanlisSaat extends Functions {

    private static final Logger logger = getLogger(_410_yanlisSaat.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "Appointment"},dependsOnMethods = "login")
    public void yanlisSaat() throws InterruptedException {

        logger.info("Yanlış saati dilimi uyarısı testi yapıldı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        yanlisSaatPage page = new yanlisSaatPage(driver);

        page.appClick1.click();
        page.appClick2.click();

        page.search.sendKeys("sa");

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(page.click3)).click();

        wait.until(ExpectedConditions.urlContains("manageAppointments"));

        String cond = page.warning.getText();
        String exp = "Your computer is not set to the right time zone. " +
                "Please change to Coordinated Universal Time and then close and restart your " +
                "browser to assure proper scheduling functionality.";

        Assert.assertEquals(cond, exp);
    }
}
