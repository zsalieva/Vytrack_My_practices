package com.vytrack.utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumUtils {
    //@param expectedResult
    //@param actualResult
    //Verifies if 2 Strings are equal

    public static void verifyEquals(String expectedResult,String actualResult){

        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("failed");
            System.out.println("Expected result:"+expectedResult);
            System.out.println("Actual result"+actualResult);
        }
    }

    /**
     *  This method will put on pause execution
     * @param seconds
     */
    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void openPage(String page, WebDriver driver) {
        List<WebElement> listOfexamples = driver.findElements(By.tagName("a"));
        for (WebElement example : listOfexamples) {
            if (example.getText().contains(page)) {
                example.click();
            }

        }
    }

    public static void verifyIsDisplayed(WebElement element){
        if (element.isDisplayed()) {
            System.out.println("Passed");
            System.out.println(element.getText() + ": is not visible");
        }else{
            System.out.println("Failed");
            System.out.println(element.getText() + ": is not visible");

        }
    }
}
