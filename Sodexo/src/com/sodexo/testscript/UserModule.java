package com.sodexo.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sodexo.generic.BaseClass;
import com.sodexo.pom.HomePage;
import com.sodexo.pom.UserListPage;
@Listeners(com.sodexo.generic.ListenerImplemention.class)
public class UserModule extends BaseClass {
	
	@Test
	public void addAndDeleteUser() throws EncryptedDocumentException, IOException, InterruptedException {
	String firstName=f.getExcelData("addAndDeleteUser",1,0);
	String lastName=f.getExcelData("addAndDeleteUser",1,1);
	String email=f.getExcelData("addAndDeleteUser",1,2);
	String un=f.getExcelData("addAndDeleteUser",1,3);
	String password=f.getExcelData("addAndDeleteUser",1,4);
	String pwdCopy=f.getExcelData("addAndDeleteUser",1,5);
	HomePage h = new HomePage(driver);
	h.setUsers();
	UserListPage u = new UserListPage(driver);
	u.getAddUserBtn().click();
	WebElement popup = u.getUserPopup();
	boolean res = popup.isDisplayed();
	Assert.assertTrue(res, "The popup is not displayed");
	u.getFirstNameTbx().sendKeys(firstName);
	u.getLastNameTbx().sendKeys(lastName);
	u.getEmailTbx().sendKeys(email);
	u.getUsernameTbx().sendKeys(un);
	u.getPasswordTbx().sendKeys(password);
	u.getPasswordCopyTbx().sendKeys(pwdCopy);
	u.getCreateUserBtn().click();
	Thread.sleep(2000);
	u.getSearchTbx().sendKeys(firstName);
	WebElement createdUser = u.getCreatedUser();
	String userName = createdUser.getText();
	boolean res1 = createdUser.isDisplayed();
	Assert.assertTrue(res1, userName+" has not been created");
	createdUser.click();
	Thread.sleep(2000);
	boolean res2 = popup.isDisplayed();
	Assert.assertTrue(res2, "User popup has not been displayed");
	u.getDeleteUserBtn().click();
	driver.switchTo().alert().accept();
	Thread.sleep(2000);
	u.getSearchTbx().sendKeys(firstName);
	Thread.sleep(2000);
	boolean res3 = u.getNoUserMsg().isDisplayed();
	Assert.assertTrue(res3, userName+" has not been deleted");

}}
