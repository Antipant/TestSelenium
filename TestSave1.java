import java.util.regex.Pattern;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.Wait;

import org.openqa.selenium.support.ui.WebDriverWait;


public class TestSave1 {

    private WebDriver driver;

    private String baseUrl;

    private boolean acceptNextAlert = true;

    private StringBuffer verificationErrors = new StringBuffer();


    @Before

    public void setUp() throws Exception {

        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");

        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");

        driver = new FirefoxDriver();

        baseUrl = "http://www.sberbank.ru/ru/person";

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }


    @Test

    public void testSave() throws Exception {

        driver.get(baseUrl + "/ru/person");

        driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]//*[contains(text(),'Застраховать себя')]")).click();

        Wait<WebDriver> wait = new WebDriverWait(driver, 10, 1000);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Страхование путешественников"))));

        driver.findElement(By.linkText("Страхование путешественников")).click();

        driver.findElement(By.cssSelector("li.active > a > span")).click();

        //assertEquals("«Сбербанк» - Страхование путешественников", driver.getTitle());

        //driver.findElement(By.cssSelector("li.active > a > span")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p > a > img"))));

        driver.findElement(By.cssSelector("p > a > img")).click();

        // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]

        for (String winHandle : driver.getWindowHandles()) {


            driver.switchTo().window(winHandle);


        }

        //  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding"))));

        //driver.findElement(By.cssSelector("div.b-form-prog-note.ng-binding")).click();

        //driver.findElement(By.cssSelector("span.b-continue-btn")).click();

        driver.findElement(By.cssSelector("div.b-form-sum-big-font-size.ng-binding")).click();

        driver.findElement(By.cssSelector("span.b-continue-btn")).click();


        driver.findElement(By.name("insured0_surname")).clear();

        driver.findElement(By.name("insured0_surname")).sendKeys("Sdg");

        driver.findElement(By.name("insured0_name")).clear();

        driver.findElement(By.name("insured0_name")).sendKeys("Afd");

        driver.findElement(By.name("insured0_birthDate")).clear();

        driver.findElement(By.name("insured0_birthDate")).sendKeys("01012000");;

        driver.findElement(By.name("surname")).click();

        driver.findElement(By.name("surname")).clear();

        driver.findElement(By.name("surname")).sendKeys("Фававфы");

        driver.findElement(By.name("name")).clear();

        driver.findElement(By.name("name")).sendKeys("Ыфа");

        driver.findElement(By.name("middlename")).clear();

        driver.findElement(By.name("middlename")).sendKeys("Кпуф");

        driver.findElement(By.name("insured0_birthDate")).clear();

        driver.findElement(By.name("birthDate")).clear();

        driver.findElement(By.name("birthDate")).sendKeys("02.02.1998");

        driver.findElement(By.name("passport_series")).click();

        driver.findElement(By.name("passport_series")).clear();

        driver.findElement(By.name("passport_series")).sendKeys("2434");

        driver.findElement(By.name("passport_number")).clear();

        driver.findElement(By.name("passport_number")).sendKeys("346545");

        driver.findElement(By.name("issueDate")).clear();

        driver.findElement(By.name("issueDate")).sendKeys("04.04.2014");

        driver.findElement(By.name("issuePlace")).click();

        driver.findElement(By.name("issuePlace")).clear();

        driver.findElement(By.name("issuePlace")).sendKeys("впявыпавыв");



        assertEquals("Sdg", driver.findElement(By.name("insured0_surname")).getAttribute("value"));

        assertEquals("Afd", driver.findElement(By.name("insured0_name")).getAttribute("value"));

        assertEquals("11.12.2032", driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        assertEquals("Фававфы", driver.findElement(By.name("surname")).getAttribute("value"));

        assertEquals("Ыфа", driver.findElement(By.name("name")).getAttribute("value"));

        assertEquals("Кпуф", driver.findElement(By.name("middlename")).getAttribute("value"));

        assertEquals("07.09.1999", driver.findElement(By.name("birthDate")).getAttribute("value"));

        assertEquals("2434", driver.findElement(By.name("passport_series")).getAttribute("value"));

        assertEquals("346545", driver.findElement(By.name("passport_number")).getAttribute("value"));

        assertEquals("04.03.2000", driver.findElement(By.name("issueDate")).getAttribute("value"));

        assertEquals("впявыпавыв", driver.findElement(By.name("issuePlace")).getAttribute("value"));


        driver.findElement(By.cssSelector("span.b-continue-btn")).click();


        assertEquals("Заполнены не все обязательные поля", driver.findElement(By.cssSelector("div.b-form-center-pos.b-form-error-message > div")).getText());


        // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]

    }


    @After

    public void tearDown() throws Exception {

        driver.quit();

        String verificationErrorString = verificationErrors.toString();

        if (!"".equals(verificationErrorString)) {

            fail(verificationErrorString);

        }

    }


    private boolean isElementPresent(By by) {

        try {

            driver.findElement(by);

            return true;

        } catch (NoSuchElementException e) {

            return false;

        }

    }


    private boolean isAlertPresent() {

        try {

            driver.switchTo().alert();

            return true;

        } catch (NoAlertPresentException e) {

            return false;

        }

    }


    private String closeAlertAndGetItsText() {

        try {

            Alert alert = driver.switchTo().alert();

            String alertText = alert.getText();

            if (acceptNextAlert) {

                alert.accept();

            } else {

                alert.dismiss();

            }

            return alertText;

        } finally {

            acceptNextAlert = true;

        }

    }

}
