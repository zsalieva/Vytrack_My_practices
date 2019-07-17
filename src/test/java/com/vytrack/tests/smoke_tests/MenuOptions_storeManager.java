package com.vytrack.tests.smoke_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MenuOptions_storeManager {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");

        Thread.sleep(3000, 2);


 //   @Test(priority = 1)
   // public void testLogIn() throws Exception {
        String actualResult = "Dashboard";

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager59");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        String excpectedResult = driver.getTitle();


    }

    @Test (priority = 2)
    public void CustomerTest()throws Exception {

        //4. Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page name Accounts
        //1.Login	to	Vytrack	as driver

        String expectedT = "All - Accounts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')][1]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Accounts']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);
    }

    @Test  (priority = 3)
    public void ContactsTest()throws Exception {


        //5.  Navigate to Customers à Contacts, verify page title Accounts - Customers, verify page name Contacts

        String expectedT = "All - Contacts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);

    }
    @Test  (priority = 4)
    public void SalesTest()throws Exception {

        // 6.Navigate to Sales à Opportunities, verify page title Open Opportunities

        String expectedT = "Open Opportunities - Opportunities - Sales";
        driver.findElement(By.xpath("//span[contains(text(),'Sales')]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Opportunities']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);

    }

    @Test  (priority = 5)
    public void ActivitiesCallsTest()throws Exception {


        // 7.Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name Calendar Events

        String expectedT = "All - Calls - Activities";
        driver.findElement(By.xpath("//span[contains(text(),'Activities')]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Calls']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);

    }




    @Test  (priority = 6)
    public void ActivitiesTest()throws Exception {


        // 8.Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name Calendar Events

        String expectedT = "All - Calendar Events - Activities";
        driver.findElement(By.xpath("//span[contains(text(),'Activities')]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Calendar Events']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);

    }

        @AfterMethod
    public void afterMethod(){
        driver.close();
    }

}