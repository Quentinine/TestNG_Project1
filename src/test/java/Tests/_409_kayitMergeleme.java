package Tests;

import Pages.hastaMergePage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _409_kayitMergeleme extends Functions {

    private static final Logger logger = getLogger(_409_kayitMergeleme.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "PatientManagement"}, dependsOnMethods = "login")
    public void kayitMerge() throws InterruptedException {

        logger.info("Hasta mergeleme tamamlandı.");

        hastaMergePage page = new hastaMergePage(driver);

        page.click1.click();
        page.click2.click();

        page.patientsearch.sendKeys("da");

        WebElement patient1 = wait.until(ExpectedConditions.elementToBeClickable(page.patient1));
        patient1.click();
        WebElement patient2 = wait.until(ExpectedConditions.elementToBeClickable(page.patient2));
        patient2.click();
        WebElement patient3 = wait.until(ExpectedConditions.elementToBeClickable(page.patient3));
        patient3.click();

        wait.until(ExpectedConditions.elementToBeClickable(page.confirmButton)).click();
        page.merge.click();
        page.confirm.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("patientdashboard"));

    }
}
