package Tests;

import Pages.hastaAramaPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _407_hastaSilme extends Functions {

    private static final Logger logger = getLogger(_407_hastaSilme.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = {"PatientManagement", "Smoke"}, dependsOnMethods = "login")
    public void hastaSilme() {

        logger.info("Hasta silme işlemi tamamlandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        hastaAramaPage page = new hastaAramaPage(driver);

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable
                (page.findrec));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(page.findpatient));
        findPatient.sendKeys("da");

        WebElement firstPatient = wait.until(ExpectedConditions.elementToBeClickable(page.firstPatient));
        firstPatient.click();

        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(page.deleteButton));
        deleteButton.click();

        driver.findElement(By.cssSelector("#delete-reason")).sendKeys("test delete");
        page.confirm.click();

        wait.until(ExpectedConditions.urlContains("findpatient"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("findpatient"));
    }
}
