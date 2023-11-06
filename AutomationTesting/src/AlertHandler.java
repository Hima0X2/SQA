package com.basic.JavaBasic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AlertHandler extends BaseDrive {
    String url = "https://demoqa.com/alerts";

    @Test
    public void AlertTest() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get(url);

        // Alert 1
        WebElement alert1 = driver.findElement(By.id("alertButton"));
        alert1.click();
        Thread.sleep(3000);
        Alert a1 = driver.switchTo().alert();
        a1.accept();

        // Alert 2
        WebElement alert2 = driver.findElement(By.id("timerAlertButton"));
        alert2.click();
        Thread.sleep(6000);
        Alert a2 = driver.switchTo().alert();
        a2.accept();

        // Alert 3
        WebElement alert3 = driver.findElement(By.id("confirmButton"));
        alert3.click();
        Thread.sleep(5000);
        Alert a3 = driver.switchTo().alert();
        Thread.sleep(3000);
        a3.dismiss();
        //a3.accept();
        
        // Alert 4
        WebElement alert4=driver.findElement(By.id("promtButton"));
    	alert4.click();
    	Alert a4 = driver.switchTo().alert();
    	a4.sendKeys("samanta");
    	Thread.sleep(3000);
    	a4.accept();
    	Thread.sleep(5000);
//    	a.dismiss();
    }
}
