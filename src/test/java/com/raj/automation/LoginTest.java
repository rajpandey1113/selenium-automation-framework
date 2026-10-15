package com.raj.automation;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.raj.automation.driver.DriverFactory;
import com.raj.automation.pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void loginTest() {
        System.out.println(
    "Test: " + Thread.currentThread().getName()
          );
       // System.out.println("learning");
       // WebDriver driver  = new ChromeDriver();
       WebDriver driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage(driver);

        //driver.get("https://www.saucedemo.com/");
       //  driver.findElement(By.id("user-name")).sendKeys("standard_user");
        loginPage.enterUsername("standard_user");
       // driver.findElement(By.id("password")).sendKeys("secret_sauce");
        loginPage.enterPassword("secret_sauce");
       // driver.findElement(By.id("login-button")).click();
        loginPage.clickLoginButton();


       // driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Products']")));

        // assertion 
       // String actualTitle =driver.findElement(By.xpath("//span[text()='Products']")).getText();
       String actualTitle = productTitle.getText();
       Assert.assertEquals(actualTitle,"Products");
       // driver.quit();

    }

        @Test(groups = {"regression"})
        public void inValidLoginTest(){
             System.out.println("invalidLoginTest running on: "
        + Thread.currentThread().getName());
            //WebDriver driver = new ChromeDriver();
            //LoginPage loginpage = new LoginPage(driver);
            WebDriver driver = DriverFactory.getDriver();
            LoginPage loginPage = new LoginPage(driver);
            //driver.get("https://www.saucedemo.com/");
           // driver.findElement(By.id("user-name")).sendKeys("standard_user");
           loginPage.enterUsername("standard_user");
           // driver.findElement(By.id("password")).sendKeys("secret_sauce1");
              loginPage.enterPassword("secret_sauce1");
            //driver.findElement(By.id("login-button")).click();
              loginPage.clickLoginButton();

          // String expectedErrorMSG = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
          String expectedErrorMSG = loginPage.getErrorMSG();
          String actualErrorMSG = "Epic sadface: Username and password do not match any user in this service";
           Assert.assertEquals(expectedErrorMSG, actualErrorMSG);
           // driver.quit();
        }





    }

    


