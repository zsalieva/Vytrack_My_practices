package com.vytrack.test.components.login_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;

public class LoginTest {

    String dropdownSelector =  "[id^='user-menu']";

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
         public void testLogInPositive() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        WebElement userName = driver.findElement(By.id("user-menu"));
            //Verify  name    of  the store   manager is   displayed   on  top
           String userName1 =userName.getText();
       
            boolean isThere = userName1.isEmpty();
            System.out.println("User name is on top" +userName1 + isThere);
            Thread.sleep(3000, 2);
        //Dashboard
        String actualResult = "Dashboard";
        String excpectedResult = driver.getTitle();
        Assert.assertEquals(excpectedResult, actualResult);
        Thread.sleep(3000, 2);
            System.out.println("Dashboard Displayed");

        // LogOut
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'Logout\')]")).click();
        Thread.sleep(3000, 2);
            System.out.println("System logout");

    }

    //    ****************** SALES_MANAGER **********************
    @Test(priority = 2)
    public void LogInAs_Sales_Manager() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        WebElement userName = driver.findElement(By.id("user-menu"));
        Thread.sleep(3000, 2);
        //Verify  name  of  the Sales manager is   displayed   on  top
        String userName1 =userName.getText();

        boolean isThere = userName1.isEmpty();
        System.out.println("User name is on top" +userName1 + isThere);
        Thread.sleep(3000, 2);


        //Dashboard
        String actualResult = "Dashboard";
        String excpectedResult = driver.getTitle();
        Assert.assertEquals(excpectedResult, actualResult);
        Thread.sleep(3000, 2);
        System.out.println("Dashboard Displayed");


        // LogOut
        driver.findElement(By.id("user-menu")).click();
        driver.findElement(By.xpath("//a[contains(text(),\'Logout\')]")).click();
        Thread.sleep(3000, 2);
        System.out.println("System Logout");

    }
    //    ****************** TRUCK_DRIVER **********************
    @Test(priority = 3)
    public void LogInAs_Truck_Driver() throws Exception {

        // Login
        driver.findElement(By.id("prependedInput")).sendKeys("user13");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000, 2);

        //Dashboard
        String actualResult = "Dashboard";
        String excpectedResult = driver.getTitle();
        Assert.assertEquals(excpectedResult, actualResult);
        Thread.sleep(3000, 2);

        // Verify Different Name Displayed
        WebElement userName = driver.findElement(By.id("user-menu"));
        Thread.sleep(3000, 2);
        //Verify  name    of  the store   manager is   displayed   on  top
        String userName1 =userName.getText();

        boolean isThere = userName1.isEmpty();
        System.out.println("User name is on top" +userName1 + isThere);
        Thread.sleep(3000, 2);
        System.out.println("All 3 test Passed !!!");

    }

    //    ****************** NEGATIVE_LOG_IN **********************
    @Test (priority=4)
    public void LogIn_Negative() throws Exception{

        // Login
        String excpected = driver.getTitle();
        driver.findElement(By.id("prependedInput")).sendKeys("salesmanager104");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000, 2);

        //Verify  "invalid username os password"   displayed   on  top

        String actual = driver.getTitle();
        String excpected4 ="Invalid user name or password.";
        String actual4 =driver.findElement(By.xpath("//fieldset/div/div")).getText();
        Assert.assertEquals(actual4,excpected4);
        Assert.assertEquals(excpected,actual);
        System.out.println("Negative Login passed");
        Thread.sleep(3000, 2);


    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }


}
