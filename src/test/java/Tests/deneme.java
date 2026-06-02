package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class deneme {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://openmrs.org/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

// 1. Demo Butonuna Tıklama
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://openmrs.org/demo/']")));
        driver.findElement(By.xpath("//a[@href='https://openmrs.org/demo/']")).click();

// 2. Explore OpenMRS 2 Butonuna Scroll ve Tıklama
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text() ='Explore OpenMRS 2']")));

// Scroll yapabilmek için elementi bir kerelik değişkene alıyoruz
        WebElement exploreButton = driver.findElement(By.xpath("//a[text() ='Explore OpenMRS 2']"));
        js.executeScript("arguments[0].scrollIntoView(true);", exploreButton);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text() ='Explore OpenMRS 2']")));
        exploreButton.click();

// 3. Giriş Bilgilerini Doldurma
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#username")));
        driver.findElement(By.cssSelector("input#username")).sendKeys("admin");
        driver.findElement(By.cssSelector("input#password")).sendKeys("Admin123");

// 4. Rastgele Lokasyon Seçimi
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@tabindex]")));

        List<WebElement> locations = driver.findElements(By.xpath("//*[@tabindex]"));
        int rasgele = (int) (Math.random() * locations.size());
        locations.get(rasgele).click();

// 5. Login Butonuna Tıklama
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#loginButton")));
        driver.findElement(By.cssSelector("input#loginButton")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient']")));
        driver.findElement(By.xpath("//*[@href='/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient']")).click();

// 2. İsim ve Soyisim Girişi
// fr5974-field gibi dinamik ID'ler yerine sabit olan 'name' alanlarını kullandık
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='givenName']")));
        driver.findElement(By.cssSelector("input[name='givenName']")).sendKeys("name");
        driver.findElement(By.cssSelector("input[name='familyName']")).sendKeys("surname");
        driver.findElement(By.cssSelector("button#next-button")).click();

// 3. Cinsiyet Seçimi
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#gender-field")));
        new Select(driver.findElement(By.cssSelector("select#gender-field"))).selectByValue("M");
        driver.findElement(By.cssSelector("button#next-button")).click();

// 4. Doğum Tarihi Girişi
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#birthdateDay-field")));
        driver.findElement(By.cssSelector("input#birthdateDay-field")).sendKeys("12");
        new Select(driver.findElement(By.cssSelector("select#birthdateMonth-field"))).selectByValue("6");
        driver.findElement(By.cssSelector("input#birthdateYear-field")).sendKeys("1999");
        driver.findElement(By.cssSelector("button#next-button")).click();

// 5. Adres Girişi
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#address1")));
        driver.findElement(By.cssSelector("#address1")).sendKeys("deneme adresss sokak 1321.");
        driver.findElement(By.cssSelector("button#next-button")).click();

// 6. Kalan Boş Form Adımlarını Geçme (Telefon, İlişki vb.)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#next-button")));
        driver.findElement(By.cssSelector("button#next-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#next-button")));
        driver.findElement(By.cssSelector("button#next-button")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#next-button")));
        driver.findElement(By.cssSelector("button#next-button")).click();

// 7. Onaylama (Submit)
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#submit")));
        driver.findElement(By.cssSelector("#submit")).click();


    }
}

