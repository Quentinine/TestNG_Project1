package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class _410_yanlisSaat extends Functions {

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "Appointment"},dependsOnMethods = "login")
    public void yanlisSaat() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
        driver.findElement(By.cssSelector("#appointmentschedulingui-manageAppointments-app")).click();

        driver.findElement(By.cssSelector("#patient-search.form-control")).sendKeys("sa");

        Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody[@aria-live='polite']/tr[@class='odd'][1]"))).click();

        wait.until(ExpectedConditions.urlContains("manageAppointments"));

        String cond = driver.findElement(By.cssSelector("#time-zone-warning")).getText();
        String exp = "Your computer is not set to the right time zone. Please change to Coordinated Universal Time and then close and restart your browser to assure proper scheduling functionality.";

        Assert.assertEquals(cond, exp);
    }
}
