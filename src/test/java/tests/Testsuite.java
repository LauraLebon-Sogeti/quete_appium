package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
 

public class Testsuite extends TestManager{

	
	/*@Test
	public void test1(){
		System.out.println("Hello");
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hello World!");
		
		System.out.println("Premier cas ok");
	}*/
	
	@Test
	public void test2(){
		System.out.println("Hello");
		
		driver.findElement(By.xpath("//android.widget.TextView[1]")).click();
		try {
			Thread.sleep(5000);
			System.out.println("tout est ok");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
