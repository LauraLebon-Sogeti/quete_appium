package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class TestManager {
	
	static AppiumDriver<MobileElement> driver;
	DesiredCapabilities capabilities ;
	
	String folder_name;
	DateFormat df;
	
	@BeforeSuite
	public void setup() {
		try {
			capabilities = new DesiredCapabilities();
		    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"ANDROID");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Device");
		    //capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android Emulator");
		    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0.0");
		    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
		    //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
			capabilities.setCapability("appPackage", "io.appium.android.apis");
			capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		    
		}
		catch (Exception e) {
			
		}
	}
	
	@BeforeMethod
	public void testSetup() {
		
		URL url;
		try {
			url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
	@AfterSuite
	public void SuiteTeardown() {
		driver.quit();
	}
	
	// Actions disponibles pour tous les cas de test : 
	
	public void captureScreenShots() throws IOException {
		folder_name = "screenshot";
		File f=( (TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		df = new  SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(folder_name).mkdir();
		String file_name=df.format(new Date())+".png";
		FileUtils.copyFile(f, new File(folder_name + "/" + file_name));
		System.out.println("La capture d'écran a fonctionné.");
	}
}
