package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _405_hesabım extends Functions {

    @BeforeClass
    public void login() {
        loginOP();
    }

    @Test(groups = "Smoke")
    public void hesabaGiris() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement mainMenu = driver.findElement(By.cssSelector(".icon-user.small"));

        Actions actions = new Actions(driver);
        actions.moveToElement(mainMenu).perform();

        WebElement chmenu = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#user-account-menu")));
        chmenu.click();

        WebElement disp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//li[normalize-space()='My Account']/i")));

        Assert.assertTrue(disp.isDisplayed());
    }

}
