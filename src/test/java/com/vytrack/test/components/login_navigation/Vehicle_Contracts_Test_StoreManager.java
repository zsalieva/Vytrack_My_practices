package com.vytrack.test.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Vehicle_Contracts_Test_StoreManager {

    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(3000, 2);
    }

    //    ****************** STORE_MANAGER **********************
    @Test(priority = 1)
    public void testLogIn_Vehicle_Contracts() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        Thread.sleep(3000,2);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        Thread.sleep(3000,2);
        String expectedT ="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualT = driver.getCurrentUrl();
        Assert.assertEquals(actualT,expectedT);
        Thread.sleep(3000,2);
        System.out.println("Store Manager Test Passed !!!  :)");
    }


    //    ****************** SALES_MANAGER **********************

    @Test(priority = 2)
    public void LogInAs_Sales_Manager() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        Thread.sleep(3000,2);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        Thread.sleep(3000,2);
        String expectedT ="http://qa2.vytrack.com/entity/Extend_Entity_VehicleContract";
        String actualT = driver.getCurrentUrl();
        Assert.assertEquals(actualT,expectedT);
        Thread.sleep(3000,2);
        System.out.println(" Sales Manager Test Passed !!!  :)");
    }


    //    ****************** TRUCK_DRIVER **********************

    @Test(priority = 3)
    public void LogInAs_Truck_Driver() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("user13");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        Thread.sleep(3000,2);
        driver.findElement(By.xpath("//span[text()='Vehicle Contracts']")).click();
        Thread.sleep(3000,2);
        String excpected ="You do not have permission to perform this action.";
        String actual =driver.findElement(By.xpath("//div[contains(text(),'You do not have permission to perform this action.')]")).getText();
        Assert.assertEquals(excpected,actual);
        System.out.println("Driver Contracts passed !! :)");

    }
    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}