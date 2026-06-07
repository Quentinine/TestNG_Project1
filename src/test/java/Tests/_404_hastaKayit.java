package Tests;

import Pages.hastaPage;
import Utilities.Functions;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.apache.logging.log4j.LogManager.getLogger;

public class _404_hastaKayit extends Functions {

    private static final Logger logger = getLogger(_404_hastaKayit.class);

    @Test(alwaysRun = true) // once parent calısır sonra child yani once basedriver icerisindeki calısır sonra bu.
    public void login() {
        loginOP();
    }

    @Test(groups = "Regression", dependsOnMethods = "login")
    @Parameters({"name", "surname", "day", "month", "year"})
    public void hastaKayit(String name, String surname, String day, String month, String year) {

        logger.info("Hasta kayıt işlemi bitti.");

        hastaPage pageH = new hastaPage(driver);

        driver.get("https://o2.openmrs.org/openmrs/referenceapplication/home.page");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(pageH.registerPatient));

        pageH.registerPatient.click();

        pageH.patientName.sendKeys(name);
        pageH.patientSurname.sendKeys(surname);
        pageH.continueButton.click();

        returnSelect(pageH.gender).selectByValue("M");
        pageH.continueButton.click();

        pageH.Bday.sendKeys(day);
        returnSelect(pageH.Bmonth).selectByValue(month);
        pageH.Byear.sendKeys(year);
        pageH.continueButton.click();

        pageH.Address.sendKeys("deneme adresss sokak 1321.");
        pageH.continueButton.click();
        pageH.continueButton.click();
        pageH.continueButton.click();
        pageH.submit.click();

        Assert.assertEquals(pageH.confname.getText(), name);

    }
}
