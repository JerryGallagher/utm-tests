package com.utm.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UTMUserTestCase {
 
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private WebDriver driver;
  
  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", //
    		  "lib\\win\\chromedriver.exe");
    driver = new ChromeDriver();
    
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	driver.get("http://localhost:8080/UTM/");      
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("email")).sendKeys("testuser1@unomaha.edu");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("password");
    driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//body")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='wrapper']/div/div/table/tbody/tr")).click();
    driver.findElement(By.id("schedule")).click();
    driver.findElement(By.id("recentreport")).click();
    driver.findElement(By.xpath("//div[@id='recentreport']/option[3]")).click();
    driver.findElement(By.linkText("&nbsp;Make a report")).click();
    driver.findElement(By.id("report")).click();
    driver.findElement(By.id("report")).clear();
    driver.findElement(By.id("report")).sendKeys("Long day, wrote 80 lines of quality code.");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//div[@id='recentreport']/option")).click();
    driver.findElement(By.xpath("//div[@id='punch']/h3")).click();
    driver.findElement(By.xpath("//div[@id='punch']/p")).click();
    driver.findElement(By.xpath("//div[@id='punch']/p")).click();
    driver.findElement(By.xpath("//div[@id='punch']/button")).click();
    driver.findElement(By.linkText("&nbsp;Sign Out")).click();
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
