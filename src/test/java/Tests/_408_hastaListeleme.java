package Tests;

import Utilities.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class _408_hastaListeleme extends Functions {

    @BeforeClass
    public void login() {
        loginOP();
    }

    @Test(groups = {"Regression", "PatientManagement"})
    public void hastaListeleme() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement findRec = wait.until(ExpectedConditions.elementToBeClickable
                (By.cssSelector("#coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")));
        findRec.click();

        WebElement findPatient = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#patient-search")));
        findPatient.sendKeys("jo");

        Thread.sleep(3000);

        boolean button = true;
        int patientCount = 0;

        while (button) {

            List<WebElement> patients = driver.findElements(By.cssSelector("tbody tr"));

            patientCount += patients.size();

            WebElement next = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#patient-search-results-table_next")));
            String nextButtonClass = next.getAttribute("class");

            if (!nextButtonClass.contains("disabled")) {
                next.click();
                wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//*[@class =\"odd\"][1]"))));
                System.out.println(patientCount);

            } else button = false;

        }

        String[] expectedString = driver.findElement(By.cssSelector("#patient-search-results-table_info")).getText().split(" ");
        int expected = Integer.parseInt(expectedString[5]);

        Assert.assertEquals(patientCount, expected);

        //getattribute ve contains onemli, (attribute string olarak mı alıyor? list yapma tekrar  bak, ), parseint, containsli xpath bide birdne fazla alma notlara ekle

    }

}
