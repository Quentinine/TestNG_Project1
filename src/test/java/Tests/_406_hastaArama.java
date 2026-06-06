package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class _406_hastaArama extends Functions {

    @Test(groups = "PatientManagement")
    public void hastaAramaPos() {

        driver.findElement(By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension"));
        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient-search")));
        findPatient.sendKeys("da");
        WebElement firstPatient = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class =\"odd\"][1]")));
        firstPatient.click();

    }
    @Test(groups = "PatientManagement")
    public void hastaAramaNeg() {



    }
}
