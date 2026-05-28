package Tests;

import Pages.loginPage;
import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class loginTestPositive extends Functions {

    @Test(groups = {"smoke", "login"})
    @Parameters({"usernameSend", "passSend"})
    public void loginTestR(String usernameSend, String passSend) {

        loginPage page = new loginPage(driver);
        driver.get("https://openmrs.org/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(page.demo));

        page.demo.click();

        scrollTo(page.scrollToE);

        wait.until(ExpectedConditions.elementToBeClickable(page.scrollToE));

        page.scrollToE.click();

        page.login.sendKeys(usernameSend);
        page.password.sendKeys(passSend);

        page.location1.click();
        page.loginButton.click();

        Assert.assertTrue(page.logged.isDisplayed());

    }

    @Test(dependsOnMethods = {"loginTestR"}, groups = {"smoke", "logout"})
    public void logouttest() {

        loginPage page = new loginPage(driver);

        page.logout.click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".w-auto")).isDisplayed());

    }
}
