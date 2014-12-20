package utils;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.Selenium;

public class Test1 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:801/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    driver.get(baseUrl + "/xampp/CS401Website/");
    driver.findElement(By.cssSelector("a[title=\"Automation Practice Form\"] > strong")).click();
    driver.findElement(By.cssSelector("a[title=\"Automation Practice Table\"] > strong")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("ali");
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("veli");
    driver.findElement(By.id("sex-0")).click();
    driver.findElement(By.id("exp-0")).click();
    driver.findElement(By.id("datepicker")).clear();
    driver.findElement(By.id("datepicker")).sendKeys("09.10.2014");
    driver.findElement(By.id("profession-0")).click();
    driver.findElement(By.id("profession-1")).click();
    //driver.findElement(By.id("photo")).clear();
    //driver.findElement(By.id("photo")).sendKeys("C:\\Users\\bluew_000\\Desktop\\5022cf46a2def90002000c36_803514353.jpg");
    driver.findElement(By.id("tool-0")).click();
    driver.findElement(By.id("tool-1")).click();
    driver.findElement(By.id("tool-2")).click();
    new Select(driver.findElement(By.id("continents"))).selectByVisibleText("Australia");
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=selenium_commands | label=Browser Commands]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=selenium_commands | label=Navigation Commands]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=selenium_commands | label=Switch Commands]]
    // ERROR: Caught exception [ERROR: Unsupported command [removeSelection | id=selenium_commands | label=Browser Commands]]
    // ERROR: Caught exception [ERROR: Unsupported command [addSelection | id=selenium_commands | label=WebElement Commands]]
    driver.findElement(By.id("submit")).click();
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
