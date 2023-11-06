package com.basic.JavaBasic;

import java.net.MalformedURLException; 
import java.net.URL;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2{
String url="https://www.lambdatest.com/selenium-playground/";
WebDriver driver=null;
@BeforeSuite
public void start() {
	String browser=System.getProperty("browser","chrome");
	if(browser.contains("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	else if(browser.contains("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	else {
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
}
@Test
public void ButtonTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(3000);
	WebElement window=driver.findElement(By.xpath("//a[contains(text(),'Window Popup Modal')]"));
	window.click();
	Thread.sleep(3000);
	WebElement twit=driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
	twit.click();
	Thread.sleep(3000);
	String parentWindowHandle = driver.getWindowHandle();
    for (String windowHandle : driver.getWindowHandles()) {
        if (!windowHandle.equals(parentWindowHandle)) {
            driver.switchTo().window(windowHandle);
            String pageTitle = driver.getTitle();
            System.out.println("Browser: " + driver.getClass().getSimpleName());
            System.out.println("Title of the new window: " + pageTitle);

        }
    }

}
@AfterSuite
public void close() {
	driver.quit();
}
}
