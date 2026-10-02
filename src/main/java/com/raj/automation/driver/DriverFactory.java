package com.raj.automation.driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    /* public static WebDriver intializeDriver(){
        return new ChromeDriver();
       } */

        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static void initializeDriver() {
          driver.set(new ChromeDriver());
        }

        public static WebDriver getDriver(){
            return driver.get();
        }

        public static void quitDriver(){
            driver.get().quit();
            driver.remove();
        }



    
}
