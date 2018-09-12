package br.com.yaman.poc;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.yaman.util.Cpf;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class Cadastro {

	@SuppressWarnings("rawtypes")
	private static AndroidDriver driver;

	public static void scrollAndClick(String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(1)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}

	public void Cadastro(String app) throws Exception {
		// TODO Auto-generated method stub
		
		Cpf cpf = new Cpf ();
	
		// Open Emulador
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app",app);
		capabilities.setCapability("appPackage", "br.com.ipiranga.kmv.homolog");
		capabilities.setCapability("appActivity", "br.com.ipiranga.kmv.ui.activities.MainActivity");
		capabilities.setCapability("newCommandTimeout", "3600");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);

		// btnPular
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/btn_skip")).click();
		Thread.sleep(100);

		// ---------------------------------------Cadastrar----------------------------------
		// btnCadastrar
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_signup")).click();
		Thread.sleep(100);

		// txtCpf
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_cpf")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_cpf")).sendKeys(cpf.geraCPF());
		Thread.sleep(100);

		// txtNascimento
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_birth")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_birth")).sendKeys("15101991");
		Thread.sleep(100);

		// txtprimeiro_nome
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_first_name")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_first_name")).sendKeys("Teste Automacao");
		Thread.sleep(100);

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_last_name")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_last_name")).sendKeys("Yaman");
		Thread.sleep(100);

		scrollAndClick("Repita o E-mail *");

		// campo_sexo
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/spinner_gender")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]"))
				.click();
		// campo email
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_email")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_email")).sendKeys("automacaoYaman@hotmail.com");
		Thread.sleep(100);

		scrollAndClick("Senha *");

		// campo confirma email
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_email_confirmation")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_email_confirmation"))
				.sendKeys("automacaoYaman@hotmail.com");
		Thread.sleep(100);

		// campo senha
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_password")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_password")).sendKeys("123456");
		Thread.sleep(100);

		// campo confirma a senha
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_password_confirmation")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_password_confirmation")).sendKeys("123456");
		Thread.sleep(100);

		scrollAndClick("Indicação de Amigo");

		// campo telefone
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_phone")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_phone")).sendKeys("11958096143");
		Thread.sleep(100);

		scrollAndClick("Estado *");

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/spinner_state")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/spinner_city")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
				.click();
		Thread.sleep(500);

		scrollAndClick("Bairro *");

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/spinner_neighborhood")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
				.click();
		Thread.sleep(500);

		scrollAndClick("Já li e aceito os termos da Política de Privacidade Ipiranga.");
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/spinner_favorite_station")).click();
		driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]"))
				.click();
		Thread.sleep(500);

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_complete_signup")).click();
		Thread.sleep(500);

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_1")).click();
		Thread.sleep(500);

		// segunda tela

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_postal_code")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_postal_code")).sendKeys("06433020");

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_number")).clear();
		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/edit_number")).sendKeys("300");

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_finish")).click();
		Thread.sleep(500);

		driver.findElement(By.id("br.com.ipiranga.kmv.homolog:id/button_1")).click();
		Thread.sleep(500);

		driver.quit();
	}

}
