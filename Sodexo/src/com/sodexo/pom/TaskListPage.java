package com.sodexo.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
	@FindBy(xpath = "//div[text()='Add New']")
	private WebElement addNewBtn;
	
	@FindBy(xpath = "//div[text()='+ New Customer']")
	private WebElement newCutomerBtn;
	
	@FindBy(id="customerLightBox_content")
	private WebElement createNewCustomerPopup;
	
	@FindBy(xpath="//input[@id='customerLightBox_nameField']")
	private WebElement enterCustomerNameTextfield;
	
	@FindBy(xpath="//span[text()='Create Customer']")
	private WebElement createCustomerButton;
	
	public TaskListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getAddNewBtn() {
		return addNewBtn;
	}

	public WebElement getNewCutomerBtn() {
		return newCutomerBtn;
	}

	public WebElement getCreateNewCustomerPopup() {
		return createNewCustomerPopup;
	}

	public WebElement getEnterCustomerNameTextfield() {
		return enterCustomerNameTextfield;
	}

	public WebElement getCreateCustomerButton() {
		return createCustomerButton;
	}


	}
	
	


