package br.com.yaman.poc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Login {
	
	public static AndroidDriver driver;
	
	public void Login(String app) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app",app);
		capabilities.setCapability("appPackage", "br.com.ipiranga.kmv.homolog");
		capabilities.setCapability("appActivity", "br.com.ipiranga.kmv.ui.activities.MainActivity");
		capabilities.setCapability("newCommandTimeout", "3600");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),capabilities); 
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//driver.quit();
		
		//FAZER LOGIN
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/btn_skip")).click();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_cpf")).sendKeys("41398101818");
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_password")).sendKeys("123456");
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_signin")).click();
		Thread.sleep(500);

	}
}
