package tests;

import java.net.MalformedURLException;
import java.net.URL;

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
		    //capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/llebon/downloads/KABOOM_v4.0.104_apkpure.com.apk");
		    capabilities.setCapability(MobileCapabilityType.APP, "C:/Users/llebon/downloads/Findrive_apkpure.com.apk");
		    
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
}
