package Tests;

import Pages.hastaAramaPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _408_hastaListeleme extends Functions {

    private static final Logger logger = getLogger(_408_hastaListeleme.class);

    @Test(alwaysRun = true)
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "PatientManagement"}, dependsOnMethods = "login")
    public void hastaListeleme() throws InterruptedException {

        logger.info("Hasta listeleme tamamlandı");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        hastaAramaPage page = new hastaAramaPage(driver);

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable(page.findrec));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(page.findpatient));
        findPatient.sendKeys("jo");

        Thread.sleep(3000);

        boolean button = true;
        int patientCount = 0;

        while (button) {

            List<WebElement> patients = page.patients;

            patientCount += patients.size();

            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(page.next));
            String nextButtonClass = next.getAttribute("class");

            if (!nextButtonClass.contains("disabled")) {
                next.click();
                wait.until(ExpectedConditions.elementToBeClickable((page.expCon)));
                System.out.println(patientCount);

            } else button = false;
        }

        String[] expectedString = page.expString.getText().split(" ");
        int expected = Integer.parseInt(expectedString[5]);

        Assert.assertEquals(patientCount, expected);

        //getattribute ve contains onemli, (attribute string olarak mı alıyor?
        // list yapma tekrar  bak, ), parseint, containsli xpath bide birdne fazla alma notlara ekle
    }
}
