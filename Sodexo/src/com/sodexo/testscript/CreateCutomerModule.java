package com.sodexo.testscript;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sodexo.generic.BaseClass;
import com.sodexo.pom.HomePage;
import com.sodexo.pom.LoginPage;
import com.sodexo.pom.TaskListPage;

@Listeners(com.sodexo.generic.ListenerImplemention.class)
public class CreateCutomerModule extends BaseClass {
	
	@Test
	public void createCustomer() throws IOException {
		String customerName = f.getExcelData("createCustomer", 1, 1);
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCutomerBtn().click();
		WebElement popup = t.getCreateNewCustomerPopup();
		boolean res = popup.isDisplayed();
		Assert.assertEquals(res, "The popup is not displayed");
		t.getEnterCustomerNameTextfield().sendKeys(customerName);
		t.getCreateCustomerButton().click();

}
}