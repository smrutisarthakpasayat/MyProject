package com.sodexo.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.sodexo.pom.HomePage;
import com.sodexo.pom.LoginPage;

public class BaseClass {
public WebDriver driver;
public static FileLib f = new FileLib();
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String browser) throws IOException {
		switch(browser) {
		case "chrome": driver = new ChromeDriver();break;
		case "edge": driver = new EdgeDriver();break;
		case "firefox": driver = new FirefoxDriver();break;
		default: driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String url = f.getPropertyData("url");
		driver.get(url);
	}
	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.getPropertyData("un");
		String pwd = f.getPropertyData("pwd");
		LoginPage l = new LoginPage(driver);
		l.login(un, pwd);
	}
	
	@AfterMethod
	public void logout() {
		HomePage h = new HomePage(driver);
		h.setLogout();
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.manage().window().minimize();
		driver.quit();
		

}}
