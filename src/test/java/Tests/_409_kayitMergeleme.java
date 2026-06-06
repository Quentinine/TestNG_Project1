package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _409_kayitMergeleme extends Functions {

    @BeforeClass
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "PatientManagement"})
    public void kayitMerge() throws InterruptedException {

        driver.findElement(By.cssSelector("#coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension")).click();
        driver.findElement(By.cssSelector("#coreapps-mergePatientsHomepageLink-app")).click();

        driver.findElement(By.cssSelector("#patient-search")).sendKeys("da");

        WebElement patient1 = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//tr[@class=\"odd\"][1]")));
        patient1.click();
        WebElement patient2 = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//tr[@class=\"even\"][1]")));
        patient2.click();
        WebElement patient3 = wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//tr[@class=\"odd\"][2]")));
        patient3.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirm-button"))).click();
        driver.findElement(By.xpath("//*[@id = 'first-patient']")).click();
        driver.findElement(By.xpath("//*[@id = 'confirm-button']")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("patientdashboard"));

    }
}
