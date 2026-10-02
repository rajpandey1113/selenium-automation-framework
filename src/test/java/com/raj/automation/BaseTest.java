package com.raj.automation;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.raj.automation.driver.DriverFactory;
import com.raj.automation.utils.ScreenshotUtils;

public class BaseTest {

    // protected WebDriver driver;

    @BeforeMethod
     public void setUp() {
       // driver = new ChromeDriver();

       //driver = DriverFactory.intializeDriver();

       DriverFactory.initializeDriver();
      // driver = DriverFactory.getDriver();
       // driver.manage().window().maximize();
        DriverFactory.getDriver().get("https://www.saucedemo.com/");

     }


    @AfterMethod 
         public void tearDown(ITestResult result) throws IOException {

    if (ITestResult.FAILURE == result.getStatus()) {
        ScreenshotUtils.captureScreenshot(DriverFactory.getDriver(), result.getName());
    }

   // driver.quit();
   DriverFactory.quitDriver();
}       
    }

