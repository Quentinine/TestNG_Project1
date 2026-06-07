package Tests;

import Pages.hastaAramaPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _406_hastaArama extends Functions {

    private static final Logger logger = getLogger(_406_hastaArama.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = "PatientManagement", priority = 1, dependsOnMethods = "login")
    public void hastaAramaPos() {

        logger.info("Pozitif hasta arama tamamlandı");

        hastaAramaPage page = new hastaAramaPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable(page.findrec));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(page.findpatient));
        findPatient.sendKeys("da");

        WebElement firstPatient = wait.until(ExpectedConditions.elementToBeClickable(page.firstPatient));
        firstPatient.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("patient.page"));
    }

    @Test(groups = "PatientManagement", priority = 2, dependsOnMethods = "login")
    public void hastaAramaNeg() throws InterruptedException {

        logger.info("Negatif hasta arama tamamlandı.");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        hastaAramaPage page = new hastaAramaPage(driver);

        driver.get("https://o2.openmrs.org/openmrs/referenceapplication/home.page");

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable(page.findrec));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(page.findpatient));
        findPatient.sendKeys("555555");

        // wait kütüphanesi cok önemli

        String condition = "No matching records found";
        wait.until(ExpectedConditions.textToBePresentInElement(page.found, condition));
        String found = wait.until(ExpectedConditions.visibilityOf((page.found))).getText();

        Assert.assertEquals(found, condition);
    }
}
