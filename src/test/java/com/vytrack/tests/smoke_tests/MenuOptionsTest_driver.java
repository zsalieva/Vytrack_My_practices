package com.vytrack.tests.smoke_tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.PriorityQueue;


public class MenuOptionsTest_driver {
    WebDriver driver;


    @BeforeMethod
    public void beforeMethod()throws Exception{

        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        //1.Login	to	Vytrack	as driver
        driver.findElement(By.id("prependedInput")).sendKeys("user39");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        Thread.sleep(3000,2);
    }


    @Test (priority = 1)
    public void testMenuOptions()throws Exception{


        // 2. Navigate	to	Fleet	àVehicles,	verify	page	title	Car	-Entities	-System	-Car
        // -Entities	-System,	page	name	All	Cars

        String expectedT ="Car - Entities - System - Car - Entities - System";
        driver.findElement(By.xpath("//span[contains(text(),'Fleet')][1]")).click();
        Thread.sleep(3000,2);
        driver.findElement(By.xpath("//span[text()='Vehicles']")).click();
        Thread.sleep(3000,2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT,expectedT);
        Thread.sleep(3000,2);

    }

    @Test (priority = 2)
    public void CustomerTest()throws Exception {

        //3. Navigate to Customers à Accounts, verify page title Accounts - Customers, verify page name Accounts
        //1.Login	to	Vytrack	as driver

        String expectedT = "Accounts - Customers";
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


        //4.  Navigate to Customers à Contacts, verify page title Accounts - Customers, verify page name Contacts

        String expectedT = "Contacts - Customers";
        driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
        Thread.sleep(3000, 2);
        driver.findElement(By.xpath("//span[text()='Contacts']")).click();
        Thread.sleep(3000, 2);
        String actualT = driver.getTitle();
        Assert.assertEquals(actualT, expectedT);
        Thread.sleep(3000, 2);

    }

    @Test  (priority = 4)
    public void ActivitiesTest()throws Exception {


      // 5.Navigate to ActivitiesàCalendar Events, verify page title Calendar Events - Activities, page name Calendar Events

        String expectedT = "Calendar Events - Activities";
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