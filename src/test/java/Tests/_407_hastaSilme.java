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

public class _407_hastaSilme extends Functions {

    @BeforeClass
    public void login() {
        loginOP();
    }

    @Test(groups = {"PatientManagement", "Smoke"})
    public void hastaSilme() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient-search")));
        findPatient.sendKeys("da");

        WebElement firstPatient = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//*[@class =\"odd\"][1]")));
        firstPatient.click();

        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//div[contains(text(),'Delete Patient')]")));
        deleteButton.click();

        driver.findElement(By.cssSelector("#delete-reason")).sendKeys("test delete");
        driver.findElement(By.cssSelector("#delete-patient-creation-dialog button.confirm.right")).click();

        wait.until(ExpectedConditions.urlContains("findpatient"));

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("findpatient"));

    }

}
