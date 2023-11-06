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
import static org.lambdatest.Constants.*;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Test1{

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
@BeforeMethod
@Parameters(value = {"browser", "version", "platform"})
public void setUp(String browser, String version, String platform) throws Exception {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("browserName", browser);
    capabilities.setCapability("version", version);
    capabilities.setCapability("platform", platform);
    capabilities.setCapability("build", "lambdatestbuild");
    capabilities.setCapability("name", "Test01");
    capabilities.setCapability("console", true);
    capabilities.setCapability("network", true);
    capabilities.setCapability("visual", true);

    try {
        driver = new RemoteWebDriver(new URL("https://" + USERNAME + ":" + ACCESS_KEY + LAMBDA_URL), capabilities);
    } catch (MalformedURLException e) {
        throw new Exception("LAMBDA_URL is not valid");
    } catch (Exception e) {
        throw new Exception("Exception raised during the remotewebdrive object creation! " + e);
    }
}
@Test
public void ButtonTest() throws InterruptedException {
	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(3000);
	WebElement radio=driver.findElement(By.xpath("//a[contains(text(),'Radio Buttons Demo')]"));
	radio.click();
	Thread.sleep(3000);
	WebElement female=driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/div[1]/label[2]/input[1]"));
	female.click();
	Thread.sleep(3000);
	WebElement check=driver.findElement(By.xpath("//button[@id='buttoncheck']"));
	check.click();
	System.out.println();
	Thread.sleep(3000);
	WebElement messageElement = driver.findElement(By.className("radiobutton"));
    String message = messageElement.getText();
	 String expectedMessage = "Radio button 'Female' is checked";
     if (message.equals(expectedMessage)) {
         System.out.println("Validation successful. Message matches the expected message.");
     } else {
         System.out.println("Validation failed. Expected: '" + expectedMessage + "', Actual: '" + message + "'");
     }
}
@AfterSuite
public void close() {
	driver.close();
}
}
