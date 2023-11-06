package com.basic.JavaBasic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollHandling extends BaseDrive {
    String url = "https://www.amazon.com/";

    @Test
    public void ScrollTest() {
        try {
            driver.manage().window().maximize();
            driver.get(url);

            // Wait for the element to be present
            WebElement exist = driver.findElement(By.xpath("//h2[contains(text(),'Exciting deals')]"));

            // Scroll to the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true)", exist);

            // Optionally, you can add a wait here for some time to see the scroll effect
            Thread.sleep(3000);
        } catch (Exception e) {
            // Handle any exceptions and print the error message
            e.printStackTrace();
        }
    }
}
