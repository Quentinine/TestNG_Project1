package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class _406_hastaArama extends Functions {

    @BeforeClass
    public void login() {
        loginOP();
    }

    @Test(groups = "PatientManagement", priority = 1)
    public void hastaAramaPos() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient-search")));
        findPatient.sendKeys("da");

        WebElement firstPatient = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class =\"odd\"][1]")));
        firstPatient.click();

    }

    @Test(groups = "PatientManagement", priority = 2)
    public void hastaAramaNeg() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://o2.openmrs.org/openmrs/referenceapplication/home.page");

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient-search")));
        findPatient.sendKeys("555555");


        String condition = "No matching records found";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".dataTables_empty"), condition));
        String found = wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".dataTables_empty")))).getText();

        Assert.assertEquals(found, condition);

    }
}
