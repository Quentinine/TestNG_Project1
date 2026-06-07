package Tests;

import Pages.hesabimPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _405_hesabim extends Functions {

    private static final Logger logger = getLogger(_405_hesabim.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = "Smoke", dependsOnMethods = "login")
    public void hesabaGiris() throws InterruptedException {

        logger.info("Hesaba giriş tamamlandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        hesabimPage page = new hesabimPage(driver);

        WebElement mainMenu = page.mainmenu;

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();

        WebElement chmenu = wait.until(ExpectedConditions.elementToBeClickable(page.chmenu));
        chmenu.click();

        WebElement disp = wait.until(ExpectedConditions.visibilityOf(page.disp));

        WebElement changePass = wait.until(ExpectedConditions.elementToBeClickable(page.changepass));
        changePass.click();

        driver.navigate().back();

        WebElement myLan = wait.until(ExpectedConditions.elementToBeClickable(page.mylan));
        myLan.click();

        driver.navigate().back();
        Thread.sleep(2000);

        changePass = wait.until(ExpectedConditions.elementToBeClickable(page.changepass));
        myLan = wait.until(ExpectedConditions.elementToBeClickable(page.mylan));

        Assert.assertTrue(changePass.isDisplayed() && myLan.isDisplayed());

        //eger sayfa değişirse selenium için eski tanımlanmıs deger bayatlamıştır kullılabilmesi için tekrar tanımlanması gerekir
    }
}
